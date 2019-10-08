package AIOWoodcutter.data;

import org.rev317.min.api.wrappers.Tile;
import AIOWoodcutter.Zone;

public enum Tree {

    OAKTREEDRAYNOR("Oak tree",
            Variables.DRAYNOR_OAK_ZONE,
            Variables.DRAYNOR_PATH_TO_BANK_FROM_OAK_TREE,
            Variables.DRAYNOR_PATH_TO_OAK_TREE,
            Variables.OAK_TREE_IDS,
            37.5,
            1522),
    WILLOWTREEDRAYNOR("Willow tree",
            Variables.DRAYNOR_WILLOW_ZONE,
            Variables.DRAYNOR_PATH_TO_BANK_FROM_WILLOW_TREE,
            Variables.DRAYNOR_PATH_TO_WILLOW_TREE,
            Variables.WILLOW_TREE_IDS,
            67.5,
            1520),
    MAPLETREESEERS("Maple tree",
            Variables.SEERS_MAPLE_ZONE,
            Variables.SEERS_PATH_TO_BANK_FROM_MAPLE_TREE,
            Variables.SEERS_PATH_TO_MAPLE_TREE,
            Variables.MAPLE_TREE_IDS,
            100.0,
            1518),
    NORMALTREEVWEST("Normal tree",
            Variables.VARROCK_WEST_OAK_ZONE,
            Variables.VARROCK_WEST_PATH_TO_BANK_FROM_OAK,
            Variables.VARROCK_WEST_PATH_TO_OAK,
            Variables.NORMAL_TREE_IDS,
            25.0,
            1512),
    OAKTREEVWEST("Oak VWest",
            Variables.VARROCK_WEST_OAK_ZONE,
            Variables.VARROCK_WEST_PATH_TO_BANK_FROM_OAK,
            Variables.VARROCK_WEST_PATH_TO_OAK,
            Variables.OAK_TREE_IDS,
            37.5,
            1512),
    ;

    private String name;
    private Zone chopZone;
    private Tile[] pathToBank;
    private Tile[] pathToTree;
    private int[] treeIds;
    private double exp;
    private int logId;

    Tree(String name, Zone chopZone, Tile[] pathToBank, Tile[] pathToTree, int[] treeIds, double exp, int logId) {
        this.name = name;
        this.chopZone = chopZone;
        this.pathToBank = pathToBank;
        this.pathToTree = pathToTree;
        this.treeIds = treeIds;
        this.exp = exp;
        this.logId = logId;
    }

    public Zone getChopZone() {
        return chopZone;
    }

    public Tile[] getPathToBank() {
        return pathToBank;
    }

    public Tile[] getPathToTree() {
        return pathToTree;
    }

    public String getName() {
        return this.name;
    }

    public int[] getTreeIds() {return this.treeIds;}

    public double getExp() {
        return exp;
    }

    public int getLogId() {
        return logId;
    }
}
