/* -----------------------------------------------------------------------------
 System  : RCLEAPPS
 Module  : Eservice
 Prog ID : ESER008 - EserviceCommodityPopupDaoImpl.java
 Name    : New Web Booking
 Purpose : DAO Class for EserviceCommodityPopupDao Interface
 --------------------------------------------------------------------------------
 History : None
 --------------------------------------------------------------------------------
 Author          Date            What
 --------------- --------------- ------------------------------------------------
 NTL)Vikas         24/04/2013      <Initial version>
 --Change Log--------------------------------------------------------------------
 ## DD/MM/YY –User- -Task/CR No- -Short Description-
 ##11/07/2013        01             add SQL for get commodity data
 ----------------------------------------------------------------------------- */
package com.rclgroup.dolphin.rcl.web.eservice.dao;

import com.niit.control.common.ComboVO;
import com.niit.control.common.Debug;
import com.niit.control.common.exception.BusinessException;
import com.niit.control.common.exception.ExceptionFactory;
import com.niit.control.dao.AncestorJdbcDao;
import com.niit.control.dao.JdbcRowMapper;
import com.niit.control.dao.JdbcStoredProcedure;

import com.rclgroup.dolphin.rcl.web.eservice.actionform.EserviceNewWebBookingUim;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceBookingListMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceCommodityDetailsMod;
import com.rclgroup.dolphin.rcl.web.eservice.vo.EserviceNewWebBookingMod;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;


/**
 * Class for DAO
 * @class EserviceCommodityPopupDaoImpl
 * @author NTL) Vikas
 * @version v1.00 2013/04/29
 * @see
 */
public class EserviceCommodityPopupDaoImpl extends AncestorJdbcDao implements EserviceCommodityPopupDao {


    public EserviceCommodityPopupDaoImpl() {
    }

    /**
     * Method called when page load
     * 
     * @param amapParam
     * @return
     * @throws BusinessException
     * @throws DataAccessException
     */
    public Map onLoad(Map amapParam) throws BusinessException, 
                                            DataAccessException {
        return amapParam;
    }

    public Map getList(Map amap) throws BusinessException, 
                                             DataAccessException {
                      
        List<EserviceCommodityDetailsMod> list = null;

        String find = (String)amap.get(KEY_CRITERIA_TEXT_FIND);
        String column = (String)amap.get(KEY_CRITERIA_COLUMN);
        String sortby = (String)amap.get(KEY_CRITERIA_SORTBY);
        String order = (String)amap.get(KEY_CRITERIA_ORDER);
        String wildcard = (String)amap.get(KEY_CRITERIA_WILDCARD);
//@01 BEGIN
        StringBuffer sqlStatement =  new StringBuffer(
                "select DISTINCT Description as \"description\", b.Commodity_Group_code as \"code\" FROM COMMODITY_GROUP a, ITP080 b WHERE a.Commodity_Group_code = b.Commodity_Group_code AND FCRCST = 'A' AND XXRCST = 'A'");
//@01 END  
        
        if(null!=column && !"".equals(column))
        {
            sqlStatement.append(" and ");

            if(KEY_COLUMN_COMM_CODE.equals(column))
            {
                sqlStatement.append(KEY_COLUMN_COMM_CODE);
                sqlStatement.append(" = ");
                sqlStatement.append(find);
            }

             else
             {
                 sqlStatement.append(column);
             }

             if(null!=wildcard)
             {

                 sqlStatement.append(" like '%"+find.trim()+"%'");
             }
             else
             {
                 sqlStatement.append(" = '"+find.trim()+"'");
             }
        }

        if(null!=sortby && !"".equals(sortby))
        {
            sqlStatement.append(" order by "+ sortby);
        }
        else
        {
            sqlStatement.append(" order by description");
        }

        if(null!=order && !"".equals(order))
        {
            sqlStatement.append(" "+ order);
        }
        
        System.out.println("sql : " + sqlStatement);

        SqlRowSet rs = getNamedParameterJdbcTemplate().queryForRowSet(sqlStatement.toString(), new HashMap());

        rs.last();

        int size = rs.getRow();
        rs.beforeFirst();
        System.out.println("Row(s) : " + size);

        if(0!=size){
            list = new ArrayList<EserviceCommodityDetailsMod>();
        }

        // String bookingDate = null;
        EserviceCommodityDetailsMod objVO = null;
        while (rs.next())
        {
            objVO = new EserviceCommodityDetailsMod();
            objVO.setCode(rs.getString("code"));
            objVO.setDescription(rs.getString("description"));

            // bookingDate = rs.getString(1);
            // blm.setBookingDate(null!=bookingDate?bookingDate.substring(6,8)+"/"+bookingDate.substring(4,6)+"/"+bookingDate.substring(0,4):bookingDate);
            // blm.setBookingNo(rs.getString(2));
            // blm.setCocSoc(rs.getString(3));
            // blm.setBookingType(rs.getString(4));
            // blm.setPol(rs.getString(5));
            // blm.setPod(rs.getString(6));
            // blm.setStatus(rs.getString(7));

            list.add(objVO);
        }
              
        
        amap.put(KEY_DATA, list);
        amap.put(KEY_SIZE, size);
        
        return amap;        
    }


} // end of class
