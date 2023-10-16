package org.example.service;

import java.util.List;
import org.example.model.Grade;
import org.example.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademicRecordServiceImpl implements AcademicRecordService {

  private static final Logger logger = LoggerFactory.getLogger(AcademicRecordServiceImpl.class);
  private final GradeRepository gradeRepository;

  public AcademicRecordServiceImpl(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }

  @Override
  public Double calculateAverage() {
      System.out.println("Sacando promedio de calificaciones");
      logger.info("Sacando promedio de calificaciones");
      logger.warn("Sacando promedio de calificaciones");
      logger.error("Sacando promedio de calificaciones");

      List<Grade> gradeList = this.gradeRepository.findAllGrades();
      {
          if (gradeList.isEmpty()) {
              logger.warn("No grades to calculate average from.");
              return 0.0;
          }

          double sum = 0;
          for (int i = 0; i < gradeList.size(); i++) {
              sum += gradeList.get(i).grade();
          }

          return sum / gradeList.size();


      }
  }

  @Override
      public Integer sumNumberOfGrades() {
          System.out.println("Sumando el número de calificaciones");
          logger.info("Sumando el número de calificaciones");
          logger.warn("Sumando el número de calificaciones");
          logger.error("Sumando el número de calificaciones");

          List<Grade> gradeList = this.gradeRepository.findAllGrades();

          int sum = gradeList.size();
          logger.info("Total number of grades: " + sum);
          return sum;

      }

}
