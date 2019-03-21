package statuses;
import random.Random;
import statuses.Status;

public class Paralysis implements Status {
    private byte turn = 3;
    
    public boolean canMove() {
        if(this.turn <= 0 || Random.random() <= 25) {
            return false;
        }
        this.turn--;
        return true;
    }
}
