package com.majustory.k1.project;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository   
    extends CrudRepository<TBL_CLASS_202201, Long> 
    , QuerydslPredicateExecutor<TBL_CLASS_202201> {
	  
    @Query(value="	select  T.TEACHER_CODE ,T.CLASS_NAME , T.TEACHER_NAME, SUM(C.TUITION) as  TUITION "
    		+ "	from TBL_MEMBER_202201 M join TBL_CLASS_202201 C on M.C_NO = C.C_NO "
    		+ "	join TBL_TEACHER_202201 T on T.TEACHER_CODE = C.TEACHER_CODE  "
    		+ "	group  by T.TEACHER_CODE ,T.CLASS_NAME , T.TEACHER_NAME "
    		+ "	order  by T.TEACHER_CODE asc ", nativeQuery=true)
    List<ClassVO> queryAnnotationTest();
    
    @Query(value="	select  T.TEACHER_CODE ,T.CLASS_NAME , T.TEACHER_NAME, SUM(C.TUITION) as  TUITION "
    		+ "	from TBL_MEMBER_202201 M join TBL_CLASS_202201 C on M.C_NO = C.C_NO "
    		+ "	join TBL_TEACHER_202201 T on T.TEACHER_CODE = C.TEACHER_CODE  "
    		+ "	group  by T.TEACHER_CODE ,T.CLASS_NAME , T.TEACHER_NAME "
    		+ "	order  by T.TEACHER_CODE asc ", nativeQuery=true)
    List<Object[]> queryAnnotationTest2();
}
