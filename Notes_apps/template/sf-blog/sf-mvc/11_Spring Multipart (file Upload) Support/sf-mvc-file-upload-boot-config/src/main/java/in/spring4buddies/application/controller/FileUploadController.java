package in.spring4buddies.application.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import in.spring4buddies.application.model.FileInfo;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

	@Autowired
	ServletContext context;

	@RequestMapping(method = RequestMethod.GET)
	public String load() {
		return "uploadFile";
	}
	// TODO: FIX ME: at time two methods will not allow, to run some one needs to comment
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processFiles(@RequestParam("file") List<MultipartFile> files) {

		List<FileInfo> uploadedFiles = new ArrayList<FileInfo>();

		if (!files.isEmpty()) {
			try {
				for (MultipartFile file : files) {
					String path = context.getRealPath("/WEB-INF/uploaded") + File.separator + file.getOriginalFilename();
					File destinationFile = new File(path);
					file.transferTo(destinationFile);
					uploadedFiles.add(new FileInfo(destinationFile.getName(), path));
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		ModelAndView modelAndView = new ModelAndView("uploadSuccess");
		modelAndView.addObject("files", uploadedFiles);
		return modelAndView;
	}

//	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	public ModelAndView processFiles(MultipartHttpServletRequest request) throws IOException {
//
//		List<MultipartFile> files = request.getFiles("file");
//
//		List<FileInfo> uploadedFiles = new ArrayList<FileInfo>();
//
//		if (!files.isEmpty()) {
//			try {
//				for (MultipartFile file : files) {
//					String path = context.getRealPath("/WEB-INF/uploaded") + File.separator + file.getOriginalFilename();
//					File destinationFile = new File(path);
//					file.transferTo(destinationFile);
//					uploadedFiles.add(new FileInfo(destinationFile.getName(), path));
//				}
//
//			} catch (Exception e) {
//				System.out.println(e.getMessage());
//			}
//
//		}
//		ModelAndView modelAndView = new ModelAndView("uploadSuccess");
//		modelAndView.addObject("files", uploadedFiles);
//		return modelAndView;
//	}
}