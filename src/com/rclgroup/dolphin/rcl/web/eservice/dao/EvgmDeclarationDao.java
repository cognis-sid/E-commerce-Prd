package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.rclgroup.dolphin.rcl.web.eservice.vo.EvgmDeclarationDetailMod;

import java.util.List;
import java.util.Map;

public interface EvgmDeclarationDao {
    
    public static final String DAO_NAME             = "EvgmDeclarationDao";
    public static final String CONTAINER_LIST             = "CONTAINER_LIST";
    
    public static final String USER_ID             = "USER_ID";
    public static final String BOOKING_NO             = "BOOKING_NO";
    public static final String MSG_ERROR             = "MSG_ERROR";
    public static final String HDR_SEQ             = "HDR_SEQ";
    public static final String RESULT             = "RESULT";
    
    public interface PCR_ESV_SI_MAIN{
        public final String PACKAGE_NAME = "PCR_ESV_SI_MAIN";
        public final String PRR_ESI_CHECK_EXIST_CNTR = PACKAGE_NAME+".PRR_ESI_CHECK_EXIST_CNTR";
    }
    
    public interface PCR_ESV_VGM{
        public final String PACKAGE_NAME = "VASAPPS.PCR_ESV_VGM";
        public final String PRR_VGM_GET_COM_NAME = PACKAGE_NAME+".PRR_VGM_GET_COM_NAME";
        public final String PRR_VGM_GET_CONTAINER = PACKAGE_NAME+".PRR_VGM_GET_CONTAINER";
        
        public final String PRR_VGM_INSERT_HDR = PACKAGE_NAME+".PRR_VGM_INSERT_HDR";
        public final String PRR_VGM_INSERT_DTL = PACKAGE_NAME+".PRR_VGM_INSERT_DTL";
        public final String PRR_VGM_DEL_DTL = PACKAGE_NAME+".PRR_VGM_DEL_DTL";
        public final String PRR_VGM_UPD_DTL = PACKAGE_NAME+".PRR_VGM_UPD_DTL";
        public final String PRR_VGM_CHECK_BOOKING = PACKAGE_NAME+".PRR_VGM_CHECK_BOOKING";
        public final String PRR_VGM_FIND_BOOKING = PACKAGE_NAME+".PRR_VGM_FIND_BOOKING";
        public final String PRR_VGM_GET_ORG_TYPE = PACKAGE_NAME+".PRR_VGM_GET_ORG_TYPE";
        
        public final String PRR_VGM_SUBMISSION_ENOTICE = PACKAGE_NAME+".PRR_VGM_SUBMISSION_ENOTICE";
    
    }
    
    public interface P_I_V{
        public final String USER_ID                   = "P_I_USER_ID";
        public final String BOOKING_NO                   = "P_I_BOOKING_NO";
        public final String SHIPPER_NAME                   = "P_I_SHIPPER_NAME";
        public final String REP_NAME                   = "P_I_REP_NAME";
        public final String AUTHORIZE_PERSON                   = "P_I_AUTHORIZE_PERSON";
        public final String HDR_SEQ                   = "P_I_HDR_SEQ";
        public final String EQUIPMENT_NO                   = "P_I_EQUIPMENT_NO";
        public final String METHOD                   = "P_I_METHOD";
        public final String VGM                   = "P_I_VGM";
        public final String GROSS_CARGO_WEIGHT                   = "P_I_GROSS_CARGO_WEIGHT";
        public final String TARE_WEIGHT                   = "P_I_TARE_WEIGHT";
        public final String SUBMIT_STATUS                   = "P_I_SUBMIT_STATUS";
        public final String USER_FSC                   = "P_I_V_FSC";
        public final String DTL_SEQ                   = "P_I_V_DTL_SEQ";
    }
    
    public interface P_O_V{
        public final String COMPANY_NAME                   = "P_O_COM_NAME";
        public final String RESULT                   = "P_O_RESULT";
        public final String MSG                   = "P_O_MSG";
        public final String HDR_SEQ                   = "P_O_HDR_SEQ";
        public final String ORG_TYPE                   = "P_O_ORG_TYPE";
        public final String RESULT_HDR                   = "P_O_RESULT_HDR";
        public final String ERROR                   = "P_O_V_ERROR";
        
    }
    
    public String getCompanyName(String userId);
    public List getContainerList(String userId,String bookingNo,String userFsc);
    public Map checkBookingAvailable(String booking,String userId);
    public Map checkExcelBookingAvailable(String booking,String userId);
    public boolean deleteContainer(String dtlSeq ,String hdrSeq,String containerNo);
    public String updateVGMDtl(EvgmDeclarationDetailMod mod,String userId,String hdrSeq);
    public String insertVGMDtl(EvgmDeclarationDetailMod mod,String userId,String hdrSeq);
    public String insertVGMHdr(String booking,String shipperName,String repName,String authPerson,String userId);
    public boolean checkContainer(String container);
    public String getOrgType(String userId);
    public String submitEnotice(String bookingId,String userId);
    
}
