package com.waterlufei.WyWork.mapper;

import com.waterlufei.WyWork.vo.OrderRequest;
import com.waterlufei.WyWork.vo.OrderResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 获得订单信息
     * @return
     */
    List<OrderResponse> getOrdersInfo();

    /**
     * 新增订单
     * @param orderRequest
     * @return
     */
    int addOrder(OrderRequest orderRequest);


    /**
     * 通过订单id查询订单的详细信息
     * @param orderRequest
     * @return
     */
    List<OrderResponse> getOrdersInfoById(OrderRequest orderRequest);
}
