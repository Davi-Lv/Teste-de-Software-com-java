package aula02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrimeirosPassos {
	ChromeDriver driver;

	// tudo que é executado antes 
	@BeforeEach
	public void antes() {
		// definir o navegador
		WebDriverManager.chromedriver().setup();
		// WebDriverManager.firefoxdriver().setup();

		// criar o driver
		driver = new ChromeDriver();
		// FirefoxDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
	}

	// depois que tudo é executado
	@AfterEach
	public void depois() throws InterruptedException {
		// fechar pagina
		driver.quit();
	}

	@Test
	public void primeirosPassos() throws InterruptedException {
		// acessar a pagina da web.
		driver.navigate().to("https://www.google.com.br/");

		// usar uma pausa
		Thread.sleep(2000);
	}

	@Test
	public void interagindoComElementos() throws InterruptedException {

		// abrir o google
		driver.navigate().to("https://www.google.com.br/");

		// usando WebElement
		WebElement campoTexto = driver.findElement(By.name("q"));
		// escrever na barra de pesquisa do google
		campoTexto.sendKeys("Q academico");

		// usar uma pausa
		Thread.sleep(1000);

		// clicar no botão pesquisar da barra de pesquisa do google
		driver.findElement(By.name("btnK")).click();

		// dar submir dentro do input
		// driver.findElement(By.name("q")).submit();

		// usar uma pausa
		Thread.sleep(1000);

		// selecionando o site
		driver.findElement(By.partialLinkText("Q-Acadêmico")).click();

		// usar uma pausa
		Thread.sleep(1000);

		// login do aluno
		driver.findElement(By.id("Image_alunos")).click();

		// usando pause para determinar o tempo de fechar o chrome
		Thread.sleep(5000);
	}
	
	@Test
	public void teste02() throws InterruptedException {
		driver.get("https://www.ifpe.edu.br/campus/jaboatao");
		driver.findElement(By.linkText("Cursos")).click();
		driver.findElement(By.linkText("Análise e Desenvolvimento de Sistemas")).click();
		Thread.sleep(5000);
	}
}
