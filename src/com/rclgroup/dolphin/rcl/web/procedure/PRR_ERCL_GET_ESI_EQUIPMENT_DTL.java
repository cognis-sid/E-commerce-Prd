package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCargoDescriptionMod;

public class PRR_ERCL_GET_ESI_EQUIPMENT_DTL {

	JdbcTemplate jdbcTemplate;
	Map map;
	EshippingInstructionUim form;

public PRR_ERCL_GET_ESI_EQUIPMENT_DTL(JdbcTemplate jdbcTemplate,Map map,EshippingInstructionUim form) {
	this.jdbcTemplate=jdbcTemplate;
	this.map=map;
	this.form=form;
}

public Map executeDbProcedure() {
	String V_SQL;
	String MODE_COUNT="Select Count(*) from ESV_SI_HEADER where FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'"; 
	
	int count=jdbcTemplate.queryForInt(MODE_COUNT);
	
		if(count==0) {
		 V_SQL="SELECT '' as CNTR_NO   " + 
				"	   	  		   		   , b.eq_size || ' - ' || (Select TRTPNM from ITP075 where TRTYPE = b.eq_type) as CNTR_TYPE   " + 
				"	   					   , '' as CARRIER_SEAL   " + 
				"	   					   , '' as SHIPPER_SEAL   " + 
				"	   					   , '0' as NO_OF_PACKAGES   " + 
				"	   					   , '' as PACKAGE_KIND   " + 
				"						   , '' as PACKAGE_KIND_CODE   " + 
				"	   					   , COALESCE(weight, 0) as GROSS_CARGO_WGT   " + 
				"	   					   , 0 as GROSS_CARGO_MMT   " + 
				"	   					   , 'LADEN' as LADEN_MT   " + 
				"						   , 0 as CNTR_SEQ   " + 
				"						   , b.EQ_SIZE as EQ_SIZE   " + 
				"						   , b.EQ_TYPE as EQ_TYPE   " + 
				"	   					   , '' as FK_BKG_EQUIPM_DTL   " + 
				"		   		 		   , b.Supplier_SQNO as FK_BKG_SUPPLIER   " + 
				"				 		   , EQP_SIZETYPE_SEQNO as FK_BKG_SIZE_TYPE_DTL   " + 
				"						   , '' COMMODITY   " + 
				"						   , '' COMMODITY_DESC   " + 
				"						   , full_qty as FULL_QTY"+
				"						   , '' as EQPT_COMMODITY "+	
				"					FROM   BOOKING_SUPPLIER_DETAIL b  inner join ESV_WB_SIZETYPE c on  " + 
				"	b.booking_no =c.pk_booking_no and " + 
				"	b.EQ_SIZE=c.EQ_SIZE and " + 
				"	b.EQ_TYPE=c.EQ_TYPE " + 
				"					WHERE BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'   " + 
				"					--ORDER BY BISEQN";
		 
		}else {
			 V_SQL="SELECT ltrim(DN_EQUIPMENT_NO) as CNTR_NO   " + 
					"						   , DN_EQ_SIZE || ' - ' || (Select TRTPNM from ITP075 where TRTYPE = DN_EQ_TYPE) as CNTR_TYPE   " + 
					"						   , ltrim(CARRIER_SEAL) as CARRIER_SEAL   " + 
					"						   , ltrim(SHIPPER_SEAL) as SHIPPER_SEAL   " + 
					"						   , NO_OF_PACKAGES as NO_OF_PACKAGES   " + 
					"						   , (Select PKDESC from ITP170 where PKCODE = DN_PACKAGE_KIND_CODE) as PACKAGE_KIND   " + 
					"						   , ltrim(DN_PACKAGE_KIND_CODE) as PACKAGE_KIND_CODE   " + 
					"						   , COALESCE(GROSS_CARGO_WEIGHT, 0) as GROSS_CARGO_WGT   " + 
					"						   , COALESCE(GROSS_CARGO_MSMT, 0) as GROSS_CARGO_MMT   " + 
					"						   , CASE LADEN_MT WHEN 'E' THEN 'EMPTY' ELSE 'LADEN' END as LADEN_MT   " + 
					"						   , PK_DTL_SEQNO as CNTR_SEQ   " + 
					"						   , DN_EQ_SIZE as EQ_SIZE   " + 
					"						   , DN_EQ_TYPE as EQ_TYPE   " + 
					"						   , 0 as FK_BKG_EQUIPM_DTL   " + 
					"		   		 		   , 0 as FK_BKG_SUPPLIER   " + 
					"				 		   , 0 as FK_BKG_SIZE_TYPE_DTL   " + 
					"						   , FK_COMMODITY_SEQNO as COMMODITY   " + 
					"						   , (SELECT FCDESC FROM ITP080, ESV_SI_COMMODITY COMM   " + 
					"						     WHERE FCCODE = COMM.DN_COMMODITY_CODE and COMM.FK_HDR_SEQNO = PK_HDR_SEQNO   " + 
					"							 and FK_COMMODITY_SEQNO = COMM.DN_COMMODITY_CODE ) as COMMODITY_DESC    " + 
					"						   ,1 as FULL_QTY"+
					"						   ,FK_COMMODITY_SEQNO  as EQPT_COMMODITY "+
					"					FROM  ESV_SI_CONTAINERS,  ESV_SI_HEADER   " + 
					"					WHERE FK_BOOKING_NO = '"+map.get("P_I_V_BKG_NO")+"'   " + 
					"						  AND PK_HDR_SEQNO = FK_HDR_SEQNO   " + 
					"					ORDER BY PK_DTL_SEQNO";
		}
		List<EshippingCargoDescriptionMod> list=jdbcTemplate.query(V_SQL, new Object[] {}, new EquipmentDetailsRowMapper(form,(String)map.get("P_I_V_ESI_STATUS")));
	  
	  Map outMap=new HashMap();
	  outMap.put("P_O_V_DTL_DATA", list);
	  return outMap;
	}
public class EquipmentDetailsRowMapper extends JdbcRowMapper{

