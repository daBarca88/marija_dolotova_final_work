package lv.lu.finalwork.repository;

import lv.lu.finalwork.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class ProductOrmRepository implements lv.lu.finalwork.repository.Repository<Product> {


    private final SessionFactory sessionFactory;

    @Autowired
    public ProductOrmRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(Product productEntity) {
        return (Long) this.sessionFactory.getCurrentSession().save(productEntity);
    }

    @Override
    public List<Product> findAll() {
//      return   sessionFactory.getCurrentSession().createCriteria(Product.class).list();

        //Criteria API
//        Session session = sessionFactory.getCurrentSession();
//        CriteriaQuery<Product> criteriaQuery = session.getCriteriaBuilder().createQuery(Product.class);
//        criteriaQuery.from(Product.class);
//
//        return session.createQuery(criteriaQuery).getResultList();


        return sessionFactory.getCurrentSession()
                .createQuery("FROM PRODUCTS p", Product.class)
                .getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Product.class, id));

    }

    @Override
    public void delete(Long id) {
        Product product = this.sessionFactory.getCurrentSession().get(Product.class, id);
        this.sessionFactory.getCurrentSession().delete(product);

    }
}
