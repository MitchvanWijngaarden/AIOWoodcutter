package AIOWoodcutter.data;

import org.rev317.min.api.wrappers.Tile;
import AIOWoodcutter.Zone;

public enum Tree {

    OAKTREEDRAYNOR("Oak tree", Variables.DRAYNOR_OAK_ZONE, Variables.DRAYNOR_PATH_TO_BANK_FROM_OAK_TREE, Variables.DRAYNOR_PATH_TO_OAK_TREE, Variables.OAK_TREE_IDS),
    WILLOWTREEDRAYNOR("Willow tree", Variables.DRAYNOR_WILLOW_ZONE, Variables.DRAYNOR_PATH_TO_BANK_FROM_WILLOW_TREE, Variables.DRAYNOR_PATH_TO_WILLOW_TREE, Variables.WILLOW_TREE_IDS),
    ;

    private String name;
    private Zone chopZone;
    private Tile[] pathToBank;
    private Tile[] pathToTree;
    private int[] treeIds;

    Tree(String name, Zone chopZone, Tile[] pathToBank, Tile[] pathToTree, int[] treeIds) {
        this.name = name;
        this.chopZone = chopZone;
        this.pathToBank = pathToBank;
        this.pathToTree = pathToTree;
        this.treeIds = treeIds;
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
}
