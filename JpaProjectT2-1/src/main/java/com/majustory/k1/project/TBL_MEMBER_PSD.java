package com.majustory.k1.project;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity  // 필수 
public class TBL_MEMBER_PSD  {
   @Id   //필수 
   private String NO ;
   private String NAME ;
   private String PHONE ;
   private String ADDRESS  ;
   private String GRADE  ;
   private String FILENAME; // 파일명
   
   @Transient
   private MultipartFile FILE;  //실제파일
   
   @Transient
   private String ch1;
   @Transient
   private String ch2;
}
