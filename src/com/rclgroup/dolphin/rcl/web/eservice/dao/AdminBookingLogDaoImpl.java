package com.rclgroup.dolphin.rcl.web.eservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.AdminBookingLogUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AdminBookingFileLogMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.AdminBookingLogMod;

public class AdminBookingLogDaoImpl extends AncestorJdbcDao implements AdminBookingLogDao {

	private  String ediFileName;
	
	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm aa";
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

	public static String formatDate(Date date) {

		if (date != null) {
			return simpleDateFormat.format(date);
		}
		return "";

	}
	
	

	public void setEdiFileName(String ediFileName) {
		this.ediFileName = ediFileName;
	}



	@Override
	public List<AdminBookingLogMod> getBookingLog(AdminBookingLogUim uim) {

		String sqlQuery = " select  record_updated_date, fk_booking_no,fk_booking_ref_no,fk_bl_no,booking_submit_date, booking_confirm_date,si_submit_date,si_confirm_date,type_error,message,record_add_user,"
				+ " record_add_date,ID_LOG from bkg_log_dtl where 1=1 ";
		String where = "";
		if (!uim.getBookingNo().equalsIgnoreCase("")) {
			where += " AND fk_booking_no='" + uim.getBookingNo() + "' ";
		}

		if (!uim.getbLNo().equalsIgnoreCase("")) {
			where += " AND fk_bl_no='" + uim.getbLNo() + "' ";
		}

		if (!uim.getBookingRef().equalsIgnoreCase("")) {
			where += " AND fk_booking_ref_no='" + uim.getBookingRef() + "' ";
		}

		if (!uim.getSubmitDate().equals("") && uim.getConfirmDate().equals("")) {
			where += " AND ( TO_DATE(to_char(booking_submit_date,'DD/MM/YYYY'),'DD/MM/YYYY')>= TO_DATE('" + uim.getSubmitDate()
					+ "','DD/MM/YYYY') OR  TO_DATE(to_char(si_submit_date,'DD/MM/YYYY'),'DD/MM/YYYY') >=  TO_DATE('" + uim.getSubmitDate() + "','DD/MM/YYYY') ) ";
		} else if (uim.getSubmitDate().equals("") && !uim.getConfirmDate().equals("")) {
			where += " AND ( TO_DATE(to_char(booking_confirm_date,'DD/MM/YYYY'),'DD/MM/YYYY') >= TO_DATE('" + uim.getConfirmDate()
					+ "','DD/MM/YYYY') OR  TO_DATE(to_char(si_confirm_date,'DD/MM/YYYY'),'DD/MM/YYYY') >= TO_DATE('" + uim.getConfirmDate() + "','DD/MM/YYYY') ) ";
		} else if (!uim.getSubmitDate().equals("") && !uim.getConfirmDate().equals("")) {
			where += " AND (( booking_confirm_date<= TO_DATE('" + uim.getSubmitDate()
					+ "','DD/MM/YYYY') AND booking_confirm_date>= TO_DATE('" + uim.getConfirmDate()
					+ "','DD/MM/YYYY')  ) " + " OR  (si_submit_date<= TO_DATE('" + uim.getSubmitDate()
					+ "','DD/MM/YYYY')  AND si_confirm_date>= TO_DATE('" + uim.getConfirmDate() + "','DD/MM/YYYY') )) ";
		}
		if(!uim.getCancelDate().equals("")) {			
			where += " AND ( TO_DATE(to_char(record_updated_date,'DD/MM/YYYY'),'DD/MM/YYYY')>= TO_DATE('" + uim.getCancelDate()
			+ "','DD/MM/YYYY') AND  type_error='"+DAO_BOOKING_CANCEL+"' AND type_error='"+DAO_SI_CANCELED+"') ";
			
		}
		if(!"All".equalsIgnoreCase(uim.getErrorType())) {			
			where += " AND   type_error='"+uim.getErrorType()+"'   ";
			
		}
		sqlQuery = sqlQuery + where+" order by booking_submit_date DESC ";
		System.out.println("Booking log Query -->" + sqlQuery);
		List<AdminBookingLogMod> ppm = getJdbcTemplate().query(sqlQuery, new Object[] {}, new AdminBookingLogMapper());

		return ppm;
	}

