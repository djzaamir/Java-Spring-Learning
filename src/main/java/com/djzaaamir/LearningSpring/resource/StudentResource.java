package com.djzaaamir.LearningSpring.resource;

import com.djzaaamir.LearningSpring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.djzaaamir.LearningSpring.service.StudentService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/students")
public class StudentResource {

    private final StudentService studentService;

    @Autowired
    public StudentResource(@Qualifier("StudentService") StudentService studentService) {
        this.studentService = studentService;

        //Add Mock User
        UUID uuid = UUID.randomUUID();
        this.studentService
                .persistNewStudent(uuid,new Student(uuid,"Aamir",16));
    }

    //region Get Data /students and /students/:ID
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "{studentID}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Student getStudentById(@PathVariable ("studentID") UUID id){
        return studentService.getStudentById(id);
    }
    //endregion

    //region POST /students
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String insertNewStudent(@RequestBody Student student){
        UUID final_id = UUID.randomUUID();
        studentService.persistNewStudent(final_id, student);
        return "Successful Insertion";
    }
    //endregion

    //region Update|PUT /students/
    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String updateStudentByID(@RequestBody Student student){
        return studentService.updateStudentById(student.getId(),student) == -1 ? "Update Failed" : "Successfully updated";
    }
    //endregion//

    // region DELETE /students
    @RequestMapping(
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String deleteStudentByID(@RequestBody Student student){
        return studentService.deleteStudentById(student.getId()) == -1 ? "Deletion Failed" : "Successfully Deleted";
    }
    //endregion
}
