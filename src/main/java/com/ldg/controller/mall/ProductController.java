package com.ldg.controller.mall;

import com.ldg.entity.Brand;
import com.ldg.entity.Product;
import com.ldg.entity.ProductType;
import com.ldg.service.BrandService;
import com.ldg.service.ProductService;
import com.ldg.service.ProductTypeService;
import com.ldg.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;


    /**
     * 根据 id 查询商品
     * @param productId 商品id
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findById")
    public ResultInfo findById(Integer productId) {
        Product product = productService.selectById(productId);
        if (product != null) {
            return ResultInfo.success("商品查询成功", product);
        } else {
            return ResultInfo.error("商品查询失败");
        }
    }

    /**
     * 根据 商品编号 查询
     * @param productNo 商品编号
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findByProductNo")
    public ResultInfo findByProductNo(String productNo) {
        Product product = productService.selectByKey(productNo);
        if (product != null) {
            return ResultInfo.success("商品查询成功", product);
        } else {
            return ResultInfo.error("商品查询失败");
        }
    }

    /**
     * 通过 商品编号 查Id
     * @param productNo 商品编号
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findIdByProductNo")
    public ResultInfo findIdByProductNo(String productNo) {
        Integer productId = productService.selectIdByKey(productNo);
        if (productId != null) {
            return ResultInfo.success("商品id查询成功", productId);
        } else {
            return ResultInfo.error("商品id查询失败");
        }
    }

    /**
     * 查询商品总数
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findCount")
    public ResultInfo findCount() {
        Integer count = productService.selectCount();
        if (count != null) {
            return ResultInfo.success("商品数量查询成功", count);
        } else {
            return ResultInfo.error("商品数量查询失败");
        }
    }

    /**
     * 根据 商品编号判断商品是否存在
     * @param productNo 商品编号
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/existsProductNo")
    public ResultInfo existsProductNo(String productNo) {
        Boolean isExist = productService.existsWithPrimaryKey(productNo);
        if (isExist != null) {
            return ResultInfo.success("商品是否存在查询成功", isExist);
        } else {
            return ResultInfo.error("商品是否存在查询失败");
        }
    }

    /**
     * 根据商品类型判断商品是否存在
     * @param productType 商品类别
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/existsProductType")
    public ResultInfo existsProductType(String productType) {
        Boolean isExist = productService.existsProductType(productType);
        if (isExist != null) {
            return ResultInfo.success("查询成功", isExist);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    /**
     * 根据 品牌 判断商品是否存在
     * @param productBrand 商品偏僻
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/existsProductBrand")
    public ResultInfo existsProductBrand(String productBrand) {
        Boolean isExist = productService.existsProductBrand(productBrand);
        if (isExist != null) {
            return ResultInfo.success("查询成功", isExist);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    /**
     * 查询所有商品
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAll")
    public ResultInfo findAll() {
        List<Product> products = productService.selectAll();
        if (products != null) {
            return ResultInfo.success("全部商品信息查询成功", products);
        } else {
            return ResultInfo.error("全部商品信息查询失败");
        }
    }

    /**
     * 查询所有商品
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAllByCon")
    public ResultInfo fineAllByCondition() {
        List<Product> products = productService.selectAll();
        if (products != null) {
            return ResultInfo.success("全部商品信息查询成功", products);
        } else {
            return ResultInfo.error("全部商品信息查询失败");
        }
    }

    /**
     * 查询所有商品
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAllNew")
    public ResultInfo findAllNew() {
        List<Product> products = productService.selectAllNew();
        if (products != null) {
            return ResultInfo.success("全部新品商品信息查询成功", products);
        } else {
            return ResultInfo.error("全部新品商品信息查询失败");
        }
    }

    /**
     * 查询所有上架商品 并按上架时间排序
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAllSale")
    public ResultInfo findAllSale() {
        List<Product> products = productService.selectAllSale();
        if (products != null) {
            return ResultInfo.success("全部在售商品信息查询成功", products);
        } else {
            return ResultInfo.error("全部在售商品信息查询失败");
        }
    }

    /**
     * 根据 商品名称 模糊查询
     * @param keyWord 搜索关键字
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAllLikeName")
    public ResultInfo findAllLikeName(String keyWord) {
        if(keyWord == null){
            keyWord = "";
        }
        List<Product> products = productService.selectAllLikeName(keyWord);
        if (products != null) {
            return ResultInfo.success("全部商品信息查询成功", products);
        } else {
            return ResultInfo.error("全部商品信息查询失败");
        }
    }

    /**
     * 根据 商品类别 模糊查询
     * @param keyWord 搜索关键字
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAllLikeType")
    public ResultInfo findAllLikeType(String keyWord) {
        if(keyWord == null){
            keyWord = "";
        }
        List<Product> products = productService.selectAllLikeType(keyWord);
        if (products != null) {
            return ResultInfo.success("全部商品信息查询成功", products);
        } else {
            return ResultInfo.error("全部商品信息查询失败");
        }
    }

    @RequestMapping(value = "/findAllLikeKeyWord")
    public ResultInfo findAllLikeKeyWord(String keyWord) {
        if(keyWord == null){
            keyWord = "";
        }
        List<Product> products = productService.selectAllLikeKeyWord(keyWord);
        if (products != null) {
            return ResultInfo.success("全部商品信息查询成功", products);
        } else {
            return ResultInfo.error("全部商品信息查询失败");
        }
    }

    /**
     * 根据 商品品牌 模糊查询
     * @param keyWord 搜索关键字
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAllLikeBrand")
    public ResultInfo findAllLikeBrand(String keyWord) {
        if(keyWord == null){
            keyWord = "";
        }
        List<Product> products = productService.selectAllLikeBrand(keyWord);
        if (products != null) {
            return ResultInfo.success("全部商品信息查询成功", products);
        } else {
            return ResultInfo.error("全部商品信息查询失败");
        }
    }

    /**
     * 根据 商品类别 查询全部
     * @return ResultInfo 结果集
     */
    @RequestMapping(value = "/findAllByType")
    public ResultInfo findAllByType() {
        List<Map<String, Object>> maps = productService.selectAllByType();
        if (maps != null) {
            return ResultInfo.success("商品分类信息查询成功", maps);
        } else {
            return ResultInfo.error("商品分类信息查询失败");
        }
    }

    /*
    @RequestMapping(value = "/product/add")
    public ResultInfo add(Product product) {
        System.out.println(product);
        if (productService.insertData(product)) {
            return ResultInfo.success("添加商品成功", product);
        } else {
            return ResultInfo.error("添加商品失败");
        }
    }

    @RequestMapping(value = "/product/update")
    public ResultInfo update(Product product) {
        if (product.getIsNew() != null && product.getIsNew()) {
            product.setSaleTime(new Date());
        }
        if (productService.updateById(product)) {
            return ResultInfo.success("修改商品成功", product);
        } else {
            return ResultInfo.error("修改商品失败");
        }
    }

    @RequestMapping(value = "/product/delete")
    public ResultInfo delete(Integer productId) {
        if (productService.deleteById(productId)) {
            return ResultInfo.success("商品删除成功", "productId：" + productId);
        } else {
            return ResultInfo.error("商品删除失败");
        }
    }

    //*商品类别*//*
    @RequestMapping(value = "/productType/add")
    public ResultInfo addType(ProductType productType) {
        if (productTypeService.insertData(productType)) {
            return ResultInfo.success("商品分类添加成功", productType);
        } else {
            return ResultInfo.error("商品分类添加失败");
        }
    }

    @RequestMapping(value = "/productType/update")
    public ResultInfo updateType(ProductType productType) {
        if (productTypeService.updateById(productType)) {
            return ResultInfo.success("商品分类修改成功", productType);
        } else {
            return ResultInfo.error("商品分类修改失败");
        }
    }

    @RequestMapping(value = "/productType/deleteById")
    public ResultInfo deleteTypeById(Integer typeId) {
        if (productTypeService.deleteById(typeId)) {
            return ResultInfo.success("商品分类删除成功", "typeId: " + typeId);
        } else {
            return ResultInfo.error("商品分类删除失败");
        }
    }

    @RequestMapping(value = "/productType/deleteByName")
    public ResultInfo deleteTypeByName(String typeName) {
        if (productTypeService.deleteByName(typeName)) {
            return ResultInfo.success("商品分类删除成功", "typeName: " + typeName);
        } else {
            return ResultInfo.error("商品分类删除失败");
        }
    }



    *//*商品品牌*//*
    @RequestMapping(value = "/productBrand/add")
    public ResultInfo addBrand(ProductBrand productBrand) {
        if (productBrandService.insertData(productBrand)) {
            return ResultInfo.success("商品品牌添加成功", productBrand);
        } else {
            return ResultInfo.error("商品品牌添加失败");
        }
    }

    @RequestMapping(value = "/productBrand/update")
    public ResultInfo updateBrand(ProductBrand productBrand) {
        if (productBrandService.updateById(productBrand)) {
            return ResultInfo.success("商品品牌修改成功", productBrand);
        } else {
            return ResultInfo.error("商品品牌修改失败");
        }
    }

    @RequestMapping(value = "/productBrand/deleteById")
    public ResultInfo deleteBrandById(Integer brandId) {
        if (productBrandService.deleteById(brandId)) {
            return ResultInfo.success("商品品牌删除成功", "brandId: " + brandId);
        } else {
            return ResultInfo.error("商品品牌删除失败");
        }
    }

    @RequestMapping(value = "/productBrand/deleteByName")
    public ResultInfo deleteBrandByName(String brandName) {
        if (productBrandService.deleteByName(brandName)) {
            return ResultInfo.success("商品品牌删除成功", "brandName: " + brandName);
        } else {
            return ResultInfo.error("商品品牌删除失败");
        }
    }

    */

    @RequestMapping(value = "/productType/existsTypeName")
    public ResultInfo existsTypeName(Integer typeId, String typeName) {
        Boolean isExist = productTypeService.existsWithTypeName(typeId, typeName);
        if (isExist != null) {
            return ResultInfo.success("查询成功", isExist);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping(value = "/productType/findAll")
    public ResultInfo findAllType() {
        List<ProductType> productTypes = productTypeService.selectAll();
        if (productTypes != null) {
            return ResultInfo.success("商品分类查询成功", productTypes);
        } else {
            return ResultInfo.error("商品分类查询失败");
        }
    }

    @RequestMapping(value = "/productType/findAllName")
    public ResultInfo findAllTypeName() {
        List<String> names = productTypeService.selectAllName();
        if (names != null) {
            return ResultInfo.success("商品分类名称查询成功", names);
        } else {
            return ResultInfo.error("商品分类名称查询失败");
        }
    }

    @RequestMapping(value = "/findAllBrand")
    public ResultInfo findAllBrand() {
        List<Brand> productBrands = brandService.selectAll();
        if (productBrands != null) {
            return ResultInfo.success("商品品牌查询成功", productBrands);
        } else {
            return ResultInfo.error("商品品牌查询失败");
        }
    }

    @RequestMapping(value = "/existsBrandName")
    public ResultInfo existsBrandName(Integer brandId, String brandName) {
        Boolean isExist = brandService.existsWithBrandName(brandId, brandName);
        if (isExist != null) {
            return ResultInfo.success("查询成功", isExist);
        } else {
            return ResultInfo.error("查询失败");
        }
    }

    @RequestMapping(value = "/productBrand/findAllBrandName")
    public ResultInfo findAllBrandName() {
        List<String> names = brandService.selectAllName();
        if (names != null && !names.isEmpty()) {
            return ResultInfo.success("商品品牌名称查询成功", names);
        } else {
            return ResultInfo.error("商品品牌名称查询失败");
        }
    }
}
