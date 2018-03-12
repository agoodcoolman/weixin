package com.jin.weixin.handler;

import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.util.xml.XStreamTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by jin on 2018/3/12.
 */
@Controller
public class Message {

    @PostMapping("/")
    @ResponseBody
    public String receiveMessage(@RequestBody String text) {

        WxXmlMessage wxXmlMessage = XStreamTransformer.fromXml(WxXmlMessage.class, text);
        Logger.getLogger("Message").info(wxXmlMessage.toString());
        return "";
    }
}
