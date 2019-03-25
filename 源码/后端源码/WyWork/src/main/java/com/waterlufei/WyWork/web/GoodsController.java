package com.waterlufei.WyWork.web;

import com.waterlufei.WyWork.Enum.GoodsEnum;
import com.waterlufei.WyWork.service.GoodsService;
import com.waterlufei.WyWork.vo.BaseResponse;
import com.waterlufei.WyWork.vo.GoodsInfoRequest;
import com.waterlufei.WyWork.vo.GoodsInfoResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品
 */
@RestController
@RequestMapping(value = "goods", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    /**
     * 卖家发布商品
     * @param goodsInfoRequest
     * @return
     */
    @RequestMapping(value = "/increaseGoods", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse increaseGoods(@RequestBody GoodsInfoRequest goodsInfoRequest){
        BaseResponse result = new BaseResponse();
        try{
            int isNotInsert = goodsService.increaseGoods(goodsInfoRequest);
            if (isNotInsert == 1){
                result.setCode(GoodsEnum.SUCCESS.getCode());
                result.setMsg(GoodsEnum.SUCCESS.getMsg());
                Map<String,Object> map = new HashMap<>();
                map.put("goodsId",goodsInfoRequest.getGoodsId());
                result.setData(map);
            }else {
                result.setCode(GoodsEnum.INCREASE_FAIL.getCode());
                result.setMsg(GoodsEnum.INCREASE_FAIL.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(GoodsEnum.EXCEPTION.getCode());
            result.setMsg(GoodsEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 查询用户未购买的商品信息
     * @return
     */
    @RequestMapping(value = "/getNotPurchaseGoodsInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse getNotPurchaseGoodsInfo(){
        BaseResponse result = new BaseResponse();
        try{
            List<GoodsInfoResponse> goodsInfo = goodsService.getNotPurchaseGoodsInfo();
            if (goodsInfo.size() > 0){
                result.setCode(GoodsEnum.SUCCESS.getCode());
                result.setMsg(GoodsEnum.SUCCESS.getMsg());
                result.setData(goodsInfo);
            }else {
                result.setCode(GoodsEnum.NOT_PURCHASE_GOODS_EMPTY.getCode());
                result.setMsg(GoodsEnum.NOT_PURCHASE_GOODS_EMPTY.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(GoodsEnum.EXCEPTION.getCode());
            result.setMsg(GoodsEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 通过商品id删除某个商品
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteGoods", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse deleteGoods(@RequestParam("goodsId") int id){
        BaseResponse result = new BaseResponse();
        try{
            int deleteAnswer = goodsService.deleteGoods(id);
            if (deleteAnswer == 1){
                result.setCode(GoodsEnum.SUCCESS.getCode());
                result.setMsg(GoodsEnum.SUCCESS.getMsg());
            }else {
                result.setCode(GoodsEnum.DELETE_FAIL.getCode());
                result.setMsg(GoodsEnum.DELETE_FAIL.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(GoodsEnum.EXCEPTION.getCode());
            result.setMsg(GoodsEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 查询所有商品信息
     * @return
     */
    @RequestMapping(value = "/getGoodsInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse getGoodsInfo(){
        BaseResponse result = new BaseResponse();
        try{
            List<GoodsInfoResponse> goodsInfo = goodsService.getGoodsInfo();
            if (goodsInfo.size() > 0){
                result.setCode(GoodsEnum.SUCCESS.getCode());
                result.setMsg(GoodsEnum.SUCCESS.getMsg());
                result.setData(goodsInfo);
            }else {
                result.setCode(GoodsEnum.GOODS_EMPTY.getCode());
                result.setMsg(GoodsEnum.GOODS_EMPTY.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(GoodsEnum.EXCEPTION.getCode());
            result.setMsg(GoodsEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 修改商品信息
     * @param goodsInfoRequest
     * @return
     */
    @RequestMapping(value = "/changeGoodsInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse changeGoodsInfo(@RequestBody GoodsInfoRequest goodsInfoRequest){
        BaseResponse result = new BaseResponse();
        try{
            int changeAnswer = goodsService.changeGoodsInfo(goodsInfoRequest);
            if (changeAnswer > 0){
                result.setCode(GoodsEnum.SUCCESS.getCode());
                result.setMsg(GoodsEnum.SUCCESS.getMsg());
            }else {
                result.setCode(GoodsEnum.CHANGE_ZERO.getCode());
                result.setMsg(GoodsEnum.CHANGE_ZERO.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(GoodsEnum.EXCEPTION.getCode());
            result.setMsg(GoodsEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 通过商品id查询商品的详细信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/getGoodsInfoByGoodsId", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse getGoodsInfoByGoodsId(@RequestParam("goodsId") int id){
        BaseResponse result = new BaseResponse();
        try{
            GoodsInfoResponse goodsInfoResponse = goodsService.getGoodsInfoByGoodsId(id);
            if (goodsInfoResponse!=null){
                result.setCode(GoodsEnum.SUCCESS.getCode());
                result.setMsg(GoodsEnum.SUCCESS.getMsg());
                result.setData(goodsInfoResponse);
            }else {
                result.setCode(GoodsEnum.GOODS_NOT_EXISTS.getCode());
                result.setMsg(GoodsEnum.GOODS_NOT_EXISTS.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(GoodsEnum.EXCEPTION.getCode());
            result.setMsg(GoodsEnum.EXCEPTION.getMsg());
        }
        return result;
    }

}
