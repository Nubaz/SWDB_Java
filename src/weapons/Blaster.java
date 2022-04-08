package weapons;

public class Blaster {
    private String name;
    private String type;
    private Integer shots;
    private Double cooldown;

    //basic constructors
    public Blaster() {
    }

    public Blaster(String name, String type, Integer shots, Double cooldown) {
        this.name = name;
        this.type = type;
        this.shots = shots;
        this.cooldown = cooldown;
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public Double getCooldown() {
        return cooldown;
    }

    public void setCooldown(Double cooldown) {
        this.cooldown = cooldown;
    }

    @Override
    public String toString() {
        return "Blaster name: " + name + "\n" +
                "Blaster type: " + type + "\n" +
                "Shots until overheating: " + shots + "\n" +
                "Cooldown time: " + cooldown;
    }
}
