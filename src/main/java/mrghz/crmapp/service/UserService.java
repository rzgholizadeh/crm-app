package mrghz.crmapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import mrghz.crmapp.entity.User;
import mrghz.crmapp.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
