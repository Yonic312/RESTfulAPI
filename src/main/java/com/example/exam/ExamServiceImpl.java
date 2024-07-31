package com.example.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	private ExamDao dao ;
	
	@Override
	public List<ExamVO> getExamList(ExamVO vo) {

		return dao.getExamList(vo);
	}

}
