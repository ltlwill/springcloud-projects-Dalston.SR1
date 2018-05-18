package ds.ltl.springcloud.eurekaclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ds.ltl.springcloud.eurekaclient.dao.UserRepository;
import ds.ltl.springcloud.eurekaclient.entity.User;

/**
 * User业务接口实现类
 * 
 * @author ltl
 * @date 2018年3月1日 下午4:22:30
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void edit(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.delete(id);
	}

}
