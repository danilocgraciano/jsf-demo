package com.jsf.jsfdemo.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jsf.jsfdemo.entity.Product;

@Component
public class ProdutcDao implements Dao<Product> {

	private List<Product> data = new ArrayList<>();

	@Override
	public Optional<Product> get(int id) {
		return data.stream().filter(item -> item.getId() == id).findFirst();
	}

	@Override
	public Collection<Product> getAll() {
		return data.stream().filter(Objects::nonNull)
				.collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
	}

	@Override
	public int save(Product product) {
		data.add(product);
		int index = data.size();
		product.setId(index);
		return index;
	}

	@Override
	public void update(Product product) {

		Product aProduct = get(product.getId()).get();
		aProduct.setName(product.getName());
		aProduct.setPrice(product.getPrice());
	}

	@Override
	public void delete(Product product) {
		data.remove(product);
	}

}
