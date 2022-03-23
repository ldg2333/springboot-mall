package com.ldg.controller.admin;

import com.ldg.entity.ProductSpecs;
import com.ldg.entity.Specs;
import com.ldg.service.ProductSpecsService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PSAdmin")
@CrossOrigin
public class ProductSpecsAdminController {

    @Autowired
    private ProductSpecsService productSpecsService;

    @RequestMapping("/addPSList")
    public ResultInfo addProductSpecsByList(@RequestBody List<ProductSpecs> list){
        System.out.println(list);
        if(productSpecsService.insertBatch(list)){
            return ResultInfo.success("新增成功");
        }
        return ResultInfo.error("新增失败");
    }
    @RequestMapping("/deletePSList")
    public ResultInfo deleteProductSpecsByList(@RequestBody List<ProductSpecs> list){
        if(productSpecsService.deleteBatch(list)){
            return ResultInfo.success("删除成功");
        }
        return ResultInfo.error("删除失败");
    }

    @RequestMapping("/selectTAndSByPId")
    public ResultInfo selectTAndSByPId(Integer productId){
        try {
            List<Specs> list = productSpecsService.selectTAndSByPId(productId);
            return ResultInfo.success("查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/selectTypeName")
    public ResultInfo selectTypeName(){
        try {
            List<String> list = productSpecsService.selectTypeName();
            return ResultInfo.success("查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

}
