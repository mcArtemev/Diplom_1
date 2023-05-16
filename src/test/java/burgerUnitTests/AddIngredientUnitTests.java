package burgerUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddIngredientUnitTests {
    private Burger burger;

    @Mock
    private Ingredient mockedIngredient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
    }

    @Test
    public void testAddIngredientShouldReturnIngredient() {
        burger.addIngredient(mockedIngredient);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(1, ingredients.size());
        assertEquals(mockedIngredient, ingredients.get(0));
    }
}
