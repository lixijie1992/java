package com.lixijie.mybatisdemo.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory  sqlSessionFactory;
	
	public static SqlSession getSqlSession() {	
		
		try {
			if(sqlSessionFactory==null) {
				String resource = "mybatis.xml";
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			}
			 return sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
