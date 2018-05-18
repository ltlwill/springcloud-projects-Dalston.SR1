package ds.ltl.springcloud.eurekaclient.service;

import java.util.List;

import ds.ltl.springcloud.eurekaclient.entity.User;

/**
 * User 业务接口
 * 
 * @author ltl
 * @date 2018年3月1日 下午4:22:16
 */
public interface UserService {
	
	List<User> getUserList();
	
	User getUserById(Long id);
	
	void save(User user);
	
	void edit(User user);
	
	void delete(Long id);

}
