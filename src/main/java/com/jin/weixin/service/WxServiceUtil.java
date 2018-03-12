package com.jin.weixin.service;

import com.soecode.wxtools.api.WxService;

/**
 * Created by jin on 2018/3/12.
 */
public class WxServiceUtil {

    private static WxService wxService = new WxService();

    public static WxService getInstance() {
        return wxService;
    }

}
