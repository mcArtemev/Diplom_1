package bunUnitTests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GetPriceUnitTests {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    @Mock
    private Bun mockedBun;
    @Test
    public void testGetPriceShouldReturn25f() {
        Bun bun = new Bun("black bun", 2.5f);
        assertEquals(2.5f, bun.getPrice(), 0.01);
    }

    @Test
    public void testMockedGetPriceShouldReturn3f() {
        when(mockedBun.getPrice()).thenReturn(3.0f);
        assertEquals(3.0f, mockedBun.getPrice(), 0.01);
    }
}
