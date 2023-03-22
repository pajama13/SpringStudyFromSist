package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodLocationEntity;
@Repository
public interface FoodLocationDAO extends JpaRepository<FoodLocationEntity, Integer>{ //Integer => Id fno의 타입
	@Query(value="SELECT * FROM food_location "
			     +"WHERE address LIKE CONCAT('%',:address,'%') ORDER BY fno LIMIT :start,20",nativeQuery=true)
	public List<FoodLocationEntity> foodFindData(@Param("address") String address,@Param("start") Integer start);
	
	@Query(value="SELECT CEIL(count(*)/20.0) FROM food_location "
				+"WHERE address LIKE CONCAT('%',:address,'%')",nativeQuery=true)
	public int foodFindTotalPage(@Param("address") String address);
	
	//상세보기용
	public FoodLocationEntity findByFno(@Param("fno") Integer fno);
	
	//리액트 연습
	@Query(value="select * from food_location "
			+"order by fno desc limit 0,20 ",nativeQuery=true)
	public List<FoodLocationEntity> foodChangeData();
}
