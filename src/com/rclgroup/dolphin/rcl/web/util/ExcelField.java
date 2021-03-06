package com.rclgroup.dolphin.rcl.web.util;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelField {
    private String value;
    private String condition;
    private String errorMessage;
    private boolean nullValue;
    private boolean error;

    public ExcelField(String value) {
        setValue(value);
    }

    public ExcelField(HSSFRow row, String _pattern) {
        setValue(String.valueOf(row.getRowNum() + 1));
    }

    public ExcelField(HSSFRow row, String _pattern, int _column) {
        this.value = null;
        String strDate = "";

        if (row.getCell((short) _column) == null) {
            setNullValue(true);
            setValue("");
            /*if (_column == 0) {
                setValue(String.valueOf(row.getRowNum()));
            } else {
                setNullValue(true);
            }*/
        } else {
            HSSFCell cell = row.getCell((short) _column);
            if (_pattern == "date" && (!cell.toString().equals(""))) {
                // Excel Date
                try {
                    Calendar c = Calendar.getInstance(Locale.US);
                    c.setTime(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                    strDate = getDateFormat(getDateString(c), "E");
                } catch (NumberFormatException n) {
                    strDate = cell.toString();
                    setError(true);
                    setCondition("1");
                }
                setValue(strDate);
            } else if (Pattern.matches(_pattern, cell.toString())) {
                if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                    setValue(convertDoubleToBigDecimal(
                    cell.getNumericCellValue()).toString());
                } else {
                    setValue(cell.toString());
                }
            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
                setValue(String.valueOf(cell.getNumericCellValue()));
            } else {
                setNullValue(true);
                setError(true);
                setCondition("1");
            }
        }
    }
    
    public ExcelField(Row row, String _pattern, int _column) {
        this.value = null;
        String strDate = "";

        if(row != null){
            if (row.getCell((short) _column) == null) {
                setNullValue(true);
                setValue("");
                /*if (_column == 0) {
                    setValue(String.valueOf(row.getRowNum()));
                } else {
                    setNullValue(true);
                }*/
            } else {
                Cell cell = row.getCell((short) _column);
                if (_pattern == "date" && (!cell.toString().equals(""))) {
                    // Excel Date
                    try {
                        Calendar c = Calendar.getInstance(Locale.US);
                        c.setTime(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                        strDate = getDateFormat(getDateString(c), "E");
                    } catch (NumberFormatException n) {
                        strDate = cell.toString();
                        setError(true);
                        setCondition("1");
                    }
                    setValue(strDate);
                } else if (Pattern.matches(_pattern, cell.toString())) {
                    if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        setValue(convertDoubleToBigDecimal(
                        cell.getNumericCellValue()).toString());
                    } else {
                        setValue(cell.toString());
                    }
                } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                    setValue(String.valueOf(cell.getNumericCellValue()));
                } else {
                    setNullValue(true);
                    setError(true);
                    setCondition("1");
                }
            }
        }else{
            setNullValue(true);
            setValue("");
        }
    }

    public static BigDecimal convertDoubleToBigDecimal(Double value) {
        BigDecimal data = new BigDecimal(0);

        if (value != null) {
            data = new BigDecimal(value);
        }

        return data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isNullValue() {
        return nullValue;
    }

    public void setNullValue(boolean nullValue) {
        this.nullValue = nullValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @param yyyymmdd
     * @param "E" or "T" (Year)
     * @return String ("01/01/2007")
     * @example String c = DateUtils.getDateFormat("20070101");
     */
    public static String getDateFormat(String yyyymmdd, String local) {
        String year = "";
        if (local.equals("E")) {
                year = yyyymmdd.substring(0, 4);
        } else {
                year = String.valueOf(Integer.parseInt(yyyymmdd.substring(0, 4)) + 543);
        }
        String month = yyyymmdd.substring(4, 6);
        String day = yyyymmdd.substring(6, 8);

        return day + "/" + month + "/" + year;
    }

    /**
     * @param Calendar
     * @return String ("20070101")
     * @example String dateUI = DateUtils.toString(object.getDate());
     */
    public static String getDateString(Calendar calendar) {
        String yyyy = String.valueOf(calendar.get(Calendar.YEAR));
        String mm = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        String dd = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        if (mm.length() < 2)
                mm = "0" + mm;
        if (dd.length() < 2)
                dd = "0" + dd;
        return yyyy + mm + dd;
    }
}
