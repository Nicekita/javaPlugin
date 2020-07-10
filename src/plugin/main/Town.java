package plugin.main;

import java.util.Objects;

public class Town {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
    public Town(String name){
        this.Name = name;
    }

    public boolean equals(Town town) {
        if (this.getName() == town.getName()) return true;
        else return false;
    }


}
