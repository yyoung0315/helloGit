package com.majustory.k1.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private TeacherRepository teacherRepo;

	@Autowired
	private ClassRepository classRepo;

	@Autowired
	private MemberRepository memberRepo;

	@Autowired
	private PsdRepository psdRepo;

	@Override
	public List<TBL_TEACHER_202201> teacherList() {
		return (List<TBL_TEACHER_202201>) teacherRepo.findAll();
	}

	@Override
	public void classFormOK(TBL_CLASS_202201 vo) {
		classRepo.save(vo);
	}

	@Override
	public List<TBL_MEMBER_202201> memberList() {
		return (List<TBL_MEMBER_202201>) memberRepo.findAll();
	}

	@Override
	public List<TBL_CLASS_202201> memberListJoin() {
		return (List<TBL_CLASS_202201>) classRepo.findAll();
	}

	@Override
	public List<ClassVO> teacherMoneyList() {

		return classRepo.queryAnnotationTest();
	}

	@Override
	public void psdFormInsert(TBL_MEMBER_PSD vo) {
		psdRepo.save(vo);

	}

	@Override
	public Page<TBL_MEMBER_PSD> psdList() {
		PageRequest paging = PageRequest.of(0, 5);
		return (Page<TBL_MEMBER_PSD>) psdRepo.OrderByNODesc(paging);
	}

	@Override
	public Page<TBL_MEMBER_PSD> psdList2(TBL_MEMBER_PSD vo) {
		BooleanBuilder builder = new BooleanBuilder();
		QTBL_MEMBER_PSD qPsd = QTBL_MEMBER_PSD.tBL_MEMBER_PSD;
		if(vo.getCh1()==null) {
			builder.and(qPsd.NO.like("%"+""+"%"));
		}else if(vo.getCh1().equals("NO")) {
			builder.and(qPsd.NO.like("%"+vo.getCh2()+"%"));
		}else if(vo.getCh1().equals("NAME")) {
			builder.and(qPsd.NAME.like("%"+vo.getCh2()+"%"));
		}else if(vo.getCh1().equals("PHONE")) {
			builder.and(qPsd.PHONE.like("%"+vo.getCh2()+"%"));
		}
		PageRequest paging = PageRequest.of(0, 5);
		Page<TBL_MEMBER_PSD> li = (Page<TBL_MEMBER_PSD>) psdRepo.findAll(builder,paging);
		return li;
	}

}
