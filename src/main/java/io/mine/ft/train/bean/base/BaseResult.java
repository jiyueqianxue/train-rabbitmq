package io.mine.ft.train.bean.base;

import java.io.Serializable;

/**基础回复
 * @author machao
 *
 */

public class BaseResult implements Serializable{
	
	private static final long serialVersionUID = -4496867430298036980L;
	
	/** 成功标志*/
	private boolean success;
	
	/** 信息 */
	private String code;
	
	/** 描述 */
	private String msg;
	
	
	private BaseResult(boolean success, String code, String msg) {
		super();
		this.success = success;
		this.code = code;
		this.msg = msg;
	}
	
	public static BaseResult createSuccess() {
		return new BaseResult(true, "", "");
	}
	
	public static BaseResult createFail(String code, String msg) {
		return new BaseResult(false, code, msg);
	}
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @param msg the msg to set
	 */
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
