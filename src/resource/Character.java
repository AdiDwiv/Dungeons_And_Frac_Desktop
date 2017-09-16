package resource;

public class Character {

    String name;
    String display;
    String imageCode;

    public Character(String name, String display, String imageCode) {
        this.name = name;
        this.display = display;
        this.imageCode = imageCode;
    }

    public String getImageCode() {
        return imageCode;
    }
}
