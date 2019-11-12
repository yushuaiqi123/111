package com.jk.service;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;

import java.util.List;

public interface TreeService {

    List<Tree> queryTree(Integer id);

    List<User> queryUserList();

    void deleteUser(Integer id);

    void adduser(User f);

    User queryUserById(Integer id);

    List<Role> queryUserRole(Integer id);

    void saveUserRole(int id, String rids);


}
