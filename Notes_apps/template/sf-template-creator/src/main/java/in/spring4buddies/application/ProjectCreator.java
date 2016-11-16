package in.spring4buddies.application;

import in.spring4buddies.application.xsd.Modules;
import in.spring4buddies.application.xsd.Modules.Module;
import in.spring4buddies.application.xsd.Modules.Module.Concept;
import in.spring4buddies.application.xsd.Modules.Module.Concept.SubConcept;

import java.io.File;
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

		if (moduleList != null) {

			List<Modules.Module> modules = moduleList.getModule();

			if (CollectionUtils.isNotEmpty(modules)) {

				for (Module module : modules) {

					if (StringUtils.isNotBlank(module.getName())) {
						List<Modules.Module.Concept> concepts = module.getConcept();

						for (Concept concept : concepts) {
							if (StringUtils.isNotBlank(concept.getName())) {
								String concept_name = WordUtils.capitalize(concept.getName());
								String document_name = concept_name;

								String project_name = new StringBuffer().append(Constants.DEST_DIR).append(File.separatorChar)
										.append(module.getName()).append(File.separatorChar).append(concept_name).toString();

								if (new File(project_name).exists()) {
									project_name = project_name +" " +new SimpleDateFormat("yyyyMMddhhmm").format(new Date());
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

									String project_type = new StringBuffer().append(module.getName()).append("-").append(concept_name)
											.append("-").append(type).toString().replace(" ", "-").toLowerCase();

									File destDir = new File(project_name + File.separatorChar + project_type);

									FileUtils.copyDirectory(new File(Constants.SRC_DIR), destDir);

								}

								File document = new File(project_name + File.separatorChar + document_name + ".docx");

								StringBuffer content = new StringBuffer();
								for (SubConcept subConcept : concept.getSubConcept()) {
									if (StringUtils.isNotBlank(subConcept.getName())) {
										content.append(subConcept.getName()).append("\n");
									}
								}

								if (StringUtils.isNotBlank(content)) {
									FileUtils.writeStringToFile(document, content.toString(), "UTF-8");
								}

								System.out.println("'"+ StringUtils.substringAfterLast(project_name, File.separator) + "' generated successfully.");
							}
						}
					}
				}
			}
		}
	}
}
