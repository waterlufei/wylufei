package com.waterlufei.WyWork.web;

import com.waterlufei.WyWork.Enum.ShoppingCartEnum;
import com.waterlufei.WyWork.service.ShoppingCartService;
import com.waterlufei.WyWork.vo.BaseResponse;
import com.waterlufei.WyWork.vo.ShoppingCartDetailedResponse;
import com.waterlufei.WyWork.vo.ShoppingCartRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购物车
 */
@RestController
@RequestMapping(value = "shoppingCart", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ShoppingCartController {

    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 加入购物车
     * @param shoppingCartRequest
     * @return
     */
    @RequestMapping(value = "/addShoppingCart", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse addShoppingCart(@RequestBody ShoppingCartRequest shoppingCartRequest){
        BaseResponse result = new BaseResponse();
        try{
            shoppingCartService.addShoppingCart(shoppingCartRequest);
            result.setCode(ShoppingCartEnum.SUCCESS.getCode());
            result.setMsg(ShoppingCartEnum.SUCCESS.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(ShoppingCartEnum.EXCEPTION.getCode());
            result.setMsg(ShoppingCartEnum.EXCEPTION.getMsg());
        }
        return result;
    }

    /**
     * 返回购物车列表详细信息
     * @return
     */
    @RequestMapping(value = "/getShoppingCartAllInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse getShoppingCartAllInfo(){
        BaseResponse result = new BaseResponse();
        try{
            List<ShoppingCartDetailedResponse> list =  shoppingCartService.getShoppingCartInfo();
            if (list.size() > 0){
                result.setCode(ShoppingCartEnum.SUCCESS.getCode());
                result.setMsg(ShoppingCartEnum.SUCCESS.getMsg());
                result.setData(list);
            }else {
                result.setCode(ShoppingCartEnum.SHOPPING_CART_EMPTY.getCode());
                result.setMsg(ShoppingCartEnum.SHOPPING_CART_EMPTY.getMsg());
            }
        }catch (Exception e){
            e.printStackTrace();
            result.setCode(ShoppingCartEnum.EXCEPTION.getCode());
            result.setMsg(ShoppingCartEnum.EXCEPTION.getMsg());
        }
        return result;
    }
}