    private EshippingInstructionUim form;
    private int seqNo = 1;
    private String mode;

    /**
     * 
     * This constructor for set obj to global variable.
     * 
     * @param form Object's Eshipping Instruction Form
     * @param mode Mode of ESI Status (1=New, 2=In Progress, 3=Submitted)
     */
    public EquipmentDetailsRowMapper(EshippingInstructionUim form, String mode){
        this.form = form;
        this.mode = mode;
    }

    /**
     * 
     * This mothod for set data to equipment detail in each row.
     * 
     * @exception SQLException
     * @param rs List of equipment detail
     * @param row Row of equipment detail
     */
    public Object mapRow(ResultSet rs, int row) throws SQLException{
        EshippingCargoDescriptionMod cargoDesc = new EshippingCargoDescriptionMod();
        cargoDesc.setContainerNo(rs.getString(1));
        cargoDesc.setContainerType(rs.getString(2));
        cargoDesc.setCarrierSeal(rs.getString(3));
        cargoDesc.setShipperSeal(rs.getString(4));
        cargoDesc.setOfPackages(rs.getString(5));
        cargoDesc.setPackagesKind(rs.getString(6));
        cargoDesc.setPackagesKindCode(rs.getString(7));
        cargoDesc.setGrossContainerWeight(rs.getString(8));
        if(rs.getString(9).equals("0"))
        	cargoDesc.setGrossCargoMeasurement("0.0000");
        else
        	cargoDesc.setGrossCargoMeasurement(rs.getString(9));	
        cargoDesc.setLadenMt(rs.getString(10));
        cargoDesc.setSeqNo(seqNo);
        cargoDesc.setDbFlag("1");
        
        String stausFlag = EshippingInstructionDao.KEY_STATUS_DELETE;
        if("1".equals(mode)){
            stausFlag = EshippingInstructionDao.KEY_STATUS_INSERT;
        } else if("2".equals(mode)){
            stausFlag = EshippingInstructionDao.KEY_STATUS_UPDATE;
        }

        cargoDesc.setStatusFlag(stausFlag);
        cargoDesc.setOriginalSeqNo(String.valueOf(seqNo));
        cargoDesc.setCntrSeq(rs.getString(11));
        cargoDesc.setContainerEqSize(rs.getString(12));
        cargoDesc.setContainerEqType(rs.getString(13));
        cargoDesc.setFkEquipmentDetail(rs.getString(14));
        cargoDesc.setFkBookingSupplier(rs.getString(15));
        cargoDesc.setFkBookingSizeTypeDetail(rs.getString(16));
        //@01 BEGIN
        cargoDesc.setCommodity(rs.getString(17));
        cargoDesc.setStrCommodityName(rs.getString(18));
        cargoDesc.setLadenCount(rs.getString(19));
        cargoDesc.setStrEqptCommodity(rs.getString("EQPT_COMMODITY")+"");
        //@01 END
        //            System.out.println("cargoDesc getCommodity >>>>>>>>>>>>>>>>>>>>>>>>>>> "+cargoDesc.getCommodity());
        seqNo++;
        return cargoDesc;
    }
}

}
