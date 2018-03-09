package com.jin.weixin.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by jin on 2018/3/9.
 */

@Controller
public class Hello2 {
    private String message = "Hello World";

    @GetMapping("/index")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "index";
    }

}
