package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.ClassModel;

import java.util.ArrayList;

public class ClassListAdapterForTeacherActivity extends BaseAdapter {
    // Dữ liệu
    private Context context;
    final ArrayList<ClassModel> LissClass;

    public ClassListAdapterForTeacherActivity(ArrayList<ClassModel> lissClass) {
        this.LissClass = lissClass;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return LissClass.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        return LissClass.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //convertView là View của phần tử ListView, nếu convertView != null nghĩa là
        //View này được sử dụng lại, chỉ việc cập nhật nội dung mới
        //Nếu null cần tạo mới
        View viewClass;
        if (convertView == null) {
            viewClass = View.inflate(parent.getContext(), R.layout.activity_class_view_custom_teacher, null);
        } else viewClass = convertView;
        ClassModel class_list = (ClassModel) getItem(position);
        ((TextView) viewClass.findViewById(R.id.text_name_class)).setText(String.format(class_list.getClass_name()));
        ((TextView) viewClass.findViewById(R.id.text_id_class)).setText(String.format(class_list.getClass_id()));
        ((TextView) viewClass.findViewById(R.id.text_totalstudentinclass)).setText(String.format(String.valueOf(class_list.getClass_Totalstudent())));
        return viewClass;
    }
}
