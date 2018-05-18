package ds.ltl.springcloud.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者
 * 
 * @author ltl
 * @date 2017年7月21日 下午6:20:26
 */

@SpringBootApplication
// 启用服务发现
@EnableDiscoveryClient
// 开启Feign功能
@EnableFeignClients
// 开启断路器功能(hystrix)
@EnableCircuitBreaker
// 启用hystrix监控服务，测试步骤：1.http://localhost:8030/hystrix.stream 可以查看Dashboard 2.在上面的输入框填入: http://想监控的服务:端口/hystrix.stream进行测试，注意：首先要先调用一下想监控的服务的API，否则将会显示一个空的图表.
@EnableHystrixDashboard
// 通过@EnableTurbine注解，激活对Turbine的支持
//@EnableTurbine
public class WebApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

    /**
     * 负载均衡（Ribbon）
     * @return
     */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
