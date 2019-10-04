package com.example.demo.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**개발환경설정이 잘 되었는지 여부를 확인하기 위한 컨트롤러.
 * @author minhj
 *
 */
@Controller
public class CommonController {

	
	@RequestMapping(value = "welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "modaltest")
	public String modalTest() {
		return "tests/modaltest";
	}
}
