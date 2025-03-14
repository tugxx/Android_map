package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.model.ClassModel;


import java.util.ArrayList;
import java.util.List;

public class ClassSAdapterActivity extends BaseAdapter implements Filterable {
    private Context context;
    private List<ClassModel> listClassS;
    private List<ClassModel> listClassSOld;
    // Dữ liệu
    final ArrayList<ClassModel> LissClass;

    public ClassSAdapterActivity(Context context, ArrayList<ClassModel> lissClass) {
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
            viewClass = View.inflate(parent.getContext(), R.layout.layoutcustom_recyclerview_classlist, null);
        } else {
            viewClass = convertView;
        }

        ClassModel class_list = (ClassModel) getItem(position);
        ((TextView) viewClass.findViewById(R.id.txtName)).setText(String.format(class_list.getClass_name()));

        return viewClass;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch  = constraint.toString();
                if(strSearch.isEmpty()){
                    listClassS = listClassSOld;
                }else{
                    List<ClassModel> list = new ArrayList<>();
                    for(ClassModel classS: listClassSOld){
                        //Chuyen doi tat ca thanh chu thuong
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
