package com.bitacademy.mysite.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	private static final Log Logger = LogFactory.getLog(ControllerExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public String HandlerException(Model model, Exception e) {
		// 로깅
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
//		System.out.println(errors.toString());
		Logger.error(errors.toString());
		
		// 사과 페이지(HTML 응답, 정상종료)
		model.addAttribute("exception", errors.toString());
		return "error/exception";
	}
}
