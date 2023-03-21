package enums;

public enum Manufactures {
    DYSON("Dyson"),
    ROWENTA("Rowenta"),
    BABYLISS("BaByliss"),
    BABYLISS_PRO("BaByliss PRO");

    private final String manufacture;

    Manufactures(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getText() {
        return manufacture;
    }
}
