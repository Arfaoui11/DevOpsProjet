package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {

    @Autowired
    IOperateurService operateurService;

    @Test
    public void testAddOperateur() throws ParseException {
        Operateur o = new Operateur("drissi","omar","pwd");
        Operateur operateur = operateurService.addOperateur(o);
        System.out.print("operateur "+operateur);
        assertNotNull(operateur.getIdOperateur());
        assertTrue(operateur.getNom().length() > 0);
        operateurService.deleteOperateur(operateur.getIdOperateur());
    }


    @Test
    public void testDeleteOperateur() throws ParseException {
       Operateur o = new Operateur("drissi", "omar", "pwd");
        Operateur  operateur = operateurService.addOperateur(o);
        operateurService.deleteOperateur( operateur.getIdOperateur());
        assertNull(operateurService.retrieveOperateur(operateur.getIdOperateur()));
    }


    @Test
    public void testRetrieveAllOperateurs() throws ParseException {
        List<Operateur> clients = operateurService.retrieveAllOperateurs();
        int expected = clients.size();
        Operateur o = new Operateur("drissi", "omar", "pwd");
        Operateur operateur= operateurService.addOperateur(o);
        assertEquals(expected + 1, operateurService.retrieveAllOperateurs().size());
        operateurService.deleteOperateur(operateur.getIdOperateur());
    }
















}
