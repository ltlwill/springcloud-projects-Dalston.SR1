package ds.ltl.springcloud.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 远程配置测试控制器
 * @author ltl
 * @date 2017年7月26日 上午10:40:19
 */
@RestController
// @RefreshScope注解不能少，配置服务器中修改了配置信息，即使调用/refresh（curl，Linux和Windows都有curl工具，当然也可以借助其他工具，例如Postman等，执行：curl  -X POST http://localhost:8740/refresh），配置也不会刷新
@RefreshScope
@RequestMapping("/remote-config")
public class RemoteConfigController {

	@Value("${customProps.remark}")
	private String remark;  // 获取配置服务器中配置的属性
	
	/**
	 * 浏览器通过：http://localhost:8740/remote-config/getProperty
	 * @return
	 */
//	@RequestMapping("/getProperty")
	@GetMapping("/getProperty")
	public String getCustomProperty(){
		return this.remark;
	}
}
