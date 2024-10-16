package SeleniumLatestFeature.CDP_Integration;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.emulation.Emulation;
import org.testng.annotations.Test;

public class SetGeoLocation
{

	@Test
	public void setLocation() throws InterruptedException
	{
		ChromeDriver driver= new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		/*
		Map<String, Object> coordiates=new HashMap<String,Object>();
		coordiates.put("latitude", 40.4168);
		coordiates.put("longitude", 3.7038);
		coordiates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordiates);
		*/
		
		devTools.send(Emulation.setGeolocationOverride(Optional.of(36), Optional.of(138), Optional.empty()));
		
		driver.get("http://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("netflix" ,Keys.ENTER);
		Thread.sleep(4000);
		driver.findElements(By.cssSelector(".LC20lb.MBeuO.DKV0Md")).get(0).click();
		String title=driver.findElement(By.cssSelector("h1[class='default-ltr-cache-jpuyb8 e9eyrqp8']")).getText();
		System.out.println(title);
		
	}
}
