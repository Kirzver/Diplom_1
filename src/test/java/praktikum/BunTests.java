package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.testData.TestNamesAndPrices.BUN_NAME;
import static praktikum.testData.TestNamesAndPrices.BUN_PRICE;

public class BunTests {

    Bun bun;

    @Before
    public void setUp(){
        bun = new Bun(BUN_NAME, BUN_PRICE);
    }

    @Test
    public void getNameReturnCorrectName() {
        assertEquals(BUN_NAME, bun.getName());

    }
    @Test
    public void getPriceReturnCorrectPrice() {
        assertEquals(BUN_PRICE, bun.getPrice(),0);
    }
}
