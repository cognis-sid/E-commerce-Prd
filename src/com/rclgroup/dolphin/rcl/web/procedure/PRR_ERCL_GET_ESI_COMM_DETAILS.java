package com.rclgroup.dolphin.rcl.web.procedure;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod;

public class PRR_ERCL_GET_ESI_COMM_DETAILS {
	JdbcTemplate jdbcTemplate;
	Map map;

public PRR_ERCL_GET_ESI_COMM_DETAILS(JdbcTemplate jdbcTemplate,Map map) {
	this.jdbcTemplate=jdbcTemplate;
	this.map=map;
}

public Map executeDbProcedure() {
	
	String V_SQL;
	String MODE_COUNT="Select Count(*) from ESV_SI_HEADER where FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'"; 
	
	int count=jdbcTemplate.queryForInt(MODE_COUNT);
	
	if(count>0) {
		
		String MODE_V_SQL="SELECT CASE ESI_STATUS WHEN 'I' THEN '2' ELSE '3' END ESI_STATUS   " + 
				"                         FROM  ESV_SI_HEADER   " + 
				"                         WHERE FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'";
		String mode=(String) jdbcTemplate.queryForObject(MODE_V_SQL, String.class);
		map.put("P_I_V_MODE", mode);	
	}
	
	if(count==0) {
	 V_SQL="SELECT c.Description as Commodity_Group   " + 
			"				   		   , FCDESC COMMODITY_DESC   " + 
			"				   		   , BWCMCD COMMODITY_CODE   " + 
			"						   , '' as Comm_Grp_Seqno   " + 
			"						   , a.Commodity_Group_Code as Comm_Grp_Code   " + 
			"               ,a.BWMTWT as Weight   " + 
			"               ,'' AS TOT_PACKAGE_KIND    " + 
			"               ,'' AS TOT_PACKAGE_KIND_CODE   " + 
			"               , 0 AS TOT_NO_OF_PACKAGE    " + 
			"               , 0 AS TOT_MEASUREMENT    " + 
			"               ,''  BL_NO    " + 
			"               ,BWCMCD || ' - ' || FCDESC AS COMMODITY   " + 
			"						   , '' as MARKS_NOS    " + 
			"						   , '' as DESCRIPTION    " + 
			"						   , '' as CNTR_NO    " + 
			"               , SPECIAL_HANDLING AS RATE_TYPE   " + 
			"					FROM BKP050 a, ITP080 b, Commodity_Group c   " + 
			"					WHERE BWBKNO = '"+map.get("P_I_V_BKG_NO")+"'   " + 
			"					  	  AND BWCMCD = FCCODE   " + 
			"					  	  AND a.Commodity_Group_Code = c.Commodity_Group_Code ";
	}else {
		V_SQL="SELECT DISTINCT CG.Description as Commodity_Group   " + 
				"						   , FCDESC COMMODITY_DESC   " + 
				"						   , DN_COMMODITY_CODE COMMODITY_CODE   " + 
				"						   , PK_SEQNO as Comm_Grp_Seqno   " + 
				"						   , CM.Commodity_Group_Code as Comm_Grp_Code   " + 
				"               , COM.Weight as Weight   " + 
				"               ,(Select PKDESC from ITP170 where PKCODE = COM.TOT_PACKAGE_KIND) as TOT_PACKAGE_KIND     " + 
				"               , COM.TOT_PACKAGE_KIND AS TOT_PACKAGE_KIND_CODE    " + 
				"               , COM.TOT_NO_OF_PACKAGE AS TOT_NO_OF_PACKAGE    " + 
				"               , COM.TOT_MEASUREMENT AS TOT_MEASUREMENT    " + 
				"               ,CASE WHEN ('"+map.get("P_I_V_MODE")+"'='2') THEN '' ELSE FK_BL_NO END BL_NO    " + 
				"               ,DN_COMMODITY_CODE || ' - ' || FCDESC AS COMMODITY    " + 
				"						   , COALESCE (cast(LTRIM(COM.COMM_LVL_MARKS_NO) as VARCHAR), ' ') AS MARKS_NOS    " + 
				"						   , COALESCE (cast(LTRIM(COM.COMM_LVL_DESC) as VARCHAR), ' ') AS DESCRIPTION    " + 
				"						   , 'XXXXXXXXX01' as CNTR_NO    " + 
				"               , RATE_TYPE   " + 
				"					FROM  ESV_SI_HEADER HDR, ESV_SI_COMMODITY COM, ITP080 CM, Commodity_Group CG   " + 
				"					WHERE Hdr.FK_BOOKING_NO =  '"+map.get("P_I_V_BKG_NO")+"'  " + 
				"						  AND Hdr.PK_HDR_SEQNO = Com.FK_HDR_SEQNO   " + 
				"						  AND CM.Commodity_Group_Code = CG.Commodity_Group_Code   " + 
				"						  AND COM.DN_COMMODITY_CODE = CM.FCCODE";
	}
	List<EshippingCommodityDetailsMod> list=jdbcTemplate.query(V_SQL, new Object[] {}, new CommodityDetailsRowMapper());
	
	  Map outMap=new HashMap();
	  outMap.put("P_O_V_DTL_DATA", list);
	  return outMap;
}
public class CommodityDetailsRowMapper extends JdbcRowMapper{
    //@10 BEGIN
    DecimalFormat dfOfPackage   = new DecimalFormat("###,###,##0");
    DecimalFormat dfWeight      = new DecimalFormat("###,###,##0.000");
    DecimalFormat dfMeasurement = new DecimalFormat("###,###,##0.0000");
    //@10 END
    
