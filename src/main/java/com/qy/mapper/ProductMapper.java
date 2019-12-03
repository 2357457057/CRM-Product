package com.qy.mapper;

import com.qy.pojo.Product;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;
import tk.mybatis.mapper.common.Mapper;

import javax.persistence.Table;

/**
 * @author 轻语
 */
@Component
public interface ProductMapper extends Mapper<Product> {

}
