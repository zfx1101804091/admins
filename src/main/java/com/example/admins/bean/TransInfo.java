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
@TableName("TRANS_INFO")
public class TransInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("MERCH_ID")
    private String merchId;

    @TableField("TERM_ID")
    private String termId;

    @TableField("TXN_AMT")
    private Double txnAmt;

    @TableField("PAN")
    private String pan;

    @TableField("SYSTRACE")
    private String systrace;

    @TableField("INVOICE")
    private String invoice;

    @TableField("AUTHID")
    private String authid;

    @TableField("BATCH")
    private String batch;

    @TableField("REFNO")
    private String refno;

    @TableField("DATE_TIME")
    private Date dateTime;

    @TableField("DATE_ASC_TIME")
    private String dateAscTime;

    @TableField("TRANS_TYPE")
    private Double transType;

    @TableField("TRANS_NAME")
    private String transName;

    @TableField("MODE_TYPE")
    private Double modeType;

    @TableField("MODE_NAME")
    private String modeName;

    @TableField("MERCH_ORDER")
    private String merchOrder;

    @TableField("BANK_ORDER")
    private String bankOrder;

    @TableField("WZ_ORDER")
    private String wzOrder;

    @TableField("EMP_ID")
    private String empId;

    @TableField("NAME")
    private String name;

    @TableField("PCJG")
    private String pcjg;

    @TableField("PXBC")
    private String pxbc;

    @TableField("PXSJ")
    private Date pxsj;

    @TableField("FLAG")
    private Double flag;

    @TableField("MEM_INFO")
    private String memInfo;

    @TableField("IMP_DATE")
    private Date impDate;

    @TableField("MEMO1")
    private String memo1;

    @TableField("MEMO2")
    private String memo2;

    @TableField("MEMO3")
    private String memo3;

    @TableField("MEMO4")
    private String memo4;

    @TableField("MEMO5")
    private String memo5;

    @TableField("MEMO6")
    private String memo6;

    @TableField("MEMO7")
    private String memo7;

    @TableField("MEMO8")
    private String memo8;

    @TableField("MEMO9")
    private String memo9;

    @TableField("MEMO10")
    private String memo10;


}
