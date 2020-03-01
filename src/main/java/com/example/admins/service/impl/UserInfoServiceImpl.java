package com.example.admins.service.impl;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.admins.bean.UserInfo;
import com.example.admins.Dao.UserInfoMapper;
import com.example.admins.service.UserInfoService;
import com.example.admins.tool.Results;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zheng_fx
 * @since 2020-02-25
 */
@Slf4j
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {
    
    @Autowired
    UserInfoMapper userInfoMapper;
    
    @Override
    public Results<UserInfo> getAllByPage(Integer offset, Integer limit) {
        Integer count = userInfoMapper.selectCount(null);
        List<UserInfo> userVarList = userInfoMapper.getALlByPage(offset, limit);
        log.debug("offset---{}--limit----",offset,limit);
        Results<UserInfo> results = Results.success(count, userVarList);
        return results;
    }

    @Override
    public UserInfo selectUserByCondition(String sysName, String sysPassword) {
        QueryWrapper<UserInfo> wrapper = new QueryWrapper<UserInfo>().eq("SYS_NAME", sysName)
                .eq("SYS_PASSWORD", sysPassword);

        UserInfo userInfo = userInfoMapper.selectOne(wrapper);
        return userInfo;
    }

    @Override
    public Integer importExcel(MultipartFile file)  {
        Integer result = null;
        InputStream ins = null;
        try {
            ins = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
                ExcelReader excelReader = ExcelUtil.getReader(ins);
                List<Map<String, Object>> maps = excelReader.readAll();
                
                for (Map<String, Object> map : maps) {
                    result = userInfoMapper.insertExcelData(map);
                }
        } catch (IOException e) {
            e.printStackTrace();
            return result;
        }

        return result;
       
    }


    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
