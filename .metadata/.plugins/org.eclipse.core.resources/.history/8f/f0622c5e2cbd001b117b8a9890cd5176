package com.mvc.upgrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.MyBoardBiz;
import com.mvc.upgrade.model.dto.MyBoardDto;

@Controller
public class MyBoardController {

	@Autowired
	private MyBoardBiz biz;

	@RequestMapping("/list.do")
	public String MyBoardList(Model model) {
		model.addAttribute("list", biz.selectList());

		return "myboardlist";
	}

	@RequestMapping("/insertform.do")
	public String MyBoardInsertForm() {
		return "myboardinsert";
	}

	@RequestMapping("/insertres.do")
	public String MyBoardInsertRes(MyBoardDto dto) {
		if (biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
		return "redirect:insertform.do";
	}

	@RequestMapping("/select.do")
	public String MyBoardSelect(Model model, int myno) {
		model.addAttribute("dto", biz.selectOne(myno));

		return "myboardselect";
	}

	@RequestMapping("/delete.do")
	public String MyBoardDelete(int myno) {
		if (biz.delete(myno) > 0) {
			return "redirect:list.do";
		}
		return "redirect:select.do?myno=" + myno;
	}

	@RequestMapping("/updateform.do")
	public String MyBoardUpdateForm(Model model, int myno) {
		model.addAttribute("dto", biz.selectOne(myno));

		return "myboardupdate";
	}

	@RequestMapping("/updateres.do")
	public String MyBoardUpdateRes(MyBoardDto dto) {
		if (biz.update(dto) > 0) {
			return "redirect:select.do?myno=" + dto.getMyno();
		}
		return "redirect:updateform.do?myno=" + dto.getMyno();
	}
}
