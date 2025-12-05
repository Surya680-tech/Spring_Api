package com.studentapi.kaashiv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository  
public interface Student_Repo extends JpaRepository<Student_model, Integer> {
	
	@Query(nativeQuery = true, value = "sp_all_student")
	public List<Student_model> all_student();
	
	@Query(nativeQuery = true, value = "sp_getone :id")
	public Student_model OneStudent(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "sp_insert_student :email, :password, :name, :course,:fees ")
	public void  sp_insert_student(@Param("email")String email, @Param("password")String password, @Param("name")String name, @Param("course")String course, @Param("fees") int fees);
	
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "update_student :id, :password, :name, :course,:fees ")
	public void  update_student(@Param("id") int id, @Param("password")String password, @Param("name")String name, @Param("course")String course, @Param("fees") int fees);
	
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "sp_student_del :id")
	public void  sp_student_del(@Param("id") int id);
}
