package wzq.nothing.header;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;

import wzq.nothing.Cheeses;
import wzq.nothing.R;
import wzq.nothing.SimpleStringRecyclerViewAdapter;

/**
 * Created by wangziqiang on 2015/8/19.
 */
public class HeaderActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(Arrays.asList(Cheeses.sCheeseStrings)));
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
