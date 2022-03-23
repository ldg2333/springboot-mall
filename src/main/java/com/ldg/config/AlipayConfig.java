package com.ldg.config;

import com.ldg.utils.MyFinal;

public class AlipayConfig{

    /** [沙箱环境]应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号 **/
    public static String APP_ID = "2021000118696922";

    /** [沙箱环境]商户私钥，您的PKCS8格式RSA2私钥 **/
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCjE4b9WCV8rLjCSQuuYqB7LDoNBJHoWNxYlB57tlFB/Ylzr/hGOA2k5/AUJj/L3Ygg5ofhdzdif0vOa70l/RzyfIAEVx/KSoB3WyE+zuk6mDRTzsYzk/EwT5UabePvZg+7teucoxHmaH3/pzL7QskPxX1jffW6RMMyXSO9aETxZuh75MRkVGPvCmFE1Y6Gi4KPeMjs481FM7JsjSTzfYgDDAfF3dw5suNMij7XwzUgCxBGB9FSEwS+RIDjen88H8fxCFYYsmHwWd11GWyyCWSC9CDTte1LkSK6wBvnCk63Qezk8oZnVhB0o81erg4sV298KRNcGY/ZzoAw39KTvig9AgMBAAECggEBAIauAOVIoCUYTLqAMzqBT8KKIyNPK+V1Rf2NzqMjTnaumo9FvEjZ0ELqHre1YyjOO7fYTE5j9ATP1t6S0jMGmJqXQe7TuXiLERAB3jIOFkaDH2w7sCs2upHIl/6s1PuJEeNX+k9xyb29fJngD1W9sWnqE4VQqNl+Iqt8iqDJ9W5b17Q1tTvkwO/Pc1aT11ich0RotJmTMyGefVZchRVioSmNe4jcstiz2i85WOBzLPTi9VWTSQwxVpQq3UmGpN6Cv2NdET6vaXW3S2HS/RwgO73GNji+dsYKed9O1eXy8O3E/8N3xKsnuFYdRn2rr1viiGOHs/978Ro1ZYGL1vunD0ECgYEA6M/ulcPYw40I8B7ikG8sQruHY49SGKTX/L5Py10p89HYk/gRilGcD8MTQuiX9UjJl9Ab1uaFnul6On2lx09wA8SgG35SwpZZscXU+9ACPxNuRE0Cfkikz+pz9Z89uyzUHylrO8qEKRJqQ9FM+E3sluGl24H2nh+ZMF5QKFkEsLECgYEAs1GFduBYOYy8ywdBuGVKj9GFfFdtFYzXFiZxeZINVsBXIizum4r3OO3dxYACVbJpO50zJPn+MLG/7vrbiD9de4rQ/a4DZA211QBNFlqqFChdB3aj2LXecSRhXwK3b0sAtCgFzaRyfzOLJaK6i2kx2Jk5wxKYqBMICOxWQJKt800CgYEA35nVrEHNjwOF8hm3wMEF4ZH7FsQwNTsdtsGSId/4yxRgzr0TG6YGHZ1egoSibhLai9R06JG/BEF6A3NqJWNGUlgm7kEFe56rxvIa/T9q6OngnfjYzDE5Gfg0J1QqFfuYP9WoCGUZSdlF9pyvMEynTsKqaYkJNBVlK+9pTVcyCgECgYAIJfIsnrEjnFOP3jqMSH4E3v5z0f0w939mkESjw5E7me3brbMB+mSVf6mOKezxO/QwM0p5qap1R/5yu49yN37l+D7a6CdbSowyq5rVIzWLSPJBPpDfbhQ3i/GowZTYR842YYMx/wD86rit8yEK6LLNJtlLFfM93++DiEm7EW86GQKBgQCxDVjI4evyQYbE2sS2v7+pc+444G48FPaGIFPzQb3/zvf+Su35b+0E/uxvZjDCxds9/t3Jwk+xDrnNVzbvyurS8nvJOWYSvCCvYOLND20ne08a8E96yJYfhwe+1NICAgL/dPFdwmdNh1rH/StsS0bRXoYt3eb16m4502v4hqHk+A==";

    /** [沙箱环境]沙箱支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。**/
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoxOG/VglfKy4wkkLrmKgeyw6DQSR6FjcWJQee7ZRQf2Jc6/4RjgNpOfwFCY/y92IIOaH4Xc3Yn9Lzmu9Jf0c8nyABFcfykqAd1shPs7pOpg0U87GM5PxME+VGm3j72YPu7XrnKMR5mh9/6cy+0LJD8V9Y331ukTDMl0jvWhE8Wboe+TEZFRj7wphRNWOhouCj3jI7OPNRTOybI0k832IAwwHxd3cObLjTIo+18M1IAsQRgfRUhMEvkSA43p/PB/H8QhWGLJh8FnddRlssglkgvQg07XtS5EiusAb5wpOt0Hs5PKGZ1YQdKPNXq4OLFdvfCkTXBmP2c6AMN/Sk74oPQIDAQAB";

    /** [沙箱环境]支付宝公钥 **/
    public static String ZHIFUBAO_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1seh+YdDfqnDp9Ok+SxONxkk4gsGmS6KfHPGcdpNjvcS+c4QrLGzdSZqd3Qmpe5voZqUVQaBxgwZa+r2Ry5oY08mVxRLwRrkLfR9V6ufXRPFHnfa+RjekpBP97iyAwi9TxDpTEY1KvX/l+U6ZshW6zjJyDDlBFEsDN1Si3ZdDpueAuCpDV11hA6DUUBsfAH8kuESAAyIHR9J66TmjZckrDBzf26RBia+0Qh6qGmOpCSY1dPAEm69lWIQKg7zsjWiXIhGu+Z8BD0ddk4F09haC6n5HxAveCDxVjb2YFYUM80lKhAuRwNjNRiYCjvNu+SNJSfr/0KLzCaYIP+tywGk3wIDAQAB";

    /** [沙箱环境]服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 **/
    public static String notify_url = "http://"+ MyFinal.DOMAIN +"/alipay/notifyUrl";

    /** [沙箱环境]页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 **/
    public static String return_url = "http://"+ MyFinal.DOMAIN +"/alipay/success";

    /** [沙箱环境] **/
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    /** [编码] **/
    public static String CHARSET = "UTF-8";

    /** [返回格式] **/
    public static String FORMAT = "json";

    /** [RSA2] **/
    public static String SIGNTYPE = "RSA2";

}
