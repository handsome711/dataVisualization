package com.example.lecture.service;

import com.example.lecture.api.LectureRepository;
import com.example.lecture.domain.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.lecture.dataAnalyze.NumChange;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LectureService {
    private String[] departments = {"BIO", "BME", "Chemistry", "CSE",
            "EE", "ESE", "FIN", "MAE", "Math", "MED", "MEE", "Ocean", "Physics"};

    private int minyear = 2015;
    private int maxyear = 2019;


    @Autowired
    private LectureRepository lRepository;

    public List<Lecture> findall(){
        return lRepository.findAll();
    }

    public Lecture save(Lecture transaction){
        return lRepository.save(transaction);
    }

    public void deteleById(long id){
        lRepository.deleteById(id);
    }

    public Lecture findById(long id) {
        return lRepository.findById(id).get();
    }

    public List<Lecture> findByTitleLike(String title){
        return lRepository.findByTitleLike(title);
    }

    public Long countByDepartment(String department){
        return lRepository.countByDepartment(department);
    }

    public Long countByYearAndDepartment(int year, String department){
        return lRepository.countByYearAndDepartment(String.valueOf(year), department);
    }

    public List<NumChange> getChange(){
        List<NumChange> numChanges = new ArrayList<NumChange>();
        for (int i = minyear; i <= maxyear; i++) {
            String year = String.valueOf(i);
            for (int j = 0; j < departments.length; j++) {
                String department = departments[j];
                String totalNum = String.valueOf(countByYearAndDepartment(i, department));
                numChanges.add(new NumChange(year, department, totalNum));
            }
        }
        return numChanges;
    }
}