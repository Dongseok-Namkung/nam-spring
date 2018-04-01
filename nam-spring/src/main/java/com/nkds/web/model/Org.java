package com.nkds.web.model;

public class Org {
	private String stfno;
	private String nm;
	private String orgcd;
	
	public Org() {}
	
	public Org(String stfno, String nm) {
		this.stfno = stfno;
		this.nm = nm;
	}

	public String getStfno() {
		return stfno;
	}

	public void setStfno(String stfno) {
		this.stfno = stfno;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getOrgcd() {
		return orgcd;
	}

	public void setOrgcd(String orgcd) {
		this.orgcd = orgcd;
	}
	
	@Override
    public String toString() {
        return "stfno: " + stfno + ", nm: " + nm;
    }

}