	public class AdminBookingLogMapper extends JdbcRowMapper {
		private int index=0;
		public AdminBookingLogMod mapRow(ResultSet rs, int row) throws SQLException {
			index++;
			AdminBookingLogMod obj = new AdminBookingLogMod();
			obj.setId(rs.getString("ID_LOG"));
			obj.setIndex(index+"");
			obj.setBookingNo(rs.getString("fk_booking_no"));
			obj.setbLNo(rs.getString("fk_bl_no"));
			obj.setBookingRef(rs.getString("fk_booking_ref_no"));
			obj.setType(rs.getString("type_error"));
			obj.setBookingConfirmDate(AdminBookingLogDaoImpl.formatDate(rs.getTimestamp("booking_confirm_date")));
			obj.setBookingSubmitDate(AdminBookingLogDaoImpl.formatDate(rs.getTimestamp("booking_submit_date")));

			obj.setShippingConfirmDate(AdminBookingLogDaoImpl.formatDate(rs.getTimestamp("si_confirm_date")));
			obj.setShippingSubmitDate(AdminBookingLogDaoImpl.formatDate(rs.getTimestamp("si_submit_date")));
			obj.setRecordAddUser(rs.getString("record_add_user"));
			obj.setCreationDate(AdminBookingLogDaoImpl.formatDate(rs.getTimestamp("record_add_date")));
			obj.setType(rs.getString("type_error"));
			obj.setErrorLog(rs.getString("message"));
			obj.setUpdatedDate(AdminBookingLogDaoImpl.formatDate(rs.getTimestamp("record_updated_date")));
			return obj;
		}
	}

