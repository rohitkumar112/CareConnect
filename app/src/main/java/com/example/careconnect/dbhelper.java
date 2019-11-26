package com.example.careconnect;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {
    public dbhelper(@Nullable Context context) {
        super(context, "dbconnection", null, 1);
    }
    private static final String CREATE_USER_TABLE = "CREATE TABLE [userProfile] ( [userId] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT," +
            " [name] TEXT ," +
            " [pass] TEXT ,"+
            " [phonenumber] TEXT ,"+
            " [bloodgroup] TEXT ,"+
            " [email] TEXT );"
            ;
    private static final String CREATE_department_table = "CREATE TABLE [departmentt] ( [departmentid] INTEGER NOT NULL PRIMARY KEY ," +
            " [departmentname] TEXT );"
            ;
    private static final String CREATE_department = "CREATE TABLE [department] ( [departmentid] INTEGER NOT NULL PRIMARY KEY ," +
            " [departmentname] TEXT );"
            ;

    private static final String table_name="userProfile";
    private static final String userdepartment="departmentt";
    private static final String department="department";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_department_table);
        sqLiteDatabase.execSQL(CREATE_department);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+userdepartment);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+department);
        onCreate(sqLiteDatabase);
    }
    public void userdepartment(userdepartmentmodel user)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("departmentid",user.getDepartmentid());
        contentValues.put("departmentname",user.getDeparatmentname());

        //        contentValues.put("bloodgroup",s.getBloodgroup());
//        contentValues.put("phonenumber",s.getPhonenumber());
        SQLiteDatabase db =getWritableDatabase();
        Long i= db.insert(userdepartment,null,contentValues);
//        if(i>0)
//        {
//
//            return 1;
//        }
//        else
//        {
//            return 0;
//        }

    }
    public int adddepartment(adddepartmentmodel adddepartmentmodel)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put("departmentid",adddepartmentmodel.getId());
        contentValues.put("departmentname",adddepartmentmodel.getName());
        //        contentValues.put("bloodgroup",s.getBloodgroup());
//        contentValues.put("phonenumber",s.getPhonenumber());
        SQLiteDatabase db =getWritableDatabase();
        Long i= db.insert(department,null,contentValues);
        if(i>0)
        {
            return  1;
        }
        else
        {
            return 0;
        }
    }
    public int insert(signinmodel s)
    {
        ContentValues contentValues=new ContentValues();
contentValues.put("name",s.getName());
contentValues.put("pass",s.getPass());
contentValues.put("email",s.getEmail());
contentValues.put("bloodgroup",s.getBloodgroup());
        contentValues.put("phonenumber",s.getPhonenumber());
        SQLiteDatabase db =getWritableDatabase();
       Long i= db.insert(table_name,null,contentValues);
        if(i>0)
        {

            return 1;
        }
        else
        {
            return 0;
        }
        }
        public int verifyuser(verifymodel s)
        {
            SQLiteDatabase db=getReadableDatabase();
            Cursor cursor=db.rawQuery("Select * from userProfile where name='"+s.getName()+"'",null);
            int count=cursor.getCount();
            return count;
        }

}
