package data;

public enum TestData {
    FIRSTNAMECYR("Стажер"),
    FIRSTNAMELAT("Trainee"),
    LASTNAMECYR("Тестировщик"),
    LASTNAMELAT("Tester"),
    BLOGNAME("Стожор"),
    DOB("13.10.1888");

    private String name;
    TestData(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
