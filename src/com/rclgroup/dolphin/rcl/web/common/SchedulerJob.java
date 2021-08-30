package com.rclgroup.dolphin.rcl.web.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rclgroup.dolphin.ezl.email.EZLBeanFactory;
import com.rclgroup.dolphin.ezl.email.EZLMail;
import com.rclgroup.dolphin.rcl.web.eservice.action.EservicePropertyFatchOperation;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EsiSubmissionMail;
import com.rclgroup.dolphin.rcl.web.eservice.dao.AdminBookingLogDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceConnectionPostgra;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDaoImpl;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.FtpConfig;

public class SchedulerJob extends TimerTask {

	private String schedularStartdate;
	private Timer timer;
	private JdbcTemplate jdbcTemplate;
	static EserviceNewWebBookingDaoImpl dbConnection = null;
	static AdminBookingLogDao  			daoObjs		 = null;

	private static List eqnNum;
	private static List size;
	private static List type;
	private static String bookingNumber;
	private static String bookingNumberOld;
	private static String vesselName;
	private static String vesselNumber;
	private static String voyage;
	private static String qtnNo;

	static String date;
	static String customerContNumber;
	static String customerFaxNumber;
	static String customerEmail;
	static String traficServiceCode;
	static String confirmedDate;
	static String serviceOrigin;
	static String status;

	static String statusSi;
	 
	static String por;
	static String del;
	static String toTerminal;
	static String fromTerminal;
	static String pol;
	static String pod;
	static String bookingDate;
	static String bookingParty;
	static String volume;

	static String arrivalDate;
	static String departureDate;
	static String cargoDescription;
	static String contractParty;
	static String specialInstructions = "";
	static String userName;
	static String sipmentTerm;
	/*
	 * static String status; static String status;
	 */
	static String checkLoc9 = "";
	static String checkLoc11 = "";
	static String loc9132 = null; // vessel eta
	static String loc9133 = null; // EST departue date
	static String loc11132 = null; // EST arrivl date
	static String loc11133 = null;
    static boolean checkTDT20 = false; 
    static boolean checkTDT30 = false;
    static String pot1 = null;
    static String pot2 = null;
    static String pot3 = null;
	// for eSI file

	static String chargedCode;
	static String bLNum;
	static String descption;
	static String ammount;
	static String currnyType;
	static String rate;
	static String bookingNumberForSI;
	
	static String vesselNumber1 ;
	static String vesselName1;
	static String voyage1;
	
	static String vesselNumber2 ;
	static String vesselName2;
	static String voyage2;
	
	static String vesselNumber3 ;
	static String vesselName3;
	static String voyage3;

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public SchedulerJob(Timer timer, String schedularStartdate) {
		this.timer = timer;
		this.schedularStartdate = schedularStartdate;
	}

	public SchedulerJob(Timer timer, String schedularStartdate,JdbcTemplate jdbcTemplate) {
		this.timer = timer;
		this.schedularStartdate = schedularStartdate;
		this.jdbcTemplate =  jdbcTemplate;
	}
	
	@Override
	public void run() {
		System.out.println("Executing timer task" + schedularStartdate);
		this.execute();
	}

	public void execute() {

		// System.out.println("[============ Updating Database ===============]");
		try {
			updateDcsDataBase();
			updateDcsDataBaseForSI();
		} catch (IOException e) { // TODO
			// Auto-generated catch block e.printStackTrace();
		}

	}

