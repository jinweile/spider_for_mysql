package com.etaoshi.spider.web;

import java.nio.charset.Charset;

public class HelloWorldBean implements HelloWorld {
    public String greeting(String name) {
        return "你好 "+name;
    }

    public String print() {
        return "我叫林计钦";
    }
    
    public byte[] getMessage(byte[] msg){
    	//获取字节数组
    	String xml = new String(msg, Charset.forName("GBK"));
    	System.out.print(xml);
    	
    	return xml.getBytes(Charset.forName("GBK"));
    }
}
