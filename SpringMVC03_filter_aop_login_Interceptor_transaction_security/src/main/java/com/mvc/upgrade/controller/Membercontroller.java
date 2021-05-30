package com.mvc.upgrade.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;

@Controller
public class Membercontroller {

	private Logger logger = LoggerFactory.getLogger(Membercontroller.class);

	@Autowired
	private MemberBiz biz;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/loginform.do")
	public String LoginForm() {
		logger.info("[Controller] loginform.do");
		return "memberlogin";
	}

	@ResponseBody
	@RequestMapping(value = "/ajaxlogin.do", method = RequestMethod.POST)
	public Map<String, Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session) {
		logger.info("[Controller] ajaxlogin.do");

		MemberDto res = biz.login(dto);
		boolean check = false;

		if (res != null) {
			if (passwordEncoder.matches(dto.getMemberpw(), res.getMemberpw())) {
				check = true;
				session.setAttribute("login", res);
			}
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("check", check);

		return map;
	}

	@RequestMapping("/memberinsertform.do")
	public String registForm() {
		logger.info("[Controller] registform.do");
		return "registform";
	}

	@RequestMapping("/registres.do")
	public String registRes(MemberDto dto) {
		logger.info("[Controller] registres.do");

		/*
		 * 따로 파일에다가 dto.getid / dto.getpw 해서 암호화 안된 개인정보 넣을 수 있다!
		 * 하지만 하면 안된다.
		 * 
		 */
		System.out.println("암호화 전 : " + dto.getMemberpw());
		dto.setMemberpw(passwordEncoder.encode(dto.getMemberpw()));
		System.out.println("암호화 후 : " + dto.getMemberpw());
		if (biz.insert(dto) > 0) {
			return "redirect:loginform.do";
		}

		return "redirect:memberinsertform.do";
	}
}
