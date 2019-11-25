package com.qy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

  private String id;
  private String productNum;
  private String productName;
  private String cityName;
  private java.sql.Timestamp departureTime;
  private double productPrice;
  private String productDesc;
  private long productStatus;


}
