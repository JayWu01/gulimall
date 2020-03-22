package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.service.AttrInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wujie
 * @version 1.0
 * @date 2020/3/18 12:12
 * @desciption
 */
@RestController
@CrossOrigin
public class AttrInfoController {
    @Reference
    private AttrInfoService attrInfoService;

    /**
     * 添加商品时的销售属性
     */
    @RequestMapping("baseSaleAttrList")
    public List<PmsBaseSaleAttr> baseSaleAttrList(){
        List<PmsBaseSaleAttr> baseSaleAttrList =attrInfoService.baseSaleAttrList();
        return baseSaleAttrList;
    }

    /**
     * 选择三级分类时根据catalog3Id将平台属性查询出来
     * @param catalog3Id
     * @return
     */
    @RequestMapping("attrInfoList")
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){
        List<PmsBaseAttrInfo> attrInfoList =attrInfoService.attrInfoList(catalog3Id);
        return attrInfoList;
    }

    @RequestMapping("saveAttrInfo")
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        String Msg=attrInfoService.saveAttrInfo(pmsBaseAttrInfo);
        return Msg;
    }


    @RequestMapping("getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValueList=attrInfoService.getAttrValueList(attrId);
        return pmsBaseAttrValueList;
    }



}
