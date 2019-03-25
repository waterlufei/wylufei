package com.waterlufei.WyWork.service.impl;

import com.waterlufei.WyWork.mapper.GoodsMapper;
import com.waterlufei.WyWork.service.GoodsService;
import com.waterlufei.WyWork.vo.GoodsInfoRequest;
import com.waterlufei.WyWork.vo.GoodsInfoResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsMapper goodsMapper;

    /**
     * 卖家发布商品
     * @param goodsInfoRequest
     * @return
     */
    public int increaseGoods(GoodsInfoRequest goodsInfoRequest){
        return goodsMapper.increaseGoods(goodsInfoRequest);
    }

    /**
     * 买家查询未购买商品的信息
     * @return
     */
    public List<GoodsInfoResponse> getNotPurchaseGoodsInfo(){
        return goodsMapper.getNotPurchaseGoodsInfo();
    }

    /**
     * 查询所有商品信息
     * @return
     */
    public List<GoodsInfoResponse> getGoodsInfo(){
        GoodsInfoRequest request = new GoodsInfoRequest();
        return goodsMapper.getGoodsInfo(request);
    }

    /**
     * 通过id删除某个商品
     * @param goodsId
     * @return
     */
    @Override
    public int deleteGoods(int goodsId){
        GoodsInfoRequest request = new GoodsInfoRequest();
        request.setGoodsId(goodsId);
        return goodsMapper.deleteGoods(request);
    }

    /**
     * 修改商品信息
     * @param goodsInfoRequest
     * @return
     */
    @Override
    public int changeGoodsInfo(GoodsInfoRequest goodsInfoRequest) {
        int result = goodsMapper.changeGoodsInfo(goodsInfoRequest);
        return result;
    }

    /**
     * 通过id查询商品的详细信息
     * @param goodsId
     * @return
     */
    public GoodsInfoResponse getGoodsInfoByGoodsId(int goodsId){
        GoodsInfoRequest request = new GoodsInfoRequest();
        request.setGoodsId(goodsId);
        return goodsMapper.getGoodsInfoByGoodsId(request);
    }
}
