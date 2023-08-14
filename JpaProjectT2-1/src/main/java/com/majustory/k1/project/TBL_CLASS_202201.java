package com.majustory.k1.project;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.ToString;

@Data    
@Entity  
@ToString(exclude= {"teacher", "member"} )
@Table(name="TBL_CLASS_202201", uniqueConstraints= {@UniqueConstraint(columnNames= {"REGIST_MONTH","C_NO"})}) 
public class TBL_CLASS_202201 {
	
	@Id
	@GeneratedValue
	private  Long SEQ;
	
	@Column(name="C_NO" ,nullable=false)
	private String C_NO;
	
	@Column(name="TEACHER_CODE" ,nullable=false)
	private String TEACHER_CODE  ;

	
	private String REGIST_MONTH ;
		
	private String CLASS_AREA  ;
	private Long   TUITION  ;
	
	@ManyToOne   // F.K 제약조건 적용
    @JoinColumn(name="C_NO", referencedColumnName="C_NO",insertable=false,updatable=false)
    private  TBL_MEMBER_202201  member;
	
	
	@ManyToOne
    @JoinColumn(name="TEACHER_CODE",referencedColumnName="TEACHER_CODE",insertable=false,updatable=false)
    private  TBL_TEACHER_202201  teacher;


}
