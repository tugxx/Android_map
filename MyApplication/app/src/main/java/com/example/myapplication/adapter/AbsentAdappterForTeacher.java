//package com.example.myapplication.adapter;
package com.example.myapplication.adapter;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.AbsentTeacherModel;
import com.example.myapplication.model.PresentTeacherModel;

import java.util.ArrayList;

public class AbsentAdappterForTeacher extends BaseAdapter {
    final ArrayList<AbsentTeacherModel> ListAbsent;

    public AbsentAdappterForTeacher(ArrayList<AbsentTeacherModel> ListAbsent) {
        this.ListAbsent = ListAbsent;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return ListAbsent.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        return ListAbsent.get(position);
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
            viewClass = View.inflate(parent.getContext(), R.layout.layoutcustom_absentteacher, null);
        } else {
            viewClass = convertView;
        }

        AbsentTeacherModel Absent_list = (AbsentTeacherModel) getItem(position);
        ((TextView) viewClass.findViewById(R.id.text_name_student)).setText(String.format(Absent_list.getStudent_name()));
        ((TextView) viewClass.findViewById(R.id.text_id_studentt)).setText(String.format(Absent_list.getStudent_id()));
        return viewClass;
    }
}
