package AIOWoodcutter.data;

import org.rev317.min.api.wrappers.Tile;
import AIOWoodcutter.Zone;

public class Variables {

    private static Location location;
    private static Tree tree;

    public static int getLogs() {
        return logs;
    }

    public static void setLogs(int logsNr) {
        logs = logsNr;
    }

    private static int logs;

    public final static Tile[] DRAYNOR_PATH_TO_OAK_TREE = new Tile[]{new Tile(3101, 3244)};
    public final static Tile[] DRAYNOR_PATH_TO_BANK_FROM_OAK_TREE = new Tile[]{new Tile(3092, 3245)};

    public final static Tile[] DRAYNOR_PATH_TO_WILLOW_TREE = new Tile[]{new Tile(3086, 3238)};
    public final static Tile[] DRAYNOR_PATH_TO_BANK_FROM_WILLOW_TREE = new Tile[]{new Tile(3092, 3245)};

    public final static Zone DRAYNOR_OAK_ZONE = new Zone(new Tile(3098, 3248), new Tile(3105, 3239));
    public final static Zone DRAYNOR_WILLOW_ZONE = new Zone(new Tile(3082, 3239), new Tile(3090, 3226));
    public final static Zone DRAYNOR_BANK = new Zone(new Tile(3088, 3246), new Tile(3097, 3240));

    public final static int[] OAK_TREE_IDS = new int[]{1281};
    public final static int[] WILLOW_TREE_IDS = new int[]{5551, 1308, 5553, 5552};

    public static boolean isDrop() {
        return drop;
    }

    public static void setDrop(boolean drop) {
        Variables.drop = drop;
    }

    public static boolean isSell() {
        return sell;
    }

    public static void setSell(boolean sell) {
        Variables.sell = sell;
    }

    private static boolean drop;

    private static boolean sell;

    public static Location getLocation() {
        return location;
    }

    public static void setLocation(Location i) {
        location = i;
    }

    public static void setTree(Tree treeToSet) {
        tree = treeToSet;
    }
    public static Tree getTree(){
        return tree;
    }
}
