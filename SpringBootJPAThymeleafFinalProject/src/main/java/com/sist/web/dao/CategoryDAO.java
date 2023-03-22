package com.sist.web.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.*;
import com.sist.web.entity.*;
import java.util.*;
@Repository
public interface CategoryDAO extends JpaRepository<CategoryEntity, Integer>{
	@Query(value="select cno,title,poster from project_category",nativeQuery=true)
	public List<CategoryDataMapping> categoryListData();
	public CategoryEntity findByCno(@Param("cno") Integer cno);
	//                    where cno=              ----------- 들어갈 값  / ex) where cno=2
	
	@Query(value="select * from project_category "
				+"where cno between :start and :end",nativeQuery=true)
	public List<CategoryEntity> categoryChangeData(@Param("start") Integer start,@Param("end") Integer end);
}
