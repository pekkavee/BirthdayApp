package com.example.ContactsApp.domain;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contact {
    
@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String contactname;
    private String info;
    private int age;
    private Date birthdate;


public Contact() {
 
}
public Contact(Long id, String contactname, String info, int age, Date birthdate) {
this.id = id;
this.contactname = contactname;
this.info = info;
this.age = age;
this.birthdate = birthdate;



}

public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getContactname() {
return contactname;
}
public void setContactname(String contactname) {
this.contactname = contactname;
}
public String getInfo() {
	
return info;
}
public Date getBirthdate() {
	return birthdate;
}
public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}
public void setInfo(String info) {

this.info = info;
}
public int getAge() {
	Calculator calculator =new Calculator(this.birthdate);
	
return calculator.getAge();
}
public void setAge(int age) {
	this.age = age;
//this.fee = calculateAge(this.birthdate, this.currentDate);
}
public String text() {
	int value = this.getAge();
	String tomorrow = "Huomenna";
	String today = "Tänään!!";
	String coming ="Tulossa pian";
	String nA ="Ei tiedossa";
	String gone="Oli äsken";
	String s = "On vielä aikaa";
	
	if (value==0) {
		return today;
	} else if (value ==1) { 
		return tomorrow;		
	} else if (value>=0 && value <20) {
		return coming;
	}else if (value <0 && value >-30) { 
		return gone;
		
	} else if (value==999) {
		return nA;
	} else {
		return s;
	}
	
	
}

 
}