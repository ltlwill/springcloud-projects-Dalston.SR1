package ds.ltl.springcloud.gatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ds.ltl.springcloud.gatewayzuul.filter.AccessTokenFilter;

/**
 * 过滤器配置
 * 
 * @author ltl
 * @date 2018年3月2日 下午4:28:35
 */
@Configuration
public class FilterConfiguration {

	/**
	 * 注册一个自定义zuul过来传奇
	 * 
	 * @return
	 */
	@Bean
	public AccessTokenFilter accessTokenFilter() {
		return new AccessTokenFilter();
	}
}
