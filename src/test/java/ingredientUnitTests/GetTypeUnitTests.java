package ingredientUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetTypeUnitTests {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE},
                {IngredientType.FILLING}
        });
    }

    @Parameterized.Parameter
    public IngredientType ingredientType;

    private Ingredient ingredient;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ingredient = new Ingredient(ingredientType, "Test Ingredient", 1.5f);
    }
    @Test
    public void getIngredientTypeShouldReturnCorrectType() {
        IngredientType expectedType = ingredientType;
        IngredientType actualType = ingredient.getType();
        assertEquals(expectedType, actualType);
    }
}
