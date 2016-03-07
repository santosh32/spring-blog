package in.spring4buddies.application.common;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class TableExample {
	public static void main(String[] args) {
		Document document = new Document();

		try {
			PdfWriter.getInstance(document, new FileOutputStream(
					"C:/Users/amenchu/Desktop/PDF/HelloWorld-Table.pdf"));

			document.open();

			PdfPTable table = new PdfPTable(3); // 3 columns.

			PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
			PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
			PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));

			table.addCell(cell1);
			table.addCell(cell2);
			table.addCell(cell3);

			document.add(table);

			document.close();
		} catch (Exception e) {

		}
	}
}
