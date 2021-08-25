package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.common.EncryptDecryptUtil;
import com.rclgroup.dolphin.rcl.web.common.FormatUtil;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceContractPartyPortPairMod;

public class PRR_ESV_GET_CONTRACT_PARTY {
	
	private JdbcTemplate jdbcTemplate;
	private Map map;
	public PRR_ESV_GET_CONTRACT_PARTY(JdbcTemplate jdbcTemplate, Map map) {
		super();
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}
	
	public void executeProcedure() {
		
		String query="SELECT PP_HDR.PK_ESV_PP_HDR_SEQ   " + 
				"                            , PP_HDR.USER_ID AS FK_USER_ID   " + 
				"                            , PP_HDR.FK_CONTRACT_PARTY_CODE   " + 
				"                            , ( SELECT T.CUNAME   " + 
				"                                FROM  ITP010 T   " + 
				"                                WHERE  T.CUCUST  = PP_HDR.FK_CONTRACT_PARTY_CODE   " + 
				"                              ) AS CONTRACT_PARTY_NAME   " + 
				"                            , PP_HDR.PWD AS PWD   " + 
				"                            , PP_HDR.REACT_PWD AS REACT_PWD   " + 
				"                            , PP_HDR.RECORD_STATUS   " + 
				"                            , PP_HDR.RECORD_ADD_DATE   " + 
				"                            , PP_HDR.RECORD_ADD_USER   " + 
				"                            , PP_HDR.RECORD_CHANGE_DATE   " + 
				"                            , PP_HDR.RECORD_CHANGE_USER   " + 
				"                            , CASE   " + 
				"                                  ( SELECT   " + 
				"                                    CASE   " + 
				"                                      WHEN COUNT(*) > 0 THEN 'ACTIVE'    " + 
				"                                      ELSE 'EXPIRED'   " + 
				"                                    END   " + 
				"                                    AS CONTRACT_PART_STATUS   " + 
				"                                  FROM VASAPPS.ESV_CONTRACT_PARTY_PP_DTL PP_DTL   " + 
				"                                  WHERE (   " + 
				"                                          now() BETWEEN PP_DTL.EFF_DATE AND PP_DTL.EXP_DATE   " + 
				"                                          OR now() < PP_DTL.EFF_DATE   " + 
				"                                          OR now() = PP_DTL.EFF_DATE   " + 
				"                                          OR now() = PP_DTL.EXP_DATE   " + 
				"                                        )   " + 
				"                                    AND PP_DTL.FK_ESV_PP_HDR_SEQ = PP_HDR.PK_ESV_PP_HDR_SEQ   " + 
				"                                    AND PP_DTL.RECORD_STATUS = 'A'   " + 
				"                                 )   " + 
				"                                 WHEN 'ACTIVE' THEN 'ACTIVE'   " + 
				"                                 WHEN 'EXPIRED' THEN   " + 
				"                                    (   " + 
				"                                      CASE   " + 
				"                                        when  (   " + 
				"                                                SELECT count(*)   " + 
				"                                                FROM vasapps.esv_contract_party_pp_dtl   " + 
				"                                                WHERE fk_esv_pp_hdr_seq = PP_HDR.pk_esv_pp_hdr_seq   " + 
				"                                                  AND record_status = 'A'   " + 
				"                                              ) = 0 THEN 'ACTIVE'   " + 
				"                                        ELSE 'EXPIRED'   " + 
				"                                      END   " + 
				"                                    )   " + 
				"                              END AS CONTRACT_PARTY_STATUS   " + 
				"                            , (   " + 
				"                                SELECT   " + 
				"                                  count(*)   " + 
				"                                FROM   " + 
				"                                  VASAPPS.ESV_CONTRACT_PARTY_PP_DTL PP_DTL   " + 
				"                                WHERE   " + 
				"                                  PP_DTL.FK_ESV_PP_HDR_SEQ = PP_HDR.PK_ESV_PP_HDR_SEQ   " + 
				"                                  AND PP_DTL.RECORD_STATUS =  'A'    " + 
				"                              ) AS PORT_PAIRS   " + 
				"                    FROM   " + 
				"                      VASAPPS.ESV_CONTRACT_PARTY_PP_HDR PP_HDR   " + 
				"                    WHERE   " + 
				"                      PP_HDR.RECORD_STATUS = 'A'   " + 
				"                      AND PP_HDR.USER_ID = '"+map.get("P_I_V_FK_USER_ID")+"'";
		
		List<EserviceContractPartyPortPairMod> list=jdbcTemplate.query(query, new RepresentedCompanyRowMapper());
		
		map.put("P_O_V_CONTRACT_PARTY_DATA", list);
		map.put("P_O_V_ERROR","");
		
	}
	
	class RepresentedCompanyRowMapper extends JdbcRowMapper{

		@Override
		public Object mapRow(ResultSet rs, int rowCount) throws SQLException {
			 
			EserviceContractPartyPortPairMod obj=new EserviceContractPartyPortPairMod();
			
			// obj.setPkPortPairSeq                (FormatUtil.nullToBlank(rs.getString("PK_PORT_PAIR_SEQ")));
            obj.setFkUserId                     (FormatUtil.nullToBlank(rs.getString("FK_USER_ID")));
            obj.setFkContractPartyCode          (FormatUtil.nullToBlank(rs.getString("FK_CONTRACT_PARTY_CODE")));
            obj.setContractPartyName            (FormatUtil.nullToBlank(rs.getString("CONTRACT_PARTY_NAME")));
            obj.setContractPartyNameDisabled    (FormatUtil.nullToBlank(rs.getString("CONTRACT_PARTY_NAME")));
            // obj.setFkPOL                        (FormatUtil.nullToBlank(rs.getString("FK_POL")));
            // obj.setFkPOD                        (FormatUtil.nullToBlank(rs.getString("FK_POD")));
            // obj.setEffDate                      (FormatUtil.dateFormat(rs.getString("EFFECTIVE_DATE"), "yyyyMMdd", "dd/MM/yyyy"));
            // obj.setExpDate                      (FormatUtil.dateFormat(rs.getString("EXPIRY_DATE"), "yyyyMMdd", "dd/MM/yyyy"));
            obj.setRecStatus                    (FormatUtil.nullToBlank(rs.getString("RECORD_STATUS")));
            obj.setRecStatusDesc                (FormatUtil.statusRecDesc(rs.getString("RECORD_STATUS")));

            //##03 Begin
            obj.setPkEsvPpHdrSeq                (FormatUtil.nullToBlank(rs.getString("PK_ESV_PP_HDR_SEQ")));
            obj.setContractPartyStatus          (FormatUtil.nullToBlank(rs.getString("CONTRACT_PARTY_STATUS")));

            try{
                obj.setPwd                      (EncryptDecryptUtil.convertHexToString(FormatUtil.nullToBlank(rs.getString("PWD"))));

            } catch (Exception e){
                e.printStackTrace();
                obj.setPwd                      (FormatUtil.nullToBlank(rs.getString("PWD")));
            }
            try{
                obj.setReactPwd                      (EncryptDecryptUtil.convertHexToString(FormatUtil.nullToBlank(rs.getString("REACT_PWD"))));
            } catch (Exception e){
                e.printStackTrace();
                obj.setReactPwd                      (FormatUtil.nullToBlank(rs.getString("REACT_PWD")));
            }
            //##03 End

            if(!obj.getRecStatus().equals("P"))obj.setApproveFlag("Y");

            return obj;
			
		}
		
	}
	
}
