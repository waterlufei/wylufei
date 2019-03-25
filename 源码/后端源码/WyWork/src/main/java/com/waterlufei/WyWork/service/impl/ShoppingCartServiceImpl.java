package com.waterlufei.WyWork.service.impl;

import com.waterlufei.WyWork.mapper.GoodsMapper;
import com.waterlufei.WyWork.mapper.ShoppingCartMapper;
import com.waterlufei.WyWork.service.ShoppingCartService;
import com.waterlufei.WyWork.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 将商品添加到购物车
     * @param shoppingCartRequest
     */
    @Override
    public void addShoppingCart(ShoppingCartRequest shoppingCartRequest) {
        // 检查购物车中是否已经存在了此种商品,已经存在购物车商品就加一，不存在添加到购物车
        int goodsNum = shoppingCartMapper.findNumByGoodsId(shoppingCartRequest.getGoodsId());
        if (goodsNum > 0){
            shoppingCartMapper.goodsPlus(shoppingCartRequest.getGoodsId());
        }else {
            shoppingCartMapper.addShoppingCart(shoppingCartRequest);
        }
    }

    /**
     * 返回购物车中所有商品的详细信息
     * @return
     */
    @Override
    public List<ShoppingCartDetailedResponse> getShoppingCartInfo() {
        List<ShoppingCartDetailedResponse> shoppingCartResponseList = new ArrayList<>();
        List<ShoppingCartResponse> shoppingCartInfo = shoppingCartMapper.getNotPurchaseShoppingCartInfo();
        for (ShoppingCartResponse response:shoppingCartInfo){
            // 通过商品id获得商品信息
            GoodsInfoRequest request = new GoodsInfoRequest();
            request.setGoodsId(response.getGoodsId());
            GoodsInfoResponse goodsInfoResponse = goodsMapper.getGoodsInfoByGoodsId(request);
            // 填写购物车中商品的详细信息
            ShoppingCartDetailedResponse shoppingCartDetailedResponse = new ShoppingCartDetailedResponse();
            shoppingCartDetailedResponse.setGoodsId(response.getGoodsId());
            shoppingCartDetailedResponse.setGoodsNum(response.getGoodsNum());
            shoppingCartDetailedResponse.setPrice(goodsInfoResponse.getPrice());
            shoppingCartDetailedResponse.setTitle(goodsInfoResponse.getTitle());
            shoppingCartResponseList.add(shoppingCartDetailedResponse);
        }
        return shoppingCartResponseList;
    }
}
