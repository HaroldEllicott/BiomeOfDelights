package com.fdm.servlets;

public class Product {

	private String name;
	private String description;
	private String imageURL;
	private double price;
	private int starRating;
	private int quantity;

	public Product(String name, String description, String imageURL, double price, int starRating, int quantity) {
		super();
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
		this.price = price;
		this.starRating = starRating;
		this.quantity = quantity;
	}

	public final String getName() {
		return name;
	}

	public final String getDescription() {
		return description;
	}

	public final double getPrice() {
		return price;
	}

	public final int getStarRating() {
		return starRating;
	}

	public final int getQuantity() {
		return quantity;
	}

	public final String getImageURL() {
		return imageURL;
	}
}
