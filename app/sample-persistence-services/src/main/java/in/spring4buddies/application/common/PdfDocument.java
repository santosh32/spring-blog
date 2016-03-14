package in.spring4buddies.application.common;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfDocument {

	@Value("${fileName}")
	private String fileName;

	@Value("${fileDirectory}")
	private String fileDirectory;

	private static Document document = new Document();

	public Document open() throws Exception {
		FileOutputStream fileOutputStream = new FileOutputStream(new File(
				fileDirectory + fileName));
		PdfWriter.getInstance(document, fileOutputStream);
		document.setPageSize(PageSize.A4);
		document.open();
		return document;
	}

	public void close(Document document) {
		if (null != document) {
			document.close();
		}
	}
}
