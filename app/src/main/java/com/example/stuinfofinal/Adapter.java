package com.example.stuinfofinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;


/**
 * Created by 梅梅 on 2015/12/8.
 */
public class Adapter extends ArrayAdapter<Item>{
    //private List<Item> data = new ArrayList<>();

    //private int resourceId;

    public Adapter(Context context, int resource, List<Item> objects) {
        super(context, resource, objects);
       // resourceId = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item item = getItem(position);
//        View view = LayoutInflater.from(getContext()).inflate(R.layout.item,null);//将xml转化为view
        View view;
        ViewHodler viewHodler;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.item,null);
            viewHodler = new ViewHodler();
            viewHodler.imageView = (ImageView)
                    view.findViewById(R.id.ImageView);
            viewHodler.textView = (TextView)
                    view.findViewById(R.id.TextView);
            view.setTag(viewHodler); //将ViewHolder存储在view中
        }
        else {
            view = convertView;
            viewHodler = (ViewHodler) view.getTag(); //重新获取ViewHolder
        }
//        ImageView imageView = (ImageView)
//                view.findViewById(R.id.ImageView);
//        TextView textView = (TextView)
//                view.findViewById(R.id.TextView);
        viewHodler.imageView.setImageResource(item.getImageview());
        viewHodler.textView.setText(item.getText());
        return view;

    }

}

class ViewHodler{
    ImageView imageView;
    TextView textView;
}

class Item implements Serializable { //序列化
    private String text;
    private int imageview;

    public Item(String text,int imageview){
        this.text = text;
        this.imageview = imageview;
    }

    public String getText(){
        return text;
    }
    public int getImageview(){
        return imageview;
    }
}

class  StuinfoItem implements Serializable{
    private String stuname;
    private String stuprofessional;
    private String stuclass;
    private String stugrade;

    public StuinfoItem(String stuname,String stuprofessional,String stuclass,String stugrade){
        this.stuname = stuname;
        this.stuprofessional = stuprofessional;
        this.stuclass = stuclass;
        this.stugrade = stugrade;
    }
    public String  getStuname(){
        return stuname;
    }
    public  String getStuprofessional(){
        return stuprofessional;
    }
    public  String getStuclass(){
        return stuclass;
    }
    public  String getStugrade(){
        return stugrade;
    }
}