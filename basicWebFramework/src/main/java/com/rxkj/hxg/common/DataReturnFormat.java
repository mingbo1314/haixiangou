/**
 * Copyright: Copyright (c)2016
 * Company: 仁轩科技(Rxkj)
 */
package com.rxkj.hxg.common;

import com.rxkj.hxg.entity.Commodity;
import com.rxkj.hxg.entity.User;
import com.yeepay.g3.utils.common.StringUtils;
import com.yeepay.g3.utils.common.json.JSONUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author: yangming  Date: 2017/1/3 Time: 11:53
 */
public class DataReturnFormat implements Serializable {

    private static final long serialVersionUID = 6826225666857397565L;

    /**
     * 请求流水号
     */
    private String request_id;

    /**
     * 返回状态
     */
    private Status status;

    /**
     * 0请求成功，－1请求失败，其他值待定
     */
    private String error_code;

    /**
     * 错误消息
     */
    private String error_msg;

    /**
     * 缓存判断数据是否有更新
     */
    private String sign;

    /**
     * 返回数据
     */
    private Map<String, Object> data;

    public DataReturnFormat(Object message) {
        this.status = Status.SUCCESS;
        if (message instanceof String) {
            this.error_msg = (String) message;
        } else {
            this.error_msg = message != null ? message.toString() : null;
        }
    }

    public DataReturnFormat(Status status, Object message) {
        this.status = status;
        if (message instanceof String) {
            this.error_msg = (String) message;
        } else {
            this.error_msg = message != null ? message.toString() : null;
        }
    }

    /**
     * 产生Json信息
     *
     * @return
     */
    public String toJson() {
        return JSONUtils.toJsonString(toJsonObject());
    }

    /**
     * 产生Json信息
     *
     * @return
     */
    public String toJson(Object object) {
        return JSONUtils.toJsonString(object);
    }

    public Object toJsonObject(){
        Map<String, Object> response = new HashMap<String, Object>();
        if (request_id != null) {
            response.put("request_id", request_id);
        }
        if (status != null) {
            response.put("status", status);
        }
        if (error_code != null) {
            response.put("error_code", error_code);
        }
        if (error_msg != null) {
            response.put("errMsg", error_msg);
        }
        if (sign != null) {
            response.put("sign", sign);
        }
        if (data != null) {
            response.putAll(data);
        }
        return response;
    }

    /**
     * 设置错误信息
     *
     * @param errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        String msg = errorMsg;
        if (StringUtils.isNotBlank(errorMsg)) {
            String orgMsg = StringUtils.substringAfterLast(errorMsg,
                    "orgExceptionInfo:");
            if (StringUtils.isNotBlank(orgMsg)) {
                msg = orgMsg;
            }
        }
        this.error_msg = msg;
    }


    /**
     * 添加属性
     *
     * @param attr
     * @param value
     */
    public void addAttr(String attr, Object value) {
        if (data == null) {
            data = new HashMap<String, Object>();
        }
        data.put(attr, value);
    }

    public DataReturnFormat() {
    }

    public DataReturnFormat(String error_code, String error_msg) {
        this.status = Status.FAIL;
        this.error_code = error_code;
        this.error_msg = error_msg;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    public enum Status {
//
//        SUCESS(0), FAIL(-1), OTHER(1);
//
//        private int value;
//
//        private Status(int num) {
//            this.value = num;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//    }
    public enum Status {

        SUCCESS("success"), TIMEOUT("timeout"), FAIL("fail");

        private String value;

        Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public static void main(String[] args) {
        DataReturnFormat dataReturnFormat = new DataReturnFormat();
        dataReturnFormat.setRequest_id("123123123123");
        dataReturnFormat.setStatus(Status.SUCCESS);
        dataReturnFormat.setError_code("B000001");
        dataReturnFormat.setError_msg("错误消息");
        User user = new User();
        user.setAccumulateScore(BigDecimal.ONE);
        user.setCreateTime(new Date());
        Commodity commodity = new Commodity();
        commodity.setCreateTime(new Date());
        commodity.setCommodityIsHot(Boolean.TRUE);
        List list = new ArrayList();
        list.add(user);
        list.add(commodity);
        dataReturnFormat.addAttr("user",user);
        dataReturnFormat.addAttr("commodity",user);
        dataReturnFormat.addAttr("list",list);
        System.out.println(JSONUtils.toJsonString(dataReturnFormat));
    }
}
