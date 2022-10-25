package ek.pluralsight.dasboot;

import ek.pluralsight.dasboot.controller.ShipwreckController;
import ek.pluralsight.dasboot.model.Shipwreck;
import ek.pluralsight.dasboot.repository.ShipwreckRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ShipwreckControllerTest {
    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNullShipwreckGet() {
        when(shipwreckRepository.findById(1L)).thenReturn(null);
        Shipwreck wreck = sc.get(1L);
        verify(shipwreckRepository).findById(1L);
        assertNull(wreck);
    }

    @Test
    public void testNotNullShipwreckGet() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        Optional<Shipwreck> osw = Optional.ofNullable(sw);
        when(shipwreckRepository.findById(1L)).thenReturn(osw);
        Shipwreck wreck = sc.get(1L);

        verify(shipwreckRepository).findById(1L);
        assertEquals(1L, wreck.getId());
    }

    @Test
    public void testShipwreckList() {
        List<Shipwreck> shipwrecksList = new ArrayList<>();
        Shipwreck sw1 = new Shipwreck();
        Shipwreck sw2 = new Shipwreck();
        shipwrecksList.add(sw1);
        shipwrecksList.add(sw2);

        when(shipwreckRepository.findAll()).thenReturn(shipwrecksList);
        List<Shipwreck> shipwrecks = sc.list();

        verify(shipwreckRepository).findAll();
        assertEquals(2, shipwrecks.size());
        assertEquals(shipwrecksList, shipwrecks);
    }

    @Test
    public void testShipwreckCreate() {
        Shipwreck sw = new Shipwreck();
        when(shipwreckRepository.saveAndFlush(sw)).thenReturn(sw);

        Shipwreck wreck = sc.create(sw);

        verify(shipwreckRepository).saveAndFlush(sw);
        assertEquals(sw, wreck);
    }

    @Test
    public void testNonExistentShipwreckDelete() {
        when(shipwreckRepository.findById(99L)).thenReturn(null);
        Shipwreck wreck = sc.delete(99L);

        verify(shipwreckRepository).deleteById(99L);
        assertNull(wreck);
    }

    @Test
    public void testExistingShipwreckDelete() {
        Shipwreck sw = new Shipwreck();
        Optional<Shipwreck> osw = Optional.ofNullable(sw);
        when(shipwreckRepository.findById(1L)).thenReturn(osw);

        Shipwreck wreck = sc.delete(1L);

        verify(shipwreckRepository).deleteById(1L);
        assertEquals(sw, wreck);
    }
}
