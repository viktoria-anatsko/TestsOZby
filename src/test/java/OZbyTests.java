import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.TestUtils;


public class OZbyTests extends BaseTest {

    @Test
    public void testSearchPanel() {
        TestUtils.get(getDriver());

        WebElement input = getDriver().findElement(By.id("top-s"));
        input.sendKeys("карандаш\n");

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.className("item-type-card__title")));

        Assert.assertEquals(
                getDriver().findElement(By.xpath("//*[@id=\"goods-table\"]/li[1]/div/div/div/div/a/p[1]"))
                        .getText(), "Карандаш чернографитный с ластиком \"Party Blackline\" (HB)");
    }

    @Test
    public void testClickGoodsToSchool() {
        TestUtils.get(getDriver());

        getDriver().findElement(By.linkText("Товары в школу")).click();

        Assert.assertEquals(
                getDriver().findElement(By.className("landing-header__title"))
                        .getText(), "Товары к школе");
    }

    @Test
    public void testClickPromotionsAndDiscounts() {
        TestUtils.get(getDriver());

        getDriver().findElement(By.linkText("Акции и скидки")).click();

        Assert.assertEquals(
                getDriver().findElement(By.xpath("//*[@id=\"ul_combined\"]/li[3]/label/a"))
                        .getText(), "Распродажа");
    }

    @Test
    public void testPutInBasket() {
        TestUtils.get(getDriver());

        getDriver().findElement(By.linkText("Книги")).click();

        getDriver().findElement(By.xpath("//*[@id=\"goods-table\"]/li[2]/div/div/div/a")).click();

        getDriver().findElement(By.className("b-product-control__btn-container")).click();

        Assert.assertEquals(
                getDriver().findElement(By.className("top-panel__userbar__cart__count"))
                        .getText(), "1");
    }

    @Test
    public void testClickBasket() {
        TestUtils.get(getDriver());

        getDriver().findElement(By.linkText("Корзина")).click();

        Assert.assertEquals(
                getDriver().findElement(By.id("loginFormLoginEmailLink"))
                        .getText(), "Электронная почта");
    }

    @Test
    public void testClickAuthorization() {
        TestUtils.get(getDriver());

        getDriver().findElement(By.linkText("Войти")).click();

        Assert.assertEquals(
                getDriver().findElement(By.id("loginFormLoginPhoneLink"))
                        .getText(), "Номер телефона");

        getDriver().findElement(By.className("i-social-buttons__item")).click();
    }

    @Test
    public void testClickShopsOZ() {
        TestUtils.get(getDriver());

        getDriver().findElement(By.linkText("Магазины OZ")).click();

        Assert.assertEquals(
                getDriver().findElement(By.xpath("//*[@id=\"top-page\"]/div[3]/div/div/div[1]/h2"))
                        .getText(), "Расположение");
    }
}

