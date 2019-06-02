package com.steer.beetl.extern.function;

import org.beetl.core.Context;
import org.beetl.core.Function;

import java.io.IOException;

/**
 * 自定义函数
 */
public class CustomFunc implements Function {
    @Override
    public Object call(Object[] objects, Context context) {
        Object o = objects[0];
        if (o != null){
            try{
                //传入的参数是什么，就返回输出什么
                context.byteWriter.write(o.toString().getBytes());
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return "";
    }
}
