package in.spring4buddies.application.common;

import com.lowagie.text.Font;

public class PdfFont {

	public static Font HELVETICA_BOLD = new Font(Font.HELVETICA, 7, Font.BOLD);
	public static Font HELVETICA_ITALIC_UNDERLINE = new Font(Font.HELVETICA, 7, Font.ITALIC
			| Font.UNDERLINE);
	public static Font HELVETICA_NORMAL = new Font(Font.HELVETICA, 7);
}
