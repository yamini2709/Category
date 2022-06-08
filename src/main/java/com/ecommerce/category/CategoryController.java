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
import com.ecommerce.category.Category;
import com.ecommerce.category.CategoryServiceImpl;


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
	public Category getByCategoryId(@PathVariable int categoryId) {
		return categoryService.getByCategoryId(categoryId);
		
	}
	@GetMapping("/categories")
	public List<Category>getCategories(){
		return categoryService.getCategories();
	}
	
	@PutMapping("/updateCategory/{categoryId}")
	public Category editCategory(@PathVariable Integer categoryId,@RequestBody Category category) {
		return categoryService.editCategory(category);		
	}

	@DeleteMapping("/delCategory/{categoryId}")
	public String deleteCategory(@PathVariable Integer categoryId) {
		categoryService.deleteCategory(categoryId);
		return "Deleted Successfully";
	}	
	
	@DeleteMapping("/allCategories")
	public String deleteAllcategories() {
		categoryService.deleteAll();
		return "Deleted all Categories in the Database";
	}

}
