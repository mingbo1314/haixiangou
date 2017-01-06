/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.dao;

import com.rxkj.hxg.entity.BannerChannel;
import com.rxkj.hxg.params.BannerChannelParams;
import com.yeepay.g3.utils.persistence.GenericDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类名称: BannerChannelDao <br>
 * 类描述: <br>
 *
 * @author: yangming
 * @since: 2017/1/4 14:46
 * @version: 1.0.0
 */
@Repository("bannerChannelDao")
public interface BannerChannelDao extends GenericDao<BannerChannel> {

    public List<BannerChannel> queryBannerChannel(BannerChannelParams bannerChannelParams);

}
