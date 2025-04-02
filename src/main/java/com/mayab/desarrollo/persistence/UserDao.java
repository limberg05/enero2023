package com.mayab.desarrollo.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.main.HibernateUtil;

public class UserDao implements IUserDao {

    @Override
    public int createUser(Usuario usuario) {
        int id;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            id = (int) session.save(usuario);
            session.getTransaction().commit();
        }
        return id;
    }

    @Override
    public boolean deleteUser(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, id);
            session.delete(usuario);
            session.getTransaction().commit();
        }
        return true;
    }

    @Override
    public Usuario updatePass(Usuario usuario, String contra) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            //Usuario user_to_update = session.get(Usuario.class, usuario.getId());
            //user_to_update.setPassword(contra);
            usuario.setPassword(contra);
            session.update(usuario);
            session.getTransaction().commit();
        }
        return usuario;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> lista;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("FROM Usuario");
            lista = query.getResultList();
        }

        return lista;
    }

    @Override
    public Usuario findById(int id) {
        Usuario usuario;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            usuario = session.get(Usuario.class, id);
        }
        return usuario;
    }

    @Override
    public Usuario findByName(String nombre) {
        Usuario usuario;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM Usuario WHERE name = :nombre");
            query.setParameter("nombre", nombre);
            usuario = (Usuario) query.uniqueResult();
        }

        return usuario;
    }

    @Override
    public Usuario findByEmail(String email) {
        Usuario usuario;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            @SuppressWarnings("rawtypes")
            Query query = session.createQuery("FROM Usuario WHERE email = :email");
            query.setParameter("email", email);
            usuario = (Usuario) query.uniqueResult();
        }

        return usuario;
    }

}
