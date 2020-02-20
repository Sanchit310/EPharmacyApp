//package example.android.epharmacyapp;
//
//import android.graphics.Color;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import androidx.recyclerview.widget.RecyclerView;
//
//public class itemAdapter extends RecyclerView.Adapter<itemAdapter.itemViewHolder> implements Filterable {
//
//    public static Boolean isScanned = false;
//
//    private ArrayList<ExampleItems> mExampleFilteredList;
//    private ArrayList<ExampleItems> mExampleFullList;
//    private onItemClickListerner mListener;
//
//
//
//    @Override
//    public Filter getFilter() {
//        return exampleFilter;
//    }
//
//    private Filter exampleFilter = new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//
////            String filterPattern = constraint.toString();
////            Log.d("____", "performFiltering: "+ filterPattern);
////            Gson gson = new Gson();
////            List<String> newlist = gson.fromJson(filterPattern,List.class);
////            Log.d("_____", "performFiltering: "+ newlist);
//
//            String filterPattern = constraint.toString().toLowerCase().trim();
//            if (filterPattern.length() == 0) {
//                mExampleFilteredList = mExampleFullList;
//            } else {
//                List<ExampleItems> filteredList = new ArrayList<>();
//                for (ExampleItems item : mExampleFullList) {
//                    if (item.getmText2().toLowerCase().contains(filterPattern)) {
//                        filteredList.add(item);
//                    }
//                }
//                mExampleFilteredList = (ArrayList<ExampleItems>) filteredList;
//            }
//
//
////            if(filterPattern.isEmpty()){
////                mExampleFilteredList = mExampleFullList;
////            }
////            else {
////                ArrayList<ExampleItems> filteredList = new ArrayList<>();
////                for (ExampleItems item : mExampleFullList){
////                    int size = newlist.size();
////                    Log.d("___", "performFiltering: "+size+"" + item);
////                    if (size==1) {
////                        if (item.getmText2().toLowerCase().startsWith(newlist.get(0).toLowerCase().trim().toString())) {
////                            filteredList.add(item);
////                        }
////                    }
////                    else if (size==2) {
////                            if (item.getmText2().toLowerCase().startsWith(newlist.get(0).toLowerCase().trim().toString()) ||
////                                    item.getmText2().toLowerCase().startsWith(newlist.get(1).toLowerCase().trim().toString())) {
////                                filteredList.add(item);
////                                Log.d("____", "filtered lsit: " + filteredList);
////                            }
////                        }
////                     else if (size==3){
////                            if (item.getmText2().toLowerCase().startsWith(newlist.get(0).toLowerCase().trim().toString()) ||
////                                    item.getmText2().toLowerCase().startsWith(newlist.get(1).toLowerCase().trim().toString())||
////                                    item.getmText2().toLowerCase().startsWith(newlist.get(2).toLowerCase().trim().toString())) {
////                                filteredList.add(item);
////                            }
////                     }
////                     else{
////                         mExampleFilteredList = mExampleFullList;
////                    }
////                    Log.d("____", "performFiltering: "+ filteredList);
////                    }
////
////                mExampleFilteredList = filteredList;
////            }
//            FilterResults results = new FilterResults();
//            results.values = mExampleFilteredList;
//           // results.values = mExampleFilteredList;
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            mExampleFilteredList = (ArrayList<ExampleItems>) results.values;
//            notifyDataSetChanged();
//        }
//    };
//
//
//
//
//    public interface onItemClickListerner{
//
//        void onItemClicked(int position);
//        void bookmarkOnCLick(int position);
//    }
//    public void setOnItemClickListener(onItemClickListerner Listener){
//
//        mListener = Listener;
//
//    }
//
//   public itemAdapter(ArrayList<ExampleItems> exampleList){
//
//       mExampleFilteredList = exampleList;
//       this.mExampleFullList = new ArrayList<>(exampleList);
//
//   }
//
//
//    public itemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        View view = inflater.inflate(R.layout.item_layout,viewGroup, false);
//
//        return new itemViewHolder(view, mListener);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull itemViewHolder itemViewHolder, int i) {
//        ExampleItems currentItem = mExampleFilteredList.get(i);
//
//
//        itemViewHolder.textView1.setText(currentItem.getmText1());
//        itemViewHolder.textView2.setText(currentItem.getmText2());
//        itemViewHolder.eventName.setText(currentItem.getEventName());
//
//
//      //  itemViewHolder.imageView.setImageResource(currentItem.getImageId());
//
//
//        if (currentItem.isBookmarked){
//            itemViewHolder.linearLayout.setBackgroundColor(Color.BLACK);
//            itemViewHolder.textView1.setTextColor(Color.WHITE);
//            itemViewHolder.textView2.setTextColor(Color.WHITE);
//            itemViewHolder.eventName.setTextColor(Color.WHITE);
//            itemViewHolder.imageView.setImageResource(R.drawable.ic_star_black_24dp);
//            itemViewHolder.lineHorizontal.setBackgroundColor(Color.parseColor("#ff9700"));
//        }
//        else {
//            itemViewHolder.linearLayout.setBackgroundColor(Color.parseColor("#BDBDBD"));
//            itemViewHolder.textView1.setTextColor(Color.BLACK);
//            itemViewHolder.textView2.setTextColor(Color.BLACK);
//            itemViewHolder.eventName.setTextColor(Color.BLACK);
//            itemViewHolder.imageView.setImageResource(R.drawable.ic_star_border_black_24dp);
//            itemViewHolder.lineHorizontal.setBackgroundColor(Color.parseColor("#000000"));
//        }
//
//        if (isScanned) {
//            itemViewHolder.imageView.setVisibility(View.VISIBLE);
//        } else {
//            itemViewHolder.imageView.setVisibility(View.GONE);
//        }
//    }
//
//
//    @Override
//    public int getItemCount() {
//        return mExampleFilteredList.size();
//    }
//
//    public class itemViewHolder extends RecyclerView.ViewHolder{
//
//        ImageView imageView;
//        LinearLayout linearLayout;
//        TextView textView1;
//        TextView textView2;
//        View lineHorizontal;
//        TextView eventName;
//
//
//        public itemViewHolder(@NonNull final View itemView, final onItemClickListerner listerner) {
//            super(itemView);
//
//            imageView  = itemView.findViewById(R.id.bookmar);
//            linearLayout = itemView.findViewById(R.id.itemlayout);
//            textView1 = itemView.findViewById(R.id.txt1);
//            textView2 = itemView.findViewById(R.id.txt2);
//            lineHorizontal = itemView.findViewById(R.id.lineHorizontal);
//            eventName = itemView.findViewById(R.id.eventname);
//
////            itemView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////
////                    if(listerner != null){
////
////                        int position = getAdapterPosition();
////                        if (position != RecyclerView.NO_POSITION){
////                            listerner.onItemClicked(position);
////                        }
////                    }
////
////                }
////            });
//
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(listerner != null){
//
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION){
//                            listerner.bookmarkOnCLick(position);
//                        }
//                    }
//                }
//            });
//
//        }
//    }
//
//    public void updateList(ArrayList<ExampleItems> list) {
//        mExampleFilteredList = list;
//        mExampleFullList = list;
//        notifyDataSetChanged();
//    }
//
//    public void updateBoolean(){
//        isScanned = true;
//        notifyDataSetChanged();
//    }
//}
