package in.spring4buddies.application;

import in.spring4buddies.application.xsd.Modules;
import in.spring4buddies.application.xsd.Modules.Module;
import in.spring4buddies.application.xsd.Modules.Module.Concept;
import in.spring4buddies.application.xsd.Modules.Module.Concept.SubConcept;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

public class ProjectCreator {

	public static void process(Modules moduleList) throws Exception {

		processModules(moduleList);
	}

	private static void processModules(Modules moduleList) throws IOException {
		
		if (moduleList != null) {

			List<Modules.Module> modules = moduleList.getModule();

			if (CollectionUtils.isNotEmpty(modules)) {

				for (Module module : modules) {
					if (StringUtils.isNotBlank(module.getName())) {
						List<Modules.Module.Concept> concepts = module.getConcept();
						processConcepts(concepts, module);
					}
				}
			}
		}
	}

	private static void processConcepts(List<Modules.Module.Concept> concepts, Module module) throws IOException {

		for (Concept concept : concepts) {
			if (StringUtils.isNotBlank(concept.getName())) {
				String concept_name = WordUtils.capitalize(concept.getName());
				String document_name = concept_name;

				String project_name = new StringBuffer().append(Constants.DEST_DIR).append(File.separator).append(module.getName())
						.append(File.separator).append(concept_name).toString();

				if (new File(project_name).exists()) {
					project_name = project_name + " " + new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
				}

				FileUtils.forceMkdir(new File(project_name));

				String inputTypes = concept.getType();
				List<String> types = new ArrayList<>();
				if (StringUtils.isEmpty(inputTypes) || StringUtils.equalsIgnoreCase(inputTypes, "all")) {
					types = Constants.TYPES;
				} else {
					types = Arrays.asList(StringUtils.split(inputTypes));
				}

				for (String type : types) {

					String project_type = new StringBuffer().append(module.getName()).append("-").append(concept_name).append("-").append(type)
							.toString().replace(" ", "-").toLowerCase();

					File destDir = new File(project_name + File.separator + project_type);

					FileUtils.copyDirectory(new File(Constants.SRC_DIR), destDir);

				}

				processSubConcepts(concept, document_name, project_name);

				System.out.println("'" + StringUtils.substringAfterLast(project_name, File.separator) + "' generated successfully.");
			}
		}
	}

	private static void processSubConcepts(Concept concept, String document_name, String project_name) throws IOException {

		File document = new File(project_name + File.separator + document_name + ".docx");

		StringBuffer content = new StringBuffer();
		for (SubConcept subConcept : concept.getSubConcept()) {
			if (StringUtils.isNotBlank(subConcept.getName())) {
				content.append(subConcept.getName()).append("\n");
			}
		}

		if (StringUtils.isNotBlank(content)) {
			FileUtils.writeStringToFile(document, content.toString(), "UTF-8");
		}
	}
}
