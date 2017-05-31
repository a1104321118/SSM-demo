package dao;

import model.User;

public interface UserDao {

    User selectByPrimaryKey(Integer id);
    
    User getUserByUsername(String username);
}