package com.steer.beetl.config.web;

import com.steer.beetl.config.properties.BeetlProperties;
import com.steer.beetl.function.CustomFunc;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeetlCfg {
    @Autowired
    BeetlProperties beetlProperties;

    /**
     * beetl的配置
     */
    @Bean(initMethod = "init")
    public BeetlGroupUtilConfiguration beetlConfiguration() {
        BeetlGroupUtilConfiguration beetlConfiguration = new BeetlGroupUtilConfiguration();
        //设置共享变量，所有模板都可以使用
        Map<String,Object> map = new HashMap<>();
        map.put("global","我是全局变量");
        beetlConfiguration.setSharedVars(map);
        //注册自定义函数
//        beetlConfiguration.getGroupTemplate().registerFunction("customFunction()",new CustomFunc());
        //设置资源路径
        beetlConfiguration.setResourceLoader(new ClasspathResourceLoader(BeetlCfg.class.getClassLoader(), beetlProperties.getPrefix()));
        beetlConfiguration.setConfigProperties(beetlProperties.getProperties());
        return beetlConfiguration;
    }

    /**
     * beetl的视图解析器
     */
    @Bean
    public BeetlSpringViewResolver beetlViewResolver() {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setConfig(beetlConfiguration());
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setSuffix(".html");
        return beetlSpringViewResolver;
    }

////    @Value("${beetl.templatesPath}") String templatesPath;//模板根目录 ，比如 "templates"
//    @Bean(name = "beetlConfig")
//    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
//        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
//        //获取Spring Boot 的ClassLoader
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        if(loader==null){
//            loader = BeetlCfg.class.getClassLoader();
//        }
////        beetlGroupUtilConfiguration.setConfigProperties(extProperties);//额外的配置，可以覆盖默认配置，一般不需要
//        ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader,
//                "templates");
//        beetlGroupUtilConfiguration.setResourceLoader(cploder);
//        beetlGroupUtilConfiguration.init();
//        //如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
//        beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
//        return beetlGroupUtilConfiguration;
//
//    }
//
//    @Bean(name = "beetlViewResolver22")
//    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlCfg") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
//        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
//        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
//        beetlSpringViewResolver.setPrefix("/templates/");
//        beetlSpringViewResolver.setSuffix(".html");
//        beetlSpringViewResolver.setOrder(0);
//        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
//        return beetlSpringViewResolver;
//    }


}
