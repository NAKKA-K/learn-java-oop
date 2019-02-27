package skills;
import skills.Skill;
import skills.SpecialEffects;
import random.Random;
import pokemon.Pokemon;

public class IronTail extends Skill implements SpecialEffects {
    int damage = 100;

    public IronTail() {
        super("アイアンテール");
    }

    @Override
    public int calcDamage() {
        return damage;
    }

    @Override
    public void effect(Pokemon pokemon) {
        if(Random.random() <= 30) {
            pokemon.setBlock(pokemon.getBlock() - 10);
        }
    }
}

