package com.lixijie.mybatisdemo.mapper;

import java.util.List;

import com.lixijie.mybatisdemo.pojo.Country;
import com.lixijie.mybatisdemo.pojo.Province;

public interface CountryMapper {

	List<Province> selectByCountry(Country country); 
	List<Province> selectByCountryId(Country country); 
	
}
