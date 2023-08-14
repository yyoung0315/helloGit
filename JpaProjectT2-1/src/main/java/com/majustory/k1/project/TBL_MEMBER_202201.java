package com.majustory.k1.project;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude="classList")
@Entity  // 필수 
public class TBL_MEMBER_202201  {
   @Id
   private String C_NO ;
   private String C_NAME ;
   private String PHONE ;
   private String ADDRESS  ;
   private String GRADE  ;
   
   @OneToMany(mappedBy="member",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
   private  List<TBL_CLASS_202201> classList = new  ArrayList<TBL_CLASS_202201>();
   
}
