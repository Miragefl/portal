package com.soap.management.handle;

import com.soap.exception.BizFailException;
import com.soap.management.util.Helper;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author fenglei
 * @Date 2018/10/3
 * @Version 1.0
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ExceptionHandler(value = BizFailException.class)
    public String bizFailHandler(HttpServletRequest req, BizFailException e) throws Exception {
        return Helper.retFail(e);
    }

}
