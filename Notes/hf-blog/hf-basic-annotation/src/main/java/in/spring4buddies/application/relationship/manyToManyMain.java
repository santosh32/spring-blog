package in.spring4buddies.application.relationship;

import in.spring4buddies.application.config.HibernateConfig;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class manyToManyMain {

	public static void main(String[] args) {

//		save();
		 load();

	}

	private static void save() {
		
		System.out.println("Hibernate one to many (Annotation)");

		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Stock stock = new Stock();

		stock.setStockCode("ISBN-101");
		stock.setStockName("Books");

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("Java");
		stockDetail.setCompDesc("Persistence in Java");
		stockDetail.setRemark("Good");
		stockDetail.setListedDate(new Date());

		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		StockDailyRecord stockDailyRecords = new StockDailyRecord();
		stockDailyRecords.setPriceOpen(new Float("1.21"));
		stockDailyRecords.setPriceClose(new Float("1.11"));
		stockDailyRecords.setPriceChange(new Float("10.1"));
		stockDailyRecords.setVolume(3000000L);
		stockDailyRecords.setDate(new Date());
		
		StockDailyRecord stockDailyRecords1 = new StockDailyRecord();
		stockDailyRecords1.setPriceOpen(new Float("1.2"));
		stockDailyRecords1.setPriceClose(new Float("1.1"));
		stockDailyRecords1.setPriceChange(new Float("10.0"));
		stockDailyRecords1.setVolume(3000000L);
		stockDailyRecords1.setDate(new Date());

		stock.getStockDailyRecord().add(stockDailyRecords);
		stockDailyRecords.setStock(stock);
		
		stock.getStockDailyRecord().add(stockDailyRecords1);
		stockDailyRecords1.setStock(stock);
		
		
		StockCategory category1 = new StockCategory("CONSUMER", "CONSUMER COMPANY");
		StockCategory category2 = new StockCategory("INVESTMENT", "INVESTMENT COMPANY");
    
        Set<StockCategory> categories = new HashSet<StockCategory>();
        categories.add(category1);
        categories.add(category2);
        
        stock.getCategories().add(category1);
        stock.getCategories().add(category2);
        
        stock.setCategories(categories);
        
		
		session.save(stock);
		// session.save(stockDetail);

		session.getTransaction().commit();

		HibernateConfig.shuntdown();

		System.out.println("Done");
	}

	private static void load() {

		System.out.println("Hibernate one to many (Annotation)");
		SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
		Session session = sessionFactory.openSession();

		Stock stock = (Stock) session.load(Stock.class, 3200);

		System.out.println(stock);

		if (stock.getStockDetail() != null) {
			System.out.println(stock.getStockDetail());
		}

		if (stock.getStockDailyRecord() != null) {
			for (StockDailyRecord stockDailyRecord : stock.getStockDailyRecord()) {
				System.out.println(stockDailyRecord);
			}
		}

		// StockDetail stockDetail = (StockDetail)
		// session.load(StockDetail.class, 300);
		//
		// System.out.println(stockDetail);
		// System.out.println(stockDetail.getStock());

		HibernateConfig.shuntdown();

		System.out.println("Done");
	}
}