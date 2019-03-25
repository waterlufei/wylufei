package com.waterlufei.WyWork.mapper;

import com.waterlufei.WyWork.vo.ShoppingCartRequest;
import com.waterlufei.WyWork.vo.ShoppingCartResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 加入购物车
     * @return
     */
    int addShoppingCart(ShoppingCartRequest shoppingCartRequest);

    /**
     * 查找购物车中商品的数量
     * @param goodsId
     * @return
     */
    int findNumByGoodsId(int goodsId);

    /**
     * 购物车商品数量加一
     * @param goodsId
     * @return
     */
    int goodsPlus(int goodsId);

    /**
     * 得到购物车中未结算商品的信息
     * @return
     */
    List<ShoppingCartResponse> getNotPurchaseShoppingCartInfo();

    /**
     * 从购物车中移除某个商品
     * @param goodsId
     * @return
     */
    int deleteShoppingCartGoods(int goodsId);
}
