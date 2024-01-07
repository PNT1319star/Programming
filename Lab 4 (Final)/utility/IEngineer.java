package utility;

import core.*;

public interface IEngineer {
    public void enableZeroGravityDevice(ZeroGravityDevice zeroGravityDevice, Rocket rocket);

    public void disableZeroGravityDevice(ZeroGravityDevice zeroGravityDevice, Rocket rocket);

    public void checkZeroGravityDevice(ZeroGravityDevice zeroGravityDevice);
}
