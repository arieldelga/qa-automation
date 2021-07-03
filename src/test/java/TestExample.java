import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestExample {

    String url = "https://petshelter.miwuki.com/";

    String emailExample = "sanchopanza@gmail.com";
    String passExample = "soysancho";
    String nameExample = "Sancho";
    String lastNameExample = "Panza Panza";

    @Test
    public void firstTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"m_header_topbar\"]/div/ul/li/a/span/span"));
        WebDriverWait eWait = new WebDriverWait(driver, 10);
        eWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){}
//        WebElement regisButton = driver.findElement(By.cssSelector("a[href=\"https://petshelter.miwuki.com/registro\"]"));
        WebElement regisButton = driver.findElement(By.xpath("//*[@id=\"modal_login\"]/div/div/div[2]/div[4]/div/div[1]/a"));
        regisButton.click();

        driver.findElement(By.name("nombre")).sendKeys("Sancho");

        driver.findElement(By.name("apellidos")).sendKeys(lastNameExample);

        driver.findElement(By.name("email")).sendKeys(emailExample);

        driver.findElement(By.name("email_confirmation")).sendKeys(emailExample);

        WebElement paisEjemplo = driver.findElement(By.id("s-pais"));
        Select paisEjemploCombo = new Select(paisEjemplo);
        paisEjemploCombo.selectByValue("MG");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e){}
        WebElement provinciaEjemplo = driver.findElement(By.id("s-provincia"));
        Select provinciaEjemploCombo = new Select(provinciaEjemplo);
        provinciaEjemploCombo.selectByValue("MG-005");

        driver.findElement(By.name("pass")).sendKeys(passExample);

        driver.findElement(By.name("pass_confirmation")).sendKeys(passExample);

        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div/div[1]/div/form/div[8]/label/span")).click();

        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div/div[1]/div/form/div[9]/label/span")).click();

        driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div/div[1]/div/form/div[10]/button")).click();

        String actualErrorText = driver.findElement(By.xpath("//*[@id=\"m_login\"]/div[1]/div/div[1]/div/form/div[1]")).getText();
        String spectedErrorText = "¡Error! El correo electrónico ya ha sido registrado.";
        Assert.assertEquals(actualErrorText, spectedErrorText);
        System.out.println("Error message: " + actualErrorText);



//            WebElement tiempoPrepReceta = driver.findElement(By.id("rangeInput"));
//            Actions actions = new Actions(driver);
//            actions.dragAndDropBy(tiempoPrepReceta, -31, 348).build().perform();

    }
}
