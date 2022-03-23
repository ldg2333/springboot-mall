package com.ldg.controller.admin;

import com.alibaba.fastjson.JSON;
import com.ldg.entity.ProductType;
import com.ldg.service.ProductTypeService;
import com.ldg.utils.FileUtil;
import com.ldg.utils.MyFinal;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("PTAdmin")
@CrossOrigin
public class ProductTypeAdminController {

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("getTypeByName")
    public ResultInfo getAllTypeByName(String typeName){
        try {
            List<ProductType> list = productTypeService.selectAllByName(typeName);
            return ResultInfo.success("查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @GetMapping("getAllType")
    public ResultInfo getAllType(){
        try {
            List<ProductType> list = productTypeService.selectAll();
            return ResultInfo.success("查询成功",list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @GetMapping("getTypeById")
    public ResultInfo getTypeById(Integer typeId){
        try {
            ProductType productType = productTypeService.selectById(typeId);
            return ResultInfo.success("查询成功",productType);
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/deleteProductTypeUrl")
    public ResultInfo deleteProductTypeUrl(String preProductTypeUrl) {
        if (FileUtil.deleteFile(MyFinal.PRODUCT_TYPE_FILE_DIC, preProductTypeUrl) == 1) {//存在就删了
            return ResultInfo.success("删除成功");
        } else if (FileUtil.deleteFile(MyFinal.PRODUCT_TYPE_FILE_DIC, preProductTypeUrl) == 0) {
            return ResultInfo.error("文件删除失败");
        } else {
            return ResultInfo.error("文件不存在");
        }
    }

    @RequestMapping(value = "/updateProductTypeAndUrl")
    public ResultInfo updateProductTypeAndUrl(@RequestParam(value="file",required = false) MultipartFile file,@RequestParam(value="file2",required = false) MultipartFile file2, @RequestParam("productType") String productType) {
        ProductType p = JSON.parseObject(productType, ProductType.class);
        try {
            if(file != null){
                String fileName = file.getOriginalFilename();
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                String newFileName = FileUtil.getFileName() + suffixName;
                p.setTypeUrlLeft(MyFinal.PRODUCT_TYPE_URL + newFileName);
                p.setTypeUrlTop(null);
                FileUtil.uploadFile(file, MyFinal.PRODUCT_TYPE_FILE_DIC,newFileName);
            }
            if(file2 != null){
                String fileName2 = file2.getOriginalFilename();
                String suffixName2 = fileName2.substring(fileName2.lastIndexOf("."));
                String newFileName2 = FileUtil.getFileName() + suffixName2;
                p.setTypeUrlTop(MyFinal.PRODUCT_TYPE_URL + newFileName2);
                p.setTypeUrlLeft(null);
                FileUtil.uploadFile(file2, MyFinal.PRODUCT_TYPE_FILE_DIC,newFileName2);
            }
            productTypeService.updateById(p);
            return ResultInfo.success("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.error("修改失败");
        }
    }

    @RequestMapping(value = "/updateProductType")
    public ResultInfo updateProduct(@RequestBody ProductType productType) {
        if (productTypeService.updateById(productType)) {
            return ResultInfo.success("修改商品类型成功");
        } else {
            return ResultInfo.error("修改商品类型失败");
        }
    }

    @GetMapping("/isExistProduct")
    public ResultInfo isExistProduct(String productType){
        try {
            if(productTypeService.isExistProduct(productType))
                return ResultInfo.success("存在商品");
            return ResultInfo.error("不存在商品");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("不存在商品");
        }
    }

    @DeleteMapping("/deleteTypeById")
    public ResultInfo deleteTypeById(Integer typeId){
        try {
            if(productTypeService.deleteById(typeId))
                return ResultInfo.success("删除成功");
            return ResultInfo.error("删除失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultInfo.error("删除成功");
        }
    }

    @RequestMapping(value = "/addProductType")
    public ResultInfo addProduct(@RequestParam(value="file",required = false) MultipartFile file,@RequestParam(value="file2",required = false) MultipartFile file2,@RequestParam("productType") String productType) {
        ProductType p = JSON.parseObject(productType, ProductType.class);
        try {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String newFileName = FileUtil.getFileName() + suffixName;
            p.setTypeUrlLeft(MyFinal.PRODUCT_TYPE_URL + newFileName);
            FileUtil.uploadFile(file, MyFinal.PRODUCT_TYPE_FILE_DIC,newFileName);
            String fileName2 = file2.getOriginalFilename();
            String suffixName2 = fileName2.substring(fileName2.lastIndexOf("."));
            String newFileName2 = FileUtil.getFileName() + suffixName2;
            p.setTypeUrlTop(MyFinal.PRODUCT_TYPE_URL + newFileName2);
            FileUtil.uploadFile(file2, MyFinal.PRODUCT_TYPE_FILE_DIC,newFileName2);
            productTypeService.insertData(p);
            return ResultInfo.success("新增成功");

        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.error("新增失败");
        }
    }
}
