package com.sist.food.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.food.dao.CategoryDAO;
import com.sist.food.entity.CategoryEntity;

@Controller
public class FoodController {
	@Autowired
	private CategoryDAO dao;
	
	@GetMapping("/")
	public String categoryListData(Model model)
	{
		List<CategoryEntity> list=dao.categoryListData();
		model.addAttribute("list",list);
		return "category";
	}
}
