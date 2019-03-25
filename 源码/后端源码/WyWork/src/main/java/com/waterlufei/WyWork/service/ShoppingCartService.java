package com.waterlufei.WyWork.service;

import com.waterlufei.WyWork.vo.ShoppingCartDetailedResponse;
import com.waterlufei.WyWork.vo.ShoppingCartRequest;

import java.util.List;

public interface ShoppingCartService {

    /**
     * 商品加入购物车
     * @param shoppingCartRequest
     * @return
     */
    void addShoppingCart(ShoppingCartRequest shoppingCartRequest);

    List<ShoppingCartDetailedResponse> getShoppingCartInfo();
}
