package in.spring4buddies.application.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class EmployeeController {
	public static void main(String[] args) {

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"C:/Users/amenchu/Desktop/PDF/HelloWorld.pdf"));

			document.open();
			document.add(new Paragraph("A Hello World PDF document."));
			document.close(); // no need to close PDFwriter?
			
			System.out.println("Done!");

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
