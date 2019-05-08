package com.example.lecture.api;

import com.example.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    @Query("select l from Lecture l where l.title like %:title%")
    List<Lecture> findByTitleLike(@Param("title")String title);

    @Query(value = "select count(*) from Lecture l where l.department like ?1", nativeQuery = true)
    Long countByDepartment(String department);

    @Query(value = "select count(*) from Lecture l where l.lecture_date like %:year% and l.department = :department", nativeQuery = true)
    Long countByYearAndDepartment(@Param("year")String year, @Param("department")String department);

    @Query("select min(l.lecture_date) from Lecture l where l.lecture_date like \"2%\"")
    String getMinDate();

    @Query("select max(l.lecture_date) from Lecture l where l.lecture_date like \"2%\"")
    String getMaxDate();

    @Query("select l from Lecture l where l.title like %:title% and l.lecture_date between minTime and maxTime " +
            "and l.speaker = speaker and l.department = department")
    List<Lecture> search(@Param("title")String title, @Param("minTime")String minTime, @Param("maxTime")String maxTime,
                         @Param("speaker")String speaker, @Param("department")String department);
}