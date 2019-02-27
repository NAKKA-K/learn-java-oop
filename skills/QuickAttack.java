package skills;
import skills.Skill;
import skills.SpecialEffects;
import random.Random;
import pokemon.Pokemon;

public class QuickAttack extends Skill {
    int damage = 40;

    public QuickAttack() {
        super("でんこうせっか");
    }

    @Override
    public int calcDamage() {
        return damage;
    }
}

