/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.persistence;

import app.model.Reserve;
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
public class ReserveJpaController implements Serializable {

    public ReserveJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }  
    
    public ReserveJpaController() {
        this.emf = Persistence.createEntityManagerFactory("HotelPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
   

    public void create(Reserve reserve) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reserve);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserve reserve) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reserve = em.merge(reserve);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reserve.getId();
                if (findReserve(id) == null) {
                    throw new NonexistentEntityException("The reserve with id " + id + " no longer exists.");
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
            Reserve reserve;
            try {
                reserve = em.getReference(Reserve.class, id);
                reserve.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserve with id " + id + " no longer exists.", enfe);
            }
            em.remove(reserve);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserve> findReserveEntities() {
        return findReserveEntities(true, -1, -1);
    }

    public List<Reserve> findReserveEntities(int maxResults, int firstResult) {
        return findReserveEntities(false, maxResults, firstResult);
    }

    private List<Reserve> findReserveEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserve.class));
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

    public Reserve findReserve(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserve.class, id);
        } finally {
            em.close();
        }
    }

    public int getReserveCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserve> rt = cq.from(Reserve.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
