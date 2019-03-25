package com.waterlufei.WyWork.vo;

import java.math.BigDecimal;

public class OrderInfoResponse extends BaseResponse{
    private BigDecimal totalSum;

    public BigDecimal getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }
}