	private boolean isBookingExist(String bookingId) {
		String selectQuery = "select count(*) from rcltbls.bkg_log_dtl where fk_booking_ref_no=? or  fk_booking_no=?";
		int count = getJdbcTemplate().queryForInt(selectQuery, new Object[] { bookingId, bookingId });
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	private int bookingLogPrimary(String bookingRefNumber, String bookingNumber) {
		String selectQuery = "select max(ID_LOG) from rcltbls.bkg_log_dtl where fk_booking_ref_no=? or  fk_booking_no=?";
		int count = getJdbcTemplate().queryForInt(selectQuery, new Object[] { bookingRefNumber, bookingNumber });
	  return count;
	}

	
	@Override
	public void insertLogInLogTable(EserviceNewWebBookingUim form, Exception e, String errorType) {
		try {
			String query = "";
			Date currentDate = new Date();
			if (errorType.equals(SAVE_BOOKING)) {

				if (isBookingExist(form.getBookingRef())) {
					query = "UPDATE  rcltbls.bkg_log_dtl  set  booking_submit_date=?, record_add_user=?, record_updated_date=?,type_error=? where fk_booking_ref_no=? ) ";
					getJdbcTemplate().update(query, new Object[] { currentDate, form.getUserId(), currentDate,
							AdminBookingLogDao.DAO_BOOKING_CREATION, form.getBookingRef() });

					System.out.println("Insert booking creation : " + query);
					insertFile(form.getBookingRef(), form.getBookingNo(), form.getBookingNo()+".xml", XML_FILE_BOOKING);
				} else {

					query = "INSERT INTO rcltbls.bkg_log_dtl "
							+ "(fk_booking_ref_no,  booking_submit_date, record_add_user, record_add_date,type_error)  values(?,?,?,?,?)";
					getJdbcTemplate().update(query, new Object[] { form.getBookingRef(), currentDate, form.getUserId(),
							currentDate, AdminBookingLogDao.DAO_BOOKING_CREATION });

					insertFile(form.getBookingRef(), form.getBookingNo(), form.getBookingNo()+".xml", XML_FILE_BOOKING);
					System.out.println("Insert booking creation : " + query);
				}
			}

			if (errorType.equals(SAVE_BOOKING_ERROR)) {
				if (isBookingExist(form.getBookingRef())) {

					query = "UPDATE  rcltbls.bkg_log_dtl  set  booking_submit_date=?, record_add_user=?, record_updated_date=?,type_error=?,message=? where fk_booking_ref_no=? ) ";
					getJdbcTemplate().update(query,
							new Object[] { currentDate, form.getUserId(), currentDate,
									errorType,
									ExceptionUtils.getStackTrace(e).substring(0, 2998), form.getBookingRef() });
					
					
				} else {
					query = "INSERT INTO rcltbls.bkg_log_dtl "
							+ "(fk_booking_ref_no,  booking_submit_date, record_add_user, record_add_date,type_error,message) values(?,?,?,?,?,?)";
					getJdbcTemplate().update(query,
							new Object[] { form.getBookingRef(), currentDate, form.getUserId(), currentDate,
									errorType,
									ExceptionUtils.getStackTrace(e).substring(0, 2998) });

					System.out.println("Insert booking creation  SAVE_BOOKING_ERROR: " + query);
					 

				}

			} else if (errorType.equals(DAO_BOOKING_SUBMIT_XML) || errorType.equals(DAO_BOOKING_CANCEL_XML)) {
				if (isBookingExist(form.getBookingRef())) {

					query = "UPDATE  rcltbls.bkg_log_dtl  set  booking_submit_date=?, record_add_user=?, record_updated_date=?,type_error=?,message=? where fk_booking_ref_no=? ) ";
					getJdbcTemplate().update(query, new Object[] { currentDate, form.getUserId(), currentDate,
							errorType, ExceptionUtils.getStackTrace(e).substring(0, 2998), form.getBookingRef() });
				} else {
					query = "INSERT INTO rcltbls.bkg_log_dtl "
							+ "(fk_booking_ref_no,  booking_submit_date, record_add_user, record_add_date,type_error,message) values(?,?,?,?,?,?)";
					getJdbcTemplate().update(query, new Object[] { form.getBookingRef(), currentDate, form.getUserId(),
							currentDate, errorType, ExceptionUtils.getStackTrace(e).substring(0, 2998) });

					System.out.println("Insert booking creation : " + query);
					insertFile(form.getBookingRef(), form.getBookingNo(), form.getBookingNo()+".xml", XML_FILE_BOOKING);
				}

			}
		} catch (Exception exp) {
			//exp.printStackTrace();
			System.out.println("AdminBookingLogDaoImpl insertLogInLogTable() 191");
		}

	}

	@Override
	public void insertLogInLogTableBooking(String bookingNumber, String bookingNumberOld, Exception e1,
			String errorType) {
		try {
			String query = "";
			Date currentDate = new Date();

			if (errorType.equals(DAO_BOOKING_CONFIRMED_ERROR)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set fk_booking_no=?, record_updated_date=?, booking_confirm_date=?, type_error=?,message=? where fk_booking_ref_no=? or fk_booking_no=? ) ";
				getJdbcTemplate().update(query, new Object[] {bookingNumber,currentDate, currentDate, errorType,
						ExceptionUtils.getStackTrace(e1).substring(0, 2998), bookingNumberOld, bookingNumber });
				
			} else if (errorType.equals(DAO_BOOKING_CONFIRMED)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set fk_booking_no=?,record_updated_date=?,  booking_confirm_date=?, type_error=?,message=? where fk_booking_ref_no=? or fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { bookingNumber,currentDate,currentDate, errorType, null, bookingNumberOld, bookingNumber });
				
				insertFile(bookingNumberOld ,bookingNumber , ediFileName,EDI_FILE_BOOKING);
			} else if (errorType.equals(DAO_BOOKING_EDIT)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set fk_booking_no=?,record_updated_date=?,  booking_confirm_date=?, type_error=?,message=? where fk_booking_ref_no=? or fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { bookingNumber,currentDate,currentDate, errorType, null, bookingNumberOld, bookingNumber });
				
				insertFile(bookingNumberOld ,bookingNumber , ediFileName,EDI_FILE_BOOKING);
			} else if (errorType.equals(DAO_BOOKING_EDIT_ERROR)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set fk_booking_no=?,record_updated_date=?,  booking_confirm_date=?, type_error=?,message=? where fk_booking_ref_no=? or fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { bookingNumber,currentDate,currentDate, errorType, ExceptionUtils.getStackTrace(e1).substring(0, 2998), bookingNumberOld, bookingNumber });
				
