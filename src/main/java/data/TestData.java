package data;

public enum TestData {
    FIRSTNAMECYR("Стажер"),
    FIRSTNAMELAT("Trainee"),
    LASTNAMECYR("Тестировщик"),
    LASTNAMELAT("Tester"),
    BLOGNAME("СТОЖОР"),
    DOB("13.10.1888"),
    COMPANY("Barmaley Inc."),
    POSITION("Big boss"),
    SEXFEMALE("f"),
    YESRELOCATE("Да"),
    ENGLISHLEVEL("Супер продвинутый (Mastery)"),
    ADDITIONALMESSENGER1("Тelegram"),
    ADDITIONALMESSENGER2("WhatsApp"),
    ADDITIONALCONTACT1("@ZUPATESTER"),
    ADDITIONALCONTACT2("+12345678901");


    private final String name;
    TestData(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
