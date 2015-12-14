package in.spring4buddies.application.validator;

import in.spring4buddies.application.model.FileBucket;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return FileBucket.class.isAssignableFrom(clazz);
	}

	public void validate(Object object, Errors errors) {
		FileBucket fileBucket = (FileBucket) object;

		if (fileBucket.getFile() != null) {
			if (fileBucket.getFile().getSize() == 0) {
				errors.rejectValue("file", "missing.file");
			}
		}
	}
}