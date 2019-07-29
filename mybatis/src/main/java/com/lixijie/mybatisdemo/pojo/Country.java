package com.lixijie.mybatisdemo.pojo;

import java.util.Set;

public class Country {
	private Integer cid;
	private String country;
	private Set<Province> Provinces;

	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Set<Province> getProvinces() {
		return Provinces;
	}
	public void setProvinces(Set<Province> provinces) {
		Provinces = provinces;
	}
	@Override
	public String toString() {
		return "County [cid=" + cid + ", country=" + country + ", Provinces=" + Provinces + "]";
	}

}
