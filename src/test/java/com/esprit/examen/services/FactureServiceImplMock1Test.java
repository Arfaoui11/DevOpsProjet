/*package com.esprit.examen.services;

import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class FactureServiceImplMock1Test {
    @Autowired
    IFactureService factureService;
    @Autowired

    @Test
    public void testAddFacture () throws ParseException {
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFactrure= factureService.addFacture(f);
        System.out.print("client "+savedFactrure);
        assertNotNull(savedFactrure);
        Assertions.assertEquals(200f, savedFactrure.getMontantFacture());
        Assertions.assertEquals(20f,savedFactrure.getMontantRemise());
        assertEquals(new Date(10 / 10 / 2022),savedFactrure.getDateCreationFacture());
        factureService.cancelFacture(savedFactrure.getIdFacture());
        log.info("facture ajoutée ===>" + savedFactrure.toString());

    }


    @Mock
    FactureRepository factureRepository;
    @InjectMocks
    FactureServiceImpl  FactureService;
    Facture f = new Facture(1L, 20f, 200f, new Date(10 / 10 / 2022), new Date(10 / 10 / 2022), true);

    List<Facture> list = new ArrayList<Facture>() {
        {
            add(new Facture(2L, 30f, 700f, new Date(10 / 10 / 2022), new Date(10 / 10 / 2022), true));
            add(new Facture(3L, 40f, 1000f, new Date(10 / 10 / 2022), new Date(10 / 10 / 2022), true));
        }
    };
    @Test
    void testRetrieveFacturesMock() throws Exception {

        Facture returned = new Facture (1L, 20f, 200f, new Date(10 / 10 / 2022), new Date(10 / 10 / 2022), true);

        Mockito.when(factureRepository.findById(1L)).thenReturn(Optional.of(returned));
        Facture result =FactureService.retrieveFacture(1L);

        Assertions.assertEquals(200f, result.getMontantFacture());
        Assertions.assertEquals(20f, result.getMontantRemise());
        Assertions.assertEquals(new Date(10 / 10 / 2022), result.getDateCreationFacture());
        log.info("get ===>" +  result.toString());

    }
    @Test
    void testAddFactureMock() throws Exception {
        Facture  input1 = new Facture (1L, 20f, 200f, new Date(10 / 10 / 2022), new Date(10 / 10 / 2022), true);
        Facture returned1 =  new  Facture (1L, 20f, 200f, new Date(10 / 10 / 2022), new Date(10 / 10 / 2022), true);


        //stub the data
        Mockito.when(factureRepository.save(input1)).thenReturn(returned1);

        //actual method call
        Facture result1 =FactureService.addFacture(input1);


        Assertions.assertEquals(200f, result1.getMontantFacture());
        Assertions.assertEquals(20f, result1.getMontantRemise());
        Assertions.assertEquals(new Date(10 / 10 / 2022), result1.getDateCreationFacture());
        log.info("facture ajoutée ===>" +  result1.toString());
    }

    @Test
    void testCancelFactureMock() throws Exception {
        Facture  input = new Facture (1L, 20f, 200f, new Date(10 / 10 / 2022), new Date(10 / 10 / 2022), true);

        //stub the data
        Mockito.when(factureRepository.findById(1L)).thenReturn(Optional.of(input));
        FactureService.cancelFacture(input.getIdFacture());
        assertEquals( input.getArchivee(),true);

    }


}
*/