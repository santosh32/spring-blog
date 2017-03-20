package in.spring4buddies.application.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadController {

	@Autowired
	ServletContext context;

	@RequestMapping
	public String load() {
		return "downloadFile";
	}

	@RequestMapping("/download/{fileName:.+}")
	public void processFiles(HttpServletRequest request, HttpServletResponse response, @PathVariable("fileName") String fileName) {
		try {
			String downloadFolder = context.getRealPath("/WEB-INF/download");
			System.out.println("== downloadFolder == : " + downloadFolder);
			File file = new File(downloadFolder + File.separator + fileName);

			if (file.exists()) {
				String mimeType = context.getMimeType(file.getPath());

				if (mimeType == null) {
					mimeType = "application/octet-stream";
				}

				response.setContentType(mimeType);
				response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
				response.setContentLength((int) file.length());

				OutputStream os = response.getOutputStream();
				FileInputStream fis = new FileInputStream(file);
				byte[] buffer = new byte[4096];
				int b = -1;

				while ((b = fis.read(buffer)) != -1) {
					os.write(buffer, 0, b);
				}

				fis.close();
				os.close();
			} else {
				System.out.println("Requested " + fileName + " file not found!!");
			}
		} catch (IOException e) {
			System.out.println("Error:- " + e.getMessage());
		}
	}
}