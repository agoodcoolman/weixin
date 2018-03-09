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
class SettingHandlerController{



    /**
     * 设置微信的开发者网站的时候用的
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping("/")
    @ResponseBody
    public String home(@RequestParam String signature, @RequestParam String timestamp,
                       @RequestParam String nonce, @RequestParam String echostr) {
        //实例化 统一业务API入口
        IService iService = new WxService();
        String out = "";
        if (iService.checkSignature(signature, timestamp, nonce, echostr)) {
            out= echostr;
        }
        return out;
    }

    @RequestMapping("/setmenu")
    @ResponseBody
    public String setMenu() {
        String out = "";
       /* if (iService.checkSignature(signature, timestamp, nonce, echostr)) {
            out= echostr;
        }*/
        return out;
    }


}
