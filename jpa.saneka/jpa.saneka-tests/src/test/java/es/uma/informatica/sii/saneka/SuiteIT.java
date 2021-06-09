package es.uma.informatica.sii.saneka;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SuiteIT {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	  BaseDatos.inicializaBaseDatos("SanekaTest");
	}
  @After
  public void tearDown() {
    driver.quit();
  }
/*
  @Test
  public void loginContraseniaIncorrecta() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).sendKeys("sec1@uma.es");
    driver.findElement(By.id("login:password")).sendKeys("321");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.findElement(By.id("login:errorPassword")).getText(), is("La contraseña no es correcta"));
  }
  @Test
  public void loginContraseniaRequerida() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).click();
    driver.findElement(By.id("login:correo")).sendKeys("sec1@uma.es");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.findElement(By.id("login:errorPassword")).getText(), is("login:password: Validation Error: Value is required."));
  }
  @Test
  public void loginCorreoRequerido() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:password")).sendKeys("123");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.findElement(By.id("login:errorCorreo")).getText(), is("login:correo: Validation Error: Value is required."));
  }
  @Test
  public void loginExitosoAlumno() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).sendKeys("07143291@uma.es");
    driver.findElement(By.id("login:password")).sendKeys("123");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.getTitle(), is("Página principal"));
  }
  @Test
  public void loginExitosoSecretaria() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).sendKeys("sec1@uma.es");
    driver.findElement(By.id("login:password")).sendKeys("123");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.getTitle(), is("Panel de control de Secretaria"));
  }
  @Test
  public void loginUsuarioNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).sendKeys("Pepe@uma.es");
    driver.findElement(By.id("login:password")).sendKeys("123");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.findElement(By.id("login:errorCorreo")).getText(), is("La cuenta no existe"));
  }
  @Test
  public void paginaIndice() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    assertThat(driver.getTitle(), is("Login"));
  }*/
  @Test
  public void modificarTitulacionExitoso() {
  }
  @Test
  public void modificarTitulacionNoEncontrada() {
  }
  @Test
  public void panelControlCrearAlumno() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("panel:selectCrear")).click();
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(1)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Insertar Alumno"));
  }
  @Test
  public void panelControlCrearAsignatura() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectCrear"));
      dropdown.findElement(By.xpath("//option[. = 'Asignatura']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(2)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Insertar Asignatura"));
  }
  @Test
  public void panelControlCrearCentro() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectCrear"));
      dropdown.findElement(By.xpath("//option[. = 'Centro']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(3)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Crear centro"));
  }
  @Test
  public void panelControlCrearClase() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectCrear"));
      dropdown.findElement(By.xpath("//option[. = 'Clase']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(4)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Crear clase"));
  }
  @Test
  public void panelControlCrearExpediente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectCrear"));
      dropdown.findElement(By.xpath("//option[. = 'Expediente']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(5)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Crear expediente"));
  }
  @Test
  public void panelControlCrearGrupo() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectCrear"));
      dropdown.findElement(By.xpath("//option[. = 'Grupo']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(6)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Crear grupo"));
  }
  @Test
  public void panelControlCrearMatricula() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectCrear"));
      dropdown.findElement(By.xpath("//option[. = 'Matrícula']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(7)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Insertar Matrícula"));
  }
  @Test
  public void panelControlCrearOptativa() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectCrear"));
      dropdown.findElement(By.xpath("//option[. = 'Optativa']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(9)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Insertar Optativa"));
  }
  @Test
  public void panelControlCrearTitulacion() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(8)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Insertar Titulación"));
  }
  @Test
  public void panelControlEliminarAlumno() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.id("panel:selectEliminar")).click();
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(1)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar Alumno"));
  }
  @Test
  public void panelControlEliminarAsignatura() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectEliminar"));
      dropdown.findElement(By.xpath("//option[. = 'Asignatura']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(2)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar Asignatura"));
  }
  @Test
  public void panelControlEliminarCentro() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectEliminar"));
      dropdown.findElement(By.xpath("//option[. = 'Centro']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(3)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar centro"));
  }
  @Test
  public void panelControlEliminarClase() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectEliminar"));
      dropdown.findElement(By.xpath("//option[. = 'Clase']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(4)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar clase"));
  }
  @Test
  public void panelControlEliminarExpediente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectEliminar"));
      dropdown.findElement(By.xpath("//option[. = 'Expediente']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(5)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar expediente"));
  }
  @Test
  public void panelControlEliminarGrupo() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectEliminar"));
      dropdown.findElement(By.xpath("//option[. = 'Grupo']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(6)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar grupo"));
  }
  @Test
  public void panelControlEliminarOptativa() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectEliminar"));
      dropdown.findElement(By.xpath("//option[. = 'Optativa']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(9)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Insertar Optativa"));
  }
  @Test
  public void panelControlEliminarTitulacion() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(8)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar Titulación"));
  }
  @Test
  public void panelControlEliminarMatricula() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectEliminar"));
      dropdown.findElement(By.xpath("//option[. = 'Matrícula']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(7)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar Matrícula"));
  }
  @Test
  public void panelControlModificarAsignatura() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectModificar"));
      dropdown.findElement(By.xpath("//option[. = 'Asignatura']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(2)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar Asignatura"));
  }
  @Test
  public void panelControlModificarAlumno() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(1)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar Alumno"));
  }
  @Test
  public void panelControlModificarClase() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectModificar"));
      dropdown.findElement(By.xpath("//option[. = 'Clase']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(4)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar clase"));
  }
  @Test
  public void panelControlModificarExpediente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(5)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar expediente"));
  }
  @Test
  public void panelControlModificarCentro() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectModificar"));
      dropdown.findElement(By.xpath("//option[. = 'Centro']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(3)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar centro"));
  }
  @Test
  public void panelControlModificarGrupo() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectModificar"));
      dropdown.findElement(By.xpath("//option[. = 'Grupo']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(6)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar grupo"));
  }
  @Test
  public void panelControlModificarMatricula() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectModificar"));
      dropdown.findElement(By.xpath("//option[. = 'Matrícula']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(7)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar Matrícula"));
  }
  @Test
  public void panelControlModificarOptativa() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectModificar"));
      dropdown.findElement(By.xpath("//option[. = 'Optativa']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(9)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar Optativa"));
  }
  @Test
  public void panelControlModificarTitulacion() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(8)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar Titulación"));
  }
  @Test
  public void modificarAlumnoExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarAlumno.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 941));
    driver.findElement(By.id("modificarAlumno:dni")).sendKeys("446753A");
    driver.findElement(By.id("modificarAlumno:nombre")).sendKeys("Diego");
    driver.findElement(By.id("modificarAlumno:apellido1")).sendKeys("Centeno");
    driver.findElement(By.id("modificarAlumno:apellido2")).sendKeys("Linares");
    driver.findElement(By.id("modificarAlumno:email")).sendKeys("07143291@uma.es");
    driver.findElement(By.id("modificarAlumno:emailP")).sendKeys("sonic@gmail.com");
    driver.findElement(By.id("modificarAlumno:grupos")).sendKeys("103-,204-B,301-A");
    driver.findElement(By.id("modificarAlumno:btonModificar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Test
  public void modificarAlumnoNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarAlumno.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarAlumno:dni")).sendKeys("123C");
    driver.findElement(By.id("modificarAlumno:nombre")).sendKeys("Pepe");
    driver.findElement(By.id("modificarAlumno:apellido1")).sendKeys("Carrasco");
    driver.findElement(By.id("modificarAlumno:apellido2")).sendKeys("Molilla");
    driver.findElement(By.id("modificarAlumno:email")).sendKeys("08917283@uma.es");
    driver.findElement(By.id("modificarAlumno:emailP")).sendKeys("mol@gmail.com");
    driver.findElement(By.id("modificarAlumno:telf")).sendKeys("000736102");
    driver.findElement(By.id("modificarAlumno:grupos")).sendKeys("103-,204-B,301-A");
    driver.findElement(By.id("modificarAlumno:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarAlumno:errorDni")).getText(), is("El alumno no se ha podido encontrar"));
  }
  @Test
  public void modificarAsignaturaExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarAsignatura.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarAsignatura:referencia")).sendKeys("232");
    driver.findElement(By.id("modificarAsignatura:cod")).sendKeys("101");
    driver.findElement(By.id("modificarAsignatura:nombre")).sendKeys("Sistemas de Computadores");
    driver.findElement(By.id("modificarAsignatura:curso")).sendKeys("1");
    driver.findElement(By.id("modificarAsignatura:cTeoria")).sendKeys("3");
    driver.findElement(By.id("modificarAsignatura:cPractica")).sendKeys("3");
    driver.findElement(By.id("modificarAsignatura:btonModificar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Test
  public void modificarAsignaturaNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarAsignatura.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarAsignatura:referencia")).sendKeys("111");
    driver.findElement(By.id("modificarAsignatura:cod")).sendKeys("234");
    driver.findElement(By.id("modificarAsignatura:nombre")).sendKeys("SI");
    driver.findElement(By.id("modificarAsignatura:curso")).sendKeys("1");
    driver.findElement(By.id("modificarAsignatura:cTeoria")).sendKeys("3");
    driver.findElement(By.id("modificarAsignatura:cTeoria")).sendKeys("2");
    driver.findElement(By.id("modificarAsignatura:cPractica")).sendKeys("4");
    driver.findElement(By.id("modificarAsignatura:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarAsignatura:errorRef")).getText(), is("La asignatura no se ha podido encontrar"));
  }
  @Test
  public void modificarCentroExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarCentro.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarCentro:id")).sendKeys("123");
    driver.findElement(By.id("modificarCentro:direccion")).sendKeys("calle tal");
    driver.findElement(By.id("modificarCentro:telefono")).sendKeys("000111222");
    driver.findElement(By.id("modificarCentro:nombre")).sendKeys("Inf0rm4T1C4");
    driver.findElement(By.id("modificarCentro:btonModificar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Test
  public void modificarClaseExitoso() {
  }
  @Test
  public void modificarCentroNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarCentro.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarCentro:id")).sendKeys("321");
    driver.findElement(By.id("modificarCentro:nombre")).sendKeys("tal");
    driver.findElement(By.id("modificarCentro:direccion")).sendKeys("calle si");
    driver.findElement(By.id("modificarCentro:telefono")).sendKeys("000111222");
    driver.findElement(By.id("modificarCentro:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarCentro:errorId")).getText(), is("El centro no se ha podido encontrar"));
  }
  @Test
  public void modificarClaseGrupoNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarClase.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 941));
    driver.findElement(By.id("j_idt5:horaInicio")).sendKeys("8:45");
    driver.findElement(By.id("j_idt5:dia")).sendKeys("23");
    driver.findElement(By.id("j_idt5:grupoId")).sendKeys("420");
    driver.findElement(By.id("j_idt5:horaFin")).sendKeys("10:30");
    driver.findElement(By.id("j_idt5:horaInicio")).sendKeys("8:45");
    driver.findElement(By.id("j_idt5:btonModificar")).click();
  }
  @Test
  public void modificarClaseNoENcontrado() {
  }
  @Test
  public void modificarClaseNoEncontrado() {
  }
  @Test
  public void modificarExpedienteExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarExpediente.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarExpediente:titulacion")).sendKeys("1234");
    driver.findElement(By.id("modificarExpediente:numExpediente")).sendKeys("12345");
    driver.findElement(By.id("modificarExpediente:notaMedia")).sendKeys("7");
    driver.findElement(By.id("modificarExpediente:dni")).sendKeys("446753A");
    driver.findElement(By.id("modificarExpediente:activo:0")).click();
    driver.findElement(By.id("modificarExpediente:btonModificar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Test
  public void modificarExpedienteNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarExpediente.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarExpediente:titulacion")).sendKeys("4321");
    driver.findElement(By.id("modificarExpediente:numExpediente")).sendKeys("54321");
    driver.findElement(By.id("modificarExpediente:dni")).sendKeys("12324A");
    driver.findElement(By.id("modificarExpediente:activo:0")).click();
    driver.findElement(By.id("modificarExpediente:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarExpediente:errorNumExpediente")).getText(), is("El expediente no se ha podido encontrar"));
  }
  @Test
  public void modificarGrupoExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarGrupo.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarGrupo:id")).sendKeys("420");
    driver.findElement(By.id("modificarGrupo:titulacion")).sendKeys("1234");
    driver.findElement(By.id("modificarGrupo:curso")).sendKeys("1");
    driver.findElement(By.id("modificarGrupo:letra")).sendKeys("A");
    driver.findElement(By.id("modificarGrupo:turno")).sendKeys("tarde");
    driver.findElement(By.id("modificarGrupo:ingles:0")).click();
    driver.findElement(By.id("modificarGrupo:visible:0")).click();
    driver.findElement(By.id("modificarGrupo:btonModificar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Test
  public void modificarMatriculaExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarMatricula.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("modificarMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("modificarMatricula:idC")).sendKeys("123");
    driver.findElement(By.id("modificarMatricula:nExp")).sendKeys("12345");
    driver.findElement(By.id("modificarMatricula:cursoA")).sendKeys("3");
    driver.findElement(By.id("modificarMatricula:fechaMatricula")).sendKeys("12/09/2020");
    driver.findElement(By.id("modificarMatricula:numArc")).sendKeys("12345678");
    driver.findElement(By.id("modificarMatricula:listadoAsignaturas")).sendKeys("103,104,105");
    driver.findElement(By.id("modificarMatricula:btonModificar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Test
  public void modificarMatriculaExpedienteNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarMatricula.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("modificarMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("modificarMatricula:idC")).sendKeys("123");
    driver.findElement(By.id("modificarMatricula:nExp")).sendKeys("12367");
    driver.findElement(By.id("modificarMatricula:cursoA")).sendKeys("3");
    driver.findElement(By.id("modificarMatricula:fechaMatricula")).sendKeys("12/09/2020");
    driver.findElement(By.id("modificarMatricula:numArc")).sendKeys("12345678");
    driver.findElement(By.id("modificarMatricula:listadoAsignaturas")).sendKeys("103,104,105");
    driver.findElement(By.id("modificarMatricula:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarMatricula:errorNExp")).getText(), is("El expediente no se ha podido encontrar"));
  }
  @Test
  public void modificarMatriculaNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarMatricula.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("modificarMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("modificarMatricula:idC")).sendKeys("123");
    driver.findElement(By.id("modificarMatricula:nExp")).sendKeys("12345");
    driver.findElement(By.id("modificarMatricula:cursoA")).sendKeys("3");
    driver.findElement(By.id("modificarMatricula:fechaMatricula")).sendKeys("12/09/2020");
    driver.findElement(By.id("modificarMatricula:numArc")).sendKeys("12345678");
    driver.findElement(By.id("modificarMatricula:listadoAsignaturas")).sendKeys("103,104,105");
    driver.findElement(By.id("modificarMatricula:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarMatricula:errorMatricula")).getText(), is("La matricula no se ha podido encontrar"));
  }
  @Test
  public void modificarGrupoNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarGrupo.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarGrupo:id")).sendKeys("320");
    driver.findElement(By.id("modificarGrupo:titulacion")).sendKeys("1234");
    driver.findElement(By.id("modificarGrupo:curso")).sendKeys("1");
    driver.findElement(By.id("modificarGrupo:letra")).sendKeys("A");
    driver.findElement(By.id("modificarGrupo:turno")).sendKeys("tarde");
    driver.findElement(By.id("modificarGrupo:ingles:0")).click();
    driver.findElement(By.id("modificarGrupo:visible:0")).click();
    driver.findElement(By.id("modificarGrupo:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarGrupo:errorId")).getText(), is("Grupo no encontrado"));
  }
  @Test
  public void modificarGrupoTitulacionNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarGrupo.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarTitulacion:id")).sendKeys("420");
    driver.findElement(By.id("modificarTitulacion:titulacion")).sendKeys("1235");
    driver.findElement(By.id("modificarTitulacion:curso")).sendKeys("1");
    driver.findElement(By.id("modificarTitulacion:letra")).sendKeys("A");
    driver.findElement(By.id("modificarTitulacion:turno")).sendKeys("tarde");
    driver.findElement(By.id("modificarTitulacion:ingles:0")).click();
    driver.findElement(By.id("modificarTitulacion:visible:0")).click();
    driver.findElement(By.id("modificarTitulacion:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarTitulacion:errorTitulacion")).getText(), is("Titulacion no encontrada"));
  }
  @Test
  public void modificarOptativaExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarOptativa.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarOptativa:idC")).sendKeys("123");
    driver.findElement(By.id("modificarOptativa:codTitu")).sendKeys("1234");
    driver.findElement(By.id("modificarOptativa:referencia")).sendKeys("233");
    driver.findElement(By.id("modificarOptativa:cod")).sendKeys("102");
    driver.findElement(By.id("modificarOptativa:cTeoria")).sendKeys("3");
    driver.findElement(By.id("modificarOptativa:cPractica")).sendKeys("3");
    driver.findElement(By.id("modificarMatriculaid=modificarOptativa")).sendKeys("Empresa");
    driver.findElement(By.id("modificarOptativa:curso")).sendKeys("3");
    driver.findElement(By.id("modificarOptativa:nombre")).sendKeys("Economia");
    driver.findElement(By.id("modificarOptativa:btonModificar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Test
  public void modificarOptativaNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/modificarOptativa.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("modificarOptativa:idC")).sendKeys("123");
    driver.findElement(By.id("modificarOptativa:codTitu")).sendKeys("12344");
    driver.findElement(By.id("modificarOptativa:referencia")).sendKeys("233");
    driver.findElement(By.id("modificarOptativa:cod")).sendKeys("102");
    driver.findElement(By.id("modificarOptativa:cTeoria")).sendKeys("3");
    driver.findElement(By.id("modificarOptativa:cPractica")).sendKeys("3");
    driver.findElement(By.id("modificarOptativa:mencion")).sendKeys("Empresa");
    driver.findElement(By.id("modificarOptativa:curso")).sendKeys("3");
    driver.findElement(By.id("modificarOptativa:nombre")).sendKeys("Economia");
    driver.findElement(By.id("modificarOptativa:btonModificar")).click();
    assertThat(driver.findElement(By.id("modificarOptativa:errorIdC")).getText(), is("La optativa no se ha podido encontrar"));
  }
  @Test
  public void alumnoVistaAccedeEncuesta() {
    driver.get("http://0.0.0.0:8080/jpa.saneka-war/faces/alumnoVista.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 827));
    driver.findElement(By.id("alumnoVista:linkEncuesta")).click();
    assertThat(driver.getTitle(), is("Encuesta"));
  }
  @Test
  public void encuestaExitoVolverLogin() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/encuestaExito.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 827));
    driver.findElement(By.id("linkVolver")).click();
    assertThat(driver.getTitle(), is("Login"));
  }
  @Test
  public void encuestaExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/encuesta.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 827));
    driver.findElement(By.id("encuesta:turno:0")).click();
    driver.findElement(By.id("encuesta:btonEnvia")).click();
    assertThat(driver.getTitle(), is("Encuesta se ha realizado con exito"));
  }

}