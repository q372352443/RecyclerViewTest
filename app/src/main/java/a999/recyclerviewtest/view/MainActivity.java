package a999.recyclerviewtest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import a999.recyclerviewtest.adapter.Adapter;
import a999.recyclerviewtest.R;

public class MainActivity extends AppCompatActivity implements Adapter.IonSlidingViewClickListener {

    private RecyclerView mRecyclerView;

    private Adapter mAdapter;

    private final String TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setAdapter();

    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
    }

    private void setAdapter(){

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter = new Adapter(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG,"点击项："+position);
    }

    @Override
    public void onDeleteBtnCilck(View view, int position) {
        Log.i(TAG,"删除项："+position);
        mAdapter.removeData(position);
    }
}