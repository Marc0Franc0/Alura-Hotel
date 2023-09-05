/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.persistence;

import app.model.Guest;
import app.persistence.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author marco
 */
public class GuestsJpaController implements Serializable {

    public GuestsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     public GuestsJpaController() {
        this.emf = Persistence.createEntityManagerFactory("HotelPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Guest guests) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(guests);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Guest guests) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            guests = em.merge(guests);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = guests.getId();
                if (findGuests(id) == null) {
                    throw new NonexistentEntityException("The guests with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Guest guests;
            try {
                guests = em.getReference(Guest.class, id);
                guests.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The guests with id " + id + " no longer exists.", enfe);
            }
            em.remove(guests);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Guest> findGuestsEntities() {
        return findGuestsEntities(true, -1, -1);
    }

    public List<Guest> findGuestsEntities(int maxResults, int firstResult) {
        return findGuestsEntities(false, maxResults, firstResult);
    }

    private List<Guest> findGuestsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Guest.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Guest findGuests(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Guest.class, id);
        } finally {
            em.close();
        }
    }

    public int getGuestsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Guest> rt = cq.from(Guest.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
