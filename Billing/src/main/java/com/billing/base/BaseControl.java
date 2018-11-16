package com.billing.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author 孙磊 on 2018/7/20
 * @version 1.0
 * @apiNote 基本控制器
 */
public abstract class BaseControl {

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
    }

    public HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getResponse();
    }

    public Result successResponse() {
        return successResponse(null);
    }

    public Result successResponse(Map<String, Object> data) {
        Result result = new Result();
        result.setStatusCode(1);
        result.setMessage("success");
        result.setData(data);
        return result;
    }
    public Result successResponse(Map<String, Object> data, String msg) {
        Result result = new Result();
        result.setStatusCode(1);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
    public Result failResponse(){
        Result result=new Result();
        result.setStatusCode(0);
        result.setMessage("失败");
        return result;
    }
    public Result failResponse(String msg){
        Result result=new Result();
        result.setStatusCode(0);
        result.setMessage(msg);
        return result;
    }
    public ModelAndView createMav(String viewName, Map<String, ?> model) {
        return new ModelAndView(viewName, model);
    }

    @JsonInclude(Include.NON_NULL)
    public static class Result {
        private int statusCode;
        private String message;
        private Map<String, Object> data;

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Map<String, Object> getData() {
            return data;
        }

        public void setData(Map<String, Object> data) {
            this.data = data;
        }

        public void addData(String key, Object object) {
            if (data == null) {
                data = new HashMap<>();
            }
            data.put(key, object);
        }

    }
}

