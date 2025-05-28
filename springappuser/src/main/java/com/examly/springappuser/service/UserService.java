
package com.examly.springappuser.service;

import com.examly.springappuser.model.User;

public interface UserService {
    User createUser(User user);
    User loginUser(String email,String password);
}
