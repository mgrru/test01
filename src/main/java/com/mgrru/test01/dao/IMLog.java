package com.mgrru.test01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mgrru.test01.model.MLog;


@Mapper
public interface IMLog {
  @Insert("insert into log values(#{time},#{desc})")
  void addLog(MLog mlog);

  @Select("select * from log")
  List<MLog> getLog();
}
