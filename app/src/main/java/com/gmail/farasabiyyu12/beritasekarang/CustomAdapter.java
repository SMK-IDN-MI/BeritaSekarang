package com.gmail.farasabiyyu12.beritasekarang;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gmail.farasabiyyu12.beritasekarang.ResponseServer.ArticlesItem;

import java.util.List;

/**
 *
 * Created by farasabiyyuhandoko on 01/04/2018.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    Context context;
    List<ArticlesItem> data;
    public static final String WebUrl = "https://newsapi.org/v2/";

    public CustomAdapter(Context context, List<ArticlesItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item , parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, final int position) {
    holder.title.setText(data.get(position).getTitle());
    holder.description.setText(data.get(position).getDescription());
    holder.published.setText(data.get(position).getPublishedAt());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent =  new Intent(context, DetailActivity.class);
                intent.putExtra("browser", data.get(position).getUrl());
                context.startActivity(intent);
            }
        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent();
//                switch (position){
//                    case 0:
//                        intent =  new Intent(context, DetailActivity.class);
//                        intent.putExtra("browser", data.get(position).getUrl());
//                        break;
//                    case 1:
//                        intent =  new Intent(context, DetailActivity.class);
//                        intent.putExtra("browser", data.get(position).getUrl());
//                        break;
//                    case 2:
//                        intent =  new Intent(context, DetailActivity.class);
//                        intent.putExtra("browser", data.get(position).getUrl());
//                        break;
//                    case 3:
//                        intent =  new Intent(context, DetailActivity.class);
//                        intent.putExtra("browser", data.get(position).getUrl());
//                        break;
//                    case 4:
//                        intent =  new Intent(context, DetailActivity.class);
//                        intent.putExtra("browser", data.get(position).getUrl());
//                        break;
//                }
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, published;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            published = itemView.findViewById(R.id.published);
        }
    }
}
