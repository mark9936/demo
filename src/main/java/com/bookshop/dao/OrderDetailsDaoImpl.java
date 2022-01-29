package com.bookshop.dao;

import com.bookshop.model.OrderDetails;
import com.bookshop.model.OrderMaster;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

//import org.hibernate.query.Query;

@Repository
@Transactional
public class OrderDetailsDaoImpl implements OrderDetailsDao {

    @PersistenceContext
    private EntityManager em;


    public String sql = new StringBuilder().append("SELECT c.customer_id as customerId, c.customer_name as customerName, om.order_id as orderId, od.isbn, od.quantity, om.order_date as orderDate FROM order_detail od, order_master om , customer c where od.order_id = om.order_id and om.customer_id = c.customer_id").toString();

    @Override
    public List<OrderDetails> getOrderDetails() {
//        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query query = em.createNativeQuery(sql);
//        List<OrderDetails>orderDetailsList = query.getResultList();
//        Query<OrderDetails> query = session.createQuery(sql);
        return query.getResultList();
    }

    @Override
    public OrderMaster getOrderDetails2(int orderMasterId) {
        Query query = em.createNativeQuery("select * from order_master where order_id = :order_id", OrderMaster.class);
        query.setParameter("order_id", orderMasterId);
        return (OrderMaster)query.getSingleResult();
    }
}
