package com.example.myapplication.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.PresentStudentModel;
import com.example.myapplication.model.PresentTeacherModel;

import java.util.ArrayList;

public class TimePresentAdapterForTeacherActivity extends BaseAdapter {
    // Dữ liệu
    final ArrayList<PresentTeacherModel> ListTimePresent;

    public TimePresentAdapterForTeacherActivity(ArrayList<PresentTeacherModel> LissTimePresent) {
        this.ListTimePresent = LissTimePresent;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return ListTimePresent.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        return ListTimePresent.get(position);
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
            viewClass = View.inflate(parent.getContext(), R.layout.layoutcustom_presentteacher, null);
        } else viewClass = convertView;
        PresentTeacherModel Time_list = (PresentTeacherModel) getItem(position);
        ((TextView) viewClass.findViewById(R.id.text_name_id_student)).setText(String.format(Time_list.getStudent_name() + " - " + Time_list.getStudent_id()));
        ((TextView) viewClass.findViewById(R.id.text_time_present)).setText(String.format(Time_list.getAttendancetime()));
        if (Time_list.getStatusAttendance().equals("On time"))
            ((TextView) viewClass.findViewById(R.id.text_stutus_attendance)).setText(String.format(Time_list.getStatusAttendance()));
        else {
            ((TextView) viewClass.findViewById(R.id.text_stutus_attendance)).setText(String.format(Time_list.getStatusAttendance()));
            ((TextView) viewClass.findViewById(R.id.text_stutus_attendance)).setTextColor(Color.rgb(255,0,0));
        }
        return viewClass;
    }
}
