package resource;

public class GCharacter {

    String name;
    String display;
    String imageCode;

    public GCharacter(String name, String display, String imageCode) {
        this.name = name;
        this.display = display;
        this.imageCode = imageCode;
    }

    public String getImageCode() {
        return imageCode;
    }
}
