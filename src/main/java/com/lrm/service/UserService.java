package com.lrm.service;

import com.lrm.po.User;

/**
 * Created by limi on 2017/10/15.
 */
public interface UserService {

    User checkUser(String username, String password);
    User checkUserIsNew(String username);
    void save(User user);
	void update(String username,String password,Long id);
}