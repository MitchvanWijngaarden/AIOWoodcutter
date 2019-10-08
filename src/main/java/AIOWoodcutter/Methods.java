package AIOWoodcutter;

import AIOWoodcutter.data.Constants;
import AIOWoodcutter.data.Location;
import AIOWoodcutter.data.Tree;
import org.parabot.core.reflect.RefClass;
import org.rev317.min.Loader;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Methods {
    public static String formatNumber(int start) {
        DecimalFormat nf = new DecimalFormat("0.0");
        double i = start;
        if (i >= 1000000) {
            return nf.format((i / 1000000)) + "M";
        }
        if (i >= 1000) {
            return nf.format((i / 1000)) + "K";
        }
        return "" + start;
    }


    public static String[] locationToStringArray() {
        List<Location> enumList = Arrays.asList(Location.values());
        List<String> locationsArray = new ArrayList<>();
        for (Location loc : enumList) {
            locationsArray.add(loc.getName());
        }

        String[] simpleArray = new String[ locationsArray.size() ];
        locationsArray.toArray( simpleArray );
        return(simpleArray);
    }

    public static String[] treeToStringArray(Location loc) {

        List<Location> enumList = Arrays.asList(Location.values());
        List<String> treesArray = new ArrayList<>();

        for (Location location : enumList) {
            if (location.getName().equalsIgnoreCase(loc.getName())) {
                for(Tree tree : location.getTrees()) {
                    treesArray.add(tree.getName());
                }
            }
        }

        String[] simpleArray = new String[ treesArray.size() ];
        treesArray.toArray( simpleArray );
        return(simpleArray);
    }

    private static String getMessage(String field) {
        RefClass clientClass = new RefClass(Loader.getClient());
        String message = clientClass.getField(field, "Ljava/lang/String;").asString().toLowerCase();
        return message;
    }
}
