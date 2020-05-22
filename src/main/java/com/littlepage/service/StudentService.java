package com.littlepage.service;

import com.littlepage.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> selectStudents(int start, int count);

    Student selectStudent(int id);

    boolean insertStudent(Student student);

    boolean deleteStudent(int id);

    List<Student> search(String message);

    boolean update(Student student);

    int makePageList(int pageSize);
}
