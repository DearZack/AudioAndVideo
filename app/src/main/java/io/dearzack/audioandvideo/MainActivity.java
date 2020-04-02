package io.dearzack.audioandvideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.dearzack.audioandvideo.adapter.MainAdapter;
import io.dearzack.audioandvideo.bean.NextActivity;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnClick {

    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;
    private List<NextActivity> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mainAdapter = new MainAdapter(this, data, this);
        recyclerView.setAdapter(mainAdapter);
    }

    private void initData() {
        data = new ArrayList<>();
        data.add(new NextActivity("1", MainActivity.class));
    }

    @Override
    public void onClick(NextActivity nextActivity) {
        if (nextActivity != null) {
            try {
                startActivity(new Intent(this, nextActivity.getNext()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
