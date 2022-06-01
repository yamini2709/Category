package com.ecommerce.category;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")

public class Category {
	@Id
	@Indexed( unique=true )
	private Integer categoryId;
	private String categoryName;
	private Date datePosted=new Date();

	public Category(Integer categoryId, String categoryName, Date datePosted) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.datePosted = datePosted;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getDatePosted() {
		return datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}

}



