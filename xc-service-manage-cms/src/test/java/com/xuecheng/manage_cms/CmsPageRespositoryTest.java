package com.xuecheng.manage_cms;

/**
 * ClassName: CmsPageRespositoryTest
 * Date:      2020/3/18 15:24
 * author     congzi
 * version    V1.0
 */

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRespositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    //分页测试
    @Test
    public void findPage(){

        int page = 0;//从0 开始
        int size = 10;//每页显示条数

        //获取分页对象
        Pageable pageable = PageRequest.of(page, size);

        //执行查询
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);

        System.out.println("总记录数: "+ all.getTotalElements());
        System.out.println("总页数: "+all.getTotalPages());

        Iterator<CmsPage> iterator = all.iterator();
        while (iterator.hasNext()){
            System.out.println("==================当前页数据=====================");
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testInsert(){

        CmsPage cp = new CmsPage();
        cp.setSiteId("s01");//站点ID
        cp.setTemplateId("t01");//模板ID
        cp.setPageName("测试页面");
        cp.setPageCreateTime(new Date());

        //封装参数集合
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param01");
        cmsPageParam.setPageParamValue("value01");

        List<CmsPageParam> paramList = new ArrayList<>();
        paramList.add(cmsPageParam);
        cp.setPageParams(paramList);//设置参数列表

        //保存
        cmsPageRepository.save(cp);
        System.out.println(cp);
    }

    @Test
    public void testDel(){
        cmsPageRepository.deleteById("5e71d7d39b99524160120f1e");
    }

    @Test
    public void testUpdate(){

        Optional<CmsPage> optional = cmsPageRepository.findById("5e71d9889b99523908ddfe92");

        if(optional.isPresent()){
            CmsPage cmsPage = optional.get();
            cmsPage.setPageName("修改测试页面");
            cmsPageRepository.save(cmsPage);
        }else{
            System.out.println("cmsPage为: " + null);
        }

    }


}
