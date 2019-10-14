/*/*********************************************************************
 *======================================================================
 * CHANGE HISTORY LOG
 *----------------------------------------------------------------------
 * MOD. NO.|  DATE        | NAME           | REASON		 | CHANGE REQ.
 *----------------------------------------------------------------------
 *         |2015年2月5日 | liubing        | Created       |
 * DESCRIPTION:
 ***********************************************************************/
/**
 * @Title: BaseException.java
 * @author liubing@buyforyou.cn
 * @date 2015年2月5日 下午2:07:57
 * @version V1.0
 */
package com.example.exception;

/**
 * @Description 异常基类 其它层异常需继承此基类
 * @Author liubing
 * @Date 2015年2月5日 下午2:07:57
 * @Copyright：北京邦孚力德商务服务有限公司
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = -6077014216304140329L;

    public String messageCode;
    
    

    public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(String messageCode, String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String messageCode, String message) {

        super(message);
        this.messageCode = messageCode;
    }

}
