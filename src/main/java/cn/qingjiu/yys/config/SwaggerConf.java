package cn.qingjiu.yys.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
* @Description: swagger配置
* @Param:  
* @return:  
* @Author: tjy
* @Date: 2019/5/21 
*/ 
@Configuration
public class SwaggerConf {

    @Value("${swagger.enable}")
    private boolean enable;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.qingjiu.yys.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger接口文档")
                .description("用来调试接口")
                .termsOfServiceUrl("http://qingjiujiu.wang")
                .version("1.0")
                .build();
    }
}
