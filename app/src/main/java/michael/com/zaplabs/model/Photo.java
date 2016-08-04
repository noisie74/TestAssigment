package michael.com.zaplabs.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mikhail on 8/3/16.
 */
public class Photo {

    private int id;
    private String title;
    @SerializedName("thumbnailUrl")
    private String image;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }
}
