package com.rclgroup.dolphin.rcl.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.tools.zip.ZipEntry;
//import org.apache.tools.zip.ZipFile;

public class ExcelUtil {
	public static Workbook getWorkbook(File f) throws IOException {
            System.out.println("[ExcelUtil][getWorkbook][Begin]");
            
            String      contentType = null;
            InputStream is          = null;
            
            try {
                contentType = getContenttype(f);
                
                if (contentType.indexOf(".zip") >= 0 || contentType.indexOf(".7z") >= 0) {
//                    return getWorkbookZip(f);
                    return createWookbook(is);
                } else {
                    is = new FileInputStream(f);
                    return createWookbook(is);
                }
            } finally {
                is = null;
                System.out.println("[ExcelUtil][getWorkbook][End]");
            }
	}

	private static String getContenttype(File f) {
        
	    System.out.println("[ExcelUtil][getContenttype] File name :: " + f.getName());
            return f.getName();
	}

//	private static Workbook getWorkbookZip(File f) throws IOException {
//            ZipFile     zipFile     = new ZipFile(f);
//            Enumeration enumZip     = zipFile.getEntries();// entries();
//            InputStream is          = null;
//
//            while (enumZip.hasMoreElements()) {
//                ZipEntry entryZip = (ZipEntry) enumZip.nextElement();
//                if (!entryZip.isDirectory()) {
//                    is = zipFile.getInputStream(entryZip);
//                    break;
//                }
//            }
//            if (is == null) {
//                System.out.println("zipFile.getInputStream is null");
//                throw new IOException(f.getName());
//            }
//            
//            return createWookbook(is);
//	}
//
//	private static Workbook getWorkbookZip(String url) throws IOException {
//            ZipFile     zipFile = new ZipFile(url);
//            Enumeration enumZip = zipFile.getEntries();// entries();
//            InputStream is      = null;
//
//            while (enumZip.hasMoreElements()) {
//                ZipEntry entryZip = (ZipEntry) enumZip.nextElement();
//                if (!entryZip.isDirectory()) {
//                    is = zipFile.getInputStream(entryZip);
//                }
//            }
//            if (is == null) {
//                throw new IOException(url);
//            }
//            return createWookbook(is);
//	}

	private static Workbook createWookbook(InputStream is) throws IOException {
	    System.out.println("[ExcelUtil][createWookbook][Begin]");
            Workbook wb = null;
	    XSSFWorkbook c = null;
            try {
                wb = WorkbookFactory.create(is);
                System.out.println("[ExcelUtil][createWookbook] wb :: " + wb);
                
            } catch (InvalidFormatException e) {
                e.printStackTrace();
                throw new IOException(e.getMessage());
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                System.out.println("[ExcelUtil][createWookbook][End]");
            }
	    return wb;
	}

	public static HSSFRow[] getAllRows(HSSFSheet sheet) {
	    System.out.println("[ExcelUtil][getAllRows][Begin]");
            
	    int         startRow    = 0;
	    int         endRow      = 0;
	    HSSFRow[]   rowArray    = null;
            
            try{
                startRow    = sheet.getFirstRowNum();
                endRow      = sheet.getPhysicalNumberOfRows();
                System.out.println("[ExcelUtil][getAllRows] startRow :: " + startRow);
                System.out.println("[ExcelUtil][getAllRows] endRow   :: " + endRow);
                
                rowArray    = new HSSFRow[endRow];
                
                for (int j = startRow; j < rowArray.length; j++) {
                    rowArray[j] = sheet.getRow(j);
                    
//                    if(j >4){
//                    String activity = RutString.nullToStr(new ExcelField(rowArray[j], ".*", 1).getValue()); 
//                    System.out.println("activity >>>>>> "+activity);
//                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                System.out.println("[ExcelUtil][getAllRows][End]");
            }
            
            return rowArray;
	}
        
    public static Row[] getAllRows_EX(Sheet sheet) {
        System.out.println("[ExcelUtil][getAllRows][Begin]");
        
        int         startRow    = 0;
        int         endRow      = 0;
        Row[]   rowArray    = null;
        
        try{
            startRow    = sheet.getFirstRowNum();
            endRow      = sheet.getPhysicalNumberOfRows();
            System.out.println("[ExcelUtil][getAllRows] startRow :: " + startRow);
            System.out.println("[ExcelUtil][getAllRows] endRow   :: " + endRow);
            
            rowArray    = new Row[endRow];
            
            for (int j = startRow; j < rowArray.length; j++) {
                rowArray[j] = sheet.getRow(j);
                
    //                    if(j >4){
    //                    String activity = RutString.nullToStr(new ExcelField(rowArray[j], ".*", 1).getValue());
    //                    System.out.println("activity >>>>>> "+activity);
    //                    }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("[ExcelUtil][getAllRows][End]");
        }
        
        return rowArray;
    }
}
