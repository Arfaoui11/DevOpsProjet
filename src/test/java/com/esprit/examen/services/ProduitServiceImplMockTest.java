package com.esprit.examen.services;



import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;


import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplMockTest {

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    IProduitService produitService = new ProduitServiceImpl();






    Produit produit = new Produit("f1", "l1",1F, new Date(), new Date());
    List<Produit> listProduits = new ArrayList<Produit>() {
        {
            add(new Produit("f1aa", "l1ss",1F, new Date(), new Date()));
            add(new Produit("f1f", "l1d",2F, new Date(), new Date()));
        }
    };


    @Test
    void testRetrieveProduitByid() {

        when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produitq = produitService.retrieveProduit(1L);

        System.out.println(produitq);
        Assertions.assertNotNull(produitq);
    }
    @Test
    void testRetrieveAllProduit() {

        List<Produit> produits = new ArrayList();
        produits.add(new Produit());
        when(produitRepository.findAll()).thenReturn(produits);
        List<Produit> expected = produitService.retrieveAllProduits();
        Assertions.assertEquals(expected, produits);
        verify(produitRepository).findAll();

    }



    @Test
    void testCreateNewObject() {
        Produit obj = new Produit("new", "new",3.9F, new Date(), new Date());


        when(produitRepository.save(isA(Produit.class))).thenAnswer(invocation -> (Produit) invocation.getArguments()[0]);
        Produit returnedObj = produitService.addProduit(obj);
        ArgumentCaptor<Produit> savedObjectArgument = ArgumentCaptor.forClass(Produit.class);
        verify(produitRepository, times(1)).save(savedObjectArgument.capture());
        verifyNoMoreInteractions(produitRepository);

        Produit savedRestObject = savedObjectArgument.getValue();
        Assertions.assertNotNull(savedRestObject);

    }

    @Test
    void testDeleteObject() {
        Produit produite = new Produit();
        produite.setCodeProduit("new test");
        produite.setIdProduit(1L);
        when(produitRepository.findById(produite.getIdProduit())).thenReturn(Optional.of(produite));
        Produit produitq = produitService.retrieveProduit(1L);
        produitService.deleteProduit(produitq.getIdProduit());
        verify(produitRepository).deleteById(produitq.getIdProduit());
    }



}
