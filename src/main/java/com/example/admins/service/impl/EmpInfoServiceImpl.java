package com.example.admins.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.admins.bean.EmpInfo;
import com.example.admins.Dao.EmpInfoMapper;
import com.example.admins.service.EmpInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zheng_fx
 * @since 2020-02-25
 */
@Service
public class EmpInfoServiceImpl extends ServiceImpl<EmpInfoMapper, EmpInfo> implements EmpInfoService {

}
