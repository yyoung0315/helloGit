package com.majustory.k1.jungbo;

import java.util.List;

public interface JungboService {
  List<TeacherVO>	tescherList();
  List<MemberVO>  memberList();
  List<MoneyListVO> teacherMoneyList();
  
  void  classFormInsert(ClassVO vo);
}
