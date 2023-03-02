package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;
public interface SeoulMapper {
	//서울여행 리스트
	@Select("SELECT no,title,poster,num "
			+"FROM (SELECT no,title,poster,rownum as num "
			+"FROM (SELECT no,title,poster "
			+"FROM seoul_location ORDER BY no ASC)) "
			+"WHERE num BETWEEN #{start} AND #{end}")
	public List<SeoulVO> seoulListData(Map map);
	
	//총페이지
	@Select("SELECT CEIL(count(*)/20.0) FROM seoul_location")
	public int seoulTotalPage();
	
	//상세보기
	@Select("SELECT no,title,poster,address,msg FROM seoul_location "
			+"WHERE no=#{no}")
	public SeoulVO seoulDetailData(int no);
	
	//근처맛집
	@Select("SELECT fno,name,poster FROM food_location "
			+"WHERE rownum<=4 AND address LIKE '%'||#{addr}||'%'")
	public List<FoodVO> nearbyFoodData(Map map);
	
}
