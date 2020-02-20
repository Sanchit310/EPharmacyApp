//package example.android.epharmacyapp;
//
//        import android.Manifest;
//        import android.content.Intent;
//        import android.content.pm.PackageManager;
//
//        import android.os.Bundle;
//
//        import android.util.Log;
//        import android.view.Gravity;
//        import android.view.Menu;
//        import android.view.MenuInflater;
//        import android.view.MenuItem;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.TextView;
//        import android.widget.Toast;
//
//
//        import com.google.firebase.firestore.EventListener;
//        import com.google.firebase.firestore.FirebaseFirestore;
//        import com.google.firebase.firestore.FirebaseFirestoreException;
//        import com.google.firebase.firestore.Query;
//        import com.google.firebase.firestore.QueryDocumentSnapshot;
//        import com.google.firebase.firestore.QuerySnapshot;
//
//
//        import java.util.ArrayList;
//
//        import java.util.HashMap;
//        import java.util.List;
//
//        import javax.annotation.Nullable;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//
//public class MyCart extends AppCompatActivity {
//
//    private ArrayList<ExampleItems> mExampleList = new ArrayList<>();
//    private ArrayList<ExampleItems> bookmarkedList = new ArrayList<>();
//    public static final int QR_SCANNER_CODE = 101;
//    private itemAdapter mAdapter;
//    private View view1;
//
//    DrawerLayout drawerLayout;
//    private List<String> mlist = new ArrayList<>();
//    public static TextView textView;
//
//
//    Button button;
//    RecyclerView recyclerView;
//    Toolbar toolbar;
//    ActionBarDrawerToggle actionBarDrawerToggle;
//    NavigationView navigationView;
//    private TextView textView1;
//    private TextView textView2;
//
//    private FirebaseFirestore db = FirebaseFirestore.getInstance();
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_cart);
//        setuptoolbar();
//        view1 = findViewById(R.id.lineHorizontal);
//        textView1 = findViewById(R.id.txt1);
//        textView2 = findViewById(R.id.txt2);
//        recyclerView = findViewById(R.id.recview);
//        textView = findViewById(R.id.resultview);
//        button = findViewById(R.id.qrbutton);
//
//        navigationOpen();
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                requestPermission();
//            }
//        });
//    }
//
//    public void setuptoolbar(){
//
//        drawerLayout = findViewById(R.id.drawer);
//        toolbar = findViewById(R.id.tool);
//        setSupportActionBar(toolbar);
//        actionBarDrawerToggle =  new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.app_name, R.string.app_name);
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//
//
//    }
//
//    public void openDialog(){
//
//        DialogFragment dialogFragment = new DialogFragment();
//        dialogFragment.show(getSupportFragmentManager(),"Filter Dialog");
//
//    }
//
//    public void changeItem(int position, String text){
//
//
//        mAdapter.notifyItemChanged(position);
//    }
//    public  void bookmarkItem(final int position){
//        if(!mExampleList.get(position).isBookmarked){
//            mExampleList.get(position).isBookmarked = true;
//            bookmarkedList.add(mExampleList.get(position));
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("id", mExampleList.get(position).id);
//            map.put("isBookmarked", mExampleList.get(position).isBookmarked);
//            map.put("mText1", mExampleList.get(position).mText1);
//            map.put("mText2", mExampleList.get(position).mText2);
//            map.put("eventName", mExampleList.get(position).eventName);
//            db.collection("user").document("asd").collection("bookmarks").document(String.valueOf(mExampleList.get(position).id))
//                    .set(map);
//            mAdapter.notifyItemChanged(position);
//        }
//        else{
//            bookmarkedList.remove(mExampleList.get(position));
//            mExampleList.get(position).isBookmarked = false;
//            db.collection("user").document("asd").collection("bookmarks").document(String.valueOf(mExampleList.get(position).id))
//                    .delete();
//            mAdapter.notifyItemChanged(position);
//        }
//    }
//
//
//    public void buildRecyclerView(){
//        bookmarkedList.clear();
//        db.collection("user").document("asd").collection("bookmarks").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//                if (e != null){
//                    return;
//                }
//                else{
//                    if (queryDocumentSnapshots == null){
//                        return;
//                    }
//                    else {
//                        for (QueryDocumentSnapshot snapshot: queryDocumentSnapshots){
//                            ExampleItems item = snapshot.toObject(ExampleItems.class);
//                            bookmarkedList.add(item);
//                        }
//                    }
//                }
//            }
//        });
//
//
//        db.collection("stalls").addSnapshotListener(new EventListener<QuerySnapshot>() {
//            @Override
//            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
//                if (e != null){
//                    return;
//                }
//                else {
//
//                    if ( queryDocumentSnapshots == null){
//                        return;
//                    }
//                    else {
//                        mExampleList.clear();
//                        for(QueryDocumentSnapshot snapshot: queryDocumentSnapshots){
//
//                            ExampleItems item = snapshot.toObject(ExampleItems.class);
//                            if (bookmarkedList.contains(item)) {
//                                item.isBookmarked = true;
//                            }
//                            mExampleList.add(item);
//                            mAdapter.updateList(mExampleList);
//                        }
//                        Log.d("_______", "onEvent: " + mExampleList);
//                    }
//
//                }
//
//            }
//        });
//        mAdapter = new itemAdapter(mExampleList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(mAdapter);
//        mAdapter.notifyDataSetChanged();
//
//        mAdapter.setOnItemClickListener(new itemAdapter.onItemClickListerner() {
//            @Override
//            public void onItemClicked(int position) {
//
//            }
//
//            @Override
//            public void bookmarkOnCLick(int position) {
//                bookmarkItem(position);
//            }
//
//        });
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_menu, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                mAdapter.getFilter().filter(s);
//                return false;
//            }
//        });
//
//
//        return true;
//    }
//
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        switch (item.getItemId()){
////            case R.id.action_filter:
////                openDialog();
////
////            case R.id.action_search:
////                Gson gson = new Gson();
////                String  json = gson.toJson(mlist);
////                mAdapter.getFilter().filter(json);
////
////
////
////        }
////        return  false;
////    }
//
//    public void openBookmarkAct(){
//        Intent intent =  new Intent(this, BookmarkActivity.class);
//        startActivity(intent);
//
//    }
//
//    public void settingActivity(){
//
//        Intent intent =  new Intent(this, SettingActivity.class);
//        startActivity(intent);
//
//    }
//
//    public void aboutActivity(){
//
//        Intent intent =  new Intent(this, AboutActivity.class);
//        startActivity(intent);
//
//    }
//
//    public void navigationOpen(){
//        navigationView = findViewById(R.id.nav);
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                switch (menuItem.getItemId()){
//
//                    case R.id.bookmarks:
//                        openBookmarkAct();
//                        drawerLayout.closeDrawer(Gravity.START);
//                        return true;
//
//                    case  R.id.setting:
//                        settingActivity();
//                        drawerLayout.closeDrawer(Gravity.START);
//                        return true;
//
//                    case R.id.about:
//                        aboutActivity();
//                        drawerLayout.closeDrawer(Gravity.START);
//                        return true;
//
//                }
//                return false;
//            }
//        });
//
//    }
//
//    @Override
//    public void sendList(List<String> list) {
//        Log.d("____", "sendList: "+ list);
//        mlist = list;
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        buildRecyclerView();
//    }
//
//    void requestPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
//                != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
//        } else {
//            Intent intent = new Intent(getApplicationContext(), QrScanner.class);
//            startActivityForResult(intent, QR_SCANNER_CODE);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 0 && grantResults.length < 1) {
//            Toast.makeText(this, "Permission required", Toast.LENGTH_SHORT).show();
//        } else {
//            Intent intent = new Intent(getApplicationContext(), QrScanner.class);
//            startActivityForResult(intent, QR_SCANNER_CODE);
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @android.support.annotation.Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == QR_SCANNER_CODE) {
//            if (resultCode == RESULT_OK) {
//                mAdapter.updateBoolean();
//            }
//        }
//    }
//}
