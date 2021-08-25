package com.rclgroup.dolphin.rcl.web.common;

import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class TestPDF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		 Document document = new Document();
		    try
		    {
		        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\AddTableExample.pdf"));
		        document.open();
		        
		        
		       
		        PdfPTable table = new PdfPTable(2); // 3 columns.
		        table.setWidthPercentage(100); //Width 100%
		        table.setSpacingBefore(10f); //Space before table
		        table.setSpacingAfter(10f); //Space after table
		 
		        //Set Column widths
		        float[] columnWidths = {1f, 1f};
		        table.setWidths(columnWidths);
		 
		        PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
		        cell1.setBorderColor(BaseColor.BLUE);
		        cell1.setPaddingLeft(10);
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		 
		        PdfPCell cell2 = new PdfPCell(new Paragraph("cccccccccccccc\r\nvvvvvvvvvvvvvvvvvv\r\nddddddddddddddddd"));
		        cell2.setRowspan(3);
		        cell2.setBorderColor(BaseColor.GREEN);
		        cell2.setPaddingLeft(10);
		        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
		  
		        //To avoid having the cell border and the content overlap, if you are having thick cell borders
		        //cell1.setUserBorderPadding(true);
		        //cell2.setUserBorderPadding(true);
		        //cell3.setUserBorderPadding(true);
		 
		        table.addCell(cell1);
		        table.addCell(cell2);
		   
		        cell1 = new PdfPCell(new Paragraph("Cell 1"));
		        cell1.setBorderColor(BaseColor.BLUE);
		        cell1.setPaddingLeft(10);
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        table.addCell(cell1);
		        cell1 = new PdfPCell(new Paragraph("Cell 1"));
		        cell1.setBorderColor(BaseColor.BLUE);
		        cell1.setPaddingLeft(10);
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        table.addCell(cell1);
		        cell1 = new PdfPCell(new Paragraph("cccccccccccccc\r\nvvvvvvvvvvvvvvvvvv\r\nddddddddddddddddd"));
		        cell1.setBorderColor(BaseColor.BLUE);
		        cell1.setPaddingLeft(10);
		        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
		        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		        table.addCell(cell1);
		 
		        System.out.println("cccccccccccc");
		        
		        document.add(table);
		        
		        
		        String waterMarkText = "DRAFT/SHIPPING INSTRUCTION";
		        
		        
                Phrase phrase = new Phrase(waterMarkText, new Font(
                             FontFamily.HELVETICA, //Select the Font name of waterMark Text
                             40, //Select the Font type of waterMark Text
                             Font.ITALIC, //Select the Font style of waterMark Text 
                             BaseColor.LIGHT_GRAY));
                
                ColumnText.showTextAligned(writer.getDirectContentUnder(),
                        Element.ALIGN_CENTER, //Keep waterMark center aligned
                        phrase, 300f, 500f,
                        360f); 
		 
		        document.close();
		        writer.close();
		    } catch (Exception e)
		    {
		        e.printStackTrace();
		    }
	}

}
