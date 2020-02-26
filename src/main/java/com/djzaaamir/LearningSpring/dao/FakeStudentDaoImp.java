package com.djzaaamir.LearningSpring.dao;

import com.djzaaamir.LearningSpring.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("FakeStudentDao") //Tells Spring to Instantiate instance of this class and use it in Dependency Injection
public class FakeStudentDaoImp implements StudentDao {
        private final Map<UUID ,Student> database;

    public FakeStudentDaoImp() {
        this.database = new HashMap<>();
    }

    @Override
        public int insertNewStudent(UUID id, Student student) {
            if (id == null || student == null) return -1;
            database.put(id , student);
            return 1;
        }

        @Override
        public Student selectStudentById(UUID studentId) {
            if (studentId == null) return null;
            return database.get(studentId);
        }

        @Override
        public List<Student> selectAllStudents() {
            return new ArrayList<>(database.values());
        }

        @Override
        public int updateStudentById(UUID id, Student newStudent) {
            if (id == null || newStudent == null) return -1;
            database.put(id, newStudent);
            return 1;
        }

        @Override
        public int deleteStudentById(UUID id) {
            if (id == null) return -1;
            database.remove(id);
            return 1;
        }
}
