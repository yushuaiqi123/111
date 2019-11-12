package com.jk.dao;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreeDao {


    List<Tree> findNodes(@Param("pid") int pid);


    List<User> queryUserList();


    void deleteUser(Integer id);

    void adduser(User f);

    User queryUserById(Integer id);


    void updateUser(User f);

    List<Role> queryRoleAll();

    List<Integer> queryUserRole(Integer id);

    void deleteUserRoleByUid(int id);

    void saveUserRole(@Param("id") int id,@Param("rids") String[] ridArr);

    List<Tree> queryUserMenuTree(@Param("pid")int pid,@Param("id") Integer id);


}
