package com.ecommerce.category;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class CategoryServiceImpl {
	@Autowired
	CategoryRepository categoryRepository;

	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public Category getByCategoryId(int categoryId) {
		List<Category>categories = categoryRepository.findAll();
		Category category = null;
		for(Category cat:categories) {
			if(cat.getCategoryId()==categoryId)
				category=cat;
		}
		return category;
	}
	
	public Category editCategory(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	public void deleteCategory(Integer categoryId) {
		categoryRepository.deleteById(categoryId);
	}
}



