package avitoTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MethodTest {

    public WebDriver webDriver;

    public MethodTest(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//input[@class='suggest-root-1v2AH js-suggest suggest_search']")
    private WebElement search;

    @FindBy(xpath = "//div[@class='main-select-2pf7p main-location-3j9by']")
    private WebElement elementLocal;

    @FindBy(className = "suggest-input-3p8yi")
    private WebElement elementCitySearch;

    @FindBy(xpath = "//ul/li/span[@class='suggest-suggest-content-KQ__w']")
    private WebElement elementCity;

    @FindBy(xpath = "//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']")
    private WebElement elementClickCity;


    public void setCategory(Select select, String value){
        select.selectByValue(value);
    }

    public void setSearch(String str){
        search.sendKeys(str);
    }

    public void setElementLocal(){
        elementLocal.click();
    }

    public void setElementCitySearch(String str){
        elementCitySearch.sendKeys(str);
    }

    public void setElementCity(){
        elementCity.click();
    }

    public void setElementClickCity (){
        elementClickCity.click();
    }


}
