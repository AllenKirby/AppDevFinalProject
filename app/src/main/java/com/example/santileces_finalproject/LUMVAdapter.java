package com.example.santileces_finalproject;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
public class LUMVAdapter extends RecyclerView.Adapter<LUMVAdapter.MyViewHolder>{
    List missionVision;
    public LUMVAdapter(List missionVision) {
        this.missionVision=missionVision;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_mvlist, viewGroup, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int i) {
        LUMV data = (LUMV) missionVision.get(i);
        viewHolder.name.setText(data.Name);
        viewHolder.details.setText(String.valueOf(data.details));
    }
    @Override
    public int getItemCount() {
        return missionVision.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,details;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.Name);
            details=itemView.findViewById(R.id.details);
        }
    }
}
