package com.qy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Traveller implements Serializable {

  private String id;
  private String name;
  private String sex;
  private String phoneNum;
  private long credentialsType;
  private String credentialsNum;
  private long travellerType;


}
