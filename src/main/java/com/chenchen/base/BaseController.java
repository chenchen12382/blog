package com.chenchen.base;

import javax.servlet.http.HttpServletRequest;

import com.chenchen.exception.ParamException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


public class BaseController {

	@ModelAttribute
	public void preMethod(Model model, HttpServletRequest request) {
		String contextPath = request.getContextPath();
		model.addAttribute("ctx", contextPath);
	}
	
	public ResultInfo success(Object result, String... message) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResult(result);
		resultInfo.setResultCode(Constant.SUCCESS_CODE);
		if (message == null || message.length == 0 || StringUtils.isBlank(message[0])) {
			resultInfo.setResultMessage(Constant.SUCCESS_MSG);
		} else {
			resultInfo.setResultMessage(message[0]);
		}
		return resultInfo;
	}
	
	public ResultInfo failure(ParamException exception) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(exception.getErrorCode());
		resultInfo.setResult(exception.getMessage());
		resultInfo.setResultMessage(exception.getMessage());
		return resultInfo;
	}
	
	public ResultInfo failure(Integer code, String message) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(code);
		resultInfo.setResult(message);
		resultInfo.setResultMessage(message);
		return resultInfo;
	}
	
	public ResultInfo failure(String... message) {
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setResultCode(Constant.ERROR_CODE);
		if (message == null || message.length == 0 || StringUtils.isBlank(message[0])) {
			resultInfo.setResultMessage(Constant.ERROR_MSG);
			resultInfo.setResult(Constant.ERROR_MSG);
		} else {
			resultInfo.setResultMessage(message[0]);
			resultInfo.setResult(message[0]);
		}
		return resultInfo;
	}
	
	
}
