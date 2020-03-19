package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerApi;
import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: CmsPageController
 * Date:      2020/3/16 18:08
 * author     congzi
 * version    V1.0
 */

@RestController  //@ResponseBody + @Controller
@RequestMapping("/cms/page")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    PageService pageService;

    /**
     * 页面信息分页展示
     * @param page 当前页
     * @param size 每页显示条数
     * @param queryPageRequest
     * @return
     */
    @Override
    @GetMapping("/list/{page}/{size}") //基于GET访问 相当于RequestMapping的GET
    public QueryResponseResult findList(@PathVariable("page") int page,@PathVariable("size") int size, QueryPageRequest queryPageRequest) {

        //使用测试数据 封装
        QueryResult queryResult = new QueryResult();
        //总页数
        queryResult.setTotal(2);

        //页面对象 封装
        CmsPage cp = new CmsPage();
        cp.setPageName("测试页面");

        List list = new ArrayList();
        list.add(cp);

        //设置页面显示数据
        queryResult.setList(list);

        //创建响应对象,封装响应数据
        //QueryResponseResult result = new QueryResponseResult(CommonCode.SUCCESS,queryResult);

       QueryResponseResult result = pageService.findList(page, size, queryPageRequest);

        return result;
    }
}
