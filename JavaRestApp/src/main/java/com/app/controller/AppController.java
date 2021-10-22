package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.Stock;
import com.app.service.AppService;

@RestController
@RequestMapping("/app")
public class AppController {
	@Autowired
	AppService appService;
	
	@GetMapping(value = "/getAllStocks", produces = MediaType.APPLICATION_JSON_VALUE )
	public List<Stock> saveEvent(){
		return appService.getAllStocks();
	}
	
	@PostMapping(value = "/createStock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public String createStock(@RequestBody Stock stock){
		return appService.createStock(stock);
	}
	
	@GetMapping(value = "/getStock/{stockId}", produces = MediaType.APPLICATION_JSON_VALUE )
	public Stock saveEvent(@PathVariable int stockId) throws Exception{
		return appService.getStock(stockId);
	}
	
	@PutMapping(value = "/updateStock", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public String updateStock(@RequestBody Stock stock) throws Exception{
		return appService.updateStock(stock);
	}
	
	@DeleteMapping(value = "/deleteStock/{stockId}")
	public String deleteStock(@PathVariable int stockId) throws Exception{
		return appService.deleteStock(stockId);
	}
}
