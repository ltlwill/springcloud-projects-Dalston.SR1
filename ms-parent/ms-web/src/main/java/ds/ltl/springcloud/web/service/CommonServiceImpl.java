package ds.ltl.springcloud.web.service;

import org.springframework.stereotype.Service;

/**
 * 公共业务类
 * 
 * @author ltl
 * @date 2017年7月24日 下午3:43:26
 */
@Service
public class CommonServiceImpl {

	protected final String SCHEMA = "http://";

	protected String createRestTemplateUrl(String serviceName, String url) {
		return SCHEMA + serviceName + (url.charAt(0) == '/' ? url : "/" + url);
	}
}
