package mrghz.crmapp.dao;

import mrghz.crmapp.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
}
