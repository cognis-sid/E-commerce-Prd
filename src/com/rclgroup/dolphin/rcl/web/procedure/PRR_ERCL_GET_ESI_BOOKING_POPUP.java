package com.rclgroup.dolphin.rcl.web.procedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingBookingListMod;

public class PRR_ERCL_GET_ESI_BOOKING_POPUP {

	private JdbcTemplate jdbcTemplate;
	private Map map;

	public PRR_ERCL_GET_ESI_BOOKING_POPUP(JdbcTemplate jdbcTemplate, Map map) {
		this.jdbcTemplate = jdbcTemplate;
		this.map = map;
	}

	public void executeDbProcedure() {
		
		
		
		//P_O_V_DTL_DATA
		//P_O_V_TOTAL_ROW
	}
    public class EsiBookingPopupRowMapper extends JdbcRowMapper{

        /**
         * 
         * This mothod for set data to booking data in each row.
         * 
         * @exception SQLException
         * @param rs List of booking data
         * @param row Row of booking data
         */
        public Object mapRow(ResultSet rs, int row) throws SQLException{
            EshippingBookingListMod obj = new EshippingBookingListMod();
            obj.setBookingDate(rs.getString(1));
            obj.setBookingNo(rs.getString(2));
            //@04 BEGIN
            obj.setShipperName(rs.getString(3));
            //@04 END
            obj.setLegVessel(rs.getString(4));
            obj.setLegVoyage(rs.getString(5));
            obj.setPol(rs.getString(6));
            obj.setPod(rs.getString(7));
            obj.setEsiStatusDesc(rs.getString(8));
            obj.setBlNo(rs.getString(9));
            obj.setCocSoc(rs.getString(10));
            obj.setEsiStatusCode(rs.getString(11));
            obj.setPolNo(rs.getString(12));
            obj.setPodNo(rs.getString(13));
            return obj;
        }
    }
}
