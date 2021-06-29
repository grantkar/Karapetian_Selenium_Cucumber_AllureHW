package avitoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultTest {

    public WebDriver webDriver;

    public SearchResultTest(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "(//span[@class ='checkbox-label-3AzRS text-text-1PdBw text-size-s-1PUdo text-color-default-1QVMz'])[2]")
    public WebElement elementCheckBox;

    @FindAll({@FindBy(xpath = "//div[@class='iva-item-content-m2FiN']")})
    private List<WebElement> resultSearch;

    public void setElementCheckBox(){
        if (!elementCheckBox.isSelected()) {
            elementCheckBox.click();
        }
    }

    public void setSelectPrice(Select select, String value){
        select.selectByValue(value);
    }

    public void printResultSearch(int value){
        for (int i = 0; i < resultSearch.size(); i++) {
            if (i < value) {
                System.out.println(" Название принтера: " +
                        resultSearch.get(i).findElement(By.xpath(".//div[@class='iva-item-titleStep-2bjuh']//h3")).getText() +
                        " Стоимость принтера : "  + resultSearch.get(i).findElement(By.xpath(".//span[@class = 'price-text-1HrJ_ text-text-1PdBw text-size-s-1PUdo']")).getText() +
                        "рублей");
            } else break;
        }
    }
}
