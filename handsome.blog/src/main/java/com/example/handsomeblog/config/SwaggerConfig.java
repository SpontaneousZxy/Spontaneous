package com.example.handsomeblog.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger 配置.
 * swagger.enable 可以控制是否开启swagger页面
 * 可以配置的参数包括一下几个：
 * swagger.basePackage     扫描包路径
 * swagger.title           页面标题
 * swagger.description     页面描述
 * swagger.authName        作者信息
 * swagger.authUrl         作者连接
 * swagger.authEmail       作者邮箱
 * swagger.version         项目版本号
 *
 * @author
 */
@Configuration
@ConditionalOnExpression("${swagger.enable:true}")
@EnableSwagger2
public class SwaggerConfig {

    private static final String BASE_PACKAGE_SPLIT = ";";

    /**
     * swagger扫描包路径.
     */
    @Value("${swagger.basePackage:com.example.handsomeblog}")
    private String basePackage;

    /**
     * swagger页面标题.
     */
    @Value("${swagger.title:Swagger接口列表}")
    private String title;

    /**
     * swagger页面描述.
     */
    @Value("${swagger.description:接口文档}")
    private String description;

    /**
     * swagger页面作者信息.
     */
    @Value("${swagger.authName:}")
    private String authName;

    /**
     * swagger页面项目作者连接.
     */
    @Value("${swagger.authUrl:}")
    private String authUrl;

    /**
     * swagger页面作者邮箱.
     */
    @Value("${swagger.authEmail:}")
    private String authEmail;

    /**
     * swagger页项目版本号.
     */
    @Value("${swagger.version:1.0.0}")
    private String version;

    public static Predicate<RequestHandler> basePackage(final String basePackage) {
        return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
    }

    private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
        return input -> {
            String[] packages = basePackage.split(BASE_PACKAGE_SPLIT);
            // 循环判断匹配
            for (String strPackage : packages) {
                boolean isMatch = input.getPackage().getName().startsWith(strPackage);
                if (isMatch) {
                    return true;
                }
            }
            return false;
        };
    }

    private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
        return Optional.fromNullable(input.declaringClass());
    }

    /**
     * 创建Docket 对象，配置swagger的基本设置扫描路径.
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(basePackage(basePackage))
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(authName, authUrl, authEmail))
                .version(version)
                .build();
    }
}
