package com.majustory.k1.project;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository  
      extends CrudRepository<TBL_TEACHER_202201, String> 
      , QuerydslPredicateExecutor<TBL_TEACHER_202201> {

    	  
    	  
}
