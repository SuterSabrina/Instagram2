package instagram2.bbcag.ch.instagram2.Add;

public class ImageUploadInfo {

    private String imageName;

    private String imageURL;

    private ImageUploadInfo() {

    }

    public ImageUploadInfo(String name, String url) {

        this.imageName = name;
        this.imageURL= url;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

}
