package Pokemons;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import moves.*;

public class    Hawlucha extends Pokemon {
    public Hawlucha(String name, int lvl){
        super(name,lvl);
        this.setStats(78,92,75,74,63,118);
        this.setType(Type.FIGHTING, Type.FLYING);
        this.setMove(new SteelWing(), new RockTomb(), new BulkUp(), new Confide());
    }
}
