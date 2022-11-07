/*package com.esprit.examen.services;

import static org.junit.Assert.*;


import java.util.List;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class StockServiceImplTest {
	@Autowired
	IStockService stockService;

	@Test
	@Order(4)
	public void testRetrieveAllStocks() {
		List<Stock> listStocks = stockService.retrieveAllStocks();
		Assertions.assertNotEquals(0, listStocks.size());
	}

	@Test
	@Order(1)
	public void testAddStock() {
		List<Stock> stocks = stockService.retrieveAllStocks();
		int expected=stocks.size();
		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		
		assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedStock.getLibelleStock());
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	@Order(3)
	public void testAddStockOptimized() {

		Stock s = new Stock("stock test",10,100);
		Stock savedStock= stockService.addStock(s);
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);
		stockService.deleteStock(savedStock.getIdStock());
		
	} 
	
	@Test
	@Order(2)
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		Stock savedStock= stockService.addStock(s);
		stockService.deleteStock(savedStock.getIdStock());
		assertNull(stockService.retrieveStock(savedStock.getIdStock()));
	}

	@Test
	@Order(5)
	public void testUpdateStock() {

		Stock s = new Stock(" new stock ",10,100);
		Stock savedStock= stockService.addStock(s);

		savedStock.setLibelleStock("12345");
		savedStock.setQte(2);
		savedStock.setQteMin(1);
		savedStock.setIdStock(1L);

		Stock updatedStock = stockService.updateStock(savedStock);


		assertNotNull(updatedStock.getIdStock());
		assertSame("12345", updatedStock.getLibelleStock());
	//	assertTrue(updatedStock.getQte()>2);

		stockService.deleteStock(updatedStock.getIdStock());
	//	stockService.deleteStock(savedStock.getIdStock());


	}

}

 */
