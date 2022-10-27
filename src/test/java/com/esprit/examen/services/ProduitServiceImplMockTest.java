package com.esprit.examen.services;



import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.assertNull;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplMockTest {

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    IProduitService produitService = new ProduitServiceImpl();






    Produit produit = new Produit("f1", "l1",1F, new Date(), new Date());
    List<Produit> listUsers = new ArrayList<Produit>() {
        {
            add(new Produit("f1aa", "l1ss",1F, new Date(), new Date()));
            add(new Produit("f1f", "l1d",2F, new Date(), new Date()));
        }
    };


    @Test
    public void testRetrieveProduitByid() {

        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produitq = produitService.retrieveProduit(1L);

        System.out.println(produitq);
        Assertions.assertNotNull(produitq);
    }
    @Test
    public void testRetrieveAllProduit() {

        Mockito.when(produitRepository.findAll()).thenReturn(listUsers);
        List<Produit> produits = produitService.retrieveAllProduits();

        System.out.println(produits);
        Assertions.assertEquals(2, produits.size());
    }



    @Test
    public void testCreateNewObject() {
        Produit obj = new Produit("new", "new",3.9F, new Date(), new Date());


        Mockito.when(produitRepository.save(isA(Produit.class))).thenAnswer(invocation -> (Produit) invocation.getArguments()[0]);
        Produit returnedObj = produitService.addProduit(obj);
        ArgumentCaptor<Produit> savedObjectArgument = ArgumentCaptor.forClass(Produit.class);
        Mockito.verify(produitRepository, times(1)).save(savedObjectArgument.capture());
        Mockito.verifyNoMoreInteractions(produitRepository);

        Produit savedRestObject = savedObjectArgument.getValue();
        System.out.println(savedRestObject);
        Assertions.assertNotNull(savedRestObject);

    }



}
