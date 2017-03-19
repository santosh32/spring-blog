package in.spring4buddies.application.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.spring4buddies.application.domain.User;

public class PdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest req, HttpServletResponse resp)
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
}