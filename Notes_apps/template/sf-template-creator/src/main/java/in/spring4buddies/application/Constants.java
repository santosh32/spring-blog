package in.spring4buddies.application;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static String SRC_DIR = "./sf-${module}-${concept}-${type}";
	
	public static String DEST_DIR = "../sf-blog";

	public static List<String> TYPES = Arrays.asList("xml", "annotation", "config");
	
	public static String INPUT_FILE = "module.xml";
}
