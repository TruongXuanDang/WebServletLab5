package com.demo.dao;

import com.demo.entity.Product;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Stateless
public class ProductDAO {
//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
//    EntityManager em = emf.createEntityManager();

    @PersistenceUnit
    EntityManagerFactory emf;
//

    public ProductDAO() {
    }

    public Integer insertProduct(Product p)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        Integer id = p.getId();
        em.close();
        return id;
    }

    public Integer updateProduct(int id, Product product)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product p = em.find(Product.class, id);
        p.setName(product.getName());
        p.setPrice(product.getPrice());
        p.setQuantity(product.getQuantity());
        em.getTransaction().commit();
        Integer success = p.getId();
        em.close();
        return success;
    }

    public void deleteProduct(int id)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product p = em.find(Product.class, id);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    public List<Product> getProduct()
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Product> list = em.createQuery("SELECT c from Product c", Product.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }
}
