import Pokemons.*;
import ru.ifmo.se.pokemon.*;
public class BattleGround {
    public static void main(String[] args) {
        Battle mainBattle = new Battle();
        Grimer pokemon1 = new Grimer("Apple",10);
        Hawlucha pokemon2 = new Hawlucha("Orange",10);
        Muk pokemon3 = new Muk("Lemon",10);
        Togekiss pokemon4 = new Togekiss("Peach",1);
        Togepi pokemon5 = new Togepi("Grape",2);
        Togetic pokemon6 = new Togetic("Lichee",1);
        mainBattle.addAlly(pokemon1);
        mainBattle.addAlly(pokemon2);
        mainBattle.addAlly(pokemon3);
        mainBattle.addFoe(pokemon4);
        mainBattle.addFoe(pokemon5);
        mainBattle.addFoe(pokemon6);
        mainBattle.go();
    }
}
