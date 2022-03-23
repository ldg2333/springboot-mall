package com.ldg.controller.mall;

import com.ldg.entity.ProductSpecs;
import com.ldg.entity.Specs;
import com.ldg.service.ProductSpecsService;
import com.ldg.service.SpecsService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ps")
@CrossOrigin
public class ProductSpecsController {

    @Autowired
    private SpecsService specsService;
    @Autowired
    private ProductSpecsService productSpecsService;

    /*根据id查询规格*/
    @RequestMapping(value = "/specs/findById")
    public ResultInfo findById(Integer specsId) {
        Specs specs = specsService.selectById(specsId);
        if (specs != null) {
            return ResultInfo.success("查询成功", specs);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    /*查询所有规格信息*/
    @RequestMapping(value = "/specs/findAll")
    public ResultInfo findAllSpecs() {
        List<Specs> specs = specsService.selectAll();
        if (specs != null) {
            return ResultInfo.success("查询成功", specs);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    // 查询是否存在当前规格名称
    @RequestMapping(value = "/specs/existsSpecsName")
    public ResultInfo existsSpecsName(Integer specsId, String specsName, String productType) {
        Boolean isExist = specsService.existsWithSpecsName(specsId, specsName, productType);
        if (isExist != null) {
            return ResultInfo.success("查询成功", isExist);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    // 查询所有类别
    @RequestMapping(value = "/specs/findAllByType")
    public ResultInfo findAllSpecsByType(String productType) {
        List<Specs> specs = specsService.selectAllByType(productType);
        if (specs != null) {
            return ResultInfo.success("查询成功", specs);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    /*        商品于规格对应的信息         */

    /*查询所有商品规格对应信息*/
    @RequestMapping(value = "/productSpecs/findAll")
    public ResultInfo findAll() {
        List<ProductSpecs> productSpecs = productSpecsService.selectAll();
        if (productSpecs != null) {
            return ResultInfo.success("查询成功", productSpecs);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    // 根据商品id查询所有对应的规格信息
    @RequestMapping(value = "/productSpecs/findAllByProId")
    public ResultInfo findAllByProId(Integer productId) {
        List<String> specsName = productSpecsService.selectAllByProId(productId);
        if (specsName != null) {
            return ResultInfo.success("查询成功", specsName);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

}
