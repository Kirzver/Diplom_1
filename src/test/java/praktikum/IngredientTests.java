package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.testData.TestNamesAndPrices.*;

@RunWith(Parameterized.class)
public class IngredientTests {

    private final IngredientType type;
    private final String name;
    private final float price;

    Ingredient ingredient;

    public IngredientTests(IngredientType type, String name, float price){
        this.type = type;
        this.name = name;
        this.price = price;

    }


    @Parameterized.Parameters
    public static Object[][] chooseIngredient(){
        return new Object[][]{
                {IngredientType.SAUCE, SAUCE_NAME, SAUCE_PRICE},
                {IngredientType.FILLING, FILLING_NAME, FILLING_PRICE}
        };
    }

    @Before
    public void setUp(){
        ingredient = new Ingredient(type,name,price);
    }
    @Test
    public void getPriceReturnCorrectPrice() {
        assertEquals(price, ingredient.getPrice(),0);

    }

    @Test
    public void getPriceReturnCorrectName() {
        assertEquals(name, ingredient.getName());

    }

    @Test
    public void getTypeReturnCorrectIngredient() {
        assertEquals(type, ingredient.getType());

    }


}
