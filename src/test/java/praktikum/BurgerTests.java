package praktikum;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static praktikum.testData.TestNamesAndPrices.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Mock
    Ingredient ingredientTwo;

    @Before
    public void setUp(){
        burger = new Burger();

    }

    @Test
    public void setBunsIsCorrect(){
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientOnlyOneInBurgerIsCorrect(){
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());

    }

    @Test
    public void removeIngredientInBurgerIsCorrect(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());

    }

    @Test
    public void moveIngredientInBurgerIsCorrect(){
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0,1);
        assertEquals(1, burger.ingredients.indexOf(ingredient));

    }

    @Test
    public void getPriceBurgerIsCorrect(){
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getPrice()).thenReturn(SAUCE_PRICE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float burgerPrice = burger.getPrice();
        assertEquals(BUN_PRICE * 2 + SAUCE_PRICE,burgerPrice,0);

    }

    @Test
    public void getReceiptIngredientOnBurgerIsCorrect(){
        Mockito.when(bun.getName()).thenReturn(BUN_NAME);
        Mockito.when(bun.getPrice()).thenReturn(BUN_PRICE);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(SAUCE_NAME);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float burgerPrice = burger.getPrice();
        String expectedReceipt =
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burgerPrice);
        assertEquals(expectedReceipt,burger.getReceipt());

    }
}
