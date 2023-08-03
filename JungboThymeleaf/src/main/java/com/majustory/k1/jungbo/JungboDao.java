package com.majustory.k1.jungbo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JungboDao {
  List<TeacherVO> tescherList();
  List<MemberVO>  memberList();
  List<MoneyListVO> teacherMoneyList();
  
  void  classFormInsert(ClassVO vo);
}
