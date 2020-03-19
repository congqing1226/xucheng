package com.xuecheng.manage_cms.service;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.CommonCode;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.framework.model.response.QueryResult;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ClassName: PageService
 * Date:      2020/3/18 16:54
 * author     congzi
 * version    V1.0
 */
@Service
public class PageService {

    @Autowired
    CmsPageRepository cmsPageRepository;

    /**
     * 页面查询方法
     * @param page 页码,从1开始
     * @param size 每页显示记录数
     * @param queryPageRequest 查询条件
     * @return
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest){

        if(queryPageRequest == null){
            queryPageRequest = new QueryPageRequest();
        }

        if(page == 0){
            page = 1;
        }

        //为了适应mongodb的接口 将页码-1
        page = page - 1;

        if(size == 0){
            size = 20;
        }

        //分页对象
        Pageable pageable = PageRequest.of(page,size);

        //分页查询
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);

        //分页查询结果封装
        QueryResult<CmsPage> queryResult = new QueryResult<>();
        queryResult.setTotal(all.getTotalElements());
        queryResult.setList(all.getContent());

        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS,queryResult);
    }

}



