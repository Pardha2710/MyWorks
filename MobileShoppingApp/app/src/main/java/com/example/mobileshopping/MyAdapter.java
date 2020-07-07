package com.example.mobileshopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;
    private SelectedPlan selectedPlan;

    public MyAdapter(List<ListItem> listItems, SelectedPlan selectedPlan) {
        this.listItems = listItems;
        this.selectedPlan=selectedPlan;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem=listItems.get(position);

        String dataPlan=listItem.getPlan();
        holder.textViewPlan.setText(dataPlan);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public interface SelectedPlan{
        void selectedPlan(ListItem listItem);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewPlan;
        public TextView textViewDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewPlan=(TextView)itemView.findViewById(R.id.texViewplan);
            textViewDetails=(TextView)itemView.findViewById(R.id.texViewdetails);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selectedPlan.selectedPlan(listItems.get(getAdapterPosition()));
                }
            });

        }
    }

}
