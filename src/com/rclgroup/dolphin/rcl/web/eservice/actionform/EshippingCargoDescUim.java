package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.web.actionform.BaseActionForm;

public class EshippingCargoDescUim extends BaseActionForm 
{
    private String blNumber;
    private String commodity;
    private String containerNo;
    private String marksAndNumbers;
    private String description;

    public void setBlNumber(String blNumber) {
        this.blNumber = blNumber;
    }

    public String getBlNumber() {
        return blNumber;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity;
    }

    public String getCommodity() {
        return commodity;
    }

    public void setContainerNo(String containerNo) {
        this.containerNo = containerNo;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setMarksAndNumbers(String marksAndNumbers) {
        this.marksAndNumbers = marksAndNumbers;
    }

    public String getMarksAndNumbers() {
        return marksAndNumbers;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
