package com.ex.myapi;

import java.util.List;

public class ProductsResponse{
	private int total;
	private int limit;
	private int skip;
	private List<ProductsItem> products;

	public int getTotal(){
		return total;
	}

	public int getLimit(){
		return limit;
	}

	public int getSkip(){
		return skip;
	}

	public List<ProductsItem> getProducts(){
		return products;
	}
}