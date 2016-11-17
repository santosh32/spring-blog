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
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

@SuppressWarnings("unused")
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

				String project_name = ProjectUtil.replace(ProjectConstant.PROJECT_NAME, new String[] { module.getName(), concept_name });

				if (new File(project_name).exists()) {
					project_name = project_name + " " + new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
				}

				FileUtils.forceMkdir(new File(project_name));
				System.out.println(StringUtils.substringAfterLast(project_name, "/") + " created.");

				String inputTypes = concept.getType();

				// TODO : generate field of 'concept' level is not used now
				boolean isGenerate = BooleanUtils.toBoolean(concept.getGenerate());

				List<String> types = new ArrayList<>();
				if (StringUtils.isEmpty(inputTypes) || StringUtils.equalsIgnoreCase(inputTypes, "all")) {
					types = ProjectConstant.TYPES;
				} else {
					types = Arrays.asList(StringUtils.split(inputTypes, ","));
				}

				for (String type : types) {

					String project_type = ProjectUtil.replace(ProjectConstant.PROJECT_TYPE, new String[] { module.getName(), concept_name, type });

					FileUtils.copyDirectory(new File(ProjectConstant.SRC_DIR),
							new File(ProjectUtil.replace(ProjectConstant.DEST_PROJECT_PATH, new String[] { project_name, project_type })));

					System.out.println(project_type + " generated successfully.");

				}

				processSubConcepts(concept, document_name, project_name);

			}
		}
	}

	private static void processSubConcepts(Concept concept, String document_name, String project_name) throws IOException {
		
		
		
		

		StringBuffer content = new StringBuffer();
		for (SubConcept subConcept : concept.getSubConcept()) {
			if (StringUtils.isNotBlank(subConcept.getName())) {
				content.append(subConcept.getName()).append("\n");
			}
		}

		if (StringUtils.isNotBlank(content)) {
			File readme_file = new File(ProjectUtil.replace(ProjectConstant.README_FILE, new String[] { project_name, document_name }));
			FileUtils.writeStringToFile(readme_file, content.toString(), "UTF-8");
			System.out.println(document_name + ".docx created.\n");
		}
	}
}