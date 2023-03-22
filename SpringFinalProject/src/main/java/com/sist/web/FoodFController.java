package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.*;
import com.sist.dao.*;
@Controller
// front : router(include)
/*
 *   vue => vue.component
 */
public class FoodFController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping("food/food_list.do")
   //?cno=
   public String food_list(int cno,Model model)
   {
	   model.addAttribute("cno", cno);
	   return "food/food_list";
   }
   
   @GetMapping("food/food_before_detail.do")
   public String food_before_detail(int fno,HttpServletResponse response,RedirectAttributes ra)
   {
	   Cookie cookie=new Cookie("spring_food"+fno, String.valueOf(fno));
	   cookie.setPath("/");
	   cookie.setMaxAge(60*60*24);
	   response.addCookie(cookie);
	   ra.addAttribute("fno", fno);
	   return "redirect:../food/food_detail.do";
   }
   
   @GetMapping("food/food_detail.do")
   public String food_detail(int fno,Model model)
   {
	   model.addAttribute("fno", fno);
	   return "food/food_detail";
   }
   
   @GetMapping("food/food_find.do")
   public String food_find()
   {
	   return "food/food_find";
   }
}