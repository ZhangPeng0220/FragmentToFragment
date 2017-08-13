package com.zhangpeng.sendmessage;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements ContentFragment.CallBack{
    private android.app.FragmentManager manager;
    private android.app.FragmentTransaction transaction;

    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tvn);
    }
    public void show(View view){
        //1，得到Fragment管理器对象
        manager = getFragmentManager();
        //2，开启Fragment的事务
        transaction = manager.beginTransaction();
        //3，实例化要显示的Fragment对象

        ContentFragment cf = new ContentFragment();
        //步骤3:设置监听器，实现接口里面的方法
        cf.setCallBack(this);
        Log.i("2233","执行");
        Bundle bundle1 = new Bundle();//activity向fragment传递数据
        bundle1.putString("id", "Activity发送给MyFragment1的数据");
        cf.setArguments(bundle1);
        transaction.replace(R.id.content,cf);
        transaction.commit();
    }
    @Override
    public void getResult(String content) {
        tv.setText(content);
    }
}
