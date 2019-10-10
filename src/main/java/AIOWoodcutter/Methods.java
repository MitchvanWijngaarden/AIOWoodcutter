package AIOWoodcutter;

import AIOWoodcutter.data.Location;
import AIOWoodcutter.data.Tree;
import AIOWoodcutter.data.Variables;
import org.parabot.core.reflect.RefClass;
import org.rev317.min.Loader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
//                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
                try {
                    String content = Methods.readFile(fileEntry.getPath(), StandardCharsets.US_ASCII);
                    System.out.println(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getAccountPassword(String accountName) {
        File fileEntry = new File(Variables.DEFAULT_DIR + Variables.FSEP + "accounts" + Variables.FSEP + accountName);
        String password = "";
        try {
            password =  readFile(fileEntry.getPath(), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return password;
    }

    public static String[] getAccounts() {

        File directory = new File(Variables.DEFAULT_DIR + Variables.FSEP + "accounts");
        String[] accounts;

        List<String> accountArray = new ArrayList<>();

        for (final File fileEntry : directory.listFiles()) {
            if (fileEntry.isDirectory()) {
//                listFilesForFolder(fileEntry);
            } else {
                accountArray.add(fileEntry.getName());
                try {
                    String content = Methods.readFile(fileEntry.getPath(), StandardCharsets.US_ASCII);
                    System.out.println(content);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        String[] simpleArray = new String[ accountArray.size() ];
        accountArray.toArray( simpleArray );
        return simpleArray;
    }
}
