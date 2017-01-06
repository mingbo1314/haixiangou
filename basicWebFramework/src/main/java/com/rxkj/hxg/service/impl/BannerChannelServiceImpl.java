/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.service.impl;

import com.rxkj.hxg.dao.BannerChannelDao;
import com.rxkj.hxg.entity.BannerChannel;
import com.rxkj.hxg.params.BannerChannelParams;
import com.rxkj.hxg.service.BannerChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名称: BannerChannelServiceImpl <br>
 * 类描述: <br>
 *
 * @author: yangming
 * @since: 2017/1/4 14:44
 * @version: 1.0.0
 */
@Service("bannerChannelService")
public class BannerChannelServiceImpl implements BannerChannelService {

    @Autowired
    private BannerChannelDao bannerChannelDao;

    @Override
    public List<BannerChannel> queryBannerChannel(BannerChannelParams bannerChannelParams) {
        return bannerChannelDao.queryBannerChannel(bannerChannelParams);
    }
}
