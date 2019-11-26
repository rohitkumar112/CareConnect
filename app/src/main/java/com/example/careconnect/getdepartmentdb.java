package com.example.careconnect;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class getdepartmentdb {
    public dbhelper helper;
    public SQLiteDatabase database;
       public void openRead() {
        this.database = loginactivity.dbhelpe.getReadableDatabase();
    }

    public void openWrite() {
        this.database = loginactivity.dbhelpe.getWritableDatabase();
    }




    public void close() {
        this.database.close();
    }

List<adddepartmentmodel> adddepartmentmodelList =new ArrayList<>();
    public List<adddepartmentmodel> getdepartment()
    {

        this.openRead();
    //    mydb = helper.getReadableDatabase();
        Cursor res = database.rawQuery("Select * from department", null);

       // UserInfoModel prof = new UserInfoModel();
         while (res.moveToNext()) {
             adddepartmentmodel adddepartment = new adddepartmentmodel();
             adddepartment.setId(res.getInt(res.getColumnIndex("departmentid")));
             adddepartment.setName(res.getString(res.getColumnIndex("departmentname")));
             //        prof.setUserFirstName(cursor.getString(1));
             adddepartmentmodelList.add(adddepartment);
             // get  the  data into array,or class variable
         }
       // adddepartmentmodelList.size();
        //this.close();
        return adddepartmentmodelList;
    }
}
