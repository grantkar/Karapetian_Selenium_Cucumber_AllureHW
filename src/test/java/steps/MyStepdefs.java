package steps;

import avitoTest.ConfProperties;
import avitoTest.MethodTest;
import avitoTest.SearchResultTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;

import io.qameta.allure.Attachment;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import steps.enams.CategoryValue;
import steps.enams.Steps;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    public static MethodTest methodTest;
    public static SearchResultTest resultTest;
    public static WebDriver driver;
    public static Select selectCategory;
    public static Select selectCheckBox;

    private final String ID_CATEGORY = "category";

    @Before
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        methodTest = new MethodTest(driver);
        resultTest = new SearchResultTest(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Пусть("^Открыт ресурс авито$")
    public void открыт_ресурс_авито() {
        driver.get(ConfProperties.getProperty("startpage"));
        captureScreenshot(driver);
    }

    @ParameterType(".*")
    public CategoryValue categoryValue (String category){
        return CategoryValue.valueOf(category);
    }

    @И("в выподающем списке категорий выбрана {categoryValue}")
    public void в_выподающем_списке_категорий_выбрана(CategoryValue categoryValue) {
        selectCategory = new Select(driver.findElement(By.id(ID_CATEGORY)));
        methodTest.setCategory(selectCategory, categoryValue.getValue());
        captureScreenshot(driver);
    }

    @И("^в поле поиска введено значение (.*)$")
    public void в_поле_поиска_введено_значение_принтер(String str) {
        methodTest.setSearch(str);
        captureScreenshot(driver);
    }

    @Тогда("^кликнуть по выподающему списку региона$")
    public void кликнуть_по_выподающему_списку_региона() {
        methodTest.setElementLocal();
        captureScreenshot(driver);
    }

    @Тогда("^в поле регион введено значение \"([^\"]*)\"$")
    public void в_поле_регион_введено_значение(String arg1) {
        methodTest.setElementCitySearch(arg1);
        captureScreenshot(driver);
    }

    @И("^нажата кнопка показать объявления$")
    public void нажата_кнопка_показать_объявления() {
        methodTest.setElementCity();
        methodTest.setElementClickCity();
        captureScreenshot(driver);
    }

    @Тогда("^открылась страница результаты по запросу (.*)$")
    public void открылась_страница_результаты_по_запросу_принтер(String str) {
        System.out.println("открылась страница результаты по запросу " + str);
        captureScreenshot(driver);
    }

    @И("^активирован чекбокс только с фотографией$")
    public void активирован_чекбокс_только_с_фотографией() {
        resultTest.setElementCheckBox();
        selectCheckBox = new Select(driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select[@class='select-select-3CHiM']")));
        captureScreenshot(driver);
    }

    @ParameterType(".*")
    public Steps steps(String price){
        return Steps.valueOf(price);
    }

    @И("в выподающем списке сортировка выбрано значение {steps}")
    public void в_выподающем_списке_сортировка_выбрано_значение_Дороже(Steps step) {
        resultTest.setSelectPrice(selectCheckBox, step.getValue());
        captureScreenshot(driver);
    }

    @И("^в консоль выведено значение названия и цены (\\d+) первых товаров$")
    public void в_консоль_выведено_значение_названия_и_цены_первых_товаров(int arg1) {
        resultTest.printResultSearch(arg1);
        captureScreenshot(driver);
    }

    @After
    public void closeDriver() {
        driver.close();
    }

    @Attachment(value="Screenshot", type="image/png")
    private static byte[] captureScreenshot(WebDriver driver) {
        byte[] screenshot = null;
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

}