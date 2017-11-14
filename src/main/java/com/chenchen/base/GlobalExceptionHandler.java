package com.chenchen.base;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenchen.exception.LoginException;
import com.chenchen.exception.ParamException;
import com.chenchen.exception.UnAuthPermissionException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

/**
 * 全局异常处理
 * @author TW
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends BaseController {
	
//	@Autowired
//	private LogService logService;
	
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value = ParamException.class)
	@ResponseBody
	public ResultInfo handlerParamException(ParamException paramException) {
		logger.error("参数异常：{}", paramException);
//		logService.addLog(log); // 错误日志收集
		return failure(paramException);
	}
	
	@ExceptionHandler(value = UnAuthPermissionException.class)
	@ResponseBody
	public ResultInfo handlerUnAuthPermissionException(UnAuthPermissionException exception) {
		logger.error("异常：{}", exception);
		return failure(exception.getPermissionCode(), exception.getMessage());
	}
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultInfo handlerException(Exception exception) {
		logger.error("异常：{}", exception);
		return failure(exception.getMessage());
	}
	
	@ExceptionHandler(value = {IllegalAccessException.class, IllegalArgumentException.class})
	@ResponseBody
	public ResultInfo handlerIllegalException(Exception exception) {
		logger.error("异常：{}", exception);
		if (exception instanceof IllegalAccessException) {
			return failure(((IllegalAccessException)exception).getMessage());
		}
		if (exception instanceof IllegalArgumentException) {
			IllegalArgumentException e = (IllegalArgumentException)exception;
			return failure(e.getMessage());
		}
		return failure("未知异常");
	}
	
	/**
	 * 登录异常处理
	 * @param loginException
	 * @return
	 */
	@ExceptionHandler(value = LoginException.class)
	public String handlerLoginException(LoginException loginException, 
			Model model, HttpServletRequest request, HttpServletResponse response)
	throws IOException{
		logger.error("登录异常：{}", loginException);
		model.addAttribute("resultMessage", loginException.getMessage());
		model.addAttribute("resultCode", loginException.getErrorCode());
//		String ctx  = request.getContextPath();
//		String url = ctx + "/index";
		String xmlHttpRequest = request.getHeader("X-Requested-With");
		if (StringUtils.isNoneBlank(xmlHttpRequest) 
				&& "XMLHttpRequest".equals(xmlHttpRequest)) { // 异步请求
			// 返回json
			ResultInfo resultInfo = failure(201, "请登录");
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(JSON.toJSONString(resultInfo));
			return null;
		}
		return "error";
	}
	
	
}
