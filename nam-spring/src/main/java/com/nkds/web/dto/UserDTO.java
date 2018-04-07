package com.nkds.web.dto;

public class UserDTO extends AbstractDTO{
	private String stfno;
	private String nm;
	private String orgcd;
	
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
		return "UserDTO [stfno=" + stfno + ", nm=" + nm + ", orgcd=" + orgcd + ", getStfno()=" + getStfno()
				+ ", getNm()=" + getNm() + ", getOrgcd()=" + getOrgcd() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
