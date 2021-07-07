package com.zhangzixiang.bridge.util;


import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class COSClientUtil {

    private static String secretId; //初始化用户身份信息（secretId
    private static String secretKey ;//初始化用户身份信息 secretKey

    @Value("${secretId}")
    public void setSecretId(String secretId){
        COSClientUtil.secretId = secretId;
    }
    public static String getSecretId() {
        return secretId;
    }

    @Value("${secretKey}")
    public void setSecretKey(String secretKey){
        COSClientUtil.secretKey = secretKey;
    }
    public static String getSecretKey() {
        return secretKey;
    }

    private static class COSClientUtil1
    {
        public final static COSClient instance =getInstance(secretId,secretKey);
        private static COSClient getInstance(String secretId, String secretKey) {

            // 1 初始化用户身份信息（secretId, secretKey）。
            COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
            // 2 设置 bucket 的地域, COS 地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
            // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
            Region region = new Region("ap-nanjing");
            ClientConfig clientConfig = new ClientConfig(region);
            // 这里建议设置使用 https 协议
            clientConfig.setHttpProtocol(HttpProtocol.https);
            // 3 生成 cos 客户端。
            COSClient cosClient = new COSClient(cred, clientConfig);
            return cosClient;
        }
    }


    public static COSClient getCOSClient()
    {
        return COSClientUtil1.instance;
    }

}
