package com.example.admins.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author zheng_fx
 * @since 2020-02-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("USER_INFO")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("SYS_ID")
    private Long sysId;

    @TableField("SYS_NAME")
    private String sysName;

    @TableField("SYS_PASSWORD")
    private String sysPassword;

    @TableField("SYS_NUMBER")
    private Long sysNumber;

    @TableField("SYS_TRAIN_NAME")
    private String sysTrainName;

    @TableField("SYS_TRAN_TIME")
    private Date sysTranTime;

    @TableField("SYS_SITE")
    private String sysSite;

    @TableField("SYS_MONEY")
    private String sysMoney;

    @TableField("SYS_MONEY_STATE")
    private String sysMoneyState;

    @TableField("SYS_REMARK")
    private String sysRemark;


}
