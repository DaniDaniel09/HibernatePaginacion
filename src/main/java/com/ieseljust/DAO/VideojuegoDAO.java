/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ieseljust.DAO;

import com.ieseljust.ORM.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ieseljust.Model.Videojuego;
import java.util.List;
import org.hibernate.query.Query;

/**
 *
 * @author Daniel
 */
public class VideojuegoDAO {
    public void insertVideojuego(Videojuego vj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(vj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tus necesidades)
        }
    }
    public void updateVideojuego(Videojuego vj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(vj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tus necesidades)
        }
    }
    public void deleteVideojuego(Videojuego vj) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(vj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Manejo de la excepción (puedes personalizarlo según tus necesidades)
        }
    }
    public List<Videojuego> getVideojuegosPaginados(int pageNumber, int pageSize) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Videojuego> query = session.createQuery("FROM Videojuego", Videojuego.class);
            query.setFirstResult((pageNumber - 1) * pageSize);
            query.setMaxResults(pageSize);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Error al obtener videojuegos paginados: ");
            e.printStackTrace();
            return null;
        }
    }
    
}
