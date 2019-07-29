package com.lixijie.mybatisdemo.pojo;

public class Province {
	private Integer pid;
	private String province;
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "Province [pid=" + pid + ", province=" + province + "]";
	}
	

}
