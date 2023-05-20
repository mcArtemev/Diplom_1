package bunUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunUnitTests {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    private Bun bun;

    @Test
    // Тестирование метода getName() с валидным значением имени
    public void testValidNameShouldReturnBun() {
        bun = new Bun("bun", 2.5f);
        String expectedName = "bun";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    // Тестирование метода getName() с пустым значением имени
    public void testEmptyNameShouldReturnEmpty() {
        bun = new Bun("", 2.5f);
        String expectedName = "";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }
    @Test
    // Тестирование метода getName() с null значением имени
    public void testNullNameShouldReturnNull() {
        bun = new Bun(null, 2.5f);
        String expectedName = null;
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    // Тестирование метода getName() с именем, содержащим только пробелы
    public void testNameWithOnlySpacesShouldReturnSpaces() {
        bun = new Bun("   ", 2.5f);
        String expectedName = "   ";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    // Тестирование метода getName() с длинным именем
    public void testLongNameShouldReturnLongName() {
        bun = new Bun("thisssveryverylongbunnameintheworld", 2.5f);
        String expectedName = "thisssveryverylongbunnameintheworld";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    // Тестирование метода getName() с именем, содержащим специальные символы
    public void testNameWithSymbolsShouldReturnSymbolsName() {
        bun = new Bun("$bun!@", 2.5f);
        String expectedName = "$bun!@";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    // Тестирование метода getName() с именем, содержащим цифры
    public void testNameWithNumericsShouldReturnNumericsName() {
        bun = new Bun("123bun", 2.5f);
        String expectedName = "123bun";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    // Тестирование метода getName() с именем, содержащим символы в верхнем регистре
    public void testUppercaseNameShouldReturnUppercaseName() {
        bun = new Bun("BUN", 2.5f);
        String expectedName = "BUN";
        String actualName = bun.getName();
        assertEquals(expectedName, actualName);
    }

    @Test
    // Тестирование метода getPrice() с положительной ценой
    public void testPositivePriceShouldReturnPositivePrice() {
        bun = new Bun("Bun", 2.5f);
        float expectedPrice = 2.5f;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    @Test
    // Тестирование метода getPrice() с отрицательной ценой
    public void testNegativePriceShouldReturnNegativePrice() {
        bun = new Bun("Bun", -2.5f);
        float expectedPrice = -2.5f;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    @Test
    // Тестирование метода getPrice() с нулевой ценой
    public void testZeroPriceShouldReturnZeroPrice() {
        bun = new Bun("Bun", 0f);
        float expectedPrice = 0f;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    @Test
    // Тестирование метода getPrice() с минимальной положительной ценой (дробной)
    public void testMinPositivePriceShouldReturnMinPositivePrice() {
        bun = new Bun("Bun", 0.01f);
        float expectedPrice = 0.01f;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    @Test
    // Тестирование метода getPrice() с максимально возможной положительной ценой
    public void testMaxPositivePriceShouldReturnMaxPositivePrice() {
        bun = new Bun("Bun", Float.MAX_VALUE);
        float expectedPrice = Float.MAX_VALUE;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

    @Test
    // Тестирование метода getPrice() с ценой NaN (не числовое значение)
    public void testNaNPriceShouldReturnNaNPrice() {
        bun = new Bun("Bun", Float.NaN);
        float expectedPrice = Float.NaN;
        float actualPrice = bun.getPrice();
        assertEquals(expectedPrice, actualPrice, 0.01f);
    }

}
