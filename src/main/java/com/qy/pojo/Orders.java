package com.qy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders implements Serializable {

  private String id;
  private String orderNum;
  private java.sql.Timestamp orderTime;
  private long peopleCount;
  private String orderDesc;
  private long payType;
  private long orderStatus;
  private String productId;
  private String memberId;
}
