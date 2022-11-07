
package com.esprit.examen.services;
        import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.ArgumentMatchers.any;
        import static org.mockito.Mockito.when;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;

        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.Mockito;
        import org.mockito.junit.jupiter.MockitoExtension;

        import com.esprit.examen.entities.Reglement;

        import com.esprit.examen.repositories.ReglementRepository;
        import com.esprit.examen.services.ReglementServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReglementServiceImplTest {

    @InjectMocks
    ReglementServiceImpl reglementServiceImpl;
    @Mock
    ReglementRepository reglementRepository;

    //logging
    Reglement reglement = new Reglement(1L,2, 100, true, null, null);

    List<Reglement> list = new ArrayList<Reglement>() {

        {
            add(new Reglement());
            add(new Reglement());

        }
    };

    @Test
    void test_retrieveAllReglements_ok() {

        when(reglementRepository.findAll()).thenReturn(new ArrayList());
        List<Reglement> response = reglementServiceImpl.retrieveAllReglements();
        assertEquals(0, response.size());
    }

    @Test
    void test_addReglement_ok() {
        Reglement r = new Reglement();
        r.setIdReglement(1L);
        //mock
        when(reglementRepository.save(any())).thenReturn(r);
        //call function
        reglementServiceImpl.addReglement(new Reglement());

        //assert
        assertEquals(1L, r.getIdReglement());
    }


    public void selectOne() {
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
        Reglement reg = reglementServiceImpl.retrieveReglement((long) 2);

        Assertions.assertNotNull(reg);
    }

    public void delete() {

        Reglement r = reglementRepository.findById(1L).get();
        reglementRepository.delete(r);

    }
}