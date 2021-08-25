package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EshippingPackageTypeListMod implements Serializable 
{
    private String packageCode;
    private String packageName;

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }
}
