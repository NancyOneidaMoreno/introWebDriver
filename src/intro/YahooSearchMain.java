package intro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooSearchMain {

	public static void main(String[] args) {
		//INICIALIZACION DE SYSTEM.SETPROPERTY()
	    WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,  TimeUnit.SECONDS);
		driver.get("http://www.yahoo.com");
		WebElement searchBox = driver.findElement(By.id("header-search-input"));//localiza elemento de busqueda
		WebElement searchButton = driver.findElement(By.id("header-desktop-search-button"));//Localiza elemento del boton de busqueda
		
		searchBox.clear(); //limpia el campo
		searchBox.sendKeys("Selenium"); //agrega datos al campo de search
		searchButton.click(); //da click al boton de busqueda
		
		WebElement seleniumLink = driver.findElement(By.linkText("Downloads - Selenium"));//encontrar el titulo en las ligas
		seleniumLink.click(); //dar click
		
		ArrayList<String> windowIds = new ArrayList<String>(driver.getWindowHandles()); //
		System.out.println("Number of windows: " + windowIds.size()); //Dice el numero de ventanas que se abren
		
		for(String windowId: driver.getWindowHandles()) {
			driver.switchTo().window(windowId);//Cambia a la nueva ventana
		}
		
		WebElement downloadLink = driver.findElement(By.linkText("Download"));//Busca el link Download pero por "texto"
		downloadLink.click();//Le da click al link
		
		driver.close();

	}

}