	public static void updateDcsDataBase() throws IOException {

		// System.out.println("updateDcsDataBase() called...");

		FtpConfig ftfConfig = (FtpConfig) EZLBeanFactory.getBean("ftpConfig");

		/*
		 * String ip = ftfConfig.getIp(); String userId = ftfConfig.getUserId(); String
		 * password = ftfConfig.getPassword(); String path = ftfConfig.getBookingOut();
		 * String bookingOut = ftfConfig.getBookingOut(); String outBackUp =
		 * ftfConfig.getOutBkup();
		 */

		String ip = EservicePropertyFatchOperation.ip;
		System.out.println("ip : "+ip);
		String userId = EservicePropertyFatchOperation.userId;
		System.out.println("userId : "+userId);
		String password = EservicePropertyFatchOperation.password;
		System.out.println("password : "+password);
		String bookingOut = EservicePropertyFatchOperation.bookingOut;
		System.out.println("bookingOut : "+bookingOut);
		String outBackUp = EservicePropertyFatchOperation.bookingOutBackUp;
		System.out.println("outBackUp : "+outBackUp);
		String errorBackUp = EservicePropertyFatchOperation.bookingOutBackUp;
		System.out.println("errorBackUp : "+errorBackUp);
		FTPClient client = new FTPClient();
		try {
			client.connect(ip);
			boolean login = client.login(userId, password);
			client.enterLocalPassiveMode();
			//client.connect("localhost");
			//boolean login = client.login("lenovo", "cognis");
			if (login == true) {
				System.out.println("Successfully logged in for EDI file Read!");
			} else {
				System.out.println("Login Fail!  for EDI file Read");
			}
			//client.changeWorkingDirectory("E:\\Genrate");
			client.changeWorkingDirectory(bookingOut);
			List<String> files = new ArrayList<>();
			FTPFile[] listOfFiles = client.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println("    " + listOfFiles[i].getName());
					files.add(listOfFiles[i].getName());
				}
			}
			client.disconnect();
			for (String file : files) {
				client.connect(ip);
				login = client.login(userId, password);
				
				client.enterLocalPassiveMode();
                
				System.out.println("Started for EDI reading...." +  file);
				// client.connect("localhost");
				// login = client.login("lenovo", "cognis");

				client.changeWorkingDirectory(bookingOut);
				InputStream inputStream = client.retrieveFileStream(file);
				Scanner sc = new Scanner(inputStream);
				// Reading the file line by line and printing the same
				String fileData = "";
				while (sc.hasNextLine()) {
					fileData += sc.nextLine();
				}
				//reset all variable
				reset();
				try {
					synchronized (fileData) {
						int i=readFile(fileData,file);
						if(i==0)
							readFileSecond(fileData);
					}
				
					client.connect(ip);
					login = client.login(userId, password);
				
					if (login == true) {
						System.out.println("Successfully logged in for booking EDI  remove operation "+file);
					} else {
						System.out.println("Login Fail!  for booking EDI file remove operation "+file);
					}
				
					client.enterLocalPassiveMode();
				
					boolean b = client.rename(bookingOut + file, outBackUp + file);

					if (b)
						System.out.println("  file moved successfully!  " + file);
					else
						System.out.println("  file not moved ! " + file);
					sc.close();
					inputStream.close();

				}catch (Exception e) {					
					System.out.println("File move to Error Directory...");
					client.connect(ip);
					login = client.login(userId, password);
					if (login == true) {
						System.out.println("Successfully logged in for booking EDI  remove operation "+file);
					} else {
						System.out.println("Login Fail!  for booking EDI file remove operation "+file);
					}
					client.enterLocalPassiveMode();
					boolean b = client.rename(bookingOut + file, errorBackUp + file);
					if (b)
						System.out.println("  file moved to Error Directory successfully!  " + file);
					else
						System.out.println("  file not moved to Error Directory! " + file);
					sc.close();
					inputStream.close();
				}
			}
			client.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Read process failed.. ");
		} finally {
			try {
				client.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/** This is for reading booking EDI file
	 * 
	 * @param fileData
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	public static int readFile(String fileData,String file) throws IOException, SQLException {

		System.out.println("readFile() called....");
		// using Scanner class for large files, to read line by line
		try {
			readUsingScanner(fileData);
			System.out.println("bookingNumber!  " + bookingNumber);
			System.out.println(" try to fetch status "+status);
			daoObjs = getAdminLoginDao();
			daoObjs.setEdiFileName(file);
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(" File Read failed.. ");
			try {
				daoObjs = getAdminLoginDao();
				daoObjs.insertLogInLogTableBooking(bookingNumber,bookingNumberOld,e1,AdminBookingLogDao.DAO_BOOKING_CONFIRMED_ERROR);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			throw new IOException();
		}
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String cuuntDate = dateFormat.format(date);
			Connection connection = null;
			EserviceConnectionPostgra daoObj = (EserviceConnectionPostgra) EZLBeanFactory
					.getBeanSpringJdbc("eserviceConnectionPostgra");
			try {
				connection = daoObj.getConnectionObj();
				Statement statement = null;
				ResultSet rs = null;
				if (status == null) {
					status = "";
				}
				if(status.equals("E")) { 
				int bookingStatusDbValdation= 0;
				String CHECK_BOOKING_STATUS_IN_DB="select count(*) as COUNTBOOKING from SEALINER.BKP001 where babkno='" + bookingNumber + "'";
				System.out.println("CHECK_BOOKING_STATUS_IN_DB : " + CHECK_BOOKING_STATUS_IN_DB);
				
				statement = connection.createStatement();
				rs = statement.executeQuery(CHECK_BOOKING_STATUS_IN_DB);
				if (rs.next()) {
					bookingStatusDbValdation = rs.getInt("COUNTBOOKING");
				}
				rs.close();
				statement.close();
				if(bookingStatusDbValdation==0) {
					status="O";
				}
				}
				System.out.println("status of booking edi "+ status);
				String UPDATE_BOOKING_NO_BKP001 = "";
				String UPDATE_BOOKING_NO_ESV_WB_EXTEND = "";
				if(!status.equals("N")) {
				if (status.equals("E")) {
					System.out.println("Edit is execute "+status+" sipmentTerm "+sipmentTerm);
					UPDATE_BOOKING_NO_BKP001 = "update SEALINER.BKP001 set  bapot1 ="+((pot1==null || "".equals(pot1) )?null:"'"+pot1+"'")+", bapot2="+((pot2==null || "".equals(pot2) )?null:"'"+pot2+"'")+", bapot3 ="+((pot3==null || "".equals(pot3) )?null:"'"+pot3+"'")+", babkno='" + bookingNumber + "', bapol='"
							+ pol + "', bapod='" + pod + "', TOTERMINAL='" + toTerminal + "', FROMTERMINAL='"
							+ fromTerminal + "', baquno='"+qtnNo+"' ,BAORGN='" + por + "', BADSTN='" + del + "',vesseletd='" + ((loc9132==null || "".equals(loc9132) )?((loc9133==null || "".equals(loc9133) )?cuuntDate:loc9133):loc9132)
							+ "', bamode='"+sipmentTerm+"'  where babkno= '" + bookingNumber + "' ";

					UPDATE_BOOKING_NO_ESV_WB_EXTEND = "update ESV_WB_EXTEND set pk_booking_no='" + bookingNumber
							+ "', DESIRED_ARRIVAL_DATE=" + ((loc11132==null || "".equals(loc11132) )?null:"'"+loc11132+"'") + " , EXPECTED_SAILING_DATE=" + ((loc9133==null || "".equals(loc9133) )?null:"'"+loc9133+"'")
							+ " where pk_booking_no= '" + bookingNumber + "' ";
					
					String CHECK_INPROGRESS_FLAG = "Select count(*) as checkSI from ESV_SI_HEADER  where fk_booking_no= '" + bookingNumber + "' and esi_status='E'"; 
					
					int siStatusCheck=0;
					System.out.println("CHECK_INPROGRESS_FLAG : " + CHECK_INPROGRESS_FLAG);
					
					statement = connection.createStatement();
					rs = statement.executeQuery(CHECK_INPROGRESS_FLAG);
					if (rs.next()) {
						siStatusCheck = rs.getInt("checkSI");
					}
					rs.close();
					statement.close();
					
					System.out.println(" SiStatus check : " +siStatusCheck);
					
					if(siStatusCheck>0) {
						String UPDATE_ESI_EDIT_FLAG="UPDATE ESV_SI_HEADER set EDIT_FALG = 'R' where  fk_booking_no= '" + bookingNumber + "'";
						System.out.println("1 UPDATE_ESI_EDIT_FLAG " + UPDATE_ESI_EDIT_FLAG);
						statement = connection.createStatement();
						int row = statement.executeUpdate(UPDATE_ESI_EDIT_FLAG);
						statement.close();
					}
					
				} else {
					System.out.println("Confirm is execute "+status+" sipmentTerm "+sipmentTerm);
					
					/*
					 * int CHECK_BOOKINGNO_BOOKINGREF_COUNT=0; String CHECK_BOOKINGNO_BOOKINGREF =
					 * "select count(*) as COUNT_BOOKING_REF from SEALINER.BKP001 where babkno='" +
					 * bookingNumberOld + "'"; System.out.println("CHECK_BOOKING_STATUS_IN_DB : " +
					 * CHECK_BOOKINGNO_BOOKINGREF);
					 * 
					 * statement = connection.createStatement(); rs =
					 * statement.executeQuery(CHECK_BOOKINGNO_BOOKINGREF); if (rs.next()) {
					 * CHECK_BOOKINGNO_BOOKINGREF_COUNT = rs.getInt("COUNT_BOOKING_REF"); }
					 * rs.close(); statement.close(); if(CHECK_BOOKINGNO_BOOKINGREF_COUNT==0) {
					 * bookingNumberOld=bookingNumber; }
					 */
					
					UPDATE_BOOKING_NO_BKP001 = "update SEALINER.BKP001 set  BASTAT='C' , SPLSTATS='C' ,BKG_CONFRIM_DATE='" + cuuntDate+"' , bapot1 ="+((pot1==null || "".equals(pot1) )?null:"'"+pot1+"'")+", bapot2="+((pot2==null || "".equals(pot2) )?null:"'"+pot2+"'")+", bapot3 ="+((pot3==null || "".equals(pot3) )?null:"'"+pot3+"'")+", babkno='" + bookingNumber + "', bapol='"
							+ pol + "', bapod='" + pod + "', baquno='"+qtnNo+"', TOTERMINAL='" + toTerminal + "', FROMTERMINAL='"
							+ fromTerminal + "', BAORGN='" + por + "', BADSTN='" + del + "',vesseletd='" + ((loc9132==null || "".equals(loc9132) )?((loc9133==null || "".equals(loc9133) )?cuuntDate:loc9133):loc9132)
							+ "', bamode='"+sipmentTerm+"'  where babkno= '" + bookingNumberOld + "' ";

					UPDATE_BOOKING_NO_ESV_WB_EXTEND = "update ESV_WB_EXTEND set pk_booking_no='" + bookingNumber
							+ "', DESIRED_ARRIVAL_DATE=" + ((loc11132==null || "".equals(loc11132) )?null:"'"+loc11132+"'") + ", EXPECTED_SAILING_DATE=" + ((loc9133==null || "".equals(loc9133) )?null:"'"+loc9133+"'")
							+ " where pk_booking_no= '" + bookingNumberOld + "' ";
				}
				String UPDATE_BOOKING_NO_BKP030 = "update SEALINER.BKP030 set bnbkno='" + bookingNumber
						+ "' where bnbkno= '" + bookingNumberOld + "' ";

				/*
				 * String UPDATE_BOOKING_NO_ROUTE_DTL_BOOKING =
				 * "update route_dtl_booking set booking_no='" + bookingNumber +
				 * "' where booking_no= '" + bookingNumberOld + "' ";
				 */

				String UPDATE_BOOKING_NO_ROUTE_DTL_BOOKING = "DELETE FROM ROUTE_DTL_BOOKING  "
						+ " WHERE BOOKING_NO= '" + bookingNumberOld + "' or  BOOKING_NO= '" + bookingNumber + "'";
				
				String UPDATE_BOOKING_NO_BKP050 = "update SEALINER.BKP050 set bwbkno='" + bookingNumber
						+ "' where bwbkno= '" + bookingNumberOld + "' ";

				// String UPDATE_BOOKING_NO_BKG_EQUIPMENT = "update BKG_EQUIPMENT set bibkno='"
				// + bookingNumber+ "' where bibkno= '" + bookingNumberOld+"' ";

				String UPDATE_BOOKING_NO_BKP007 = "update SEALINER.BKP007 set bgbkno='" + bookingNumber
						+ "' where bgbkno= '" + bookingNumberOld + "' ";

				String UPDATE_BOOKING_NO_BKP032 = "update SEALINER.BKP032 set bcbkno='" + bookingNumber
						+ "' where bcbkno= '" + bookingNumberOld + "' ";

				String UPDATE_BOOKING_NO_BOOKING_SUPPLIER_DETAIL = "update SEALINER.BOOKING_SUPPLIER_DETAIL set booking_no= '"
						+ bookingNumber + "' where booking_no='" + bookingNumberOld + "' ";

				String UPDATE_BOOKING_NO_ESV_WB_SIZETYPE = "update ESV_WB_SIZETYPE set pk_booking_no='" + bookingNumber
						+ "' where pk_booking_no= '" + bookingNumberOld + "' ";
				
				String INSERT_ROUTING_DTL = "INSERT INTO  ROUTE_DTL_BOOKING (vessel_name,vessel_no,voyage,booking_no)"
						+" values('"+vesselName+"','"+vesselNumber+"','"+voyage+"','"+bookingNumber+"')";

				
				/*
				 * System.out.println("EMAIL_QUERY : " + EMAIL_IDS);
				 * statement=connection.createStatement(); ResultSet resultSet =
				 * statement.executeQuery(EMAIL_IDS); while(resultSet.next()) {
				 * customerEmail=resultSet.getString("CALLER_EMAIL").trim();
				 * if(resultSet.getString("ADDITIONAL_EMAILS") != null &&
				 * !resultSet.getString("ADDITIONAL_EMAILS").equals("")) {
				 * customerEmail=customerEmail +","+resultSet.getString("ADDITIONAL_EMAILS"); }
				 * } statement.close();
				 */

				
				System.out.println("123 UPDATE_BOOKING_NO_BKP001 " + UPDATE_BOOKING_NO_BKP001);
				statement = connection.createStatement();
				int row = statement.executeUpdate(UPDATE_BOOKING_NO_BKP001);
				statement.close();
				System.out.println(" UPDATE_BOOKING_NO_BKP030 " + UPDATE_BOOKING_NO_BKP030);
				statement = connection.createStatement();
				row = statement.executeUpdate(UPDATE_BOOKING_NO_BKP030);
				statement.close();
				System.out.println(" UPDATE_BOOKING_NO_ESV_WB_EXTEND " + UPDATE_BOOKING_NO_ESV_WB_EXTEND);
				statement = connection.createStatement();
				row = statement.executeUpdate(UPDATE_BOOKING_NO_ESV_WB_EXTEND);
				statement.close();
				System.out.println(" UPDATE_BOOKING_NO_ROUTE_DTL_BOOKING " + UPDATE_BOOKING_NO_ROUTE_DTL_BOOKING);
				statement = connection.createStatement();
				row = statement.executeUpdate(UPDATE_BOOKING_NO_ROUTE_DTL_BOOKING);
				statement.close();
				System.out.println(" UPDATE_BOOKING_NO_BKP050 " + UPDATE_BOOKING_NO_BKP050);
				statement = connection.createStatement();
				row = statement.executeUpdate(UPDATE_BOOKING_NO_BKP050);
				statement.close();
				System.out.println(" INSERT_ROUTING_DTL " + INSERT_ROUTING_DTL);
				statement = connection.createStatement();
				row = statement.executeUpdate(INSERT_ROUTING_DTL);
				statement.close();

				/*
				 * System.out.println(" UPDATE_BOOKING_NO_BKG_EQUIPMENT " +
				 * UPDATE_BOOKING_NO_BKG_EQUIPMENT); statement=connection.createStatement(); row
				 * = statement.executeUpdate(UPDATE_BOOKING_NO_BKG_EQUIPMENT);
				 * statement.close();
				 */

				System.out.println(" UPDATE_BOOKING_NO_BKP007 " + UPDATE_BOOKING_NO_BKP007);
				statement = connection.createStatement();
				row = statement.executeUpdate(UPDATE_BOOKING_NO_BKP007);
				statement.close();
				System.out.println(" UPDATE_BOOKING_NO_BKP032 " + UPDATE_BOOKING_NO_BKP032);
				statement = connection.createStatement();
				row = statement.executeUpdate(UPDATE_BOOKING_NO_BKP032);
				statement.close();
				System.out.println(
						" UPDATE_BOOKING_NO_BOOKING_SUPPLIER_DETAIL " + UPDATE_BOOKING_NO_BOOKING_SUPPLIER_DETAIL);
				statement = connection.createStatement();
				row = statement.executeUpdate(UPDATE_BOOKING_NO_BOOKING_SUPPLIER_DETAIL);
				statement.close();
				System.out.println(" UPDATE_BOOKING_NO_ESV_WB_SIZETYPE " + UPDATE_BOOKING_NO_ESV_WB_SIZETYPE);
				statement = connection.createStatement();
				row = statement.executeUpdate(UPDATE_BOOKING_NO_ESV_WB_SIZETYPE);
				statement.close();

				if((vesselName1!=null && !vesselName1.equals("")) ||
						(vesselNumber1!=null && !vesselNumber1.equals("")) || 
											(voyage1!=null && !voyage1.equals(""))) {
				String INSERT_ROUTING_VESSEL1= "INSERT INTO  ROUTE_DTL_BOOKING (vessel_name,vessel_no,voyage,booking_no)"
						+" values('"+vesselName1+"','"+vesselNumber1+"','"+voyage1+"','"+bookingNumber+"')";
				System.out.println(" INSERT_ROUTING_VESSEL1 " + INSERT_ROUTING_VESSEL1);
				statement = connection.createStatement();
				row = statement.executeUpdate(INSERT_ROUTING_VESSEL1);
				statement.close();
				}
				if((vesselName2!=null && !vesselName2.equals("")) ||
						(vesselNumber2!=null && !vesselNumber2.equals("")) || 
											(voyage2!=null && !voyage2.equals(""))) {
				String INSERT_ROUTING_VESSEL2 = "INSERT INTO  ROUTE_DTL_BOOKING (vessel_name,vessel_no,voyage,booking_no)"
						+" values('"+vesselName2+"','"+vesselNumber2+"','"+voyage2+"','"+bookingNumber+"')";
				System.out.println(" INSERT_ROUTING_VESSEL2 " + INSERT_ROUTING_VESSEL2);
				statement = connection.createStatement();
				row = statement.executeUpdate(INSERT_ROUTING_VESSEL2);
				statement.close();
				}
				if((vesselName3!=null && !vesselName3.equals("")) ||
							(vesselNumber3!=null && !vesselNumber3.equals("") ) ||
										 			(voyage3!=null && !voyage3.equals(""))) {
				String INSERT_ROUTING_VESSEL3 = "INSERT INTO  ROUTE_DTL_BOOKING (vessel_name,vessel_no,voyage,booking_no)"
						+" values('"+vesselName3+"','"+vesselNumber3+"','"+voyage3+"','"+bookingNumber+"')";
				System.out.println(" INSERT_ROUTING_VESSEL3 " + INSERT_ROUTING_VESSEL3);
				statement = connection.createStatement();
				row = statement.executeUpdate(INSERT_ROUTING_VESSEL3);
				statement.close();
				}
				
				
				/*
				 * String sqlStatus = "UPDATE BKP001 SET BASTAT='C' , BKG_CONFRIM_DATE='" +
				 * cuuntDate + "' , SPLSTATS='C' WHERE BABKNO ='" + bookingNumber + "'";
				 * 
				 * System.out.println(" sqlStatus " + sqlStatus);
				 * 
				 * statement = connection.createStatement(); row =
				 * statement.executeUpdate(sqlStatus); statement.close();
				 */
				/*
				 * for(int j=0;j<eqnNum.size();j++) {
				 * 
				 * String
				 * sqlEqmNo="	INSERT INTO BKG_EQUIPMENT(BICTRN,BIBKNO,CARRIER_SEAL_VIN,SHIPPER_SEAL,MET_WEIGHT,"
				 * + "MET_MEASUREMENT,BIEORF,BICSZE,BICNTP,BISEQN )"+
				 * "VALUES('"+eqnNum.get(j)+"','"+bookingNumber+"','','',null,null,'',"+size.get
				 * (j)+",'"+type.get(j)+"',"+j+")"; System.out.println(" sqlEqmNo " + sqlEqmNo);
				 * statement=connection.createStatement(); row =
				 * statement.executeUpdate(sqlEqmNo); statement.close();
				 * 
				 * }
				 */

				System.out.println(" Row updated        " + row + " " + status);

				/*
				 * if(status.trim().equalsIgnoreCase("O")){ BookingConfirmationMail model=new
				 * BookingConfirmationMail();
				 * System.out.println("mail clled method "+customerEmail); if(userName!=null)
				 * model.setName(userName);
				 * 
				 * if(bookingParty!=null) { model.setBookingParty(bookingParty);
				 * model.setContarctParty(bookingParty); }
				 * 
				 * if(bookingNumber!=null) model.setBookingno(bookingNumber);
				 * 
				 * model.setQuotaionNo(""); if(bookingDate!=null)
				 * model.setBookingDate(bookingDate);
				 * 
				 * if(sipmentTerm!=null) model.setShipmentTerm(sipmentTerm);
				 * 
				 * if(pol!=null) model.setPol(pol);
				 * 
				 * if(pod!=null) model.setPod(pod);
				 * 
				 * if(volume!=null) model.setVolume(volume);
				 * 
				 * model.setEmptyPickupDate(""); if(arrivalDate!=null)
				 * model.setCargoAvailabilityDate(arrivalDate);
				 * 
				 * if(departureDate!=null) model.setDesiredArrivalDate(departureDate);
				 * 
				 * model.setRoutingPreferrence(""); if(cargoDescription!=null)
				 * model.setCargoDescription(cargoDescription);
				 * 
				 * if(specialInstructions!=null)
				 * model.setSpecialInstruction(specialInstructions);
				 * model.setCargoAvailabilityDate(""); try {
				 * 
				 * EZLMail mail = (EZLMail) EZLBeanFactory.getBean("mailMail"); if
				 * (customerEmail.contains(",")) { String[] mailIds = customerEmail.split(",");
				 * for (int i = 0; i < mailIds.length; i++) {
				 * model.setMailId(mailIds[i].trim()); mail.bookingConfirmationMail(model); } }
				 * else { model.setMailId(customerEmail.trim());
				 * mail.bookingConfirmationMail(model); } } catch (Exception e) {
				 * e.printStackTrace(); } }
				 */
				}else{
					String mailId="";
					String additionalMail="";
					int checkingBoooking=0;
					
					String TYPE_OF_CANCEL_CHECK="select count(*) BOOKING_AVAILABLE from SEALINER.BKP001 where babkno='"+bookingNumber+"'";
					
					System.out.println("Checking cancel type : " + TYPE_OF_CANCEL_CHECK);
					
					statement = connection.createStatement();
					rs = statement.executeQuery(TYPE_OF_CANCEL_CHECK);
					if (rs.next()) {
						checkingBoooking = rs.getInt("BOOKING_AVAILABLE");
					}
					rs.close();
					statement.close();
					
					String MAIL_ADDRESS= "select a.CALLER_EMAIL as MAIL ,b.ADDITIONAL_EMAILS as ADDITIONALMAIL from SEALINER.BKP001 a inner join ESV_WB_EXTEND b on a.babkno=b.PK_BOOKING_NO WHERE a.bkfern='"+bookingNumberOld+"'";
					System.out.println("MAIL_ADDRESS Booking "+MAIL_ADDRESS);
					statement = connection.createStatement();
					rs = statement.executeQuery(MAIL_ADDRESS);
					if (rs.next()) {
						 mailId=rs.getString("MAIL");
						 additionalMail = rs.getString("ADDITIONALMAIL");
					}
					rs.close();
					statement.close();

					if(checkingBoooking>0) {
						
						UPDATE_BOOKING_NO_BKP001 = "update SEALINER.BKP001 set babkno='" + bookingNumber + "'"
								+ ", BASTAT='N' , BKG_CONFRIM_DATE='" +cuuntDate+"'"
								+ ", SPLSTATS='N' "
								+ " where bkfern= '" + bookingNumberOld + "' ";
						System.out.println("Cancel booking UPDATE_BOOKING_NO_BKP001 " + UPDATE_BOOKING_NO_BKP001);
						statement = connection.createStatement();
						int row = statement.executeUpdate(UPDATE_BOOKING_NO_BKP001);
						statement.close();
						
						int siPresent=0;
						
						String CHECK_SI_PRESENCE= "select count(*) as siCheck from ESV_SI_HEADER  WHERE FK_BOOKING_NO='"+bookingNumber+"'";
						ResultSet rsrs = null;
						statement = connection.createStatement();
						rsrs = statement.executeQuery(CHECK_SI_PRESENCE);
						if (rsrs.next()) {
							siPresent = rsrs.getInt("siCheck");
						}
						rsrs.close();
						statement.close();
						
						if(siPresent>0) {
							
							int sqnNoHrd=0;
							String GET_SQN_NO= "select pk_hdr_seqno from ESV_SI_HEADER  WHERE FK_BOOKING_NO='"+bookingNumber+"'";
							ResultSet rsr = null;
							statement = connection.createStatement();
							rsr = statement.executeQuery(GET_SQN_NO);
							if (rsr.next()) {
								sqnNoHrd = rsr.getInt("pk_hdr_seqno");
							}
							rsr.close();
							statement.close();
							
							String DELETE_FROM_ESV_SI_HEADER =  "DELETE FROM ESV_SI_HEADER WHERE FK_BOOKING_NO='"+bookingNumber+"'";
						    String REMOVE_FROM_ESV_SI_CON =  "DELETE FROM ESV_SI_CONTAINERS con where con.fk_hdr_seqno="+sqnNoHrd   ;
						    String REOMVE_FROM_ESV_SI_COM =  "DELETE FROM ESV_SI_COMMODITY comm where comm.fk_hdr_seqno="+sqnNoHrd ;
							
						    System.out.println("1 DELETE_FROM_ESV_SI_HEADER " + DELETE_FROM_ESV_SI_HEADER);
							statement = connection.createStatement();
							row = statement.executeUpdate(DELETE_FROM_ESV_SI_HEADER);
							statement.close();
							
							System.out.println("2 REMOVE_FROM_ESV_SI_CON " + REMOVE_FROM_ESV_SI_CON);
							statement = connection.createStatement();
							row = statement.executeUpdate(REMOVE_FROM_ESV_SI_CON);
							statement.close();
							
							System.out.println("3 REOMVE_FROM_ESV_SI_COM " + REOMVE_FROM_ESV_SI_COM);
							statement = connection.createStatement();
							row = statement.executeUpdate(REOMVE_FROM_ESV_SI_COM);
							statement.close();
						}
						try {
							EZLMail mails = (EZLMail) EZLBeanFactory.getBean("mailMail");
							if(mailId!=null && !"".equals("mailId"))
							mails.bookingCancelationMail(bookingNumber,bookingNumberOld,cuuntDate,"BOOKINGCANCEL",mailId,additionalMail,"EDI");
						}catch (Exception e) {
							System.out.println("exception on booking cancelation "+bookingNumber);
							e.printStackTrace();
						}
						
						return 1;
					}else {
						UPDATE_BOOKING_NO_BKP001 = "UPDATE SEALINER.BKP001 SET BABKNO='" + bookingNumberOld + "'"
								+ ", BASTAT='R' , BKG_CONFRIM_DATE='" +cuuntDate+"'"
								+ ", SPLSTATS='R' "
								+ " where bkfern= '" + bookingNumberOld + "' ";
						System.out.println("Cancel booking UPDATE_BOOKING_NO_BKP001 " + UPDATE_BOOKING_NO_BKP001);
						statement = connection.createStatement();
						int row = statement.executeUpdate(UPDATE_BOOKING_NO_BKP001);
						statement.close();	
						try {
						EZLMail mails = (EZLMail) EZLBeanFactory.getBean("mailMail");
						if(mailId!=null && !"".equals("mailId"))
						mails.bookingCancelationMail(bookingNumber,bookingNumberOld,cuuntDate,"BOOKINGREJECTION",mailId,additionalMail,"EDI");
						}catch (Exception e) {
							System.out.println("exception on booking Rejection "+bookingNumber);
							e.printStackTrace();
						}
						return 1;
					}
				}
				if(status.equals("O")) {
						daoObjs.insertLogInLogTableBooking(bookingNumber,bookingNumberOld,null,AdminBookingLogDao.DAO_BOOKING_CONFIRMED);	
				} else if(status.equals("E")) {
						daoObjs.insertLogInLogTableBooking(bookingNumber,bookingNumberOld,null,AdminBookingLogDao.DAO_BOOKING_EDIT);	
				} else if(status.equals("N")) {
						daoObjs.insertLogInLogTableBooking(bookingNumber,bookingNumberOld,null,AdminBookingLogDao.DAO_BOOKING_CANCEL);	
				}
			} catch (Exception e) {
				e.printStackTrace();
				connection.rollback();
				try {
					daoObjs = getAdminLoginDao();
					if(status.equals("O")) {
							daoObjs.insertLogInLogTableBooking(bookingNumber,bookingNumberOld,e,AdminBookingLogDao.DAO_BOOKING_CONFIRMED_ERROR);
					} else if(status.equals("E")) {
							daoObjs.insertLogInLogTableBooking(bookingNumber,bookingNumberOld,e,AdminBookingLogDao.DAO_BOOKING_EDIT_ERROR);
					} else if(status.equals("N")) {
							daoObjs.insertLogInLogTableBooking(bookingNumber,bookingNumberOld,e,AdminBookingLogDao.DAO_BOOKING_CANCEL_ERROR);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				throw new SQLException();
			} finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		return 0;
	}

	private static void readUsingScanner(String line) throws IOException {

		String[] words = line.split("'");// splits the string based on string
		// using java foreach loop to print elements of string array
		int i = 0;
		int coutTDT30 = 0;
		int coutTDT30Rout = 0;
		int coutTDT20Val = 0;
		eqnNum = new LinkedList();
		size = new LinkedList();
		type = new LinkedList();
		for (String w : words) {

			if (w.startsWith("RFF")) {
				String[] word = w.split("\\+");

				if (word[1].startsWith("BN"))
					bookingNumber = word[1].replace("BN:", "");
				if (word[1].startsWith("SI"))
					bookingNumberOld = word[1].replace("SI:", "");
				if (word[1].endsWith("CNF"))
					status = "N";
				if (word[1].endsWith("RJT"))
					status = "R";
				if (word[1].endsWith("WAT"))
					status = "W";
				if (word[1].endsWith("PAT"))
					status = "P";
				if (word[1].startsWith("QTN"))
					qtnNo = word[1].replace("QTN:", "");
			}

			if (w.startsWith("EQD")) {
				String[] word = w.split("\\+");
				eqnNum.add(word[2]);
				size.add(word[3].substring(0, 2));
				type.add(word[3].substring(2, 4));
				i++;
			}
			if (w.startsWith("TDT+20")) {
				String[] word = w.split("\\+");
				String[] velsselnameandvesselCode = word[8].split(":");
				String[] polValidation = word[5].split(":");
				vesselNumber = velsselnameandvesselCode[0].replaceAll("9", "");
				vesselName = velsselnameandvesselCode[3];
				voyage = word[2];
				checkTDT20 = true;
				if( ("D").equals(polValidation[0])) {
					coutTDT20Val++;
				}
			}
			
			if (w.startsWith("DTM") && checkTDT20) {
				String[] word = w.split("\\+");

				if (word[1].startsWith("182")) {
					confirmedDate = word[1]; // confirmed_date
				} else if (word[1].startsWith("137")) {
					confirmedDate = word[1].replace("137:", "").substring(0, 8);
					; // (Document/message date/time)
					bookingDate = word[1].replace("137:", "").substring(0, 8);
					;
				}
				if (word[1].startsWith("132")) {
					arrivalDate = word[1].replace("132:", "").substring(0, 8);
				}
				if (word[1].startsWith("133")) {
					departureDate = word[1].replace("133:", "").substring(0, 8);
				}
				if (word[1].startsWith("132") && checkLoc9.equals("LOC9")) {
					loc9132 = word[1].replace("132:", "").substring(0, 8);
					System.out.println("loc9132                   = " + loc9132);
				}
				if (word[1].startsWith("133") && checkLoc9.equals("LOC9")) {
					loc9133 = word[1].replace("133:", "").substring(0, 8);
					System.out.println("loc9133 =                        " + loc9133);
					checkLoc9 = "";
				}
				if (word[1].startsWith("132") && checkLoc11.equals("LOC11")) {
					loc11132 = word[1].replace("132:", "").substring(0, 8);
					System.out.println("loc11132 =                               " + loc11132);
				}

				if (word[1].startsWith("133") && checkLoc11.equals("LOC11")) {
					loc11133 = word[1].replace("133:", "").substring(0, 8);
					System.out.println("loc11133 =                           " + loc11133);
					checkLoc11 = "";
				}
			}
			
			if(checkTDT20) {
				if (w.startsWith("LOC+9")) {
					String[] word = w.split("\\+");
					// //uim.setPortOfLoading(word[2]);
					String[] polTemp = word[2].split(":");
					pol = polTemp[0];
					// pol-termina
					fromTerminal = word[2].substring(word[2].lastIndexOf(":") + 1);
					checkLoc9 = "LOC9";
				}
				if (w.startsWith("LOC+11")) {
					String[] word = w.split("\\+");
					// //uim.setPortOfDischarge(word[2]);
					String[] podTemp = word[2].split(":");
					pod = podTemp[0];

					toTerminal = word[2].substring(word[2].lastIndexOf(":") + 1);
					checkLoc11 = "LOC11";
				}
				if (w.startsWith("LOC+7")) { // DEL
					String[] word = w.split("\\+");
					// //uim.setPlaceOfDelivery(word[2]);
					String[] delArry = word[2].split(":");
					del = delArry[0];
				}
				if (w.startsWith("LOC+88")) { /// POR
					String[] word = w.split("\\+");
					// //uim.setPlaceOfReceipt(word[2]);
					String[] porArray = word[2].split(":");
					por = porArray[0];
			    	}
			   }
			
			/* TDT 30 Start. */
			
			if (w.startsWith("TDT+30")) {
				
				coutTDT30++;
				if(coutTDT30 == 1) {
					String[] word = w.split("\\+");
					String[] velsselnameandvesselCode = word[8].split(":");
					try {
					vesselNumber1 = velsselnameandvesselCode[0].replaceAll("9", "");
					}catch (Exception e) {
					System.out.println("vesselNumber1 not found");	
					vesselNumber1=null;
					}try {
					vesselName1 = velsselnameandvesselCode[3];
					}catch (Exception e) {
					System.out.println("vesselName1 not found");	
					vesselName1=null;
					}
					voyage1 = word[2];
					System.out.println("vesselNumber1    "+vesselNumber1);
					System.out.println("vesselName1      "+vesselName1);
					System.out.println("voyage1          "+voyage1);
				}
				if(coutTDT30 == 2) {
					String[] word = w.split("\\+");
					String[] velsselnameandvesselCode = word[8].split(":");
					voyage2 = word[2];
					try {
					vesselNumber2 = ((velsselnameandvesselCode[0].replaceAll("9", "")==null || "".equals(velsselnameandvesselCode[0].replaceAll("9", "")) )?null :velsselnameandvesselCode[0].replaceAll("9", "")) ;
					}catch (Exception e) {
					System.out.println("vesselNumber2 not found");
					vesselNumber2=null;
					}try {
					vesselName2 = ((velsselnameandvesselCode[3]==null|| "".equals(velsselnameandvesselCode[3]) )?null:velsselnameandvesselCode[3]);
					}catch (Exception e) {
					System.out.println("vesselName2 not found");
					vesselName2=null;
					}
					System.out.println("vesselNumber2    "+vesselNumber2);
					System.out.println("vesselName2      "+vesselName2);
					System.out.println("voyage2          "+voyage2);
				}
				
				if(coutTDT30 == 3) {
					String[] word = w.split("\\+");
					String[] velsselnameandvesselCode = word[8].split(":");
					try {
					vesselNumber3 = ((velsselnameandvesselCode[0].replaceAll("9", "")==null || "".equals(velsselnameandvesselCode[0].replaceAll("9", "")) )?null :velsselnameandvesselCode[0].replaceAll("9", "")) ;
					}catch (Exception e) {
						System.out.println("vesselNumber3 not found");
					vesselNumber3=null;
					}try{
						vesselName3 = ((velsselnameandvesselCode[3]==null|| "".equals(velsselnameandvesselCode[3]) )?null:velsselnameandvesselCode[3]);
					}catch (Exception e) {
						System.out.println("vesselName3 not found");
						vesselName3=null;
					}
					voyage3 = word[2];
					System.out.println("vesselNumber3    "+vesselNumber3);
					System.out.println("vesselName3      "+vesselNumber3);
					System.out.println("voyage3         "+voyage3);
				}
			}
			
			if (w.startsWith("TDT+30")) {
				checkTDT20 = false;
				checkTDT30 = true;
				/* coutTDT30++; */
			}
			if(checkTDT30) {
		    if(coutTDT30 == 1) {
		    	if (w.startsWith("LOC+9")) {
					String[] word = w.split("\\+");
					String[] polTemp = word[2].split(":");
					pot1 = polTemp[0];
					if(coutTDT20Val>0) {
						pol=polTemp[0];
					}
					//fromTerminal = word[2].substring(word[2].lastIndexOf(":") + 1);
				}
				if (w.startsWith("LOC+11")) {
					String[] word = w.split("\\+");
					String[] podTemp = word[2].split(":");
					pod = podTemp[0];
					toTerminal = word[2].substring(word[2].lastIndexOf(":") + 1);
				   }
		       }	
		      if(coutTDT30 == 2) {
		    	if (w.startsWith("LOC+9")) {
					String[] word = w.split("\\+");
					String[] polTemp = word[2].split(":");
					pot2 = polTemp[0];
				//	fromTerminal = word[2].substring(word[2].lastIndexOf(":") + 1);
					
				}
				if (w.startsWith("LOC+11")) {
					String[] word = w.split("\\+");
					String[] podTemp = word[2].split(":");
					pod = podTemp[0];
					toTerminal = word[2].substring(word[2].lastIndexOf(":") + 1);
				   }
		       }
		     if(coutTDT30 == 3) {
		    	if (w.startsWith("LOC+9")) {
					String[] word = w.split("\\+");
					String[] polTemp = word[2].split(":");
					pot3 = polTemp[0];
				//	fromTerminal = word[2].substring(word[2].lastIndexOf(":") + 1);
				}
				if (w.startsWith("LOC+11")) {
					String[] word = w.split("\\+");
					String[] podTemp = word[2].split(":");
					pod = podTemp[0];
					toTerminal = word[2].substring(word[2].lastIndexOf(":") + 1);
				   }
		       }
		     if (w.startsWith("LOC+7")) { // DEL
					String[] word = w.split("\\+");
					String[] delArry = word[2].split(":");
					del = delArry[0];
					System.out.println("LOC+7 del  = " + del);
				}
				if (w.startsWith("LOC+88")) { /// POR
					String[] word = w.split("\\+");
					String[] porArray = word[2].split(":");
					por = porArray[0];
					System.out.println("LOC+88   por = " + por);
				}
			}
			
			/* TDT 30 End. */
			
			if (w.startsWith("FTX") && w.contains("HAN")) {
				String[] word = w.split("\\+");
				specialInstructions = word[2];
			}

			if (w.startsWith("UNB+UNOC")) {
				String[] word = w.split("\\+");
				date = word[4];
			}
			if (w.startsWith("UNH")) {
				String[] word = w.split("\\+");

				// //uim.setMsgId(word[1]);
				// //uim.setMsgIdType(word[2]);

			}
			if (w.startsWith("BGM")) {
				String[] word = w.split("\\+");

				// //uim.setBookingConfirmCode(word[1]);
				// //uim.setDocMsgId(word[2]);
				if (word[3].equalsIgnoreCase("9")) // status ("Open"); confirm
					status = "O";
				else if (word[3].equalsIgnoreCase("4")) {
					status = "E"; // //uim.setFunctionCode("Edit"); edit
				} else if (word[3].equalsIgnoreCase("1"))
					status = "N"; // //uim.setFunctionCode("cancel"); cancel
			}
			if (w.startsWith("CTA")) {
				String[] word = w.split("\\+");

				// //uim.setContactFunctionCode(word[1]);
				// //uim.setContactInformation(word[2]);

			}
			if (w.startsWith("CTA") && w.startsWith("CW")) {
				String[] word = w.split("\\+");

				userName = word[2].replace(":", "");

			}
			if (w.startsWith("COM")) {
				String[] word = w.split("\\+");

				// //uim.setCommunicationNo(word[1]);
				if (word[1].endsWith("TE"))
					customerContNumber = word[1]; // tellphone db col = customer_contract_no
				else if (word[1].endsWith("FX"))
					customerFaxNumber = word[1];
				else if (word[1].endsWith("EM"))

					customerEmail = word[1].replace(":EM", "");

			}
			
			if (w.startsWith("TSR")) {
				String[] word = w.split("\\+");

				sipmentTerm = word[1];
				if (word[1].equalsIgnoreCase("27"))
					traficServiceCode = "DD"; // fk_term
				else if (word[1].equalsIgnoreCase("28"))
					traficServiceCode = "DP";
				else if (word[1].equalsIgnoreCase("29"))
					traficServiceCode = "PD";
				else if (word[1].equalsIgnoreCase("30"))
					traficServiceCode = "PP";
				if (word[2].equalsIgnoreCase("2"))
					serviceOrigin = "FCL";
				else if (word[2].equalsIgnoreCase("3"))
					serviceOrigin = "LCL";

			}
			if (w.startsWith("MEA+AAE")) {
				String[] word = w.split("\\+");
				volume = word[3].replace("KGM:", "");
			}
			if (w.startsWith("NAD+ZZZ")) {
				String[] word = w.split("\\+");
				bookingParty = word[2].replace(":160:ZZZ", "");
			}

			if (w.startsWith("FTX")) {
				String[] word = w.split("\\+");

				// //uim.setTxtSubjectCode(word[1]);
				// //uim.setTxtLiteral(word[2]);
				// //uim.setFreTxtValue1(word[3]);
				// //uim.setFreTxtValue2(word[4]);
				// System.out.println(//uim.toString());

			}

			if (w.startsWith("TDT")) {
				String[] word = w.split("\\+");

				// //uim.setTransportCode(word[1]);
				// //uim.setTransportJourneyId(word[2]);
				// //uim.setTransportModeName(word[3]);
				// //uim.setCarrier(word[4]);
				// //uim.setCarrierIdentifier(word[5]);
				// //uim.setTransportId(word[6]);
				// //uim.setTransportIdName(word[7]);
				// //uim.setIdCode(word[8]);
				// 103 , ZZZ
				// //uim.setTransportIdVesselName(word[9]);

			}
			
			if (w.startsWith("NAD+CA")) {
				String[] word = w.split("\\+");
				// //uim.setAgent(word[2]);
				// //uim.setCustomerName(word[3]);
				// //uim.setCustomerCode(word[3]);

			}
			if (w.startsWith("NAD+BA")) {
				String[] word = w.split("\\+");
				// //uim.setAgent(word[2]);
				// //uim.setCustomerName(word[3]);
				// //uim.setCustomerCode(word[3]);

			}
			if (w.startsWith("NAD+CZ")) {
				String[] word = w.split("\\+");
				// uim.setAgent(word[2]);
				// uim.setCustomerName(word[3]);
				// uim.setCustomerCode(word[4]);

			}
			if (w.startsWith("NAD+CF")) {
				String[] word = w.split("\\+");
				// uim.setAgent(word[2]);
				// uim.setCustomerName(word[3]);
				// uim.setCustomerCode(word[4]);

			}
			if (w.startsWith("NAD+SF")) {
				String[] word = w.split("\\+");
				// uim.setAgent(word[2]);
				// uim.setCustomerName(word[3]);
				// uim.setCustomerCode(word[4]);
			}
			if (w.startsWith("GID")) {
				String[] word = w.split("\\+");
				// uim.setAgent(word[1]);
				// uim.setCustomerName(word[2]);
			}
			if (w.startsWith("FTX+AAA")) {
				String[] word = w.split("\\+");
				// uim.setTxtLtrl(word[2]);
				// uim.setTxtVal(word[3]);
				// uim.setCargoDescription(word[4]);
				cargoDescription = word[4];
			}
			if (w.startsWith("EQD")) {
				String[] word = w.split("\\+");
				// uim.setContainerType(word[1]);
				// uim.setContainerNo(word[2]);
				// uim.setFkBookingSizeTypeDetail(word[3]);
				// uim.setFkBookingSupplier(word[4]);
				// uim.setEqStatus(word[5]);
				// uim.setEqFullOrEmpt(word[6]);
			}
			if (w.startsWith("EQN")) {
				String[] word = w.split("\\+");
				// uim.setUnitQuantity(word[1]);
			}
			if (w.startsWith("UNT")) {
				String[] word = w.split("\\+");
				// uim.setNoSgmtsMsg(word[1]);
				// uim.setMsgRefNo(word[2]);
			}
			if (w.startsWith("UNZ")) {
				String[] word = w.split("\\+");
				// uim.setControlCount(word[1]);
				// uim.setControlRef(word[2]);

			}

		}

	}

	public static void updateDcsDataBaseForSI() throws IOException {
		FtpConfig ftfConfig = (FtpConfig) EZLBeanFactory.getBean("ftpConfig");
		/*
		 * String ip = ftfConfig.getIp(); String userId = ftfConfig.getUserId(); String
		 * password = ftfConfig.getPassword(); String shiipingOut =
		 * ftfConfig.getShiipingOut(); String outBackUp = ftfConfig.getOutBkupSI();
		 */
		String ip = EservicePropertyFatchOperation.ip;
		String userId = EservicePropertyFatchOperation.userId;
		String password = EservicePropertyFatchOperation.password;
		String shiipingOut = EservicePropertyFatchOperation.shiipingOut;
		String outBackUp = EservicePropertyFatchOperation.shiipingoutBackUp;
		String errorBackUp = EservicePropertyFatchOperation.shippingErrorOutBackUp;

		FTPClient client = new FTPClient();

		try {

			client.connect(ip);
			boolean login = client.login(userId, password);
			client.enterLocalPassiveMode();
			// client.connect("localhost");
			// boolean login = client.login("lenovo", "12345");
			if (login == true) {
				System.out.println("Successfully logged in!");
			} else {
				System.out.println("Login Fail!");
			}
			// client.changeWorkingDirectory("E:\\EDI");
			client.changeWorkingDirectory(shiipingOut);
			List<String> files = new ArrayList<>();

			FTPFile[] listOfFiles = client.listFiles();

			for (int i = 0; i < listOfFiles.length; i++) {
				if (listOfFiles[i].isFile()) {
					System.out.println("    " + listOfFiles[i].getName());
					files.add(listOfFiles[i].getName());
				}
			}
			client.disconnect();
			for (String file : files) {
				client.connect(ip);
				login = client.login(userId, password);
				
				client.enterLocalPassiveMode();

				// client.connect("localhost");
				// login = client.login("lenovo", "12345");

				client.changeWorkingDirectory(shiipingOut);

				InputStream inputStream = client.retrieveFileStream(file);
				Scanner sc = new Scanner(inputStream);

				// Reading the file line by line and printing the same
				String fileData = "";
				while (sc.hasNextLine()) {
					fileData += sc.nextLine();

				}
				reset();
				try {
				synchronized (fileData) {
					readFileForSI(fileData);
				}
				
				client.connect(ip);
				login = client.login(userId, password);
				
				if (login == true) {
					System.out.println("Successfully logged in for booking EDI  remove operation "+file);
				} else {
					System.out.println("Login Fail!  for booking EDI file remove operation "+file);
				}
				
				client.enterLocalPassiveMode();
				
				boolean b = client.rename(shiipingOut + file, outBackUp + file);

				if (b)
					System.out.println("  file moved successfully!  " + file);
				else
					System.out.println("  file not moved ! " + file);
				sc.close();
				inputStream.close();
				}catch (Exception e) {
					System.out.println("Remove Edi to Error Directory.");
					client.connect(ip);
					login = client.login(userId, password);
					
					if (login == true) {
						System.out.println("Successfully logged in for booking EDI Error remove operation "+file);
					} else {
						System.out.println("Login Fail!  for booking EDI file Error remove operation "+file);
					}
					
					client.enterLocalPassiveMode();
					
					boolean b = client.rename(shiipingOut + file, errorBackUp + file);

					if (b)
						System.out.println("  file moved Error successfully!  " + file);
					else
						System.out.println("  file not Error moved ! " + file);
					sc.close();
					inputStream.close();
					
				}
			}

			client.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				client.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void readFileForSI(String fileData) throws  Exception {
		System.out.println("Si EDI readIng Start.......");
		String esiMail 				= "";
		String add_mail 			= "";
		String vessel 				= "";
		String voyage 				= "";
		String remark 				= "";
		String qtnNo 				= "";
		String pol 					= "";
		String pod 					= "";
		String customerName 		= "";
		String customerCompany 		= "";
		int index 					= 0;
		String volume_temp 			= "";
		String userId 				= "";
		System.out.println("si get file called......" + fileData);
		// using Scanner class for large files, to read line by line
		try {
			readUsingScannerForSI(fileData);
		} catch (Exception e1) {
			System.out.println("Unable to read Si EDI... ");
			e1.printStackTrace();
			try {
				daoObjs = getAdminLoginDao();
				daoObjs.setEdiFileName(fileData);
				daoObjs.insertLogInLogSiTable(bookingNumberForSI, bLNum, userId, e1,
						AdminBookingLogDao.DAO_SI_CONFIRMED_ERROR);
			} catch (Exception e) {
				e.printStackTrace();
			}
			throw e1;
		}

		Connection connection = null;
		EserviceConnectionPostgra daoObj = (EserviceConnectionPostgra) EZLBeanFactory
				.getBeanSpringJdbc("eserviceConnectionPostgra");

		try {
			connection = daoObj.getConnectionObj();
			Statement statement = null;
			ResultSet resultSet = null;
			/*
			 * try (Connection connection =
			 * DriverManager.getConnection("jdbc:postgresql://10.24.238.205/sgdwebdb",
			 * "webapps", "ZMZmcksZKa3L25qC"))
			 */
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			String cuuntDate = dateFormat.format(date);

			int checkingBoooking = 0;

			String TYPE_OF_CANCEL_CHECK = "select count(*) BOOKING_AVAILABLE from SEALINER.BKP001 where babkno='"
					+ bookingNumberForSI + "' and (bastat='N' or bastat='R')";

			System.out.println("Checking cancel type : " + TYPE_OF_CANCEL_CHECK);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(TYPE_OF_CANCEL_CHECK);
			if (resultSet.next()) {
				checkingBoooking = resultSet.getInt("BOOKING_AVAILABLE");
			}
			resultSet.close();
			statement.close();

			if (checkingBoooking == 0) {
				if (statusSi.equals("O")) {
					System.out.println("EDI Confirm BL ......... ");

					statement = connection.createStatement();
					String sqlQry = "insert into BL_REVENUE (FK_BL_NO,DN_FRT_SUR_CODE,RATE,AMOUNT,AMOUNT_CURR,RATE_BASIS,desc_charge_code) values"
							+ "(" + ((bLNum == null || "".equals(bLNum)) ? null : "'" + bLNum + "'") + ","
							+ ((chargedCode == null || "".equals(chargedCode)) ? null : chargedCode) + ","
							+ ((rate == null || "".equals(rate)) ? null : rate) + ","
							+ ((ammount == null || "".equals(ammount)) ? null : ammount) + ","
							+ ((currnyType == null || "".equals(currnyType)) ? null : "'" + currnyType + "'") + ",'B',"
							+ ((descption == null || "".equals(descption)) ? null : "'" + descption + "'") + ");";
					System.out.println("sqlQry        " + sqlQry);
					int row = statement.executeUpdate(sqlQry);
					statement.close();

					statement = connection.createStatement();
					String sqlQryUpdate = "update	ESV_SI_HEADER set confirm_date = '" + cuuntDate + "', fk_bl_no = '"
							+ bLNum + "', special_status= 'C'," + "esi_status = 'C' where fk_booking_no='"
							+ bookingNumberForSI + "'";

					row += statement.executeUpdate(sqlQryUpdate);
					statement.close();

					System.out.println(" Row updated        " + row);
					try {
						String email_query = "select submit_by,email,add_emails,vessel_name,voyage_no,pol_name,pod_name,remarks,quotno from ESV_SI_HEADER where fk_booking_no='"
								+ bookingNumberForSI + "'";
						System.out.println("email_query : " + email_query);
						statement = connection.createStatement();
						resultSet = statement.executeQuery(email_query);
						while (resultSet.next()) {
							userId = resultSet.getString("submit_by");
							esiMail = resultSet.getString("email");
							pol = resultSet.getString("pol_name");
							pod = resultSet.getString("pod_name");
							vessel = resultSet.getString("vessel_name");
							voyage = resultSet.getString("voyage_no");
							remark = resultSet.getString("remarks");
							qtnNo = resultSet.getString("quotno");

							if (resultSet.getString("add_emails") != null
									&& !resultSet.getString("add_emails").equals("")) {
								add_mail += resultSet.getString("add_emails");
							}
						}
						statement.close();
						resultSet.close();

						String GET_CUSTOMER_QUERY = "Select b.CUSTOMER_NAME as company_name,a.user_name as user_name from esm_user_login a INNER JOIN CAM_CUSTOMER  b on"
								+ " a.ORG_CODE=b.PK_CUSTOMER_CODE  " + "  where a.user_id='" + userId + "' ";
						statement = connection.createStatement();
						resultSet = statement.executeQuery(GET_CUSTOMER_QUERY);
						while (resultSet.next()) {
							customerName = resultSet.getString("user_name");
							customerCompany = resultSet.getString("company_name");
						}
						statement.close();
						resultSet.close();

						String GET_VOLUME_QUERY = "select eq_type,eq_size,full_qty,special_handling from SEALINER.BOOKING_SUPPLIER_DETAIL where booking_no='"
								+ bookingNumberForSI + "' ";
						statement = connection.createStatement();
						resultSet = statement.executeQuery(GET_VOLUME_QUERY);
						while (resultSet.next()) {
							index++;
							String cargtype = "";
							if (resultSet.getString("special_handling").equals("N")) {
								cargtype = "Normal";
							} else if (resultSet.getString("special_handling").equals("NR")) {
								cargtype = "Non-Reefer";
							} else if (resultSet.getString("special_handling").equals("O0")) {
								cargtype = "OOG";
							} else if (resultSet.getString("special_handling").equals("OD")) {
								cargtype = "Open Door";
							} else if (resultSet.getString("special_handling").equals("D1")) {
								cargtype = "DG";
							} else if (resultSet.getString("special_handling").equals("DA")) {
								cargtype = "Door Ajar";
							}
							if (index == 1)
								volume_temp = resultSet.getString("full_qty") + " X " + resultSet.getString("eq_size")
										+ "" + resultSet.getString("eq_type") + "(Laden" + cargtype + ")";
							else
								volume_temp = volume_temp + " & " + resultSet.getString("full_qty") + " X "
										+ resultSet.getString("eq_size") + "" + resultSet.getString("eq_type")
										+ "(Laden -" + cargtype + ")";
						}
						statement.close();
						resultSet.close();

						EsiSubmissionMail model = new EsiSubmissionMail();
						System.out.println("mail id " + esiMail);
						System.out.println("add mail id " + add_mail);
						model.setBlNumber(bLNum);
						model.setBookingNo(bookingNumberForSI);
						model.setQuotation(qtnNo);
						model.setVessel(vessel);
						model.setVoyageNo(voyage);
						model.setRemarks(remark);
						model.setPol(pol);
						model.setPod(pod);
						model.setCustomerCompany(customerCompany);
						model.setCustomerName(customerName);
						model.setVolume(volume_temp);
						model.setMailId(esiMail);
						model.setAddMail(add_mail);

						EZLMail mail = (EZLMail) EZLBeanFactory.getBean("mailMail");
						mail.siConfirmationMail(model);

					} catch (Exception e) {
						System.out.println("exception on Si confirmation " + bookingNumberForSI);
						e.printStackTrace();
					}
				} else if (statusSi.equals("N")) {
					System.out.println("EDI Cancel BL ......... ");

					int sqnNoHrd = 0;
					String GET_SQN_NO = "select pk_hdr_seqno from ESV_SI_HEADER  WHERE FK_BOOKING_NO='"
							+ bookingNumberForSI + "'";
					statement = connection.createStatement();
					resultSet = statement.executeQuery(GET_SQN_NO);
					if (resultSet.next()) {
						sqnNoHrd = resultSet.getInt("pk_hdr_seqno");
					}
					resultSet.close();
					statement.close();

					String DELETE_FROM_ESV_SI_HEADER = "DELETE FROM ESV_SI_HEADER WHERE FK_BOOKING_NO='"
							+ bookingNumberForSI + "'";
					String REMOVE_FROM_ESV_SI_CON = "DELETE FROM ESV_SI_CONTAINERS con where con.fk_hdr_seqno="
							+ sqnNoHrd;
					String REOMVE_FROM_ESV_SI_COM = "DELETE FROM ESV_SI_COMMODITY comm where comm.fk_hdr_seqno="
							+ sqnNoHrd;
					String UPDATE_BOOKING_HRD = "UPDATE SEALINER.BKP001 SET BASTAT='C'  "
							+ "						   ,BKG_CONFRIM_DATE='" + cuuntDate + "' "
							+ "						   ,SPLSTATS='C'  " + "						   WHERE BABKNO= '"
							+ bookingNumberForSI + "'";

					System.out.println("1 DELETE_FROM_ESV_SI_HEADER " + DELETE_FROM_ESV_SI_HEADER);
					statement = connection.createStatement();
					int row = statement.executeUpdate(DELETE_FROM_ESV_SI_HEADER);
					statement.close();

					System.out.println("2 REMOVE_FROM_ESV_SI_CON " + REMOVE_FROM_ESV_SI_CON);
					statement = connection.createStatement();
					row = statement.executeUpdate(REMOVE_FROM_ESV_SI_CON);
					statement.close();

					System.out.println("3 REOMVE_FROM_ESV_SI_COM " + REOMVE_FROM_ESV_SI_COM);
					statement = connection.createStatement();
					row = statement.executeUpdate(REOMVE_FROM_ESV_SI_COM);
					statement.close();

					System.out.println("4 UPDATE_BOOKING_HRD " + UPDATE_BOOKING_HRD);
					statement = connection.createStatement();
					row = statement.executeUpdate(UPDATE_BOOKING_HRD);
					statement.close();
					try {
						String mailId = "";
						String additionalMail = "";

						String MAIL_ADDRESS = "select a.CALLER_EMAIL as MAIL ,b.ADDITIONAL_EMAILS as ADDITIONALMAIL from SEALINER.BKP001 a inner join ESV_WB_EXTEND b on a.babkno=b.PK_BOOKING_NO WHERE babkno='"
								+ bookingNumberForSI + "'";
						System.out.println("MAIL_ADDRESS si " + MAIL_ADDRESS);
						statement = connection.createStatement();
						resultSet = statement.executeQuery(MAIL_ADDRESS);
						if (resultSet.next()) {
							mailId = resultSet.getString("MAIL");
							additionalMail = resultSet.getString("ADDITIONALMAIL");
						}
						resultSet.close();
						statement.close();
						EZLMail mails = (EZLMail) EZLBeanFactory.getBean("mailMail");
						mails.siCancelationMail(bookingNumberForSI, bLNum, cuuntDate, mailId, additionalMail);
					} catch (Exception e) {
						System.out.println("exception on Si cancelation " + bookingNumberForSI);
						e.printStackTrace();
					}

				} else {
					System.out.println("Status not match Plz check the edi ..... ");
				}
				
				if(statusSi.equals("O")) {
					daoObjs = getAdminLoginDao();				 
					daoObjs.insertLogInLogSiTable(bookingNumberForSI,bLNum,userId,null,AdminBookingLogDao.DAO_SI_CONFIRMED);
				} else if(statusSi.equals("N")) {
					daoObjs = getAdminLoginDao();				 
					daoObjs.insertLogInLogSiTable(bookingNumberForSI,bLNum,userId,null,AdminBookingLogDao.DAO_SI_CANCELED);
				} 
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(statusSi.equals("O")) {
				daoObjs = getAdminLoginDao();				 
				daoObjs.insertLogInLogSiTable(bookingNumberForSI,bLNum,userId,e,AdminBookingLogDao.DAO_SI_CONFIRMED_ERROR);
			} else if(statusSi.equals("N")) {
				daoObjs = getAdminLoginDao();				 
				daoObjs.insertLogInLogSiTable(bookingNumberForSI,bLNum,userId,e,AdminBookingLogDao.DAO_SI_CANCELED_ERROR);
			} 
				
			throw e;
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private static void readUsingScannerForSI(String line) throws Exception {
		System.out.println("Eading started : "+ line);
		String[] words = line.split("'");// splits the string based on string

		// using java foreach loop to print elements of string array
		for (String w : words) {

			if (w.startsWith("RFF")) {
				String[] word = w.split("\\+");

				if (word[1].startsWith("BN")) {
					bookingNumberForSI = word[1].replace("BN:", "");

				}
			}

			if (w.startsWith("RFF")) {
				String[] word = w.split("\\+");

				if (word[1].startsWith("BM")) {
					bLNum = word[1].replace("BM:", "");
					System.out.println("BL " + bLNum);
				}

			}
			if (w.startsWith("BGM")) {
				String[] word = w.split("\\+");
				 
				if (word[3].equalsIgnoreCase("9")) // status ("Open"); confirm
					statusSi = "O";
				 else if (word[3].equalsIgnoreCase("1"))
					statusSi = "N"; // //uim.setFunctionCode("cancel"); cancel
				 else if(word[3].equalsIgnoreCase("4")) {
					 statusSi = "E"; 			//   Edit
					throw new Exception("Wrong Edi File status is 1");
				 }
			}
			if (w.startsWith("EQD")) {
				String[] word = w.split("\\+");
				String equpment = word[2];
				System.out.println("equpment   " + equpment);
			}
			if (w.startsWith("SEL")) {
				String[] word = w.split("\\+");
				String SealNumber = word[1];
				System.out.println("SealNumber   " + SealNumber);
			}

			if (w.startsWith("TCC")) {
				System.out.println("chargedCode   ");
				String[] word = w.split("\\+"); // FF:
				String chrgdCode[] = word[1].split(":");
				chargedCode = chrgdCode[1];
				descption = chrgdCode[3];
			} //
			if (w.startsWith("PRI")) {
				String[] word = w.split("\\+");
				rate = word[1].replace("CAL:", "");
				if (rate.contains("::")) {
					String rates[] = rate.split("::");
					rate = rates[0];

				}
			}
			if (w.startsWith("MOA")) {
				String[] word = w.split("\\+");
				String amunt = word[1].replace("64:", "");
				if (amunt.contains(":")) {
					String ammountAndCurrnyType[] = amunt.split(":");
					ammount = ammountAndCurrnyType[0];
					currnyType = ammountAndCurrnyType[1];
				}
			}
		}
	}

	public static void readFileSecond(String fileData) throws IOException, SQLException {

		System.out.println("readFileSecond() called....");
		// using Scanner class for large files, to read line by line
		try {
			readUsingScannerSecond(fileData);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("Read second job failed");
			throw new IOException();
		}
	}

	private static void readUsingScannerSecond(String line) throws IOException, SQLException {
		EserviceNewWebBookingUim uim = new EserviceNewWebBookingUim();
		int containerCount=0;
		uim.setPortOfLoading(pol);
		uim.setLine("R");
		uim.setTrade("*");
		uim.setAgent("***");
		uim.setSocCocUserFlag("C");
		boolean checkFoComdy = false;
		boolean checkFoEquipt = false;
		int i = 0;
		int j = 0;
		String dateNew = null;
		String time = null;
		String containerSizeType = "";
		boolean check = false;
		String supplyCode = "";
		int indexComdy = 1;
		List<EserviceEquipmentDetailsMod> equipmentDetailsList = new ArrayList<EserviceEquipmentDetailsMod>();
		List<EserviceCommodityDetailsMod> erviceCommodityDetailsList = new ArrayList<EserviceCommodityDetailsMod>();
		List<EserviceEquipmentDetailsMod> equipmentDetailsListTwo = new ArrayList<EserviceEquipmentDetailsMod>();
		Map<String, Integer> sizeTypMap = new HashMap<String, Integer>();
		Map<String, String> grossWaightMap = new HashMap<String, String>();
		Map<String, Integer> ledanSumMap = new HashMap<String, Integer>();
		Map<String, String> emptyDepo = new HashMap<String, String>();
		Map<String, String> emptyDepoDate = new HashMap<String, String>();
		String[] words = line.split("'");
		String special_handling_value="N";

		for (String w : words) {
			
			if (w.startsWith("UNB+UNOC")) {
				String[] word = w.split("\\+");

				String timeAndDate[] = word[4].split(":");
				dateNew = timeAndDate[0];
				time = timeAndDate[1];

			}

			if (w.startsWith("RFF+BN")) {
				String[] word = w.split("\\+");

				if (word[1].startsWith("BN")) {
					uim.setBookingNo(word[1].replace("BN:", ""));
				}
			}

			if (w.startsWith("RFF+SI")) {
				String[] word = w.split("\\+");

				if (word[1].startsWith("BM")) {
					uim.setBookingRef(word[1].replace("BM:", ""));
				}

			}
			if (w.startsWith("NAD+ZZZ")) {
				String[] word = w.split("\\+");
				String[] sc = word[2].split(":");
				supplyCode = sc[0];
				System.out.println("supplyCode   " + supplyCode);
			}

			if (w.startsWith("NAD+CZ")) {
				String[] word = w.split("\\+");
				String[] customerCode = word[2].split(":");
				uim.setCustomerName(word[4]);
				uim.setCustomerCode(customerCode[0]);

			}

			if (w.startsWith("GID")) {
				String[] word = w.split("\\+");
				checkFoComdy = true;
			}
			if (w.startsWith("FTX+AAI")) {
				String[] word = w.split("\\+");
				uim.setSpecialInstruction(word[2]);

			}
			if (w.startsWith("FTX+AAA")) {
				String[] word = w.split("\\+");
				uim.setCargoDescription(word[4]);
				EserviceCommodityDetailsMod com = new EserviceCommodityDetailsMod();
				com.setCode(word[3]);
				String grupCode = getGroupCode(word[3]);
				com.setGroup(grupCode);
				com.setDescription(word[4]);
				com.setSeqNo(indexComdy++);
				com.setSpecialInstruction(""); // need mapping
				com.setRateType("");
				erviceCommodityDetailsList.add(com);

			}

			if (w.startsWith("FRX+HAN")) {
				String[] word = w.split("\\+");
				uim.setSpecialInstruction(word[2]);

			}
			if (w.startsWith("MEA+AAE+G") && checkFoComdy) {

				String[] word = w.split("\\+");
				erviceCommodityDetailsList.get(j).setGrossWeight(word[3].replace("KGM:", ""));
				j++;
			}

			if (w.startsWith("EQD")) {
				checkFoComdy = false;
				String[] word = w.split("\\+");
				EserviceEquipmentDetailsMod eqn = new EserviceEquipmentDetailsMod();

				eqn.setEqNumber(word[2]); // container number
				containerSizeType = word[3].substring(0, 4);
				if (sizeTypMap.containsKey(containerSizeType)) {
					sizeTypMap.put(containerSizeType, sizeTypMap.get(containerSizeType) + 1);
				} else {
					sizeTypMap.put(containerSizeType, 1);
				}
				eqn.setSize(word[3].substring(0, 2));
				eqn.setType(word[3].substring(2, 4)); // ContainerType
				if (word[3].substring(word[3].length() - 1) == "4") {
					eqn.setMt(word[3].substring(word[3].length() - 1));
				} else {
					eqn.setLaden(word[3].substring(word[3].length() - 1)); // empty 4 ladan 5
				}
				equipmentDetailsList.add(eqn);

			}
			if (w.startsWith("EQN")) {
				String[] word = w.split("\\+");
				int sum = Integer.parseInt(word[1]);
				if (ledanSumMap.containsKey(containerSizeType)) {
					int lastVal = ledanSumMap.get(containerSizeType);
					lastVal = lastVal + sum;
					ledanSumMap.put(containerSizeType, lastVal);
				} else {
					ledanSumMap.put(containerSizeType, sum);
				}
				checkFoEquipt = true;
			}

			if (w.startsWith("MEA+AAE+G") && checkFoEquipt) {
				check = true;
				String[] word = w.split("\\+");
				equipmentDetailsList.get(containerCount).setGrossContainerWeight(word[3].replace("KGM:", ""));
				String groswaight = word[3].replace("KGM:", "");
				if (!grossWaightMap.containsKey(containerSizeType)) {
					grossWaightMap.put(containerSizeType, groswaight);
				}
				containerCount++;
			}
			if (w.startsWith("NAD+CK") && checkFoEquipt) {

				String[] word = w.split("\\+");

				if (!emptyDepo.containsKey(containerSizeType)) {
					String depo[] = word[3].split(":");
					emptyDepo.put(containerSizeType, depo[0]);
				}
			}
			if (w.startsWith("DTM+392:") && checkFoEquipt) {

				String[] word = w.split("\\+");

				if (!emptyDepoDate.containsKey(containerSizeType)) {
					emptyDepoDate.put(containerSizeType, word[1].replace("392:", "").replace(":102", ""));
				}
			}
			if (w.startsWith("DGS") && checkFoEquipt) {
				special_handling_value="D1";
			}
		}

		Set<String> eqptSet = sizeTypMap.keySet();
		int eqIndex = 1;
		for (String st : eqptSet) {
			EserviceEquipmentDetailsMod eqn = new EserviceEquipmentDetailsMod();
			eqn.setEqSeqNo(eqIndex);
			eqn.setSize(st.substring(0, 2));
			eqn.setType(st.substring(2, 4)); // ContainerType
			eqn.setLaden(String.valueOf(ledanSumMap.get(st)));
			eqn.setMt("0");
			eqn.setGrossContainerWeight(grossWaightMap.get(st));
			eqn.setCargoType(special_handling_value);  
			eqn.setSpecialCargo(""); // TODO Need to map
			eqn.setPodStatus("L"); // TODO Need to map
			eqn.setPolStatus("L"); // TODO Need to map
			eqn.setEqRecordStatus("");
			uim.setEmptyPickupDate(getDate(emptyDepoDate.get(st)));
			uim.setEmptyPickupDepot(emptyDepo.get(st));
			equipmentDetailsListTwo.add(eqn);
			eqIndex++;
		}

		System.out.println("commodity " + erviceCommodityDetailsList);
		System.out.println(" container org" + equipmentDetailsList);
		System.out.println(" container dupli " + equipmentDetailsListTwo);

		uim.setCommodityVoDataList(erviceCommodityDetailsList);

		uim.setEquipmentVoDataList(equipmentDetailsListTwo);
		if (dbConnection == null) {
			dbConnection = (EserviceNewWebBookingDaoImpl) EZLBeanFactory.getBeanSpringJdbc("EserviceNewWebBookingDao");
		}
		try {
			for (int k = 0; k < uim.getCommodityVoDataList().size(); k++) {
				EserviceCommodityDetailsMod mod = (EserviceCommodityDetailsMod) uim.getCommodityVoDataList().get(k);
				mod.setRecordStatus("ADD");
			}
			uim.setUserId(dbConnection.getUSerID(uim.getBookingNo()));
			dbConnection.saveEquipmentDetails(uim);
			dbConnection.saveCommodityDetails(uim);
			dbConnection.saveEquipmentBkgTable(equipmentDetailsList, uim.getBookingNo());
		} catch (Exception e) {
			System.out.println("containe and commodity update faild ..");
			e.printStackTrace();
		}
		System.out.println(uim.toString());
	}

	private static String getGroupCode(String code) {
		dbConnection = (EserviceNewWebBookingDaoImpl) EZLBeanFactory.getBeanSpringJdbc("EserviceNewWebBookingDao");
		String group = null;
		try {
			group = dbConnection.getCommodityGroupCode(code);
		} catch (Exception e) {
			System.out.print("getGroupCode( )" + e.toString());
		}
		return group;

	}

	public static String getDate(String s) {
		if (s != null && !(s.equals(" "))) {
			String dd = s.substring(6);
			String mm = s.substring(4, 6);
			String yy = s.substring(0, 4);
			return dd + "-" + mm + "-" + yy;
		} else
			return "";
	}
	public static void reset() {
		System.out.println("reset()          Start.......");
		bookingNumber = null;
		bookingNumberOld = null;
		vesselName = null;
		vesselNumber = null;
		voyage = null;
		date = null;
		customerContNumber = null;
		customerFaxNumber = null;
		customerEmail = null;
		traficServiceCode = null;
		confirmedDate = null;
		serviceOrigin = null;
		status = null;
		statusSi = null;
		por = null;
		del = null;
		toTerminal = null;
		fromTerminal = null;
		pol = null;
		pod = null;
		bookingDate = null;
		bookingParty = null;
		volume = null;
		arrivalDate = null;
		departureDate = null;
		cargoDescription = null;
		contractParty = null;
		specialInstructions = "";
		userName = null;
		sipmentTerm = null;
		checkLoc9 = "";
		checkLoc11 = "";
		loc9132 = null;
		loc9133 = null;
		loc11132 = null;
		loc11133 = null;
		checkTDT20 = false;
		checkTDT30 = false;
		pot1 = null;
		pot2 = null;
		pot3 = null;
		chargedCode = null;
		bLNum = null;
		descption = null;
		ammount = null;
		currnyType = null;
		rate = null;
		bookingNumberForSI = null;
		vesselNumber1 = null;
		vesselName1 = null;
		voyage1 = null;
		vesselNumber2 = null;
		vesselName2 = null;
		voyage2 = null;
		vesselNumber3 = null;
		vesselName3 = null;
		voyage3 = null;
		qtnNo = null;
	}
	
	public static void cancelMail(String bookingNo,String BookingRef,String BLno,String date,String type,String mail,String additionalMail) {
		System.out.println("cancelMail() is called ....... ");
		System.out.println("mail "+mail);
		System.out.println("additionalMail "+additionalMail);
		
	}
	
	 private static AdminBookingLogDao getAdminLoginDao() {
	    	AdminBookingLogDao dao = null;
	        try{
	            dao = (AdminBookingLogDao) EZLBeanFactory.getBeanSpringJdbc(AdminBookingLogDao.DAO_NAME);
	        } catch(Exception ex){
	             
	        }
	        return dao;
	    }

	 
	
	
}