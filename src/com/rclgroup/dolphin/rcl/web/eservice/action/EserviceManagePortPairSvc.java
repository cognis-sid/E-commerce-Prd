 /*------------------------------------------------------
  EserviceManagePortPairSvc.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 07/10/2014
 - Change Log ----------------------------------------------------
##  DD/MM/YY    -User-      -TaskRef-       -ShortDescription-
01  11/12/2015   Watchakorn                  Change solution for Represented Company Contract
---------------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.niit.control.common.ComboVO;
import com.niit.control.web.UserAccountBean;
import com.niit.control.web.action.BaseAction;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceManagePortPairUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceManagePortPairDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;
import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;

public class EserviceManagePortPairSvc extends BaseAction {

    private final String ADD_CONTRACT_COMPANY           = "add";
    private final String UPD_CONTRACT_COMPANY           = "upd";
    private final String DEL_CONTRACT_COMPANY           = "del";
    private final String SAVE_CONTRACT_COMPANY          = "save";
    private final String FIND_CONTRACT_COMPANY          = "find";

    //##01 Begin
    private final String ADD_PORT_PAIR                  = "addPortPair";
    private final String UPD_PORT_PAIR                  = "updPortPair";
    private final String DEL_PORT_PAIR                  = "delPortPair";
    private final String FIND_PORT_PAIR                 = "findPortPair";
    private final String GEN_UNIQ_PWD                   = "genUniqPwd";
    private final String SUSPEND_CONTRACT_COMPANY       = "suspendCon";
    private final String SUSPEND_PORT_PAIR              = "suspendPortPair";
    private final String FIND_USER_DETAIL               = "findUserDetail";
    //##01 End

    private FormatUtil                  formatUtil      = null;
    private EserviceManagePortPairUim   form            = null;
    private HttpServletRequest          request         = null;

    private String getForwardPage(EserviceManagePortPairUim form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String pageAction   = null;
        String forwardPage  = null;

        try {
            pageAction          = form.getPageAction();
            this.formatUtil     = new FormatUtil(request, response);
            this.form           = form;
            this.request        = request;

            if (ONLOAD.equals(pageAction)){
                forwardPage = this.lp_onloadPage();
            }else if (ADD_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.lp_addContractPartyCompany();
            }else if (UPD_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.lp_updContractCompany();
            }else if (DEL_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.lp_delContractCompany();
            }else if (FIND_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.lp_getdataList();
            }else if (SAVE_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.lp_save();
            //##01 Begin
            }else if (SUSPEND_CONTRACT_COMPANY.equals(pageAction)){
                forwardPage = this.suspendContractParty();
            }else if (ADD_PORT_PAIR.equals(pageAction)){
                forwardPage = this.addPortPair();
            }else if (UPD_PORT_PAIR.equals(pageAction)){
                forwardPage = this.updPortPair();
            }else if (DEL_PORT_PAIR.equals(pageAction)){
                forwardPage = this.delPortPair();
            }else if (FIND_PORT_PAIR.equals(pageAction)){
                forwardPage = this.findPortPair();
            }else if(GEN_UNIQ_PWD.equals(pageAction)){
                forwardPage = this.genUniqPwd();
            }else if(SUSPEND_PORT_PAIR.equals(pageAction)){
                forwardPage = this.suspendPortPair();
            }else if(FIND_USER_DETAIL.equals(pageAction)){
                forwardPage = this.findUserDetail();
                //##01 End
            }

        } catch (Exception ex) {
            throw ex;
        }
        return forwardPage;
    }

    //##01 Begin
    /**
     * addPortPair : Add new input row for 'Port Pair'
     * @return status
     */
    public String addPortPair(){
        System.out.println("[EserviceManagePortPairSvc][addPortPair][Begin]");
        List<EserviceContractPartyPortPairMod>  portPairs         = null;
        EserviceContractPartyPortPairMod        portPair          = null;
        String                                  maxPkEsvPpDtlSeq  = null;
        String                                  pkEsvPpHdrSeq     = null;

        try{
            portPairs         = this.form.getNewPortPairList();
            portPair          = new EserviceContractPartyPortPairMod();
            maxPkEsvPpDtlSeq  = FormatUtil.nullToBlank(request.getParameter("maxPkEsvPpDtlSeq")).equals("") ? "0" : request.getParameter("maxPkEsvPpDtlSeq");
            pkEsvPpHdrSeq     = FormatUtil.nullToBlank(request.getParameter("pkEsvPpHdrSeq"));

            System.out.println("[EserviceManagePortPairSvc][addPortPair] maxPkEsvPpDtlSeq :: " + maxPkEsvPpDtlSeq);
            System.out.println("[EserviceManagePortPairSvc][addPortPair] pkEsvPpHdrSeq    :: " + pkEsvPpHdrSeq);

            portPair.setPkEsvPpDtlSeq(maxPkEsvPpDtlSeq);
            portPair.setPkEsvPpHdrSeq(pkEsvPpHdrSeq);
            portPair.setPortPairStatusFlag(EserviceManagePortPairDao.ADD);

            portPairs.add(portPair);
            form.setMaxPkEsvPpDtlSeq(maxPkEsvPpDtlSeq);

            this.formatUtil.writeMSG("OK");
        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceManagePortPairSvc][addPortPair][End]");
        }

        return null;
    }
    //##01 End

    //##01 Begin
    /**
     * updPortPair : When user change Port Pair data have to save to model.
     * @return status
     */
    public String updPortPair(){
        System.out.println("[EserviceManagePortPairSvc][updPortPair][Begin]");

        List<EserviceContractPartyPortPairMod>  portPairList        = null;
        EserviceContractPartyPortPairMod        portPair            = null;
        String                                  pkEsvPpDtlSeq       = null;
        String                                  fkEsvPpHdrSeq       = null;
        String                                  fkPOL               = null;
        String                                  POLDesc             = null;
        String                                  fkPOD               = null;
        String                                  PODDesc             = null;
        String                                  effDate             = null;
        String                                  expDate             = null;
        String                                  portPairStatusFlag  = null;
        List<EserviceContractPartyPortPairMod>  contractPartyList   = null;
        EserviceContractPartyPortPairMod        contractParty       = null;
        String                                  fkUserId            = null;
        List<EserviceContractPartyPortPairMod>  newPortPairList     = null;
        List<EserviceContractPartyPortPairMod>  newUserList         = null;
        List<EserviceContractPartyPortPairMod>  updPortPairList     = null;

        try{
            portPairList        = form.getPortpairContractPartyList();
            pkEsvPpDtlSeq       = FormatUtil.nullToBlank(request.getParameter("pkEsvPpDtlSeq"));
            fkEsvPpHdrSeq       = FormatUtil.nullToBlank(request.getParameter("fkEsvPpHdrSeq"));
            fkPOL               = FormatUtil.nullToBlank(request.getParameter("fkPOL"));
            POLDesc             = FormatUtil.nullToBlank(request.getParameter("POLDesc"));
            fkPOD               = FormatUtil.nullToBlank(request.getParameter("fkPOD"));
            PODDesc             = FormatUtil.nullToBlank(request.getParameter("PODDesc"));
            effDate             = FormatUtil.nullToBlank(request.getParameter("effDate"));
            expDate             = FormatUtil.nullToBlank(request.getParameter("expDate"));
            portPairStatusFlag  = FormatUtil.nullToBlank(request.getParameter("portPairStatusFlag"));
            contractPartyList   = form.getUserContractPartyList();
            newPortPairList     = form.getNewPortPairList();
            newUserList         = form.getNewUserList();
            updPortPairList     = form.getUpdPortPairList();

            boolean checker = false;
            for(int i = 0 ; i < contractPartyList.size() ; i++ ){
                contractParty = contractPartyList.get(i);
                if(fkEsvPpHdrSeq.equals(contractParty.getPkEsvPpHdrSeq())){
                    fkUserId  = contractParty.getFkUserId();
                    checker = true;
                    break;
                }
            }

            if(!checker){
                for(EserviceContractPartyPortPairMod cur : newUserList){
                    if(fkEsvPpHdrSeq.equals(cur.getPkEsvPpHdrSeq())){
                        fkUserId  = cur.getFkUserId();
                        break;
                    }
                }
            }

            System.out.println("[EserviceManagePortPairSvc][updPortPair] pkEsvPpDtlSeq      :: " + pkEsvPpDtlSeq);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] fkEsvPpHdrSeq      :: " + fkEsvPpHdrSeq);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] fkPOL              :: " + fkPOL);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] POLDesc            :: " + POLDesc);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] fkPOD              :: " + fkPOD);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] PODDesc            :: " + PODDesc);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] effDate            :: " + effDate);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] expDate            :: " + expDate);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] portPairStatusFlag :: " + portPairStatusFlag);
            System.out.println("[EserviceManagePortPairSvc][updPortPair] fkUserId           :: " + fkUserId);

            checker = false;
            for(EserviceContractPartyPortPairMod cur : portPairList){

                if(cur.getPkEsvPpDtlSeq().equals(pkEsvPpDtlSeq)){
                    portPair = cur;

                    // portPair.setPkEsvPpDtlSeq(pkEsvPpDtlSeq);
                    portPair.setPkEsvPpHdrSeq(fkEsvPpHdrSeq);
                    portPair.setFkPOL(fkPOL);
                    portPair.setPOLDesc(POLDesc);
                    portPair.setFkPOD(fkPOD);
                    portPair.setPODDesc(PODDesc);
                    portPair.setEffDate(effDate);
                    portPair.setExpDate(expDate);
                    portPair.setFkUserId(fkUserId);
                    if(!portPair.getPortPairStatusFlag().equals(EserviceManagePortPairDao.ADD)) {
                        portPair.setPortPairStatusFlag(EserviceManagePortPairDao.UPD);
                    }

                    updPortPairList.add(portPair);
                    checker = true;
                    break;
                }
            }

            if(!checker){
              for(EserviceContractPartyPortPairMod cur : newPortPairList){
                  if(cur.getPkEsvPpDtlSeq().equals(pkEsvPpDtlSeq)){
                      portPair = cur;

                      // portPair.setPkEsvPpDtlSeq(pkEsvPpDtlSeq);
                      portPair.setPkEsvPpHdrSeq(fkEsvPpHdrSeq);
                      portPair.setFkPOL(fkPOL);
                      portPair.setPOLDesc(POLDesc);
                      portPair.setFkPOD(fkPOD);
                      portPair.setPODDesc(PODDesc);
                      portPair.setEffDate(effDate);
                      portPair.setExpDate(expDate);
                      portPair.setFkUserId(fkUserId);
                      if(!portPair.getPortPairStatusFlag().equals(EserviceManagePortPairDao.ADD)) {
                          portPair.setPortPairStatusFlag(EserviceManagePortPairDao.UPD);
                      }
                      break;
                  }
              }

            }

            String responseMsg = validateDate(portPair, portPairList);// Check with available list.
            if("OK".equals(responseMsg)){
                responseMsg = validateDate(portPair, newPortPairList); // Check with new list.
            }

            this.formatUtil.writeMSG(responseMsg);
        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceManagePortPairSvc][updPortPair][End]");
        }
        return null;
    }
    //##01 End

    //##01 Begin
    private String validateDate(EserviceContractPartyPortPairMod portPair, List<EserviceContractPartyPortPairMod> portPairList){
        String responseMsg = "OK";

        String format = "dd/MM/yyyy";     
        
        System.out.println("[cognis EserviceManagePortPairSvc][updPortPair][End]"  +portPair.getEffDate());
        System.out.println("[cognis EserviceManagePortPairSvc][updPortPair][End]"  +portPair.getExpDate());
        
        Date targetEffDate = FormatUtil.stringToDate(portPair.getEffDate(), format);
        Date targetExpDate = FormatUtil.stringToDate(portPair.getExpDate(), format);
        String targetFkPol = FormatUtil.nullToBlank(portPair.getFkPOL());
        String targetFkPod = FormatUtil.nullToBlank(portPair.getFkPOD());
        int removingIndex = 0;
        for(int i = 0 ; i < portPairList.size() ; i++){
            EserviceContractPartyPortPairMod curPortPair = portPairList.get(i);
            Date curEffDate = FormatUtil.stringToDate(curPortPair.getEffDate(), format);
            Date curExpDate = FormatUtil.stringToDate(curPortPair.getExpDate(), format);
            String curFkPol = curPortPair.getFkPOL();
            String curFkPod = curPortPair.getFkPOD();
            removingIndex = i;

            if(!portPair.getPkEsvPpDtlSeq().equals(curPortPair.getPkEsvPpDtlSeq())
                && targetFkPol.equals(curFkPol) && targetFkPod.equals(curFkPod)){
                if(targetEffDate != null && targetExpDate != null){
                    if(curEffDate != null && curExpDate != null){
                        if(targetExpDate.before(targetEffDate) || targetExpDate.compareTo(targetEffDate) == 0){
                            responseMsg = "Expiry Date must greater than Effective Date";
                            break;
                        } else if(
                                (targetEffDate.after(curEffDate) && targetEffDate.before(curExpDate))
                                || (targetExpDate.after(curEffDate) && targetExpDate.before(curExpDate))
                                || (curEffDate.after(targetEffDate) && curEffDate.before(targetExpDate))
                                || (curExpDate.after(targetEffDate) && curExpDate.before(targetExpDate))
                                || (curEffDate.equals(targetEffDate) || curExpDate.equals(targetEffDate))
                                || (curEffDate.equals(targetExpDate) || curExpDate.equals(targetExpDate))
                            ){
                            responseMsg = "At Seq#{0}, Effective Date/Expiry Date  should not overlaping for the same POL/POD";
                            break;
                        }
                    }
                } else if(targetEffDate != null && targetExpDate == null){
                    // System.out.println("[EserviceManagePortPairSvc][updPortPair] effDate is not null.");
                    if((curEffDate.compareTo(targetEffDate) == 0 || curExpDate.compareTo(targetEffDate) == 0)
                        || (curEffDate.before(targetEffDate) && curExpDate.after(targetEffDate))){
                        responseMsg = "At Seq#{0}, Effective Date/Expiry Date  should not overlaping for the same POL/POD";
                        break;
                    }
                } else if(targetEffDate == null && targetExpDate != null){
                    // System.out.println("[EserviceManagePortPairSvc][updPortPair] expDate is not null.");
                    if((curEffDate.compareTo(targetExpDate) == 0 || curExpDate.compareTo(targetExpDate) == 0)
                        || (curEffDate.before(targetExpDate) && curExpDate.after(targetExpDate))){
                        responseMsg = "At Seq#{0}, Effective Date/Expiry Date  should not overlaping for the same POL/POD";
                        break;
                    }
                }
            }
        }
        return responseMsg;
    }
    //##01 End

    //##01 Begin
    /**
     * delPortPair : Delete new port pair row from list.
     * @return
     */
    public String delPortPair(){
        System.out.println("[EserviceManagePortPairSvc][delPortPair][Begin]");

        List<EserviceContractPartyPortPairMod>  portPairList    = null;
        List<EserviceContractPartyPortPairMod>  newPortPairList = null;
        EserviceContractPartyPortPairMod        portPair        = null;
        String                                  pkEsvPpDtlSeq   = null;

        try{

            pkEsvPpDtlSeq   = FormatUtil.nullToBlank(request.getParameter("pkEsvPpDtlSeq"));
            portPairList    = form.getPortpairContractPartyList();
            newPortPairList = form.getNewPortPairList();

            System.out.println("[EserviceManagePortPairSvc][delPortPair] pkEsvPpDtlSeq :: " + pkEsvPpDtlSeq);

            if(newPortPairList != null){
                int index = 0;
                for(EserviceContractPartyPortPairMod cur : newPortPairList){
                    if(pkEsvPpDtlSeq.equals(cur.getPkEsvPpDtlSeq())){
                        newPortPairList.remove(index);
                        break;
                    }
                    index++;
                }
            }

            if(portPairList != null){
                portPairList.addAll(newPortPairList);
            }

            if(portPairList != null && portPairList.size() > 0){
                for(int i = 0; i < portPairList.size() ; i++){
                    portPair = portPairList.get(i);
                    if(pkEsvPpDtlSeq.equals(portPair.getPkEsvPpDtlSeq())){
                        if(portPair.getPortPairStatusFlag().equals(EserviceManagePortPairDao.ADD)){
                            portPairList.remove(i);
                        }
                        break;
                    }
                }
            }

            this.formatUtil.writeMSG("OK");
        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceManagePortPairSvc][delPortPair][End]");
        }
        return null;
    }
    //##01 End

    //##01 Begin
    /**
     * findPortPairFromDB : Call DAO to get Port Pair List.
     * @param objDao
     * @param userContractPartyMod
     * @return
     */
    private List<EserviceContractPartyPortPairMod> findPortPairFromDB(EserviceManagePortPairDao objDao, EserviceContractPartyPortPairMod userContractPartyMod){
        System.out.println("[EserviceManagePortPairSvc][findPortPairFromDB][Begin]");
        List<EserviceContractPartyPortPairMod> result                       = null;
        String                                 tempMaxPkEsvPpDtlSeq         = "0";
        List<EserviceContractPartyPortPairMod> newPortPairList              = null;
        String                                 pkEsvPpHdrSeq                = null;
        String                                 chkBoxExcludeExpiredPortPair = null;

        try{
            pkEsvPpHdrSeq                 = userContractPartyMod != null ? userContractPartyMod.getPkEsvPpHdrSeq() : "";
            chkBoxExcludeExpiredPortPair  = form.getChkBoxExcludeExpiredPortPair();

            if(!"".equals(pkEsvPpHdrSeq) && "".equals(userContractPartyMod.getStatusFlag())){
                result = objDao.findPortPair(pkEsvPpHdrSeq, chkBoxExcludeExpiredPortPair);
            } else {
                result = new ArrayList<EserviceContractPartyPortPairMod>();
            }
            newPortPairList = this.form.getNewPortPairList();

            System.out.println("[EserviceManagePortPairSvc][findPortPairFromDB] newPortPairList.size() :: "+newPortPairList.size());
            if(newPortPairList != null && newPortPairList.size() > 0){
                for(int i = 0 ; i < newPortPairList.size() ; i++ ){
                    EserviceContractPartyPortPairMod newPortPair = newPortPairList.get(i);
                    if(newPortPair.getPkEsvPpHdrSeq() != null
                        && newPortPair.getPkEsvPpHdrSeq().equals(pkEsvPpHdrSeq)
                      ){
                        result.add(newPortPair);
                    }
                }
            }

            if(result != null){
                for(int i = 0 ; i < result.size() ; i++){
                    EserviceContractPartyPortPairMod mod = result.get(i);
                    if(Integer.parseInt(mod.getPkEsvPpDtlSeq()) > Integer.parseInt(tempMaxPkEsvPpDtlSeq)) {
                        tempMaxPkEsvPpDtlSeq = mod.getPkEsvPpDtlSeq();
                    }
                }

                this.form.setTotPortpairRecord(result.size());
            } else {
                this.form.setTotRecord(0);
            }

            this.form.setMaxPkEsvPpDtlSeq(tempMaxPkEsvPpDtlSeq);
            this.form.setPortpairContractPartyList(result);
            this.form.setSelectedPkEsvPpHdrSeq(pkEsvPpHdrSeq);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("[EserviceManagePortPairSvc][findPortPairFromDB][End]");
            return result;
        }
    }
    //##01 End

    //##01 Begin
    /**
     * findPortPair : Find port pair by PK_ESV_HDR_SEQ
     * @return
     */
    public String findPortPair(){
        System.out.println("[EserviceManagePortPairSvc][findPortPair][Begin]");

        String                                  pkEsvPpHdrSeq                      = null;
        EserviceManagePortPairDao               eserviceManagePortPairDao          = null;
        String                                  responseMsg                        = null;
        List<EserviceContractPartyPortPairMod>  userContractPartyList              = null;
        EserviceContractPartyPortPairMod        userContractParty                  = null;
        List<EserviceContractPartyPortPairMod>  newUserList                        = null;

        try{
            pkEsvPpHdrSeq             = FormatUtil.nullToBlank(this.request.getParameter("pkEsvPpHdrSeq"));
            eserviceManagePortPairDao = this.getDao();
            userContractPartyList     = this.form.getUserContractPartyList();
            newUserList               = this.form.getNewUserList();

            System.out.println("[EserviceManagePortPairSvc][findPortPair] pkEsvPpHdrSeq :: " + pkEsvPpHdrSeq);

            boolean isFound = false;
            for(EserviceContractPartyPortPairMod cur : userContractPartyList){
                if(cur.getPkEsvPpHdrSeq().equals(pkEsvPpHdrSeq)){
                    System.out.println("found! pkEsvPpHdrSeq "+ pkEsvPpHdrSeq);
                    userContractParty = cur;
                    isFound = true;
                    break;
                }
            }

            if(!isFound){
                for(EserviceContractPartyPortPairMod cur : newUserList){
                    if(cur.getPkEsvPpHdrSeq().equals(pkEsvPpHdrSeq)){
                      System.out.println("found! pkEsvPpHdrSeq "+ pkEsvPpHdrSeq);
                      userContractParty = cur;
                      isFound = true;
                      break;
                    }
                }
            }

            findPortPairFromDB(eserviceManagePortPairDao, userContractParty);

            String responseJsonString = convertPortPairListToJsonString(this.form.getPortpairContractPartyList());

            responseMsg = responseJsonString;
        }catch(Exception e){
            e.printStackTrace();
            responseMsg = e.getMessage();
        }finally{
            System.out.println("[EserviceManagePortPairSvc][findPortPair][End]");
            this.formatUtil.writeMSG(responseMsg);
        }
        return null;
    }
    //##01 End

    //##01 Begin
    private String convertPortPairListToJsonString(List<EserviceContractPartyPortPairMod> portPairList){
        System.out.println("[EserviceManagePortPairSvc][convertPortPairListToJsonString][Begin]");
        String response = "{\"status\":\"OK\"";
        try{
            response += ",\"resultList\":[";
            String strPortPairList = "";

            System.out.println("[EserviceManagePortPairSvc][convertPortPairListToJsonString] portPairList.size() :: "+portPairList.size());

            for(EserviceContractPartyPortPairMod cur : portPairList){
                if(!"".equals(strPortPairList)){
                    strPortPairList += ",";
                }
                strPortPairList += "{"
                                + "\"pkEsvPpHdrSeq\" : \"" + cur.getPkEsvPpHdrSeq() + "\""
                                + ", \"pkEsvPpDtlSeq\" : \"" + cur.getPkEsvPpDtlSeq() + "\""
                                + ", \"portPairStatusFlag\" : \"" + cur.getPortPairStatusFlag() + "\""
                                + ", \"fkPOL\" : \"" + cur.getFkPOL() + "\""
                                + ", \"POLDesc\" : \"" + cur.getPOLDesc() + "\""
                                + ", \"fkPOD\" : \"" + cur.getFkPOD() + "\""
                                + ", \"PODDesc\" : \"" + cur.getPODDesc() + "\""
                                + ", \"effDate\" : \"" + cur.getEffDate() + "\""
                                + ", \"expDate\" : \"" + cur.getExpDate() + "\""
                                + "}";
            }
            response += strPortPairList;
            response += "]";
        } catch (Exception e){
          e.printStackTrace();
          response = "{\"status\":\"" + e.getMessage() + "\"";
        } finally {
            response += "}";
            System.out.println("[EserviceManagePortPairSvc][convertPortPairListToJsonString] response :: "+response);
            System.out.println("[EserviceManagePortPairSvc][convertPortPairListToJsonString][End]");
        }
        return response;
    }
    //##01 End

    public ActionForward executeAction(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
        EserviceManagePortPairUim form = null;

        String pageAction = null;
        String forwardPage = null;
        try {
            pageAction = getPageAction(mapping);

            form = getForm(actionForm, pageAction);
            form.setPageAction(pageAction);

            forwardPage = getForwardPage(form, request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return mapping.findForward(forwardPage);
    }

    private String lp_onloadPage() throws Exception {

        System.out.println("[EserviceManagePortPairSvc][lp_onloadPage][Begin]");

        EserviceManagePortPairDao                       objDao                  = null;
        UserAccountBean                                 userAccountBean         = null;
        String                                          userId                  = null;

        try {

            objDao              = getDao();
            userAccountBean     = (UserAccountBean) request.getSession().getAttribute(USER_ACCOUNT_BEAN);
            userId              = userAccountBean.getUserId();

            this.form.setUserLoginId(userId);
            this.form.setChkBoxExcludeExpiredPortPair("Y"); //##01
            this.form.setChkBoxWildCard("Y");
            this.populateComboData(this.form);
            this.form.setCustomerName(userAccountBean.getOrgCode());
            this.form.setErroMessage("NO");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("[EserviceManagePortPairSvc][lp_onloadPage][End]");
        }

        return SUCCESS;
    }

    private String lp_getdataList(){
        System.out.println("[EserviceManagePortPairSvc][lp_getdataList][Begin]");

        EserviceManagePortPairDao                       objDao                        = null;
        List <EserviceContractPartyPortPairMod>         userContractPartyList         = null;
        EserviceContractPartyPortPairMod                modRes                        = null;
        String                                          tempPkPortPairSeq             = null;
        String                                          find                          = null;
        String                                          column                        = null;
        String                                          sortby                        = null;
        String                                          order                         = null;
        String                                          wildcard                      = null;
        String                                          POL                           = null;
        String                                          POD                           = null;
        //##01 Begin
        String                                          selectedPkEsvPpHdrSeq         = null;
        List<EserviceContractPartyPortPairMod>          newUserList                   = null;
        List<EserviceContractPartyPortPairMod>          newPortPairList               = null;
        EserviceContractPartyPortPairMod                userContractPartyMod          = null;
        String                                          chkBoxExcludeExpiredPortPair  = null;
        //##01 End

        try{
            objDao                       = this.getDao();
            find                         = FormatUtil.nullToBlank(this.request.getParameter("find"));
            column                       = FormatUtil.nullToBlank(this.request.getParameter("column"));
            sortby                       = FormatUtil.nullToBlank(this.request.getParameter("sortBy"));
            order                        = FormatUtil.nullToBlank(this.request.getParameter("order"));
            wildcard                     = FormatUtil.chkNullForCheckBox(this.request.getParameter("chkBoxWildCard"));
            POL                          = FormatUtil.nullToBlank(this.request.getParameter("POL"));
            POD                          = FormatUtil.nullToBlank(this.request.getParameter("POD"));
            selectedPkEsvPpHdrSeq        = FormatUtil.nullToBlank(this.request.getParameter("optRowdata"));
            //##01 Begin
            this.form.setNewUserList(new ArrayList<EserviceContractPartyPortPairMod>()); //clear newUserList
            this.form.setNewPortPairList(new ArrayList<EserviceContractPartyPortPairMod>()); //clear newPortPairList
            newUserList                  = this.form.getNewUserList();
            newPortPairList              = this.form.getNewPortPairList();
            chkBoxExcludeExpiredPortPair = FormatUtil.nullToBlank(this.request.getParameter("chkBoxExcludeExpiredPortPair"));
            //##01 End

            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] find                          :: " + find);
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] column                        :: " + column);
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] sortby                        :: " + sortby);
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] order                         :: " + order);
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] wildcard                      :: " + wildcard);
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] POL                           :: " + POL);
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] POD                           :: " + POD);
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] selectedPkEsvPpHdrSeq         :: " + selectedPkEsvPpHdrSeq);
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList] chkBoxExcludeExpiredPortPair  :: " + chkBoxExcludeExpiredPortPair);

            this.form.setFind(find);
            this.form.setColumn(column);
            this.form.setSortBy(sortby);
            this.form.setOrder(order);
            this.form.setChkBoxWildCard(wildcard);
            this.form.setPOL(POL);
            this.form.setPOD(POD);
            this.form.setSelectedPkEsvPpHdrSeq(selectedPkEsvPpHdrSeq); //##01
            this.form.setChkBoxExcludeExpiredPortPair(chkBoxExcludeExpiredPortPair);

            userContractPartyList = objDao.getList(this.form, this.form.getChkBoxExcludeExpiredPortPair());

            //##01 Begin
            if(newUserList != null && newUserList.size() > 0){
              userContractPartyList.addAll(newUserList);
            }

            if(userContractPartyList != null && userContractPartyList.size() > 0){
                for(int i = 0 ; i < userContractPartyList.size() ; i++){
                    userContractPartyMod = userContractPartyList.get(i);
                    if(!EserviceManagePortPairDao.DEL.equals(userContractPartyMod.getStatusFlag())){
                        break;
                    }
                }
            }

            List<EserviceContractPartyPortPairMod> portPairList = findPortPairFromDB(objDao, userContractPartyMod);
            this.form.setPortpairContractPartyList(portPairList);
            //##01 End

            if(userContractPartyList!=null && userContractPartyList.size() > 0){
                for(int i=0;i<userContractPartyList.size();i++){
                    modRes = userContractPartyList.get(i);
                    if(i==0){
                        tempPkPortPairSeq = modRes.getPkEsvPpHdrSeq();
                    }else{
                        if(Integer.parseInt(modRes.getPkEsvPpHdrSeq()) > Integer.parseInt(tempPkPortPairSeq)){
                            tempPkPortPairSeq = modRes.getPkEsvPpHdrSeq();
                        }
                    }
                }
                this.form.setTotRecord(userContractPartyList.size());
            } else {
                this.form.setTotRecord(0);
            }

            this.populateComboData(this.form);
            this.form.setMaxPkEsvPpHdrSeq(tempPkPortPairSeq);
            this.form.setUserContractPartyList(userContractPartyList);

        }catch(CustomDataAccessException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[EserviceManagePortPairSvc][lp_getdataList][End]");
        }
        return SUCCESS;
    }

    private String lp_addContractPartyCompany(){
        System.out.println("[EserviceManagePortPairSvc][lp_addContractPartyCompany][Begin]");

        List<EserviceContractPartyPortPairMod>          userContractPartyList             = null; //##01
        List<EserviceContractPartyPortPairMod>          newUserList                       = null;
        EserviceContractPartyPortPairMod                contractPartyMod                  = null;
        String                                          maxPkEsvPpHdrSeq                  = null;

        try{
            userContractPartyList   = this.form.getUserContractPartyList(); //##01
            newUserList             = this.form.getNewUserList();//##01
            contractPartyMod        = new EserviceContractPartyPortPairMod();
            maxPkEsvPpHdrSeq        = FormatUtil.nullToBlank(request.getParameter("maxPkEsvPpHdrSeq")); //##01

            System.out.println("[EserviceManagePortPairSvc][lp_addContractPartyCompany] maxPkEsvPpHdrSeq        :: " + maxPkEsvPpHdrSeq); //##01

            contractPartyMod.setPkEsvPpHdrSeq(maxPkEsvPpHdrSeq); //##01
            contractPartyMod.setStatusFlag(EserviceManagePortPairDao.ADD);

            // userContractPartyList.add(contractPartyMod);
            newUserList.add(contractPartyMod);//##01
            form.setMaxPkEsvPpHdrSeq(maxPkEsvPpHdrSeq); //##01

            this.formatUtil.writeMSG("OK");
        }catch(Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceManagePortPairSvc][lp_addContractPartyCompany][End]");
        }

        return null;
    }

     private String lp_updContractCompany(){
         System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany][Begin]");

         List <EserviceContractPartyPortPairMod>         contractPartyList       = null;
         EserviceContractPartyPortPairMod                contractPartyMod        = null;
         String                                          pkEsvPpHdrSeq           = null;
         String                                          fkUserId                = null;
         String                                          userName                = null;
         String                                          contractPartyName       = null;
         //##01 Begin
         //  String                                          fkPOL                   = null;
         //  String                                          fkPOD                   = null;
         String                                          pwd                     = null;
         boolean                                         found                   = false;
         List<EserviceContractPartyPortPairMod>          newUserList             = null;
         //##01 End
         String                                          effDate                 = null;
         String                                          expDate                 = null;
         String                                          contractCompany         = null;
         String                                          POLDesc                 = null;
         String                                          PODDesc                 = null;

         try{
             contractPartyList      = form.getUserContractPartyList();
             contractPartyMod       = new EserviceContractPartyPortPairMod();
             pkEsvPpHdrSeq          = FormatUtil.nullToBlank(request.getParameter("pkEsvPpHdrSeq"));
             fkUserId               = FormatUtil.nullToBlank(request.getParameter("fkUserId"));
             userName               = FormatUtil.nullToBlank(request.getParameter("userName"));
             contractPartyName      = FormatUtil.nullToBlank(request.getParameter("contractPartyName"));
             //##01 Begin
             //  fkPOL                  = FormatUtil.nullToBlank(request.getParameter("fkPOL"));
             //  fkPOD                  = FormatUtil.nullToBlank(request.getParameter("fkPOD"));
             pwd                    = FormatUtil.nullToBlank(request.getParameter("pwd"));
             newUserList            = form.getNewUserList();
             //##01 End
             effDate                = FormatUtil.nullToBlank(request.getParameter("effDate"));
             expDate                = FormatUtil.nullToBlank(request.getParameter("expDate"));
             contractCompany        = FormatUtil.nullToBlank(request.getParameter("contractCompany"));
             POLDesc                = FormatUtil.nullToBlank(request.getParameter("POLDesc"));
             PODDesc                = FormatUtil.nullToBlank(request.getParameter("PODDesc"));

             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] pkEsvPpHdrSeq           :: " + pkEsvPpHdrSeq);
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] fkUserId                :: " + fkUserId);
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] userName                :: " + userName);
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] contractPartyName       :: " + contractPartyName);
             //##01 Begin
             //  System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] fkPOL                   :: " + fkPOL);
             //  System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] fkPOD                   :: " + fkPOD);
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] pwd                     :: " + pwd);
             //##01 End
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] effDate                 :: " + effDate);
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] expDate                 :: " + expDate);
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] contractCompany         :: " + contractCompany);
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] POLDesc                 :: " + POLDesc);
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany] PODDesc                 :: " + PODDesc);

             for(int i=0;i<contractPartyList.size();i++){
                 contractPartyMod = contractPartyList.get(i);

                 if(contractPartyMod.getPkEsvPpHdrSeq().equals(pkEsvPpHdrSeq)){
                     contractPartyMod.setFkUserId(fkUserId);
                     contractPartyMod.setUserName(userName);
                     contractPartyMod.setUserNameDisabled(userName);
                     contractPartyMod.setContractPartyName(contractPartyName);
                     contractPartyMod.setContractPartyNameDisabled(contractPartyName);
                     //##01 Begin
                    //  contractPartyMod.setFkPOL(fkPOL);
                    //  contractPartyMod.setFkPOD(fkPOD);
                    //  contractPartyMod.setEffDate(effDate);
                    //  contractPartyMod.setExpDate(expDate);
                     contractPartyMod.setPwd(pwd);
                     //##01 End
                     contractPartyMod.setContractCompany(contractCompany);
                     contractPartyMod.setPOLDesc(POLDesc);
                     contractPartyMod.setPODDesc(PODDesc);
                     if(!contractPartyMod.getStatusFlag().equals(EserviceManagePortPairDao.ADD)) {
                        contractPartyMod.setStatusFlag(EserviceManagePortPairDao.UPD);
                     }

                     found = true; //##01

                     break;
                 }
             }

             //##01 Begin
             if(!found){
                for(int i = 0; i < newUserList.size() ; i++ ){
                    contractPartyMod = newUserList.get(i);
                    if(contractPartyMod.getPkEsvPpHdrSeq().equals(pkEsvPpHdrSeq)){
                        contractPartyMod.setFkUserId(fkUserId);
                        contractPartyMod.setUserName(userName);
                        contractPartyMod.setUserNameDisabled(userName);
                        contractPartyMod.setContractPartyName(contractPartyName);
                        contractPartyMod.setContractPartyNameDisabled(contractPartyName);
                        //##01 Begin
                       //  contractPartyMod.setFkPOL(fkPOL);
                       //  contractPartyMod.setFkPOD(fkPOD);
                       //  contractPartyMod.setEffDate(effDate);
                       //  contractPartyMod.setExpDate(expDate);
                        contractPartyMod.setPwd(pwd);
                        //##01 End
                        contractPartyMod.setContractCompany(contractCompany);
                        contractPartyMod.setPOLDesc(POLDesc);
                        contractPartyMod.setPODDesc(PODDesc);
                        if(!contractPartyMod.getStatusFlag().equals(EserviceManagePortPairDao.ADD)) {
                           contractPartyMod.setStatusFlag(EserviceManagePortPairDao.UPD);
                        }
                        break;
                    }
                }
             }
             //##01 End

             this.formatUtil.writeMSG("OK");
         }catch(Exception e){
             e.printStackTrace();
             this.formatUtil.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceManagePortPairSvc][lp_updContractCompany][End]");
         }

         return null;
     }

     private String lp_delContractCompany(){
         System.out.println("[EserviceManagePortPairSvc][lp_delContractCompany][Begin]");

         List <EserviceContractPartyPortPairMod>         userContractPartyList            = null;
         EserviceContractPartyPortPairMod                contractPartyMod                 = null;
         String                                          pkUserContractPartySeq           = null;

         try{
            //  userContractPartyList        = form.getUserContractPartyList();
             userContractPartyList        = form.getNewUserList();
             pkUserContractPartySeq       = FormatUtil.nullToBlank(request.getParameter("pkUserContractPartySeq"));

             System.out.println("[EserviceManagePortPairSvc][lp_delContractCompany] pkUserContractPartySeq :: " + pkUserContractPartySeq);

             for(int i=0;i<userContractPartyList.size();i++){
                 contractPartyMod = userContractPartyList.get(i);

                 if(contractPartyMod.getPkEsvPpHdrSeq() != null && contractPartyMod.getPkEsvPpHdrSeq().equals(pkUserContractPartySeq)){
                     if(contractPartyMod.getStatusFlag().equals(EserviceManagePortPairDao.ADD)){
                         userContractPartyList.remove(i);
                     }else{
                         contractPartyMod.setStatusFlag(EserviceManagePortPairDao.DEL);
                     }
                     break;
                 }
             }

             this.formatUtil.writeMSG("OK");
         }catch(Exception e){
             e.printStackTrace();
             this.formatUtil.writeMSG(e.getMessage());
         }finally{
             System.out.println("[EserviceManagePortPairSvc][lp_delContractCompany][End]");
         }

         return null;
     }
    private String lp_save(){
        System.out.println("[EserviceManagePortPairSvc][lp_save][Begin]");

        List <EserviceContractPartyPortPairMod>         contractPartyList       = null;
        EserviceContractPartyPortPairMod                contractPartyMod        = null;
        String                                          statusFlag              = null;
        EserviceManagePortPairDao                       objDao                  = null;

        //##01 Begin
        List<EserviceContractPartyPortPairMod>          portPairList            = null;
        List<EserviceContractPartyPortPairMod>          newPortPairList         = null;
        List<EserviceContractPartyPortPairMod>          updPortPairList         = null;
        List<EserviceContractPartyPortPairMod>          newUserList             = null;
        String                                          responseMsg             = null;
        String                                          pkEsvPpHdrSeqForDel     = null;
        String                                          pkEsvPpDtlSeqForDel     = null;
        //##01 End

        try{
            contractPartyList       = form.getUserContractPartyList();
            portPairList            = form.getPortpairContractPartyList();
            objDao                  = this.getDao();
            //##01 Begin
            newPortPairList         = form.getNewPortPairList();
            updPortPairList         = form.getUpdPortPairList();
            newUserList             = form.getNewUserList();
            responseMsg             = "";
            pkEsvPpHdrSeqForDel     = "";
            pkEsvPpDtlSeqForDel     = "";
            //##01 End

            for(int i=0;i<contractPartyList.size();i++){
                contractPartyMod    = contractPartyList.get(i);
                statusFlag          = contractPartyMod.getStatusFlag();
                // responseMsg         = "";

                if(!statusFlag.equals("")){
                    if(statusFlag.equals(EserviceManagePortPairDao.ADD)){
                        //do nothing.
                    } else if(EserviceManagePortPairDao.DEL.equals(statusFlag)){
                        // objDao.suspendContractParty(contractPartyMod.pkEsvPpHdrSeq(), this.form.getUserLoginId());
                        if(!"".equals(pkEsvPpHdrSeqForDel)){
                            pkEsvPpHdrSeqForDel += ", ";
                        }

                        pkEsvPpHdrSeqForDel += contractPartyMod.getPkEsvPpHdrSeq();
                    }
                } else {
                    //##01 Begin

                    String dummyPkEsvPpHdrSeq = contractPartyMod.getPkEsvPpHdrSeq();

                    // Get id for suspend port pair.
                    for(EserviceContractPartyPortPairMod portPair : portPairList){
                        if(EserviceManagePortPairDao.DEL.equals(portPair.getPortPairStatusFlag())){
                            if(!"".equals(pkEsvPpDtlSeqForDel)){
                                pkEsvPpDtlSeqForDel += ", ";
                            }
                            pkEsvPpDtlSeqForDel += portPair.getPkEsvPpDtlSeq();
                        }
                    }

                    System.out.println("newPortPairList.size() "+newPortPairList.size());
                    for(EserviceContractPartyPortPairMod portPair : newPortPairList){

                        if(dummyPkEsvPpHdrSeq.equals(portPair.getPkEsvPpHdrSeq())){
                            String portPairStatusFlag = portPair.getPortPairStatusFlag();

                            if(!"".equals(portPairStatusFlag)){
                                if(EserviceManagePortPairDao.ADD.equals(portPairStatusFlag)) {
                                    portPair.setRecStatus(EserviceManagePortPairDao.ACTIVE);
                                    portPair.setUserId(this.form.getUserLoginId());
                                    portPair.setFlagPortPair(EserviceManagePortPairDao.USER_MODE.MPP);
                                    if(!"".equals(portPair.getFkPOL())
                                        && !"".equals(portPair.getFkPOD())
                                        && !"".equals(portPair.getEffDate())
                                        && !"".equals(portPair.getExpDate())
                                        ){
                                          objDao.addPortPair(portPair);
                                    } else {
                                        if(responseMsg.indexOf(contractPartyMod.getFkUserId()) != -1){
                                            continue;
                                        }
                                        if(!"".equals(responseMsg)){
                                            responseMsg += ", ";
                                        }
                                        responseMsg += contractPartyMod.getFkUserId();
                                    }
                                }
                            }
                        }
                    }
                    //##01 End
                }
            }

            //##01 Begin
            //save new user.
            for(EserviceContractPartyPortPairMod newUser : newUserList){
                statusFlag = newUser.getStatusFlag();
                if(statusFlag.equals(EserviceManagePortPairDao.ADD)){
                    newUser.setFkContractPartyCode("");
                    newUser.setContractPartyName("");
                    newUser.setRecStatus(EserviceManagePortPairDao.ACTIVE);
                    newUser.setUserId(this.form.getUserLoginId());
                    newUser.setFlagPortPair(EserviceManagePortPairDao.USER_MODE.MPP);

                    String dummyPkEsvPpHdrSeq = newUser.getPkEsvPpHdrSeq();
                    String addedPkEsvPpHdrSeq = objDao.addContractPartyPortPair(newUser);

                    System.out.println("newPortPairList.size() "+newPortPairList.size());
                    for(EserviceContractPartyPortPairMod portPair : newPortPairList){

                        if(dummyPkEsvPpHdrSeq.equals(portPair.getPkEsvPpHdrSeq())){
                            portPair.setPkEsvPpHdrSeq(addedPkEsvPpHdrSeq);
                            String portPairStatusFlag = portPair.getPortPairStatusFlag();

                            if(!"".equals(portPairStatusFlag)){
                                if(EserviceManagePortPairDao.ADD.equals(portPairStatusFlag)) {
                                    portPair.setRecStatus(EserviceManagePortPairDao.ACTIVE);
                                    portPair.setUserId(this.form.getUserLoginId());
                                    portPair.setFlagPortPair(EserviceManagePortPairDao.USER_MODE.MPP);
                                    if(!"".equals(portPair.getFkPOL())
                                        && !"".equals(portPair.getFkPOD())
                                        && !"".equals(portPair.getEffDate())
                                        && !"".equals(portPair.getExpDate())
                                        ){
                                        objDao.addPortPair(portPair);
                                    } else {
                                        if(responseMsg.indexOf(newUser.getFkUserId()) != -1){
                                            continue;
                                        }
                                        if(!"".equals(responseMsg)){
                                            responseMsg += ", ";
                                        }
                                        responseMsg += newUser.getFkUserId();
                                    }
                                }
                            }
                        }
                    }
                }
            }
            //##01 End

            //##01 Begin
            /*Update Port Pair*/
            for(EserviceContractPartyPortPairMod cur : updPortPairList){
                cur.setRecStatus(EserviceManagePortPairDao.ACTIVE);
                cur.setUserId(this.form.getUserLoginId());
                cur.setFlagPortPair(EserviceManagePortPairDao.USER_MODE.MPP);

                objDao.updPortPair(cur);
            }
            //##01 End

            //##01 Begin
            if("".equals(responseMsg)){
                //Delete Contract Party
                if(!"".equals(pkEsvPpHdrSeqForDel)){
                    objDao.suspendContractParty(pkEsvPpHdrSeqForDel, this.form.getUserLoginId());
                }
                if(!"".equals(pkEsvPpDtlSeqForDel)){
                    objDao.suspendPortPair(pkEsvPpDtlSeqForDel, this.form.getUserLoginId());
                }

                this.form.setNewUserList(new ArrayList<EserviceContractPartyPortPairMod>());
                this.form.setNewPortPairList(new ArrayList<EserviceContractPartyPortPairMod>());
                this.form.setUpdPortPairList(new ArrayList<EserviceContractPartyPortPairMod>());
                responseMsg = "OK";
            } else {
                responseMsg += " have blank field please check.";
            }
            //##01 End

            this.formatUtil.writeMSG(responseMsg);
        }catch(Exception e){
            e.printStackTrace();
            //added by cognis
             this.form.setErroMessage(e.toString());
             this.form.setErroMessage("CCCCCCCCCCCCCCCC");
            this.formatUtil.writeMSG(e.getMessage());
        }finally{
            System.out.println("[EserviceManagePortPairSvc][lp_save][End]");
        }

        return null;
    }

    private EserviceManagePortPairUim getForm(ActionForm actionForm, String pageAction) throws Exception {
        EserviceManagePortPairUim form = null;
        try {
            form = (EserviceManagePortPairUim)actionForm;
            if (form == null){
                form = new EserviceManagePortPairUim();
            }else if(ONLOAD.equals(pageAction)){
                form.resetForm();
            }
        } catch (Exception ex) {
            throw ex;
        }

        return form;
    }

    private String getPageAction(ActionMapping mapping) throws Exception {
        String pageAction = null;
        try {
            pageAction = mapping.getParameter();
        } catch (Exception ex) {
            pageAction = "";
        }

        return pageAction;
    }

    private EserviceManagePortPairDao getDao() throws Exception {
        EserviceManagePortPairDao dao = null;
        try {
            dao = (EserviceManagePortPairDao)getDao(EserviceManagePortPairDao.DAO_NAME);
        } catch (Exception ex) {
            throw ex;
        }
        return dao;
    }

    public void populateComboData(EserviceManagePortPairUim objForm) {

        try{
            objForm.setColumnList(getColumnList());
            objForm.setSortByList(getSortByList());
            objForm.setOrderList(getComboBoxOrderBy());
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public List getComboBoxOrderBy(){
        List list = new ArrayList();

        try{
            list.add(new ComboVO(EserviceManagePortPairDao.KEY_COLUMN_ORDER_ASC,  EserviceManagePortPairDao.KEY_COLUMN_SHOW_ORDER_ASC));
            list.add(new ComboVO(EserviceManagePortPairDao.KEY_COLUMN_ORDER_DESC, EserviceManagePortPairDao.KEY_COLUMN_SHOW_ORDER_DESC));
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public List getColumnList(){

        List list = new ArrayList();

        try{
            list.add(new ComboVO(""                   , "Select One..."));
            list.add(new ComboVO("PP_HDR.USER_ID"     , "User Id"));
            list.add(new ComboVO("U_LOGIN.USER_NAME"  , "User Name"));
            list.add(new ComboVO("T.CUNAME"           , "Company Name"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List getSortByList(){
        List list = new ArrayList();

        try{
            list.add(new ComboVO(""                   , "Select One..."));
            list.add(new ComboVO("PP_HDR.USER_ID"     , "User Id"));
            list.add(new ComboVO("U_LOGIN.USER_NAME"  , "User Name"));
            list.add(new ComboVO("T.CUNAME"           , "Company Name"));
            list.add(new ComboVO("PP_DTL.POL"         , "Port of Loading"));
            list.add(new ComboVO("PP_DTL.POD"         , "Port of Discharge"));
            list.add(new ComboVO("PP_DTL.EFF_DATE"    , "Effective Date"));
            list.add(new ComboVO("PP_DTL.EXP_DATE"    , "Expire date"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //##01 Begin
    public String genUniqPwd(){
        System.out.println("[EserviceManagePortPairSvc][genUniqPwd][Begin]");

        List <EserviceContractPartyPortPairMod> userContractPartyList     = null;
        EserviceContractPartyPortPairMod        userContractPartyMod      = null;
        String                                  pkEsvPpHdrSeq             = null;
        EserviceManagePortPairDao               eserviceManagePortPairDao = null;

        try{
            userContractPartyList     = this.form.getNewUserList();
            pkEsvPpHdrSeq             = request.getParameter("pkEsvPpHdrSeq");
            eserviceManagePortPairDao = this.getDao();

            System.out.println("[EserviceManagePortPairSvc][genUniqPwd] pkEsvPpHdrSeq :: "+pkEsvPpHdrSeq);

            for(int i = 0 ; i < userContractPartyList.size() ; i++){
                if(pkEsvPpHdrSeq.equals(userContractPartyList.get(i).getPkEsvPpHdrSeq())){
                    String resultPwd = eserviceManagePortPairDao.genUniqPwd(8);
                    userContractPartyMod = userContractPartyList.get(i);
                    userContractPartyMod.setPwd(resultPwd);
                    break;
                }
            }

            this.formatUtil.writeMSG("OK|"+userContractPartyMod.getPwd());
        } catch (Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        } finally {
            System.out.println("[EserviceManagePortPairSvc][genUniqPwd][End]");
        }
        return null;
    }
    //##01 End

    //##01 Begin
    /**
     * suspendContractParty : Update status 'S' (Suspend) for selected Contract Party which select by user.
     * @return error message 'OK' or some error message
     */
    public String suspendContractParty(){
        System.out.println("[EserviceManagePortPairSvc][suspendContractParty][Begin]");
        List <EserviceContractPartyPortPairMod> userContractPartyList     = null;
        EserviceContractPartyPortPairMod        userContractPartyMod      = null;
        String                                  pkEsvPpHdrSeqArry         = null;
        EserviceManagePortPairDao               eserviceManagePortPairDao = null;
        try{
            pkEsvPpHdrSeqArry         = request.getParameter("pkEsvPpHdrSeq");
            userContractPartyList     = this.form.getUserContractPartyList();
            eserviceManagePortPairDao = this.getDao();
            System.out.println("[EserviceManagePortPairSvc][suspendContractParty] pkEsvPpHdrSeq :: " + pkEsvPpHdrSeqArry);
            for(int i = 0 ; i < userContractPartyList.size() ; i++ ){
                userContractPartyMod = userContractPartyList.get(i);
                String[] tempArr = pkEsvPpHdrSeqArry.split(",");
                for(int j = 0 ; j < tempArr.length ; j++){
                    if(tempArr[j].equals(userContractPartyMod.getPkEsvPpHdrSeq())){
                        // userContractPartyList.remove(i);
                        userContractPartyMod.setStatusFlag(EserviceManagePortPairDao.DEL);
                        break;
                    }
                }
            }

            if(userContractPartyList != null){
                this.form.setTotRecord(userContractPartyList.size());
            } else {
                this.form.setTotRecord(0);
            }

            // String result = eserviceManagePortPairDao.suspendContractParty(pkEsvPpHdrSeqArry, this.form.getUserLoginId());
            String result = "OK";

            this.formatUtil.writeMSG(result);
        } catch (Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        } finally {
            System.out.println("[EserviceManagePortPairSvc][suspendContractParty][End]");
        }
        return null;
    }
    //##01 Begin

    //##01 Begin
    /**
     * suspendPortPair : Update RECORD_STATUS TO 'S' in table ESV_CONTRACT_PARTY_PP_DTL
     * @return
     */
    public String suspendPortPair(){
        System.out.println("[EserviceManagePortPairSvc][suspendPortPair][Begin]");

        List<EserviceContractPartyPortPairMod>  portPairList              = null;
        List<EserviceContractPartyPortPairMod>  updPortPair               = null;
        EserviceContractPartyPortPairMod        portPair                  = null;
        String                                  pkEsvPpDtlSeqArr          = null;
        EserviceManagePortPairDao               eserviceManagePortPairDao = null;
        String                                  result                    = null;

        try{
            pkEsvPpDtlSeqArr          = request.getParameter("pkEsvPpDtlSeq");
            portPairList              = this.form.getPortpairContractPartyList();
            updPortPair               = this.form.getUpdPortPairList();
            eserviceManagePortPairDao = this.getDao();

            System.out.println("[EserviceManagePortPairSvc][suspendPortPair] pkEsvPpDtlSeqArr :: " + pkEsvPpDtlSeqArr);

            String[] tempArr = pkEsvPpDtlSeqArr.split(",");
            for(int j = 0 ; j < tempArr.length ; j++ ){
                for(int i = 0 ; i < portPairList.size() ; i++ ){
                    portPair = portPairList.get(i);
                    if(portPair.getPkEsvPpDtlSeq().equals(tempArr[j])){
                        // portPairList.remove(i);
                        portPair.setPortPairStatusFlag(EserviceManagePortPairDao.DEL);
                        break;
                    }
                }
                for(int i = 0 ; i < updPortPair.size() ; i++ ){
                    portPair = updPortPair.get(i);
                    if(portPair.getPkEsvPpDtlSeq().equals(tempArr[j])){
                        // portPairList.remove(i);
                        portPair.setPortPairStatusFlag(EserviceManagePortPairDao.DEL);
                        break;
                    }
                }
            }

            if(portPairList != null){
                this.form.setTotPortpairRecord(portPairList.size());
            } else {
                this.form.setTotPortpairRecord(0);
            }

            // result = eserviceManagePortPairDao.suspendPortPair(pkEsvPpDtlSeqArr, this.form.getUserLoginId());
            result = "OK";

            this.formatUtil.writeMSG(result);
        } catch (Exception e){
            e.printStackTrace();
            this.formatUtil.writeMSG(e.getMessage());
        } finally {
            System.out.println("[EserviceManagePortPairSvc][suspendPortPair][End]");
        }
        return null;
    }
    //##01 End

    //##01 Begin
    /**
     * findUserDetail : Find user detail for checking duplicate data or not.
     * @return
     */
    public String findUserDetail(){
      System.out.println("[EserviceManagePortPairSvc][findUserDetail][Begin]");

      EserviceManagePortPairDao               objDao        = null;
      EserviceContractPartyPortPairMod        modRes        = null;
      String                                  responseMsg   = null;
      String                                  fkUserId      = null;
      String                                  pkEsvPpHdrSeq = null;
      List<EserviceContractPartyPortPairMod>  newUserList   = null;

      try{
          fkUserId      = FormatUtil.nullToBlank(request.getParameter("fkUserId"));
          pkEsvPpHdrSeq = FormatUtil.nullToBlank(request.getParameter("pkEsvPpHdrSeq"));
          objDao        = this.getDao();
          newUserList   = this.form.getNewUserList();

          System.out.println("[EserviceManagePortPairSvc][findUserDetail] fkUserId        :: "+fkUserId);
          System.out.println("[EserviceManagePortPairSvc][findUserDetail] pkEsvPpHdrSeq   :: "+pkEsvPpHdrSeq);

          if("".equals(fkUserId)){
              responseMsg = buildJsonError("Invalid 'User Id'.");
          } else {
              modRes = objDao.findUserDetail(fkUserId);
              if(modRes != null){
                  List<EserviceContractPartyPortPairMod> tempList = objDao.getList(this.form, "N"); // Check all userId.

                  /* checking data on screen and data from db.*/
                  if(tempList != null && tempList.size() > 0){
                      for(int i = 0; i < tempList.size() ; i++){
                          String userName = modRes.getUserName();
                          if(userName.equals(tempList.get(i).getUserName())){
                              responseMsg = buildJsonError("Duplicated 'User Id'.");
                              break;
                          }

                      }
                  }

                  if(newUserList != null && newUserList.size() > 0){
                      for(int i = 0; i < newUserList.size() ;i++){
                          String userName = modRes.getUserName();
                          if(userName.equals(newUserList.get(i).getUserName())){
                              responseMsg = buildJsonError("Duplicated 'User Id'.");
                              break;
                          }
                      }
                  }

                  if(responseMsg == null){
                      responseMsg = convertToJsonString(modRes);
                  }
              } else {
                  responseMsg = buildJsonError("Invalid 'User Id'.");
              }
          }

      } catch (Exception e){
          e.printStackTrace();
          responseMsg = buildJsonError(e.getMessage());
      }
      this.formatUtil.writeMSG(responseMsg);
      return null;
    }
    //##01 End

    //##01 Begin
    /**
     * convertToJsonString : After get contract party data have to convert to json string before send out.
     * @param mod
     * @return
     */
    public String convertToJsonString(EserviceContractPartyPortPairMod mod){

        String jsonString = "{\"status\":\"OK\"";

        if (mod != null){

            jsonString += ",\"userDetail\": {"
                        + "\"userName\":\""           + mod.getUserName() + "\""
                        + ",\"contractPartyName\":\""  + mod.getContractPartyName() + "\""
                        + ",\"fkContractPartyCode\":\"" + mod.getFkContractPartyCode() +"\""
                        + "}"
                        + ",\"msg\":\"success\"}";

        } else {
            jsonString += ",\"msg\":\"Invalid 'User Id'.\"}";
        }


        return jsonString;
    }
    //##01 End

    //##01 Begin
    public String buildJsonError(String status){
        String jsonString = "{\"status\":\"ERROR\",\"msg\":\""+status+"\"}";
        return jsonString;
    }
    //##01 End
}