				insertFile(bookingNumberOld ,bookingNumber , ediFileName,EDI_FILE_BOOKING);
			} else if (errorType.equals(DAO_BOOKING_CANCEL)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set fk_booking_no=?,record_updated_date=?,  booking_confirm_date=?, type_error=?,message=? where fk_booking_ref_no=? or fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { bookingNumber,currentDate,currentDate, errorType, null, bookingNumberOld, bookingNumber });
				
				insertFile(bookingNumberOld ,bookingNumber , ediFileName,EDI_FILE_BOOKING);
			} else if (errorType.equals(DAO_BOOKING_CANCEL_ERROR)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set fk_booking_no=?,record_updated_date=?,  booking_confirm_date=?, type_error=?,message=? where fk_booking_ref_no=? or fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { bookingNumber,currentDate,currentDate, errorType, ExceptionUtils.getStackTrace(e1).substring(0, 2998), bookingNumberOld, bookingNumber });
				
				insertFile(bookingNumberOld ,bookingNumber , ediFileName,EDI_FILE_BOOKING);
			}
		} catch (Exception exp) {
			//exp.printStackTrace();
			System.out.println("AdminBookingLogDaoImpl insertLogInLogTableBooking() 217");
		}

	}

    private void insertFile(String bookingRefNumber  , String bookingNumber ,String fileName,String type) {
    	int id =bookingLogPrimary(bookingRefNumber,bookingNumber);
    	if(id != 0) {
    		Date currentDate = new Date();
    		String 	query = "INSERT INTO rcltbls.bkg_log_dtl_files "
					+ "(ID_LOG_FK,  file_name, type_of_file, record_add_date) values(?,?,?,?)";
			getJdbcTemplate().update(query, new Object[] { id, fileName, type,currentDate });
    	}
    }

    public void insertLogInLogSiTable(String bookingNumberForSI, String bLNum, String userId, Exception e1,
			String errorType) {
		try {
			Date currentDate = new Date();
			String query = "";
			if (errorType.equals(DAO_SI_SUBMIT)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set record_updated_date=?,  si_submit_date=?, fk_bl_no=?,type_error=?,message=? where fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { currentDate,currentDate, bLNum, errorType, null, bookingNumberForSI });
				insertFile(bookingNumberForSI, bookingNumberForSI, bookingNumberForSI+".xml", XML_FILE_SI);

			} else if (errorType.equals(DAO_SI_SUBMIT_XML) || errorType.equals(DAO_SI_SUBMIT_ERROR)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set record_updated_date=?, si_submit_date=?, fk_bl_no=?,type_error=?,message=? where fk_booking_no=?  ";
				getJdbcTemplate().update(query, new Object[] {currentDate, currentDate, bLNum, errorType,
						ExceptionUtils.getStackTrace(e1).substring(0, 2998), bookingNumberForSI });
				
				insertFile(bookingNumberForSI, bookingNumberForSI, bookingNumberForSI+".xml", XML_FILE_SI);

			} else if (errorType.equals(DAO_SI_CONFIRMED_ERROR)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set record_updated_date=?, si_confirm_date=?, fk_bl_no=?,type_error=?,message=? where fk_booking_no=?  ";
				getJdbcTemplate().update(query, new Object[] {currentDate, currentDate, bLNum, errorType,
						ExceptionUtils.getStackTrace(e1).substring(0, 2998), bookingNumberForSI });
				
			}  else if (errorType.equals(DAO_SI_CANCELED_ERROR)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set record_updated_date=?, si_confirm_date=?, fk_bl_no=?,type_error=?,message=? where fk_booking_no=?  ";
				getJdbcTemplate().update(query, new Object[] {currentDate, currentDate, bLNum, errorType,
						ExceptionUtils.getStackTrace(e1).substring(0, 2998), bookingNumberForSI });
				
			} else if (errorType.equals(DAO_SI_CONFIRMED)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set record_updated_date=?, si_confirm_date=?, fk_bl_no=?,type_error=?,message=? where fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { currentDate,currentDate, bLNum, errorType, null, bookingNumberForSI });
				insertFile(bookingNumberForSI, bookingNumberForSI, ediFileName, EDI_FILE_SI);
			}  else if (errorType.equals(DAO_SI_CANCELED)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set record_updated_date=?, si_confirm_date=?, fk_bl_no=?,type_error=?,message=? where fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { currentDate,currentDate, bLNum, errorType, null, bookingNumberForSI });
				insertFile(bookingNumberForSI, bookingNumberForSI, ediFileName, EDI_FILE_SI);
			} else if(errorType.equals(DAO_SI_SAVE)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set record_updated_date=?,  si_submit_date=?, fk_bl_no=?,type_error=?,message=? where fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { currentDate,currentDate, bLNum, errorType, null, bookingNumberForSI });
			} else if(errorType.equals(DAO_SI_SAVE_ERROR)) {
				query = "UPDATE  rcltbls.bkg_log_dtl  set record_updated_date=?,  si_submit_date=?, fk_bl_no=?,type_error=?,message=? where fk_booking_no=?  ";
				getJdbcTemplate().update(query,
						new Object[] { currentDate,currentDate, bLNum, errorType, ExceptionUtils.getStackTrace(e1).substring(0, 2998), bookingNumberForSI });
			}
		} catch (Exception exp) {
			//exp.printStackTrace();
			System.out.println("AdminBookingLogDaoImpl insertLogInLogSiTable() 287");
		}
	}

	private static final String url = "jdbc:postgresql://10.24.238.205:5432/sgdwebdb";
	private static final String user = "webapps";
	private static final String password = "ZMZmcksZKa3L25qC";

	public static void main(String arg[]) throws Exception {

		Class.forName("org.postgresql.Driver");
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);

		Date currentDate = new Date();
		// String query = "UPDATE rcltbls.bkg_log_dtl set booking_submit_date=?,
		// record_add_user=?, record_add_date=?,type_error=? where fk_booking_ref_no=? )
		// ";

		String query = "INSERT INTO rcltbls.bkg_log_dtl "
				+ "(fk_booking_ref_no,  booking_submit_date, record_add_user, record_add_date,type_error)  values(?,?,?,?,?)";
		/*
		 * getJdbcTemplate().update(query, new Object[] { form.getBookingRef(),
		 * currentDate, form.getUserId(), currentDate,
		 * AdminBookingLogDao.DAO_BOOKING_CREATION });
		 */
		PreparedStatement pre = conn.prepareStatement(query);
		pre.setString(1, "BLK222");
		pre.setDate(2, new java.sql.Date(currentDate.getTime()));
		pre.setString(3, "22");
		pre.setDate(4, new java.sql.Date(currentDate.getTime()));
		pre.setString(5, AdminBookingLogDao.DAO_BOOKING_CREATION);
		pre.executeUpdate();

		System.out.println("Insert booking creation : " + query);

	}
	
	/*    */


	@Override
	public List<AdminBookingFileLogMod> getBookingFileLog(AdminBookingLogUim form) {

		String sqlQuery = " select file_name,type_of_file,record_add_date from bkg_log_dtl_files where id_log_fk='"+form.getId()+"' ";
		System.out.println("Booking file log Query -->" + sqlQuery);
		List<AdminBookingFileLogMod> ppm = getJdbcTemplate().query(sqlQuery, new Object[] {}, new AdminBookingFilLogMapper());

		return ppm;
	}
	
	public class AdminBookingFilLogMapper extends JdbcRowMapper {

		public AdminBookingFileLogMod mapRow(ResultSet rs, int row) throws SQLException {
			AdminBookingFileLogMod obj = new AdminBookingFileLogMod();
			obj.setTypeOfFile(rs.getString("type_of_file"));
			obj.setFileName(rs.getString("file_name"));
			obj.setRecordAddUser(AdminBookingLogDaoImpl.formatDate(rs.getTimestamp("record_add_date")));
			 
			return obj;
		}
	}
	
}