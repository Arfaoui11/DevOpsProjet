package com.esprit.examen.services;


import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(MockitoExtension.class)


public class FournisseurServiceMockImplTest {
    @InjectMocks
    IFournisseurService fournisseurService;
    @Mock
    FournisseurRepository fournisseurRepository;
    @Test
         public void  testretrieveAllFournisseurs () {
        Mockito.when(fournisseurRepository.findAll()).thenReturn(new ArrayList());
        List<Fournisseur> fournisseurList = fournisseurService.retrieveAllFournisseurs();
        assertEquals(0,fournisseurList.size());

    }


}
