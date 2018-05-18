package ds.ltl.springcloud.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * eureka客户端（即服务提供者，注册到服务注册中心）
 * 
 * @author ltl
 * @date 2017年7月19日 上午11:54:04
 */

@SpringBootApplication
// 启用客户端（原生方式）
@EnableEurekaClient
// 启用客户端（spring 封装，推荐）
@EnableDiscoveryClient
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
