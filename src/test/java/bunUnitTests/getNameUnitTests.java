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
public class getNameUnitTests {

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    private Bun mockedBun;

    @Test
    public void testGetNameShouldReturnBlackBun() {
        Bun bun = new Bun("black bun", 2.5f);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testMockedGetNameShouldReturnMockerBun() {
        when(mockedBun.getName()).thenReturn("mocked bun");
        assertEquals("mocked bun", mockedBun.getName());
    }
}
