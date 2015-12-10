package com.example.stuinfofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Adapter adapter;
    private ListView listView;
    private List<Item> data = new ArrayList<>();
    private List<StuinfoItem> stuinfodata = new ArrayList<>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1、创建适配器
        //2、加载数据源
        adapter = new Adapter(this, R.layout.item, data);
        initdata();  //加载数据
        initstuinfodata();
        //3、视图加载适配器
        //((ListView)findViewById(R.id.listview)).setAdapter(adapter)
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
            int position, long id) {
         //     Toast.makeText(MainActivity.this,"点击了第"+position+"个item", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);//为什么this不可以，因为这里是匿名内部类
                intent.putExtra("item", data.get(position));//数据（Item）序列化了才可以传输   //所以上边的这里不能用this，不知道是哪个活动
                intent.putExtra("stuinfoitem",stuinfodata.get(position));
                startActivity(intent);
               // Log.i("text",data.get(position).getText());
            }
        });



    }


    private void initdata() {
        Item one = new Item("最帅的安卓学员", R.mipmap.ic_launcher);
        Item two = new Item("鑫锅", R.mipmap.ic_launcher);
        Item three = new Item("凌霄学姐", R.mipmap.ic_launcher);
        data.add(one);
        data.add(two);
        data.add(three);

        for(int i=0;i<20;i++){
            Item other = new Item("无名"+i,R.mipmap.ic_launcher);
            data.add(other);
        }


    }


    private void initstuinfodata(){
        //姓名、专业、班级、年级
        StuinfoItem one = new StuinfoItem("梅建丰","计算机大类","0401412","2014级");
        StuinfoItem two = new StuinfoItem("林龙鑫","计算机科学与技术","xxxxxxx","2013级");
        StuinfoItem three = new StuinfoItem("凌霄","软件工程","xxxxxxx","2014级");
        stuinfodata.add(one);
        stuinfodata.add(two);
        stuinfodata.add(three);

        for(int i=0;i<20;i++){
            StuinfoItem other = new StuinfoItem("无名"+i,"未知专业"+i,"xxxxxx"+i,"未知年级"+i);
            stuinfodata.add(other);
        }
    }
}
