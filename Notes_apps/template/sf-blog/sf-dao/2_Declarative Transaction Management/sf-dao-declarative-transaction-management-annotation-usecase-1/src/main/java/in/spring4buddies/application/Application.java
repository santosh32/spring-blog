package in.spring4buddies.application;

import in.spring4buddies.application.service.BankService;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) throws Exception {
		String confFile = "beans-hsql.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		BankService bankService = context.getBean(BankService.class);

		System.out.println(" *****  getBalance for primary holder ******");
		double primaryHolderBal = bankService.getBalance(1);
		System.out.println(1 + " | " + primaryHolderBal);

		System.out.println(" *****  getBalance for beneficiary ******");
		double beneficiaryHolderBal = bankService.getBalance(2);
		System.out.println(2 + " | " + beneficiaryHolderBal);

		System.out.println(" *****  transfer amount from primary to beneficiary ******");
		bankService.transfer(1, 2, 500);

		System.out.println(" ***** after transfer primary holder Balance******");
		primaryHolderBal = bankService.getBalance(1);
		System.out.println(1 + " | " + primaryHolderBal);

		System.out.println(" ***** after transfer beneficiary holder Balance******");
		beneficiaryHolderBal = bankService.getBalance(2);
		System.out.println(2 + " | " + beneficiaryHolderBal);

		context.close();
	}
}
