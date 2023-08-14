package com.majustory.k1;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.majustory.k1.project.PsdRepository;
import com.majustory.k1.project.PsdVO;
import com.majustory.k1.project.TBL_MEMBER_PSD;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryAnnotationTest1 {
	@Autowired
	private PsdRepository psdRepo;
	
	//@Test
	public void testAueryAnnotationTest2() {
		List<TBL_MEMBER_PSD> psdList = psdRepo.queryAnnotation2("V");
		System.out.println("검색결과");
		for(TBL_MEMBER_PSD m : psdList) {
			System.out.println("====> " + m.toString());
		}
		
	}
	
	//@Test
	public void testAueryAnnotationTest3() {
		List<Object[]> psdList = psdRepo.queryAnnotation3("V");
		System.out.println("검색결과");
		for(Object[] m : psdList) {
			System.out.println("====> " + m[0] +" , "+m[1]);
		}
	}
		
	@Test
	public void testAueryAnnotationTest4() {
		List<PsdVO> psdList = psdRepo.queryAnnotation4("V");
		System.out.println("검색결과");
		for(PsdVO m : psdList) {
			System.out.println("====> " + m.getNO() +" , "+m.getNAME());
		}
	}
}
