package com.littlepage.servlet.studentmanage.admin;

import com.littlepage.entity.Student;
import com.littlepage.service.StudentService;
import com.littlepage.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/manage/admin/showstudents")
public class ShowStudent extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageNum = req.getParameter("pageNum");
        int currentPage = 0;
        if(pageNum != null) currentPage = Integer.parseInt(pageNum);
//        List<Student> students = studentService.selectStudents(0, 10);
//        System.out.println(students);
        List<Student> students = studentService.selectStudents(currentPage * 15, 15);
        int pageCount = studentService.makePageList(15);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("students", students);
        req.getRequestDispatcher("dashboard-root.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
