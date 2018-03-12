package com.jin.weixin.init;

import com.jin.weixin.service.WxServiceUtil;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConfig;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxMenu;
import com.soecode.wxtools.exception.WxErrorException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.LinkedList;

/**
 * Created by jin on 2018/3/9.
 * 项目初始化启动的时候加载的相关的配置
 */
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    //实例化 统一业务API入口
    private IService iService = WxServiceUtil.getInstance();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        try {
            String accessToken = iService.getAccessToken();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        WxMenu wxMenu = new WxMenu();

        WxMenu.WxMenuButton wxMenuButton = new WxMenu.WxMenuButton();
        wxMenuButton.setType("view");
        wxMenuButton.setKey("key");
        wxMenuButton.setUrl("http://kaikaidev.nat300.top/view/show");
        wxMenuButton.setName("跳转");

        WxMenu.WxMenuButton wxMenuButton2 = new WxMenu.WxMenuButton();
        wxMenuButton2.setType("view");
        wxMenuButton2.setKey("key");
        wxMenuButton2.setUrl("http://kaikaidev.nat300.top/view/show");
        wxMenuButton2.setName("跳转来");
        LinkedList<WxMenu.WxMenuButton> wxMenuButtons = new LinkedList<>();
        wxMenuButtons.add(wxMenuButton);
        wxMenuButtons.add(wxMenuButton2);

        wxMenu.setButton(wxMenuButtons);
        try {
            iService.createMenu(wxMenu, false);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }
}
