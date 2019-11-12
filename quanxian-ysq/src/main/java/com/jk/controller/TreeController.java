package com.jk.controller;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("toTree")
    public String toTree(){

       return "show";
    }


    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
       return treeService.queryTree(user.getId());
    }


    @RequestMapping("toTest")
    public String toTest(){

        return "test";
    }

    @RequestMapping("queryUserList")
    @ResponseBody
    public List<User> queryUserList(){

        return treeService.queryUserList();
    }
    @RequestMapping("deleteUser")
    @ResponseBody
    public void deleteUser(Integer id){

        treeService.deleteUser(id);
    }
    @RequestMapping("adduser")
    @ResponseBody
    public void adduser(User f){

        treeService.adduser(f);
    }

    @RequestMapping("queryUserById")
    @ResponseBody
    public User queryUserById(Integer id){

        return treeService.queryUserById(id);
    }

    @RequestMapping("toEditUserRole")
    public String toEditUserRole(Integer id, Model model){

        List<Role> roleList = treeService.queryUserRole(id);
        model.addAttribute("roles",roleList);
        return "userRole";
    }

    @RequestMapping("saveUserRole")
    @ResponseBody
    public String saveUserRole(int id,String rids){
        treeService.saveUserRole(id,rids);
        return "suc";
    }



}
