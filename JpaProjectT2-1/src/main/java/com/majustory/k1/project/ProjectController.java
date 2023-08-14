package com.majustory.k1.project;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletContext;

@Controller
public class ProjectController {

	String path="";
	
	@Autowired // 서블릿 주입하기
	private ServletContext servletContext;
	
	@Autowired
	private ProjectService  service;
	
	// @PostConstruct 어노테이션을 설정해놓은 
	// init 메소드는 WAS가 띄워질 때 실행된다. 
	@PostConstruct 
	public void init() {
		path = servletContext.getRealPath("/psd/files/");
		System.out.println("path:" + path);
	}
	
	
	@GetMapping("/index.do")
	void index() {  }
	
	@GetMapping("/teacher/teacherList.do")
	void teacherList(Model model) { 
	  	System.out.println("===> /teacher/teacherList.do ");
	  	model.addAttribute("li", service.teacherList());
	}
	
	@GetMapping("/class/classForm.do")
	void classForm( Model model) { 
		model.addAttribute("li2", service.memberList());
	  	model.addAttribute("li1", service.teacherList());
		
	}

	
	@PostMapping("/class/classFormOK.do")
	String classFormOK(TBL_CLASS_202201 vo ) {
        service.classFormOK(vo);		
		return "index.html";		
	}
	
	@GetMapping("/member/memberList.do")
	void memberList(Model model) { 		
		model.addAttribute("li", service.memberListJoin());
	}
	
	@GetMapping("/admin/teacherMoneyList.do")
	void teacherMoneyList(Model model) { 
		model.addAttribute("li", service.teacherMoneyList());
	}	

	@GetMapping("/psd/psdForm.do")
	void PsdForm() {}
	
	
	@PostMapping("/psd/PsdFormOK.do")
	String PsdFormOK(TBL_MEMBER_PSD vo ) throws Exception, IOException {
		
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime =new SimpleDateFormat("HHmmss");
		String timeStr=daytime.format(time);
		
		MultipartFile  file= vo.getFILE();
		String fileName = file.getOriginalFilename();
		
		File f=new File(path+fileName);
		if( !file.isEmpty()) {
			if (f.exists()) {
			  System.out.println("중복파일이 존재합니다. !!!"); 
			  // 파일명 : good.fi.gif
			  String onlyFileName =fileName.substring(0,fileName.lastIndexOf(".")); // good.fi 
			  String extension =fileName.substring(fileName.lastIndexOf(".")); // .gif
			  fileName=onlyFileName+"_"+timeStr+extension;
			}
					  
		} else {
			 fileName= "space.png"; // 첨부파일이 없어면 ...
		}
		
		file.transferTo(new File(path+ fileName ));
		
		vo.setFILENAME(fileName);
		
		service.psdFormInsert(vo);
		
		System.out.println("저장하기");
        		
		return "index.html";		
	}	
	
	@GetMapping("/psd/psdList.do")
	void psdList(Model model) { 
		
		model.addAttribute("pageInfo", service.psdList());
		model.addAttribute("li", service.psdList());
	}	
	
	@GetMapping("/psd/psdList2.do")
	void psdList2(Model model, TBL_MEMBER_PSD vo) { 
		model.addAttribute("li", service.psdList2(vo));
	}	
}