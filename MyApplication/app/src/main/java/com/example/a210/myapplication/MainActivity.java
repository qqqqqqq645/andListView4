package com.example.a210.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListViewItem data;
    private ArrayList<ListViewItem> arrays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = null;
        ListViewAdapter adapter;
        arrays = new ArrayList<ListViewItem>();
        //데이터 추가 부분
        initialData();//서버로부터 데이터 받기 또는 로컬 sqllite3으로부터 데이터 읽어오룻있다
        listview = (ListView)findViewById(R.id.listview1);
        //adapter 생성
        adapter = new ListViewAdapter(arrays);
        Log.i("kani","test");
    /*
        //리스트뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        adapter.addItem(getResources().getDrawable(R.drawable.p1),"김관희","010-2333-3333","서울");
        adapter.addItem(getResources().getDrawable(R.drawable.p2),"박신혜","010-2333-4333","인천");
        adapter.addItem(getResources().getDrawable(R.drawable.p3),"이동건","010-2433-3333","해남");
     */
        //리스트뷰 참조 및 adapter 달기
        listview.setAdapter(adapter);
        //리스트뷰 아이템 클릭 이벤트 핸들러
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
             /*get item
             parent : ListView 자체에 대한 참조
             view 클릭이 발생한 뷰에 대한 참조
             position Adapter에서의 view의 position
             id ㅡㅋㄹ릭된 아이템의 row id
              */
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,position+"번째 선택\n "+ item.getTitle()+
                        item.getDesc()+ item.getLocation(), Toast.LENGTH_SHORT).show();

                //전화걸기
                //Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse(item.getDesc()));
                //startActivity(intent);
            }
        });



    }
    private void initialData(){
        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p1),"이은솔","010-2333-3333","서울");
        arrays.add(data);

        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p2),"김관희","010-2333-4333","인천");
        arrays.add(data);

        data = new ListViewItem();
        data.setData(getResources().getDrawable(R.drawable.p3),"이동건","010-2433-3333","해남");
        arrays.add(data);
    }
}
