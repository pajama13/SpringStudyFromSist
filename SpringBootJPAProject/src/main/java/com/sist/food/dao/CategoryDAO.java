package com.sist.food.dao;

import com.sist.food.entity.CategoryEntity;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository

public interface CategoryDAO extends JpaRepository<CategoryEntity,Integer>{
	@Query(value="SELECT cno,title,poster,subject,link FROM project_category",nativeQuery=true)
	public List<CategoryEntity> categoryListData();
	
}
