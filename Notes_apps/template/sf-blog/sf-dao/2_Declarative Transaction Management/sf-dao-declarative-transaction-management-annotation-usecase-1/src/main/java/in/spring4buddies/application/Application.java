package in.spring4buddies.application;

import in.spring4buddies.application.model.Account;
import in.spring4buddies.application.service.BankService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans-hsql.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		BankService bankService = context.getBean(BankService.class);

		System.out.println(" *****  getBalance for primary holder ******");
		Account primary = bankService.getBalance(1);
		System.out.println(primary.getAccountId() + " | " + primary.getName() + " | " + primary.getBalance());

		System.out.println(" *****  getBalance for beneficiary ******");
		Account beneficiary = bankService.getBalance(2);
		System.out.println(beneficiary.getAccountId() + " | " + beneficiary.getName() + " | " + beneficiary.getBalance());

		context.close();
	}
}
