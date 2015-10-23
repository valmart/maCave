package managers;

import models.Cave;
import models.User;

/**
 * Created by val on 22/10/15.
 */
public class CaveManager {
    public static Cave create(String cave_name, User currUser){
        Cave cave = new Cave(cave_name, currUser);
        cave.save();
        currUser.caves.add(cave);
        currUser.update();
        return (cave);
    }
}
