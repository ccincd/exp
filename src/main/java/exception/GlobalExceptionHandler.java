/*
 * Copyright (c) 2016 Qunar.com. All Rights Reserved.
 */
package exception;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chichen  Date: 16-3-29 Time: 下午2:36
 */
public class GlobalExceptionHandler implements HandlerExceptionResolver, Ordered {

    public static final int DEFAULT_FAILED_STATUS = -1;

    private static MappingJackson2JsonView jsonView = new MappingJackson2JsonView();

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse, Object o, Exception e) {
        String uri = httpServletRequest.getRequestURI();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setView(jsonView);
        modelAndView.addObject("uri", uri);
        modelAndView.addObject("status", DEFAULT_FAILED_STATUS);
        modelAndView.addObject("message", e.getMessage());

        return modelAndView;
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }
}
