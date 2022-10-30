package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperateurServiceImplMockTest {


   /* @Mock
    OperateurRepository op;

    @InjectMocks
    IOperateurService operateurService;

    Operateur user = new Operateur(1L,"Drissi","Omar","123",new Date());

    List<Operateur> list = new ArrayList<Operateur>() {
        {
            add(new Operateur(2L,"drissi", "ahmed", "456",new Date()));
            add(new Operateur(3L,"dri", "MOhamed", "789",new Date()));
        }
    };

    @Test
    @Order(1)
    public void testRetrieveOperateur(){
        Mockito.when(op.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Operateur op1=operateurService.retrieveOperateur(1L);
        assertNotNull(op1);
    }


    @Test
    @Order(2)
    public void testAddOperateur(){
        Mockito.when(op.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Operateur p =operateurService.retrieveOperateur(2L);
        Operateur u= operateurService.addOperateur(p);
        assertNotNull(u.getDateNaissance());
    }

    @Test
    @Order(4)
    void testDeleteOperateur()  {
        Mockito.when(op.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Operateur pr =operateurService.retrieveOperateur(2L);
        operateurService.deleteOperateur(pr.getIdOperateur());
        assertNull(operateurService.retrieveOperateur(pr.getIdOperateur()));
    }

    @Test
    @Order(3)
    void testupdateOperateur( ) {
        Mockito.when(op.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        Operateur pr =operateurService.retrieveOperateur(2L);
        pr.setPassword("pass");
        assertThat(pr.getPassword()).isEqualTo("pass");
    }*/




}
