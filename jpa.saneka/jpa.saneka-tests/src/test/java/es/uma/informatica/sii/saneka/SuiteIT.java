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

import es.uma.informatica.sii.anotaciones.Requisitos;

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
  
  @Requisitos({"RF-7"})
  @Test
  public void loginContraseniaIncorrecta() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).sendKeys("sec1@uma.es");
    driver.findElement(By.id("login:password")).sendKeys("321");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.findElement(By.id("login:errorPassword")).getText(), is("La contraseña no es correcta"));
  }
  @Requisitos({"RF-7"})
  @Test
  public void loginContraseniaRequerida() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).click();
    driver.findElement(By.id("login:correo")).sendKeys("sec1@uma.es");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.findElement(By.id("login:errorPassword")).getText(), is("login:password: Validation Error: Value is required."));
  }
  @Requisitos({"RF-7"})
  @Test
  public void loginCorreoRequerido() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:password")).sendKeys("123");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.findElement(By.id("login:errorCorreo")).getText(), is("login:correo: Validation Error: Value is required."));
  }
  @Requisitos({"RF-7"})
  @Test
  public void loginExitosoAlumno() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).sendKeys("07143291@uma.es");
    driver.findElement(By.id("login:password")).sendKeys("123");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.getTitle(), is("Página principal"));
  }
  @Requisitos({"RF-7"})
  @Test
  public void loginExitosoSecretaria() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).sendKeys("sec1@uma.es");
    driver.findElement(By.id("login:password")).sendKeys("123");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.getTitle(), is("Panel de control de Secretaria"));
  }
  @Requisitos({"RF-7"})
  @Test
  public void loginUsuarioNoEncontrado() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    driver.findElement(By.id("login:correo")).sendKeys("Pepe@uma.es");
    driver.findElement(By.id("login:password")).sendKeys("123");
    driver.findElement(By.id("login:btonEntrar")).click();
    assertThat(driver.findElement(By.id("login:errorCorreo")).getText(), is("La cuenta no existe"));
  }
  @Requisitos({"RF-3"})
  @Test
  public void paginaIndice() {
    driver.get("http://localhost:8080/jpa.saneka-war/");
    driver.manage().window().setSize(new Dimension(1086, 670));
    assertThat(driver.getTitle(), is("Login"));
  }
 
  @Requisitos({"RF-3"})
  @Test
  public void panelControlCrearAlumno() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 724));
    driver.findElement(By.id("panel:selectCrear")).click();
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(1)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Insertar Alumno"));
  }
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
  @Test
  public void panelControlCrearTitulacion() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectCrear > option:nth-child(8)")).click();
    driver.findElement(By.id("panel:btonCrear")).click();
    assertThat(driver.getTitle(), is("Insertar Titulación"));
  }
  @Requisitos({"RF-3"})
  @Test
  public void panelControlEliminarAlumno() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.id("panel:selectEliminar")).click();
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(1)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar Alumno"));
  }
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
  @Test
  public void panelControlEliminarTitulacion() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(8)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar Titulación"));
  }
  @Requisitos({"RF-3"})
  @Test
  public void panelControlEliminarMatricula() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    {
      WebElement dropdown = driver.findElement(By.id("panel:selectEliminar"));
      dropdown.findElement(By.xpath("//option[. = 'Matrícula']")).click();
    }
    driver.findElement(By.cssSelector("#panel\\3AselectEliminar > option:nth-child(7)")).click();
    driver.findElement(By.id("panel:btonELiminar")).click();
    assertThat(driver.getTitle(), is("Eliminar Matrícula"));
  }
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
  @Test
  public void panelControlModificarAlumno() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(1)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar Alumno"));
  }
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
  @Test
  public void panelControlModificarExpediente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(5)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar expediente"));
  }
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
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
  @Requisitos({"RF-3"})
  @Test
  public void panelControlModificarTitulacion() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/panelControl.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 726));
    driver.findElement(By.cssSelector("#panel\\3AselectModificar > option:nth-child(8)")).click();
    driver.findElement(By.id("panel:btonModificar")).click();
    assertThat(driver.getTitle(), is("Modificar Titulación"));
  }
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-2"})
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
    driver.findElement(By.id("modificarOptativa:mencion")).sendKeys("Empresa");
    driver.findElement(By.id("modificarOptativa:curso")).sendKeys("3");
    driver.findElement(By.id("modificarOptativa:nombre")).sendKeys("Economia");
    driver.findElement(By.id("modificarOptativa:btonModificar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-2"})
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
  @Requisitos({"RF-3"})
  @Test
  public void alumnoVistaAccedeEncuesta() {
    driver.get("http://0.0.0.0:8080/jpa.saneka-war/faces/alumnoVista.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 827));
    driver.findElement(By.id("alumnoVista:linkEncuesta")).click();
    assertThat(driver.getTitle(), is("Encuesta"));
  }
  @Requisitos({"RF-3"})
  @Test
  public void encuestaExitoVolverLogin() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/encuestaExito.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 827));
    driver.findElement(By.id("linkVolver")).click();
    assertThat(driver.getTitle(), is("Login"));
  }
  @Requisitos({"RF-3"})
  @Test
  public void encuestaExitoso() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/encuesta.xhtml");
    driver.manage().window().setSize(new Dimension(1186, 827));
    driver.findElement(By.id("encuesta:turno:0")).click();
    driver.findElement(By.id("encuesta:btonEnvia")).click();
    assertThat(driver.getTitle(), is("Encuesta se ha realizado con exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearAlumnoSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearAlumno.xhtml");
    driver.findElement(By.id("crearAlumno:dni")).sendKeys("1980");
    driver.findElement(By.id("crearAlumno:nombre")).sendKeys("alumnotest");
    driver.findElement(By.id("crearAlumno:apellido1")).sendKeys("alumno");
    driver.findElement(By.id("crearAlumno:apellido2")).sendKeys("test");
    driver.findElement(By.id("crearAlumno:email")).sendKeys("test@test.com");
    driver.findElement(By.id("crearAlumno:btonCrear")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearAlumnoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearAlumno.xhtml");
    driver.findElement(By.id("crearAlumno:dni")).sendKeys("446753A");
    driver.findElement(By.id("crearAlumno:nombre")).sendKeys("Diego");
    driver.findElement(By.id("crearAlumno:apellido1")).sendKeys("Centeno");
    driver.findElement(By.id("crearAlumno:email")).sendKeys("07143291@uma.es");
    driver.findElement(By.id("crearAlumno:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearAlumno:errorDni")).getText(), is("El alumno ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearAsignaturaExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearAsignatura.xhtml");
    driver.findElement(By.id("crearAsignatura:idC")).sendKeys("123");
    driver.findElement(By.id("crearAsignatura:codTitu")).sendKeys("1234");
    driver.findElement(By.id("crearAsignatura:referencia")).sendKeys("232");
    driver.findElement(By.id("crearAsignatura:cod")).sendKeys("101");
    driver.findElement(By.id("crearAsignatura:ofer:0")).click();
    driver.findElement(By.id("crearAsignatura:cTeoria")).sendKeys("6");
    driver.findElement(By.id("crearAsignatura:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearAsignatura:errorRef")).getText(), is("La asignatura ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearAsignaturaSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearAsignatura.xhtml");
    driver.findElement(By.id("crearAsignatura:referencia")).sendKeys("6464");
    driver.findElement(By.id("crearAsignatura:idC")).sendKeys("123");
    driver.findElement(By.id("crearAsignatura:codTitu")).sendKeys("1234");
    driver.findElement(By.id("crearAsignatura:cod")).sendKeys("410");
    driver.findElement(By.id("crearAsignatura:ofer:0")).click();
    driver.findElement(By.id("crearAsignatura:cTeoria")).sendKeys("12");
    driver.findElement(By.id("crearAsignatura:btonCrear")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearCentroExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearCentro.xhtml");
    driver.findElement(By.id("crearCentro:id")).sendKeys("123");
    driver.findElement(By.id("crearCentro:nombre")).sendKeys("informatica");
    driver.findElement(By.id("crearCentro:direccion")).sendKeys("avenida de andalucia n11");
    driver.findElement(By.id("crearCentro:telefono")).sendKeys("23446");
    driver.findElement(By.id("crearCentro:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearCentro:errorId")).getText(), is("El centro ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearCentroSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearCentro.xhtml");
    driver.findElement(By.id("crearCentro:id")).sendKeys("1234");
    driver.findElement(By.id("crearCentro:nombre")).sendKeys("test");
    driver.findElement(By.id("crearCentro:direccion")).sendKeys("test");
    driver.findElement(By.id("crearCentro:telefono")).sendKeys("1234321");
    driver.findElement(By.id("crearCentro:btonCrear")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearClaseExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearClase.xhtml");
    driver.findElement(By.id("crearClase:dia")).sendKeys("23");
    driver.findElement(By.id("crearClase:asignatura")).sendKeys("232");
    driver.findElement(By.id("crearClase:horaInicio")).sendKeys("8:45");
    driver.findElement(By.id("crearClase:grupoId")).sendKeys("420");
    driver.findElement(By.id("crearClase:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearClase:errorClase")).getText(), is("La clase ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearClaseSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearClase.xhtml");
    driver.findElement(By.id("crearClase:dia")).sendKeys("6");
    driver.findElement(By.id("crearClase:horaInicio")).sendKeys("08");
    driver.findElement(By.id("crearClase:asignatura")).sendKeys("232");
    driver.findElement(By.id("crearClase:grupoId")).sendKeys("423");
    driver.findElement(By.id("crearClase:horaFin")).sendKeys("14");
    driver.findElement(By.id("crearClase:btonCrear")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearClaseSinGrupo() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearClase.xhtml");
    driver.findElement(By.id("crearClase:dia")).sendKeys("3");
    driver.findElement(By.id("crearClase:asignatura")).sendKeys("232");
    driver.findElement(By.id("crearClase:horaInicio")).sendKeys("15");
    driver.findElement(By.id("crearClase:grupoId")).sendKeys("111111");
    driver.findElement(By.id("crearClase:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearClase:errorGrupo")).getText(), is("El grupo no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearExpedienteExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearExpediente.xhtml");
    driver.findElement(By.id("crearExpediente:titulacion")).sendKeys("1234");
    driver.findElement(By.id("crearExpediente:numExpediente")).sendKeys("12345");
    driver.findElement(By.id("crearExpediente:dni")).sendKeys("446753A");
    driver.findElement(By.id("crearExpediente:activo:0")).click();
    driver.findElement(By.id("crearExpediente:crea")).click();
    assertThat(driver.findElement(By.id("crearExpediente:errorExp")).getText(), is("El expediente ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearGrupoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearGrupo.xhtml");
    driver.findElement(By.id("crearGrupo:id")).sendKeys("420");
    driver.findElement(By.id("crearGrupo:titulacion")).sendKeys("1234");
    driver.findElement(By.id("crearGrupo:curso")).sendKeys("3");
    driver.findElement(By.id("crearGrupo:letra")).sendKeys("B");
    driver.findElement(By.id("crearGrupo:turno")).sendKeys("tarde");
    driver.findElement(By.id("crearGrupo:ingles:1")).click();
    driver.findElement(By.id("crearGrupo:visible:0")).click();
    driver.findElement(By.id("crearGrupo:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearGrupo:errorGrupo")).getText(), is("El grupo ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearMatriculaExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearMatricula.xhtml");
    driver.findElement(By.id("crearMatricula:idC")).sendKeys("123");
    driver.findElement(By.id("crearMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("crearMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("crearMatricula:nExp")).sendKeys("12345");
    driver.findElement(By.id("crearMatricula:cursoA")).sendKeys("3");
    driver.findElement(By.id("crearMatricula:fechaMatrícula")).sendKeys("12/09/2020");
    driver.findElement(By.id("crearMatricula:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearMatricula:errorMatricula")).getText(), is("La matricula ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearOptativaExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearOptativa.xhtml");
    driver.findElement(By.id("crearOptativa:idC")).sendKeys("123");
    driver.findElement(By.id("crearOptativa:codTitu")).sendKeys("1234");
    driver.findElement(By.id("crearOptativa:referencia")).sendKeys("233");
    driver.findElement(By.id("crearOptativa:cod")).sendKeys("102");
    driver.findElement(By.id("crearOptativa:ofer:0")).click();
    driver.findElement(By.id("crearOptativa:cTeoria")).sendKeys("6");
    driver.findElement(By.id("crearOptativa:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearOptativa:errorId")).getText(), is("La optativa ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearTitulacionExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearTitulacion.xhtml");
    driver.findElement(By.id("crearTitulacion:idC")).sendKeys("123");
    driver.findElement(By.id("crearTitulacion:codTitu")).sendKeys("1234");
    driver.findElement(By.id("crearTitulacion:cred")).sendKeys("6");
    driver.findElement(By.id("crearTitulacion:nombre")).sendKeys("infor");
    driver.findElement(By.id("crearTitulacion:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearTitulacion:errorId")).getText(), is("La titulacion ya existe"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearGrupoSinTitulacion() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearGrupo.xhtml");
    driver.findElement(By.id("crearGrupo:id")).sendKeys("460");
    driver.findElement(By.id("crearGrupo:titulacion")).sendKeys("1111");
    driver.findElement(By.id("crearGrupo:curso")).sendKeys("4");
    driver.findElement(By.id("crearGrupo:letra")).sendKeys("A");
    driver.findElement(By.id("crearGrupo:turno")).sendKeys("M");
    driver.findElement(By.id("crearGrupo:visible:0")).click();
    driver.findElement(By.id("crearGrupo:ingles:1")).click();
    driver.findElement(By.id("crearGrupo:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearGrupo:errorTitulacion")).getText(), is("La titulacion no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearMatriculaSinExpediente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearMatricula.xhtml");
    driver.findElement(By.id("crearMatricula:nExp")).sendKeys("11111");
    driver.findElement(By.id("crearMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("crearMatricula:idC")).sendKeys("123");
    driver.findElement(By.id("crearMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("crearMatricula:cursoA")).sendKeys("4");
    driver.findElement(By.id("crearMatricula:fechaMatrícula")).sendKeys("14/07/2019");
    driver.findElement(By.id("crearMatricula:btonCrear")).click();
    assertThat(driver.findElement(By.id("crearMatricula:errorExpediente")).getText(), is("El expediente no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearExpedienteSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearExpediente.xhtml");
    driver.findElement(By.id("crearExpediente:titulacion")).sendKeys("1234");
    driver.findElement(By.id("crearExpediente:numExpediente")).sendKeys("10000");
    driver.findElement(By.id("crearExpediente:dni")).sendKeys("770341P");
    driver.findElement(By.id("crearExpediente:activo:0")).click();
    driver.findElement(By.id("crearExpediente:crea")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Test
  public void crearGrupoSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearGrupo.xhtml");
    driver.findElement(By.id("crearGrupo:id")).sendKeys("450");
    driver.findElement(By.id("crearGrupo:titulacion")).sendKeys("1234");
    driver.findElement(By.id("crearGrupo:curso")).sendKeys("4");
    driver.findElement(By.id("crearGrupo:letra")).sendKeys("A");
    driver.findElement(By.id("crearGrupo:turno")).sendKeys("M");
    driver.findElement(By.id("crearGrupo:ingles:1")).click();
    driver.findElement(By.id("crearGrupo:visible:0")).click();
    driver.findElement(By.id("crearGrupo:btonCrear")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearMatriculaSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearMatricula.xhtml");
    driver.findElement(By.id("crearMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("crearMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("crearMatricula:idC")).sendKeys("123");
    driver.findElement(By.id("crearMatricula:cursoA")).sendKeys("4");
    driver.findElement(By.id("crearMatricula:fechaMatrícula")).sendKeys("13/08/2021");
    driver.findElement(By.id("crearMatricula:nExp")).sendKeys("12345");
    driver.findElement(By.id("crearMatricula:btonCrear")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearOptativaSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearOptativa.xhtml");
    driver.findElement(By.id("crearOptativa:referencia")).sendKeys("8888");
    driver.findElement(By.id("crearOptativa:cod")).sendKeys("450");
    driver.findElement(By.id("crearOptativa:ofer:0")).click();
    driver.findElement(By.id("crearOptativa:cTeoria")).sendKeys("12");
    driver.findElement(By.id("crearOptativa:btonCrear")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void crearTitulacionSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/crearTitulacion.xhtml");
    driver.findElement(By.id("crearTitulacion:codTitu")).sendKeys("12356");
    driver.findElement(By.id("crearTitulacion:nombre")).sendKeys("lul");
    driver.findElement(By.id("crearTitulacion:btonCrear")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarAlumnoNoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarAlumno.xhtml");
    driver.findElement(By.id("eliminarAlumno:dni")).sendKeys("4444444");
    driver.findElement(By.id("eliminarAlumno:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarAlumno:errorDni")).getText(), is("El alumno no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarAlumnoSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarAlumno.xhtml");
    driver.findElement(By.id("eliminarAlumno:dni")).sendKeys("374147G");
    driver.findElement(By.id("eliminarAlumno:btonEliminar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarAsignaturaNoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarAsignatura.xhtml");
    driver.findElement(By.id("eliminarAsignatura:idC")).sendKeys("123");
    driver.findElement(By.id("eliminarAsignatura:codTitu")).sendKeys("1234");
    driver.findElement(By.id("eliminarAsignatura:ref")).sendKeys("88888");
    driver.findElement(By.id("eliminarAsignatura:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarAsignatura:errorRef")).getText(), is("La asignatura no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarAsignaturaSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarAsignatura.xhtml");
    driver.findElement(By.id("eliminarAsignatura:idC")).sendKeys("101");
    driver.findElement(By.id("eliminarAsignatura:codTitu")).sendKeys("1234");
    driver.findElement(By.id("eliminarAsignatura:ref")).sendKeys("235");
    driver.findElement(By.id("eliminarAsignatura:btonEliminar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarCentroNoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarCentro.xhtml");
    driver.findElement(By.id("eliminarCentro:centroId")).sendKeys("99999");
    driver.findElement(By.id("eliminarCentro:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarCentro:errorId")).getText(), is("El centro no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarCentroSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarCentro.xhtml");
    driver.findElement(By.id("eliminarCentro:centroId")).sendKeys("125");
    driver.findElement(By.id("eliminarCentro:btonEliminar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarExpedienteNoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarExpediente.xhtml");
    driver.findElement(By.id("eliminarExpediente:titulacion")).sendKeys("1234");
    driver.findElement(By.id("eliminarExpediente:numExpediente")).sendKeys("99999");
    driver.findElement(By.id("eliminarExpediente:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarExpediente:errorExp")).getText(), is("El expediente no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarExpedienteSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarExpediente.xhtml");
    driver.findElement(By.id("eliminarExpediente:titulacion")).sendKeys("1234");
    driver.findElement(By.id("eliminarExpediente:numExpediente")).sendKeys("12349");
    driver.findElement(By.id("eliminarExpediente:btonEliminar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarGrupoNoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarGrupo.xhtml");
    driver.findElement(By.id("eliminarGrupo:titulacion")).sendKeys("1234");
    driver.findElement(By.id("eliminarGrupo:grupoId")).sendKeys("99999");
    driver.findElement(By.id("eliminarGrupo:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarGrupo:errorGrupo")).getText(), is("El grupo no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarGrupoSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarGrupo.xhtml");
    driver.findElement(By.id("eliminarGrupo:titulacion")).sendKeys("1234");
    driver.findElement(By.id("eliminarGrupo:grupoId")).sendKeys("423");
    driver.findElement(By.id("eliminarGrupo:btonEliminar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarGrupoSinTitulacion() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarGrupo.xhtml");
    driver.findElement(By.id("eliminarGrupo:titulacion")).sendKeys("9999");
    driver.findElement(By.id("eliminarGrupo:grupoId")).sendKeys("420");
    driver.findElement(By.id("eliminarGrupo:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarGrupo:errorTitulacion")).getText(), is("La titulacion no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarMatriculaNoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarMatricula.xhtml");
    driver.findElement(By.id("eliminarMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("eliminarMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("eliminarMatricula:dC")).sendKeys("123");
    driver.findElement(By.id("eliminarMatricula:nExp")).sendKeys("12345");
    driver.findElement(By.id("eliminarMatricula:cursoA")).sendKeys("4");
    driver.findElement(By.id("eliminarMatricula:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarMatricula:errorMatricula")).getText(), is("La matricula no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarMatriculaSastisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarMatricula.xhtml");
    driver.findElement(By.id("eliminarMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("eliminarMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("eliminarMatricula:idC")).sendKeys("123");
    driver.findElement(By.id("eliminarMatricula:nExp")).sendKeys("12348");
    driver.findElement(By.id("eliminarMatricula:cursoA")).sendKeys("6");
    driver.findElement(By.id("eliminarMatricula:btonEliminar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarMatriculaSinExpediente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarMatricula.xhtml");
    driver.findElement(By.id("eliminarMatricula:dni")).sendKeys("446753A");
    driver.findElement(By.id("eliminarMatricula:codTitu")).sendKeys("1234");
    driver.findElement(By.id("eliminarMatricula:idC")).sendKeys("123");
    driver.findElement(By.id("eliminarMatricula:nExp")).sendKeys("99999");
    driver.findElement(By.id("eliminarMatricula:cursoA")).sendKeys("3");
    driver.findElement(By.id("eliminarMatricula:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarMatricula:errorExpediente")).getText(), is("El expediente no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarOptativaNoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarOptativa.xhtml");
    driver.findElement(By.id("eliminarOptativa:idC")).sendKeys("123");
    driver.findElement(By.id("eliminarOptativa:codTitu")).sendKeys("1234");
    driver.findElement(By.id("eliminarOptativa:referencia")).sendKeys("999");
    driver.findElement(By.id("eliminarOptativa:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarOptativa:errorId")).getText(), is("La optativa no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarOptativaSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarOptativa.xhtml");
    driver.findElement(By.id("eliminarOptativa:idC")).sendKeys("123");
    driver.findElement(By.id("eliminarOptativa:codTitu")).sendKeys("1234");
    driver.findElement(By.id("eliminarOptativa:referencia")).sendKeys("240");
    driver.findElement(By.id("eliminarOptativa:btonEliminar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarTitulacionNoExistente() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarTitulacion.xhtml");
    driver.findElement(By.id("eliminarTitulacion:idC")).sendKeys("123");
    driver.findElement(By.id("eliminarTitulacion:codTitu")).sendKeys("99999");
    driver.findElement(By.id("eliminarTitulacion:btonEliminar")).click();
    assertThat(driver.findElement(By.id("eliminarTitulacion:errorId")).getText(), is("La titulacion no se ha podido encontrar"));
  }
  @Requisitos({"RF-8"})
  @Test
  public void eliminarTitulacionSatisfactorio() {
    driver.get("http://localhost:8080/jpa.saneka-war/faces/eliminarTitulacion.xhtml");
    driver.findElement(By.id("eliminarTitulacion:idC")).sendKeys("123");
    driver.findElement(By.id("eliminarTitulacion:codTitu")).sendKeys("1236");
    driver.findElement(By.id("eliminarTitulacion:btonEliminar")).click();
    assertThat(driver.getTitle(), is("Exito"));
  }
 
}