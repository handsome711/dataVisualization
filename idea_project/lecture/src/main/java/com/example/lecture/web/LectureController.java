package com.example.lecture.web;

import com.example.lecture.domain.Lecture;
import com.example.lecture.service.LectureService;
import com.kennycason.kumo.*;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.example.lecture.web.LectureDataAnalyze;

import javax.sound.midi.SysexMessage;

@Controller
public class LectureController {
    @Autowired
    private LectureService lectureService;
    private String[] departments = {"BIO", "BME", "Chemistry", "CSE",
            "EE", "ESE", "FIN", "MAE", "Math", "MED", "MEE", "Ocean", "Physics"};

    private int minyear = 2015;
    private int maxyear = 2019;

    private void writeCsv(String context) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("department_change.csv");
            fw.write(context);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/allLecture")
    public String list(Model model){
        List<Lecture> lectureList=lectureService.findall();
        model.addAttribute("lecture",new Lecture());
        model.addAttribute("lectureList",lectureList);

        List<Long> departmentCount = getDepartmentCount();
        getDepartmentChange();
        model.addAttribute("departmentCount",departmentCount);

        System.out.println("departmentCount");
        System.out.println(departmentCount);


        return "lectureList";
    }

    private List<Long> getDepartmentChange() {
        List<Long> departmentCount = new ArrayList<Long>();
        String departmentChange = "year,department,totalNum\n";
        System.out.println("getDepartmentChange");
        for (int i = minyear; i <= maxyear; i++) {
            String year = String.valueOf(i);
            for (int j = 0; j < departments.length; j++) {
                String department = departments[j];
                String totalNum = String.valueOf(lectureService.countByYearAndDepartment(i, department));
                departmentChange += (year + "," + department + "," + totalNum +"\n");
            }
        }
        writeCsv(departmentChange);
        asaa();
        System.out.println("FrequencyAnalyzerend");
        return departmentCount;
    }

    public void asaa() {
        System.out.println("FrequencyAnalyzer");
        try {
            //建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
            FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
            frequencyAnalyzer.setWordFrequenciesToReturn(600);
            frequencyAnalyzer.setMinWordLength(2);

            //引入中文解析器
            frequencyAnalyzer.setWordTokenizer(new ChineseWordTokenizer());
            //指定文本文件路径，生成词频集合
            final List<WordFrequency> wordFrequencyList;
            wordFrequencyList = frequencyAnalyzer.load("E:\\wordcloud.txt");
            System.out.println(wordFrequencyList);
            //设置图片分辨率
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private List<Long> getDepartmentCount() {
        List<Long> departmentCount = new ArrayList<Long>();
        for (int i = 0; i < departments.length; i++)
            departmentCount.add(lectureService.countByDepartment(departments[i]));
        System.out.println(departmentCount);
        return departmentCount;
    }

    @GetMapping("/insertOneLec")
    public String addLecture(Model model){
        System.out.println("GetMapping insertOneLec");

        model.addAttribute("lecture",new Lecture());
        return "addLecture";
    }

    @PostMapping("/allLecture")
    public String saveNew(Lecture lecture,RedirectAttributes
            attributes){
        System.out.println("PostMapping allLecture");

        lectureService.save(lecture);
        attributes.addFlashAttribute("msg","Update has been saved");
        return "redirect:/allLecture";
    }

    @GetMapping("/findOneLec{id}")
    public String findLecture(@PathVariable long id, Model model){
        Lecture lecture=lectureService.findById(id);
        model.addAttribute("lecture",lecture);
        return "addLecture";
    }

    @GetMapping("/deleteOneLec{id}")
    public String deleteLecture(@PathVariable long id, RedirectAttributes
            attributes){
        lectureService.deteleById(id);
        attributes.addFlashAttribute("msg","Delete successfully");
        return "redirect:/allLecture";
    }

    @PostMapping("/search")
    public String findByTitleLike(Lecture lecture, Model model){
        String title = lecture.getTitle();
        System.out.println("title:"+title);
//        List<Long> departmentCount = LectureDataAnalyze.getDepartmentCount();
        List<Long> departmentCount = getDepartmentCount();
//        departmentCount.add(lectureService.countByDepartment("Math"));
//        departmentCount.add(lectureService.countByDepartment("Ess"));
        model.addAttribute("departmentCount",departmentCount);
        List<Lecture> lectureList=lectureService.findByTitleLike(title);

        model.addAttribute("lecture",lecture);
        model.addAttribute("lectureList",lectureList);
        return "lectureList";
    }
}