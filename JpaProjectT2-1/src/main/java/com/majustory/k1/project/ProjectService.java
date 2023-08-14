package com.majustory.k1.project;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ProjectService {
  List<TBL_TEACHER_202201>  teacherList();
  
  List<TBL_MEMBER_202201>  memberList();
  List<TBL_CLASS_202201>   memberListJoin();
  
  List<ClassVO>  teacherMoneyList();
  
  void classFormOK(TBL_CLASS_202201  vo);
  
  void psdFormInsert(TBL_MEMBER_PSD  vo);
  
  
  Page<TBL_MEMBER_PSD>  psdList();
  
  Page<TBL_MEMBER_PSD>  psdList2(TBL_MEMBER_PSD vo);
}
