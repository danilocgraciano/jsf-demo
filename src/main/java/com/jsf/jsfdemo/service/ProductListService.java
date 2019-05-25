package com.jsf.jsfdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jsf.jsfdemo.dao.Dao;
import com.jsf.jsfdemo.entity.Product;

@Scope(value = "session")
@Component(value = "productList")
public class ProductListService {

	@Autowired
	private Dao<Product> dao;

	private List<Product> products;

	public List<Product> getProducts() {
		products = (List<Product>) dao.getAll();
		return products;
	}

}
