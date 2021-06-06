// package com.example.demo;
//
//
// import com.alibaba.fastjson.JSONArray;
// import com.alibaba.fastjson.JSONObject;
//
// import java.util.HashMap;
//
// /**
//  * 百度OCR身份证识别
//  */
// public class BiduORCTest {
//
//
//
//     /**
//      * 通过图片url获取解析的文字
//      * @param imgUrl
//      * @return
//      */
//     public static String getImgContent(String imgUrl){
//         String text = "";
//         try {
//             //百度AppID
//             String APP_ID = "BAIDU_APP_ID";
//             //百度API Key
//             String API_KEY = "BAIDU_API_KEY";
//             //百度Secret Key
//             String SECRET_KEY = "BAIDU_SECRET_KEY";
//             AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
//             // 可选：设置网络连接参数
//             client.setConnectionTimeoutInMillis(2000);
//             client.setSocketTimeoutInMillis(60000);
//
//             JSONObject resp = client.basicGeneralUrl(imgUrl, new HashMap<String, String>());
//
//             if(resp==null || resp.getJSONArray("words_result")==null){
//                 return null;
//             }
//             JSONArray jsonArray = resp.getJSONArray("words_result");
//             if(jsonArray!=null&&jsonArray.length()>0){
//                 for(int i=0;i<jsonArray.length();i++){
//                     JSONObject item = jsonArray.getJSONObject(i);
//                     if(StringUtils.isBlank(item.getString("words"))){
//                         continue;
//                     }
//                     String words = item.getString("words");
//                     text += words;
//                 }
//             }
//         } catch (Exception e) {
//             logger.info("使用百度OCR接口发生异常【{}】",e);
//             return null;
//         }
//         return text;
//     }
//
// }
