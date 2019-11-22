package com.briup.apps.cms.utils;

/**
 * 
 * @ClassName: CustomerException
 * @Description: 自定义异常类
 * @Author "张晨光"
 * @DateTime 2019年11月18日 上午12:53:53
 */
public class CustomerException extends RuntimeException{

	public CustomerException() {
	}

	public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CustomerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public CustomerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CustomerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
