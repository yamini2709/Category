package com.ecommerce.category;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {CategoryControllerTest.class})
public class CategoryControllerTest {
	
	@Mock
	CategoryServiceImpl service;
	
	@InjectMocks
	CategoryController controller;
	Category allData = new Category(1,"Mobiles",new Date());
	
	@Test
	public void saveCategory() {
		when(service.saveCategory(allData)).thenReturn(allData);
		assertEquals("Added Successfully", controller.saveCategory(allData));
	}
	
	@Test
	public void getCategories() {
		List<Category> allData = new ArrayList<Category>();
		allData.add(new Category(1, "Boat", new Date()));
		allData.add(new Category(2, "Noise", new Date()));
		when(service.getCategories()).thenReturn(allData);
		assertEquals(allData, controller.getCategories());
	}
	
	@Test
	public void getByCategoryId() {
		Integer categoryId = 1;
		controller.getByCategoryId(categoryId);
		when(service.getByCategoryId(categoryId)).thenReturn(allData);
		assertEquals(1, controller.getByCategoryId(categoryId).getCategoryId());
	}
	
	@Test
	public void editCategory() {
		Category category = new Category(3, "FireBolt", new Date());
		Integer categoryId=3;
		when(service.editCategory(category)).thenReturn(category);
		assertEquals(category, controller.editCategory(categoryId, category));
	}
	
	@Test
	public void deleteCategory() {
		Integer categoryId = 2;
		controller.deleteCategory(categoryId);
		verify(service, times(1)).deleteCategory(categoryId);
	}
	
	@Test
	public void deleteAll() {
		service.deleteAll();
		assertEquals("Deleted all Categories in the Database", controller.deleteAllcategories());
}
}

