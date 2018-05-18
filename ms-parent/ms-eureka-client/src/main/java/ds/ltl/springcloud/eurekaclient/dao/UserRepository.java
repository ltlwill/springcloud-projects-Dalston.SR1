package ds.ltl.springcloud.eurekaclient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ds.ltl.springcloud.eurekaclient.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
