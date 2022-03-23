package com.ldg.controller.admin;

import com.ldg.entity.Specs;
import com.ldg.service.SpecsService;
import com.ldg.utils.ResultInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("specsAdmin")
@CrossOrigin
public class SpecsAdminController {

    @Autowired
    private SpecsService specsService;

    @RequestMapping("/getAllSpecs")
    public ResultInfo getAllSpecs(){
        try {
            List<Specs> specs = specsService.selectAll();
            return ResultInfo.success("查询成功",specs);
        }catch (Exception e){
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/getAllSpecsByKey")
    public ResultInfo getAllSpecsByKey(String key){
        try {
            List<Specs> specs = specsService.selectAllByNAT(key);
            return ResultInfo.success("查询成功",specs);
        }catch (Exception e){
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/getSpecsById")
    public ResultInfo getSpecsById(Integer specsId){
        try {
            Specs specs = specsService.selectById(specsId);
            return ResultInfo.success("查询成功",specs);
        }catch (Exception e){
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/updateSpecsById")
    public ResultInfo updateSpecsById(@RequestBody Specs specs){
        try {
            if(specsService.updateById(specs))
                return ResultInfo.success("修改成功");
            return ResultInfo.error("修改失败");
        }catch (Exception e){
            return ResultInfo.error("修改失败");
        }
    }

    @RequestMapping("/addSpecs")
    public ResultInfo addSpecs(@RequestBody Specs specs){
        try {
            if(specsService.insertData(specs))
                return ResultInfo.success("新增成功");
            return ResultInfo.error("新增失败");
        }catch (Exception e){
            return ResultInfo.error("新增失败");
        }
    }

    @RequestMapping("/existSpecsName")
    public ResultInfo existSpecsName(@RequestBody Specs specs){
        try {
            if(specsService.existsWithName(specs.getSpecsName(),specs.getProductType()))
                return ResultInfo.success("已存在当前规格");
            return ResultInfo.error("规格不存在");
        }catch (Exception e){
            return ResultInfo.error("规格不存在");
        }
    }

    @RequestMapping("/isExistProduct")
    public ResultInfo isExistProduct(@Param("productType") String productType,@Param("specsId") Integer specsId ){
        try {
            if(specsService.isExistProduct(specsId, productType))
                return ResultInfo.success("存在商品");
            return ResultInfo.error("不存在商品");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("不存在商品");
        }
    }

    @DeleteMapping("/deleteSpecsById/{specsId}")
    public ResultInfo deleteSpecsById(@PathVariable("specsId") Integer specsId){
        try {
            if(specsService.deleteById(specsId))
                return ResultInfo.success("删除成功");
            return ResultInfo.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("删除失败");
        }
    }

}
