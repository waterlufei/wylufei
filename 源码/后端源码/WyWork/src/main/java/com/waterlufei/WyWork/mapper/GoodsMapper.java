package com.waterlufei.WyWork.mapper;

import com.waterlufei.WyWork.vo.GoodsInfoRequest;
import com.waterlufei.WyWork.vo.GoodsInfoResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    /**
     * 添加商品
     * @param goodsInfoRequest
     * @return
     */
    int increaseGoods(GoodsInfoRequest goodsInfoRequest);

    /**
     * 获得商品信息
     * @param goodsInfoRequest
     * @return
     */
    List<GoodsInfoResponse> getGoodsInfo(GoodsInfoRequest goodsInfoRequest);

    /**
     * 买家查询未购买商品的信息
     */
    List<GoodsInfoResponse> getNotPurchaseGoodsInfo();

    /**
     * 删除某个商品
     * @param goodsInfoRequest
     * @return
     */
    int deleteGoods(GoodsInfoRequest goodsInfoRequest);

    /**
     * 商品的详细信息
     * @param goodsInfoRequest
     * @return
     */
    GoodsInfoResponse getGoodsInfoByGoodsId(GoodsInfoRequest goodsInfoRequest);

    /**
     * 设置商品为已购买
     * @param goodsInfoRequest
     * @return
     */
    int setGoodsPurchased(GoodsInfoRequest goodsInfoRequest);

    /**
     * 修改商品信息
     * @param goodsInfoRequest
     * @return
     */
    int changeGoodsInfo(GoodsInfoRequest goodsInfoRequest);

}
