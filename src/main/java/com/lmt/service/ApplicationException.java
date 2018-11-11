package com.lmt.service;

/**
 * Created by 热带雨林 on 2018/11/11.
 */
public class ApplicationException extends RuntimeException {
    public ApplicationException(){
        super();
    }
    public ApplicationException(String message){
        super(message);
    }
}
