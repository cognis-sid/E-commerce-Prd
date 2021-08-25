package com.rclgroup.dolphin.rcl.web.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


import com.rclgroup.dolphin.rcl.web.eservice.action.EservicePropertyFatchOperation;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.actionform.EshippingInstructionUim;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EserviceNewWebBookingDao;
import com.rclgroup.dolphin.rcl.web.eservice.dao.EshippingInstructionDao;
import com.rclgroup.dolphin.rcl.web.eservice.vo.CustomerMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceEquipmentDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCargoDescriptionMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EshippingCommodityDetailsMod;

public class Utilis {
	public static CustomerMod custmer;

	public static String generateBookingXmlFile(EserviceNewWebBookingUim uim, EserviceNewWebBookingDao objDao,
			String cutomeNmae)throws Exception {

		System.out.println("****  Generating XML File for Booking "+uim.getBookingRef()+" ****");
		System.out.println("uim   " + uim.toString());
		getCustomerDetailes(uim.getCustomerCode(), objDao);
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		StreamResult console = null;
		StreamResult file = null;
		String checkDG = null;
		String partyCode;
		// Org
		String checkBokRepresentedCompanyValue = uim.getRepresentCompChkBox();
		if (checkBokRepresentedCompanyValue.equalsIgnoreCase("Y")) {
			getCustomerDetailes(uim.getRepresentComp(), objDao);
			partyCode = uim.getRepresentComp();

		} else {
			partyCode = uim.getCustomerCode();
		}
		int count = 0;
		String comdyCode = "999990";
		try {
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.newDocument();
			Element mainRootElement = doc.createElement("EDI_TRANSACTION_HEADER");

			doc.appendChild(mainRootElement);

			String functionCode = "9"; // 9= for new page

			if (uim.getStatus().equals("N"))
				functionCode = "1"; // 1 cancel page

			if (uim.getStatus().equals("Confirmed"))
				functionCode = "4"; // 4 edit page

			// append child elements to root element
			mainRootElement.appendChild(getChildNode(doc, "MSG_REFERENCE", "AP1811KJ088PAT"));
			mainRootElement.appendChild(getChildNode(doc, "MESSAGE_CODE", "IFTMBF"));
			mainRootElement.appendChild(getChildNode(doc, "MSG_VERSION", "00A"));
			mainRootElement.appendChild(getChildNode(doc, "API_CODE", "BOOK_IN"));
			mainRootElement.appendChild(getChildNode(doc, "DIRECTION", "IN"));
			mainRootElement.appendChild(getChildNode(doc, "SENDER_ID", "RCLEBOOKING")); // commented by durai to keep
																						// hard code
			mainRootElement.appendChild(getChildNode(doc, "RECEIVER_ID", "DCS")); // commented by durai keep hard code
			mainRootElement.appendChild(getChildNode(doc, "ACKNOWLEDGE", ""));
			mainRootElement.appendChild(getChildNode(doc, "TEST_INDICATOR", ""));
			mainRootElement.appendChild(getChildNode(doc, "INTF_CONTROL_NO", ""));
			mainRootElement.appendChild(getChildNode(doc, "FILE_NAME", ""));
			mainRootElement.appendChild(getChildNode(doc, "MODULE", "BOOKING"));

			// for total equipment
			List<EserviceEquipmentDetailsMod> equipmentVoList = new ArrayList<EserviceEquipmentDetailsMod>();
			equipmentVoList = uim.getEquipmentVoDataList();

			int totalEquipment = equipmentVoList.size();
			double  totalGrosWeight = 0.0;
			double  totalGrosWeights = 0.0;
			String sum = "";

			for (EserviceEquipmentDetailsMod equipmentVo : equipmentVoList) { // 20,000.00
				System.out.println(equipmentVo.getGrossContainerWeight());
				sum = replaceComma(equipmentVo.getGrossContainerWeight());
				if (sum.equals(""))
					sum = "0";
				totalGrosWeight = Double.parseDouble(sum);
				totalGrosWeights = totalGrosWeight + totalGrosWeights;
			}
				
			Element mainRootElement1 = doc.createElement("EDI_ST_DOC_HEADER");
			mainRootElement.appendChild(mainRootElement1);
			mainRootElement1.appendChild(getChildNode(doc, "DOCUMENT_ID", ""));
			mainRootElement1.appendChild(getChildNode(doc, "DOCUMENT_TYPE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "DOCUMENT_STATUS", ""));
			mainRootElement1.appendChild(getChildNode(doc, "DOCUMENT_DATE", getDate()));

			// if(uim.getStatus()==)
			mainRootElement1.appendChild(getChildNode(doc, "FUNCTION_CODE", functionCode));
			mainRootElement1.appendChild(getChildNode(doc, "SERVICE_ORIGIN", "2"));
			mainRootElement1.appendChild(getChildNode(doc, "SERVICE_DESTINATION", ""));
			mainRootElement1.appendChild(getChildNode(doc, "TARIFF_SERVICE_CODE", isNull(uim.getShipmentTerm())));
			mainRootElement1.appendChild(getChildNode(doc, "NUMBER_COPIES", ""));
			mainRootElement1.appendChild(getChildNode(doc, "NUMBER_ORIGINALS", ""));
			mainRootElement1.appendChild(getChildNode(doc, "TOTAL_GROSS_WEIGHT", String.valueOf(totalGrosWeights)));
			mainRootElement1.appendChild(getChildNode(doc, "GROSS_WEIGHT_UOM", "KGM"));
			mainRootElement1.appendChild(getChildNode(doc, "TOTAL_VOLUME", ""));
			mainRootElement1.appendChild(getChildNode(doc, "VOLUME_UOM", "MTQ"));
			mainRootElement1.appendChild(getChildNode(doc, "TOTAL_EQUIPMENT", String.valueOf(totalEquipment)));
			mainRootElement1.appendChild(getChildNode(doc, "EQUIPMENT_TYPE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "TOTAL_PACKAGES", ""));
			mainRootElement1.appendChild(getChildNode(doc, "PACKAGE_TYPE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "PAYMENT_TERMS", ""));
			mainRootElement1.appendChild(getChildNode(doc, "PREPAID_TOTAL", ""));
			mainRootElement1.appendChild(getChildNode(doc, "PREPAID_CCY", ""));
			mainRootElement1.appendChild(getChildNode(doc, "COLLECT_TOTAL", ""));
			mainRootElement1.appendChild(getChildNode(doc, "COLLECT_CCY", ""));
			mainRootElement1.appendChild(getChildNode(doc, "SHIPMENT_VALUE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "INSURED_VALUE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "CUSTOMS_VALUE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "VALUE_CCY", ""));
			mainRootElement1.appendChild(getChildNode(doc, "AGENT", ""));

			Element mainRootElement2 = doc.createElement("EDI_ST_DOC_REFERENCE");
			mainRootElement1.appendChild(mainRootElement2);
			mainRootElement2.appendChild(getChildNode(doc, "REFERENCE_TYPE", "ZZZ")); // qualifier
			if (functionCode.equals("4") || functionCode.equals("1")) {
				mainRootElement2.appendChild(getChildNode(doc, "REFERENCE", isNull(uim.getBookingRef())));
			} else {
				mainRootElement2.appendChild(getChildNode(doc, "REFERENCE", isNull(uim.getBookingNo())));
			}

			if (uim.getTemplateFlag() != null && !uim.getTemplateFlag().equals("")) {
				Element mainRootElement55 = doc.createElement("EDI_ST_DOC_REFERENCE");
				mainRootElement1.appendChild(mainRootElement55);
				mainRootElement55.appendChild(getChildNode(doc, "REFERENCE_TYPE", "BKG")); // qualifier
				mainRootElement55.appendChild(getChildNode(doc, "REFERENCE", ""));
			}
			if (!uim.getCustomerReference().equals("") && uim.getCustomerReference() != null) {
				Element mainRootElement3 = doc.createElement("EDI_ST_DOC_REFERENCE");
				mainRootElement1.appendChild(mainRootElement3);

				mainRootElement3.appendChild(getChildNode(doc, "REFERENCE_TYPE", "SI")); // qualifier
				mainRootElement3.appendChild(getChildNode(doc, "REFERENCE", isNull(uim.getCustomerReference())));
			}

			if (!uim.getQuotationNumber().equals("") && uim.getQuotationNumber() != null) {
				Element mainRootElement31 = doc.createElement("EDI_ST_DOC_REFERENCE");
				mainRootElement1.appendChild(mainRootElement31);
				mainRootElement31.appendChild(getChildNode(doc, "REFERENCE_TYPE", "QTN")); // qualifier
				mainRootElement31.appendChild(getChildNode(doc, "REFERENCE", isNull(uim.getQuotationNumber())));
			}

			if (functionCode.equals("4") || functionCode.equals("1")) {
				Element mainRootElement312 = doc.createElement("EDI_ST_DOC_REFERENCE");
				mainRootElement1.appendChild(mainRootElement312);
				mainRootElement312.appendChild(getChildNode(doc, "REFERENCE_TYPE", "BN")); // qualifier
				mainRootElement312.appendChild(getChildNode(doc, "REFERENCE", isNull(uim.getBookingNo())));
			}
			
			Element mainRootElement4 = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement1.appendChild(mainRootElement4);
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_TYPE", "88")); // qualifier
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPlaceOfReceipt()))); //
			mainRootElement4.appendChild(
					getChildNode(doc, "LOCATION_NAME", isNull(getPointContry(uim.getPlaceOfReceipt(), objDao))));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", isNull(uim.getEmptyPickupDepot())));// "LOCATION_SUB_CODE",
																												// isNull(uim.getToTerminal())));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement4.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			Element mainRootElement5 = doc.createElement("EDI_ST_DOC_DATE");
			mainRootElement1.appendChild(mainRootElement5);
			mainRootElement5.appendChild(getChildNode(doc, "DATE_TYPE", "137")); // qualifier
			mainRootElement5.appendChild(getChildNode(doc, "ACTIVITY_DATE", getDate())); // current date

			Element mainRootElement8N = doc.createElement("EDI_ST_DOC_DATE");
			mainRootElement1.appendChild(mainRootElement8N);

			if (functionCode.equals("1")) {
				mainRootElement8N.appendChild(getChildNode(doc, "DATE_TYPE", "200")); // qualifier
				mainRootElement8N.appendChild(
						getChildNode(doc, "ACTIVITY_DATE", isNull(getDateYYYYMMDD(uim.getEmptyPickupDate())))); // current
																												// date
			} else {
				mainRootElement8N.appendChild(getChildNode(doc, "DATE_TYPE", "200")); // qualifier
				mainRootElement8N.appendChild(
						getChildNode(doc, "ACTIVITY_DATE", isNull(getDateYYYYMMDDDif(uim.getEmptyPickupDate())))); // current
																													// date
			}

			Element mainRootElement7N = doc.createElement("EDI_ST_DOC_DATE");
			mainRootElement1.appendChild(mainRootElement7N);
			if (functionCode.equals("1")) {
				mainRootElement7N.appendChild(getChildNode(doc, "DATE_TYPE", "181")); // qualifier
				mainRootElement7N.appendChild(
						getChildNode(doc, "ACTIVITY_DATE", isNull(getDateYYYYMMDD(uim.getShipmentDate())))); // current
																												// date
			} else {
				mainRootElement7N.appendChild(getChildNode(doc, "DATE_TYPE", "181")); // qualifier
				mainRootElement7N.appendChild(
						getChildNode(doc, "ACTIVITY_DATE", isNull(getDateYYYYMMDDDif(uim.getShipmentDate())))); // current
																												// date
			}

			List<EserviceEquipmentDetailsMod> equipmentVoDataList = new ArrayList<EserviceEquipmentDetailsMod>();
			equipmentVoDataList = uim.getEquipmentVoDataList();

			for (EserviceEquipmentDetailsMod eqpmtObj : equipmentVoDataList) {
				Element mainRootElement6 = doc.createElement("EDI_ST_DOC_EQUIPMENT");
				mainRootElement1.appendChild(mainRootElement6);
				mainRootElement6.appendChild(getChildNode(doc, "EQUIPMENT_TYPE", "CN")); // -- must be CN; here CN
																							// refers container
				mainRootElement6.appendChild(getChildNode(doc, "EQUIPMENT_NO", "")); // during booking, equipment number
																						// must be blank (by durani)
				mainRootElement6.appendChild(
						getChildNode(doc, "EQUIPMENT_SIZE_TYPE", isNull(eqpmtObj.getSize() + eqpmtObj.getType())));
				mainRootElement6
						.appendChild(getChildNode(doc, "TYPE_DESCRIPTION", isNull(eqpmtObj.getCargoDescription())));
				mainRootElement6.appendChild(getChildNode(doc, "EQUIPMENT_SUPPLIER", isNull(uim.getSocCocUserFlag())));
				mainRootElement6.appendChild(getChildNode(doc, "EQUIPMENT_STATUS", "")); /// isNull(eqpmtObj.getEqRecordStatus())));
				mainRootElement6.appendChild(getChildNode(doc, "EQUIPMENT_FULL_EMPTY", ""));
				mainRootElement6.appendChild(
						getChildNode(doc, "GROSS_WEIGHT", replaceComma(isNull(eqpmtObj.getGrossContainerWeight())))); // isNull(eqpmtObj.getGrossContainerWeight())));
				mainRootElement6.appendChild(getChildNode(doc, "GROSS_WEIGHT_UOM", ""));
				mainRootElement6.appendChild(getChildNode(doc, "VOLUME", ""));
				mainRootElement6.appendChild(getChildNode(doc, "VOLUME_UOM", ""));
				mainRootElement6.appendChild(getChildNode(doc, "LENGTH_UOM", ""));
				mainRootElement6.appendChild(getChildNode(doc, "OVERLENGTH_FRONT", ""));
				mainRootElement6.appendChild(getChildNode(doc, "OVERHEIGHT", ""));
				mainRootElement6.appendChild(getChildNode(doc, "OVERWIDTH_LEFT", ""));
				mainRootElement6.appendChild(getChildNode(doc, "OVERWIDTH_RIGHT", ""));
				mainRootElement6.appendChild(getChildNode(doc, "OVERLENGTH_BACK", ""));
				mainRootElement6.appendChild(getChildNode(doc, "TEMPERATURE", ""));
				mainRootElement6.appendChild(getChildNode(doc, "TEMPERATURE_MIN", ""));
				mainRootElement6.appendChild(getChildNode(doc, "TEMPERATURE_MAX", ""));
				mainRootElement6.appendChild(getChildNode(doc, "TEMPERATURE_UOM", ""));
				mainRootElement6.appendChild(getChildNode(doc, "SEAL_NUMBER_SH", ""));
				mainRootElement6.appendChild(getChildNode(doc, "SEAL_NUMBER_TO", ""));
				mainRootElement6.appendChild(getChildNode(doc, "SEAL_NUMBER_CA", ""));
				mainRootElement6.appendChild(getChildNode(doc, "SEAL_NUMBER_CU", ""));
				mainRootElement6.appendChild(getChildNode(doc, "VENT_SETTING", ""));
				mainRootElement6.appendChild(getChildNode(doc, "HUMIDITY", ""));
				mainRootElement6.appendChild(getChildNode(doc, "AIR_EXCHANGE", ""));

				// for DG Dangerous goods
				String hazardous = "N";
				if (eqpmtObj.getCargoType() == "Y")
					hazardous = "Y";
				mainRootElement6.appendChild(getChildNode(doc, "HAZARDOUS", isNull(hazardous)));
				mainRootElement6.appendChild(getChildNode(doc, "PIECE_COUNT", isNull(eqpmtObj.getLaden())));
				mainRootElement6.appendChild(getChildNode(doc, "PACKAGE_TYPE", ""));
				mainRootElement6.appendChild(getChildNode(doc, "NATURE_OF_CARGO", isNull(eqpmtObj.getSpecialCargo())));
				mainRootElement6.appendChild(getChildNode(doc, "MOVEMENT_TYPE", ""));
				mainRootElement6.appendChild(getChildNode(doc, "HAULAGE_ARRANGEMENT", ""));

			}

			Element mainRootElement7 = doc.createElement("EDI_ST_DOC_JOURNEY");
			mainRootElement1.appendChild(mainRootElement7);
			mainRootElement7.appendChild(getChildNode(doc, "TRANSPORT_STAGE", "20"));
			mainRootElement7.appendChild(getChildNode(doc, "CONVEYANCE_REFERENCE", isNull(uim.getVoyage()))); // isNull(uim.getVoyage())));
			mainRootElement7.appendChild(getChildNode(doc, "TRANSPORT_MODE", "1"));
			mainRootElement7.appendChild(getChildNode(doc, "TRANSPORT_MEANS", ""));
			mainRootElement7.appendChild(getChildNode(doc, "CARRIER_CODE", ""));
			mainRootElement7.appendChild(getChildNode(doc, "CARRIER_NAME", ""));
			mainRootElement7.appendChild(getChildNode(doc, "CONVEYANCE_CODE", isNull(uim.getVessel())));     //isNull(uim.getVessel())
			mainRootElement7.appendChild(getChildNode(doc, "CONVEYANCE_NAME", isNull(uim.getVesselName()))); // isNull(uim.getVesselName())));
			mainRootElement7.appendChild(getChildNode(doc, "CONVEYANCE_NATIONALITY", ""));
			mainRootElement7.appendChild(getChildNode(doc, "DIRECTION", ""));
			mainRootElement7.appendChild(getChildNode(doc, "SERVICE", isNull(uim.getService()))); // isNull(uim.getService())));
			mainRootElement7.appendChild(getChildNode(doc, "SHIP_CALL_NO", ""));
			// -----------------------------------------------------------------------------
			// SUB child element in EDI_ST_DOC_JOURNEY
			Element mainRootElement1A = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement7.appendChild(mainRootElement1A);
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_TYPE", "7"));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPlaceOfDelivery())));
			mainRootElement1A.appendChild(
					getChildNode(doc, "LOCATION_NAME", isNull(getPointContry(uim.getPlaceOfDelivery(), objDao))));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", isNull(uim.getToTerminal())));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));
			
			Element mainRootElement7D = doc.createElement("EDI_ST_DOC_DATE");
			mainRootElement1A.appendChild(mainRootElement7D);
			mainRootElement7D.appendChild(getChildNode(doc, "DATE_TYPE", "132")); // qualifier
			mainRootElement7D.appendChild(getChildNode(doc, "ACTIVITY_DATE", isNull(getDateYYYYMMDD(uim.getDesiredArrivalDate())))); //Desired Arrival Date

			Element mainRootElement1B = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement7.appendChild(mainRootElement1B);
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_TYPE", "9"));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPortOfLoading())));
			mainRootElement1B
					.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(getContry(uim.getPortOfLoading(), objDao))));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", isNull(uim.getFromTerminal())));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			// SUB child No 02 element in EDI_ST_DOC_JOURNEY
			Element mainRootElement2A = doc.createElement("EDI_ST_DOC_DATE");
			mainRootElement1B.appendChild(mainRootElement2A);
			if (functionCode.equals("1")) {
				mainRootElement2A.appendChild(getChildNode(doc, "DATE_TYPE", "133")); // qualifier
				mainRootElement2A
						.appendChild(getChildNode(doc, "ACTIVITY_DATE", isNull(getDateYYYYMMDD(uim.getSailingDate())))); // come
			} else if (functionCode.equals("4")) {
				mainRootElement2A.appendChild(getChildNode(doc, "DATE_TYPE", "133")); // qualifier
				mainRootElement2A.appendChild(
						getChildNode(doc, "ACTIVITY_DATE", isNull(getDateYYYYMMDDDif(uim.getSailingDate())))); // come
			} else {
				mainRootElement2A.appendChild(getChildNode(doc, "DATE_TYPE", "133")); // qualifier
				mainRootElement2A
						.appendChild(getChildNode(doc, "ACTIVITY_DATE", isNull(getDateYYYYMMDD(uim.getEtd())))); // come
			} /* from
			    API
			    ("ESTIMATED_TIME_DEP") */

			Element mainRootElement1C = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement7.appendChild(mainRootElement1C);
			mainRootElement1C.appendChild(getChildNode(doc, "LOCATION_TYPE", "11")); // qualifier
			mainRootElement1C.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getToLocation())));
			mainRootElement1C
					.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(getContry(uim.getToLocation(), objDao))));
			mainRootElement1C.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement1C.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement1C.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement1C.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", isNull(uim.getTo())));
			mainRootElement1C.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			if(checkPort1(uim.getToLocation(),uim.getPortOfDischarge())) {
				mainRootElement1C.appendChild(getChildNode(doc, "ACTIVITY_CODE", "T"));
			}else {
				mainRootElement1C.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));
			}
			List<EserviceCommodityDetailsMod> eserviceCommodityDetailsMod = new ArrayList<EserviceCommodityDetailsMod>();
			eserviceCommodityDetailsMod = uim.getCommodityVoDataList();

			for (EserviceCommodityDetailsMod comdtyObj : eserviceCommodityDetailsMod) {
				Element mainRootElement8 = doc.createElement("EDI_ST_DOC_COMMODITY");
				mainRootElement1.appendChild(mainRootElement8);
				mainRootElement8.appendChild(getChildNode(doc, "PACKAGE_TYPE", "PK")); // will be hard coded
				mainRootElement8.appendChild(getChildNode(doc, "PIECE_COUNT", ""));

				mainRootElement8
						.appendChild(getChildNode(doc, "COMMODITY", getCommodityCode(comdtyObj.getGroup(), objDao))); // will
																														// be
																														// hard
																														// coded
				mainRootElement8.appendChild(getChildNode(doc, "DESCRIPTION", isNull(comdtyObj.getDescription()))); // need

				/*
				 * comdyCode = comdtyObj.getGroup(); comdyCode = comdyCode.replaceAll("[^\\d]",
				 * "");
				 */
				// revisit
				mainRootElement8.appendChild(getChildNode(doc, "GROSS_WEIGHT",
						replaceComma(isNull(comdtyObj.getGrossWeight().replace(",", "")))));
				mainRootElement8.appendChild(getChildNode(doc, "WEIGHT_UOM", "KGM")); // will be hard coded
				mainRootElement8.appendChild(getChildNode(doc, "VOLUME", ""));
				mainRootElement8.appendChild(getChildNode(doc, "VOLUME_UOM", "CBM")); // will be hard coded
				mainRootElement8.appendChild(getChildNode(doc, "LENGTH", ""));
				mainRootElement8.appendChild(getChildNode(doc, "WIDTH", ""));
				mainRootElement8.appendChild(getChildNode(doc, "HEIGHT", ""));
				mainRootElement8.appendChild(getChildNode(doc, "LENGTH_UOM", ""));
				mainRootElement8.appendChild(getChildNode(doc, "MOVEMENT_TYPE", ""));
				mainRootElement8.appendChild(getChildNode(doc, "HAULAGE_ARRANGEMENTS", ""));

				// SUB child element in EDI_ST_DOC_COMMODITY
				Element mainRootElement3A = doc.createElement("EDI_ST_DOC_TEXT");
				mainRootElement8.appendChild(mainRootElement3A);
				mainRootElement3A.appendChild(getChildNode(doc, "TEXT_TYPE", "AAA")); // Qualifier
				mainRootElement3A.appendChild(getChildNode(doc, "DESCRIPTION", isNull(comdtyObj.getDescription())));
				mainRootElement3A.appendChild(getChildNode(doc, "TEXT_CODE", ""));

				// In case Dangerous good
				if (comdtyObj.getRateType().equals("D1")) {
					if(comdtyObj.getEserviceDGCommoditiesUim()!=null) {
						Element mainRootElement3AA = doc.createElement("EDI_ST_DOC_HAZARD");
						mainRootElement8.appendChild(mainRootElement3AA);
						mainRootElement3AA.appendChild(getChildNode(doc, "PACKING_GROUP", "")); // Qualifier
						mainRootElement3AA.appendChild(getChildNode(doc, "HAZ_MAT_CODE", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "HAZ_MAT_CLASS", isNull(comdtyObj.getEserviceDGCommoditiesUim().getImdgClass())));
						mainRootElement3AA.appendChild(getChildNode(doc, "HAZ_MAT_SUB_CLASS", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "UNDG_NUMBER", isNull(comdtyObj.getEserviceDGCommoditiesUim().getUnNo())));
						mainRootElement3AA.appendChild(getChildNode(doc, "MFAG_PAGE", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "EMS_PAGE", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "MARINE_POLLUTANT", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "RESIDUE", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "LIMITED_QUANTITY", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "REPORT_QUANTITY", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "FLASHPOINT", isNull(comdtyObj.getEserviceDGCommoditiesUim().getFlashPoint())));
						mainRootElement3AA.appendChild(getChildNode(doc, "TEMPERATURE_UOM", isNull(comdtyObj.getEserviceDGCommoditiesUim().getUnitMeasurement())));
						mainRootElement3AA.appendChild(getChildNode(doc, "EXPLOSIVE_CONTENT", ""));// must be 999990; not 1
																									// (by
						// durani)

						Element mainRootElement3BB = doc.createElement("EDI_ST_DOC_TEXT");
						mainRootElement3AA.appendChild(mainRootElement3BB);
						mainRootElement3BB.appendChild(getChildNode(doc, "TEXT_TYPE", "AAD")); // Qualifier
						mainRootElement3BB.appendChild(getChildNode(doc, "DESCRIPTION", ""));
						mainRootElement3BB.appendChild(getChildNode(doc, "TEXT_CODE", ""));

						Element mainRootElement3CC = doc.createElement("EDI_ST_DOC_TEXT");
						mainRootElement3AA.appendChild(mainRootElement3CC);
						mainRootElement3CC.appendChild(getChildNode(doc, "TEXT_TYPE", "ACB")); // Qualifier
						mainRootElement3CC.appendChild(getChildNode(doc, "DESCRIPTION", ""));
						mainRootElement3CC.appendChild(getChildNode(doc, "TEXT_CODE", ""));
					}else {
						Element mainRootElement3AA = doc.createElement("EDI_ST_DOC_HAZARD");
						mainRootElement8.appendChild(mainRootElement3AA);
						mainRootElement3AA.appendChild(getChildNode(doc, "PACKING_GROUP", "")); // Qualifier
						mainRootElement3AA.appendChild(getChildNode(doc, "HAZ_MAT_CODE", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "HAZ_MAT_CLASS", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "HAZ_MAT_SUB_CLASS", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "UNDG_NUMBER", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "MFAG_PAGE", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "EMS_PAGE", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "MARINE_POLLUTANT", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "RESIDUE", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "LIMITED_QUANTITY", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "REPORT_QUANTITY", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "FLASHPOINT", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "TEMPERATURE_UOM", ""));
						mainRootElement3AA.appendChild(getChildNode(doc, "EXPLOSIVE_CONTENT", ""));// must be 999990; not 1
																									// (by
						// durani)

						Element mainRootElement3BB = doc.createElement("EDI_ST_DOC_TEXT");
						mainRootElement3AA.appendChild(mainRootElement3BB);
						mainRootElement3BB.appendChild(getChildNode(doc, "TEXT_TYPE", "AAD")); // Qualifier
						mainRootElement3BB.appendChild(getChildNode(doc, "DESCRIPTION", ""));
						mainRootElement3BB.appendChild(getChildNode(doc, "TEXT_CODE", ""));

						Element mainRootElement3CC = doc.createElement("EDI_ST_DOC_TEXT");
						mainRootElement3AA.appendChild(mainRootElement3CC);
						mainRootElement3CC.appendChild(getChildNode(doc, "TEXT_TYPE", "ACB")); // Qualifier
						mainRootElement3CC.appendChild(getChildNode(doc, "DESCRIPTION", ""));
						mainRootElement3CC.appendChild(getChildNode(doc, "TEXT_CODE", ""));
					}
					
				}
				String comGro = comdtyObj.getRateType();
				// for (EserviceEquipmentDetailsMod eqpmtObj : equipmentVoDataList) {
				for (int i = 0; i < equipmentVoDataList.size(); i++) {
					String equGro = equipmentVoDataList.get(i).getCargoType();
					if (equGro.equals(comGro)) {
						Element mainRootElement3B = doc.createElement("EDI_ST_DOC_EQUIPMENT");
						mainRootElement8.appendChild(mainRootElement3B);
						mainRootElement3B.appendChild(getChildNode(doc, "EQUIPMENT_TYPE", "CN"));
						mainRootElement3B.appendChild(getChildNode(doc, "EQUIPMENT_NO", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "EQUIPMENT_SIZE_TYPE",
								isNull(equipmentVoDataList.get(i).getSize() + equipmentVoDataList.get(i).getType())));
						mainRootElement3B.appendChild(getChildNode(doc, "TYPE_DESCRIPTION",
								isNull(equipmentVoDataList.get(i).getCargoDescription())));
						mainRootElement3B
								.appendChild(getChildNode(doc, "EQUIPMENT_SUPPLIER", isNull(uim.getSocCocUserFlag())));
						mainRootElement3B.appendChild(getChildNode(doc, "EQUIPMENT_STATUS", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "EQUIPMENT_FULL_EMPTY", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "GROSS_WEIGHT",
								replaceComma(isNull(equipmentVoDataList.get(i).getGrossContainerWeight()))));
						mainRootElement3B.appendChild(getChildNode(doc, "GROSS_WEIGHT_UOM", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "VOLUME", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "VOLUME_UOM", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "LENGTH_UOM", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "OVERLENGTH_FRONT", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "OVERHEIGHT", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "OVERWIDTH_LEFT", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "OVERWIDTH_RIGHT", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "OVERLENGTH_BACK", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "TEMPERATURE", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "TEMPERATURE_MIN", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "TEMPERATURE_MAX", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "TEMPERATURE_UOM", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "SEAL_NUMBER_SH", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "SEAL_NUMBER_TO", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "SEAL_NUMBER_CA", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "SEAL_NUMBER_CU", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "VENT_SETTING", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "HUMIDITY", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "AIR_EXCHANGE", ""));

						// for DG Dangerous goods
						String hazardous = "N";
						if (equipmentVoDataList.get(i).getCargoType() == "Y"
								|| equipmentVoDataList.get(i).getCargoType() == "D1")
							hazardous = "Y";
						mainRootElement3B.appendChild(getChildNode(doc, "HAZARDOUS", isNull(hazardous))); // Y for DG
																											// for other
																											// N
						mainRootElement3B.appendChild(
								getChildNode(doc, "PIECE_COUNT", isNull(equipmentVoDataList.get(i).getLaden())));
						mainRootElement3B.appendChild(getChildNode(doc, "PACKAGE_TYPE", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "NATURE_OF_CARGO",
								isNull(equipmentVoDataList.get(i).getSpecialCargo())));
						mainRootElement3B.appendChild(getChildNode(doc, "MOVEMENT_TYPE", ""));
						mainRootElement3B.appendChild(getChildNode(doc, "HAULAGE_ARRANGEMENT", ""));

					}
				}
			}
			/* split based on length 70*/
			
			if(uim.getSpecialInstruction() != null && !uim.getSpecialInstruction().equals("")){
				List<String> list = splitEqually(uim.getSpecialInstruction(), 70);
					for (String str : list) {
						Element mainRootElement9C = doc.createElement("EDI_ST_DOC_TEXT");
						mainRootElement1.appendChild(mainRootElement9C);
						mainRootElement9C.appendChild(getChildNode(doc, "TEXT_TYPE", "AAI"));
						mainRootElement9C.appendChild(getChildNode(doc, "DESCRIPTION", isNull(str)));
						mainRootElement9C.appendChild(getChildNode(doc, "TEXT_CODE", ""));
					}
			 }else{	
				    Element mainRootElement9A = doc.createElement("EDI_ST_DOC_TEXT");
					mainRootElement1.appendChild(mainRootElement9A);
					mainRootElement9A.appendChild(getChildNode(doc, "TEXT_TYPE", "AAI"));
					mainRootElement9A.appendChild(getChildNode(doc, "DESCRIPTION", isNull(uim.getSpecialInstruction())));
					mainRootElement9A.appendChild(getChildNode(doc, "TEXT_CODE", ""));
			  }
			
			if(uim.getCargoDescription() != null && !uim.getCargoDescription().equals("")){
				List<String> list = splitEqually("\r\n"+uim.getCargoDescription(), 70);
					for (String str : list) {
						Element mainRootElement9B = doc.createElement("EDI_ST_DOC_TEXT");
						mainRootElement1.appendChild(mainRootElement9B);
						mainRootElement9B.appendChild(getChildNode(doc, "TEXT_TYPE", "AAA"));
						mainRootElement9B.appendChild(getChildNode(doc, "DESCRIPTION", isNull(str)));
						mainRootElement9B.appendChild(getChildNode(doc, "TEXT_CODE", ""));
					}
			 }else{	
				    Element mainRootElement9B = doc.createElement("EDI_ST_DOC_TEXT");
					mainRootElement1.appendChild(mainRootElement9B);
					mainRootElement9B.appendChild(getChildNode(doc, "TEXT_TYPE", "AAA"));
					mainRootElement9B.appendChild(getChildNode(doc, "DESCRIPTION", isNull(uim.getCargoDescription())));
					mainRootElement9B.appendChild(getChildNode(doc, "TEXT_CODE", ""));
			  }
			
			if(uim.getRoutingPreference() != null && !uim.getRoutingPreference().equals("")){
				List<String> list = splitEqually(uim.getRoutingPreference(), 70);
					for (String str : list) {
						Element mainRootElement9C = doc.createElement("EDI_ST_DOC_TEXT");
						mainRootElement1.appendChild(mainRootElement9C);
						mainRootElement9C.appendChild(getChildNode(doc, "TEXT_TYPE", "ACB"));
						mainRootElement9C.appendChild(getChildNode(doc, "DESCRIPTION", isNull(str)));
						mainRootElement9C.appendChild(getChildNode(doc, "TEXT_CODE", ""));
					}
			 }else{	
				    Element mainRootElement9C = doc.createElement("EDI_ST_DOC_TEXT");
					mainRootElement1.appendChild(mainRootElement9C);
					mainRootElement9C.appendChild(getChildNode(doc, "TEXT_TYPE", "ACB"));
					mainRootElement9C.appendChild(getChildNode(doc, "DESCRIPTION", isNull(uim.getRoutingPreference())));
					mainRootElement9C.appendChild(getChildNode(doc, "TEXT_CODE", ""));
			  }

			Element mainRootElement10 = doc.createElement("EDI_ST_DOC_CONTACT");
			mainRootElement1.appendChild(mainRootElement10);
			mainRootElement10.appendChild(getChildNode(doc, "CONTACT_TYPE", "IC"));
			mainRootElement10.appendChild(getChildNode(doc, "CONTACT_NAME", isNull(uim.getContact())));
			mainRootElement10.appendChild(getChildNode(doc, "CONTACT_DEPARTMENT", ""));

			// SUB child element in EDI_ST_DOC_CONTACT
			Element mainRootElement4A = doc.createElement("EDI_ST_DOC_COMM");
			mainRootElement10.appendChild(mainRootElement4A);
			mainRootElement4A.appendChild(getChildNode(doc, "COMM_TYPE", "EM")); // will be hard coded to ME( email)
			mainRootElement4A.appendChild(getChildNode(doc, "COMM_NUMBER", isNull(uim.getEmail())));

			Element mainRootElement11 = doc.createElement("EDI_ST_DOC_CONTACT");
			mainRootElement1.appendChild(mainRootElement11);
			mainRootElement11.appendChild(getChildNode(doc, "CONTACT_TYPE", ""));
			mainRootElement11.appendChild(getChildNode(doc, "CONTACT_NAME", ""));
			mainRootElement11.appendChild(getChildNode(doc, "CONTACT_DEPARTMENT", ""));

			if (uim.getAdditionalMailRecipeints() != null && !uim.getAdditionalMailRecipeints().equals("")) {
				if (uim.getAdditionalMailRecipeints().contains(",")) {
					String[] mails = uim.getAdditionalMailRecipeints().split(",");
					int mailCount = 1;
					for (String email : mails) {
						String mailId = "E";
						mailId = mailId + mailCount;
						Element mainRootElement4AB = doc.createElement("EDI_ST_DOC_COMM");
						mainRootElement10.appendChild(mainRootElement4AB);
						mainRootElement4AB.appendChild(getChildNode(doc, "COMM_TYPE", mailId)); // will be hard coded to
																								// ME( email)
						mainRootElement4AB.appendChild(getChildNode(doc, "COMM_NUMBER", isNull(email)));
						mailCount++;
					}
				} else {
					Element mainRootElement4AC = doc.createElement("EDI_ST_DOC_COMM");
					mainRootElement10.appendChild(mainRootElement4AC);
					mainRootElement4AC.appendChild(getChildNode(doc, "COMM_TYPE", "E1")); // will be hard coded to ME(
																							// email)
					mainRootElement4AC
							.appendChild(getChildNode(doc, "COMM_NUMBER", isNull(uim.getAdditionalMailRecipeints())));
				}
			}

			// SUB child element in EDI_ST_DOC_CONTACT
			Element mainRootElement5A = doc.createElement("EDI_ST_DOC_COMM");
			mainRootElement11.appendChild(mainRootElement5A);
			mainRootElement5A.appendChild(getChildNode(doc, "COMM_TYPE", "TE")); // will be hard coded to TE( telephone)
			mainRootElement5A.appendChild(getChildNode(doc, "COMM_NUMBER", isNull(uim.getTelephone())));

			Element mainRootElement12 = doc.createElement("EDI_ST_DOC_CONTACT");
			mainRootElement1.appendChild(mainRootElement12);
			mainRootElement12.appendChild(getChildNode(doc, "CONTACT_TYPE", ""));
			mainRootElement12.appendChild(getChildNode(doc, "CONTACT_NAME", ""));
			mainRootElement12.appendChild(getChildNode(doc, "CONTACT_DEPARTMENT", ""));

			// SUB child element in EDI_ST_DOC_CONTACT
			Element mainRootElement6A = doc.createElement("EDI_ST_DOC_COMM");
			mainRootElement12.appendChild(mainRootElement6A);
			mainRootElement6A.appendChild(getChildNode(doc, "COMM_TYPE", "FX")); // will be hard coded to FX( FX number)
			mainRootElement6A.appendChild(getChildNode(doc, "COMM_NUMBER", isNull(uim.getFax())));

			Element mainRootElement13 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement13);
			mainRootElement13.appendChild(getChildNode(doc, "PARTY_TYPE", "ZZZ"));
			mainRootElement13.appendChild(getChildNode(doc, "PARTY_CODE", isNull(partyCode)));
			mainRootElement13.appendChild(getChildNode(doc, "PARTY_NAME", isNull(custmer.getCustomerName())));
			mainRootElement13.appendChild(getChildNode(doc, "ADDRESS_LINE_1", isNull(custmer.getAddress1())));
			mainRootElement13.appendChild(getChildNode(doc, "ADDRESS_LINE_2", isNull(custmer.getAddress2())));
			mainRootElement13.appendChild(getChildNode(doc, "ADDRESS_LINE_3", isNull(custmer.getAddress3())));
			mainRootElement13.appendChild(getChildNode(doc, "ADDRESS_LINE_4", isNull(custmer.getAddress1())));
			mainRootElement13.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement13.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement13.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			Element mainRootElement14 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement14);
			mainRootElement14.appendChild(getChildNode(doc, "PARTY_TYPE", "CZ"));
			mainRootElement14.appendChild(getChildNode(doc, "PARTY_CODE", isNull(uim.getCustomerCode())));
			mainRootElement14.appendChild(getChildNode(doc, "PARTY_NAME", ""));
			mainRootElement14.appendChild(getChildNode(doc, "ADDRESS_LINE_1", ""));
			mainRootElement14.appendChild(getChildNode(doc, "ADDRESS_LINE_2", ""));
			mainRootElement14.appendChild(getChildNode(doc, "ADDRESS_LINE_3", ""));
			mainRootElement14.appendChild(getChildNode(doc, "ADDRESS_LINE_4", ""));
			mainRootElement14.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement14.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement14.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			Element mainRootElement20 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement20);
			mainRootElement20.appendChild(getChildNode(doc, "PARTY_TYPE", "BA"));
			mainRootElement20.appendChild(getChildNode(doc, "PARTY_CODE", isNull(uim.getCustomerCode())));
			mainRootElement20.appendChild(getChildNode(doc, "PARTY_NAME", ""));
			mainRootElement20.appendChild(getChildNode(doc, "ADDRESS_LINE_1", ""));
			mainRootElement20.appendChild(getChildNode(doc, "ADDRESS_LINE_2", ""));
			mainRootElement20.appendChild(getChildNode(doc, "ADDRESS_LINE_3", ""));
			mainRootElement20.appendChild(getChildNode(doc, "ADDRESS_LINE_4", ""));
			mainRootElement20.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement20.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement20.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			Element mainRootElement18 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement18);
			mainRootElement18.appendChild(getChildNode(doc, "PARTY_TYPE", "BS"));
			mainRootElement18.appendChild(getChildNode(doc, "PARTY_CODE", isNull(uim.getCustomerCode())));
			mainRootElement18.appendChild(getChildNode(doc, "PARTY_NAME", ""));
			mainRootElement18.appendChild(getChildNode(doc, "ADDRESS_LINE_1", ""));
			mainRootElement18.appendChild(getChildNode(doc, "ADDRESS_LINE_2", ""));
			mainRootElement18.appendChild(getChildNode(doc, "ADDRESS_LINE_3", ""));
			mainRootElement18.appendChild(getChildNode(doc, "ADDRESS_LINE_4", ""));
			mainRootElement18.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement18.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement18.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			Element mainRootElement19 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement19);
			mainRootElement19.appendChild(getChildNode(doc, "PARTY_TYPE", "SF"));
			mainRootElement19.appendChild(getChildNode(doc, "PARTY_CODE", isNull(uim.getCustomerCode())));
			mainRootElement19.appendChild(getChildNode(doc, "PARTY_NAME", ""));
			mainRootElement19.appendChild(getChildNode(doc, "ADDRESS_LINE_1", ""));
			mainRootElement19.appendChild(getChildNode(doc, "ADDRESS_LINE_2", ""));
			mainRootElement19.appendChild(getChildNode(doc, "ADDRESS_LINE_3", ""));
			mainRootElement19.appendChild(getChildNode(doc, "ADDRESS_LINE_4", ""));
			mainRootElement19.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement19.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement19.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			// output DOM XML to console
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			console = new StreamResult(System.out);
			// transformer.transform(source, console);

			file = new StreamResult(new StringWriter());
			transformer.transform(source, file);
			String xmlString = file.getWriter().toString();

			writtingTheFileToFTP(xmlString, uim.getBookingNo());

			System.out.println("\nXML DOM Created Successfully..");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return "SUCCESS";
	}

	private static boolean checkPort1(String toLocation, String portOfDischarge) {
		
			if(!toLocation.equals(portOfDischarge))
				return true;
		
		return false;
	}

	public static String generateEshippingInstructionXmlFile(EshippingInstructionUim uim,
			EshippingInstructionDao objDao, String userId) throws Exception {

		System.out.println("****  Generating XML File for EshippingInstruction "+uim.getBookingNo()+" ******* " );

		getCustomerDetailesForEshipping(userId, objDao);

		System.out.println("customer detailes  " + custmer.toString());

		System.out.println();
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		StreamResult console = null;
		StreamResult file = null;
		int i = 0;
		double carGrosWeight = 0;
		double carGrosVolume = 0;
		String emptLadenValue = "";

		List<EshippingCargoDescriptionMod> equipmentVoDataLists = new ArrayList<EshippingCargoDescriptionMod>();
		equipmentVoDataLists = uim.getCargoDescriptionDetails();

		for (EshippingCargoDescriptionMod equmntModel : equipmentVoDataLists) {
			i++;
			carGrosWeight = carGrosWeight + Double.parseDouble(replaceComma(equmntModel.getGrossContainerWeight()));
			carGrosVolume = carGrosVolume + Double.parseDouble(replaceComma(equmntModel.getGrossCargoMeasurement()));

		}
		try {
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.newDocument();
			Element mainRootElement = doc.createElement("EDI_TRANSACTION_HEADER");

			doc.appendChild(mainRootElement);

			// append child elements to root element
			mainRootElement.appendChild(getChildNode(doc, "MSG_REFERENCE", isNull(uim.getBookingNo())));
			mainRootElement.appendChild(getChildNode(doc, "MESSAGE_CODE", "IFTMIN"));
			mainRootElement.appendChild(getChildNode(doc, "MSG_VERSION", "99B"));
			mainRootElement.appendChild(getChildNode(doc, "API_CODE", "BL_IN"));
			mainRootElement.appendChild(getChildNode(doc, "DIRECTION", "IN"));
			mainRootElement.appendChild(getChildNode(doc, "SENDER_ID", "RCLEBOOKING"));
			mainRootElement.appendChild(getChildNode(doc, "RECEIVER_ID", "DCS"));
			mainRootElement.appendChild(getChildNode(doc, "ACKNOWLEDGE", ""));
			mainRootElement.appendChild(getChildNode(doc, "TEST_INDICATOR", ""));
			mainRootElement.appendChild(getChildNode(doc, "INTF_CONTROL_NO", ""));
			mainRootElement.appendChild(getChildNode(doc, "FILE_NAME", ""));
			mainRootElement.appendChild(getChildNode(doc, "MODULE", "BL"));

			// for total equipment
			List<EshippingCargoDescriptionMod> equipmentVoList = new ArrayList<EshippingCargoDescriptionMod>();
			equipmentVoList = uim.getCargoDescriptionDetails();

			int totalEquipment = equipmentVoList.size();

			String docType = "";
			if (uim.getBlType() == "T")
				docType = "706";
			else
				docType = "710";
			Element mainRootElement1 = doc.createElement("EDI_ST_DOC_HEADER");
			mainRootElement.appendChild(mainRootElement1);
			mainRootElement1.appendChild(getChildNode(doc, "DOCUMENT_ID", ""));
			mainRootElement1.appendChild(getChildNode(doc, "DOCUMENT_TYPE", docType));
			mainRootElement1.appendChild(getChildNode(doc, "DOCUMENT_STATUS", isNull(uim.getDocStatus())));
			mainRootElement1.appendChild(getChildNode(doc, "DOCUMENT_DATE", getDate()));// current date
			mainRootElement1.appendChild(getChildNode(doc, "FUNCTION_CODE", "9"));
			mainRootElement1.appendChild(getChildNode(doc, "SERVICE_ORIGIN", "2"));
			mainRootElement1.appendChild(getChildNode(doc, "SERVICE_DESTINATION", ""));
			mainRootElement1.appendChild(getChildNode(doc, "TARIFF_SERVICE_CODE", "CYCY"));
			mainRootElement1.appendChild(getChildNode(doc, "NUMBER_COPIES", ""));
			mainRootElement1.appendChild(getChildNode(doc, "NUMBER_ORIGINALS", isNull(uim.getNoOfOriginal())));
			mainRootElement1
					.appendChild(getChildNode(doc, "TOTAL_GROSS_WEIGHT", replaceComma(isNull(carGrosWeight + ""))));
			mainRootElement1.appendChild(getChildNode(doc, "GROSS_WEIGHT_UOM", "KGM"));
			mainRootElement1.appendChild(getChildNode(doc, "TOTAL_VOLUME", replaceComma(isNull(carGrosVolume + ""))));
			mainRootElement1.appendChild(getChildNode(doc, "VOLUME_UOM", "MTQ"));
			mainRootElement1.appendChild(getChildNode(doc, "TOTAL_EQUIPMENT", isNull(String.valueOf(totalEquipment))));
			mainRootElement1.appendChild(getChildNode(doc, "EQUIPMENT_TYPE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "TOTAL_PACKAGES", ""));
			mainRootElement1.appendChild(getChildNode(doc, "PACKAGE_TYPE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "PAYMENT_TERMS", ""));
			mainRootElement1.appendChild(getChildNode(doc, "PREPAID_TOTAL", ""));
			mainRootElement1.appendChild(getChildNode(doc, "PREPAID_CCY", ""));
			mainRootElement1.appendChild(getChildNode(doc, "COLLECT_TOTAL", ""));
			mainRootElement1.appendChild(getChildNode(doc, "COLLECT_CCY", ""));

			mainRootElement1.appendChild(getChildNode(doc, "SHIPMENT_VALUE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "INSURED_VALUE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "CUSTOMS_VALUE", ""));
			mainRootElement1.appendChild(getChildNode(doc, "VALUE_CCY", ""));
			mainRootElement1.appendChild(getChildNode(doc, "AGENT", ""));

			Element mainRootElement2 = doc.createElement("EDI_ST_DOC_REFERENCE");
			mainRootElement1.appendChild(mainRootElement2);
			mainRootElement2.appendChild(getChildNode(doc, "REFERENCE_TYPE", "BN"));
			mainRootElement2.appendChild(getChildNode(doc, "REFERENCE", isNull(uim.getBookingNo())));

			/*
			 * Element mainRootElement3 = doc.createElement("EDI_ST_DOC_REFERENCE");
			 * mainRootElement1.appendChild(mainRootElement3);
			 * mainRootElement3.appendChild(getChildNode(doc, "REFERENCE_TYPE", "BM"));
			 * mainRootElement3.appendChild(getChildNode(doc, "REFERENCE",
			 * isNull(uim.getBlNumber())));
			 */

			Element mainRootElement4 = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement1.appendChild(mainRootElement4);
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_TYPE", "7")); // Place Of Delivery TODO
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPodNo())));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(uim.getPlaceOfDelivery()))); // isNull(getContryNew(uim.getPlaceOfDelivery(),objDao))));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", "")); // (isNull(uim.getPlaceOfDelivery()).substring(0,
																						// 2))));
			mainRootElement4.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement4.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			Element mainRootElement5 = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement1.appendChild(mainRootElement5);
			mainRootElement5.appendChild(getChildNode(doc, "LOCATION_TYPE", "9")); // POL
			mainRootElement5.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPolNo())));
			mainRootElement5.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(uim.getPol())));// isNull(getContryNew(uim.getPlaceOfReceipt(),objDao))));
			mainRootElement5.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement5.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement5.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement5.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", "")); // isNull(uim.getPlaceOfReceipt().substring(0,
																						// 2))));
			mainRootElement5.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement5.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			Element mainRootElement6 = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement1.appendChild(mainRootElement6);
			mainRootElement6.appendChild(getChildNode(doc, "LOCATION_TYPE", "11")); // POD
			mainRootElement6.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPodNo())));
			mainRootElement6.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(uim.getPod())));// isNull(getContryNew(uim.getPlaceOfDelivery(),objDao))));
			mainRootElement6.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement6.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement6.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement6.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", ""));// isNull(uim.getPlaceOfDelivery().substring(0,
																						// 2))));
			mainRootElement6.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement6.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			Element mainRootElement61 = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement1.appendChild(mainRootElement61);
			mainRootElement61.appendChild(getChildNode(doc, "LOCATION_TYPE", "88")); // Place Of Receipt TODO
			mainRootElement61.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPolNo())));
			mainRootElement61.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(uim.getPlaceOfReceipt())));// isNull(getContryNew(uim.getPlaceOfDelivery(),objDao))));
			mainRootElement61.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement61.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement61.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement61.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", ""));// isNull(uim.getPlaceOfDelivery().substring(0,
																						// 2))));
			mainRootElement61.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement61.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			List<EshippingCargoDescriptionMod> equipmentVoDataList = new ArrayList<EshippingCargoDescriptionMod>();
			equipmentVoDataList = uim.getCargoDescriptionDetails();

			for (EshippingCargoDescriptionMod equmntModel : equipmentVoDataList) {
				Element mainRootElement7 = doc.createElement("EDI_ST_DOC_EQUIPMENT");
				mainRootElement1.appendChild(mainRootElement7);
				mainRootElement7.appendChild(getChildNode(doc, "EQUIPMENT_TYPE", "CN"));
				mainRootElement7.appendChild(getChildNode(doc, "EQUIPMENT_NO", isNull(equmntModel.getContainerNo())));
				mainRootElement7.appendChild(getChildNode(doc, "EQUIPMENT_SIZE_TYPE",
						isNull(equmntModel.getContainerEqSize() + equmntModel.getContainerEqType()))); // containerEqType
				mainRootElement7
						.appendChild(getChildNode(doc, "TYPE_DESCRIPTION", isNull(equmntModel.getDescription())));
				mainRootElement7.appendChild(getChildNode(doc, "EQUIPMENT_SUPPLIER", ""));
				mainRootElement7.appendChild(getChildNode(doc, "EQUIPMENT_STATUS", ""));

				if (equmntModel.getLadenMt() == "LADEN")
					emptLadenValue = "F";
				else
					emptLadenValue = "";
				mainRootElement7.appendChild(getChildNode(doc, "EQUIPMENT_FULL_EMPTY", emptLadenValue));
				mainRootElement7.appendChild(
						getChildNode(doc, "GROSS_WEIGHT", replaceComma(isNull(equmntModel.getGrossContainerWeight()))));
				mainRootElement7.appendChild(getChildNode(doc, "GROSS_WEIGHT_UOM", "KGM"));
				mainRootElement7.appendChild(
						getChildNode(doc, "VOLUME", replaceComma(isNull(equmntModel.getGrossCargoMeasurement()))));
				mainRootElement7.appendChild(getChildNode(doc, "VOLUME_UOM", "MTQ"));
				mainRootElement7.appendChild(getChildNode(doc, "LENGTH_UOM", ""));
				mainRootElement7.appendChild(getChildNode(doc, "OVERLENGTH_FRONT", ""));
				mainRootElement7.appendChild(getChildNode(doc, "OVERHEIGHT", ""));
				mainRootElement7.appendChild(getChildNode(doc, "OVERWIDTH_LEFT", ""));
				mainRootElement7.appendChild(getChildNode(doc, "OVERWIDTH_RIGHT", ""));
				mainRootElement7.appendChild(getChildNode(doc, "OVERLENGTH_BACK", ""));
				mainRootElement7.appendChild(getChildNode(doc, "TEMPERATURE", ""));
				mainRootElement7.appendChild(getChildNode(doc, "TEMPERATURE_MIN", ""));
				mainRootElement7.appendChild(getChildNode(doc, "TEMPERATURE_MAX", ""));
				mainRootElement7.appendChild(getChildNode(doc, "TEMPERATURE_UOM", ""));
				mainRootElement7.appendChild(getChildNode(doc, "SEAL_NUMBER_SH", ""));
				mainRootElement7.appendChild(getChildNode(doc, "SEAL_NUMBER_TO", ""));
				mainRootElement7.appendChild(getChildNode(doc, "SEAL_NUMBER_CA", isNull(equmntModel.getCarrierSeal()))); // CNNGB1824284
				mainRootElement7.appendChild(getChildNode(doc, "SEAL_NUMBER_CU", isNull(equmntModel.getShipperSeal())));
				mainRootElement7.appendChild(getChildNode(doc, "VENT_SETTING", ""));
				mainRootElement7.appendChild(getChildNode(doc, "HUMIDITY", ""));
				mainRootElement7.appendChild(getChildNode(doc, "AIR_EXCHANGE", ""));

				mainRootElement7.appendChild(getChildNode(doc, "HAZARDOUS", ""));
				mainRootElement7.appendChild(getChildNode(doc, "PIECE_COUNT", isNull(equmntModel.getOfPackages())));
				mainRootElement7
						.appendChild(getChildNode(doc, "PACKAGE_TYPE", isNull(equmntModel.getPackagesKindCode())));
				mainRootElement7.appendChild(getChildNode(doc, "NATURE_OF_CARGO", ""));
				mainRootElement7.appendChild(getChildNode(doc, "MOVEMENT_TYPE", ""));
				mainRootElement7.appendChild(getChildNode(doc, "HAULAGE_ARRANGEMENT", ""));
			}

			Element mainRootElement8 = doc.createElement("EDI_ST_DOC_JOURNEY");
			mainRootElement1.appendChild(mainRootElement8);
			mainRootElement8.appendChild(getChildNode(doc, "TRANSPORT_STAGE", "20")); // qualifier
			if(uim.getVoyageNo().equals("TBA")) {
				mainRootElement8.appendChild(getChildNode(doc, "CONVEYANCE_REFERENCE", ""));
			}else {
				mainRootElement8.appendChild(getChildNode(doc, "CONVEYANCE_REFERENCE", isNull(uim.getVoyageNo())));
			}
			mainRootElement8.appendChild(getChildNode(doc, "TRANSPORT_MODE", "1"));
			mainRootElement8.appendChild(getChildNode(doc, "TRANSPORT_MEANS", ""));
			mainRootElement8.appendChild(getChildNode(doc, "CARRIER_CODE", ""));
			mainRootElement8.appendChild(getChildNode(doc, "CARRIER_NAME", ""));
			mainRootElement8.appendChild(getChildNode(doc, "CONVEYANCE_CODE", ""));
			if(uim.getVoyageNo().equals("TBA")) {
			    mainRootElement8.appendChild(getChildNode(doc, "CONVEYANCE_NAME", ""));
			}else {
				mainRootElement8.appendChild(getChildNode(doc, "CONVEYANCE_NAME", isNull(uim.getVessel())));	
			}
			mainRootElement8.appendChild(getChildNode(doc, "CONVEYANCE_NATIONALITY", ""));
			mainRootElement8.appendChild(getChildNode(doc, "DIRECTION", ""));
			mainRootElement8.appendChild(getChildNode(doc, "SERVICE", ""));
			mainRootElement8.appendChild(getChildNode(doc, "SHIP_CALL_NO", ""));

			// -----------------------------------------------------------------------------
			// SUB child element in EDI_ST_DOC_JOURNEY
			Element mainRootElement1A = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement8.appendChild(mainRootElement1A);
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_TYPE", "7"));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPod())));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(uim.getPlaceOfDelivery())));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement1A.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			Element mainRootElement1B = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement8.appendChild(mainRootElement1B);
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_TYPE", "9"));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPolNo())));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(uim.getPol())));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement1B.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			Element mainRootElement1D = doc.createElement("EDI_ST_DOC_LOCATION");
			mainRootElement8.appendChild(mainRootElement1D);
			mainRootElement1D.appendChild(getChildNode(doc, "LOCATION_TYPE", "11"));
			mainRootElement1D.appendChild(getChildNode(doc, "LOCATION_CODE", isNull(uim.getPodNo())));
			mainRootElement1D.appendChild(getChildNode(doc, "LOCATION_NAME", isNull(uim.getPod())));
			mainRootElement1D.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement1D.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement1D.appendChild(getChildNode(doc, "LOCATION_SUB_TYPE", ""));
			mainRootElement1D.appendChild(getChildNode(doc, "LOCATION_SUB_CODE", ""));
			mainRootElement1D.appendChild(getChildNode(doc, "LOCATION_SUB_NAME", ""));
			mainRootElement1D.appendChild(getChildNode(doc, "ACTIVITY_CODE", ""));

			/////////// commodityDetails
			List<EshippingCommodityDetailsMod> commodityDetailsMod = new ArrayList<EshippingCommodityDetailsMod>();
			commodityDetailsMod = uim.getCommodityVoDataList();

			for (EshippingCommodityDetailsMod comdtyObj : commodityDetailsMod) {

				Element mainRootElement9 = doc.createElement("EDI_ST_DOC_COMMODITY");
				mainRootElement1.appendChild(mainRootElement9);
				mainRootElement9
						.appendChild(getChildNode(doc, "PACKAGE_TYPE", isNull(comdtyObj.getStrCommPackageKindCode())));// strCommPackageKindName
				mainRootElement9
						.appendChild(getChildNode(doc, "PIECE_COUNT", replaceComma(isNull(comdtyObj.getStrCommOfPackages()))));
				mainRootElement9.appendChild(getChildNode(doc, "COMMODITY", isNull(comdtyObj.getStrCommCode())));
				mainRootElement9.appendChild(getChildNode(doc, "DESCRIPTION", isNull(comdtyObj.getStrCommDesc())));
				mainRootElement9.appendChild(
						getChildNode(doc, "GROSS_WEIGHT", replaceComma(isNull(comdtyObj.getStrCommWeight()))));
				mainRootElement9.appendChild(getChildNode(doc, "WEIGHT_UOM", "KGM"));
				mainRootElement9.appendChild(
						getChildNode(doc, "VOLUME", replaceComma(isNull(comdtyObj.getStrCommMeasurement()))));
				mainRootElement9.appendChild(getChildNode(doc, "VOLUME_UOM", "MTQ"));
				mainRootElement9.appendChild(getChildNode(doc, "LENGTH", ""));
				mainRootElement9.appendChild(getChildNode(doc, "WIDTH", ""));
				mainRootElement9.appendChild(getChildNode(doc, "HEIGHT", ""));
				mainRootElement9.appendChild(getChildNode(doc, "LENGTH_UOM", ""));
				mainRootElement9.appendChild(getChildNode(doc, "MOVEMENT_TYPE", ""));
				mainRootElement9.appendChild(getChildNode(doc, "HAULAGE_ARRANGEMENTS", ""));

				// SUB child element in EDI_ST_DOC_COMMODITY

				Element mainRootElement2A = doc.createElement("EDI_ST_DOC_TEXT");
				mainRootElement9.appendChild(mainRootElement2A);
				mainRootElement2A.appendChild(getChildNode(doc, "TEXT_TYPE", "BLC")); // qualifier
				mainRootElement2A.appendChild(getChildNode(doc, "DESCRIPTION", ""));
				mainRootElement2A.appendChild(getChildNode(doc, "TEXT_CODE", ""));

				// need to revisite
				Element mainRootElement2AA = doc.createElement("EDI_ST_DOC_TEXT");
				mainRootElement9.appendChild(mainRootElement2AA);
				mainRootElement2AA.appendChild(getChildNode(doc, "TEXT_TYPE", "BLC")); // qualifier
				mainRootElement2AA.appendChild(getChildNode(doc, "DESCRIPTION", ""));
				mainRootElement2AA.appendChild(getChildNode(doc, "TEXT_CODE", ""));

				Element mainRootElement2AAB = doc.createElement("EDI_ST_DOC_TEXT");
				mainRootElement9.appendChild(mainRootElement2AAB);
				mainRootElement2AAB.appendChild(getChildNode(doc, "TEXT_TYPE", "BLC")); // qualifier
				mainRootElement2AAB.appendChild(getChildNode(doc, "DESCRIPTION", ""));
				mainRootElement2AAB.appendChild(getChildNode(doc, "TEXT_CODE", ""));

				if (comdtyObj.getDescription() != null && !comdtyObj.getDescription().equals("")){
					List<String> list = splitEqually(comdtyObj.getDescription(), 70);
					for (String str : list) {
						Element mainRootElement2C = doc.createElement("EDI_ST_DOC_TEXT");
						mainRootElement9.appendChild(mainRootElement2C);
						mainRootElement2C.appendChild(getChildNode(doc, "TEXT_TYPE", "AAI"));
						mainRootElement2C
								.appendChild(getChildNode(doc, "DESCRIPTION", isNull(str)));// isNull(comdtyObj.getSpecialInstruction())));
						mainRootElement2C.appendChild(getChildNode(doc, "TEXT_CODE", ""));
					}
				}else {
					Element mainRootElement2C = doc.createElement("EDI_ST_DOC_TEXT");
					mainRootElement9.appendChild(mainRootElement2C);
					mainRootElement2C.appendChild(getChildNode(doc, "TEXT_TYPE", "AAI"));
					mainRootElement2C.appendChild(getChildNode(doc, "DESCRIPTION", isNull(comdtyObj.getDescription())));// isNull(comdtyObj.getSpecialInstruction())));
					mainRootElement2C.appendChild(getChildNode(doc, "TEXT_CODE", ""));
				}
				
				
				// need to revisite TODO
				Element mainRootElement2CC = doc.createElement("EDI_ST_DOC_TEXT");
				mainRootElement9.appendChild(mainRootElement2CC);
				mainRootElement2CC.appendChild(getChildNode(doc, "TEXT_TYPE", "AAI"));
				mainRootElement2CC.appendChild(getChildNode(doc, "DESCRIPTION", ""));
				mainRootElement2CC.appendChild(getChildNode(doc, "TEXT_CODE", ""));

				if(comdtyObj.getMarksAndNumbers() != null && !comdtyObj.getMarksAndNumbers().equals("")){
				List<String> list = splitEqually(comdtyObj.getMarksAndNumbers(), 70);
					for (String str : list) {
						Element mainRootElement2B = doc.createElement("EDI_ST_DOC_MARKS");
						mainRootElement9.appendChild(mainRootElement2B);
						mainRootElement2B.appendChild(getChildNode(doc, "MARKS", isNull(str)));
					}
			    }else{	
					Element mainRootElement2B = doc.createElement("EDI_ST_DOC_MARKS");
					mainRootElement9.appendChild(mainRootElement2B);
					mainRootElement2B.appendChild(getChildNode(doc, "MARKS", isNull(comdtyObj.getMarksAndNumbers())));
			    }
				
				Element mainRootElement2BA = doc.createElement("EDI_ST_DOC_MARKS");
				mainRootElement9.appendChild(mainRootElement2BA);
				mainRootElement2BA.appendChild(getChildNode(doc, "MARKS", ""));

				Element mainRootElement2BC = doc.createElement("EDI_ST_DOC_MARKS");
				mainRootElement9.appendChild(mainRootElement2BC);
				mainRootElement2BC.appendChild(getChildNode(doc, "MARKS", ""));

			}

			Element mainRootElement21 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement21);
			mainRootElement21.appendChild(getChildNode(doc, "PARTY_TYPE", "CZ"));
			mainRootElement21.appendChild(getChildNode(doc, "PARTY_CODE", isNull(uim.getShipperCode())));
			mainRootElement21.appendChild(getChildNode(doc, "PARTY_NAME", isNull(uim.getShipperName())));
			mainRootElement21.appendChild(getChildNode(doc, "ADDRESS_LINE_1", isNull(uim.getShipperAddress1())));
			mainRootElement21.appendChild(getChildNode(doc, "ADDRESS_LINE_2", isNull(uim.getShipperAddress2())));
			mainRootElement21.appendChild(getChildNode(doc, "ADDRESS_LINE_3", isNull(uim.getShipperAddress3())));
			mainRootElement21.appendChild(getChildNode(doc, "ADDRESS_LINE_4", isNull(uim.getShipperAddress4())));
			mainRootElement21.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement21.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement21.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			Element mainRootElement22 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement22);
			mainRootElement22.appendChild(getChildNode(doc, "PARTY_TYPE", "CN"));
			if(uim.getConsigneeName().equals("TO ORDER")) {
				mainRootElement22.appendChild(getChildNode(doc, "PARTY_CODE", "TOORZZ0001"));
				mainRootElement22.appendChild(getChildNode(doc, "PARTY_NAME", isNull(uim.getConsigneeName())));
			}else {
				mainRootElement22.appendChild(getChildNode(doc, "PARTY_CODE", isNull(uim.getConsigneeCode())));
				mainRootElement22.appendChild(getChildNode(doc, "PARTY_NAME", isNull(uim.getConsigneeName())));
			}
			mainRootElement22.appendChild(getChildNode(doc, "ADDRESS_LINE_1", isNull(uim.getConsigneeAddress1())));
			mainRootElement22.appendChild(getChildNode(doc, "ADDRESS_LINE_2", isNull(uim.getConsigneeAddress2())));
			mainRootElement22.appendChild(getChildNode(doc, "ADDRESS_LINE_3", isNull(uim.getConsigneeAddress3())));
			mainRootElement22.appendChild(getChildNode(doc, "ADDRESS_LINE_4", isNull(uim.getConsigneeAddress4())));
			mainRootElement22.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement22.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement22.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			Element mainRootElement23 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement23);
			mainRootElement23.appendChild(getChildNode(doc, "PARTY_TYPE", "N1"));
			mainRootElement23.appendChild(getChildNode(doc, "PARTY_CODE", isNull(uim.getNotifyPartyCode())));
			mainRootElement23.appendChild(getChildNode(doc, "PARTY_NAME", isNull(uim.getNotifyPartyName())));	
			mainRootElement23.appendChild(getChildNode(doc, "ADDRESS_LINE_1", isNull(uim.getNotifyPartyAddress1())));
			mainRootElement23.appendChild(getChildNode(doc, "ADDRESS_LINE_2", isNull(uim.getNotifyPartyAddress2())));
			mainRootElement23.appendChild(getChildNode(doc, "ADDRESS_LINE_3", isNull(uim.getNotifyPartyAddress3())));
			mainRootElement23.appendChild(getChildNode(doc, "ADDRESS_LINE_4", isNull(uim.getNotifyPartyAddress4())));
			mainRootElement23.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement23.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement23.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			/*
			 * Element mainRootElement24 = doc.createElement("EDI_ST_DOC_PARTY");
			 * mainRootElement1.appendChild(mainRootElement24);
			 * mainRootElement24.appendChild(getChildNode(doc, "PARTY_TYPE", "HI"));
			 * mainRootElement24.appendChild(getChildNode(doc, "PARTY_CODE", ""));
			 * mainRootElement24.appendChild(getChildNode(doc, "PARTY_NAME", ""));
			 * mainRootElement24.appendChild(getChildNode(doc, "ADDRESS_LINE_1", ""));
			 * mainRootElement24.appendChild(getChildNode(doc, "ADDRESS_LINE_2", ""));
			 * mainRootElement24.appendChild(getChildNode(doc, "ADDRESS_LINE_3", ""));
			 * mainRootElement24.appendChild(getChildNode(doc, "ADDRESS_LINE_4", ""));
			 * mainRootElement24.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			 * mainRootElement24.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			 * mainRootElement24.appendChild(getChildNode(doc, "POSTAL_CODE", ""));
			 * 
			 * // SUB child element in EDI_ST_DOC_PARTY Element mainRootElement3A =
			 * doc.createElement("EDI_ST_DOC_CONTACT");
			 * mainRootElement24.appendChild(mainRootElement3A);
			 * mainRootElement3A.appendChild(getChildNode(doc, "CONTACT_TYPE", "IC"));
			 * mainRootElement3A.appendChild(getChildNode(doc, "CONTACT_NAME",
			 * isNull(uim.getContact()))); mainRootElement3A.appendChild(getChildNode(doc,
			 * "CONTACT_DEPARTMENT", ""));
			 * 
			 * // SUB child element in EDI_ST_DOC_CONTACT Element mainRootElement4A =
			 * doc.createElement("EDI_ST_DOC_COMM");
			 * mainRootElement3A.appendChild(mainRootElement4A);
			 * mainRootElement4A.appendChild(getChildNode(doc, "COMM_TYPE", "EM"));
			 * mainRootElement4A.appendChild(getChildNode(doc, "COMM_NUMBER",
			 * isNull(uim.getEmail())));
			 * 
			 * Element mainRootElement25 = doc.createElement("EDI_ST_DOC_PARTY");
			 * mainRootElement1.appendChild(mainRootElement25);
			 * mainRootElement25.appendChild(getChildNode(doc, "PARTY_TYPE", "CA"));
			 * mainRootElement25.appendChild(getChildNode(doc, "PARTY_CODE", ""));
			 * mainRootElement25.appendChild(getChildNode(doc, "PARTY_NAME", ""));
			 * mainRootElement25.appendChild(getChildNode(doc, "ADDRESS_LINE_1", ""));
			 * mainRootElement25.appendChild(getChildNode(doc, "ADDRESS_LINE_2", ""));
			 * mainRootElement25.appendChild(getChildNode(doc, "ADDRESS_LINE_3", ""));
			 * mainRootElement25.appendChild(getChildNode(doc, "ADDRESS_LINE_4", ""));
			 * mainRootElement25.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			 * mainRootElement25.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			 * mainRootElement25.appendChild(getChildNode(doc, "POSTAL_CODE", ""));
			 */

			String custmoerCode = getCustomerCode(userId, objDao);
			Element mainRootElement26 = doc.createElement("EDI_ST_DOC_PARTY");
			mainRootElement1.appendChild(mainRootElement26);
			mainRootElement26.appendChild(getChildNode(doc, "PARTY_TYPE", "ZZZ"));
			mainRootElement26.appendChild(getChildNode(doc, "PARTY_CODE", isNull(custmoerCode))); // "RCLFEP0001"));
			mainRootElement26.appendChild(getChildNode(doc, "PARTY_NAME", isNull(custmer.getCustomerName()))); // "***
																												// ******
																												// ***
																												// ***"));
			mainRootElement26.appendChild(getChildNode(doc, "ADDRESS_LINE_1", isNull(custmer.getAddress1()))); // "11
																												// ******
																												// ***D
																												// 8TH
																												// ***OR"));////
			mainRootElement26.appendChild(getChildNode(doc, "ADDRESS_LINE_2", isNull(custmer.getAddress2()))); // "***
																												// ******"));//
			mainRootElement26.appendChild(getChildNode(doc, "ADDRESS_LINE_3", isNull(custmer.getAddress3()))); // "*********
																												// 089057"));//
			mainRootElement26.appendChild(getChildNode(doc, "ADDRESS_LINE_4", isNull(custmer.getAddress4()))); // ""));//
			mainRootElement26.appendChild(getChildNode(doc, "LOCATION_COUNTY", ""));
			mainRootElement26.appendChild(getChildNode(doc, "LOCATION_COUNTRY", ""));
			mainRootElement26.appendChild(getChildNode(doc, "POSTAL_CODE", ""));

			// output DOM XML to console
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			console = new StreamResult(System.out);

			file = new StreamResult(new StringWriter());

			transformer.transform(source, file);

			String xmlString = file.getWriter().toString();

			writtingTheFileToFTPShiiping(xmlString, uim.getBookingNo());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			//objDao.insertSiErrorLog(uim,objDao,e);
		}

		return "SUCCESS";
	}

	// utility method to create text node
	private static Node getChildNode(Document doc, String nodeName, String value) {

		Element node = doc.createElement(nodeName);
		node.appendChild(doc.createTextNode(value));
		return node;
	}

	/**
	 * Checks if is null.
	 * 
	 * @param str
	 *            the s id
	 * @return the string
	 */
	private static String isNull(String str) {
		return (str == null) ? "" : str;
	}

	private static String getDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmm");
		String strDate = formatter.format(date);
		return strDate;
	}

	public static void writtingTheFileToFTP(String xml, String filename) {
		// TODO Auto-generated method stub

		// FtpConfig ftfConfig = (FtpConfig) EZLBeanFactory.getBean("ftpConfig");

		/*
		 * String ip = ftfConfig.getIp(); String userId = ftfConfig.getUserId(); String
		 * password = ftfConfig.getPassword(); String path = ftfConfig.getBookingIn();
		 * String PathForBackup =ftfConfig.getBookingIn_Bkup();
		 */

		String ip = EservicePropertyFatchOperation.ip;
		String userId = EservicePropertyFatchOperation.userId;
		String password = EservicePropertyFatchOperation.password;
		String path = EservicePropertyFatchOperation.bookingIn;
		String PathForBackup = EservicePropertyFatchOperation.bookingInBackup;
		String folderLocation = EservicePropertyFatchOperation.getFileLocation();
		folderLocation = folderLocation + "/";
		FTPClient client = new FTPClient();
		FileInputStream fileInputStremToTransfer = null;
		
		try {

			client.connect(ip);
			boolean login = client.login(userId, password);

			if (login == true) {
				System.out.println("Successfully logged in!" + filename);
			} else {
				System.out.println("Login Fail!");
			}

			if (filename == null) {
				filename = "123";
			}
			client.setFileType(FTP.BINARY_FILE_TYPE);
			client.enterLocalPassiveMode();

			filename = filename + ".XML";
			InputStream targetStream = IOUtils.toInputStream(xml);

			File targetFile = new File(folderLocation + filename);
			OutputStream outStream = new FileOutputStream(targetFile);

			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = targetStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			outStream.close();
			
			System.out.println("File created sucess fully");
			fileInputStremToTransfer = new FileInputStream(folderLocation + filename);
			System.out.println("start transfer file " + path + filename);
		 	int reply = client.getReplyCode();
		 
			if (!FTPReply.isPositiveCompletion(reply)) {
				client.disconnect();
				System.out.println("FTP server refused connection.");

			}

			boolean doneBackUp = false;
			boolean done=false;
			try {
				Thread.sleep(100);
				System.out.println("Came out from sleep ");
				done = client.storeFile(path + filename, fileInputStremToTransfer);
				System.out.println("File one s path"+path+" name "+filename);
			} catch (Exception e) {
				System.out.println("i am in error path" + e);
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				if(fileInputStremToTransfer!= null) {
				fileInputStremToTransfer.close();
				}
			}
			
			fileInputStremToTransfer = new FileInputStream(folderLocation + filename);
			
			try {
				Thread.sleep(100);
				System.out.println("Came out from sleep for backup");
				 done = client.storeFile(PathForBackup + filename, fileInputStremToTransfer);
				 System.out.println("File  PathForBackup  done");
			} catch (Exception e) {
				System.out.println("i am in error PathForBackup" + e);
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				if(fileInputStremToTransfer!= null) {
				fileInputStremToTransfer.close();
				}
			}
			
			
			if (done && doneBackUp) {
				System.out.println("The first file is uploaded successfully." + filename);
			}
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

	public static void writtingTheFileToFTPShiiping(String xml, String filename) {
		// TODO Auto-generated method stub

		// FtpConfig ftfConfig = (FtpConfig) EZLBeanFactory.getBean("ftpConfig");

		/*
		 * String ip = ftfConfig.getIp(); String userId = ftfConfig.getUserId(); String
		 * password = ftfConfig.getPassword(); String path = ftfConfig.getShiipingIn();
		 * String pathBackUp = ftfConfig.getShiipingIn_Bkup();
		 */

		String ip = EservicePropertyFatchOperation.ip;
		String userId = EservicePropertyFatchOperation.userId;
		String password = EservicePropertyFatchOperation.password;
		String path = EservicePropertyFatchOperation.shiipingIn;
		String pathBackUp = EservicePropertyFatchOperation.shiipingInBackUp;
		String folderLocation = EservicePropertyFatchOperation.getFileLocation();
		folderLocation = folderLocation + "/";
		FTPClient client = new FTPClient();

		FileInputStream fiStreamForFileTransfer = null;
		try {

			client.connect(ip);
			boolean login = client.login(userId, password);

			client.setFileType(FTP.BINARY_FILE_TYPE);
			client.enterLocalPassiveMode();

			// client.connect("localhost");
			// boolean login = client.login("lenovo", "12345");

			if (login == true) {
				System.out.println("Successfully logged in!"+filename);
			} else {
				System.out.println("Login Fail!");
			}

			if (filename == null) {
				filename = "123";
			}
			filename = filename + ".XML";
			InputStream targetStream = IOUtils.toInputStream(xml);
			File targetFile = new File(folderLocation + filename);
			OutputStream outStream = new FileOutputStream(targetFile);

			byte[] buffer = new byte[8 * 1024];
			int bytesRead;
			while ((bytesRead = targetStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);
			}
			outStream.close();
			System.out.println("File created sucess fully");
			
			int reply = client.getReplyCode();
			 
			if (!FTPReply.isPositiveCompletion(reply)) {
				client.disconnect();
				System.out.println("FTP server refused connection.");

			}

			boolean doneBackUp = false;
			boolean done =false;
			fiStreamForFileTransfer = new FileInputStream(folderLocation + filename);
			System.out.println("start transfer file for Shipping " + pathBackUp + filename);
			
			try {
				Thread.sleep(100);
				System.out.println("Came out from sleep In ");
				done = client.storeFile(path + filename, fiStreamForFileTransfer);
				System.out.println("File one s done for "+path);

			} catch (Exception e) {
				System.out.println("i am in error " + e);
				e.printStackTrace();
				// TODO: handle exception
			}finally {
					if(fiStreamForFileTransfer!= null) {
						fiStreamForFileTransfer.close();
					}
			}
			fiStreamForFileTransfer = new FileInputStream(folderLocation + filename);
			System.out.println("start transfer file for Shipping " + pathBackUp + filename);
			
			try {
				Thread.sleep(100);
				System.out.println("Came out from sleep backup");
				doneBackUp = client.storeFile(pathBackUp + filename, fiStreamForFileTransfer);
				System.out.println("File one s doneBackUp"+pathBackUp);
			} catch (Exception e) {
				System.out.println("i am in error " + e);
				e.printStackTrace();
				// TODO: handle exception
			}finally {
				if(fiStreamForFileTransfer!= null) {
					fiStreamForFileTransfer.close();
				}
		}
			
					
			if (done && doneBackUp) {
				System.out.println("The first file is uploaded successfully for shipping." + filename);
			}
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

	public static String getContry(String code, EserviceNewWebBookingDao objDao) {
		if (code != null && !code.equals("")) {
			String contry = objDao.getContryByContyCode(code);
			return contry;
		} else {
			return "";
		}

	}
	
	public static String getPointContry(String code, EserviceNewWebBookingDao objDao) {
		if (code != null && !code.equals("")) {
			String contry = objDao.getPointByContyCode(code);
			return contry;
		} else {
			return "";
		}

	}

	public static String getDateYYYYMMDD(String date) {
		// 15/08/2020
		if (date != null && !date.equals(""))

		{
			String dateArray[] = date.split("/");
			if(dateArray.length>=3) {
				date = dateArray[2] + dateArray[1] + dateArray[0] + "0000";
			}else {
				String dateArray1[] = date.split("-");
				if(dateArray1.length>=3) {
					date = dateArray1[2] + dateArray1[1] + dateArray1[0] + "0000";
				} 
			}
		}
		return date;

	}

	public static String getDateYYYYMMDDDif(String date) {
		// 15/08/2020
		if (date != null && !date.equals(""))

		{
			String dateArray[] = date.split("-");
			if(dateArray.length>=3) {
				date = dateArray[2] + dateArray[1] + dateArray[0] + "0000";
			}else {
				String dateArray1[] = date.split("/");
				if(dateArray1.length>=3) {
					date = dateArray1[2] + dateArray1[1] + dateArray1[0] + "0000";
				} 
			}
		}
		return date;

	}

	public static void getCustomerDetailes(String CustomerCode, EserviceNewWebBookingDao objDao) {
		custmer = objDao.getCustomerDetailes(CustomerCode);

	}

	public static String getContryNew(String code, EshippingInstructionDao objDao) {
		String contry = objDao.getContryByContyCode(code);

		return contry;

	}

	public static void getCustomerDetailesForEshipping(String userId, EshippingInstructionDao objDao) {
		custmer = objDao.getCustomerDetailes(userId);

	}

	public static String getCustomerCode(String userId, EshippingInstructionDao objDao) {
		String customerCode = objDao.getCustomerCode(userId);
		if (customerCode != null)
			return customerCode;
		return "";
	}

	private static String replaceComma(String str) {
		if (str == null)
			return "0";
		if (str.contains(","))
			return str.replaceAll(",", "");
		else
			return str;
	}

	public static List<String> splitEqually(String text, int size) {
		// Give the list the right capacity to start with. You could use an array
		// instead if you wanted.
		List<String> ret = new ArrayList<String>((text.length() + size - 1) / size);

		for (int start = 0; start < text.length(); start += size) {
			ret.add(text.substring(start, Math.min(text.length(), start + size)));
		}
		return ret;
	}

	public static List<String> splitEquallyForDes(String text, int size) {
		// Give the list the right capacity to start with. You could use an array
		// instead if you wanted.
		String arr[]=text.split("\r\n");
		List<String> ret = new ArrayList<String>();
		for(int j=0;j<arr.length ;j++) {
			System.out.println("j: "+j);
			if(arr[j].length()>32) {
					getDescResult(arr[j],0,ret);
				 
				
				/*//String arrResult[]=getDescResult(arr[j]);
				String arrInner[]=arr[j].split("(?<=\\G.{30})")  ;
				 for(int k=0;k<arrInner.length;k++) {
					 ret.add(arrInner[k]);
				 }	*/
			}else {
				ret.add(arr[j]);
			}
			
		}
		return ret;
	}
	
	private static String getCommodityCode(String group, EserviceNewWebBookingDao objDao) {
		String commoditycode = objDao.getCommodityCode(group);
		if (commoditycode != null)
			return commoditycode;

		return "";
	}

	public static Date getDateYYYYMMDDPOLPOD(String dateInString) {
		// added on 24/05/2021
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date format = null;

		try {
			if (dateInString != null)
				format = formatter.parse(dateInString);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format;
	}

public static List<String> getDescResult(String st,int startingIndex,List<String> list) {
		
	
	
		int t = st.substring(startingIndex, 32).lastIndexOf(" ");
		
		System.out.println(t);
		//System.out.println(st.substring(startingIndex, t));
		if(t==-1) {
			if(st.charAt(31)==' ') {
				list.add(st.substring(0, 32));
				st=st.substring(32, st.length()).toString();
				return getDescResult(st,0,list); 
			}else {
				list.add(st.substring(0, 32));
				st=checkIntialSpace(st.substring(32, st.length()).toString());
				if(st.length()>32) {
					return getDescResult(st,0,list); 
				}else {
					list.add(st);
				}
			}
		}else {		
			String result=st.substring(startingIndex, t);
			st=checkIntialSpace(st.substring(t, st.length()).toString());
			list.add(result);
			if(st.length()>32) {
				return getDescResult(st,0,list); 
			}else {
				list.add(st);
			}
		}
		return list;
	}

	private static String checkIntialSpace(String st) {
		while(st.charAt(0)==' ') {
			st=st.substring(1,st.length());
		} 
		return st;
	}
}
