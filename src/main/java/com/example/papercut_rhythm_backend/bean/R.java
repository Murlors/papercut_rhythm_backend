package com.example.papercut_rhythm_backend.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)  //为了不显示data为null的
public class R<T> {
    private Integer status;

    private String message;

    private T data;

    public R() {
    }

    private R(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    private R(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    private R(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }


    /**
     * 成功
     */
    public static <T> R<T> success() {
        return new R<>(CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getDesc());
    }

    public static <T> R<T> success(T data, String message) {
        return new R<>(CodeEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> R<T> success(T data) {
        return new R<>(CodeEnum.SUCCESS.getCode(), data);
    }

    public static <T> R<T> success(String message) {
        return new R<>(CodeEnum.SUCCESS.getCode(), message);
    }

    public static <T> R<T> success(CodeEnum codeEnum, String message) {
        return new R<>(codeEnum.getCode(), message);
    }

    public static <T> R<T> success(CodeEnum codeEnum, T data) {
        return new R<>(CodeEnum.SUCCESS.getCode(), data);
    }

    public static <T> R<T> success(CodeEnum codeEnum) {
        return new R<>(codeEnum.getCode(), codeEnum.getDesc());
    }

    /**
     * 失败
     */
    public static <T> R<T> error() {
        return new R<>(CodeEnum.ERROR.getCode(), CodeEnum.ERROR.getDesc());
    }

    public static <T> R<T> error(String message) {
        return new R<>(CodeEnum.ERROR.getCode(), message);
    }

    public static <T> R<T> error(CodeEnum codeEnum) {
        return new R<>(codeEnum.getCode(), codeEnum.getDesc());
    }

    public static <T> R<T> error(CodeEnum codeEnum, String message) {
        return new R<>(codeEnum.getCode(), message);
    }
}
