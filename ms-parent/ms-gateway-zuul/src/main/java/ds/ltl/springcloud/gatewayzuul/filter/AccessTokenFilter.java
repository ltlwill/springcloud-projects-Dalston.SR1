package ds.ltl.springcloud.gatewayzuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 自定义Zuul服务网关过滤器
 * 
 * @author ltl
 * @date 2018年3月2日 下午2:46:35
 */
public class AccessTokenFilter extends ZuulFilter {
	
	private final Logger logger = LoggerFactory.getLogger(AccessTokenFilter.class);
	
	private final static String ACCESS_TOKEN_PARAM_NAME = "access_token";

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		logger.info("AccessTokenFilter", request.getMethod(), request.getRequestURL().toString());
		String token = request.getParameter(ACCESS_TOKEN_PARAM_NAME);
		if(StringUtils.isNotBlank(token)){
			context.setSendZuulResponse(true);  // 继续对请求进行路由
			context.setResponseStatusCode(HttpStatus.OK.value());
			context.set("request_result",true);
		}else{
			context.setSendZuulResponse(false); // 不对请求进行路由
			context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
			context.setResponseBody("the access token is invalid");
			context.set("request_result", false);
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true; // true 是否执行此过滤器，true:执行，fasle:不执行
	}

	@Override
	public int filterOrder() {
		return 0; // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
	}

	@Override
	public String filterType() {
		return "pre"; // 定义filter的类型，有pre、route、post、error四种
	}

}
