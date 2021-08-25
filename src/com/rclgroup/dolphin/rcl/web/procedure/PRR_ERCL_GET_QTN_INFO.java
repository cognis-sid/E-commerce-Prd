package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;
import com.rclgroup.dolphin.rcl.web.procedure.PCR_ESV_NEW_WEB_BOOKING_GET_QUOTATION_NUMBER.QuotationRowMappers;

public class PRR_ERCL_GET_QTN_INFO {


	JdbcTemplate jdbcTemplate;
	Map amapParam ;
	
	public PRR_ERCL_GET_QTN_INFO(JdbcTemplate jdbcTemplate,Map amapParam) {
		this.jdbcTemplate=jdbcTemplate;
		this.amapParam=amapParam;
	}
	
	public void executeDbProcedure() {
		String query="SELECT (select SCNAME as PLR from POINT_MASTER, ITP030 where POINT_CODE = QAORIG and COUNTRY_CODE = SCCODE) as QTN_ORIGIN  " + 
				"					   , (select SCNAME as PLD from POINT_MASTER, ITP030 where POINT_CODE = QADEST and COUNTRY_CODE = SCCODE) as QTN_DESTINATION  " + 
				"					   , (select PINAME from ITP040, ITP030 where PICODE = QAPOL and PICNCD = SCCODE) as QTN_POL  " + 
				"				   	   , (select PINAME from ITP040, ITP030 where PICODE = QAPOD and PICNCD = SCCODE) as QTN_POD  " + 
				"					   , SUBSTR(QAMODE,1,2) QTN_POL_TERM  " + 
				"				   	   , SUBSTR(QAMODE,3,4) QTN_POD_TERM  " + 
				"					   , QAMODE as QTN_TERM  " + 
				"					   , QASHTP as QTN_SHIPMENT_TYPE  " + 
				"					   , SOC_COC_FLAG  " + 
				"					   , SUBSTR(QAORIG,1,2) as ORIGIN_CODE  " + 
				"					   , SUBSTR(QADEST,1,2) as DEST_CODE  " + 
				"					   , QAPOL as POL_CODE  " + 
				"					   , QAPOD as POD_CODE  " + 
				"					   , QAORIG as PLR  " + 
				"					   , QADEST as PLD  " + 
				"				FROM QTP001 a, QTP0012 b  " + 
				"				WHERE a.QAQUNO = b.QAQUNO and a.QAQUNO = '"+amapParam.get("P_I_V_QTN_NO")+"'" ;
		
		
		
		 //Map map=new HashedMap();
		  
		 List list=jdbcTemplate.query(query, new Object[] { }, new QuotationInfoRowMappers());
		  
		 Map outPut=new HashMap();
		 outPut.put("P_O_V_QTN_DATA",list);
			
		 amapParam.put(EserviceNewWebBookingDaoImpl.KEY_PROCE_EXCECTION_RESULT_MAP, outPut);
			
		 
	}
	  class QuotationInfoRowMappers extends JdbcRowMapper{

          /**
           *
           * This mothod for set data to quotation information in each row.
           *
           * @exception SQLException
           * @param rs List of quotation information
           * @param row Row of quotation information
           */
          public Object mapRow(ResultSet rs, int row) throws SQLException{

              EserviceNewWebBookingUim eserviceNewWebBookingUim = new EserviceNewWebBookingUim();
              eserviceNewWebBookingUim.setOriginCountryShow(rs.getString("QTN_ORIGIN"));
              eserviceNewWebBookingUim.setDestinationCountryShow(rs.getString("QTN_DESTINATION"));
              eserviceNewWebBookingUim.setPortOfLoadingShow(rs.getString("QTN_POL"));
              eserviceNewWebBookingUim.setPortOfDischargeShow(rs.getString("QTN_POD"));
              eserviceNewWebBookingUim.setPol(rs.getString("QTN_POL_TERM"));
              eserviceNewWebBookingUim.setPod(rs.getString("QTN_POD_TERM"));
              eserviceNewWebBookingUim.setShipmentType(rs.getString("QTN_SHIPMENT_TYPE"));
              eserviceNewWebBookingUim.setSocCocUserFlag(rs.getString("SOC_COC_FLAG"));
              eserviceNewWebBookingUim.setOriginCountry(rs.getString("ORIGIN_CODE"));
              eserviceNewWebBookingUim.setDestinationCountry(rs.getString("DEST_CODE"));
              eserviceNewWebBookingUim.setPortOfLoading(rs.getString("POL_CODE"));
              eserviceNewWebBookingUim.setPortOfDischarge(rs.getString("POD_CODE"));

              // teerakan add  @02   19/07/2013 for set Default to Place of Receipt  and Place of Delivery
              eserviceNewWebBookingUim.setPlaceOfReceipt(rs.getString("PLR"));
              eserviceNewWebBookingUim.setPlaceOfDelivery(rs.getString("PLD"));

              // teerakan add


              if(StringUtils.isNotBlank(eserviceNewWebBookingUim.getPol())&&StringUtils.isNotEmpty(eserviceNewWebBookingUim.getPol())){
                  String pol = EserviceNewWebBookingDaoImpl.convertToTermValue(eserviceNewWebBookingUim.getPol());
                  eserviceNewWebBookingUim.setPolShow(pol);
              }

              if(StringUtils.isNotBlank(eserviceNewWebBookingUim.getPod())&&StringUtils.isNotEmpty(eserviceNewWebBookingUim.getPod())){
                  String pod = EserviceNewWebBookingDaoImpl.convertToTermValue(eserviceNewWebBookingUim.getPod());
                  eserviceNewWebBookingUim.setPodShow(pod);
              }

              return eserviceNewWebBookingUim;
          }
      }
}
