package com.lixijie.mybatisdemo.pojo;

import java.util.Set;

/**
 * 父栏目
 * @author lixijie
 *
 */
public class Telent {
	private Integer id;
	private String name;
    private Set<Telent> childTelent;
private Telent parentTelent;
	public Telent getParentTelent() {
	return parentTelent;
}
public void setParentTelent(Telent parentTelent) {
	this.parentTelent = parentTelent;
}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Telent> getChildTelent() {
		return childTelent;
	}
	public void setChildTelent(Set<Telent> childTelent) {
		this.childTelent = childTelent;
	}
	@Override
	public String toString() {
		return "Telent [id=" + id + ", name=" + name + ", childTelent=" + childTelent + ", parentTelent=" + parentTelent
				+ "]";
	}

    
}
