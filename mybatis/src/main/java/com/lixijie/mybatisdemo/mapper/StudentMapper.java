package com.lixijie.mybatisdemo.mapper;

import java.util.HashMap;
import java.util.List;

import com.lixijie.mybatisdemo.pojo.Student;

public interface StudentMapper {

	Student selectById(Integer id);
	
	void deleteById(Integer id);
	
	void updateById(Student student);
	
	void insertStudent(Student student);
	
	List<Student>  findAllStudent();
	
	List<Student>  findStudentByName(String name);
	
	List<Student>  findStudentByIds(int[] ids);
	
	List<Student>  findStudent(Student student);
	
	List<Student>  findStudentChoose(Student student);
	
	List<Student>  findStudentByParams(HashMap<String, Object> map);
}
