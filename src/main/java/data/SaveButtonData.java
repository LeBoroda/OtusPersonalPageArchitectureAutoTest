package data;

public enum SaveButtonData {
    SAVEANDFILLLATER("Сохранить и заполнить позже");

    private final String name;
    SaveButtonData(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
