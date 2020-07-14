package ng.whycode.pma.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppErrorController implements ErrorController {
	
	
	
	@GetMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if(status != null) {
			
			Integer code = Integer.valueOf(status.toString());
			
			if(code == HttpStatus.NOT_FOUND.value()) {
				return "error/error-404";
			}
			else if(code == HttpStatus.FORBIDDEN.value()) {
				return "error/error-403";
			}
			else if(code == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return "error/error-500";
			}
		}
		return "error/error";
		
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/error";
	}
	
	
	
	

}
