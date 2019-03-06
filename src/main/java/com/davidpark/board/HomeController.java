package com.davidpark.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.davidpark.board.member.Member;
import com.davidpark.board.member.MemberDao;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "generic";
	}

	@RequestMapping(value = "/list_view", method = RequestMethod.GET)
	public String listView() {
		return "generic";
	}
	
	@RequestMapping(value = "/photo_preview", method = RequestMethod.GET)
	public String photoPreview() {
		return "generic";
	}
	
	@RequestMapping(value = "/generic", method = RequestMethod.GET)
	public String generic() {
		return "generic";
	}
	
	@RequestMapping(value = "/elements", method = RequestMethod.GET)
	public String elements() {
		return "elements";
	}
}
