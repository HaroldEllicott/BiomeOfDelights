package com.fdm.listeners;

import java.util.ArrayList;
import java.util.List;

import com.fdm.servlets.Product;

public class GenericDAO {
	public List<Product> getAll() {
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product("TV", "40\" 4k LG OLED TV", "https://www.lg.com/us/images/tvs/md05913456/gallery/zoom-001.jpg", 2199.00, 4, 15));
		products.add(new Product("TV", "47\" 4k LG OLED TV", "https://www.lg.com/us/images/tvs/md05913456/gallery/zoom-001.jpg", 2499.00, 5, 5));
		products.add(new Product("TV", "52\" 4k LG OLED TV", "https://www.lg.com/us/images/tvs/md05913456/gallery/zoom-001.jpg", 2799.00, 4, 6));
		products.add(new Product("TV", "70\" 4k LG OLED TV", "https://www.lg.com/us/images/tvs/md05913456/gallery/zoom-001.jpg", 3300.00, 5, 3));
		return products;
	}
}

