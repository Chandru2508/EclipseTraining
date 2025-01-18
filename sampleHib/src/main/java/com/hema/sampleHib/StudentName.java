package com.hema.sampleHib;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentName {
	
	@Column(name="First_Name")
	private String fName;
	
	@Column(name="Middle_Name")
	private String mName;
	
	@Column(name="Last_Name")
	private String lName;

	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	@Override
	public String toString() {
		return "StudentName [fName=" + fName + ", mName=" + mName + ", lName=" + lName + "]";
	}
	
	
}
