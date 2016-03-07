package in.spring4buddies.application.common;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {

	public void execute() {

		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(new File(
					"Payslip_1.pdf")));
			document.setPageSize(PageSize.A4);

			document.open();

			document.add(new Chunk("Company Name", font1));
			document.add(Chunk.NEWLINE);

			document.add(new Paragraph("Company address", font3));

			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------"));
			document.add(new Paragraph("Payslip for the month of Feb-2016",
					font1));
			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------"));

			document.add(setEmplyoeeInfo());

			document.add(new Paragraph(
					"----------------------------------------------------------------------------------------------------------------------------------"));

			document.add(Chunk.NEWLINE);

			document.close();

			System.out.println("Pdf created successfully..");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static Font font1 = new Font(Font.HELVETICA, 7, Font.BOLD);
	static Font font2 = new Font(Font.HELVETICA, 7, Font.ITALIC
			| Font.UNDERLINE);
	static Font font3 = new Font(Font.HELVETICA, 7);

	private static PdfPTable setEmplyoeeInfo() throws Exception {

		PdfPTable pdfPTable = new PdfPTable(6);
		PdfPCell defaultCell = pdfPTable.getDefaultCell();
		defaultCell.setBorder(PdfCell.NO_BORDER);
		defaultCell.setNoWrap(true);

		pdfPTable.setWidthPercentage(100);
		pdfPTable.setWidths(new float[] { 2f, 2.8f, 2.8f, 2.8f, 2.5f, 2.8f });

		pdfPTable.addCell(createPharseText("Emp. ID"));
		pdfPTable.addCell(createPharseText(": 12345"));
		pdfPTable.addCell(createPharseText("Department"));
		pdfPTable.addCell(createPharseText(": SD"));
		pdfPTable.addCell(createPharseText("PF. No"));
		pdfPTable.addCell(createPharseText(": AP/HYD/1233/1244"));

		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");

		pdfPTable.addCell(createPharseText("Name"));
		pdfPTable.addCell(createPharseText(": Rajesh "));
		pdfPTable.addCell(createPharseText("Bank"));
		pdfPTable.addCell(createPharseText(": ICICI "));
		pdfPTable.addCell(createPharseText("PAN"));
		pdfPTable.addCell(createPharseText(": ATDB8347E"));

		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");

		pdfPTable.addCell(createPharseText("Designation"));
		pdfPTable.addCell(createPharseText(": Sr.Software Engineer"));
		pdfPTable.addCell(createPharseText("Bank A/c No"));
		pdfPTable.addCell(createPharseText(": 123456789012 "));
		pdfPTable.addCell(createPharseText("Paid Days"));
		pdfPTable.addCell(createPharseText(": 29"));

		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");

		return pdfPTable;
	}

	private static Phrase createPharseText(String text) {
		return new Phrase(text, font3);
	}

}