/*
* The reason for writing this Interface is to introduce flexibility
* for Different DAO sources in the future
* So for example
*   1) DAO can be fake one
*   2) DAO can be connected to real database
*   3) DAO can be connected to multiple databases
*
*  But for the end user of this DAO won't have to worry about changing their usage of code
*  because all of the above DAO will implements all of the following methods
* */

package com.djzaaamir.LearningSpring.dao;

import com.djzaaamir.LearningSpring.model.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDao {
    /**
     *
     * @param id
     * @param student
     * @return 1 for success and -1 for failure
     */
    int insertNewStudent(UUID id, Student student);
    Student selectStudentById(UUID studentId);
    List<Student> selectAllStudents();
    int updateStudentById(UUID id, Student newStudent);
    int deleteStudentById(UUID id);
}
