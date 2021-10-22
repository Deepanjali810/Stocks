package com.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.domain.Stock;

@Service
public class StockDao {
	
	private static Stock s1 = new Stock(1, "Stock1", 120, new Date());
	private static Stock s2 = new Stock(2, "Stock2", 140, new Date());
	
	final static private String CREATE_SUCCESS_MSG = "Successfully Added New Stock";
	final static private String UPDATE_SUCCESS_MSG = "Successfully Updated Stock With Id %s";
	final static private String DELETE_SUCCESS_MSG = "Successfully Deleted Stock With Id %s";
	
	private static List<Stock> listStocks = new ArrayList<>();
	
	static {
		listStocks.add(s1);
		listStocks.add(s2);
	}
	
	public List<Stock> getAllStocks(){
		return listStocks;
	}
	
	
	public String createStock(Stock stock) {
		if(stock.getLastUpdate() == null) {
			stock.setLastUpdate(new Date());
		}
		
		listStocks.add(stock);
		
		return CREATE_SUCCESS_MSG;
	}
	
	public Optional<Stock> getStockById(int id) {
		Optional<Stock> stock = Optional.empty();
		try {
			stock = Optional.of(listStocks.stream().filter(item -> item.getId() == id).findAny().get());
		} catch (Exception e) {
			//logger for the exception
		}
		
		return stock;
	}
	
	public String updateStock(Stock stock){
			int len = listStocks.size();
			for (int i = 0; i < len; i++) {
				Stock currStock = listStocks.get(i);
				if(currStock.getId() == stock.getId()) {
					currStock.setCurrentPrice(stock.getCurrentPrice());
					break;
				}
			}
			
			return String.format(UPDATE_SUCCESS_MSG, stock.getId());
	}
	
	public String deleteStock(int id){
		int len = listStocks.size();
		int index = -1;
		for (int i = 0; i < len; i++) {
			Stock currStock = listStocks.get(i);
			if(currStock.getId() == id) {
				index = i;
				break;
			}
		}
		
		listStocks.remove(index);
		return String.format(DELETE_SUCCESS_MSG, id);
}
	

}
