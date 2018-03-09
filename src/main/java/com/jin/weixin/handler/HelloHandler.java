package com.jin.weixin.handler;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jin on 2018/3/9.
 */
@Controller
@EnableAutoConfiguration
public class HelloHandler {
    //实例化 统一业务API入口
    private IService iService = new WxService();
    @RequestMapping("/hello")
    @ResponseBody
    public String home() {
        String out = "gegeg";
        return out;
    }
}
