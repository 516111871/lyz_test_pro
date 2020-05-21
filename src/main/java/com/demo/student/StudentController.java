package com.demo.student;

import com.demo.common.model.Student;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

public class StudentController extends Controller {
    @Inject
    StudentService service;

    public void index(String stuname){
        setAttr("name",stuname);
        setAttr("student",service.paginate(getParaToInt(0,1),5,stuname));
        render("/page/student/student.html");
    }

    public void add(){
        render("/page/student/add.html");
    }

    public void edit(int id){
        System.err.println("id-------------"+id);
       setAttr("student",service.queryById(id));
        render("/page/student/edit.html");
    }

    public void addsave(){
        service.addsave(getBean(Student.class));
       redirect("/student");
    }
    public void update(){
        service.update(getBean(Student.class));
       redirect("/student");
    }

    public void delete(int id){
        service.delete(id);
       redirect("/student");
    }

}
