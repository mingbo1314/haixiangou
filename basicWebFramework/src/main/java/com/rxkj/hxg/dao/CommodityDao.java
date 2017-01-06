/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.dao;

import com.rxkj.hxg.entity.Commodity;
import com.rxkj.hxg.params.CommodityParams;
import com.yeepay.g3.utils.persistence.GenericDao;

import java.util.List;

/**
 * @author: yangming  Date: 2016/12/30 Time: 15:28
 */
public interface CommodityDao extends GenericDao<Commodity> {

    public List<Commodity> queryAll(CommodityParams commodityParams);
}
