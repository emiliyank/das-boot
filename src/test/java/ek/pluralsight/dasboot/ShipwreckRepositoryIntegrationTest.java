package ek.pluralsight.dasboot;

import ek.pluralsight.dasboot.model.Shipwreck;
import ek.pluralsight.dasboot.repository.ShipwreckRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShipwreckRepositoryIntegrationTest {

    @Autowired
    ShipwreckRepository shipwreckRepository;

    @Test
    public void testFindAll() {
        List<Shipwreck> wrecks = shipwreckRepository.findAll();
        assertEquals(2, wrecks.size());
        //assertThat(wrecks.size(), is(greaterThanOrEqualTo(0)));
    }
}
