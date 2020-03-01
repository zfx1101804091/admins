package com.example.admins.controller;

import com.example.admins.bean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/page")
public class PageContontroller {


    //todo 登陆 ----http://localhost:8086/page/login
    @RequestMapping(value = "/login")
    public String Login() { return "login.html"; }

    @RequestMapping(value = "/index")
    public String index() { return "index.html"; }
    

    //新增首页显示登陆用户得名称
    @RequestMapping(value = "/welcome")
    public String welcome(Model model, HttpSession session) {
        UserInfo userInfo = (UserInfo) session.getAttribute("user_login");
        String sysName = userInfo.getSysName();
        model.addAttribute("sysName", sysName);
        return "welcome";
    }

    
    //登出功能
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.removeAttribute("user_login");
        return "login";
    }
    
    //todo  ----
    @RequestMapping(value = "/member-list")
    public String test1() {
        return "member-list";
    }


    //todo     ----
    @RequestMapping("member-list1")
    public String member() {
        return "member-list1";
    }

    //todo     ----
    @RequestMapping(value = "/member-del")
    public String member1() { return "member-del.html"; }

    //todo     ----
    @RequestMapping(value = "/order-list")
    public String member2() { return "order-list"; }

    //todo     ----
    @RequestMapping(value = "/order-list1")
    public String member3() { return "order-list2.html"; }


    //todo     ----
    @RequestMapping(value = "/cate")
    public String member4() { return "cate.html"; }


    //todo     ----
    @RequestMapping(value = "/city")
    public String member5() { return "city.html"; }


    //todo     ----
    @RequestMapping(value = "/admin-list")
    public String member6() { return "admin-list.html"; }
    
    
    


    



    //todo   错误页面  ----
    @RequestMapping(value = "/error")
    public String  error() { return "error.html"; }



//todo   示例页面  ----
    @RequestMapping(value = "/demo")
    public String  demo() { return "demo.html"; }

    //todo   更新日志  ----
    @RequestMapping(value = "/log")
    public String  log() {
        // 我在着也能用 因为我这个controller注入这个service了
        { return "log.html"; }

    }

    @RequestMapping(value = "/order-add")
    public String  role() { return "order-add.html"; }


    @RequestMapping(value = "/order-add2")
    public String  roles() { return "order-add2.html"; }


    @RequestMapping(value = "/order-update")
    public String  rolessd() { return "order-update.html"; }
}
