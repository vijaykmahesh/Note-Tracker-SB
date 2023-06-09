package com.seleniumexpress.notetracker.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seleniumexpress.notetracker.model.Blog;
import com.seleniumexpress.notetracker.service.BlogService;
import com.seleniumexpress.notetracker.utils.DateUtils;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;

	@GetMapping(value = "/blog-home")
	public String showBlogPage(Model model) {

		if (!model.containsAttribute("blogObj")) {

			model.addAttribute("blogObj", new Blog());

		}

		log.info("Application name : ");

		return "blog";
	}

	@PostMapping(value = "/submit-blog")
	public String processBlog(@Valid @ModelAttribute("blogObj") Blog blog, BindingResult errors,
			RedirectAttributes redirectAttributes) {

		if (errors.hasErrors()) {

			redirectAttributes.addFlashAttribute("blogObj", blog);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.blogObj", errors);
			errors.getAllErrors().forEach(error -> log.info("error triggered -> {}", error));

			return "redirect:/blog-home";
		}

		//insert or update
				if (blog.getId() == 0) {
					log.info("perfoming insert opration");
					
					//insert
					blogService.save(blog);
				} else {
					
					log.info("perfoming update");
					
					//update
					//blogService.updateNote(note);
					
				}
				
				redirectAttributes.addFlashAttribute("blogObj", blog);

		return "redirect:/blog-list";
	}
	
	@GetMapping("/blog-list")
	public String blogList(Model model) {
		
		List<Blog> blogsList = blogService.findAll();
		
		model.addAttribute("blogsList", blogsList);
		
		return "my-blogs";
	}
	
	@GetMapping("/getBlogById")
	public String getBlogById(Model model, @RequestParam("id") int id) {
		
		Blog blog = blogService.findBlogById(id);
		
		Date blogDate = DateUtils.asDate(blog.getDate());
		
		model.addAttribute("blog", blog);
		model.addAttribute("blogDate", blogDate);
		
		
		return "blog-view";
	}

}
