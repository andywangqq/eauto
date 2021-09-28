package com.eauto.base;

import java.io.Serializable;

/**
 * User:Administrator
 * Date:2021/9/27
 * Time:15:49
 * Description: No Description
 */
public class ResultModel<T> implements Serializable {
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    private String massage;
    private T data;


    /**
     * 返回成功
     * @return
     */
    public static ResultModel Success() {
        ResultModel result = new ResultModel();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMassage(ResultCode.SUCCESS.getMessage());
        return result;
    }

    /**
     * 返回成功
     * @param data
     * @param <F>
     * @return
     */
    public static <F> ResultModel<F> Success(F data) {
        ResultModel result = new ResultModel();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMassage(ResultCode.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 返回失败
     * @param resultCode
     * @return
     */
    public static ResultModel failure(ResultCode resultCode) {
        ResultModel result = new ResultModel();
        result.setCode(resultCode.getCode());
        result.setMassage(resultCode.getMessage());
        return result;
    }

    public static <F> ResultModel<F> failure(ResultCode resultCode, F data) {
        ResultModel result = new ResultModel();
        result.setCode(resultCode.getCode());
        result.setMassage(resultCode.getMessage());
        result.setData(data);
        return result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


