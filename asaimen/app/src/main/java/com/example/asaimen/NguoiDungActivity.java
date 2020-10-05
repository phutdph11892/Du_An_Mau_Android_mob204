package com.example.asaimen;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asaimen.Dao.NguoiDungDao;
import com.example.asaimen.Model.NguoiDung;

public class NguoiDungActivity extends AppCompatActivity {
    EditText edUser, edPass, edRePass, edphone, edFullName;
    NguoiDungDao nguoiDungDao;
    String edt1,edt2,edt3,edt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);
        setTitle("Them Nguoi Dung");
        edUser=(EditText) findViewById(R.id.edUserName);
        edPass=(EditText) findViewById(R.id.edPassword);
        edRePass=(EditText) findViewById(R.id.edRePassword);
        edphone=(EditText) findViewById(R.id.edPhone);
        edFullName=(EditText) findViewById(R.id.edFullName);

        //lay ve intent
//        Intent intent =getIntent();
//        if(intent!=null){
//            Bundle bundle = intent.getBundleExtra("bun");
        //            edUser.setText(bundle.getString("userName_key"));
        //            edPass.setText(bundle.getString("passWord_key"));
        //            edphone.setText(bundle.getString("phone_key"));
        //            edFullName.setText(bundle.getString("hoTen_key"));
//        }


        //don nhan du lieu tu adapetr den
//        Intent intent = getIntent();
//        if(intent!=null){//neu co du lieu thi giai nen bundle
//          //  giai nen bundle
//            Bundle bundle =intent.getBundleExtra("bun");
//            // dien dun lieu bundle vao from
//
//             edt1=bundle.getString("userName_key");
//             edt2=bundle.getString("passWord_key");
//            edt3=bundle.getString("phone_key");
//             edt4=bundle.getString("hoTen_key");
//
//            edUser.setText(bundle.getString("userName_key"));
//            edPass.setText(bundle.getString("passWord_key"));
//            edphone.setText(bundle.getString("phone_key"));
//            edFullName.setText(bundle.getString("hoTen_key"));
//
//       }
    //    edUser.setText(edt1);
   //    edPass.setText(edt2);
    //    edphone.setText(edt3);
      //  edFullName.setText(edt4);

    }

    public void addUser(View view) {
        nguoiDungDao=new NguoiDungDao(NguoiDungActivity.this);
        NguoiDung nguoiDung=new NguoiDung(edUser.getText().toString(), edPass.getText().toString(),
                edphone.getText().toString(), edFullName.getText().toString());

        try {
               if(nguoiDungDao.insertNguoiDung(nguoiDung)>0){
                   Toast.makeText(getApplicationContext(),"Them Thanh Cong",Toast.LENGTH_LONG).show();
               }else{
                   Toast.makeText(getApplicationContext(),"Them That Bai",Toast.LENGTH_LONG).show();
               }
        }catch (Exception e){
            Log.e("Loi",e.toString());
        }
    }

    public void showUsers(View view) {
        Intent intent = new Intent(NguoiDungActivity.this,ListNguoiDungActivity.class);
        startActivity(intent);
    }

    //xu li button update
    public void updateUser(View view){
//        nguoiDungDao = new NguoiDungDao(NguoiDungActivity.this);
//        NguoiDung nguoiDung = new NguoiDung(edUser.getText().toString(),edPass.getText().toString()
//                ,edphone.getText().toString(),edFullName.getText().toString());
//        if(nguoiDungDao.updateInfoNguoiDung(edUser.getText().toString(),edphone.getText().toString(),edFullName.getText().toString())==1){
//            Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_LONG).show();
//        }else{
//            Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_LONG).show();
//        }


        nguoiDungDao=new NguoiDungDao(NguoiDungActivity.this);
        //lay nguoi dung can update
        NguoiDung nguoiDung = new NguoiDung(edUser.getText().toString(),edPass.getText().toString()
        ,edphone.getText().toString(),edFullName.getText().toString());
        //thuc hien update
        if(nguoiDungDao.updateInfoNguoiDung(nguoiDung.getUserName(),nguoiDung.getPhone(),nguoiDung.getHoTen())==1){
           Toast.makeText(getApplicationContext(),"Update thanh cong",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Update that bai",Toast.LENGTH_LONG).show();
        }
    }
}
