package com.qy.service.impl;

import com.qy.mapper.ProductMapper;
import com.qy.pojo.Product;
import com.qy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author 轻语
 */
@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getAllProducts() {
        Example example = new Example(Product.class);
        example.orderBy("productNum");
        return productMapper.selectByExample(example);
    }
}
