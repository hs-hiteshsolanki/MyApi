package com.ex.myapi;

import java.util.List;

public class ProductsItem{
	private Object discountPercentage;
	private String thumbnail;
	private List<String> images;
	private int price;
	private Object rating;
	private String description;
	private int id;
	private String title;
	private int stock;
	private String category;
	private String brand;

	public Object getDiscountPercentage(){
		return discountPercentage;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public List<String> getImages(){
		return images;
	}

	public int getPrice(){
		return price;
	}

	public Object getRating(){
		return rating;
	}

	public String getDescription(){
		return description;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public int getStock(){
		return stock;
	}

	public String getCategory(){
		return category;
	}

	public String getBrand(){
		return brand;
	}
}