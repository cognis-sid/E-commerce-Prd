package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class TerminalMod {

	
	
	private String terminalName;
	
	private String terminalCode;

	public String getTerminalName() {
		return terminalName;
	}

	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}

	public String getTerminalCode() {
		return terminalCode;
	}

	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}

	@Override
	public String toString() {
		return "TerminalMod [terminalName=" + terminalName + ", terminalCode=" + terminalCode + "]";
	}

}
