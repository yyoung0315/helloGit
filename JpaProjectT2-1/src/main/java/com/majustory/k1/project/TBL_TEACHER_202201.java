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
public class TBL_TEACHER_202201 {
	
 @Id	
 private String   TEACHER_CODE ;
 private String   TEACHER_NAME  ;
 private String   CLASS_NAME  ;
 private Long     CLASS_PRICE ;
 private String   TEACHAR_REGIST_DATE ;
 
 @OneToMany(mappedBy="teacher",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
 private  List<TBL_CLASS_202201> classList = new  ArrayList<TBL_CLASS_202201>();
 
}
