package com.rxkj.hxg.dao;

import com.rxkj.hxg.entity.MERCHANT;

public interface MERCHANTMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MERCHANT record);

    int insertSelective(MERCHANT record);

    MERCHANT selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MERCHANT record);

    int updateByPrimaryKey(MERCHANT record);
}