    /*Begin @16*/
    int           comSeqNo      = 0;
    /*End @16*/

    public Object mapRow(ResultSet rs, int row) throws SQLException{
        //@07 BEGIN
        EshippingCommodityDetailsMod    obj             = null;
        String                          seqNo           = null;
        //@10 BEGIN
        BigDecimal                      weight          = null;
        String                          weightStr       = null;
        //@10 END
        //@14 BEGIN
        BigDecimal                      measurement     = null;
        //@14 END
        BigDecimal                      ofPackage       = null;
        
        try{
            obj = new EshippingCommodityDetailsMod();
            obj.setStrCommGroup(rs.getString("COMMODITY_GROUP"));
            obj.setStrCommDesc(rs.getString("COMMODITY_DESC"));
            obj.setStrCommCode(rs.getString("COMMODITY_CODE"));
            
            /*Begin @16*/
            obj.setComSeqNo(String.valueOf(comSeqNo));
            comSeqNo++;
            /*End @16*/

            seqNo = rs.getString("COMM_GRP_SEQNO");
            if(seqNo!=null){
                try{
                    obj.setIntCommGroupSeqNo(Integer.valueOf(seqNo));
                } catch(NumberFormatException nex){
                    obj.setIntCommGroupSeqNo(null);
                }
            } else {
                obj.setIntCommGroupSeqNo(null);
            }
            obj.setStrCommGroupCode(rs.getString("COMM_GRP_CODE"));
            //                @10 BEGIN
            weight = rs.getBigDecimal("WEIGHT");
            if(weight==null){
                weight = new BigDecimal(0.0);
            }
            obj.setStrCommWeight(dfWeight.format(weight));
            //                @10 END
            //                @14 BEGIN
            //                measurement = rs.getDouble("");
            obj.setStrCommPackageKindCode(rs.getString("TOT_PACKAGE_KIND_CODE"));
            obj.setStrCommPackageKindName(rs.getString("TOT_PACKAGE_KIND"));

            measurement = rs.getBigDecimal("TOT_MEASUREMENT");
            if(measurement==null){
                measurement = new BigDecimal(0.0);
            }
            obj.setStrCommMeasurement(dfMeasurement.format(measurement));

            ofPackage = rs.getBigDecimal("TOT_NO_OF_PACKAGE");
            if(ofPackage==null){
                ofPackage = new BigDecimal(0);
            }
            obj.setStrCommOfPackages(dfOfPackage.format(ofPackage));
            //                @14 END
            
            /*Begin @16*/
            obj.setMarksAndNumbers(rs.getString("MARKS_NOS"));
            obj.setDescription(rs.getString("DESCRIPTION"));
            obj.setContainerNoToCargo(rs.getString("CNTR_NO"));
            obj.setComBookingNo(rs.getString("BL_NO"));
            obj.setStrCommodityForMark(rs.getString("COMMODITY"));
            /*End @16*/
            
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //@07 END
        return obj;
    }
}
}
