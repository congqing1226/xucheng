package com.xuecheng.manage_cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClassName: ManageCmsApplication
 * Date:      2020/3/16 16:41
 * author     congzi
 * version    V1.0
 */
@SpringBootApplication
@EntityScan("com.xuecheng.framework.domain.cms")//扫描实体类
//扫描接口和本项目下的所有类
@ComponentScan({"com.xuecheng.api","com.xuecheng.manage_cms"})
public class ManageCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageCmsApplication.class,args);
    }

}
