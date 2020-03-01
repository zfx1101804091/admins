package com.example.admins.bean.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: zheng-fx
 * @time: 2020/2/27 0027 11:54
 */
@Data
public class UserInfoVo {

    private String sysName;
    
    private String sysPassword;
    
    private Long sysNumber;

    private String sysTrainName;

    private Date sysTranTime;

    private String sysSite;

    private String sysMoney;

    private String sysMoneyState;

    private String sysRemark;
}
