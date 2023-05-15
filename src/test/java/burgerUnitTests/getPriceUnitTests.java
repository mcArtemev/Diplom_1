package burgerUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class getPriceUnitTests {
    private Burger burger;

    @Mock
    private Bun mockedBun;

    @Mock
    private Ingredient mockedIngredient1;

    @Mock
    private Ingredient mockedIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        burger.setBuns(mockedBun);
        burger.addIngredient(mockedIngredient1);
        burger.addIngredient(mockedIngredient2);
    }

    @Test
    public void testGetPriceShouldReturn6f() {
        when(mockedBun.getPrice()).thenReturn(2.0f);
        when(mockedIngredient1.getPrice()).thenReturn(1.0f);
        when(mockedIngredient2.getPrice()).thenReturn(1.0f);

        float expectedPrice = 2.0f * 2 + 1.0f + 1.0f;
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.0f);
    }
}
