package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class AdminBookingFileLogMod {

	private String id;
	private String idlogfk;
	private String errorLog;
	private String typeOfFile;
	private String fileName;
	private String recordAddUser;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdlogfk() {
		return idlogfk;
	}
	public void setIdlogfk(String idlogfk) {
		this.idlogfk = idlogfk;
	}
	public String getErrorLog() {
		return errorLog;
	}
	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getRecordAddUser() {
		return recordAddUser;
	}
	public void setRecordAddUser(String recordAddUser) {
		this.recordAddUser = recordAddUser;
	}
	public String getTypeOfFile() {
		return typeOfFile;
	}
	public void setTypeOfFile(String typeOfFile) {
		this.typeOfFile = typeOfFile;
	}	
	
	
}
