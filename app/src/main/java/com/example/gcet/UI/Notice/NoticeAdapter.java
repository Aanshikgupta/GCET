package com.example.gcet.UI.Notice;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gcet.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {

    Context context;
    List<Notice> notices;

    public NoticeAdapter(Context context, List<Notice> notices) {
        this.context = context;
        this.notices = notices;

    }

    @NonNull
    @NotNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notice_item, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NoticeViewHolder holder, int position) {
        Notice notice = notices.get(position);
        holder.noticeTitle.setText(notice.getTitle());
        String dateTime = notice.getDate() + " " + notice.getTime();
        holder.noticeDateTime.setText("Updated on "+dateTime);
        Log.i("TAG", notice.getTitle() + "--->" + (notice.getImage()).equalsIgnoreCase("") + "");
        if (!(notice.getImage()).equalsIgnoreCase(""))
            Glide.with(context).load(notice.getImage()).into(holder.noticeImage);
        else
            holder.noticeImage.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return notices.size();
    }

    public class NoticeViewHolder extends RecyclerView.ViewHolder {

        TextView noticeTitle, noticeDateTime;
        Button deleteNotice;
        ImageView noticeImage;

        public NoticeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            noticeTitle = itemView.findViewById(R.id.noticeItemTitle);
            noticeDateTime = itemView.findViewById(R.id.noticeItemDateTime);
            noticeImage = itemView.findViewById(R.id.noticeItemImageView);

        }
    }
}

