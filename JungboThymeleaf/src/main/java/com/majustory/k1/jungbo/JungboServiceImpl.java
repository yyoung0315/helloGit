package com.majustory.k1.jungbo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JungboServiceImpl implements JungboService {

	@Autowired
	private JungboDao  dao;

	@Override
	public List<TeacherVO> tescherList() {
		return dao.tescherList();
	}

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public List<MoneyListVO> teacherMoneyList() {
		// TODO Auto-generated method stub
		return dao.teacherMoneyList();
	}

	@Override
	public void classFormInsert(ClassVO vo) {		
		dao.classFormInsert(vo);
	}
	
}
