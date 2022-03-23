package com.ldg.controller.admin;

import com.alibaba.fastjson.JSON;
import com.ldg.entity.Product;
import com.ldg.service.ProductService;
import com.ldg.utils.FileUtil;
import com.ldg.utils.MyFinal;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

@RequestMapping("productAdmin")
@RestController
@CrossOrigin
public class ProductAdminController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getProductInfo")
    public ResultInfo getProductInfo(){
        try {
            return ResultInfo.success("查询成功",productService.productInfo());
        }catch (Exception e){
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping("/addProduct")
    public ResultInfo addProduct(@RequestParam("file") MultipartFile file, @RequestParam("product") String product){
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        String newFileName = sdf.format(new Date()) + r.nextInt(100) + suffixName;
        Product p = JSON.parseObject(product, Product.class);
        p.setProductUrl(MyFinal.PRODUCT_URL + newFileName);
        p.setSaleTime(new Date());
        try {
            FileUtil.uploadFile(file, MyFinal.PRODUCT_FILE_URL,newFileName);
            productService.insertData(p);
            return ResultInfo.success("添加商品成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.error("添加商品失败");
        }

    }

    /**
     * 查询所有商品
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAllByCon")
    public ResultInfo fineAllByCondition(@RequestBody Map map) {
        for (Object key : map.keySet()) {
            if(map.get(key) != null && map.get(key).equals("")){
                map.put(key, null);
            }
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }
        Map<String,Object> m = new HashMap<>();
        List<Product> products = productService.selectAllByCondition(map);
        Integer productCount = productService.getProductCountByCon(map);
        m.put("products", products);
        m.put("productCount", productCount);
        if (products != null) {
            return ResultInfo.success("全部商品信息查询成功", m);
        } else {
            return ResultInfo.error("全部商品信息查询失败");
        }
    }

    @RequestMapping(value = "/updateProduct")
    public ResultInfo updateProduct(@RequestBody Product product) {
        if (productService.updateById(product)) {
            return ResultInfo.success("修改商品信息成功");
        } else {
            return ResultInfo.error("修改商品信息失败");
        }
    }

    @RequestMapping(value = "/updateProductAndUrl")
    public ResultInfo updateProductAndUrl(@RequestParam("file") MultipartFile file, @RequestParam("product") String product) {
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //生成文件名称通用方法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Random r = new Random();
        String newFileName = sdf.format(new Date()) + r.nextInt(100) + suffixName;
        Product p = JSON.parseObject(product, Product.class);
        p.setProductUrl(MyFinal.PRODUCT_URL + newFileName);
        try {
            FileUtil.uploadFile(file, MyFinal.PRODUCT_FILE_URL,newFileName);
            productService.updateById(p);
            return ResultInfo.success("商品图片上传成功", productService.selectById(p.getProductId()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResultInfo.error("商品图片上传失败");
        }
    }

    @RequestMapping("/deleteProductUrl")
    public ResultInfo deleteProductUrl(String preProductUrl) {
        if (FileUtil.deleteFile(MyFinal.PRODUCT_FILE_URL, preProductUrl) == 1) {//存在就删了
            return ResultInfo.success("删除成功");
        } else if (FileUtil.deleteFile(MyFinal.PRODUCT_FILE_URL, preProductUrl) == 0) {
            return ResultInfo.error("文件删除失败");
        } else {
            return ResultInfo.error("文件不存在");
        }
    }

    @RequestMapping("/updateProductState")
    public ResultInfo updateProductIsSale(@RequestParam("isSale")Integer isSale,@RequestParam("isNew")Integer isNew,@RequestParam("ids")List<Integer> ids) {
        System.out.println(isNew);
        System.out.println(isSale);
        System.out.println(ids);
        if(productService.updateIsSale(isSale, isNew,ids)){
            return ResultInfo.success("操作成功");
        }else{
            return ResultInfo.error("操作失败");
        }
    }

    @DeleteMapping("/deleteProduct")
    public ResultInfo deleteProduct(Integer productId) {
        if(productService.deleteById(productId)){
            return ResultInfo.success("删除成功");
        }
        return ResultInfo.error("删除失败");
    }
}
