package com.jk.controller;

import com.jk.model.Role;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.JueService;
import com.jk.util.CheckImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class JueController{

    @Autowired
    private JueService jueService;


    @RequestMapping("toDengLu")
    public String toLogin(){

        return "login";
    }


    @RequestMapping("toJue")
    public String toTree(){

        return "jue";
    }

    @RequestMapping("queryRoleList")
    @ResponseBody
    public List<Role> queryRoleList(){

        return jueService.queryRoleList();
    }

    @RequestMapping("deleteRole")
    @ResponseBody
    public void deleteRole(Integer rid){

        jueService.deleteRole(rid);
    }

    @RequestMapping("addRole")
    @ResponseBody
    public void addRole(Role r){

        jueService.addRole(r);
    }

    @RequestMapping("queryRoleById")
    @ResponseBody
    public Role queryRoleById(Integer rid){

        return jueService.queryRoleById(rid);
    }

    @RequestMapping("toEditRoleMenu")
    public String toEditRoleMenu(int rid , Model model){
        model.addAttribute("rid",rid);
        return "rolemenu";
    }

    @RequestMapping("queryRoleMenu")
    @ResponseBody
    public List<Tree> queryRoleMenu(int rid){

        return jueService.queryRoleMenu(-1,rid);
    }

    @RequestMapping("saveRoleMenu")
    @ResponseBody
    public String saveRoleMenu(int rid ,String menuIds){
        jueService.saveRoleMenu(rid,menuIds);
        return "suc";
    }

    @RequestMapping("gainCode")
    @ResponseBody
    public void gainCode(HttpServletRequest request, HttpServletResponse response) throws Exception{

        CheckImgUtil.checkImg(request, response);
    }

    @RequestMapping("toLogin")
    @ResponseBody
    public String toLogin(String code, HttpSession session, User user){
        String newname = session.getAttribute("checkcode").toString();
        if(!code.equalsIgnoreCase(newname)){
            return "验证码错误!";
        }
        User u = jueService.queryUserName(user.getName());
        if(u==null){
            return "用户不存在！";
        }
        if(!u.getPassWord().equals(user.getPassWord())){
            return "密码错误！";
        }
        session.setAttribute("user", u);
        return "登录成功！";
       }

}
