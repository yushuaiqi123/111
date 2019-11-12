package com.jk.service;

import com.jk.dao.TreeDao;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeDao treeDao;


    @Override
    public List<Tree> queryTree(Integer id) {
        int pid = -1;
        List<Tree> list = findNodes(pid,id);
        return list;
    }

    private List<Tree> findNodes(int pid,Integer id) {
        List<Tree> list = treeDao.queryUserMenuTree(pid,id);
        for (Tree tree : list){
            Integer id1 = tree.getId();
            List<Tree> nodes = findNodes(id1,id);
            tree.setChildren(nodes);
        }
        return list;
    }

    @Override
    public List<User> queryUserList() {

            return treeDao.queryUserList();
    }

    @Override
    public void deleteUser(Integer id) {
        treeDao.deleteUser(id);
    }

    @Override
    public void adduser(User f) {
        if(f.getId()==null){
            treeDao.adduser(f);
        }else{
            treeDao.updateUser(f);
        }
    }

    @Override
    public User queryUserById(Integer id) {

        return treeDao.queryUserById(id);
    }

    @Override
    public List<Role> queryUserRole(Integer id) {
        List<Role> roles1 = treeDao.queryRoleAll();
        List<Integer> roles2 = treeDao.queryUserRole(id);
       for (int i = 0; i < roles1.size(); i++){
            for (int j = 0; j < roles2.size(); j++) {
                System.out.println(roles1.get(i).getRid()+"-"+roles2.get(j));
                if(roles1.get(i).getRid() == roles2.get(j)){
                    roles1.get(i).setStatus("checked");
                }
            }
        }

        return roles1;
    }

    @Override
    public void saveUserRole(int id, String rids) {
        //1.删除中间表中该用户的所有数据
        treeDao.deleteUserRoleByUid(id);
        //2.添加给该用户设置的角色
        String[] ridArr = rids.split(",");
        treeDao.saveUserRole(id,ridArr);
    }





}
