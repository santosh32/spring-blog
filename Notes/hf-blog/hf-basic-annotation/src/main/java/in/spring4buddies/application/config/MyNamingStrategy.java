package in.spring4buddies.application.config;

import org.hibernate.cfg.DefaultNamingStrategy;

public class MyNamingStrategy extends DefaultNamingStrategy {
   @Override
   public  String tableName(String tableName) {
//      return tableName+yearSuffixTable;
	   return "test";
   }
}