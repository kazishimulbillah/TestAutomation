package Package;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import Package.ApprovedWorkflow;

public class CreateApp extends ApprovedWorkflow{
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		driver = new FirefoxDriver();
		String baseUrl = "http://www.training.eprocure.gov.bd";
		driver.get(baseUrl);
		
		//Login
		
		String email1 = "egppeuser@gmail.com";
		ApprovedWorkflow.Login(email1,driver);
		
	
		//Create APP
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(".//*[@id='headTabApp']")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath(".//*[@id='submenu-configuration']/li[1]/a")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select BudgetType = new Select(driver.findElement(By.id("cmbBudgetType")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		BudgetType.selectByIndex(1);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select SelectProject = new Select(driver.findElement(By.id("cmbProject")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		SelectProject.selectByIndex(1);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement APPCode = driver.findElement(By.id("txtAppCode")); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		APPCode.sendKeys("APP");
		APPCode.submit();
	
		//Add Package Details
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Select ProcurementNature = new Select(driver.findElement(By.id("cmbProcureNature")));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		ProcurementNature.selectByIndex(1);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement PackageNo = driver.findElement(By.id("txtPackageNo"));
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;
		String PackageNo1 = Integer.toString(n); 
		PackageNo.sendKeys("PackageNo1" + PackageNo1);
		 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement PackageDescription = driver.findElement(By.id("txtaPackageDesc")); 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		PackageDescription.sendKeys("txtaPackageDesc 1");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement LotNo = driver.findElement(By.id("txtLotNo_1")); 
		LotNo.sendKeys("LotNo 1");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		WebElement LotDescription = driver.findElement(By.id("txtLotDesc_1")); 
		LotDescription.sendKeys("LotDesc 1");
		
		WebElement Quantity = driver.findElement(By.id("txtQuantity_1")); 
		Quantity.sendKeys("100");
		
		WebElement Unit = driver.findElement(By.id("txtUnit_1")); 
		Unit.sendKeys("PC");
		
		WebElement EstimatedCost = driver.findElement(By.id("txtEstimateCost_1")); 
		EstimatedCost.sendKeys("100000");
		EstimatedCost.click();
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
		Select ApprovingAuthority = new Select(driver.findElement(By.id("cmbAuthority")));
		ApprovingAuthority.selectByIndex(5);
		
		Select ProcurementType = new Select(driver.findElement(By.id("cmbProcureType")));
		ProcurementType.selectByIndex(1);
		
		Select ProcurementMethod = new Select(driver.findElement(By.id("cmbProcureMethod")));
		ProcurementMethod.selectByIndex(2);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 500);");
		jse.executeScript("document.getElementById('hrefCPV').click();");
		
		
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		jse.executeScript("scroll(0, 750);");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='8005']/a"));
		jse.executeScript("arguments[0].click();", element);
		jse.executeScript("document.getElementById('btnGetCheckedNode').click();");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
		driver.switchTo().window(winHandleBefore);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Thread.sleep(1000);
		driver.findElement(By.id("btnNext")).click();
		
		//Add Package Dates
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		String Date = ".//*[@id='txtRfqdtadvtift']";
		String Date1 = "17";
		ApprovedWorkflow.SelectDate(Date,Date1, driver);
	    
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("txtRfqdtadvtiftNo")).clear();
	    driver.findElement(By.id("txtRfqdtadvtiftNo")).click();
	    driver.findElement(By.id("txtRfqdtadvtiftNo")).sendKeys("7");
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("txtRfqdtsubNo")).clear();
	    driver.findElement(By.id("txtRfqdtsubNo")).click();
	    driver.findElement(By.id("txtRfqdtsubNo")).sendKeys("7");
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("txtRfqexpdtopenNo")).clear();
	    driver.findElement(By.id("txtRfqexpdtopenNo")).click();
	    driver.findElement(By.id("txtRfqexpdtopenNo")).sendKeys("21");
	    
	    jse.executeScript("scroll(0, 500);");
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("txtRfqdtsubevaRptNo")).clear();
	    driver.findElement(By.id("txtRfqdtsubevaRptNo")).click();
	    driver.findElement(By.id("txtRfqdtsubevaRptNo")).sendKeys("14");
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("txtRfqexpdtAppawdNo")).clear();
	    driver.findElement(By.id("txtRfqexpdtAppawdNo")).click();
	    driver.findElement(By.id("txtRfqexpdtAppawdNo")).sendKeys("7");
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("txtRfqdtIssNOANo")).clear();
	    driver.findElement(By.id("txtRfqdtIssNOANo")).click();
	    driver.findElement(By.id("txtRfqdtIssNOANo")).sendKeys("7");
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("txtRfqexpdtSignNo")).clear();
	    driver.findElement(By.id("txtRfqexpdtSignNo")).click();
	    driver.findElement(By.id("txtRfqexpdtSignNo")).sendKeys("7");
	    
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("idtxttotal")).click();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	    driver.findElement(By.id("btnSave")).click();
	    
	  //Create Work flow
	    Thread.sleep(1000);
	    driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
	    ApprovedWorkflow.CreateWorkflow(driver);
	    
	  //Approve Work flow
	    
	    driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
	    driver.findElement(By.partialLinkText("Logout")).click();
	    driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
	    String email2 = "egphopeuser@gmail.com";
	    ApprovedWorkflow.Login(email2, driver);
	    driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ;
	    ApprovedWorkflow.ApprovedWorkflow1(driver);
		
	  //Publish the App
	    driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS) ; 
	    driver.findElement(By.partialLinkText("Logout")).click();
	    ApprovedWorkflow.Login(email1,driver);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; 
	    driver.findElement(By.xpath(".//*[@id='headTabApp']")).click();
		driver.findElement(By.xpath(".//*[@id='submenu-configuration']/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='0']/td[6]/a/img")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.linkText("Publish")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.findElement(By.id("txtremark")).click();
		driver.findElement(By.id("txtremark")).sendKeys("Published");
		driver.findElement(By.id("btnsubmit")).click();	
		driver.close();
	}

}
