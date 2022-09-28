package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.entities.SecteurActivite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurServiceImplTest {

    @Autowired
    ISecteurActiviteService secteurActiviteService;


    @Test
    public void testAddSecteurActivite() throws ParseException {
        SecteurActivite s = new SecteurActivite("test","test");
        SecteurActivite secteurActivite = secteurActiviteService.addSecteurActivite(s);
        System.out.print("secteurActivite "+secteurActivite);
        assertNotNull(secteurActivite.getIdSecteurActivite());
        assertTrue(secteurActivite.getCodeSecteurActivite().length() > 0);
        secteurActiviteService.deleteSecteurActivite(secteurActivite.getIdSecteurActivite());
    }



    @Test
    public void testDeleteSecteurActivite() throws ParseException {
        SecteurActivite s = new SecteurActivite("test", "test");
        SecteurActivite  secteurActivite =secteurActiviteService.addSecteurActivite(s);
        secteurActiviteService.deleteSecteurActivite( secteurActivite.getIdSecteurActivite());
        assertNull(secteurActiviteService.retrieveSecteurActivite(secteurActivite.getIdSecteurActivite()));
    }



    @Test
    public void testRetrieveAllSecteurs() throws ParseException {
        List<SecteurActivite> secteurActivites = secteurActiviteService.retrieveAllSecteurActivite();
        int expected =secteurActivites.size();
        SecteurActivite s = new SecteurActivite("test", "test");
        SecteurActivite secteurActivite= secteurActiviteService.addSecteurActivite(s);
        assertEquals(expected + 1, secteurActiviteService.retrieveAllSecteurActivite().size());
        secteurActiviteService.deleteSecteurActivite(secteurActivite.getIdSecteurActivite());
    }








}
