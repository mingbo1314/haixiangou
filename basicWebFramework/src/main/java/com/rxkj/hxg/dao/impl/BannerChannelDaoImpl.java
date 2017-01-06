/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.dao.impl;

import com.rxkj.hxg.dao.BannerChannelDao;
import com.rxkj.hxg.dao.BaseDao;
import com.rxkj.hxg.entity.BannerChannel;
import com.rxkj.hxg.params.BannerChannelParams;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类名称: BannerChannelDaoImpl <br>
 * 类描述: <br>
 *
 * @author: yangming
 * @since: 2017/1/4 14:52
 * @version: 1.0.0
 */
@Repository("bannerChannelDao")
public class BannerChannelDaoImpl extends BaseDao<BannerChannel> implements BannerChannelDao {

    @Override
    public List<BannerChannel> queryBannerChannel(BannerChannelParams bannerChannelParams) {
        return this.query("queryAll",bannerChannelParams);
    }
}
