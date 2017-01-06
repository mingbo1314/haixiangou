package com.rxkj.hxg.dao;

import com.rxkj.hxg.entity.BannerChannel;

public interface BannerChannelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BannerChannel record);

    int insertSelective(BannerChannel record);

    BannerChannel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BannerChannel record);

    int updateByPrimaryKey(BannerChannel record);
}