package com.example.TP2.Controller;

import com.example.TP2.Model.Course;
import com.example.TP2.Model.Student;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private List<Course> courses;

    public Controller() {
        courses = new ArrayList<>();

        Course course1 = new Course(1, "ANGULAR");
        course1.addStudent(new Student(1, "Samba Diouf", "A"));
        course1.addStudent(new Student(2, "Fatou fall", "B"));
        courses.add(course1);

        Course course2 = new Course(2, "SPRING");
        course2.addStudent(new Student(3, "Cheikh ndongo", "C"));
        courses.add(course2);
    }

    @GetMapping("/")
    public String listCourses(Model model) {
        model.addAttribute("courses", courses);
        return "list";
    }

    @GetMapping("/course/{id}")
    public String viewCourse(@PathVariable int id, Model model) {
        Course course = findCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
            return "view";
        } else {

            return "error";
        }
    }

    @GetMapping("/course/{id}/students")
    public String viewCourseStudents(@PathVariable int id, Model model) {
        Course course = findCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
            return "students";
        } else {
            return "error";
        }
    }

    @GetMapping("/course/{id}/add-student")
    public String showAddStudentForm(@PathVariable int id, Model model) {
        Course course = findCourseById(id);
        if (course != null) {
            model.addAttribute("course", course);
            model.addAttribute("student", new Student(1,"INSA BA","C"));
            return "add-student";
        } else {
            return "error";
        }
    }

    @PostMapping("/course/{id}/add-student")
    public String addStudentToCourse(@PathVariable int id, @ModelAttribute Student student) {
        Course course = findCourseById(id);
        if (course != null) {
            course.addStudent(student);
            return "redirect:/course/" + id + "/students";
        } else {
            return "error";
        }
    }

    private Course findCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
}
