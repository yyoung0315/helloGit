package com.majustory.k1.project;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository  
    extends CrudRepository<TBL_MEMBER_202201, String> 
    , QuerydslPredicateExecutor<TBL_MEMBER_202201> {

}
