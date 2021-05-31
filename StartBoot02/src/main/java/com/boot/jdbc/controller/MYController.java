package com.boot.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.jdbc.model.biz.MYBiz;
import com.boot.jdbc.model.dto.MYDto;

@Controller
@RequestMapping("/myboard")
public class MYController {

	@Autowired
	private MYBiz biz;
	
	@GetMapping("/list")
	public String selectList(Model model) {
		model.addAttribute("list", biz.selectList());
		return "myboardlist";
	}
	
	@GetMapping("/select")
	public String selectOne(Model model, int myno) {
		model.addAttribute("dto", biz.selectOne(myno));
		return "myboardselect";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "insertform";
	}
	
	@GetMapping("/insertres")
	public String insertres(MYDto dto) {
		
		if (biz.insert(dto) > 0) {
			return "redirect:list";
		}
		
		return "redirect:insert";
	}
	
	@GetMapping("/update")
	public String update(Model model, int myno) {
		
		model.addAttribute("dto", biz.selectOne(myno));
		
		return "updateform";
	}
	
	@GetMapping("/updateres")
	public String updateres(MYDto dto) {
		
		if (biz.update(dto) > 0) {
			return "redirect:select?myno="+dto.getMyno();
		}
		
		return "redirect:update?myno="+dto.getMyno();
	}
	
	@GetMapping("/delete")
	public String delete(int myno) {
		
		if (biz.delete(myno) > 0) {
			return "redirect:list";
		}
		
		return "redirect:select?myno"+myno;
	}
	
}
