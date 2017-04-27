package com.wipro.power.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wipro.power.bean.PowerRateBean;
import com.wipro.power.util.DBUtil;

public class PowerRateDAO 
{
	Connection con=DBUtil.getDBConnection();
	PreparedStatement ps;
	
	
	public PowerRateBean findRateByType(String type) throws SQLException
	{
		int res;
		PowerRateBean p=new PowerRateBean();
		if(type=="House")
		{
			ps=con.prepareStatement("insert into POWER_RATE_TBL(type,slab1,slab2,slab3,slabRate1,slabRate2,slabRate3)"+"values(?,?,?,?,?,?)");
			ps.setString(1,p.getType());
			ps.setInt(2,p.getSlab1());
			ps.setInt(3,p.getSlab2());
			ps.setInt(4, p.getSlab3());
			ps.setFloat(5, p.getSlabRate1());
			ps.setFloat(6, p.getSlabRate2());
			ps.setFloat(7, p.getSlabRate3());
			res=ps.executeUpdate();
			return p;
		}
		if(type=="Shop")
		{
			ps=con.prepareStatement("insert into POWER_RATE_TBL(type,slab1,slab2,slab3,slabRate1,slabRate2,slabRate3)"+"values(?,?,?,?,?,?)");
			ps.setString(1,p.getType());
			ps.setInt(2,p.getSlab1());
			ps.setInt(3,p.getSlab2());
			ps.setInt(4, p.getSlab3());
			ps.setFloat(5, p.getSlabRate1());
			ps.setFloat(6, p.getSlabRate2());
			ps.setFloat(7, p.getSlabRate3());
			 res=ps.executeUpdate();
			return p;
		}
		if(type=="Mall")
		{
			ps=con.prepareStatement("insert into POWER_RATE_TBL(type,slab1,slab2,slab3,slabRate1,slabRate2,slabRate3)"+"values(?,?,?,?,?,?,?)");
			ps.setString(1,p.getType());
			ps.setInt(2,p.getSlab1());
			ps.setInt(3,p.getSlab2());
			ps.setInt(4, p.getSlab3());
			ps.setFloat(5, p.getSlabRate1());
			ps.setFloat(6, p.getSlabRate2());
			ps.setFloat(7, p.getSlabRate3());
			res=ps.executeUpdate();
			return p;
		}
		return null;
		
	}
}


