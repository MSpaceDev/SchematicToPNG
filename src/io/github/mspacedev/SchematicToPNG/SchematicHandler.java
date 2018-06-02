package io.github.mspacedev.SchematicToPNG;

import org.jnbt.*;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Copyright © MSpace-Dev 2018
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class SchematicHandler {
    private Tag getChildTag(Map<String, Tag> items, String key, Class<? extends Tag> expected) {
        Tag tag = items.get(key);
        return tag;
    }

    public List<Integer> read(String schematicName){
        List<Integer> blockIDs = new ArrayList<>();

        try {
            File f = new File(schematicName);
            FileInputStream fis = new FileInputStream(f);
            NBTInputStream nbt = new NBTInputStream(fis);
            CompoundTag backuptag = (CompoundTag) nbt.readTag();
            Map<String, Tag> tagCollection = backuptag.getValue();

            short width = (Short)getChildTag(tagCollection, "Width", ShortTag.class).getValue();
            short height = (Short) getChildTag(tagCollection, "Height", ShortTag.class).getValue();
            short length = (Short) getChildTag(tagCollection, "Length", ShortTag.class).getValue();

            byte[] blocks = (byte[]) getChildTag(tagCollection, "Blocks", ByteArrayTag.class).getValue();
            byte[] data = (byte[]) getChildTag(tagCollection, "Data", ByteArrayTag.class).getValue();

            nbt.close();
            fis.close();

            if(height == 16){
                if((width == 16 && length == 1) || (width == 1 && length == 16)){
                    for (int i = blocks.length - 1; i >= 0; i--) {
                        int uniqueID = (blocks[i] + (data[i] * 4096));
                        blockIDs.add(uniqueID);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, schematicName + " is an invalid size!" +
                        "\n\n\nCurrent Size: [" + width + "," + height + "," + length + "]" +
                        "\n\nShould be: [16,16,1] OR [1,16,16]");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return blockIDs;
    }
}
