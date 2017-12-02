package com.mail.secure.securemail;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

import io.realm.Realm;

public class userInfo implements AsyncResponse {

    private Context context;
    private String email;
    private String pass;
    private String phone;

    public void pushInfo(String email,String pass,String phone,Context context){
        // تخزن البيانات الي ارسلها المسخدم في مخازن عشان اذا نجح الموضوع تخزنها بعدين في قاعدة البيانات
        this.context=context;
        this.email  = email;
        this.pass = pass;
        this.phone = phone;
        //هنا تسوي الاتصال مع قاعدة البيانات تاخذ اليوزر والباس
        HashMap postData = new HashMap();
        postData.put("txtUsername", email+"@localhost.com");
        postData.put("txtPassword", pass );
        postData.put("mobile", phone);


        //عشان يطلع حق الانتظار وقت ما يحاول جيب البيانات
        PostResponseAsyncTask task = new PostResponseAsyncTask(context, postData,this);
        task.execute("http://192.168.1.15/SecureMail-master/registration.php");// هنا يحاول يتصل وياخذ رقم الجوال حق المستخدم

    }

    public void pushInfoEmailServer(String email,String pass,Context context){
        this.context=context;
        this.email  = email;
        this.pass = pass;

        HashMap postData = new HashMap();
        postData.put("txtUsername", email);
        postData.put("txtPassword", pass );

        PostResponseAsyncTask task = new PostResponseAsyncTask(context, postData,this);
        task.execute("http://192.168.1.15/SecureMail-master/add_user.php");
    }
    @Override
    public void processFinish(String output) {
    }

}
