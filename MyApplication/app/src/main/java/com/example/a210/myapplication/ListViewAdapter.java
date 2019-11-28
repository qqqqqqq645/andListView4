package com.example.a210.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.BaseAdapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<>();

    public ListViewAdapter() {
        /*세마포어 개념
        * a b c 클래스가 공유하는 static변수
        * 한번에하나씩만 static변수에 접근하게해서 데이터 일관성 유지*/
    }

    public ListViewAdapter(ArrayList<ListViewItem> data) {
        this.listViewItemList = data;
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        //listview_item Layout을 inflate 하여 convertView 참조 획득.

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row, parent, false);
        }
        //이미지뷰 선택 클릭 시
       ImageView button = (ImageView) convertView.findViewById(R.id.imageView2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context,pos+"번째 선택", Toast.LENGTH_SHORT).show();

                //다이얼로그 바디
                AlertDialog.Builder alertdialog = new AlertDialog.Builder(context);

                //다이얼로그 메세지
                alertdialog.setMessage(listViewItemList.get(pos).getDesc()+"으로 전화하시겠습니까?");

                //확인버튼
                alertdialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"'확인' 버튼을 눌렀습니다.",Toast.LENGTH_SHORT).show();
                        //전화번호를 표시만 해주는 기능
                        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-2222"));
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+listViewItemList.get(pos).getDesc()));
                        context.startActivity(intent);
                    }
                });
                alertdialog.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context,"'취소' 버튼을 눌렀습니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                //메인 다이얼로그 생성
                AlertDialog alert = alertdialog.create();
                alert.setIcon(R.mipmap.ic_launcher);
                alert.setTitle("전화연결");
                alert.show();
            }
        });
/*
        ImageView button2 = (ImageView) convertView.findViewById(R.id.imageView1);
        button2.setOnClickListener((new View.OnClickListener) ){
            Intent it = new Intent(context, ProfileActivity.class);
            it.putExtra("image",pos);
            it.putExtra("title",listViewItemList.get(pos).getTitle());
            it.putExtra("desc",listViewItemList.get(pos).getDesc());
            it.putExtra("location",listViewItemList.get(pos).getLocation());

            context.startActivity(it);


        });
        */
        //프로필 사진 클릭시 프로필액티비티
        ImageView button2 = (ImageView) convertView.findViewById(R.id.imageView1);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, ProfileActivity.class);
                it.putExtra("image",pos);
                it.putExtra("title",listViewItemList.get(pos).getTitle());
                it.putExtra("desc",listViewItemList.get(pos).getDesc());
                it.putExtra("location",listViewItemList.get(pos).getLocation());

                context.startActivity(it);
            }});

/*
        ImageView button2 = (ImageView) convertView.findViewById(R.id.imageView1);
        button2.setOnClickListener(View v) ->{

                Intent it = new Intent(context, ProfileActivity.class);
                it.putExtra("image",pos);
                it.putExtra("title",listViewItemList.get(pos).getTitle());
                it.putExtra("desc",listViewItemList.get(pos).getDesc());
                it.putExtra("location",listViewItemList.get(pos).getLocation());

                context.startActivity(it);
            });
*/
        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.imageView1);
        TextView titleTextView = (TextView) convertView.findViewById(R.id.textView1);
        TextView descTextView = (TextView) convertView.findViewById(R.id.textView2);
        TextView locationTextView = (TextView) convertView.findViewById(R.id.textView3);

        //Data Set(listViewTtemList)에서 position 에 위치한 데이터 참조 획득
        ListViewItem listViewItem = listViewItemList.get(position);

        //아이테 내 각 위젯에 데이터 반영
        iconImageView.setImageDrawable(listViewItem.getIcon());
        titleTextView.setText(listViewItem.getTitle());
        descTextView.setText(listViewItem.getDesc());
        locationTextView.setText(listViewItem.getLocation());
        return convertView;
    }

    //지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴 : 필수 구현
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    public void addItem(Drawable icon, String title, String desc, String location) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setTitle(title);
        item.setDesc(desc);
        item.setLocation(location);

        listViewItemList.add(item);
    }

}
