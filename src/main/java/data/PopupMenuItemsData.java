package data;

public enum PopupMenuItemsData {
    PERSONAL("personal");

    private String name;

    PopupMenuItemsData(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
