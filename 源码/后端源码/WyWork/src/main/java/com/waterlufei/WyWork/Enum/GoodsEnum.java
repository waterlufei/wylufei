package com.waterlufei.WyWork.Enum;

public enum GoodsEnum {

    SUCCESS(0,"操作成功"),
    EXCEPTION(1,"发生异常"),
    INCREASE_FAIL(2,"添加商品失败"),
    NOT_PURCHASE_GOODS_EMPTY(3,"用户未购买商品为空"),
    DELETE_FAIL(4,"删除商品失败"),
    GOODS_EMPTY(5,"商品为空"),
    CHANGE_ZERO(6,"修改0条数据"),
    GOODS_NOT_EXISTS(7,"商品不存在")
    ;
    private Integer code;
    private String msg;

    GoodsEnum(Integer code,String msg){
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
