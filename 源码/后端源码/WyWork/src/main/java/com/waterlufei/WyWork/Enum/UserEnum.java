package com.waterlufei.WyWork.Enum;

public enum UserEnum {

    SUCCESS(0,"操作成功"),
    EXCEPTION(1,"发生异常"),
    NO_FOUND_USER_INO(2,"找不到用户信息");

    private Integer code;
    private String msg;

    UserEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
