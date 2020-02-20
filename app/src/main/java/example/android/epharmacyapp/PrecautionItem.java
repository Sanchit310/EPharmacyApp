package example.android.epharmacyapp;

public class PrecautionItem {

    private String mDiseaseName, mDiseaseDes;

    public PrecautionItem(String verionName, String version){

        mDiseaseName  = verionName;
        mDiseaseDes  = version;
    }

    public String getmDiseaseName() {
        return mDiseaseName;
    }

    public String getmDiseaseDes() {
        return mDiseaseDes;
    }
}
