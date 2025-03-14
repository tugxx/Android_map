package com.example.myapplication.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
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
        View viewClass = convertView;
        if (viewClass == null) {
            // Use LayoutInflater for better practice
            viewClass = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.layoutcustom_recyclerview_schedule,
                    parent,
                    false
            );
        }

        // Get the data item
        ScheduleModel schedule_list = (ScheduleModel) getItem(position);
        if (schedule_list == null) {
            return viewClass; // Return empty view to avoid crash
        }

        // Find and set TextViews (Connect with layoutcustom_recyclerview_schedule)
        TextView nameView = viewClass.findViewById(R.id.tv_Schedule_Name);
        TextView timeView = viewClass.findViewById(R.id.tv_Schedule_Time);
        String nameText = schedule_list.getS_name();
        nameView.setText(nameText.trim());
        String timeText = schedule_list.getS_tstart() + " - " + schedule_list.getS_tend();
        timeView.setText(timeText.trim());

//        System.out.println("ScheduleStudentAdapterActivity + getView + "+schedule_list.getS_name());
//        System.out.println("ScheduleStudentAdapterActivity + getView + "+timeText);
        return viewClass;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

}
