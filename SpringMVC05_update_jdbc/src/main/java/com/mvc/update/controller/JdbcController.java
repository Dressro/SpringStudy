package com.mvc.update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.update.model.biz.JdbcBiz;
import com.mvc.update.model.dto.JdbcDto;

@Controller
public class JdbcController {

	@Autowired
	private JdbcBiz biz;

	@RequestMapping("/list.do")
	public String selectList(Model model) {

		model.addAttribute("list", biz.selectList());

		return "jdbclist";
	}

	@RequestMapping("/insertform.do")
	public String MyBoardInsertForm() {
		return "jdbcinsert";
	}

	@RequestMapping("/insertres.do")
	public String MyBoardInsertRes(JdbcDto dto) {
		if (biz.insert(dto) > 0) {
			return "redirect:list.do";
		}
		return "redirect:insertform.do";
	}

	@RequestMapping("/select.do")
	public String MyBoardSelect(Model model, int seq) {
		model.addAttribute("dto", biz.selectOne(seq));

		return "jdbcselect";
	}

	@RequestMapping("/delete.do")
	public String MyBoardDelete(int seq) {
		if (biz.delete(seq) > 0) {
			return "redirect:list.do";
		}
		return "redirect:select.do?seq=" + seq;
	}

	@RequestMapping("/updateform.do")
	public String MyBoardUpdateForm(Model model, int seq) {
		model.addAttribute("dto", biz.selectOne(seq));

		return "jdbcupdate";
	}

	@RequestMapping("/updateres.do")
	public String MyBoardUpdateRes(JdbcDto dto) {
		if (biz.update(dto) > 0) {
			return "redirect:select.do?seq=" + dto.getSeq();
		}
		return "redirect:updateform.do?seq=" + dto.getSeq();
	}

}
