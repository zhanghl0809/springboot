package com.example.service;


import com.example.entity.Mythread;
import com.example.exception.BizException;
import com.example.mapper.MythreadMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MythreadService {

    @Autowired
    private MythreadMapper mythreadMapper;


    private static List<String> appList = new ArrayList<>();

    private static Queue<Mythread> queue = new LinkedBlockingQueue<>();

    private final static int MAX_COUNT = 10;

    private static Object lock = new Object();

    @Transactional(rollbackFor = Exception.class)
    public void add(){

        for (int i = 0; i < 10; i++) {
            appList.add("苹果对象"+i);
        }

        try {

            Customer customer = new Customer();
            Thread t1 = new Thread(customer);
            t1.start();

            Producer producer = new Producer();
            Thread t2 = new Thread(producer);
            t2.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    /***
     * 消费者
     */
    private class Customer extends Thread {

        @Override
        public void run() {
            boolean k = true;
            while (k) {

                synchronized (lock) {

                    if (queue.isEmpty()) {
                        try {
                            System.err.println("篮子里面没有苹果了,我好饿啊，我等待....");
                            lock.wait(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Mythread m = queue.poll();
                        System.err.println("篮子里面有苹果了,我要吃了苹果："+m.getName()+".... 还剩下：" + queue.size() + "个苹果");
                        if("苹果对象8".equals(m.getName())){
                            try {
                                throw new BizException("异常了。。。。。。。。。。。。。。。。");
                            } catch (BizException e) {
                                e.printStackTrace();
                            }
                        }
                        mythreadMapper.insert(m);
                        lock.notifyAll();
                    }
                }
            }
            if(queue.isEmpty()){
                System.out.println("停止线程");
                k = false;
            }
        }
    }

    /***
     * 生产者
     */
    private class Producer extends Thread {

        @Override
        public void run() {
            Mythread m;
            for (String name : appList) {
                synchronized (lock) {
                    if (queue.size() >= MAX_COUNT) {
                        try {
                            System.err.println("篮子中苹果已经放满了，我等待.....");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        //生产苹果，放到篮子里
                        m = new Mythread();
                        m.setName(name);
                        queue.add(m);

                        System.err.println("我往篮子里面放了苹果："+m.getName());
                        lock.notifyAll();
                    }
                }
            }
            System.err.println("我要往篮子里面现在有" + queue.size() + "个苹果");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
