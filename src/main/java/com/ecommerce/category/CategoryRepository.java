package com.ecommerce.category;
import com.ecommerce.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends MongoRepository<Category, Integer> {


}
