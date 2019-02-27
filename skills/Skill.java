package skills;

public abstract class Skill {
    String name;
    int damage;

    public Skill(String name) {
        this.name = name;
    }

    public abstract int calcDamage();
    public String getName() {
        return this.name;
    }
}

