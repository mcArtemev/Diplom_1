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

public class MoveIngredientUnitTests {
    private Burger burger;

    @Mock
    private Ingredient mockedIngredient1;

    @Mock
    private Ingredient mockedIngredient2;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        burger = new Burger();
        burger.ingredients = new ArrayList<>();
        burger.ingredients.add(mockedIngredient1);
        burger.ingredients.add(mockedIngredient2);
    }

    @Test
    public void testMoveIngredientShoulfChangeIngredientIndex() {
        int index = 0;
        int newIndex = 1;

        burger.moveIngredient(index, newIndex);

        List<Ingredient> ingredients = burger.ingredients;
        assertEquals(mockedIngredient1, ingredients.get(newIndex));
        assertEquals(mockedIngredient2, ingredients.get(index));
    }
}
