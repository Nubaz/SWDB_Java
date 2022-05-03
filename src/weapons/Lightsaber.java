package weapons;

public class Lightsaber {
    private String color;
    private String type;
    private String hilt;

    //basic constructors
    public Lightsaber() {
    }

    public Lightsaber(String color, String type, String hilt) {
        this.color = color;
        this.type = type;
        this.hilt = hilt;
    }

    //getters and setters
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHilt() {
        return hilt;
    }

    public void setHilt(String hilt) {
        this.hilt = hilt;
    }

    @Override
    public String toString() {
        return "Lightsaber color: " + color + "\n" +
                "Lightsaber type: " + type + "\n" +
                "Lightsaber hilt: " + hilt + "\n";
    }
}
