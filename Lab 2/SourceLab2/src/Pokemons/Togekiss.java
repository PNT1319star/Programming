package Pokemons;
import ru.ifmo.se.pokemon.Type;
import moves.*;

public class Togekiss extends Togetic {
    public Togekiss(String name, int lvl){
        super(name,lvl);
        this.setStats(85,50,95,120,115,80);
        this.setType(Type.FAIRY, Type.FLYING);
        this.setMove(new Psychic(), new ThunderWave(), new MagicalLeaf(), new ExtremeSpeed());
    }
}
