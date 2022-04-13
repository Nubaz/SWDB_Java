package enums;

public enum ForceUserType {
    Jedi(0.35), Sith(0.50);

    public final Double factor;

    ForceUserType(Double factor) {
        this.factor = factor;
    }
}
