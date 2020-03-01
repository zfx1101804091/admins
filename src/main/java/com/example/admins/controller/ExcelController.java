package com.example.admins.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.admins.bean.UserInfo;
import com.example.admins.bean.vo.UserInfoVo;
import com.example.admins.service.UserInfoService;
import com.example.admins.tool.ExcelWriterTool;
import com.example.admins.tool.LayuiResultData;
import com.example.admins.tool.Results;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;


/**
 * @description:
 * @author: zheng-fx
 * @time: 2020/2/25 0025 18:53
 */
@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelController {
    
   @Autowired
    UserInfoService userInfoService;
    
    /*
     * 数据导入
     * */
    @PostMapping("/uploadUserInfo")
    public Object uploadUserInfo(MultipartFile file) throws IOException {
        try {
            if (file == null) {
                // 文件不能为空
                log.info("file参数为空！");
                return new LayuiResultData().returnFail("file参数为空");
            }

            String fileName = file.getOriginalFilename();
            if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
                // 文件格式不正确
                log.info("Excel文件格式不正确！");
                return new LayuiResultData().returnFail("Excel文件格式不正确");
            }
            long size = file.getSize();
            if (StringUtils.isEmpty(fileName) || size == 0) {
                // 文件不能为空
                log.info("Excel文件内容为空！");
                return new LayuiResultData().returnFail("Excel文件内容为空");
            }

            // 0 -失败 大于0 成功
            Integer result = userInfoService.importExcel(file);

            if (result > 0) {
                //保存成功
                log.info("上传Excel文件，文件上传成功！");
                return new LayuiResultData().returnSuccess("上传Excel文件，文件上传成功", 0, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传Excel文件异常", e);
        }


        return new LayuiResultData().returnFail("上传失败");
    }


    @RequestMapping("/exportData")
    public void exportData(HttpServletResponse response){
       
        try {
            String fileName = "用户信息"+new Date().getTime()+".xls";// 文件名
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8"));
            OutputStream out = response.getOutputStream();

            Results<UserInfo> allByPage = userInfoService.getAllByPage(1, 13);
            ArrayList<UserInfo> rows = CollUtil.newArrayList(allByPage.getDatas());

            List<UserInfoVo> rows1 = new ArrayList<>();
            rows.forEach((userInfo)->{
                UserInfoVo userInfoVo = new UserInfoVo();
                BeanUtils.copyProperties(userInfo,userInfoVo);
                rows1.add(userInfoVo);
            });

            System.out.println("rows---"+rows1);
            ExcelWriter writer = ExcelUtil.getWriter();
            
            
            //设置表头
            writer.addHeaderAlias("sysName","员工姓名");
            writer.addHeaderAlias("sysPassword","员工密码");
            writer.addHeaderAlias("sysNumber","工号");
            writer.addHeaderAlias("sysTrainName","培训班名称");
            writer.addHeaderAlias("sysTranTime","培训时间");
            writer.addHeaderAlias("sysSite","派出机构");
            writer.addHeaderAlias("sysMoney","缴纳金额");
            writer.addHeaderAlias("sysMoneyState","缴纳状态");
            writer.addHeaderAlias("sysRemark","备注");
            
            //设置某一列的宽度（列，宽度）
//            writer.setColumnWidth(3,20);
//            writer.setColumnWidth(4,20);
            //创建单元格样式
            CellStyle headCellStyle = writer.getHeadCellStyle();
            
            headCellStyle.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());//颜色
            Font font = writer.createFont();
            font.setColor(IndexedColors.WHITE.getIndex());//设置字体颜色
            font.setBold(true);
            headCellStyle.setFont(font);
            
            writer.write(rows1,true);
            //必须等数据都写完
            for (int i = 0; i <writer.getColumnCount() ; i++) {
                writer.setColumnWidth(i,20);
            }
            writer.flush(out);
           
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
