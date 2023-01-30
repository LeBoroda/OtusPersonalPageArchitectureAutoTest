package data.locationadata;

public enum CityData {
    AKSAY("Аксай", CountryData.KAZAKHSTAN);
    private final String name;
    private final CountryData countryData;

    CityData(String name, CountryData countryData) {
        this.name = name;
        this.countryData = countryData;
    }

    public String getName() {
        return name;
    }

    public String getCountryName(){
        return countryData.getName();
    }
}
