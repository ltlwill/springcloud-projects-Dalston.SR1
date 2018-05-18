package ds.ltl.springcloud.gatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul服务网关
 * @author ltl
 * @date 2017年8月8日 下午5:16:09
 */
@SpringBootApplication
@EnableZuulProxy // 支持网关路由
public class GatewayZuulApplication 
{
    public static void main( String[] args )
    {
        SpringApplication.run(GatewayZuulApplication.class, args);
    }
}
