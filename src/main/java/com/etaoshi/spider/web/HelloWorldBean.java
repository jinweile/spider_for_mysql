package com.etaoshi.spider.web;

public class HelloWorldBean implements HelloWorld {
    public String greeting(String name) {
        return "你好 "+name;
    }

    public String print() {
        return "我叫林计钦";
    }
}
