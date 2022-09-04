package com.lin.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
public class SwaggerConfig {
/*
    swagger帮助生成接口文档
    1配置生成的文档信息
    2配置生成的接口规则
*/
    /*Docket封装接口文档信息*/
    @Bean
    public Docket getDocket(){
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("《锋迷商城》后端接口说明")
                .description("后端接口规范")
                .version("v 2.0.1")
                .contact(new Contact("木木","http://syf.io/","1129675573@qq.com"));

        ApiInfo apiInfo=apiInfoBuilder.build();
       //如何获取接口对象
        // 直接new接口，需要在构造器{}中实现接口中的所有抽象方法
        //new 子类实现
        //工厂模式

        Docket docket=new Docket(DocumentationType.OAS_30);//制定文档风格
        docket.apiInfo(apiInfo)//指定文档生成的封面信息,文档标题、作者、版本
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())//任何请求
                .build();
        return docket;
    }
}
