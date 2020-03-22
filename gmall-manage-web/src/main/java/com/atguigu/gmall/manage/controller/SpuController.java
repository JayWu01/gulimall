package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.service.SpuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wujie
 * @version 1.0
 * @date 2020/3/19 23:11
 * @desciption
 */
@RestController
@CrossOrigin
public class SpuController {
    @Reference
    private SpuService spuService;
    @RequestMapping("spuList")
    public List<PmsProductInfo> spuList(String catalog3Id) {
        List<PmsProductInfo> productInfoList =spuService.spuList(catalog3Id);
        return productInfoList;
    }

    public String saveSpuInfo(@RequestBody  PmsProductInfo pmsProductInfo){
        String Msg=spuService.saveSpuInfo(pmsProductInfo);
        return Msg;
    }
}
