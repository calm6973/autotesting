package autotesting;

import org.junit.*;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
 
        CHROMEDRIVER_FILE_PATH = "D:/Automation/chromedriver.exe";	// 크롬 드라이버 파일 경로
 
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_FILE_PATH);
        driver = new ChromeDriver();
    }
 
    @Test // 검증 사이트 접속
    public void TC0001() throws Exception 
    {
        driver.get("http://www.naver.com");	// 기본 사이트 주소
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
 
    @Test // 메일 메뉴 접속
    public void TC0002() throws Exception 
    {
    	//driver.findElement(By.xpath(".//div[@className='disaster-popup']/close")).click();
    	//driver.findElement(By.className("more")).click();
    	driver.findElement(By.linkText("메일")).click();
    }
    
    @Test // RNB 메뉴 로그인 버튼 선택
    public void TC0003() throws Exception 
    {
    	//driver.findElement(By.xpath(".//div[@className='disaster-popup']/close")).click();
    	driver.findElement(By.className("btn_login")).click();
    }
    
    @Test // 아이디 입력
    public void TC0004() throws Exception 
    {
       	driver.findElement(By.id("id")).sendKeys("LoginID");

    }
 
    @Test // 비밀번호 미입력
    public void TC0005() throws Exception 
    {
    	driver.findElement(By.id("pw")).sendKeys("");
    }
    
    @Test // 로그인 버튼 클릭
    public void TC0006() throws Exception 
    {
    	driver.findElement(By.className("btn_global")).click();
    }
    
    @Test // 비밀번호 입력 가이드 문구 확인 (아직 작업중)
    public void TC0007() throws Exception 
    {
    	//driver.findElement(By.id("err_empty_pw")).equals("비밀번호를 입력해주세요.");
    	//String GuideText = driver.findElement(By.id("err_empty_pw"));
    	//String ErrorGuideText = getText(driver.findElement(By.id("err_empty_pw")));
    	//GuideText.equals("비밀번호를 입력해주세요.");
    }	
    
    @AfterClass
    public static void tearDown() throws Exception
    {
        //driver.close(); //테스트 완료 후 브라우저 종료 명령어
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
    }
}