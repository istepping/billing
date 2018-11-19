package com.billing.base;

/**
 * @author sunLei on 2018/11/17 18:55
 * @version 1.0
 * @apiNote
 */
public abstract class BaseService {
    public ServiceResult success(){
        ServiceResult serviceResult=new ServiceResult();
        serviceResult.setSuccess(true);
        serviceResult.setId(1);
        serviceResult.setInfo("success");
        return serviceResult;
    }
    public ServiceResult success(String info){
        ServiceResult serviceResult=new ServiceResult();
        serviceResult.setSuccess(true);
        serviceResult.setId(1);
        serviceResult.setInfo(info);
        return serviceResult;
    }
    public ServiceResult fail(){
        ServiceResult serviceResult=new ServiceResult();
        serviceResult.setSuccess(false);
        serviceResult.setId(0);
        serviceResult.setInfo("fail");
        return serviceResult;
    }
    public ServiceResult fail(String info){
        ServiceResult serviceResult=new ServiceResult();
        serviceResult.setSuccess(false);
        serviceResult.setId(0);
        serviceResult.setInfo(info);
        return serviceResult;
    }
    public static class ServiceResult{
        private boolean isSuccess;
        private int id;
        private String info;
        public boolean isSuccess() {
            return isSuccess;
        }

        public void setSuccess(boolean success) {
            isSuccess = success;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }
}
