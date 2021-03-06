package skills;
import skills.Skill;
import skills.SpecialEffects;
import random.Random;
import pokemon.Pokemon;
import statuses.Paralysis;

public class VoltTackle extends Skill implements SpecialEffects {
    int damage = 120;

    public VoltTackle() {
        super("ボルテッカー");
    }

    @Override
    public int calcDamage() {
        return damage;
    }

    @Override
    public void effect(Pokemon pokemon) {
        if(Random.random() <= 10) {
            pokemon.setStatus(new Paralysis()); // 麻痺
        }
    }
}

