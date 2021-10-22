package com.app.service;

import java.util.List;

import com.app.domain.Stock;

public interface AppService {
	
	public List<Stock> getAllStocks();
	
	public String createStock(Stock stock);
	
	public Stock getStock(int id) throws Exception;
	
	public String updateStock(Stock stock) throws Exception;
	
	public String deleteStock(int id) throws Exception;
}
