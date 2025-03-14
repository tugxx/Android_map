package com.example.myapplication.adapter;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.ClassModel;

import java.util.ArrayList;
import java.util.List;

public class ClassAdapterForStudentActivity extends BaseAdapter implements Filterable {
    private Context context;
    private List<ClassModel> listClassS;
    private List<ClassModel> listClassSOld;
    // Dữ liệu
    final ArrayList<ClassModel> LissClass;
    public ClassAdapterForStudentActivity(ArrayList<ClassModel> lissClass) {
        this.LissClass = lissClass;
    }
    public ClassAdapterForStudentActivity(Context context, ArrayList<ClassModel> lissClass) {
        this.context = context;
        this.listClassS = lissClass;
        this.listClassSOld = lissClass;
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
            viewClass = View.inflate(parent.getContext(), R.layout.activity_class_view_custom_student, null);
        } else viewClass = convertView;
        ClassModel class_list = (ClassModel) getItem(position);
        ((TextView) viewClass.findViewById(R.id.text_name_class)).setText(String.format(class_list.getClass_name()));
        ((TextView) viewClass.findViewById(R.id.text_id_class)).setText(String.format(class_list.getClass_id()));
        return viewClass;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch  = constraint.toString();
//                System.out.println("ClassAdapterForStudentActivity + getFilter + " + strSearch);
                if (strSearch.isEmpty()) {
                    listClassS = listClassSOld;
                } else {
                    List<ClassModel> list = new ArrayList<>();
                    for(ClassModel classS: listClassSOld){
                        // Chuyen doi tat ca thanh chu thuong
                        if(classS.getClass_name().toLowerCase().contains(strSearch.toLowerCase())){
                            list.add(classS);
                        }
                    }
                    listClassS = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = listClassS;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listClassS = (List<ClassModel>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
