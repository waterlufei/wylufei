package com.waterlufei.WyWork.Enum;

public enum ShoppingCartEnum {
    SUCCESS(0,"操作成功"),
    EXCEPTION(1,"发生异常"),
    ADD_SHOPPING_CART_FAIL(2,"加入购物车失败"),
    SHOPPING_CART_EMPTY(3,"购物车列表为空")
    ;
    private Integer code;
    private String msg;

    ShoppingCartEnum(Integer code,String msg){
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
