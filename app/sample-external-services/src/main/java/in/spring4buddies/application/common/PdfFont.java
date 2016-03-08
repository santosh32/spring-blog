package in.spring4buddies.application.common;

import com.lowagie.text.Font;

public class PdfFont {

	public static Font font1 = new Font(Font.HELVETICA, 7, Font.BOLD);
	public static Font font2 = new Font(Font.HELVETICA, 7, Font.ITALIC
			| Font.UNDERLINE);
	public static Font font3 = new Font(Font.HELVETICA, 7);
}
