package com.zhangpeng.sendmessage;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 上官若枫 on 2017/7/20.
 */

public class ContentFragment extends Fragment implements View.OnClickListener {
    TextView tv;
    Button bt;
    EditText et;
    String content;
    CallBack callback;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout1, null);
        bt = (Button) view.findViewById(R.id.bt);
        bt.setOnClickListener(this);
        tv = (TextView) view.findViewById(R.id.tv);
        et = (EditText) view.findViewById(R.id.et);
        Bundle bundle = getArguments();
        tv.setText(bundle.getString("id"));
        return view;
    }
//以下为fragment向activity传送数据
    @Override
    public void onClick(View v) {
        //获取EditText里面的输入值
        content = et.getText().toString();
        //调用这个接口方法
        callback.getResult(content);//向activity传送数据
    }

    public interface CallBack{//定义回调接口
        public void getResult(String content);
    }
    public void setCallBack(CallBack callBack) {
        this.callback = callBack;
    }
}
