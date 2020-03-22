package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.manage.mapper.AttrInfoMapper;
import com.atguigu.gmall.manage.mapper.AttrValueMapper;
import com.atguigu.gmall.manage.mapper.SaleAttrMapper;
import com.atguigu.gmall.service.AttrInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author wujie
 * @version 1.0
 * @date 2020/3/18 12:00
 * @desciption
 */
@Service
public class AttrInfoServiceImpl implements AttrInfoService {
    @Autowired
    private AttrInfoMapper attrInfomapper;
    @Autowired
    private AttrValueMapper attrValueMapper;
    @Autowired
    private SaleAttrMapper saleAttrMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        PmsBaseAttrInfo attrInfo=new PmsBaseAttrInfo();
        attrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> attrInfoList=attrInfomapper.select(attrInfo);
        return attrInfoList;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        String id=pmsBaseAttrInfo.getId();//主键返回策略，返回新增id
        if(StringUtils.isBlank(id)){
            // id为空，保存
            // 保存属性
            attrInfomapper.insertSelective(pmsBaseAttrInfo);
            //保存属性值
            List<PmsBaseAttrValue> pmsBaseAttrValueList=pmsBaseAttrInfo.getAttrValueList();  //insert insertSelective 是否将null插入数据库
            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                attrValueMapper.insertSelective(pmsBaseAttrValue);
            }

        }else {
            //若id不为空则修改

        }

        return "success";
    }
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrinfoId) {
        PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrinfoId);
        List<PmsBaseAttrValue> pmsBaseAttrValueList=attrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValueList;
    }

    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        List<PmsBaseSaleAttr> pmsBaseSaleAttrList=saleAttrMapper.selectAll();
        return pmsBaseSaleAttrList;
    }


}
