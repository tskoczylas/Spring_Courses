package com.tomsapp.Toms.V2.controller;

import com.tomsapp.Toms.V2.entity.Books;
import com.tomsapp.Toms.V2.entity.Students;
import com.tomsapp.Toms.V2.service.BooksService;
import com.tomsapp.Toms.V2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

@Autowired
    BooksService booksService;

    @GetMapping("/list")
    public String createList(Model model){

        List<Students> studentsList =studentService.getStudents();

        model.addAttribute("list",studentsList);

        return "showStudentForm";
    }

    @GetMapping("/showaddform")
        public String showaddform(Model model) {

        Students students= new Students();
        model.addAttribute("stu",students);


        return "addStudentForm";
    }
    @PostMapping("/save")
          public String saveStudents(@ModelAttribute() Students tempStudents){
        studentService.saveSrudent(tempStudents);
        return "redirect:/students/list";
        }
@GetMapping("/updateform")
    public String updateStudent(@RequestParam("studentid") int studentID, Model model)

{
    Students students = studentService.findbyId(studentID);



    model.addAttribute("stu",students);

    return "addStudentForm";
}

@GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("studentId") int studentId){
    System.out.println(studentId);

        studentService.deleteStudentbyId(studentId);

    return "redirect:/students/list";

}

@GetMapping("/listOfBoroowingStudents")
    public String listOfBoroowingStudents(@RequestParam("studentId") int id, Model model){
    Students students = studentService.findbyId(id);
    List<Books> books = booksService.getBooks();
    List<Books> boroowingBooks = books.stream().filter(s -> s.getManyStudents().equals(students)).collect(Collectors.toList());

    model.addAttribute("borrowingStudents",boroowingBooks);

        return "showBorrowingStudent";

}

@GetMapping("/findStudent")
    public String findStudent(Model model,@RequestParam("searchStudent") String shearchField)
    {
        List<Students> students = studentService.getStudents();
        List<Students> resoultOfFindiStudents = students.stream().filter(s ->( s.getFirstName().equals(shearchField))||s.getLastName().equals(shearchField)||(s.getFirstName()+" "+s.getLastName()).equals(shearchField)).collect(Collectors.toList());

        if(resoultOfFindiStudents.isEmpty())
    model.addAttribute("list",students);
        else
            model.addAttribute("list",resoultOfFindiStudents);


        return "showStudentForm";
}









}
