package com.waterlufei.WyWork.Enum;

public enum OrderEnum {
    SUCCESS(0,"操作成功"),
    EXCEPTION(1,"发生异常"),
    QUERY_ORDERS_EMPTY(2,"订单为空"),
    ADD_ORDER_FAIL(3,"加入购物车失败")
    ;
    private Integer code;
    private String msg;

    OrderEnum(Integer code,String msg){
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
