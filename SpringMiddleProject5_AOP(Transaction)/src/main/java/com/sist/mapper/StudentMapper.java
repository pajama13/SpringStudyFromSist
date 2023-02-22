package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import com.sist.dao.*;
import java.util.*;

public interface StudentMapper {
   @Select("SELECT hakbun,name,kor,eng,math FROM student")
   public List<StudentVO> studentListData();
   
   @Insert("INSERT INTO student VALUES(#{hakbun},#{name},#{kor},#{eng},#{math})")
   public void studentInsert(StudentVO vo);
}
