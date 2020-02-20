package example.android.epharmacyapp;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ExampleItems {

    @PrimaryKey(autoGenerate = true)
    public int id;
    public String mText1;
    public String mText2;
    public int imageId;
    public String eventName;


    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean isBookmarked = false;

    public ExampleItems(){

        //needed
    }


    public ExampleItems(String Text1, String Text2, Boolean isBookmarked){

        mText1 = Text1;
        mText2 = Text2;
        isBookmarked = false;
    }
    public void changeText1(String text){

        mText1 = text;
    }
    public void bookmarked(int id){
        imageId = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getmText1(){

        return  mText1;

    }

    public Boolean getBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(Boolean bookmarked) {
        isBookmarked = bookmarked;
    }

    public String getmText2(){
        return mText2;
    }

    public String getEventName(){
        return eventName;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ExampleItems) {
            return ((ExampleItems) obj).id == this.id;
        }
        return false;
    }
}
