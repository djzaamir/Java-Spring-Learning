package com.djzaaamir.LearningSpring.service;

import com.djzaaamir.LearningSpring.dao.StudentDao;
import com.djzaaamir.LearningSpring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository("StudentService")
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("FakeStudentDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int persistNewStudent(UUID id, Student student) {
        UUID final_id_to_insert =  id == null ? UUID.randomUUID() : id;
        student.setId(final_id_to_insert);
        return studentDao.insertNewStudent(final_id_to_insert, student);
    }

    public Student getStudentById(UUID studentId) {
        return studentDao.selectStudentById(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public int updateStudentById(UUID id, Student newStudent) {
        return studentDao.updateStudentById(id, newStudent);
    }

    public int deleteStudentById(UUID id) {
        Student studentById = getStudentById(id);
        if (studentById == null) return -1;
        return studentDao.deleteStudentById(id);
    }
}
