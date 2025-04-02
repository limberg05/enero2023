package com.mayab.desarrollo.servicios;

import java.util.List;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.persistence.UserDao;

public class LoginServicio {

    private final UserDao dao;

    public LoginServicio(UserDao d) {
        this.dao = d;
    }

    public Usuario createUser(String username, String pass, String email) {
        Usuario usuario = new Usuario();
        usuario.setPassword(pass);
        usuario.setNombre(username);
        usuario.setEmail(email);
        int id = dao.createUser(usuario);
        usuario.setId(id);
        System.out.println("EL ID ES: " + id);
        return usuario;
    }

    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    public void updatePass(Usuario usuario, String contra) {
        dao.updatePass(usuario, contra);
    }

    public List<Usuario> findAll() {
        return dao.findAll();
    }

    public Usuario findUsuarioById(int id) {
        return dao.findById(id);
    }

    public Usuario findUsuarioByName(String nombre) {
        return dao.findByName(nombre);
    }

    public Usuario findUsuarioByEmail(String email) {
        return dao.findByEmail(email);
    }
}
