package com.imooc.config;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class WechatMpConfig {

    @Autowired
    private WechatAccountConfig wechatAccountConfig;
    @Bean
    public WxMpService wxMpService(){
        WxMpService wxMpService =  new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return  wxMpService;
    }

    public WxMpConfigStorage wxMpConfigStorage(){
        WxMpDefaultConfigImpl wxMpDefaultConfigImpl = new WxMpDefaultConfigImpl();
        wxMpDefaultConfigImpl.setAppId(wechatAccountConfig.getMpAppId());
        wxMpDefaultConfigImpl.setSecret(wechatAccountConfig.getMpAppSecret());
        return wxMpDefaultConfigImpl;
    }

}
