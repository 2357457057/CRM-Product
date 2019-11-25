package com.qy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Syslog implements Serializable {

  private String id;
  private java.sql.Timestamp visitTime;
  private String username;
  private String ip;
  private String url;
  private long executionTime;
  private String method;


}
