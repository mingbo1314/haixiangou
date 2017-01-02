/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.entity;

import com.yeepay.g3.utils.persistence.Entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yangming  Date: 2016/12/30 Time: 15:37
 */
public class Commodity implements Entity<Long>{

    private static final long serialVersionUID = -279727715130041508L;

    private Long id;
    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 图片地址
     */
    private String iconUrl;
    /**
     * 商品描述
     */
    private String desc;
    /**
     * 商品进价格
     */
    private BigDecimal inPrice;
    /**
     * 商品出价格
     */
    private BigDecimal outPrice;
    /**
     * 是否是热销商品
     */
    private Boolean commodityIsHot;
    /**
     * 商品剩余数量
     */
    private Integer remainderCount;
    /**
     * 商品进数量
     */
    private Integer totalCount;
    /**
     * 是否是打折的商品
     */
    private Boolean commodityIsSale;
    /**
     * 商品是从哪家商户进的
     */
    private String customerNumber;

    /**
     * 商品创建时间
     */
    private Date createTime;

    /**
     * 商品最后更新时间
     */
    private Date updateLastTime;

    /**
     * 商品售出时间
     */
    private Date saleTime;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        id = id;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getInPrice() {
        return inPrice;
    }

    public void setInPrice(BigDecimal inPrice) {
        this.inPrice = inPrice;
    }

    public BigDecimal getOutPrice() {
        return outPrice;
    }

    public void setOutPrice(BigDecimal outPrice) {
        this.outPrice = outPrice;
    }

    public Boolean getCommodityIsHot() {
        return commodityIsHot;
    }

    public void setCommodityIsHot(Boolean commodityIsHot) {
        this.commodityIsHot = commodityIsHot;
    }

    public Integer getRemainderCount() {
        return remainderCount;
    }

    public void setRemainderCount(Integer remainderCount) {
        this.remainderCount = remainderCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getCommodityIsSale() {
        return commodityIsSale;
    }

    public void setCommodityIsSale(Boolean commodityIsSale) {
        this.commodityIsSale = commodityIsSale;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateLastTime() {
        return updateLastTime;
    }

    public void setUpdateLastTime(Date updateLastTime) {
        this.updateLastTime = updateLastTime;
    }

    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }
}
