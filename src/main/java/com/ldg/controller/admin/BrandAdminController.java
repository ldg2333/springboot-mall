package com.ldg.controller.admin;

import com.ldg.dao.BaseDao;
import com.ldg.entity.Brand;
import com.ldg.service.BrandService;
import com.ldg.service.ProductService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("PBAdmin")
@CrossOrigin
public class BrandAdminController {

    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    @GetMapping("/getAllBrand")
    public ResultInfo getAllBrand(String brandName){
        try {
            List<Brand> brands = brandService.selectAllByName(brandName);
            return ResultInfo.success("查询成功",brands);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @GetMapping("/getBrandById")
    public ResultInfo getBrandById(Integer brandId){
        System.out.println("brandId:"+brandId);
        try {
            Brand brand = brandService.selectById(brandId);
            return ResultInfo.success("查询成功",brand);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @PostMapping("/updateBrand")
    public ResultInfo updateBrand(@RequestBody Brand brand){
        try {
            if(brandService.updateById(brand))
                return ResultInfo.success("修改成功");
            return ResultInfo.error("查询失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @PostMapping("/addBrand")
    public ResultInfo addBrand(@RequestBody Brand brand){
        try {
            if(brandService.insertData(brand))
                return ResultInfo.success("新增成功");
            return ResultInfo.error("新增失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("新增失败");
        }
    }

    @GetMapping("/existsBrand")
    public ResultInfo existsBrand(String productBrand){
        try {
            if(productService.existsProductBrand(productBrand))
                return ResultInfo.success("当前品牌存在商品，暂时无法删除");
            return ResultInfo.error("不存在商品");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("不存在商品");
        }
    }

    @DeleteMapping("/deleteBrand")
    public ResultInfo deleteBrand(Integer brandId){
        try {
            if(brandService.deleteById(brandId))
                return ResultInfo.success("删除成功");
            return ResultInfo.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("删除失败");
        }
    }

}
