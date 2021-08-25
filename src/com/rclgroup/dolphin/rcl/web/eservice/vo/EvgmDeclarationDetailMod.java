package com.rclgroup.dolphin.rcl.web.eservice.vo;

import java.io.Serializable;

public class EvgmDeclarationDetailMod implements Serializable{
    
    private String hdrSeq;
    private String dtlSeq;
    private String container;
    private String vesselVoy;
    private String weightMethod;
    private String verGrossMass;
    private String grossCargo;
    private String tareWeight;
    private String vgmStatus;   
    private String vgmStatusDesc;
    private String selDelete;
    private String recordStatus;
    private String submitDate;
    
    public EvgmDeclarationDetailMod() {
        recordStatus = "";
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getContainer() {
        return container;
    }

    public void setWeightMethod(String weightMethod) {
        this.weightMethod = weightMethod;
    }

    public String getWeightMethod() {
        return weightMethod;
    }

    public void setVerGrossMass(String verGrossMass) {
        this.verGrossMass = verGrossMass;
    }

    public String getVerGrossMass() {
        return verGrossMass;
    }

    public void setGrossCargo(String grossCargo) {
        this.grossCargo = grossCargo;
    }

    public String getGrossCargo() {
        return grossCargo;
    }

    public void setTareWeight(String tareWeight) {
        this.tareWeight = tareWeight;
    }

    public String getTareWeight() {
        return tareWeight;
    }

    public void setVgmStatus(String vgmStatus) {
        this.vgmStatus = vgmStatus;
    }

    public String getVgmStatus() {
        return vgmStatus;
    }

    public void setSelDelete(String selDelete) {
        this.selDelete = selDelete;
    }

    public String getSelDelete() {
        return selDelete;
    }

    public void setVgmStatusDesc(String vgmStatusDesc) {
        this.vgmStatusDesc = vgmStatusDesc;
    }

    public String getVgmStatusDesc() {
        return vgmStatusDesc;
    }

    public void setVesselVoy(String vesselVoy) {
        this.vesselVoy = vesselVoy;
    }

    public String getVesselVoy() {
        return vesselVoy;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setHdrSeq(String hdrSeq) {
        this.hdrSeq = hdrSeq;
    }

    public String getHdrSeq() {
        return hdrSeq;
    }

    public void setDtlSeq(String dtlSeq) {
        this.dtlSeq = dtlSeq;
    }

    public String getDtlSeq() {
        return dtlSeq;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getSubmitDate() {
        return submitDate;
    }
}
