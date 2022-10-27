package com.esprit.examen.services;


import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)


    public class FournisseurServiceMockImplTest {
    @InjectMocks
    IFournisseurService fournisseurService;
    @Mock
    FournisseurRepository fournisseurRepository ;
    @Mock
    DetailFournisseurRepository detailfournisseurRepository;


    @Test
    public void  retrieveAllFournisseursTest () {
        when(fournisseurRepository.findAll()).thenReturn(new ArrayList());
        List<Fournisseur> fournisseurList = fournisseurService.retrieveAllFournisseurs();
        assertEquals(0,fournisseurList.size());

    }
    public void  addFournisseurTest() {
        DetailFournisseur df = new DetailFournisseur();
        df.setIdDetailFournisseur(1L);
        when(fournisseurRepository.save(any())).thenReturn(df);
        fournisseurService.addFournisseur(new Fournisseur());
        assertEquals(1L,df.getIdDetailFournisseur());


    }


}
