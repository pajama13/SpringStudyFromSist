package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommendFController {
	@GetMapping("food/recommend.do")
	public String food_recommend()
	{
		return "recommend/recommend";
	}
}
