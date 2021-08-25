 /*------------------------------------------------------
  EserviceUploadMod.java
 --------------------------------------------------------
 Copyright RCL Public Co., Ltd. 2013
 --------------------------------------------------------
 Author Pratya Thanuchaisak 08/08/2014
 - Change Log -------------------------------------------
 ##  DD/MM/YY    –User-  -TaskRef-   -ShortDescription-
 ------------------------------------------------------*/
package com.rclgroup.dolphin.rcl.web.eservice.vo;

import org.apache.commons.fileupload.FileItem;
import org.apache.struts.upload.FormFile;

public class EserviceUploadMod{

    private FormFile        dataFile;
    private String          fileName;
    private String          fileType;
    private int             size;
    private String          sizeDisplay;
    private String          newFileName;
    private String          seq;
    private String          status;
    private String          link;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getSeq() {
        return seq;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setDataFile(FormFile dataFile) {
        this.dataFile = dataFile;
    }

    public FormFile getDataFile() {
        return dataFile;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setSizeDisplay(String sizeDisplay) {
        this.sizeDisplay = sizeDisplay;
    }

    public String getSizeDisplay() {
        return sizeDisplay;
    }
}
