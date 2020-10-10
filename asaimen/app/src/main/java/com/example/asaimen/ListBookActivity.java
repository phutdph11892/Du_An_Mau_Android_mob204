package com.example.asaimen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asaimen.Adapter.SachRecAdapter;
import com.example.asaimen.Dao.SachDao;
import com.example.asaimen.Model.Sach;

import java.util.ArrayList;
import java.util.List;

public class ListBookActivity extends AppCompatActivity {
public static List<Sach> sachList = new ArrayList<>();
SachDao sachDao;
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        recyclerView=findViewById(R.id.rcBook);
        sachDao = new SachDao(ListBookActivity.this);
        sachList=sachDao.getAllSach();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        SachRecAdapter adapter = new SachRecAdapter(ListBookActivity.this,sachList);
        recyclerView.setAdapter(adapter);
    }
}
