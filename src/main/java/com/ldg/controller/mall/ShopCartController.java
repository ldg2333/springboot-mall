package com.ldg.controller.mall;

import com.ldg.entity.ShopCart;
import com.ldg.service.ShopCartService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shopCart")
@CrossOrigin
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;

    @RequestMapping(value = "/shopCartAmount",method = RequestMethod.GET)
    public ResultInfo getShopCartAmount(Integer userId){
        try {
            int selectAmount = shopCartService.selectAmount(userId);
            return ResultInfo.success("查询成功",selectAmount);
        }catch (Exception e){
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping(value = "/getAllShopCart",method = RequestMethod.GET)
    public ResultInfo getAllShopCart(Integer userId){
        List<Map<String, Object>> list = shopCartService.selectAll(userId);
        return ResultInfo.success("查询成功",list);
    }

    @RequestMapping(value = "/update")
    public ResultInfo updateShopCart(@RequestBody ShopCart shopCart) {
        if(shopCartService.updateById(shopCart)){
            return ResultInfo.success("购物车修改成功",shopCartService.selectById(shopCart.getCartId()));
        }else{
            return ResultInfo.error("购物车修改失败");
        }
    }

    @RequestMapping(value = "/delete")
    public ResultInfo deleteShopCart(Integer cartId) {
        if(shopCartService.deleteById(cartId)){
            return ResultInfo.success("删除成功");
        }else{
            return ResultInfo.error("删除失败");
        }
    }

    @RequestMapping(value = "/add")
    public ResultInfo addShopCart(@RequestBody ShopCart shopCart) {
        System.out.println(shopCart);
        if(shopCartService.existProductSpecs(shopCart) != null){
            ShopCart shopCart1 = shopCartService.existProductSpecs(shopCart);
            // 将两者的值加起来即可
            shopCart1.setPayAmount(shopCart.getPayAmount()+shopCart1.getPayAmount());
            if(shopCartService.updateById(shopCart1))
                return ResultInfo.success("购物车修改成功",shopCartService.selectById(shopCart1.getCartId()));
        }
        if(shopCartService.insertData(shopCart)){
            return ResultInfo.success("加入购物车成功");
        }else{
            return ResultInfo.error("加入购物车失败");
        }
    }
}
