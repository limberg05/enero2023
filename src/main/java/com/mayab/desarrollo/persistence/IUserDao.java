package com.mayab.desarrollo.persistence;

import java.util.List;

import com.mayab.desarrollo.entities.Usuario;

public interface IUserDao {

    public List<Usuario> findAll();

    public int createUser(Usuario usuario);

    public boolean deleteUser(int id);

    public Usuario findById(int id);

    public Usuario updatePass(Usuario usuario, String NContra);

    public Usuario findByName(String nombre);

    public Usuario findByEmail(String email);
}
