package es.uma.informatica.sii.saneka.backing;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named(value = "saludo")
@RequestScoped
public class Saludo {
	public String getSaludo() {
		return "Hola Mundo";
	}
}
