package burgerUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;

import static org.junit.Assert.assertEquals;

public class setBunsUnitTests {
    private Burger burger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testSetBunsShouldReturnBlackBun() {
        Bun bun = new Bun("Black Bun", 1.5f);
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }
}
