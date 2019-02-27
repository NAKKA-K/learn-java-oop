package statuses;
import random.Random;
import statuses.Status;

public class Sleep implements Status {
    int turn = 3;

    public boolean canMove() {
        this.turn--;
        if(turn <= 0) {
            return true;
        }
        return false;
    }
}

