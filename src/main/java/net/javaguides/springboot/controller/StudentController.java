package net.javaguides.springboot.controller;

import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
  @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student=new Student(
                1,
                "ram",
                "das"
        );
       // return ResponseEntity.ok(student);
          return ResponseEntity.ok()
                  .header("custom-header","ram")
                  .body(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
      List<Student> students=new ArrayList<>();
      students.add(new Student(1,"ram","das"));
      students.add(new Student(2,"raj","das"));
      students.add(new Student(3,"hari","das"));
      return ResponseEntity.ok(students);
    }


    //path variable
  //http://localhost:8080/students/1/ram/das
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstname,
                                       @PathVariable("last-name") String lastname){
      Student student= new Student(studentId,firstname,lastname);
      return ResponseEntity.ok(student);
    }

    //request parameter
  //http://localhost:8080/students/query?id=1&firstname=ram&lastname=das
  @GetMapping("query")
  public ResponseEntity<Student> studentReqVar(@RequestParam int id,
                               @RequestParam String firstname,
                               @RequestParam String lastname){
    Student student=  new Student(id,firstname,lastname);
    return ResponseEntity.ok(student);
  }

  //post request
  //http://localhost:8080/students/create
  @PostMapping("create")
  //@ResponseStatus(HttpStatus.ACCEPTED)
  public ResponseEntity<Student> createStudent(@RequestBody Student student){
    System.out.println(student.getId());
    System.out.println(student.getFirstname());
    System.out.println(student.getLastname());
    return new ResponseEntity<>(student,HttpStatus.CREATED);

  }

  //put request
  //http://localhost:8080/students/1/update
  @PutMapping("{id}/update")
  public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") int studentId ){
    System.out.println(student.getFirstname());
    System.out.println(student.getLastname());
    return ResponseEntity.ok(student);
  }

  //delete request
  @DeleteMapping("{id}/delete")
  public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
    System.out.println(studentId);
    return ResponseEntity.ok("student deleted successfully") ;
  }
}
