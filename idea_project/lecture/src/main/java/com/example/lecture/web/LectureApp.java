package com.example.lecture.web;

import com.example.lecture.domain.Lecture;
import com.example.lecture.service.LectureService;
import com.example.lecture.dataAnalyze.NumChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exer")
public class LectureApp {
    private String[] departments = {"BIO", "BME", "Chemistry", "CSE",
            "EE", "ESE", "FIN", "MAE", "Math", "MED", "MEE", "Ocean", "Physics"};

    private int minyear = 2015;
    private int maxyear = 2019;

    @Autowired
    private LectureService lService;

    @GetMapping("/lecture")
    public List<Lecture> findall(){
        return lService.findall();
    }

    @PostMapping("/lecture")
    public Lecture addOne(Lecture lecture){
        return lService.save(lecture);
    }

    @PutMapping("/lecture")
    public Lecture update(@RequestParam long id,
                              @RequestParam String title,
                              @RequestParam String link,
                              @RequestParam String speaker,
                              @RequestParam String lecture_date,
                              @RequestParam String venue,
                              @RequestParam String department) {
        Lecture lecture = new Lecture();
        lecture.setId(id);
        lecture.setTitle(title);
        lecture.setLink(link);
        lecture.setSpeaker(speaker);
        lecture.setLecture_date(lecture_date);
        lecture.setVenue(venue);
        lecture.setDepartment(department);
        return lService.save(lecture);
    }

    @DeleteMapping("lecture/{id}")
    public void deleteOne(@PathVariable long id){
        lService.deteleById(id);
    }

    @GetMapping("lecture/{id}")
    public Lecture findOne(@PathVariable long id){
        return lService.findById(id);
    }

    @GetMapping("lecture/findLike/{title}")
    public List<Lecture> findByTitleLike(@PathVariable String title){
        return lService.findByTitleLike(title);
    }

    @GetMapping("lecture/getChange")
    public List<NumChange> getChange(){
        return lService.getChange();
    }

//    @GetMapping("lecture/getCloud")
//    public String getCloud(){
//        return lService.getCloud();
//    }

//    @PostMapping("lecture/count")
//    public Long countByDepartment(@RequestParam String department){
//        return lService.countByDepartment(department);
//    }
}