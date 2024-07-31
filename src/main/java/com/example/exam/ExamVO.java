package com.example.exam;

import lombok.Data;

@Data
public class ExamVO {
  private String sno;
  private String sname;
  private int kor;
  private int eng;
  private int math;
  private int hist;
}
