package com.jk.dao;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JueDao {


    List<Role> queryRoleList();


    void deleteRole(Integer rid);

    void addRole(Role r);

    void updateRole(Role r);

    Role queryRoleById(Integer rid);

    List<Tree> queryMenuTree(@Param("pid")int pid);

    List<Integer> queryMenuIdByRid(@Param("rid")int rid);


    void deleteMenuByRid(@Param("rid") int rid);

    void saveRoleMenu(@Param("rid")int rid,@Param("mids") String[] split);

    User queryUserName(String name);
}
