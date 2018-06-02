package io.github.mspacedev.SchematicToPNG;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © MSpace-Dev 2018
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class Main {

    private static List<String> listFilesForFolder(final File folder) {
        List<String> files = new ArrayList<>();
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                files.add(fileEntry.getName().substring(0, fileEntry.getName().length() - 10));
            }
        }
        return files;
    }

    public static void main(String[] args) {
        SchematicHandler schematicHandler = new SchematicHandler();
        ImageHandler imageHandler = new ImageHandler();

        String dir = ".";

        final File folder = new File(dir + "/");
        List<String> files = new ArrayList<>(listFilesForFolder(folder));

        for (String s : files){
            List<Integer> blockIDs = schematicHandler.read(dir + "/" + s + ".schematic");
            if (blockIDs.isEmpty())
                continue;
            imageHandler.createImage(s, blockIDs);
        }

        JOptionPane.showMessageDialog(null, "Program finished running!");
    }

}
