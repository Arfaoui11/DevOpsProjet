package com.esprit.examen.services;


import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class FournisseurServiceMockImplTest {
    @InjectMocks
    FournisseurServiceImpl fournisseurService;
    @Mock
    FournisseurRepository fournisseurRepository ;



    Fournisseur fournisseur = new Fournisseur("f1", "l1");
    List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>() {
        {
            add(new Fournisseur("f2", "l2"));
            add(new Fournisseur("f3", "l3"));
        }
    };

    @Test
    void testRetrieveFournisseur(){
        when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur op1= fournisseurService.retrieveFournisseur(1L);
        assertNotNull(op1);
    }
    @Test
    void testAddFournisseur(){
        when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur p =fournisseurService.retrieveFournisseur(2L);
        Fournisseur u= fournisseurService.addFournisseur(p);
        assertNotNull(u.getCode());
        assertNotNull(u.getLibelle());


    }
    @Test
    void testDeleteFournisseur()  {
        Fournisseur op = new Fournisseur();
        op.setCode("test");
        op.setIdFournisseur(1L);
        when(fournisseurRepository.findById(op.getIdFournisseur())).thenReturn(Optional.of(op));
        Fournisseur o = fournisseurService.retrieveFournisseur(1L);
        fournisseurService.deleteFournisseur(o.getIdFournisseur());
        verify(fournisseurRepository).deleteById(o.getIdFournisseur());
    }
    @Test
    void testupdateFournisseur( ) {
        when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur pr =fournisseurService.retrieveFournisseur(1L);
        pr.setLibelle("pass");
        assertThat(pr.getLibelle()).isEqualTo("pass");
    }

    @Test
    void  testretrieveAllFournisseurs(){
        List<Fournisseur> f = new ArrayList<>();
        f.add(new Fournisseur());
        when(fournisseurRepository.findAll()).thenReturn(f);
        List<Fournisseur> expected = fournisseurService.retrieveAllFournisseurs();
        assertEquals(expected, f);
        verify(fournisseurRepository).findAll();
    }








}
