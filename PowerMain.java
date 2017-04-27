package com.wipro.power.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.power.bean.PowerRateBean;
import com.wipro.power.bean.ReadingBean;
import com.wipro.power.dao.ReadingDAO;

public class PowerMain 
{
	public String generateBill(ReadingBean readingBean) throws SQLException
	{
		PowerRateBean pb=new PowerRateBean();
		if(readingBean==null||readingBean.getPastReading()>readingBean.getPresentReading())
		{
			return "INVALID";
		}
		if(pb.getType()!="House"||pb.getType()!="Shop"||pb.getType()!="Mall")
		{
			return "INVALID TYPE";
		}
		int unitsUsed= readingBean.getPresentReading()-readingBean.getPastReading();
		float amount=calculateAmount(readingBean.getUnitsUsed(),readingBean.getType());
		readingBean.setUnitsUsed(unitsUsed);
		readingBean.setAmount(amount);
		ReadingDAO rd=new ReadingDAO();
		String res=rd.createReading(readingBean);
		if(res.equals("FAIL"))
		{
			return "FAIL";
		}
		if(res.equals("SUCCESS"))
		{
			String s="BILL AMOUNT";
			String s1=readingBean.getAmount()+"";
			String Result=s+s1;
			return Result;
			
		}
		return null;
		
	}
	
	public float calculateAmount(int unitsUsed, String type)
	{
		float total=0;
		ReadingBean rd=new ReadingBean();
		ReadingDAO r=new ReadingDAO();
		rd.setUnitsUsed(unitsUsed);
		rd.setType(type);
		if(unitsUsed==0&&type=="House")
		{
				PowerRateBean pb=new PowerRateBean();
					int Slab1Units = 25;
					int Slab2Units = 25;
					int Slab3Units = 5;
					float Slab1rate=Slab1Units*pb.getSlab1();
					float Slab2rate=Slab2Units*pb.getSlab2();
					float Slab3rate=Slab3Units*pb.getSlab3();
					 total=Slab1rate*Slab2rate*Slab3rate;
					return total;
		}
		return total;
		

	}
	public ArrayList<ReadingBean> viewAllBills(String month,String year)
	{
		ReadingDAO rd=new ReadingDAO();
		
		ArrayList<ReadingBean> al=new ArrayList<ReadingBean>();
		
		return al;
		
	}
	public static void main(String[] args) throws SQLException {
	     
        ReadingBean readingBean = new ReadingBean();
        PowerRateBean pb=new PowerRateBean();
        pb.setType("House");
        pb.setSlab1(0);
        pb.setSlab2(25);
        pb.setSlab3(50);
        pb.setSlabRate1(1.50f);
        pb.setSlabRate2(3.45f);
        pb.setSlabRate3(7.85f);
        pb.setType("Shop");
        pb.setSlab1(100);
        pb.setSlab2(200);
        pb.setSlab3(200);
        pb.setSlabRate1(3.55f);
        pb.setSlabRate2(9.45f);
        pb.setSlabRate3(16.95f);
        pb.setType("Mall");
        pb.setSlab1(0);
        pb.setSlab2(500);
        pb.setSlab3(1000);
        pb.setSlabRate1(7.85f);
        pb.setSlabRate2(15.45f);
        pb.setSlabRate3(27.65f);
        readingBean.setAssetID("HO1122");
        readingBean.setPresentReading(110);
        readingBean.setPastReading(100);
        readingBean.setType("House");
        readingBean.setBillMonth("Feb");
        readingBean.setBillYear("2015");
        String result = new PowerMain().generateBill(readingBean);
        System.out.println(result);
        ArrayList<ReadingBean>bills=new PowerMain().viewAllBills("Feb","2015");
        if(bills!=null){
        for(ReadingBean reading: bills){
              System.out.println(reading.getSerialNo());
              System.out.println(reading.getAmount());
        }
        }
}
}
