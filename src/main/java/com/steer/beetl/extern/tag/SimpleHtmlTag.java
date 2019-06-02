package com.steer.beetl.extern.tag;

import org.beetl.core.Tag;

import java.io.IOException;
import java.util.Map;

public class SimpleHtmlTag extends Tag {
    @Override
    public void render() {
        String tagName = (String) this.args[0];
        Map attrs = (Map) args[1];
        String value = (String) attrs.get("attr");
        try{
            //把标签属性attr的值写入到标签内容中去
            this.ctx.byteWriter.writeString(value);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
