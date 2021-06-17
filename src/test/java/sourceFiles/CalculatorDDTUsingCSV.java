package sourceFiles;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.CalcPage;
import utils.WebDriverFactory;
import org.junit.jupiter.api.Assertions;


public class CalculatorDDTUsingCSV {

    private CalcPage calcPage;
    private WebDriver webDriver;

    @BeforeEach
    public void init() {
        this.webDriver = WebDriverFactory.createWebDriver();
        this.webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        this.webDriver.manage().window().fullscreen();
    }

    @AfterEach
    public void tearDown(){
        this.webDriver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/csv/testNums.csv", numLinesToSkip = 1)
    void testAddition(double num1, double num2, double expectedAnswer) throws InterruptedException {
        initPage();
        webDriver.get(calcPage.URL);

        calcPage.operateOperations(num1, num2, "+");
        calcPage.getOperator("=");
        calcPage.getResult();
        Assertions.assertEquals(expectedAnswer, calcPage.getResult());
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/csv/testNumsSub.csv", numLinesToSkip = 1)
    void testSubtraction(double num1, double num2, double expectedAnswer) throws InterruptedException {
        initPage();
        webDriver.get(calcPage.URL);

        calcPage.operateOperations(num1, num2, "-");
        calcPage.getOperator("=");
        calcPage.getResult();
        Assertions.assertEquals(expectedAnswer, calcPage.getResult());
        System.out.println("About to sleep");
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/csv/testNumsDiv.csv", numLinesToSkip = 1)
    void testDivide(double num1, double num2, double expectedAnswer) throws InterruptedException {
        initPage();
        webDriver.get(calcPage.URL);

        calcPage.operateOperations(num1, num2, "/");
        calcPage.getOperator("=");
        calcPage.getResult();
        Assertions.assertEquals(expectedAnswer, calcPage.getResult());
        Thread.sleep(3000);
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/csv/testNumsMult.csv", numLinesToSkip = 1)
    void testMultiply(double num1, double num2, double expectedAnswer) throws InterruptedException {
        initPage();
        webDriver.get(calcPage.URL);

        calcPage.operateOperations(num1, num2, "*");
        calcPage.getOperator("=");
        calcPage.getResult();
        Assertions.assertEquals(expectedAnswer, calcPage.getResult());
        System.out.println("About to sleep");
    }

    public void initPage(){
        this.calcPage = PageFactory.initElements(webDriver, CalcPage.class);
    }
}
