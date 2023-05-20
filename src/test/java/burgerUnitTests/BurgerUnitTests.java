package burgerUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class BurgerUnitTests {
    private Burger burger;

    @Mock
    private Ingredient mockedIngredient;

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
    public void testAddIngredientsShouldReturn3Ingredients() {
        burger.addIngredient(mockedIngredient);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(3, ingredients.size());
        assertEquals(mockedIngredient, ingredients.get(ingredients.size()-1));
    }
    @Test
    public void testGetPriceShouldReturnPrice() {
        when(mockedBun.getPrice()).thenReturn(2.0f);
        when(mockedIngredient1.getPrice()).thenReturn(1.0f);
        when(mockedIngredient2.getPrice()).thenReturn(1.0f);

        float expectedPrice = 2.0f * 2 + 1.0f + 1.0f;
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.0f);
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
    }

    @Test
    public void testMoveIngredientShouldChangeIngredientIndex() {
        int index = 0;
        int newIndex = 1;

        burger.moveIngredient(index, newIndex);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(mockedIngredient1, ingredients.get(newIndex));
        assertEquals(mockedIngredient2, ingredients.get(index));
    }

    @Test
    public void testRemoveIngredientShouldDecrementIngredientSize() {
        int index = 0;

        burger.removeIngredient(index);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(1, ingredients.size());
    }

    @Test
    public void testSetBunsShouldReturnBlackBun() {
        Bun bun = new Bun("Black Bun", 1.5f);
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

}
