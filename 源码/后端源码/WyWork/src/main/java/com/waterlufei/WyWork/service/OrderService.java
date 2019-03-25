package com.waterlufei.WyWork.service;

import com.waterlufei.WyWork.vo.OrderRequest;
import com.waterlufei.WyWork.vo.OrderResponse;

import java.util.List;

public interface OrderService {

    /**
     * 买家查询所有已完成订单信息
     */
    List<OrderResponse> getOrdersInfo();

    /**
     * 添加订单信息
     */
    void addOrder();

    /**
     * 通过商品id查询订单信息
     * @param goodsId
     * @return
     */
    List<OrderResponse> getOrdersInfoById(int goodsId);
}
