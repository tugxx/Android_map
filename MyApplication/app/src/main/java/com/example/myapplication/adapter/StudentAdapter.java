package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import com.example.myapplication.R;
import com.example.myapplication.model.StudentModel;


import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends BaseAdapter implements Filterable {
    private Context context;
    // Dữ liệu
    final ArrayList<StudentModel> ListStudent;

    public StudentAdapter(Context context, ArrayList<StudentModel> lissClass) {
        this.context = context;
        this.ListStudent = lissClass;
    }


    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return ListStudent.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        return ListStudent.get(position);
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
            viewClass = View.inflate(parent.getContext(), R.layout.layoutcustom_recyclerview_classlist, null);
        } else viewClass = convertView;
        StudentModel student_list = (StudentModel) getItem(position);
        ((TextView) viewClass.findViewById(R.id.txtName)).setText(String.format(student_list.getStudent_name()));

        return viewClass;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

}

