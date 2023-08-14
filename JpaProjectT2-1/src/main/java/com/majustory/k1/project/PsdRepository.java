package com.majustory.k1.project;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PsdRepository  
    extends CrudRepository<TBL_MEMBER_PSD, String> 
    , QuerydslPredicateExecutor<TBL_MEMBER_PSD> {

		//List<TBL_MEMBER_PSD> OrderByNODesc();
		
		//교재 271P
		Page<TBL_MEMBER_PSD> OrderByNODesc(Pageable paging);
		
		//List<TBL_MEMBER_PSD> findTop5ByOrderByNODesc();
		
		@Query("select b from TBL_MEMBER_PSD b where b.GRADE like %?1% order by b.NO desc")
		List<TBL_MEMBER_PSD> queryAnnotation1(String str1);
		
		@Query("select b from TBL_MEMBER_PSD b where b.GRADE like %:str1% order by b.NO desc")
		List<TBL_MEMBER_PSD> queryAnnotation2(@Param("str1") String str1);
		
		@Query("select b.NO,b.NAME from TBL_MEMBER_PSD b where b.GRADE like %:str1% order by b.NO desc")
		List<Object[]> queryAnnotation3(@Param("str1") String str1);
		
		
		@Query(value = "select NO, NAME from TBL_MEMBER_PSD where GRADE like '%'||:str1||'%' order by NO desc" , nativeQuery=true)
		List<PsdVO> queryAnnotation4(@Param("str1") String str1);
		
		
}
