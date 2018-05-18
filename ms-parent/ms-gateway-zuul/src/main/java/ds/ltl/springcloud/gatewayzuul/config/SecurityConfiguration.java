//package ds.ltl.springcloud.gatewayzuul.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Spring security配置
// * 
// * @author ltl
// * @date 2017年9月1日 下午5:13:51
// */
//@Configuration
////@EnableOAuth2Sso
//// 实现基于OAuth2的单点登录
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//
//		http.antMatcher("/**")
//				// 所有请求都得经过认证和授权
//				.authorizeRequests().anyRequest().authenticated().and()
//				.authorizeRequests().antMatchers("/", "/anno").permitAll()
//				.and().csrf().disable() // 这里之所以要禁用csrf，是为了方便,否则，退出链接必须要发送一个post请求，请求还得带csrf token,那样还得写一个界面，发送post请求
//										
//				.logout().logoutUrl("/logout").permitAll() // 退出登录URL
//				.logoutSuccessUrl("http://baidu.com/"); // 退出登录成功后的跳转URL
//	}
//
//}
