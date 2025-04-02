package com.mayab.desarrollo.main;

import java.util.List;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.persistence.UserDao;
import com.mayab.desarrollo.servicios.LoginServicio;

public class Test {

    public static void main(String[] args) {

        UserDao dao = new UserDao();
        LoginServicio servicio = new LoginServicio(dao);

        Usuario usuario1 = servicio.createUser("username1", "pass", "email");
        Usuario usario2 = servicio.createUser("username2", "pass2", "email2");

        servicio.updatePass(usuario1, "otropass");
        List<Usuario> lista = (List<Usuario>) servicio.findAll();
        for (Usuario usuario : lista) {
            System.out.println(usuario.toString());
        }
        servicio.deleteUser(1);
        lista = (List<Usuario>) servicio.findAll();
        for (Usuario usuario : lista) {
            System.out.println(usuario.toString());
        }

    }

}
