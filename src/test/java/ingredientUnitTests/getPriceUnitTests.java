package ingredientUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class getPriceUnitTests {

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 1.5f);
    }

    @Test
    public void getIngredientPriceShouldReturnFloat12point3(){
        float expectedPrice = 1.5f;
        float actualPrice = ingredient.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.0f);
    }
}
