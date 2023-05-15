package burgerUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class getReceiptUnitTests {
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
    public void testGetReceiptShouldReturnFullReceipt() {
        when(mockedBun.getName()).thenReturn("Black Bun");
        when(mockedBun.getPrice()).thenReturn(2.0f);
        when(mockedIngredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(mockedIngredient1.getName()).thenReturn("Ketchup");
        when(mockedIngredient1.getPrice()).thenReturn(1.0f);
        when(mockedIngredient2.getType()).thenReturn(IngredientType.FILLING);
        when(mockedIngredient2.getName()).thenReturn("Sausage");
        when(mockedIngredient2.getPrice()).thenReturn(1.0f);

        String expectedReceipt = "(==== Black Bun ====)" + System.lineSeparator() +
                "= sauce Ketchup =" + System.lineSeparator() +
                "= filling Sausage =" + System.lineSeparator() +
                "(==== Black Bun ====)" + System.lineSeparator() +
                System.lineSeparator() +
                "Price: 6,000000" + System.lineSeparator();
        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
        //я бы сказал, что здесь бага в форматировании float.
        // Можно конечно в тесте дописать DecimalFormat, но не уверен, что это правильно для тестов
    }
}
