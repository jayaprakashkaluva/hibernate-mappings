package com.jp.userservice.manager;

import com.jp.userservice.dao.UserDao;
import com.jp.userservice.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager {
    private final UserDao userDao;
    public User saveUser(final User user) {
   return  userDao.save(user);
    }
}
