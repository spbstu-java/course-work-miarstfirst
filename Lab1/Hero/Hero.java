package Lab1.Hero;
import  Lab1.MovingType.*;

public class Hero {
    private MovingType movingType = new OnFootMove();

    public void setMoving(MovingType movingType) {
        if (movingType == null) {
            throw new IllegalArgumentException("MovingType cannot be null");
        }
        this.movingType = movingType;
    }

    public String move() {
        return movingType.move();
    }
}
