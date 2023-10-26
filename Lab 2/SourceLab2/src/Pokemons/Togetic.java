package Pokemons;
import ru.ifmo.se.pokemon.Type;
import moves.*;
public class Togetic extends Togepi {
    public Togetic(String name, int lvl) {
        super(name, lvl);
        this.setStats(55, 40, 85, 80, 105, 40);
        this.setType(Type.FAIRY, Type.FLYING);
        this.setMove(new Psychic(), new ThunderWave(), new MagicalLeaf());
    }

}
