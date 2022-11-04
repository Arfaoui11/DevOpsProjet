package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.esprit.examen.entities.Produit;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Stock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceImplTest {
    @Autowired
    IProduitService produitService;
    @Autowired
    IStockService stockService;

    @Test
    @Order(4)
    public void testRetrieveAllProducts() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        Assertions.assertEquals(1, listProduits.size());
    }


    @Test
    @Order(1)
    public void testAddProduct() {
        List<Produit> produits = produitService.retrieveAllProduits();

        int expected = produits.size();

        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);

        Calendar myCalendar = new GregorianCalendar(2022, 8, 11);
        Date myDate = myCalendar.getTime();

        Calendar myCalendar1 = new GregorianCalendar(2022, 9, 11);
        Date myDate1 = myCalendar1.getTime();


        final Produit produit = new Produit("123", " test", 32.0F,myDate ,myDate1);

       produit.setStock(savedStock);
       Produit savedProduit = produitService.addProduit(produit);

        assertEquals(expected+1, produitService.retrieveAllProduits().size());
        assertNotNull(savedProduit.getLibelleProduit());
       produitService.deleteProduit(savedProduit.getIdProduit());
       stockService.deleteStock(savedStock.getIdStock());

    }


    @Test
    @Order(2)
    public void testAddProductOptimized() {

        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);



        Calendar myCalendar = new GregorianCalendar(2022, 8, 11);
        Date myDate = myCalendar.getTime();

        Calendar myCalendar1 = new GregorianCalendar(2022, 9, 11);
        Date myDate1 = myCalendar1.getTime();

        Produit produit = new Produit("123","test",32.0F,myDate,myDate1);

        produit.setStock(savedStock);
        Produit savedProduit = produitService.addProduit(produit);

        assertNotNull(savedProduit.getIdProduit());
        assertSame("test", savedProduit.getLibelleProduit());
        assertTrue(savedProduit.getPrix()>31F);

        produitService.deleteProduit(savedProduit.getIdProduit());
        stockService.deleteStock(savedStock.getIdStock());


    }

    @Test
    @Order(4)
    public void testUpdateProduct() {

        Stock s = new Stock(" new stock ",10,100);
        Stock savedStock= stockService.addStock(s);

        Calendar myCalendar = new GregorianCalendar(2022, 8, 11);
        Date myDate = myCalendar.getTime();

        Calendar myCalendar1 = new GregorianCalendar(2022, 9, 11);
        Date myDate1 = myCalendar1.getTime();

        Produit produit = new Produit("1","samsung",1299.0F,myDate,myDate1);

        produit.setStock(savedStock);
        Produit savedProduit = produitService.addProduit(produit);


        savedProduit.setCodeProduit("12345");
        savedProduit.setLibelleProduit("test 10:35");
        savedProduit.setDateCreation(myDate);
        savedProduit.setDateDerniereModification(myDate);

        Produit updatedProduit = produitService.updateProduit(savedProduit);


        assertNotNull(updatedProduit.getIdProduit());
        assertSame("test 10:35", updatedProduit.getLibelleProduit());
        assertTrue(updatedProduit.getPrix()>221F);

        produitService.deleteProduit(savedProduit.getIdProduit());
        stockService.deleteStock(savedStock.getIdStock());


    }



    @Test
    @Order(3)
    public void testDeleteProduit() {
        Stock s = new Stock("stock test",10,100);
        Stock savedStock= stockService.addStock(s);

        Calendar myCalendar = new GregorianCalendar(2022, 8, 11);
        Date myDate = myCalendar.getTime();

        Calendar myCalendar1 = new GregorianCalendar(2022, 9, 11);
        Date myDate1 = myCalendar1.getTime();

        Produit produit = new Produit("123","test",32.0F,myDate,myDate1);

        produit.setStock(savedStock);
        Produit savedProduit = produitService.addProduit(produit);


        produitService.deleteProduit(savedProduit.getIdProduit());

        assertNull(produitService.retrieveProduit(savedProduit.getIdProduit()));
        stockService.deleteStock(savedStock.getIdStock());
    }






}
