package com.mprribeiro.productms.resources;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mprribeiro.productms.entities.Category;
import com.mprribeiro.productms.repositories.CategoryRepository;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class CategoryRepositoryTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
	@DisplayName("Search for a category successfully")
	public void returnTrueWhenCategoryExists() throws Exception {
		
		Integer id = 1;
		Category category = new Category("Electronics");
		entityManager.persist(category);
		
		boolean exists = repository.existsById(id);
		
		Assertions.assertThat(exists).isTrue();

	}
	
	@Test
	@DisplayName("Search for a non-existent category")
	public void returnFalseWhenCategoryDoesntExist() throws Exception {
		
		Integer id = 1;
		
		boolean exists = repository.existsById(id);
		
		Assertions.assertThat(exists).isFalse();

	}
	
}
