package com.lixijie.mybatisdemo.mapper;

import java.util.List;

import com.lixijie.mybatisdemo.pojo.Telent;

public interface TelentMapper {
//查找下一级
	List<Telent> selectChildTelent(int id);

	List<Telent> selectChildTelentAndTelent(int id);

	// 查找上一级
	Telent selectParentById(int id);
}
