package in.spring4buddies.application.relationship;

import in.spring4buddies.application.config.HibernateConfig;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OneToOneMain {

	public static void main(String[] args) {

		 save();
//		load();

	}

	private static void save() {
		System.out.println("Hibernate one to one (Annotation)");
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

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		 session.save(stock);
//		session.save(stockDetail);

		session.getTransaction().commit();

		HibernateConfig.shuntdown();

		System.out.println("Done");
	}

	private static void load() {

		System.out.println("Hibernate one to one (Annotation)");
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

//		Stock stock = (Stock) session.load(Stock.class, 900);
//		
//		System.out.println(stock);
		
//		if (stock.getStockDetail() != null){
//			System.out.println(stock.getStockDetail());
//		}
		
		StockDetail stockDetail = (StockDetail) session.load(StockDetail.class, 450);

		System.out.println(stockDetail);
		System.out.println(stockDetail.getStock());

		HibernateConfig.shuntdown();

		System.out.println("Done");
	}
}