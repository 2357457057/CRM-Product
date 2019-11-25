package com.qy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author 轻语
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

  private String id;
  private String email;
  private String username;
  private String password;
  @Column(name = "phonenum")
  private String phoneNum;
  private long status;


}
