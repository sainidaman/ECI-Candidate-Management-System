package com.ecimanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candidate")
public class Candidate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cid;
	private String c_name;
	@Column(name="partyname")
	private String party_name;
	private String constituency;
	private String gender;
	private String state;
	private int age;
	
	public Candidate()
	{
		
	}
	public Candidate(int cid,String name, String party_name, String constituency, String gender, String state, int age) {
		super();
		this.cid=cid;
		this.c_name = name;
		this.party_name = party_name;
		this.constituency = constituency;
		this.gender = gender;
		this.state = state;
		this.age = age;
	}
	public Candidate(String name, String party_name, String constituency, String gender, String state, int age) {
		super();
		this.c_name = name;
		this.party_name = party_name;
		this.constituency = constituency;
		this.gender = gender;
		this.state = state;
		this.age = age;
	}
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	
	public String getParty_name() {
		return party_name;
	}
	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Candidate [name=" + c_name + ", party_name=" + party_name + ", constituency=" + constituency + ", gender="
				+ gender + ", state=" + state + ", age=" + age + "]";
	}
	
}
