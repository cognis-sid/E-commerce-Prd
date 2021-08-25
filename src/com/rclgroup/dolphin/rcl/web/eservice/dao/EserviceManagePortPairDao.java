 /*------------------------------------------------------
  EserviceManagePortPairDao.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 16/10/2014
 - Change Log -------------------------------------------
 ##     DD/MM/YY    �User-  -TaskRef-   -ShortDescription-
 01     23/12/15    Watchakorn            Change solution for manage port pair
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.exception.BusinessException;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceManagePortPairUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;

import com.rclgroup.dolphin.rcl.web.exception.CustomDataAccessException;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public abstract interface EserviceManagePortPairDao{
    public static final String DAO_NAME                         = "EserviceManagePortPairDao";
    public static final String ESV_LIST_COUNTRY_REF_CUR         = "ESV_LIST_COUNTRY_REF_CUR";

    public static final String ADD                              = "ADD";
    public static final String UPD                              = "UPD";
    public static final String DEL                              = "DEL";

    public static final String ACTIVE                           = "A";
    public static final String SUSPENDED                        = "S";

    public static final String KEY_COLUMN_ORDER_ASC             = "asc";
    public static final String KEY_COLUMN_ORDER_DESC            = "desc";
    public static final String KEY_COLUMN_SHOW_ORDER_ASC        = "Ascending";
    public static final String KEY_COLUMN_SHOW_ORDER_DESC       = "Descending";

    public static final String EXCEPTION                        = "EXCEPTION";

    public interface USER_MODE{
        public final String MPP        = "MPP";
    }

    public interface PCR_ESV_REGISTER{
        public final String PACKAGE_NAME                        = "VASAPPS.PCR_ESV_REGISTER";

        public final String PRR_ESV_INS_CONTRACT_PARTY          = PACKAGE_NAME+".PRR_ESV_INS_CONTRACT_PARTY";
        public final String PRR_ESV_UPD_CONTRACT_PARTY          = PACKAGE_NAME+".PRR_ESV_UPD_CONTRACT_PARTY";
        public final String PRR_ESV_GET_CONTRACT_PARTY          = PACKAGE_NAME+".PRR_ESV_GET_CONTRACT_PARTY";
        public final String PRR_ESV_DEL_CONTRACT_PARTY          = PACKAGE_NAME+".PRR_ESV_DEL_CONTRACT_PARTY";
        public final String PRR_ESV_GET_MANAGE_PORT_PAIR        = PACKAGE_NAME+".PRR_ESV_GET_MANAGE_PORT_PAIR";

        //##01 Begin
        public final String PRR_ESV_INS_CONTRACT_PARTY_HDR      = PACKAGE_NAME + ".PRR_ESV_INS_CONTRACT_PARTY_HDR";
        public final String PRR_ESV_GET_RANDOM_PWD              = PACKAGE_NAME + ".PRR_ESV_GET_RANDOM_PWD";
        public final String PRR_ESV_DEL_PP_HDR                  = PACKAGE_NAME + ".PRR_ESV_DEL_PP_HDR";
        public final String PRR_ESV_FIND_PP_DTL                 = PACKAGE_NAME + ".PRR_ESV_FIND_PP_DTL";
        public final String PRR_ESV_INS_CONTRACT_PARTY_DTL      = PACKAGE_NAME + ".PRR_ESV_INS_CONTRACT_PARTY_DTL";
        public final String PRR_ESV_UPD_CONTRACT_PARTY_DTL      = PACKAGE_NAME + ".PRR_ESV_UPD_CONTRACT_PARTY_DTL";
        public final String PRR_ESV_DEL_PP_DTL                  = PACKAGE_NAME + ".PRR_ESV_DEL_PP_DTL";
        public final String PRR_FIND_USER_DETAIL                = PACKAGE_NAME + ".PRR_FIND_USER_DETAIL";
        //##01 End
    }

    public interface P_I_V{
        public final String USR_ID                          = "P_I_V_USR_ID";
        public final String FSC                             = "P_I_V_FSC";
        public final String PK_PORT_PAIR_SEQ                = "P_I_V_PK_PORT_PAIR_SEQ";
        public final String FK_USER_ID                      = "P_I_V_FK_USER_ID";
        public final String CONTRACT_PARTY_CODE             = "P_I_V_CONTRACT_PARTY_CODE";
        public final String CONTRACT_PARTY_NAME             = "P_I_V_CONTRACT_PARTY_NAME";
        public final String POL                             = "P_I_V_POL";
        public final String POD                             = "P_I_V_POD";
        public final String EFF_DATE                        = "P_I_V_EFF_DATE";
        public final String EXP_DATE                        = "P_I_V_EXP_DATE";
        public final String TYPE                            = "P_I_V_TYPE";
        public final String STATUS                          = "P_I_V_STATUS";
        public final String COL_NAME                        = "P_I_V_COL_NAME";
        public final String COL_VAL                         = "P_I_V_COL_VAL";
        public final String SORT_BY                         = "P_I_V_SORT_BY";
        public final String ORDER_BY                        = "P_I_V_ORDER_BY";
        public final String WILD_CARD                       = "P_I_V_WILD_CARD";
        public final String FLAG                            = "P_I_V_FLAG";

        //##01 Begin
        public final String PWD                             = "P_I_V_PWD";
        public final String REACT_PWD                       = "P_I_V_REACT_PWD";
        public final String LENGTH                          = "P_I_V_LEGNTH";
        public final String PK_ESV_PP_HDR_SEQ               = "P_I_V_PK_ESV_PP_HDR_SEQ";
        public final String FK_ESV_PP_HDR_SEQ               = "P_I_V_FK_ESV_PP_HDR_SEQ";
        public final String PK_ESV_PP_DTL_SEQ               = "P_I_V_PK_ESV_PP_DTL_SEQ";
        public final String EXCLUDE_EXP                     = "P_I_V_EXCLUDE_EXP";
        //##01 End
    }

    public interface P_O_V{
        public final String ERROR                           = "P_O_V_ERROR";
        public final String CONTRACT_PARTY_DATA             = "P_O_V_CONTRACT_PARTY_DATA";
        public final String PWD                             = "P_O_V_PWD";
        public final String PORT_PAIR_DATA                  = "P_O_V_PORT_PAIR_DATA";
        public final String PK_ESV_PP_HDR_SEQ               = "P_O_V_PK_ESV_PP_HDR_SEQ";
    }

    public String addContractPartyPortPair(EserviceContractPartyPortPairMod mod);
    public String updContractPartyPortPair(EserviceContractPartyPortPairMod mod);
    public String delContractPartyPortPair(EserviceContractPartyPortPairMod mod);
    public List<EserviceContractPartyPortPairMod> getList(EserviceManagePortPairUim uim, String chkBoxExcludeExpiredPortPair);
    //##01 Begin
    public String genUniqPwd(int length);
    public String suspendContractParty(String pkEsvPpHdrSeq, String userId);
    public List<EserviceContractPartyPortPairMod> findPortPair(String pkEsvPpHdrSeq, String chkBoxExcludeExpiredPortPair);
    public String updPortPair(EserviceContractPartyPortPairMod mod);
    public String addPortPair(EserviceContractPartyPortPairMod mod);
    public String suspendPortPair(String pkEsvPpDtlSeq, String userId);
    public EserviceContractPartyPortPairMod findUserDetail(String fkUserId);
    //##01 End
}
