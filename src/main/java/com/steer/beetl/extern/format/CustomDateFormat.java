package com.steer.beetl.extern.format;

import org.beetl.core.Format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateFormat implements Format {
    @Override
    public Object format(Object data, String pattern) {
        if(data == null){
            return null;
        }
        if(Date.class.isAssignableFrom(data.getClass())){
            SimpleDateFormat sdf = null;
            if (pattern == null){
                sdf = new SimpleDateFormat();
            }else{
                sdf = new SimpleDateFormat(pattern);
            }
            return sdf.format((Date) data);
        }else{
            throw new RuntimeException("参数错误:type should be Date");
        }
    }
}
