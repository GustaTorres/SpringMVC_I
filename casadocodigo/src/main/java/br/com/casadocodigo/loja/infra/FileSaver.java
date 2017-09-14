package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired
	private HttpServletRequest request;
	
	public String write(MultipartFile file, String basePath){
		
		try {
			String realPath = request.getServletContext().getRealPath("/" + basePath);
			file.transferTo(new File(realPath + "/" +file.getOriginalFilename()));
			
			return basePath + "/" +file.getOriginalFilename();
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
