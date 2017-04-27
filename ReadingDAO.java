package com.wipro.power.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.power.bean.ReadingBean;
import com.wipro.power.util.DBUtil;

public class ReadingDAO 
{
	Connection con=DBUtil.getDBConnection();
	PreparedStatement ps;
	public String createReading(ReadingBean readingBean) throws SQLException
	{
		ps=con.prepareStatement("insert into READINGS_TBL(serialNo,assetID,type,presentReading, pastReading,billMonth,billYear,unitsUsed,amount)"+"values(?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,readingBean.getSerialNo());
		ps.setString(2,readingBean.getAssetID());
		ps.setString(3,readingBean.getType());
		ps.setInt(4,readingBean.getPresentReading());
		ps.setInt(5,readingBean.getPastReading());
		ps.setString(6,readingBean.getBillMonth());
		ps.setString(7,readingBean.getBillYear());
		ps.setInt(8,readingBean.getUnitsUsed());
		ps.setFloat(9,readingBean.getAmount());
		int res=ps.executeUpdate();
		if(res > 0)
		{
			return "SUCCESS";
		}
		else
		{
			return "FAIL";
		}
			
	}
	public int generateSerialNo()
	{
		int serialNo=1000;
		try
		{
	
		ps=con.prepareStatement("select SERIALNO_SEQ.nextval from dual");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			serialNo=rs.getInt(1);
			
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		} 
		return serialNo;
		
	}
	public ArrayList<ReadingBean> viewAllBillsByMonth(String month,String year) throws SQLException
	{
		ArrayList<ReadingBean> al=new ArrayList<ReadingBean>();
		ReadingBean rb=new ReadingBean();
		ps=con.prepareStatement("select billmonth,billyear from READINGS_TBL");
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	    	
	    	rb.setBillMonth(rs.getString(1));
	    	rb.setBillYear(rs.getString(2));
	    	al.add(rb);
	    	return al;
	    }
		return null;
		
	}
	
}
