package com.jin.weixin.handler;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jin on 2018/3/9.
 */
@Controller
@EnableAutoConfiguration
public class ErrorHello {

    @RequestMapping("/error/")
    @ResponseBody
    public String home() {
        String out = "gegeg";

        return out;
    }


}
