package poojas.angels;

public enum Platform {
    NINTENDO64("Nintendo 64", "Nintendo"),
    GAMECUBE("GameCube", "Nintendo"),
    WII("Wii", "Nintendo"),
    WII_U("Wii U", "Nintendo"),
    SWITCH("Switch", "Nintendo"),
    PS1("PlayStation", "Sony"),
    PS2("PlayStation 2", "Sony"),
    PS3("PlayStation 3", "Sony"),
    PS4("PlayStation 4", "Sony"),
    XBOX("Xbox", "Microsoft"),
    XBOX_360("Xbox 360", "Microsoft"),
    XBOX_ONE("Xbox One", "Microsoft"),
    WINDOWS("Windows", "Microsoft"),
    MAC_OS("MacOS", "Apple"),
    LINUX("Linux", "Linux Foundation");

    private String name; //full name
    private String creator;

    private Platform(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    public String getName() {
        return this.name;
    }
    
    public String getCreator() {
        return this.creator;
    }
}
