package ds.ltl.springcloud.web.service;

/**
 * RestTemplate实现微服务访问的业务接口
 * 
 * @author ltl
 * @date 2017年7月24日 下午3:38:37
 */
public interface RestTemplateService {

	String getUserByName(String name);

	String getUserById(String id);
}
