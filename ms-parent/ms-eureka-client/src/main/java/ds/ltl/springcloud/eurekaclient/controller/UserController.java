package ds.ltl.springcloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ds.ltl.springcloud.eurekaclient.entity.User;
import ds.ltl.springcloud.eurekaclient.service.UserService;

/**
 * 业务层
 * 
 * @author ltl
 * @date 2017年7月19日 下午2:34:46
 */

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

	@Autowired
	private Environment env;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/{name}")
	public User getUser(@PathVariable("name") String name) {
//		return new User(env.getProperty("spring.application.name") + ":"
//				+ env.getProperty("server.port"), name);
		User user = new User();
		user.setName(name);
		return user;
	}
	
	@RequestMapping("/getUserById")
	public User getUserById(@RequestParam("id") String id){
//		return new User(id,env.getProperty("spring.application.name") + ":"
//				+ env.getProperty("server.port"));
		return userService.getUserById(StringUtils.isEmpty(id) ? null : Long.parseLong(id));
				
	}

}
