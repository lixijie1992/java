package com.lixijie.mybatisdemo.pojo;

import java.io.Serializable;

public class City  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer tid;
	private String city;
	private Province province;
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "City [tid=" + tid + ", city=" + city + ", province=" + province + "]";
	}
	

}
