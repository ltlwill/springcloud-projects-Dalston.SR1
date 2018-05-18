package ds.ltl.springcloud.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka服务注册中心
 * 
 * @author ltl
 * @date 2017年7月19日 上午11:06:15
 */

@SpringBootApplication
// 启动eureka服务注册中心
@EnableEurekaServer
public class EurekaServerApplication {
	
	public static void main(String[] args){
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
