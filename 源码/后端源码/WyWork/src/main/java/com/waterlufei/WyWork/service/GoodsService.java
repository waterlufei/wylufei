package com.waterlufei.WyWork.service;

import com.waterlufei.WyWork.vo.GoodsInfoRequest;
import com.waterlufei.WyWork.vo.GoodsInfoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoodsService {

    /**
     * 卖家发布商品
     */
    int increaseGoods(GoodsInfoRequest goodsInfoRequest);

    /**
     * 买家查询未购买商品的信息
     */
    List<GoodsInfoResponse> getNotPurchaseGoodsInfo();


    /**
     * 查询所有商品信息
     */
    List<GoodsInfoResponse> getGoodsInfo();


    /**
     * 通过id删除某个商品
     */
    int deleteGoods(int id);

    /**
     * 修改商品信息
     * @param goodsInfoRequest
     * @return
     */
    int changeGoodsInfo(GoodsInfoRequest goodsInfoRequest);

    /**
     * 通过id查询商品的详细信息
     * @param goodsId
     * @return
     */
    GoodsInfoResponse getGoodsInfoByGoodsId(int goodsId);

}
