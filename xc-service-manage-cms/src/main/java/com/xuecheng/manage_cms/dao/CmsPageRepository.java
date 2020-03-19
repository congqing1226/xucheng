package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * ClassName: CmsPageRepository
 * Date:      2020/3/18 15:20
 * author     congzi
 * version    V1.0
 */

public  interface CmsPageRepository extends MongoRepository<CmsPage,String> {

    //根据页面名称查询
    CmsPage findByPageName(String pageName);

    //根据页面名称与类型查询
    //CmsPage findByPageNameAndPageType(String pageName,String pageType);

    //根据站点和页面类型查询记录数
    //int countBySiteIdAndPageType(String siteId,String pageType);

    //根据站点和页面类型 进行分页查询
    //Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType);

}
