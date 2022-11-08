/*package com.esprit.examen.services;


import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FournisseurServiceMockImplTest {
    @InjectMocks
    FournisseurServiceImpl fournisseurService;
    @Mock
    FournisseurRepository fournisseurRepository ;


    //logger
    Fournisseur fournisseur = new Fournisseur("f1", "l1");
    List<Fournisseur> fournisseurs = new ArrayList<Fournisseur>() {
        {
            add(new Fournisseur("f2", "l2"));
            add(new Fournisseur("f3", "l3"));
        }
    };

    @Test
    public void  retrieveAllFournisseursTest () {
        when(fournisseurRepository.findAll()).thenReturn(new ArrayList());
        List<Fournisseur> fournisseurList = fournisseurService.retrieveAllFournisseurs();
        assertEquals(0,fournisseurList.size());

    }
    @Test
    public void  addFournisseurTest() {
        DetailFournisseur df = new DetailFournisseur();
        df.setIdDetailFournisseur(1L);
        when(fournisseurRepository.save(any())).thenReturn(df);
        fournisseurService.addFournisseur(new Fournisseur());
        assertEquals(1L,df.getIdDetailFournisseur());


    }
    @Test
    public void  updateFournisseurTest() {
        DetailFournisseur df = new DetailFournisseur();
        df.setIdDetailFournisseur(1L);
        when(fournisseurRepository.save(any())).thenReturn(df);
        fournisseurService.updateFournisseur(new Fournisseur());
        assertEquals(1L, df.getIdDetailFournisseur());
    }
    @Test
    public void  retrieveFournisseurTest() {

        DetailFournisseur df = new DetailFournisseur();
        df.setIdDetailFournisseur(1L);
        when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
        Fournisseur f = fournisseurService.retrieveFournisseur(Long.valueOf("55"));
        assertEquals(1L, df.getIdDetailFournisseur());
    }

}

 */
