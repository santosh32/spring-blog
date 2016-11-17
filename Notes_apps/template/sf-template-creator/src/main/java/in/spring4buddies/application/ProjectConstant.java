package in.spring4buddies.application;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ProjectConstant {

	public static String SRC_DIR = "./sf-${module}-${concept}-${type}";

	public static String DEST_DIR = "../sf-blog";

	public static List<String> TYPES = Arrays.asList("xml", "annotation", "config");

	public static String INPUT_FILE = "module-*.xml";

	// project_name/document_name.docx
	public static String README_FILE = "{0}" + File.separator + "{1}" + ".docx";

	// project_name/project_type
	public static String DEST_PROJECT_PATH = "{0}" + File.separator + "{1}";

	public static String PROJECT_NAME = DEST_DIR + File.separator + "{0}" + File.separator + "{1}";

	public static String PROJECT_TYPE = "{0}-{1}-{2}";

	public static String SUB_PROJECT_NAME = DEST_DIR + File.separator + "{0}" + File.separator + "{1}" + File.separator + "{2}";
}
