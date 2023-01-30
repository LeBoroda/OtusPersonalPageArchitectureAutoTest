package data;

public enum PersonalInfoSelectorsData {
    FIRSTNAMECYR("input[name='fname']"),
    FIRSTNAMELAT("input[name='fname_latin']"),
    LASTNAMECYR("input[name='lname']"),
    LASTNAMELAT("input[name='lname_latin']"),
    BLOGNAME("input[name='blog_name']"),
    DOB("input[name='date_of_birth']"),
    YESRELOCATE("#id_ready_to_relocate_1+span"),
    WORKFULLDAY("input[value='full']+span"),
    WORKFLEXIBLE("input[value='flexible']+span"),
    COMPANY("#id_company"),
    POSITION("#id_work"),
    ENGLISHLEVEL("input[name=english_level]+div"),
    ENGLISHLEVELMASTERY("button[title='Супер продвинутый (Mastery)']"),
    SEX("div[class='select select_full']"),
    SEXFEMALE("#id_gender>option[value=f]"),
    ADDITIONALCONTACT1("input[name='contact-0-value']"),
    ADDITIONALCONTACT2("input[name='contact-1-value']"),
    TELEGRAM("button[title='Тelegram']"),
    WHATSAPP("//*[@name='contact-1-id']//following::button[@title='WhatsApp']"),
    ADDCONTACT("button[class*='custom-select-add']"),
    PREFFERABLECONTACT("input[name='contact-0-preferable']+span"),
    FIRSTADDCONTACTMENU("input[name*='contact-0']~.lk-cv-block__input"),
    SECONTADDCONTACTMENU("input[name*='contact-1']~.lk-cv-block__input");


    private final String name;
    PersonalInfoSelectorsData(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

}
