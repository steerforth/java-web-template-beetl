package com.steer.beetl.extern.global;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRenderExt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GlobalExt implements WebRenderExt {
    @Override
    public void modify(Template template, GroupTemplate groupTemplate, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        //每次在模板里都可以访问变量sysVersion了
        template.binding("sysVersion","v1.0.1");
    }
}
