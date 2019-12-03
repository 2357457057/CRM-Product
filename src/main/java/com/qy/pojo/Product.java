package com.qy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 轻语
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@NameStyle(Style.normal)
public class Product implements Serializable {

  private String id;
  private String productNum;
  private String productName;
  private String cityName;
  private java.sql.Timestamp departureTime;
  private BigDecimal productPrice;
  private String productDesc;
  private long productStatus;


}
