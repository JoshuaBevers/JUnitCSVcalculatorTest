package pages;

import kotlin.text.UStringsKt;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.rmi.server.ExportException;

public class CalcPage {

    //numbers
    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[11]")
    private WebElement number1;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[12]")
    private WebElement number2;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[13]")
    private WebElement number3;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[5]")
    private WebElement number4;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[6]")
    private WebElement number5;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[7]")
    private WebElement number6;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[1]")
    private WebElement number7;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[2]")
    private WebElement number8;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[3]")
    private WebElement number9;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[18]")
    private WebElement number0;

    @FindBy(xpath = "//input[@id='period_btn']")
    private WebElement numberDec;

    //operators
    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[14]")
    private WebElement plus;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[15]")
    private WebElement minus;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[8]")
    private WebElement multiply;

    @FindBy(xpath = "//body/div[4]/div[2]/div[1]/div[9]/input[9]")
    private WebElement divide;

    @FindBy(xpath = "//input[@id='equals_btn']")
    private WebElement equals;

    @FindBy(xpath = "//input[@id='fld_5']")
    private WebElement result;


    public static String URL = "https://www.calculator.com/";

    public void operateOperations(double num1, double num2, String operation) {
        try {
            getNumber(num1);
            getOperator(operation);
            getNumber(num2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getNumber(double num) {
        String value = String.valueOf(num);
        System.out.println(value);
        for (int i = 0; i < value.length(); i++) {
            switch (value.charAt(i)) {
                case '1':
                    number1.click();
                    break;
                case '2':
                    number2.click();
                    break;
                case '3':
                    number3.click();
                    break;
                case '4':
                    number4.click();
                    break;
                case '5':
                    number5.click();
                    break;
                case '6':
                    number6.click();
                    break;
                case '7':
                    number7.click();
                    break;
                case '8':
                    number8.click();
                    break;
                case '9':
                    number9.click();
                    break;
                case '0':
                    System.out.println("clicking zero");
                    number0.click();
                    break;
                case '.':
                    numberDec.click();
                    break;
            }
        }
    }

    public void getOperator(String operator) {

        switch (operator) {
            case "+":
                System.out.println("Clicking: " + operator);
                plus.click();
                break;
            case "=":
                equals.click();
                break;
            case "-":
                minus.click();
                break;
            case "*":
                multiply.click();
                break;
            case "/":
                divide.click();
                break;
        }

    }

    public double getResult() {
        System.out.println("The result is: " + result.getAttribute("value"));
        return Double.parseDouble(result.getAttribute("value"));
    }

}
