package ek.pluralsight.dasboot;

import ek.pluralsight.dasboot.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class HomeControllerTest {
    @Test
    public void homepageTest() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "Das boot project, initial page!");
    }
}
