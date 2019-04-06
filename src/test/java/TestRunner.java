import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"steps"},
        features = "src/test/resources/features",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        tags ={"@first"}
)

/*tags={"@smoke"} - Run only the tests with tag smoke
tags={"~@smoke"} - Run all the tests except ones with tag as smoke
tags={"@smoke,@Regression"} - Run the tests with either smoke or Regression tags
tags={"@smoke","@Regression"} - Run only the test tagged as smoke and Regression*/

public class TestRunner {
}
