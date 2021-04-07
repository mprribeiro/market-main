package com.mprribeiro.productms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mprribeiro.productms.entities.Category;
import com.mprribeiro.productms.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	
	public Category find(Integer id) {
		return repository.findById(id).get();
	}
	
	public List<Category> findAll() {
		return repository.findAll();
	}
}
