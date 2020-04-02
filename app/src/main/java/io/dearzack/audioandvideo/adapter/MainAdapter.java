package io.dearzack.audioandvideo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.dearzack.audioandvideo.R;
import io.dearzack.audioandvideo.bean.NextActivity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context context;
    private List<NextActivity> data;
    private OnClick onClick;

    public MainAdapter(Context context, List<NextActivity> data, OnClick onClick) {
        this.context = context;
        this.data = data;
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final NextActivity nextActivity = data.get(position);
        holder.content.setText(nextActivity.getName());
        holder.content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClick != null) {
                    onClick.onClick(nextActivity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public interface OnClick {
        void onClick(NextActivity nextActivity);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView content;

        public ViewHolder(View view) {
            super(view);
            content = view.findViewById(R.id.tv_content);
        }
    }
}
