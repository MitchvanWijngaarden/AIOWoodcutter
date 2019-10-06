package AIOWoodcutter.data;

import org.rev317.min.api.wrappers.Tile;
import AIOWoodcutter.Zone;

public class Variables {

    private static Location location;
    private static Tree tree;

    private static String accountUsername;
    private static String accountPassword;

    public static int getLogs() {
        return logs;
    }

    public static void setLogs(int logsNr) {
        logs = logsNr;
    }

    private static int logs;

    public static int getExpGained() {
        return expGained;
    }

    public static void setExpGained(int expGained) {
        Variables.expGained = expGained;
    }

    private static int expGained;

    // Paths
    // Draynor
    public final static Tile[] DRAYNOR_PATH_TO_OAK_TREE = new Tile[]{new Tile(3101, 3244)};
    public final static Tile[] DRAYNOR_PATH_TO_BANK_FROM_OAK_TREE = new Tile[]{new Tile(3092, 3245)};

    public final static Tile[] DRAYNOR_PATH_TO_WILLOW_TREE = new Tile[]{new Tile(3086, 3238)};
    public final static Tile[] DRAYNOR_PATH_TO_BANK_FROM_WILLOW_TREE = new Tile[]{new Tile(3092, 3245)};

    // Seers' village
    public final static Tile[] SEERS_PATH_TO_MAPLE_TREE = new Tile[]{new Tile(2731, 3499)};
    public final static Tile[] SEERS_PATH_TO_BANK_FROM_MAPLE_TREE = new Tile[]{new Tile(2726, 3493)};

    // Zones
    // Draynor
    public final static Zone DRAYNOR_OAK_ZONE = new Zone(new Tile(3098, 3248), new Tile(3105, 3239));
    public final static Zone DRAYNOR_WILLOW_ZONE = new Zone(new Tile(3082, 3239), new Tile(3090, 3226));
    public final static Zone DRAYNOR_BANK = new Zone(new Tile(3088, 3246), new Tile(3097, 3240));

    // Seers' village
    public final static Zone SEERS_MAPLE_ZONE = new Zone(new Tile(2720, 3502), new Tile(2733, 3497));
    public final static Zone SEERS_BANK = new Zone(new Tile(2721, 3493), new Tile(2729, 3486));

    // Tree object ID's
    public final static int[] OAK_TREE_IDS = new int[]{1281};
    public final static int[] WILLOW_TREE_IDS = new int[]{5551, 1308, 5553, 5552};

    public static boolean isDrop() {
        return drop;
    }

    public static void setDrop(boolean drop) {
        Variables.drop = drop;
    }

    public static boolean isBanking() {
        return banking;
    }

    public static void setBanking(boolean banking) {
        Variables.banking = banking;
    }

    private static boolean drop;

    private static boolean banking;

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

    public static String getAccountPassword() {
        return accountPassword;
    }

    public static void setAccountPassword(String i) {
        accountPassword = i;
    }

    public static String getAccountUsername() {
        return accountUsername;
    }

    public static void setAccountUsername(String accountUsername) {
        Variables.accountUsername = accountUsername;
    }

}
