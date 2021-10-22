package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.StockDao;
import com.app.domain.Stock;

@Service
public class AppServiceImpl implements AppService{
	
	final static private String STOCK_NOT_FOUND = "No Stock with the given ID.";
	final static private String INVALID_STOCK_UPDATE = "Please provide valid field values to update stock.";
	
	@Autowired
	StockDao stockDao;

	@Override
	public List<Stock> getAllStocks() {
		return stockDao.getAllStocks();
	}

	@Override
	public String createStock(Stock stock) {
		return stockDao.createStock(stock);
	}

	@Override
	public Stock getStock(int id) throws Exception {
		Optional<Stock> stock = stockDao.getStockById(id);
		if(!stock.isPresent())
			throw new Exception(STOCK_NOT_FOUND);
		
		return stock.get();
	}

	@Override
	public String updateStock(Stock stock) throws Exception {
		if(stock == null || stock.getId() == 0 )
			throw new Exception(STOCK_NOT_FOUND);
		
		if(stock.getCurrentPrice() <= 0)
			throw new Exception(INVALID_STOCK_UPDATE);
		
		return stockDao.updateStock(stock);
	}

	@Override
	public String deleteStock(int id) throws Exception {
		Optional<Stock> stock = stockDao.getStockById(id);
		if(!stock.isPresent())
			throw new Exception(STOCK_NOT_FOUND);
		
		return stockDao.deleteStock(id);
	}

}
