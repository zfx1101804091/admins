package com.example.admins.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.admins.bean.UserInfo;
import com.example.admins.tool.Results;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zheng_fx
 * @since 2020-02-25
 */
public interface UserInfoService extends IService<UserInfo> {
    //分页查询全部
    Results<UserInfo> getAllByPage(Integer offset, Integer limit);

    //登陆验证
    UserInfo selectUserByCondition(String sysName, String sysPassword);

    Integer importExcel(MultipartFile excel);
}
