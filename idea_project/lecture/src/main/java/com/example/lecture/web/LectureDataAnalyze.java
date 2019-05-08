package com.example.lecture.web;

import com.example.lecture.domain.Lecture;
import com.example.lecture.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LectureDataAnalyze {
    @Autowired
    private LectureService lectureService;

    @GetMapping("/allLecture2")
    public String list(Model model){
        List<Lecture> lectureList=lectureService.findall();
        model.addAttribute("lecture",new Lecture());
        model.addAttribute("lectureList",lectureList);

//        List<Long> depatmentCount = new ArrayList<Long>();
//        depatmentCount.add(lectureService.countByDepartment("Math"));
//        depatmentCount.add(lectureService.countByDepartment("Ess"));
        List<Long> depatmentCount = getDepatmentCount();
        model.addAttribute("depatmentCount",depatmentCount);

        System.out.println("depatmentCount");
        System.out.println(depatmentCount);
        System.out.println(depatmentCount.get(0));
        System.out.println(depatmentCount.get(1));

        return "lectureList";
    }

    public List<Long> getDepatmentCount() {
        System.out.println("getDepatmentCount!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Long> depatmentCount = new ArrayList<Long>();
        depatmentCount.add(lectureService.countByDepartment("Math"));
        depatmentCount.add(lectureService.countByDepartment("Ess"));
        return depatmentCount;
    }

}