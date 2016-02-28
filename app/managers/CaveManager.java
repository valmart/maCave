package managers;

import models.Cave;
import models.User;

/**
 * Created by val on 22/10/15.
 */
public class CaveManager {
    public static Cave create(User currUser){
        Cave cave = new Cave(currUser);
        cave.save();
        cave.qr_code = BarCode.addToCave(cave.id);
        cave.update();
        currUser.caves.add(cave);
        currUser.update();
        return (cave);
    }
}
