package data.locationadata;

public enum CountryData {
    KAZAKHSTAN("Казахстан");

    private final String name;

    CountryData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
