package Pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Broken_LinksPage extends PageBase {

	public Broken_LinksPage(WebDriver driver) {
		super(driver);

	}


	public void CheckingBrokenLinks(String HP) throws MalformedURLException, IOException {

		driver.get("https://www.amazon.com/");

		String homePage = HP;

//		String homePage = "https://www.amazon.com/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;


		List<WebElement> links = driver.findElements(By.tagName("a"));

		java.util.Iterator<WebElement> it = links.iterator();

		while(it.hasNext()){

			url = it.next().getAttribute("href");

			System.out.println(url);

			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if(!url.startsWith(homePage)){
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if(respCode >= 400){
					System.out.println(url+" is a broken link");
				}
				else{
					System.out.println(url+" is a valid link");
				}}
				finally {
				}
			}
		}}
	


