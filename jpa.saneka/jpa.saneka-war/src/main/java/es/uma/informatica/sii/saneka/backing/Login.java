package es.uma.informatica.sii.saneka.backing;


import es.uma.informatica.ejb.exceptions.ContraseniaInvalidaException;
import es.uma.informatica.ejb.exceptions.SanekaException;
import es.uma.informatica.ejb.exceptions.UsuarioNoEncontradoException;
import es.uma.informatica.ejb.saneka.GestionUsuario;
import es.uma.informatica.jpa.saneka.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "login")
@RequestScoped
public class Login {

    @Inject
    private GestionUsuario gestion;

    @Inject
    private InfoSesion sesion;
    private Usuario usuario;

    /**
     * Creates a new instance of login
     */
    public Login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String entrar() {
        try {
            gestion.compruebaLogin(usuario);
            sesion.setUsuario(gestion.refrescarUsuario(usuario));
            //System.out.println(usuario.getContrasenia()+usuario.getEmailInstitucional());
            Usuario u = gestion.devolverUsuario(usuario.getEmailInstitucional());
            if(u.getSecretaria()) {
            	return "panelControl.xhtml";
            }else {
            	return "alumnoVista.xhtml";
            }
        } catch (UsuarioNoEncontradoException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (SanekaException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }

}