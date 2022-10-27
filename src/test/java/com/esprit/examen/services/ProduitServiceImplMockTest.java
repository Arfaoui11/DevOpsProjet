package com.esprit.examen.services;


import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceImplMockTest {

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    IProduitService produitService;
    @InjectMocks
    IStockService stockService;


    Produit produit = new Produit("f1", "l1",1F, new Date(), new Date());
    List<Produit> listUsers = new ArrayList<Produit>() {
        {
            add(new Produit("f1aa", "l1ss",1F, new Date(), new Date()));
            add(new Produit("f1f", "l1d",2F, new Date(), new Date()));
        }
    };


    @Test
    @Order(5)
    public void testRetrieveProduit() {

        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produitq = produitService.retrieveProduit(2L);
        Assertions.assertNotNull(produitq);
    }


    @Test
    @Order(4)
    public void testRetrieveAllProducts() {
        List<Produit> listProduits = produitService.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
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
    @Order(6)
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
