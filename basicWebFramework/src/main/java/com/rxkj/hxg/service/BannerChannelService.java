/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.service;

import com.rxkj.hxg.entity.BannerChannel;
import com.rxkj.hxg.params.BannerChannelParams;

import java.util.List;

/**
 * 类名称: BannerChannelService <br>
 * 类描述: <br>
 *
 * @author: yangming
 * @since: 2017/1/4 14:15
 * @version: 1.0.0
 */
public interface BannerChannelService {

    /**
     * 查询图片轮转和模块菜单
     * @param bannerChannelParams
     * @return
     */
    public List<BannerChannel> queryBannerChannel(BannerChannelParams bannerChannelParams);
}
