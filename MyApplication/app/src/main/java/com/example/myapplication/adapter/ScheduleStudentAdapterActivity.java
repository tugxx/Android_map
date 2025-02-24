package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.model.ScheduleModel;
import com.example.myapplication.model.StudentModel;


import java.util.ArrayList;
import java.util.List;

public class ScheduleStudentAdapterActivity extends BaseAdapter implements Filterable {
    private Context context;
    final ArrayList<ScheduleModel> ListSchedule;

    public ScheduleStudentAdapterActivity(Context context, ArrayList<ScheduleModel> listSchedule) {
        this.context = context;
        this.ListSchedule = listSchedule;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return ListSchedule.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        return ListSchedule.get(position);
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
            viewClass = View.inflate(parent.getContext(), R.layout.layoutcustom_recyclerview_schedule, null);
        } else viewClass = convertView;
        ScheduleModel schedule_list = (ScheduleModel) getItem(position);
        ((TextView) viewClass.findViewById(R.id.tv_Schedule_Name)).setText(String.format(schedule_list.getS_name()));
        ((TextView) viewClass.findViewById(R.id.tv_Schedule_Time)).setText(String.format(schedule_list.getS_tstart()+"-"+schedule_list.getS_tend()));
        return viewClass;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

}
