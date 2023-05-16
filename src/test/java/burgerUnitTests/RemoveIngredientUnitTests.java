package burgerUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RemoveIngredientUnitTests {
    private Burger burger;

    @Mock
    private Ingredient mockedIngredient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(mockedIngredient);
    }

    @Test
    public void testRemoveIngredientShouldDecrementIngredientSize() {
        int index = 0;

        burger.removeIngredient(index);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(0, ingredients.size());
    }
}
