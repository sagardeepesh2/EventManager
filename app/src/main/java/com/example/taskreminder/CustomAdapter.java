package com.example.taskreminder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    List<Event> eventList;
    Context context;
    CustomAdapter(Context applicationContext, List<Event> eventList){
        this.context=applicationContext;
        this.eventList = eventList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Event current = eventList.get(position);

        holder.item_name.setText(current.getEvent());
        holder.event_type.setText(current.getEventty());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_name, event_type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.custom_text);
            event_type = itemView.findViewById(R.id.event_text);
        }
    }
}
