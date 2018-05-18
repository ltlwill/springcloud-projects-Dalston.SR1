package ds.ltl.springcloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * spring cloud 微服务分布式配置服务中心
 * 通过@EnableConfigServer注解激活配置服务.
 * 说明：
 * 在application.yml中有个git.uri的配置，目前配置的是https://github.com/ltlwill/springcloud-study/
 * 获取git上的资源信息遵循如下规则：
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 *
 * 例如本例：在git仓库config-repo目录下创建 ms-web项目中配置的spring.application.name即eureka-consumer.yml，可使用以下路径来访问：
 * http://localhost:8770/eureka-consumer.yml
 * 
 * @author ltl
 * @date 2017年7月25日 下午5:14:53
 */
@SpringBootApplication
// 开启配置服务
@EnableConfigServer
// 开启服务发现（配置服务注册到服务注册中心，即：联合eureka服务注册中心）
@EnableDiscoveryClient
public class ConfigServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
