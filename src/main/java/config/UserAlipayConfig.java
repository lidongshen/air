package config;

/**
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class UserAlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2016101600702157";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC92sWsPvzv8NkK4heBp7xaCtFvlO8USRTC2h0Dxl9QJTuBDC+dyhYy+DEZGrso94+SQjQl+R7jOM9W2CibwZ1k3THpciUm8I+w2BjY669qVEjbzWEWu5hxAIwPw0WDWzQZNeIPf7h9P+F4K+pJqfP1WxifvzmseykZcml0PsQUEBoRJ3ic3dxIXFYXEsiL0OA186V3+zASxcAy4HXjNsJWndZ9c5qzSTetkdLudpSAImtYOTzZyEwTaH1gJHoCj+3SSwOaOu9SPghoL49ZlM170vX3Wggi4jrhmIoHi8qy6k6QH2fHuePvfsxkv+52ipyz4zC/idS6tljWiBqMKAsXAgMBAAECggEBAIV3Xq+QOFCViH9WIiBLwuWp5UID+W7RUX8Jxov40NiO1B4Maw0KHEEIqbt0R06teojfcbmgQE6MiXYLz8BvhC58MbJjRCrzwpAX2p/kUBT326Bp6W8JwkjukYgjRqLpYt62Oo2axB+I4QCSHspaZ958g/sJe4n9qw7wl6HY3g8bbKirCdK+VnerO8kjCm1XmNq34RlYJ2LcwCCpaXUvZAgwSt1UoEbc8CEHYk464A2crR/okkxDIubm25AE1Ac2Dv3ehNv9m6csZdE3gSOE96ume/WIKfu/vsrYadlEq4lNUpuJK5qgKM61qybElqsCM39TmqsxpldKedEZdfNeKoECgYEA4dtCAzAk1YSdWyiC0PQ6jtFfmnjW59r3/xAJTSPq/vfQ0TL38yECoKRi0d9kHERozghxYws3l7S3+/1mUN07UAhgtxD9jr5Et5MRWHiU4FaW0bAMwtJLpTLw1ZahOuHQSGxl4yIi3WTMyuPaK6iM9STTy10NZ/esaXnTGDzzGr8CgYEA1zFz6f2XafLPuC9V7/G5lBpLbm3o2HLQLsT+T0uJraKzIe5s6OWM1HrlGyphpgQtkzIOEq3GGKSDmFRLL1jABdRUs8jWS2/KH9Ckq0hFyZSNq01HrCfFgxY7qPaMNSVKDhd6tkdf+YYJTLEhKc1z3HLLJp/73FThvn1FtMIMXakCgYBTA1vIADIJqKyNjN5IHvxG8f3JsRCMN5dfUG2axNDi1gMSYUFxQ3jLwp/vs8P//8TltYS3eq/8OphFLmYk4quiRvIFV2FazeRD9PIzKl7N9gWJHMQT92eGWKrcVnj8Q3NiqzTnvuxBo4MCL61IzrLAh8Cwxore49GjEvvbtMtF0QKBgE53eNXUo1Z9tGJr2EEy+kFXyTOOHj52txSmvjh5yc0nq3vu7YWK1mxQF6RtMsgPc/LdaKZE+RvZOSbdbcDo8rPtdalMzV8adzBcqv7NzqyvX20cM8tBgVLIU57Lr9pdK4Cx7Qv0QLnCtzdgyz/r65hxv0PpSDRSOzJziWxc6ZdpAoGBALUbsDHg0szcMiRNCKtNDGkKWTZJekTHty15My5OkMZSOpuERL/BjgKoEcKS29UErA+qqnyi7ieRBb3tZkR3ralqKIg1XKbyrluO97trnQn7vPFRBzR3QqdJMBIeczwsVXhWohhy2B0b9w0JunSSxzR3ibgM72iKGKnoyrae9Ays";
    		
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvBNLjCwv+qJrFLyNMTkTTZJ89IJ8TEOKBI4UdLP2w1TTRwpVzWpszzt5TxzgFD3xkpBCSlSuVaLRYOppvdWi2z2Jh1C4ld5OtFL/nDiFoQNx+CMXdnokOM/RB6AfRC4HwxmWN5GvKI1t287Ml/MiJsA//WiNlBJfSxKbC7q11H+N60tVjI499QN9J/Z5104+IzwkajgZf4S+haT7T5bUAKI1xy9nRYV+BmDuhc8PCAlTS3OKMYAsQWtb+RZymGVo73RWu9rUCqUzP4le65N2ZS2Ytx0RB0QtnZKUJkZm6Pq/wnjRR8dtE4Mk2IX29tdisbYedrA7qT02dCFXfAx77wIDAQAB";
	
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://6d70221a.ngrok.io/airsys/user/alipay/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://6d70221a.ngrok.io/airsys/user/alipay/return";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
//	public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	// 支付宝网关
	//public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /*//** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
   /* public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}

