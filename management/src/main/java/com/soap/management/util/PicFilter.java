package com.soap.management.util;

/*
 * 文  件  名：PicFilter.java
 * 版         权：Copyright 2016 SHANGHE Co., Ltd. Rights Reserved.
 * 描         述：
 * 创  建  人：wj
 * 创 建时间：2016-7-11
 */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;



/**
 * 图片拦截器
 * 
 * @author 
 * @version V1.0
 */
@Order(1)
//重点
@WebFilter(filterName = "picFilter", urlPatterns = "/Upload/*")
public class PicFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void destroy() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        String filePath = ConfigUtil.get("UPLOAD_FILE_PATH");

        HttpServletRequest h_req = (HttpServletRequest) req;
        HttpServletResponse h_res = (HttpServletResponse) res;

        String url = h_req.getRequestURL().toString();
        String uri = h_req.getRequestURI().toString();
        String contextPath = h_req.getContextPath();

        logger.info("url is :" + url);
        logger.info("uri is :" + uri);
        logger.info("contextpath is :" + uri.substring(contextPath.length()));
        logger.info("contextpath is :" + filePath + uri.substring(contextPath.length()));

        read(h_res, filePath + uri.substring(contextPath.length()));
        
        
        //        chain.doFilter(req, res);

    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void init(FilterConfig paramFilterConfig) throws ServletException {

    }

    private void read(HttpServletResponse response, String filePath) {
        ServletOutputStream outToUser = null;
        InputStream in = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            response.setContentType("image/jpeg");
            //设置页面不缓存
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            in = new FileInputStream(filePath);
            outToUser = response.getOutputStream();
            bis = new BufferedInputStream(in);// 输入缓冲流  
            bos = new BufferedOutputStream(outToUser);// 输出缓冲流  
            byte data[] = new byte[4096];// 缓冲字节数  
            int size = 0;
            size = bis.read(data);
            while (size != -1) {
                bos.write(data, 0, size);
                size = bis.read(data);
            }
            outToUser.flush();

        } catch (IOException e) {
            logger.error("读取图片发生异常", e);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    logger.error("关闭流发生异常", e);
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    logger.error("关闭流发生异常", e);
                }
            }
            if (outToUser != null) {
                try {
                    outToUser.close();
                } catch (IOException e) {
                    logger.error("关闭流发生异常", e);
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("关闭流发生异常", e);
                }
            }
        }
    }

}
