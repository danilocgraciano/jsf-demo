package com.jsf.jsfdemo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jsf.jsfdemo.dao.Dao;
import com.jsf.jsfdemo.entity.Product;

@Scope(value = "session")
@Component(value = "productController")
public class ProductService {

	@Autowired
	private Dao<Product> dao;
	private Product product = new Product();

	public String save() {
		save(product);
		product = new Product();
		return "/list?faces-redirect=true";
	}

	public Collection<Product> getAll() {
		return dao.getAll();
	}

	public int save(Product product) {
		int id = product.getId();
		if (id <= 0)
			id = dao.save(product);
		else
			dao.update(product);
		return id;
	}

	public void load() {
		this.product = dao.get(product.getId()).get();
		// return "form?faces-redirect=true";
	}

	public String delete(int id) {
		dao.delete(dao.get(id).get());
		this.product = new Product();
		return "list?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}

	public List<Product> getProducts() {
		return (List<Product>) dao.getAll();
	}

}
