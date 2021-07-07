package avitoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AvitoSeleniumTest {
    public static MethodTest methodTest;
    public static SearchResultTest resultTest;
    public static WebDriver driver;
    public static Select selectCategory;
    public static Select selectCheckBox;
    private final String CATEGORY = "category";
    private final int VALUE = 3;
    private final String SEARCH = "Принтер";
    private final String CITY_SEARCH = "Владивосток";


    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        methodTest = new MethodTest(driver);
        resultTest = new SearchResultTest(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("startpage"));
    }


    @Test
    public void avitoTest(){
        selectCategory = new Select(driver.findElement(By.id(CATEGORY)));
        methodTest.setCategory(selectCategory, ConfProperties.getProperty("category"));
        methodTest.setSearch(SEARCH);
        methodTest.setElementLocal();
        methodTest.setElementCitySearch(CITY_SEARCH);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        methodTest.setElementCity();
        methodTest.setElementClickCity();
        resultTest.setElementCheckBox();
        selectCheckBox = new Select(driver.findElement(By.xpath("//div[@class='sort-select-3QxXG select-select-box-3LBfK select-size-s-2gvAy']/select[@class='select-select-3CHiM']")));
        resultTest.setSelectPrice(selectCheckBox, ConfProperties.getProperty("price"));
        resultTest.printResultSearch(VALUE);
    }

    @AfterClass
    public static void closeTest(){
        driver.close();
    }

}