package com.rclgroup.dolphin.rcl.web.eservice.vo;

public class EReportServerConfigMod {
    private String serverName;
    private String portNumber;
    
    public EReportServerConfigMod() {
        serverName = "";
        portNumber = "";
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getPortNumber() {
        return portNumber;
    }
}
