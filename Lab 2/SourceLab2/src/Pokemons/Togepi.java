package Pokemons;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import moves.*;
public class Togepi extends Pokemon {
    public Togepi(String name, int lvl) {
        super(name, lvl);
        this.setStats(35, 20, 65, 40, 65, 20);
        this.setType(Type.FAIRY);
        this.setMove(new Psychic(), new ThunderWave());
    }
}
