package com.example.admins.controller;


import com.example.admins.bean.UserInfo;
import com.example.admins.service.UserInfoService;
import com.example.admins.tool.LayuiResultData;
import com.example.admins.tool.PageTableRequest;
import com.example.admins.tool.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zheng_fx
 * @since 2020-02-25
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    
    
    @Autowired
    UserInfoService userInfoService;
    
    @RequestMapping("/login")
    public Object login(HttpServletRequest request, HttpSession session){

        String sysName = request.getParameter("username");
        String sysPassword = request.getParameter("password");
        UserInfo userInfo = userInfoService.selectUserByCondition(sysName,sysPassword);
        if(userInfo!=null){
            session.setAttribute("user_login",userInfo);
            return new LayuiResultData().returnSuccess("登陆成功");
        }else {
            return new LayuiResultData().returnFail("登陆失败");
        }
    }




    //todo 分页查询全部 --【20200225】
    @RequestMapping(value = "/user_list")
    public Results<UserInfo> varList(PageTableRequest pageTable) {

        Results<UserInfo> allByPage = userInfoService.getAllByPage(pageTable.getPage(), pageTable.getLimit());
        return allByPage;
    }

}
