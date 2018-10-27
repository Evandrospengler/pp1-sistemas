package beans;

import dao.UsuarioDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

    public UsuarioBean() {
    }

    public void insertAction() {
        usuarioDAO.insert(usuario);
    }
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        if(this.usuarios == null){
        this.usuarios = usuarioDAO.findAll();
        }
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
