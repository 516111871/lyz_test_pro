package com.demo.student;

import com.demo.common.model.Student;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.SqlPara;

public class StudentService {
    Student dao = new Student().dao();

    public Page<Student> paginate(int pageNumber, int pageSize,String sname) {

        if (sname==null){
            return dao.paginate(pageNumber,pageSize,"select *","from student");
        }else{
            Kv par = Kv.by("name", sname.trim());
            SqlPara sqlpar = Db.getSqlPara("student.queryByName", par);
          //  return dao.paginate(pageNumber,pageSize,"select *","from  student where stuname like concat('%','"+sname.trim()+"','%')");
            return dao.paginate(pageNumber,pageSize,sqlpar);
        }

    }

    public void addsave(Student student) {
        System.err.println(student.getStuname());
        student.save();
    }

    public void update(Student student) {
        student.update();
    }

    public Student queryById(int id) {
      return dao.findById(id);
    }

    public void delete(int id) {
        dao.deleteById(id);
    }
}
