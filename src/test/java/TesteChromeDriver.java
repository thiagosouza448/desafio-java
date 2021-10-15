import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteChromeDriver {
	
	public static void main(String[]args) {
		System.setProperty("webdriver.chorme.driver", "\\Users\\thiag\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://srbarriga.herokuapp.com/cadastro");
	
	}
	

}
