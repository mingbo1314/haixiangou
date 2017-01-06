/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.params;

import com.rxkj.hxg.enumtype.ImageTypeEnum;
import com.rxkj.hxg.enumtype.SchemeTypeEnum;
import com.rxkj.hxg.enumtype.StatusEnum;

/**
 * 类名称: BannerChannelParams <br>
 * 类描述: <br>
 *
 * @author: yangming
 * @since: 2017/1/4 14:39
 * @version: 1.0.0
 */
public class BannerChannelParams extends BaseParam {

    private static final long serialVersionUID = 4687135309670312096L;

    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片地址
     */
    private String iconUrl;

    /**
     * 类型
     */
    private SchemeTypeEnum schemeType;

    /**
     * 可用状态
     */
    private StatusEnum status;

    /**
     * 图片类型
     */
    private ImageTypeEnum imageType;

    /**
     * 跳转ID
     */
    private Long schemeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public SchemeTypeEnum getSchemeType() {
        return schemeType;
    }

    public void setSchemeType(SchemeTypeEnum schemeType) {
        this.schemeType = schemeType;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public ImageTypeEnum getImageType() {
        return imageType;
    }

    public void setImageType(ImageTypeEnum imageType) {
        this.imageType = imageType;
    }

    public Long getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(Long schemeId) {
        this.schemeId = schemeId;
    }
}
