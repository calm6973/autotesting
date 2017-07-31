package autotesting;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runners.MethodSorters;
 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SearchTest
	{
    private static WebDriver driver;
    private static StringBuffer verificationErrors = new StringBuffer();
    private static String CHROMEDRIVER_FILE_PATH;
 
    @BeforeClass
    public static void setUp() throws Exception
    {
 
        CHROMEDRIVER_FILE_PATH = "D:/Automation/chromedriver.exe";	// ũ�� ����̹� ���� ���
 
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_FILE_PATH);
        driver = new ChromeDriver();
    }
 
    @Test
    public void TC0000() throws Exception // ���� ����Ʈ ����
    {
        driver.get("http://www.naver.com");	// �⺻ ����Ʈ �ּ�
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    @Test
    public void TC0001() throws Exception // ���� �޴� ����
    {
    	//driver.findElement(By.xpath(".//div[@className='disaster-popup']/close")).click();
    	//driver.findElement(By.className("more")).click();
    	driver.findElement(By.linkText("����")).click();
    }
    
    @Test
    public void TC0002() throws Exception // RNB �޴� �α��� ��ư ����
    {
    	//driver.findElement(By.xpath(".//div[@className='disaster-popup']/close")).click();
    	driver.findElement(By.className("btn_login")).click();
    }
 
    
    @AfterClass
    public static void tearDown() throws Exception
    {
        //driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
    }
}