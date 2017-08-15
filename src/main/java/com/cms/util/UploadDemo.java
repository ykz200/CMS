package com.cms.util;

import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.util.Auth;

import java.io.IOException;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;

public class UploadDemo {

    /**
     * 基本配置
     */
    //设置好账号的ACCESS_KEY和SECRET_KEY
    String ACCESS_KEY = "LMWTHYhWs-9S1NrRQSBwjMr1mMQDVUQXDFTSQFyy";
    String SECRET_KEY = "oZuDTC_VfGjkEnLBTN5gLlVGernI3zDvHCdtD-jc";
    //要上传的空间--目前用的测试空间--上线要修改
    String bucketname = "solo2017";


    /**指定保存到七牛的文件名--同名上传会报错  {"error":"file exists"}*/
    /**
     * {"hash":"FrQF5eX_kNsNKwgGNeJ4TbBA0Xzr","key":"aa1.jpg"} 正常返回 key为七牛空间地址 http://imagetest.i.haierzhongyou.com/aa1.jpg
     */
    //上传到七牛后保存的文件名---不指定的话，七牛随机产生-无后缀
//  String key = "hi.jpg";
    //上传文件的路径
    String FilePath = "/Users/kzyuan/Desktop/WechatIMG5.jpeg";

    //密钥配置
    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //构造一个带指定Zone对象的配置类
    Configuration cfg = new Configuration(Zone.zone0());
    //...生成上传凭证，然后准备上传
    UploadManager uploadManager = new UploadManager(cfg);


    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public void upload() throws IOException {
        try {
            //调用put方法上传

            Response res = uploadManager.put(FilePath, null, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());

        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    public static void main(String args[]) throws IOException {
        new UploadDemo().upload();
    }

}