package mrghz.crmapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mrghz.crmapp.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public List<User> findByUserName(String userName);

}