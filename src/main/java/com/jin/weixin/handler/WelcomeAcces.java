package com.jin.weixin.handler;

import com.soecode.wxtools.api.WxConfig;
import org.apache.http.client.utils.URLEncodedUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/**
 * Created by jin on 2018/3/9.
 * 欢迎 授权页面
 */

@Controller
public class WelcomeAcces {
    private String enc = "UTF-8";


    @GetMapping("/view/show")
    public String welcome(Model model) {

        model.addAttribute("appid", WxConfig.getInstance().getAppId());

        model.addAttribute("redirect_uri", URLEncoder.encode("http://kaikaidev.nat300.top/view/welcome"));
        model.addAttribute("response_type", WxConfig.getInstance().getAppId());
        model.addAttribute("scope", "snsapi_userinfo");
        model.addAttribute("state", "so");

        return "/hello";
    }

    @GetMapping("/view/welcome")
    public String show(Model model) {

        return "/welcome";
    }

}
