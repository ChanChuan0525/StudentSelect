package com.chanchuan.greendao;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.chanchuan.bean.Student;

import java.util.List;

public class MyApp extends Application {
    public static DaoSession daoSession;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "student.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        daoSession = daoMaster.newSession();
    }

    public static boolean queryOne(Student student) {               //查询是否存在
        Student unique = daoSession.queryBuilder(Student.class)
                .where(StudentDao.Properties.Number.eq(student.getNumber()))
                .unique();
        return unique == null ? true : false;
    }

    public static void delete(Student student) {
        if (!queryOne(student)) {
            daoSession.delete(student);
            Toast.makeText(context, "✔ 删除成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "删除失败", Toast.LENGTH_SHORT).show();
        }
    }

    public static void insert(Student student) {        //插入方法
        if (queryOne(student)) {
            daoSession.insert(student);
            Toast.makeText(context, "✔ 新增成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "该学号已被使用", Toast.LENGTH_SHORT).show();
        }
    }

    public static void update(Student student) {
        if (!queryOne(student)) {
            daoSession.update(student);
            Toast.makeText(context, "✔修改成功", Toast.LENGTH_SHORT).show();
        }
    }

    public static void deleteStudent(String number) {
        if (number.equals("")) {
            Toast.makeText(context, "删除失败", Toast.LENGTH_SHORT).show();
        } else {
            Student student = selectOne(number);
            if (student == null) {
                Toast.makeText(context, "删除失败", Toast.LENGTH_SHORT).show();
            } else {

                delete(student);
            }

        }
    }

    public static Student selectOne(String number) {
        Student unique = daoSession.queryBuilder(Student.class)
                .where(StudentDao.Properties.Number.eq(number))
                .unique();
        return unique;
    }

    public static List<Student> select() {
        List<Student> students = daoSession.loadAll(Student.class);
        return students;
    }
}
