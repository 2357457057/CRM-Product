package com.qy.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @author 轻语
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@NameStyle(Style.normal)
@Table(name = "role")
public class Role implements Serializable {

  private String id;
  private String roleName;
  private String roleDesc;
  private List<Permission> permissions;



}
