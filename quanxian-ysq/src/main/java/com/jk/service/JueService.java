package com.jk.service;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;

import java.util.List;

public interface JueService {


    List<Role> queryRoleList();

    void deleteRole(Integer rid);

    void addRole(Role r);

    Role queryRoleById(Integer rid);

    List<Tree> queryRoleMenu(int i, int rid);


    void saveRoleMenu(int rid, String menuIds);

    User queryUserName(String name);
}
