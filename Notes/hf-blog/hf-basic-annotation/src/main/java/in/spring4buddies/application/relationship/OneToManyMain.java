package in.spring4buddies.application.relationship;

import in.spring4buddies.application.config.HibernateConfig;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToManyMain {

	public static void main(String[] args) {

		 save();
//		load();

	}

	private static void save() {
		System.out.println("Hibernate one to many (Annotation)");

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("ISBN-100");
		stock.setStockName("Books");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("Java");
		stockDetail.setCompDesc("Head first Java");
		stockDetail.setRemark("Good");
		stockDetail.setListedDate(new Date());

		StockDetail stockDetail1 = new StockDetail();
		stockDetail1.setCompName("Java");
		stockDetail1.setCompDesc("Persistence in Java");
		stockDetail1.setRemark("Good");
		stockDetail1.setListedDate(new Date());

		stock.getStockDetail().add(stockDetail);
		stock.getStockDetail().add(stockDetail1);

		stockDetail.setStock(stock);
		stockDetail1.setStock(stock);

		 session.save(stock);
//		session.save(stockDetail);

		session.getTransaction().commit();

		HibernateConfig.shuntdown();

		System.out.println("Done");
	}

	private static void load() {

		System.out.println("Hibernate one to many (Annotation)");
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		 Stock stock = (Stock) session.load(Stock.class, 700);
		
		 System.out.println(stock);

		if (stock.getStockDetail() != null) {
			System.out.println(stock.getStockDetail());
		}

//		StockDetail stockDetail = (StockDetail) session.load(StockDetail.class, 300);
//
//		System.out.println(stockDetail);
//		System.out.println(stockDetail.getStock());

		HibernateConfig.shuntdown();

		System.out.println("Done");
	}
}