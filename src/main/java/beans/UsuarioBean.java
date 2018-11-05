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

    private boolean formAtivo = false;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioBean() {
    }

    public void Salvar() {
        if (usuario.getCodusuario() > 0) {
            usuarioDAO.Editar(usuario);
        } else {
            usuarioDAO.Inserir(usuario);
        }
        usuario = new Usuario();
        getUsuarios();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void PreparaEdicao(Usuario o) {
        this.usuario = o;        
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        usuarios = usuarioDAO.ListarTodos();
        return usuarioDAO.ListarTodos();
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void Excluir(Usuario usuario) {
        usuarioDAO.Excluir(usuario);
        //return "userio";
    }

    public boolean isFormAtivo() {
        return formAtivo;
    }

    public void setFormAtivo(boolean formAtivo) {
        this.formAtivo = formAtivo;
    }
}
