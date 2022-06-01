package com.ecommerce.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryServiceTest {

	@Mock
	CategoryRepository repository;

	@InjectMocks
	CategoryServiceImpl service;	

	@Test
	public void saveCategory() {
		Category category = new Category(111, "Mobile", new Date());
		when(repository.save(category)).thenReturn(category);
		assertEquals(category, service.saveCategory(category));
	}	
	

	
	@Test
	public void getCategoriesTest() {
		List<Category> allCategories = new ArrayList<Category>();		
		allCategories.add(new Category(222, "Clothes", new Date()));
		allCategories.add(new Category(333, "Slippers", new Date()));
		when(repository.findAll()).thenReturn(allCategories);
		assertEquals(2, service.getCategories().size());
	}
	
	@Test
	public void editCategory() {
		Category category = new Category(22, "Laptop", new Date());
		when(repository.save(category)).thenReturn(category);
		assertEquals(category, service.editCategory(category));
	}
	
	@Test
	public void getByCategoryId() {
		List<Category>allCategories=new ArrayList<Category>();
		 allCategories.add(new Category(111, "Watches", new Date()));
		 allCategories.add(new Category(22, "Laptop", new Date()));
		 int categoryId = 111;
		 service.getByCategoryId(categoryId);
		 when(repository.findAll()).thenReturn(allCategories);
		 assertEquals(categoryId, service.getByCategoryId(categoryId).getCategoryId());
	}
	
	@Test
	public void deleteCategory() {
		Category category = new Category(111, "Watches", new Date());
		int categoryId = 111;
		service.deleteCategory(categoryId);
		verify(repository,times(1)).deleteById(111);
	}
	
}
