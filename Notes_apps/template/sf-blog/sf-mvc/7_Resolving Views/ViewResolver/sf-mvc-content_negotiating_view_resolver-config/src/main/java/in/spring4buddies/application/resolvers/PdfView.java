/*package in.spring4buddies.application.resolvers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import in.spring4buddies.application.domain.User;

public class PdfView extends AbstractPdfView {

	protected void buildPdfDocument(Map model, Document document, PdfWriter writer, HttpServletRequest req, HttpServletResponse resp)
			throws Exception {

		User user = (User) model.get("user");

		PdfPTable table = new PdfPTable(4);

		table.addCell("Name");
		table.addCell("Gender");
		table.addCell("Country");
		table.addCell("AboutYou");

		table.addCell(user.getName());
		table.addCell(user.getGender());
		table.addCell(user.getCountry());
		table.addCell(user.getAboutYou());

		document.add(table);
	}
}*/