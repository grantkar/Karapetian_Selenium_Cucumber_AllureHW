package avitoTest;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/features"}
        , glue = {"steps"}
        ,tags = "@All"
)
public class RunTest extends AbstractTestNGCucumberTests {
}
