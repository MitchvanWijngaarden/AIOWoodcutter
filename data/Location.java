package AIOWoodcutter.data;
import AIOWoodcutter.Zone;

/**
 * Created by Bautista on 7/16/2015.
 */
public enum Location {


    DRAYNOR("Draynor",
            Variables.DRAYNOR_BANK,
            new Tree[] {Tree.OAKTREEDRAYNOR, Tree.WILLOWTREEDRAYNOR}
    );

    private String name;
    private Zone bankZone;
    private Tree[] trees;

    Location(String name, Zone bankZone, Tree[] trees) {
        this.name = name;
        this.bankZone = bankZone;
        this.trees = trees;
    }

    public Zone getBankZone() {
        return bankZone;
    }

    public String getName() {
        return this.name;
    }

    public Tree[] getTrees() {
        return this.trees;
    }
}
