package com.waterlufei.WyWork.vo;

import java.math.BigDecimal;

public class ShoppingCartDetailedResponse {
    // 商品id
    private Integer goodsId;
    private String title;
    private BigDecimal price;
    // 购物车中某种商品的数量
    private Integer goodsNum;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}
