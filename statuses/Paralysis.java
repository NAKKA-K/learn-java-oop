package statuses;
import random.Random;
import statuses.Status;

public class Paralysis implements Status {
    public boolean canMove() {
        if(Random.random() <= 25) {
            return false;
        }
        return true;
    }
}
