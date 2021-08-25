package com.rclgroup.dolphin.rcl.web.eservice.actionform;

import com.niit.control.common.ComboVO;
import com.niit.control.web.actionform.PaginationForm;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.upload.FormFile;

public class EvgmDeclarationUim extends PaginationForm{
    
    private String currPageAction;
    private String prevPageAction;
    private String errMsg;
    
    private String userId;
    private String userFsc;
    
    private String selectAction;
    private String bookingNo;
    private String vessel;
    private String voyage;
    private String shipperName;
    private String respresentName;
    private String authorizePerson;
    private String submissionDate;
    private String displayVesslVoy;
    private String hdrSeq;
    
    private FormFile    dataFile;
    
    private List vgmDetailList;
    private List displayDetailList;
    private List errorList;
    private List methodList;
    
    private int pagePrevNo;
    private String delItem;
    private String orgType;
    private String allSuccess;
    
    public EvgmDeclarationUim() {
        this.userId             = null;
        this.userFsc            = null;
        
        this.resetForm();
    }
    
    
    public void resetForm(){
        setBackVisible              (true);
        setRefreshVisible           (false);
        setSaveVisible              (true);
        setSelectAction("1");
        createMethodList();
        
        this.hdrSeq = "";
        this.bookingNo = "";
        this.vessel= "";
        this.voyage= "";
        this.shipperName= "";
        this.respresentName= "";
        this.authorizePerson= "";
        this.submissionDate= "";
        this.displayVesslVoy = "";
        this.vgmDetailList = new ArrayList();
        this.displayDetailList = new ArrayList();
        this.errorList = new ArrayList();
        
        this.pagePrevNo = 1;
        this.delItem = "";
        this.errMsg = "";
        this.orgType = "";
        this.allSuccess = "";
    }
    
    private void createMethodList(){
        this.methodList = new ArrayList();
        ComboVO vo = new ComboVO();
        vo.setCode("1");
        vo.setName("Method 1");
        this.methodList.add(vo);
        vo = new ComboVO();
        vo.setCode("2");
        vo.setName("Method 2");
        this.methodList.add(vo);
    }
    
//    public String getDisplayVesslVoy(){
//        displayVesslVoy = "";
//        if(this.vessel.equals("") && this.voyage.equals("")){
//            displayVesslVoy =  "";
//        }else{
//            if(this.vessel.equals("")){
//                displayVesslVoy = this.voyage;
//            }else if(this.voyage.equals("")){
//                displayVesslVoy = this.vessel;
//            }else{
//                displayVesslVoy = this.vessel+"/"+this.voyage;
//            }
//        }
//        
//        return displayVesslVoy;
//    }

    public void setSelectAction(String selectAction) {
        this.selectAction = selectAction;
    }

    public String getSelectAction() {
        return selectAction;
    }

    public void setCurrPageAction(String currPageAction) {
        this.currPageAction = currPageAction;
    }

    public String getCurrPageAction() {
        return currPageAction;
    }

    public void setPrevPageAction(String prevPageAction) {
        this.prevPageAction = prevPageAction;
    }

    public String getPrevPageAction() {
        return prevPageAction;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserFsc(String userFsc) {
        this.userFsc = userFsc;
    }

    public String getUserFsc() {
        return userFsc;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setVessel(String vessel) {
        this.vessel = vessel;
    }

    public String getVessel() {
        return vessel;
    }

    public void setVoyage(String voyage) {
        this.voyage = voyage;
    }

    public String getVoyage() {
        return voyage;
    }

    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    public String getShipperName() {
        return shipperName;
    }

    public void setRespresentName(String respresentName) {
        this.respresentName = respresentName;
    }

    public String getRespresentName() {
        return respresentName;
    }

    public void setAuthorizePerson(String authorizePerson) {
        this.authorizePerson = authorizePerson;
    }

    public String getAuthorizePerson() {
        return authorizePerson;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setDataFile(FormFile dataFile) {
        this.dataFile = dataFile;
    }

    public FormFile getDataFile() {
        return dataFile;
    }

    public void setDisplayVesslVoy(String displayVesslVoy) {
        this.displayVesslVoy = displayVesslVoy;
    }

    public void setVgmDetailList(List vgmDetailList) {
        this.vgmDetailList = vgmDetailList;
    }

    public List getVgmDetailList() {
        return vgmDetailList;
    }

    public void setDisplayDetailList(List displayDetailList) {
        this.displayDetailList = displayDetailList;
    }

    public List getDisplayDetailList() {
        return displayDetailList;
    }

    public void setErrorList(List errorList) {
        this.errorList = errorList;
    }

    public List getErrorList() {
        return errorList;
    }

    public void setMethodList(List methodList) {
        this.methodList = methodList;
    }

    public List getMethodList() {
        return methodList;
    }

    public void setHdrSeq(String hdrSeq) {
        this.hdrSeq = hdrSeq;
    }

    public String getHdrSeq() {
        return hdrSeq;
    }

    public void setPagePrevNo(int pagePrevNo) {
        this.pagePrevNo = pagePrevNo;
    }

    public int getPagePrevNo() {
        return pagePrevNo;
    }

    public void setDelItem(String delItem) {
        this.delItem = delItem;
    }

    public String getDelItem() {
        return delItem;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgType() {
        return orgType;
    }

    public String getDisplayVesslVoy() {
        return displayVesslVoy;
    }

    public void setAllSuccess(String allSuccess) {
        this.allSuccess = allSuccess;
    }

    public String getAllSuccess() {
        return allSuccess;
    }
}
