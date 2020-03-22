package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.manage.mapper.Catalog1Mapper;
import com.atguigu.gmall.manage.mapper.Catalog2Mapper;
import com.atguigu.gmall.manage.mapper.Catalog3Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @author wujie
 * @version 1.0
 * @date 2020/3/17 14:34
 * @desciption
 */
@Service
public class CatalogService implements com.atguigu.gmall.service.CatalogService {
    @Autowired
    private Catalog1Mapper catalog1;
    @Autowired
    private Catalog2Mapper catalog2;
    @Autowired
    private Catalog3Mapper catalog3;
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        System.out.println(catalog1);
        List<PmsBaseCatalog1> catalog1List=catalog1.selectAll();
        return catalog1List;
//        return null;
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2=new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> catalog2List = catalog2.select(pmsBaseCatalog2);
        return catalog2List;
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3=new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> catalog3List = catalog3.select(pmsBaseCatalog3);
        return catalog3List;
    }
}
