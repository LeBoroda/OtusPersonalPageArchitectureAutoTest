package data;

public enum PersonalPageInfoData {
    FIRSTNAMECYR("fname"),
    FIRSTNAMELAT("fname_latin"),
    LASTNAMECYR("lname"),
    LASTNAMELAT("lname_latin"),
    BLOGNAME("blog_name"),
    DOB("date_of_birth");

    private String name;
    PersonalPageInfoData(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
