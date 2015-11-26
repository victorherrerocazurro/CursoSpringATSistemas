package xfiles.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import xfiles.business.FileManagerService;
import xfiles.model.File;

@Controller
public class FileController {
	
	@Autowired 
	private FileManagerService fileManager;
	
	@RequestMapping("/show/all")
	public ModelAndView showAll() {
		System.out.println("Request show all files received");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("filesView");
		mav.addObject("files", fileManager.showAll());
		return mav;
	}
	
	@RequestMapping("/show/{id}")
	public ModelAndView show(@PathVariable Long id) {
		System.out.println("Request show file received");
		ModelAndView mav=new ModelAndView();
		mav.setViewName("fileView");
		mav.addObject("file", fileManager.show(id));
		return mav;
	}
	
	@RequestMapping(value="/classify")
	public String clasificar( @RequestParam("id") Long id, Model model){
		System.out.println("Classify file: "+id);
		File file = fileManager.show(id);
		fileManager.classify(file);
		return "redirect:/xfiles/show/all";
	}
	
	@RequestMapping(value="/declassify")
	public String desclasificar( @RequestParam("id") Long id, Model model){
		System.out.println("Declassify file: "+id);
		File file = fileManager.show(id);
		fileManager.declassify(file);
		return "redirect:/xfiles/show/all";
	}

}
