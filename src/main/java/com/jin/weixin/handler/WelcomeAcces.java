package com.jin.weixin.handler;

import com.jin.weixin.service.WxServiceUtil;
import com.soecode.wxtools.api.WxConfig;
import com.soecode.wxtools.bean.WxUserList;
import com.soecode.wxtools.bean.result.WxOAuth2AccessTokenResult;
import com.soecode.wxtools.exception.WxErrorException;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

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

        try {
            model.addAttribute("redirect_uri", URLEncoder.encode("http://kaikaidev.nat300.top/view/welcome", enc));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.addAttribute("response_type", WxConfig.getInstance().getAppId());
        model.addAttribute("scope", "snsapi_userinfo");
        model.addAttribute("state", "so");

        return "/hello";
    }

    @GetMapping("/view/welcome")
    public String show(@RequestParam String code, @RequestParam String state, Model model) {
        // get user info
        try {
            WxOAuth2AccessTokenResult wxOAuth2AccessTokenResult = WxServiceUtil.getInstance().oauth2ToGetAccessToken(code);
            WxUserList.WxUser.WxUserGet zh_cn = new WxUserList.WxUser.WxUserGet(wxOAuth2AccessTokenResult.getOpenid(), "zh_CN");
            WxUserList.WxUser wxUser = WxServiceUtil.getInstance().oauth2ToGetUserInfo(wxOAuth2AccessTokenResult.getAccess_token(), zh_cn);
            try {
                Logger.getLogger("WelcomeAcces").info(wxUser.toJson());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return "/welcome";
    }

}
