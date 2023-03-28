package enums;

public enum Manufacture {
    DYSON("Dyson"),
    ROWENTA("Rowenta"),
    BABYLISS("BaByliss"),
    BABYLISS_PRO("BaByliss PRO");

    private final String manufacture;

    Manufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getText() {
        return manufacture;
    }
}
