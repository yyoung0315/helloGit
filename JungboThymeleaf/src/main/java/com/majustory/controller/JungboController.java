package com.majustory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.majustory.k1.jungbo.ClassVO;
import com.majustory.k1.jungbo.JungboServiceImpl;

@Controller
public class JungboController {
	JungboController(){
		System.out.println("===> JungboController 실행!!");
	}
	
	@Autowired
	private JungboServiceImpl  service;
	
	@GetMapping("index.do")
	String index() {
		
		return "index.html";
	}	
	
	@GetMapping("/teacher/teacherList.do")
	String teacherList(Model  model) {
		model.addAttribute("li", service.tescherList());
		return "teacher202201/teacherList.html";
	}
	
	@GetMapping("/class/classForm.do")
	String classForm(Model  model) {
		model.addAttribute("li2", service.memberList());
		model.addAttribute("li1", service.tescherList());
		return "class202201/classForm.html";
	}
	
	
	@PostMapping("/class/classFormOK.do")
	String classFormOK(Model  model, ClassVO vo) {

		service.classFormInsert(vo);
		
		return "index.html";
	}	
	
	@GetMapping("/member/memberList.do")
	String memberList(Model  model) {
		model.addAttribute("li", service.memberList());
		return "member202201/memberList.html";
	}
	
	@GetMapping("/admin/teacherMoneyList.do")
	String teacherMoneyList(Model  model) {
		model.addAttribute("li", service.teacherMoneyList());

		return "admin/teacherMoneyList.html";
	}
}
