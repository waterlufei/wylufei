package com.waterlufei.WyWork.web;

import com.waterlufei.WyWork.Enum.OrderEnum;
import com.waterlufei.WyWork.service.OrderService;
import com.waterlufei.WyWork.vo.BaseResponse;
import com.waterlufei.WyWork.vo.OrderInfoResponse;
import com.waterlufei.WyWork.vo.OrderResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * 订单
 */
@RestController
@RequestMapping(value = "order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 买家查看已完成的订单信息
     * @return
     */
    @RequestMapping(value = "/getOrdersInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public OrderInfoResponse getOrdersInfo(){
        OrderInfoResponse result = new OrderInfoResponse();
        try{
            List<OrderResponse> ordersInfo = orderService.getOrdersInfo();
                if (ordersInfo.size() > 0){
                    result.setCode(OrderEnum.SUCCESS.getCode());
                    result.setMsg(OrderEnum.SUCCESS.getMsg());
                    result.setData(ordersInfo);
                    BigDecimal totalSum = new BigDecimal("0");
                    for (OrderResponse orderResponse : ordersInfo){
                    BigDecimal goodsNum = new BigDecimal(orderResponse.getGoodsNum());
                    totalSum = totalSum.add(orderResponse.getPrice().multiply(goodsNum));
                }
                result.setTotalSum(totalSum);
            }else {
                result.setCode(OrderEnum.QUERY_ORDERS_EMPTY.getCode());
                result.setMsg(OrderEnum.QUERY_ORDERS_EMPTY.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(OrderEnum.EXCEPTION.getCode());
            result.setMsg(OrderEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 添加订单
     * @return
     */
    @RequestMapping(value = "/addOrder", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse addOrder(){
        BaseResponse result = new BaseResponse();
        try{
            orderService.addOrder();
            result.setCode(OrderEnum.SUCCESS.getCode());
            result.setMsg(OrderEnum.SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(OrderEnum.EXCEPTION.getCode());
            result.setMsg(OrderEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 通过商品id查询订单信息，返回最新一条订单信息
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/getOrdersInfoByGoodsId", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse getOrdersInfoById(@RequestParam("goodsId") int goodsId){
        BaseResponse result = new BaseResponse();
        try{
            List<OrderResponse> orderResponses = orderService.getOrdersInfoById(goodsId);
            if (orderResponses.size() > 0){
                result.setData(orderResponses.get(orderResponses.size() - 1));
                result.setCode(OrderEnum.SUCCESS.getCode());
                result.setMsg(OrderEnum.SUCCESS.getMsg());
            }else {
                result.setCode(OrderEnum.QUERY_ORDERS_EMPTY.getCode());
                result.setMsg(OrderEnum.QUERY_ORDERS_EMPTY.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(OrderEnum.EXCEPTION.getCode());
            result.setMsg(OrderEnum.EXCEPTION.getMsg());
        }
        return result;
    }
}
