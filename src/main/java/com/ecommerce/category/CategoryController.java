package com.ecommerce.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	@Autowired
	CategoryServiceImpl categoryService;

	@PostMapping("/addCategory")
	public String saveCategory(@RequestBody Category category) {
		categoryService.saveCategory(category);
		return "Added Successfully";
	}

	@GetMapping("/category-by-id/{categoryId}")
	public Category getByCategoryId(@PathVariable int categoyId) {
		return categoryService.getByCategoryId(categoyId);
		
	}
	@GetMapping("/categories")
	public List<Category>getCategories(){
		return categoryService.getCategories();
	}
	
	@PutMapping("/updateCategory/{categoryId}")
	public Category updateCategory(@PathVariable Integer categoryId,@RequestBody Category category) {
		category.setCategoryId(categoryId);
		return categoryService.editCategory(category);		
	}

	@DeleteMapping("/delCategory/{categoryId}")
	public String deleteCategory(@PathVariable Integer categoryId) {
		categoryService.deleteCategory(categoryId);
		return "Deleted Successfully";
	}
	
}
