package com.qy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qy.pojo.Product;
import com.qy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 轻语
 */
@Controller
public class ProductCtrl {
    @Autowired
    private ProductService productService;


    @RequestMapping("/product-list1")
    public ModelAndView getAllProduct(){

        ModelAndView mv = new ModelAndView("product-list1");
        PageHelper.startPage(0,2);
        List<Product> allProducts = productService.getAllProducts();
        PageInfo<Product> productPageInfo = new PageInfo<>(allProducts);
        mv.addObject("productList",productPageInfo.getList());
        return mv;
    }}
