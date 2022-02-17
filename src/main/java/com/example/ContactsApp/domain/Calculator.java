package com.example.ContactsApp.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calculator {
	
	private Date birthD;
	private Date currentD;
	private int age;
	
	public Calculator(Date birthD) {
		super();
		this.birthD = birthD;
		this.currentD = new Date();
		this.age = ageCalculateYears(this.birthD, this.currentD);
	}

	public Date getBirthD() {
		return birthD;
	}

	public void setBirthD(Date birthD) {
		this.birthD = birthD;
	}

	public Date getCurrentD() {
		return currentD;
	}

	public void setCurrentD(Date currentD) {
		this.currentD = currentD;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	private int ageCalculate (Date b, Date c) {
		if (b!=null) {
			
		long diff = c.getTime() - b.getTime();
		int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return days;
		} else {
			return 999;
		}
	}
	
	private int ageCalculateYears (Date b, Date c) {
		if (b!=null) {
		    DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		    int d1 = Integer.parseInt(formatter.format(b));
		    int d2 = Integer.parseInt(formatter.format(c));
		    int age = (d2-d1)/10000;
		    return age;
		} else {
			return 999;
		}
	}
	
	
	

}
