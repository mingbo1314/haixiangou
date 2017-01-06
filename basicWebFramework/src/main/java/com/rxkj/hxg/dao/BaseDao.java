/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.dao;

import com.rxkj.hxg.utils.rxkjDaoDefault;
import com.yeepay.g3.utils.persistence.Entity;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名称: BaseDao <br>
 * 类描述: <br>
 *
 * @author: yangming
 * @since: 2017/1/6 15:37
 * @version: 1.0.0
 */
public class BaseDao<E extends Entity> extends rxkjDaoDefault<E> {

    /**
     * 处理mybatis-spring高版本中，没有@Autowired的问题
     */
    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
