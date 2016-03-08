package in.spring4buddies.application.pdf;

import in.spring4buddies.application.common.PdfDocument;
import in.spring4buddies.application.common.PdfFont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

@Component
public class DefaultPdfGenerator implements PdfGenerator {

	@Value("${dotLines}")
	private String dotLines;

	@Autowired
	private PdfDocument pdfDocument;

	@Override
	public void execute() throws Exception {

		Document document = pdfDocument.open();

		document.add(new Chunk("Company Name", PdfFont.font1));
		document.add(Chunk.NEWLINE);

		document.add(new Paragraph("Company address", PdfFont.font3));
		document.add(new Paragraph(dotLines));

		document.add(new Paragraph("Payslip for the month of Feb-2016",
				PdfFont.font1));
		document.add(new Paragraph(dotLines));

		document.add(setEmplyoeeInfo());
		document.add(new Paragraph(dotLines));

		document.add(Chunk.NEWLINE);

		pdfDocument.close(document);

		System.out.println("Employee Payslip Generated Successfully..");

	}

	private static PdfPTable setEmplyoeeInfo() throws Exception {

		PdfPTable pdfPTable = createPdfTableForEmployeeInfo();

		pdfPTable.addCell(createPharseText("Emp. ID"));
		pdfPTable.addCell(createPharseText(": 12345"));
		pdfPTable.addCell(createPharseText("Department"));
		pdfPTable.addCell(createPharseText(": SD"));
		pdfPTable.addCell(createPharseText("PF. No"));
		pdfPTable.addCell(createPharseText(": AP/HYD/1233/1244"));

		emptyCell(pdfPTable);

		pdfPTable.addCell(createPharseText("Name"));
		pdfPTable.addCell(createPharseText(": Rajesh "));
		pdfPTable.addCell(createPharseText("Bank"));
		pdfPTable.addCell(createPharseText(": ICICI "));
		pdfPTable.addCell(createPharseText("PAN"));
		pdfPTable.addCell(createPharseText(": ATDB8347E"));

		emptyCell(pdfPTable);

		pdfPTable.addCell(createPharseText("Designation"));
		pdfPTable.addCell(createPharseText(": Sr.Software Engineer"));
		pdfPTable.addCell(createPharseText("Bank A/c No"));
		pdfPTable.addCell(createPharseText(": 123456789012 "));
		pdfPTable.addCell(createPharseText("Paid Days"));
		pdfPTable.addCell(createPharseText(": 29"));

		emptyCell(pdfPTable);

		return pdfPTable;
	}

	private static void emptyCell(PdfPTable pdfPTable) {
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
		pdfPTable.addCell("");
	}

	private static PdfPTable createPdfTableForEmployeeInfo() throws Exception {
		PdfPTable pdfPTable = new PdfPTable(6);
		PdfPCell defaultCell = pdfPTable.getDefaultCell();
		defaultCell.setBorder(PdfCell.NO_BORDER);
		defaultCell.setNoWrap(true);

		pdfPTable.setWidthPercentage(100);
		pdfPTable.setWidths(new float[] { 2f, 2.8f, 2.8f, 2.8f, 2.5f, 2.8f });
		return pdfPTable;
	}

	private static Phrase createPharseText(String text) {
		return new Phrase(text, PdfFont.font3);
	}

}