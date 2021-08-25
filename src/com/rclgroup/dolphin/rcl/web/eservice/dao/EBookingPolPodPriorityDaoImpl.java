/*------------------------------------------------------
 EBookingPolPodPriorityDaoImpl.java
--------------------------------------------------------
Copyright RCL Public Co., Ltd. 2013
--------------------------------------------------------
Author -Joga*/
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.common.Utilis;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EservicePolPodPriorityUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.ContryMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EservicePolPodPriorityMod;

public class EBookingPolPodPriorityDaoImpl extends AncestorJdbcDao implements EBookingPolPodPriorityDao {

	public String insertPolPodPriority(EservicePolPodPriorityUim form) {
		Utilis utilis = new Utilis();

		String pol = "";
		String pod = "";
		String pot = "";
		String service = "";
		String vessel = "";
		String voyage = "";
		String bsa = "";
		String ts = "N";
		Date effdate = null;
		Date expdate = null;

		if (form.getPol() != null && !form.getPol().equals(""))
			pol = form.getPol();

		if (form.getPod() != null && !form.getPod().equals(""))
			pod = form.getPod();

		if (form.getPot1() != null && !form.getPot1().equals("")) {
			pot = form.getPot1();
			form.setTs("Y");
		}

		if (form.getService() != null && !form.getService().equals(""))
			service = form.getService();

		if (form.getVessel() != null && !form.getVessel().equals(""))
			vessel = form.getVessel();

		if (form.getVoyage() != null && !form.getVoyage().equals(""))
			voyage = form.getVoyage();

//		if (form.getBsa() != null && form.getBsa() != "")
//			bsa = form.getBsa();
//
		if (form.getTs() != null && form.getTs() != "")
			ts = form.getTs();

		if (form.getEffDate() != null && form.getEffDate() != "")
			effdate = utilis.getDateYYYYMMDDPOLPOD(form.getEffDate());

		if (form.getExpDate() != null && form.getExpDate() != "")
			expdate = utilis.getDateYYYYMMDDPOLPOD(form.getExpDate());

		try {
			boolean insert = false;

			String sqlQuery = "SELECT expireddate FROM RCLTBLS.pol_pod_priority WHERE pol = '" + pol + "' and  pod='"
					+ pod + "' and  service='" + service + "' ";
			List<Date> ppm = getJdbcTemplate().queryForList(sqlQuery, Date.class);
			Iterator itr = ppm.iterator();
			while (itr.hasNext()) {
				Date edate = (Date) itr.next();
				if (effdate.before(edate)) {
					insert = true;
				}
			}
			System.out.println("sqlQuery   " + sqlQuery);

			if (insert)
				return "Y";
			else {
				String sqlQry = "INSERT INTO pol_pod_priority(POL, " + "POD, " + "POT1, " + "SERVICE, " + "VESSEL, "
						+ "VOYAGE, " + "BSA, " + "TS, " + "EFFECTIVEDATE, " + "EXPIREDDATE) " + "VALUES ('" + pol + "',"
						+ " '" + pod + "', " + " '" + pot + "', " + " '" + service + "', " + " '" + vessel + "', "
						+ " '" + voyage + "', " + " '" + bsa + "', " + " '" + ts + "', " + " '" + effdate + "' , '"
						+ expdate + "' )  ";

				getJdbcTemplate().update(sqlQry);
				return "N";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Map getAllPolPodPriority() {
		EservicePolPodPriorityMod ppm = null;
		StringBuffer sqlQueryForTemplate = new StringBuffer("");
		Map amap = new HashMap();
		List<EservicePolPodPriorityMod> list = new ArrayList<EservicePolPodPriorityMod>();
		
		sqlQueryForTemplate.append(" select");
		sqlQueryForTemplate.append(" pol as pol");
		sqlQueryForTemplate.append(" ,pod as pod");
		sqlQueryForTemplate.append(" ,pot1 AS pot1");
		sqlQueryForTemplate.append(" ,service AS service");
		sqlQueryForTemplate.append(" ,vessel AS vessel");
		sqlQueryForTemplate.append(" ,voyage AS voyage");
		sqlQueryForTemplate.append(" ,bsa AS bsa");
		sqlQueryForTemplate.append(" ,ts AS ts");
		sqlQueryForTemplate.append(" ,TO_CHAR(effectivedate,'DD/MM/YYYY') AS effectivedate");
		sqlQueryForTemplate.append(" ,TO_CHAR(expireddate,'DD/MM/YYYY') AS expireddate");
		sqlQueryForTemplate.append(" from rcltbls.pol_pod_priority");

		
//		sqlQueryForTemplate.append(
//				"SELECT pol, pod, pot1,service,vessel,voyage,bsa,ts,effectivedate,expireddate from rcltbls.pol_pod_priority ");
		SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sqlQueryForTemplate.toString(), new HashMap());

		while (rs.next()) {
			ppm = new EservicePolPodPriorityMod();
			ppm.setPol(isNull(rs.getString("pol")));
			ppm.setPod(isNull(rs.getString("pod")));
			ppm.setPot1(isNull(rs.getString("pot1")));
			ppm.setService(isNull(rs.getString("service")));
			ppm.setVessel(isNull(rs.getString("vessel")));
			ppm.setVoyage(isNull(rs.getString("voyage")));
			ppm.setBsa(isNull(rs.getString("bsa")));
			ppm.setTs(isNull(rs.getString("ts")));
			ppm.setEffDate(isNull(rs.getString("effectivedate")));
			ppm.setExpDate(isNull(rs.getString("expireddate")));
			list.add(ppm);
		}

		if (list.size() > 0) {
			amap.put(KEY_POL_POD_DATA, list);
			amap.put(KYE_POL_POD_ERROR_CODE, null);
		} else {
			amap.put(KEY_POL_POD_DATA, list);
			amap.put(KYE_POL_POD_ERROR_CODE, "No record..");
		}
		amap.put(KEY_SIZE, 0);

		return amap;
	}

	
	@Override
	public Map getAllPolPodPriority(EservicePolPodPriorityUim form) {
		Map amap = new HashMap();
		List<EservicePolPodPriorityMod> list = new ArrayList<EservicePolPodPriorityMod>();
		EservicePolPodPriorityMod ppm = null;

		StringBuffer sqlStatement = new StringBuffer("");

		StringBuffer sqlCondition = new StringBuffer("");
		String sql = null;
		Utilis utilis = new Utilis();

		Date effdate = null;
		Date expdate = null;
		
		if (form.getEffDate() != null && form.getEffDate() != "")
			effdate = utilis.getDateYYYYMMDDPOLPOD(form.getEffDate());

		if (form.getExpDate() != null && form.getExpDate() != "")
			expdate = utilis.getDateYYYYMMDDPOLPOD(form.getExpDate());

		
		sqlStatement.append(
				"SELECT pol, pod, pot1,service,vessel,voyage,bsa,ts,TO_CHAR(effectivedate,'DD/MM/YYYY') AS effectivedate,TO_CHAR(expireddate ,'DD/MM/YYYY') AS expireddate from rcltbls.pol_pod_priority where pol = '" + form.getPol() + "' and pod='" + form.getPod() + "' "
						+ "and service='" + form.getService() + "' and effectivedate='" + effdate + "' and expireddate= '" +expdate + "' ");
		
		sql = sqlStatement.toString();

		SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql.toString(), new HashMap());
		while (rs.next()) {
			ppm = new EservicePolPodPriorityMod();
			ppm.setPol(isNull(rs.getString("pol")));
			ppm.setPod(isNull(rs.getString("pod")));
			ppm.setPot1(isNull(rs.getString("pot1")));
			ppm.setService(isNull(rs.getString("service")));
			ppm.setVessel(isNull(rs.getString("vessel")));
			ppm.setVoyage(isNull(rs.getString("voyage")));
			ppm.setBsa(isNull(rs.getString("bsa")));
			ppm.setTs(isNull(rs.getString("ts")));
			ppm.setEffDate(isNull(rs.getString("effectivedate")));
			ppm.setExpDate(isNull(rs.getString("expireddate")));
			list.add(ppm);
		}

		if (list.size() > 0) {
			amap.put(KEY_POL_POD_DATA, list);
			amap.put(KYE_POL_POD_ERROR_CODE, null);
		} else {
			amap.put(KEY_POL_POD_DATA, list);
			amap.put(KYE_POL_POD_ERROR_CODE, "No record..");
		}
		amap.put(KEY_SIZE, 0);

		return amap;
	}
	
	@Override
	public void deletePolPod(EservicePolPodPriorityUim formObj) {
		Date effdate = null;
		Date expdate = null;
		Utilis utilis = new Utilis();
		if (formObj.getEffDate() != null && formObj.getEffDate() != "")
			effdate = utilis.getDateYYYYMMDDPOLPOD(formObj.getEffDate());

		if (formObj.getExpDate() != null && formObj.getExpDate() != "")
			expdate = utilis.getDateYYYYMMDDPOLPOD(formObj.getExpDate());

		
		String sqlDelete = "delete from  rcltbls.pol_pod_priority where pol='" + formObj.getPol() + "' AND pod='"
				+ formObj.getPod() + "' AND service='" + formObj.getService() + "' and effectivedate='"
				+ effdate + "' and expireddate= '" + expdate + "' "; 
		getJdbcTemplate().update(sqlDelete);

	}

	@Override
	public String updatePolPodPriority(EservicePolPodPriorityUim formObj) {

		StringBuffer sqlStatement = new StringBuffer("");
		StringBuffer sqlCondition = new StringBuffer("");
		String sql = null;
		Utilis utilis = new Utilis();
		Date effdate = null;
		Date expdate = null;

		if (formObj.getPot1() != null && !formObj.getPot1().equals("")) {
			formObj.setTs("Y");
		}else
			formObj.setTs("N");
		
		if (formObj.getEffDate() != null && formObj.getEffDate() != "")
			effdate = utilis.getDateYYYYMMDDPOLPOD(formObj.getEffDate());

		if (formObj.getExpDate() != null && formObj.getExpDate() != "")
			expdate = utilis.getDateYYYYMMDDPOLPOD(formObj.getExpDate());

		try {
			sqlCondition.append("       pol = '" + formObj.getPol() + "' ");
			sqlCondition.append(" 		and pod='" + formObj.getPod() + "' ");
			sqlCondition.append("       and service='" + formObj.getService() + "' ");
			sqlCondition.append("       and effectivedate='" + effdate + "' ");
			sqlCondition.append("       and expireddate='" + expdate + "' ");

			sqlStatement.append("update ");
			sqlStatement.append("pol_pod_priority set");
			sqlStatement.append(" pot1 = '" + formObj.getPot1() + "' ");
			sqlStatement.append(" ,vessel = '" + formObj.getVessel() + "'");
			sqlStatement.append(" ,voyage ='" + formObj.getVoyage() + "' ");
			sqlStatement.append(" where " + sqlCondition);
			sql = sqlStatement.toString();

			int i = getJdbcTemplate().update(sql, new Object[] {});
			System.out.println("updateSql   " + i);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	};

	public EservicePolPodPriorityUim getPodPolPriority(EservicePolPodPriorityUim form) {

		Utilis utilis = new Utilis();
		StringBuffer sqlStatement = new StringBuffer("");

		StringBuffer sqlCondition = new StringBuffer("");
		String sql = null;
		
		Date effdate = null;
		Date expdate = null;
		
		if (form.getEffDate() != null && form.getEffDate() != "")
			effdate = utilis.getDateYYYYMMDDPOLPOD(form.getEffDate());

		if (form.getExpDate() != null && form.getExpDate() != "")
			expdate = utilis.getDateYYYYMMDDPOLPOD(form.getExpDate());


		sqlCondition.append("pol = '" + form.getPol() + "' and pod='" + form.getPod() + "' and service='"
				+ form.getService() + "' and effectivedate='" + effdate + "' and expireddate= '"
				+ expdate + "' ");

		sqlStatement.append(" select");
		sqlStatement.append(" pol as pol");
		sqlStatement.append(" ,pod as pod");
		sqlStatement.append(" ,pot1 AS pot1");
		sqlStatement.append(" ,service AS service");
		sqlStatement.append(" ,vessel AS vessel");
		sqlStatement.append(" ,voyage AS voyage");
		sqlStatement.append(" ,bsa AS bsa");
		sqlStatement.append(" ,ts AS ts");
		sqlStatement.append(" ,TO_CHAR(effectivedate,'DD/MM/YYYY') AS effectivedate");
		sqlStatement.append(" ,TO_CHAR(expireddate,'DD/MM/YYYY') AS expireddate");
		sqlStatement.append(" from rcltbls.pol_pod_priority");
		sqlStatement.append(" where " + sqlCondition);
		sql = sqlStatement.toString();

		List<EservicePolPodPriorityUim> ppm = getJdbcTemplate().query(sql, new Object[] {}, new PolPodMapper());
		System.out.println("sqlQuery   " + sql);
		if (ppm.size() > 0) {
			return ppm.get(0);
		} else
			return null;
	};

	public Map getSearchData(String pol, String pod, String service) {

		StringBuffer sqlStatement = new StringBuffer("");
		StringBuffer sqlCondition = new StringBuffer("");
		String sql = null;
		List<EservicePolPodPriorityMod> epmlist = null;
		EservicePolPodPriorityMod epm = null;
		Map searchMapData = new HashMap();

		try {
			if(pol!=null && pod.equals(""))
				sqlCondition.append("pol = '" + pol + "'  ");
			else if(pod!=null && pol.equals(""))
				sqlCondition.append("pod = '" + pod + "'  ");
			else
				sqlCondition.append("pol = '" + pol + "' AND pod='" + pod + "' ");

			sqlStatement.append(" select");
			sqlStatement.append(" pol as pol");
			sqlStatement.append(" ,pod as pod");
			sqlStatement.append(" ,pot1 AS pot1");
			sqlStatement.append(" ,service AS service");
			sqlStatement.append(" ,vessel AS vessel");
			sqlStatement.append(" ,voyage AS voyage");
			sqlStatement.append(" ,bsa AS bsa");
			sqlStatement.append(" ,ts AS ts");
			sqlStatement.append(" ,TO_CHAR(effectivedate,'DD/MM/YYYY') AS effectivedate");
			sqlStatement.append(" ,TO_CHAR(expireddate,'DD/MM/YYYY') AS expireddate");
			sqlStatement.append(" from rcltbls.pol_pod_priority");
			sqlStatement.append(" where " + sqlCondition);
			sql = sqlStatement.toString();

			SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sql, new HashMap());

			epmlist = new ArrayList<EservicePolPodPriorityMod>();

			while (rs.next()) {
				epm = new EservicePolPodPriorityMod();

				epm.setPol(isNull(rs.getString("pol")));
				epm.setPod(isNull(rs.getString("pod")));
				epm.setPot1(isNull(rs.getString("pot1")));
				epm.setService(isNull(rs.getString("service")));
				epm.setVessel(isNull(rs.getString("vessel")));
				epm.setVoyage(isNull(rs.getString("voyage")));
				epm.setBsa(isNull(rs.getString("bsa")));
				epm.setTs(isNull(rs.getString("ts")));
				epm.setEffDate(isNull(rs.getString("effectivedate")));
				epm.setExpDate(isNull(rs.getString("expireddate")));
				epmlist.add(epm);
			}

			if (epmlist.size() > 0) {
				searchMapData.put(KEY_POL_POD_DATA, epmlist);
				searchMapData.put(KYE_POL_POD_ERROR_CODE, null);
			} else {
				searchMapData.put(KEY_POL_POD_DATA, epmlist);
				searchMapData.put(KYE_POL_POD_ERROR_CODE, "No record..");
			}
			searchMapData.put(KEY_SIZE, 0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("[EBookingPolPodPriorityDaoImpl] Search Result[End]");
		}

		return searchMapData;
	}

	public class PolPodMapper extends JdbcRowMapper {

		public EservicePolPodPriorityUim mapRow(ResultSet rs, int row) throws SQLException {
			EservicePolPodPriorityUim pps = new EservicePolPodPriorityUim();
			try {
				pps.setPol(isNull(rs.getString("pol")));
				pps.setPod(isNull(rs.getString("pod")));
				pps.setPot1(isNull(rs.getString("pot1")));
				pps.setService(isNull(rs.getString("service")));
				pps.setVessel(isNull(rs.getString("vessel")));
				pps.setVoyage(isNull(rs.getString("voyage")));
				pps.setBsa(isNull(rs.getString("bsa")));
				pps.setTs(isNull(rs.getString("ts")));
				pps.setEffDate(isNull(rs.getString("effectivedate")));
				pps.setExpDate(isNull(rs.getString("expireddate")));

			} catch (Exception e) {
				e.printStackTrace();
			}
			return pps;
		}
	}

	/**
	 * Checks if is null.
	 * 
	 * @param str the s id
	 * @return the string
	 */
	private static String isNull(String str) {
		return (str == null) ? "" : str;
	}
	
	@Override
	public List<ContryMod> getCountryCodeNameList() {
		
		String POL_POD_QUERY="select name AS COUNTRY_NAME,code AS COUNTRY_CODE from country_code order by  COUNTRY_NAME";
		
		List<ContryMod> lit= getJdbcTemplate().query(POL_POD_QUERY, new CountruCombod());
		
		return lit;
	}
	
	
//	public List<ContryMod> getCountryCodeNameList(String pol,String pod) {
//		
//		String POL_POD_QUERY="select name AS COUNTRY_NAME,code AS COUNTRY_CODE from country_code where code='"+pol+"' or code='"+pod+"' order by  COUNTRY_NAME";
//		
//		List<ContryMod> lit= getJdbcTemplate().query(POL_POD_QUERY, new CountruCombod());
//		
//		return lit;
//	}
	
	class CountruCombod implements RowMapper{

		@Override
		public Object mapRow(ResultSet rs, int arg) throws SQLException {
			
			//ContryMod model =new ContryMod();
			
			ContryMod obj = new ContryMod();
			obj.setContryName(rs.getString("COUNTRY_NAME"));
			obj.setCode(rs.getString("COUNTRY_CODE"));
			
			return obj;
		}
		
		
		
	}

}