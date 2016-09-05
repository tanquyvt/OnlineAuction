package model;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class AuctionDaoImpl implements AuctionDao {

	private static SessionFactory factory;

	public AuctionDaoImpl() {
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").addResource("Auction.hbm.xml")
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public int add(Auction auction) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer userID = null;
		try {
			tx = session.beginTransaction();
			userID = (Integer) session.save(auction);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {

			session.close();
		}

		return userID;
	}

	public void update(Auction auction) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(auction);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {

			session.close();
		}

	}

	public void delete(Auction auction) {
		// TODO Auto-generated method stub

	}

	public Auction findBy(int id) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Auction.class);
		Transaction tx = null;
		Auction account = new Auction();
		try {
			tx = session.beginTransaction();
			account = (Auction) criteria.add(Restrictions.eq("id", id)).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
				e.printStackTrace();
			}
		} finally {

			session.close();
		}

		return account;
	}

	public void list() {
		// TODO Auto-generated method stub

	}

}
