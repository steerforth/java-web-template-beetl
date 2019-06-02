package com.steer.beetl.config.web;

import com.steer.beetl.extern.format.CustomDateFormat;
import com.steer.beetl.extern.function.CustomFunc;
import com.steer.beetl.extern.tag.SimpleHtmlTag;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * 扩展类
 */
public class BeetlConfiguration extends BeetlGroupUtilConfiguration {
    @Override
    protected void initOther(){
        //设置全局共享变量，所有模板都可以使用
        Map<String,Object> map = new HashMap<>();
        map.put("global","我是全局变量");
        this.groupTemplate.setSharedVars(map);
        //注册自定义函数
        this.groupTemplate.registerFunction("customFunc",new CustomFunc());
        //注册自定义标签
        this.groupTemplate.registerTag("simpleTag",SimpleHtmlTag.class);
        //注册自定义格式化函数
        this.groupTemplate.registerFormat("customFormat",new CustomDateFormat());
//        this.groupTemplate.runScript();

        //校验某一个模板的语法
//        BeetlException ex = groupTemplate.validateTemplate("/index.html");
//        if(ex==null){
//            return;
//        }
//        ErrorInfo error = new ErrorInfo(ex);
//        int line = error.getErrorTokenLine();
//        String errorToken = error.getErrorTokenText();
//        String type = error.getType();


    }
}
