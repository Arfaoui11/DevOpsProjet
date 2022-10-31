package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import static org.junit.Assert.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class OperateurServiceImplTest {

    @Autowired
    IOperateurService operateurService;

    @Test
    @Order(1)
    public void testRetrieveAllOperateurs() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissance = dateFormat.parse("06/01/1998");
        List<Operateur> clients = operateurService.retrieveAllOperateurs();
        int expected = clients.size();
        Operateur o = new Operateur("drissi", "omar", "pwd",dateNaissance);
        Operateur operateur= operateurService.addOperateur(o);
        assertEquals(expected + 1, operateurService.retrieveAllOperateurs().size());
        operateurService.deleteOperateur(operateur.getIdOperateur());
    }


    @Test
    @Order(2)
    public void testAddOperateur() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissance = dateFormat.parse("06/01/1998");
        Operateur o = new Operateur("drissi","omar","pwd",dateNaissance);
        Operateur operateur = operateurService.addOperateur(o);
        log.info("operateur " + operateur);
        assertNotNull(operateur.getIdOperateur());
        assertTrue(operateur.getNom().length() > 0);
        operateurService.deleteOperateur(operateur.getIdOperateur());
    }

    @Order(3)
    @Test
    public void testUpdateOperateur() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissance = dateFormat.parse("06/01/1998");
        Operateur o = new Operateur("drissi","omar","pwddddddd",dateNaissance);
        Operateur operateurUpdated = operateurService.updateOperateur(o);
        Assertions.assertEquals(o.getPassword(),operateurUpdated.getPassword());
    }


    @Test
    @Order(5)
    public void testDeleteOperateur() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaissance = dateFormat.parse("06/01/1998");
        Operateur o = new Operateur("drissi", "omar", "pwd",dateNaissance);
        Operateur  operateur = operateurService.addOperateur(o);
        operateurService.deleteOperateur( operateur.getIdOperateur());
        assertNull(operateurService.retrieveOperateur(operateur.getIdOperateur()));
    }



    @Test
    @Order(4)
    public void testGetClientsByDateNaissance() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = dateFormat.parse("06/01/1998");
        Date endDate = dateFormat.parse("06/01/2005");
        assertTrue(startDate.before(endDate));
        List<Operateur> operateurs = operateurService.getOperateurByDateNaissance(startDate, endDate);
        log.info(" count" + operateurs.size());
        for (Operateur user : operateurs) {
            log.info(" Operateur : " + user.getNom()+ " né le "+user.getDateNaissance());

        }

    }





















}
