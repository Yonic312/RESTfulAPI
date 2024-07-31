package com.example.exam;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ExamDao {
  List<ExamVO> getExamList(ExamVO vo);
}
