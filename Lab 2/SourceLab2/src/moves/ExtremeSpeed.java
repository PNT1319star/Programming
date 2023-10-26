package moves;
import ru.ifmo.se.pokemon.*;
public class ExtremeSpeed extends PhysicalMove {
    public ExtremeSpeed(){
        super(Type.NORMAL,80,100,2,1);
    }
    @Override
    protected String describe(){
        return "Use Extreme Speed";
    }
}
