package com.chs.filterdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * 作者：chs on 2016/10/22 16:01
 * 邮箱：657083984@qq.com
 */

public class FilterFragmentTwo extends Fragment {
    private ListView lv_department;
    private ImageView iv_back;
    private String departmentName = "";
    String[] list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_department_select, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        lv_department = (ListView) view.findViewById(R.id.lv_department);
        iv_back = (ImageView) view.findViewById(R.id.iv_back);
         list = new String[10];
        for(int i = 0;i<10;i++){
            list[i] = "部门"+i;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list);
        lv_department.setAdapter(arrayAdapter);


        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                showNext();
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });

        lv_department.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                departmentName = list[position];
//                showNext();
                getActivity().getSupportFragmentManager().popBackStackImmediate();
            }
        });
    }
//    private void showNext() {
//        Fragment fragment = new FilterFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("departmentName",departmentName);
//        fragment.setArguments(bundle);
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.setCustomAnimations(R.anim.left_in, R.anim.right_out, R.anim.right_in, R.anim.left_out);
//        fragmentTransaction.replace(R.id.drawer_content, fragment);
//        fragmentTransaction.commitAllowingStateLoss();
//    }
}
