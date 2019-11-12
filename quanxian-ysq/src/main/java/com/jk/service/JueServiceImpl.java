package com.jk.service;

import com.jk.dao.JueDao;
import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JueServiceImpl implements JueService {

    @Autowired
    private JueDao jueDao;


    @Override
    public List<Role> queryRoleList() {
        return jueDao.queryRoleList();
    }

    @Override
    public void deleteRole(Integer rid) {
        jueDao.deleteRole(rid);
    }

    @Override
    public void addRole(Role r) {
        if(r.getRid()==null){
                jueDao.addRole(r);
            }else{
                jueDao.updateRole(r);
            }

    }

    @Override
    public Role queryRoleById(Integer rid) {

        return jueDao.queryRoleById(rid);
    }

    @Override
    public List<Tree> queryRoleMenu(int pid, int rid) {
        List<Tree> menus1 = jueDao.queryMenuTree(pid);
        List<Integer> roleMenus = jueDao.queryMenuIdByRid(rid);
        if(menus1 != null && menus1.size() >0){
            for (int i = 0; i < menus1.size(); i++) {
                List<Tree> menus2 = queryRoleMenu(menus1.get(i).getId(),rid);
                menus1.get(i).setChildren(menus2);
                for (int j = 0; j < roleMenus.size(); j++) {
                    if(menus2.size() <=0 && menus1.get(i).getId() == roleMenus.get(j)){
                        menus1.get(i).setChecked(true);
                    }
                }
            }
        }
        return menus1;
    }

    @Override
    public void saveRoleMenu(int rid, String menuIds) {
        //1.删除中间表数据
        jueDao.deleteMenuByRid(rid);
		//2.重新添加中间表
        jueDao.saveRoleMenu(rid,menuIds.split(","));
    }

    @Override
    public User queryUserName(String name) {

        return jueDao.queryUserName(name);
    }


}
