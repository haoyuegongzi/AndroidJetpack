package com.androidjetpack.viewpager2.blank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.androidjetpack.R;
import com.androidjetpack.log.Logs;

/**
 * 作者：Nixon
 * date：2020/7/2.
 * 邮箱：jan.romon@gmail.com
 * TODO：
 */
public class BlankFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2 = "九";

    public BlankFragment() {

    }

    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            String value = getArguments().getString(ARG_PARAM2);
            if (null != value && !"".equals(value)){
                mParam2 = value;
            }
        }
        Logs.log("onCreate：mParam1" + mParam1 + "  mParam2===" + mParam2);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        TextView mTextView = view.findViewById(R.id.mTextView);
        mTextView.setText(mParam2);
        Boolean bool = Boolean.valueOf("1");
        Toast.makeText(getActivity(), "我要调接口了！" + mParam1+ "  mParam2===" + mParam2, Toast.LENGTH_SHORT).show();

        return view;
    }
}