package com.ecommerce.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryControllerTest {
	
	@Mock
	CategoryServiceImpl categoryService;
	
	@InjectMocks
	CategoryController controller;
	
	Category category;
	
	@Test
	public void test_saveCategory() {
		category=new Category(555, "clothes", new Date());
		when(categoryService.saveCategory(category)).thenReturn(category);
		assertEquals(category,categoryService.saveCategory(category));
	}
	
//	@Test
//	public void test_getByCategoryId() {
//		List<Category>allCategories=new ArrayList<Category>();
//		 allCategories.add(new Category(111, "Watches", new Date()));
//		 allCategories.add(new Category(22, "Laptop", new Date()));
//		 int categoryId = 111;
//		 categoryService.getByCategoryId(category);
//	}

	@Test
	public void test_updateCategory() {
		category=new Category(555, "watch", new Date());
		when(categoryService.editCategory(category)).thenReturn(category);
		assertEquals(category, categoryService.editCategory(category));
	}
	
	@Test
	public void test_getCategories() {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(11, "boat", new Date()));
		categories.add(new Category(22, "noise", new Date()));
		categories.add(new Category(33, "realme", new Date()));
		when(categoryService.getCategories()).thenReturn(categories);
		assertEquals(3, categoryService.getCategories().size());
	}
	
//	@Test
//	public void test_deleteCategory() {
//		Category category = new Category(11, "boat", new Date());
//		Integer categoryId = 11;
//		when(categoryService.deleteCategory(categoryId)).thenReturn(category);
//	}
}
