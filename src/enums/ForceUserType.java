package enums;

public enum ForceUserType {
    Jedi(1.35), Sith(1.50);

    public final Double factor;

    ForceUserType(Double factor) {
        this.factor = factor;
    }
}
