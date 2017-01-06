/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.controller;

import com.rxkj.hxg.common.DataReturnFormat;
import com.rxkj.hxg.entity.BannerChannel;
import com.rxkj.hxg.enumtype.SchemeTypeEnum;
import com.rxkj.hxg.enumtype.StatusEnum;
import com.rxkj.hxg.params.BannerChannelParams;
import com.rxkj.hxg.service.BannerChannelService;
import com.yeepay.g3.utils.common.json.JSONUtils;
import com.yeepay.g3.utils.common.log.Logger;
import com.yeepay.g3.utils.common.log.LoggerFactory;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 类名称: HomeController <br>
 * 类描述: <br>
 *
 * @author: yangming
 * @since: 2017/1/3 22:10
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/api/home")
public class HomeController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BannerChannelService bannerChannelService;

    @RequestMapping(value = "/queryHome")
    @ResponseBody
    public String queryHome() {
        BannerChannelParams bannerChannelParams = new BannerChannelParams();
        bannerChannelParams.setSchemeType(SchemeTypeEnum.BANNER);
        bannerChannelParams.setStatus(StatusEnum.ACTIVE);
        //查询所有的banner
        List<BannerChannel> bannerChannels = bannerChannelService.queryBannerChannel(bannerChannelParams);
        System.out.println(ToStringBuilder.reflectionToString(bannerChannels));
        //查询所有的channel
        //个性推荐（查询打折商品前10条）
        //TOP10 排行榜（查询热销数量最多的前10条）
        DataReturnFormat dataReturnFormat = new DataReturnFormat();
        dataReturnFormat.setRequest_id("123123123123");
        dataReturnFormat.setStatus(DataReturnFormat.Status.SUCCESS);
        dataReturnFormat.setError_code("B000001");
        dataReturnFormat.setError_msg("错误消息");
        dataReturnFormat.addAttr("bannerChannels",bannerChannels);
        //结果
        return JSONUtils.toJsonString(dataReturnFormat);
    }

}
