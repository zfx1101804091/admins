package com.example.admins.Dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.admins.bean.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zheng_fx
 * @since 2020-02-25
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {
    
    List<UserInfo> getALlByPage(@Param("pageIndex")Integer pageIndex, @Param("pageSize")Integer pageSize);

//    int insertExcelData(@Param("userInfo") UserInfo userInfo);
    int insertExcelData(@Param("map") Map<String,Object> map);
}
