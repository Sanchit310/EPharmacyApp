package example.android.epharmacyapp;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import example.android.epharmacyapp.PrecautionItem;
import example.android.epharmacyapp.R;


public class PrecautionAdapter extends RecyclerView.Adapter<PrecautionAdapter.iosViewHolder> {

    private ArrayList<PrecautionItem> mversionList;
    Context context;

    public  PrecautionAdapter(ArrayList<PrecautionItem> versionList){
        mversionList = versionList;
    }

    @NonNull
    @Override
    public iosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.layout,viewGroup,false);
        return new iosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull iosViewHolder iosViewHolder, final int i) {
        final PrecautionItem currentItem = mversionList.get(i);
        iosViewHolder.text1.setText(currentItem.getmDiseaseName());
        iosViewHolder.text2.setText(currentItem.getmDiseaseDes());
        iosViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailedActivity.class);
                intent.putExtra("versionName", currentItem.getmDiseaseName());
                intent.putExtra("version",currentItem.getmDiseaseDes());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mversionList.size();
    }

    public static class iosViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        TextView text2;
        LinearLayout linearLayout;

        public iosViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = itemView.findViewById(R.id.txt1);
            text2 = itemView.findViewById(R.id.txt2);
            linearLayout = itemView.findViewById(R.id.layout_list);
        }
    }
}
