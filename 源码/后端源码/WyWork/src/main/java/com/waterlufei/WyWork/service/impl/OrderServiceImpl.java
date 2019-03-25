package com.waterlufei.WyWork.service.impl;

import com.waterlufei.WyWork.mapper.GoodsMapper;
import com.waterlufei.WyWork.mapper.OrderMapper;
import com.waterlufei.WyWork.mapper.ShoppingCartMapper;
import com.waterlufei.WyWork.service.OrderService;
import com.waterlufei.WyWork.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 查询所有订单信息
     * @return
     */
    @Override
    public List<OrderResponse> getOrdersInfo(){
        return orderMapper.getOrdersInfo();
    }

    /**
     * 新增订单,配合清空购物车使用
     * @return
     */
    @Override
    public void addOrder() {
        // 1.获得购物车中所有未结算商品的详细信息
        List<ShoppingCartResponse> shoppingCartResponses = shoppingCartMapper.getNotPurchaseShoppingCartInfo();
        // 2.将购物车清空
        for (ShoppingCartResponse response : shoppingCartResponses){
            shoppingCartMapper.deleteShoppingCartGoods(response.getGoodsId());
        }
        // 3.将与购物车对应商品表中的商品设置为已购买
        for (ShoppingCartResponse response : shoppingCartResponses){
            GoodsInfoRequest request = new GoodsInfoRequest();
            request.setGoodsId(response.getGoodsId());
            request.setGoodsNum(response.getGoodsNum());
            goodsMapper.setGoodsPurchased(request);
        }
        // 4.新建订单信息
        OrderRequest orderRequest = new OrderRequest();
        for (ShoppingCartResponse response : shoppingCartResponses){
            // 根据goodsId查询商品的详细信息
            GoodsInfoRequest request = new GoodsInfoRequest();
            request.setGoodsId(response.getGoodsId());
            GoodsInfoResponse goodsInfoResponse = goodsMapper.getGoodsInfoByGoodsId(request);

            // 填写订单信息，新增订单信息
            orderRequest.setGoodsId(response.getGoodsId());
            orderRequest.setGoodsNum(response.getGoodsNum());
            orderRequest.setTitle(goodsInfoResponse.getTitle());
            orderRequest.setContent(goodsInfoResponse.getContent());
            orderRequest.setPicture(goodsInfoResponse.getPicture());
            orderRequest.setPrice(goodsInfoResponse.getPrice());
            orderRequest.setSummary(goodsInfoResponse.getSummary());
            orderMapper.addOrder(orderRequest);
        }
    }

    /**
     * 通过商品id查询订单信息
     * @param goodsId
     * @return
     */
    public List<OrderResponse> getOrdersInfoById(int goodsId){
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setGoodsId(goodsId);
        return orderMapper.getOrdersInfoById(orderRequest);
    }
}
