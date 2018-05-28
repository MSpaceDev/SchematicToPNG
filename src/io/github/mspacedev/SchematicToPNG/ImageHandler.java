package io.github.mspacedev.SchematicToPNG;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Copyright © MSpace-Dev 2018
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class ImageHandler {
    static final HashMap<Integer, Color> blockMap;
    static {
        blockMap = new HashMap<>();
        blockMap.put(0, new Color(0, true));
        blockMap.put(1, Color.decode("#FFFFFF"));
        blockMap.put(4097, Color.decode("#CCCCCC"));
        blockMap.put(8193, Color.decode("#B2B2B2"));
        blockMap.put(12289, Color.decode("#999999"));
        blockMap.put(16385, Color.decode("#808080"));
        blockMap.put(20481, Color.decode("#666666"));
        blockMap.put(24577, Color.decode("#4C4C4C"));
        blockMap.put(2, Color.decode("#333333"));
        blockMap.put(3, Color.decode("#000000"));
        blockMap.put(4099, Color.decode("#FFCCCC"));
        blockMap.put(8195, Color.decode("#FF9999"));
        blockMap.put(4, Color.decode("#FF6666"));
        blockMap.put(5, Color.decode("#FF3232"));
        blockMap.put(4101, Color.decode("#FF0000"));
        blockMap.put(8197, Color.decode("#CC0000"));
        blockMap.put(12293, Color.decode("#990000"));
        blockMap.put(16389, Color.decode("#660000"));
        blockMap.put(20485, Color.decode("#330000"));
        blockMap.put(7, Color.decode("#FFE0CC"));
        blockMap.put(12, Color.decode("#FFC199"));
        blockMap.put(4108, Color.decode("#FFA366"));
        blockMap.put(13, Color.decode("#FF8432"));
        blockMap.put(14, Color.decode("#FF6A00"));
        blockMap.put(15, Color.decode("#CC5100"));
        blockMap.put(16, Color.decode("#993D00"));
        blockMap.put(17, Color.decode("#662800"));
        blockMap.put(16401, Color.decode("#662800"));
        blockMap.put(32785, Color.decode("#662800"));
        blockMap.put(4113, Color.decode("#331400"));
        blockMap.put(20497, Color.decode("#331400"));
        blockMap.put(36881, Color.decode("#331400"));
        blockMap.put(8209, Color.decode("#FFF6CC"));
        blockMap.put(24593, Color.decode("#FFF6CC"));
        blockMap.put(40977, Color.decode("#FFF6CC"));
        blockMap.put(12305, Color.decode("#FFEE99"));
        blockMap.put(28689, Color.decode("#FFEE99"));
        blockMap.put(45073, Color.decode("#FFEE99"));
        blockMap.put(19, Color.decode("#FFE566"));
        blockMap.put(4115, Color.decode("#FFDD32"));
        blockMap.put(20, Color.decode("#FFD800"));
        blockMap.put(21, Color.decode("#CCAA00"));
        blockMap.put(22, Color.decode("#997F00"));
        blockMap.put(24, Color.decode("#665500"));
        blockMap.put(4120, Color.decode("#332A00"));
        blockMap.put(8216, Color.decode("#F0FFCC"));
        blockMap.put(35, Color.decode("#E2FF99"));
        blockMap.put(4131, Color.decode("#D3FF66"));
        blockMap.put(8227, Color.decode("#C5FF32"));
        blockMap.put(12323, Color.decode("#B6FF00"));
        blockMap.put(16419, Color.decode("#92CC00"));
        blockMap.put(20515, Color.decode("#6D9900"));
        blockMap.put(24611, Color.decode("#496600"));
        blockMap.put(28707, Color.decode("#243300"));
        blockMap.put(32803, Color.decode("#DBFFCC"));
        blockMap.put(36899, Color.decode("#B7FF99"));
        blockMap.put(40995, Color.decode("#93FF66"));
        blockMap.put(45091, Color.decode("#70FF32"));
        blockMap.put(49187, Color.decode("#4CFF00"));
        blockMap.put(53283, Color.decode("#3DCC00"));
        blockMap.put(57379, Color.decode("#2D9900"));
        blockMap.put(61475, Color.decode("#1E6600"));
        blockMap.put(41, Color.decode("#0F3300"));
        blockMap.put(42, Color.decode("#CCFFFF"));
        blockMap.put(43, Color.decode("#99FFFF"));
        blockMap.put(4139, Color.decode("#66FFFF"));
        blockMap.put(12331, Color.decode("#32FFFF"));
        blockMap.put(16427, Color.decode("#00FFFF"));
        blockMap.put(20523, Color.decode("#00CCCC"));
        blockMap.put(24619, Color.decode("#009999"));
        blockMap.put(28715, Color.decode("#006666"));
        blockMap.put(44, Color.decode("#99FFFF"));
        blockMap.put(32812, Color.decode("#99FFFF"));
        blockMap.put(4140, Color.decode("#66FFFF"));
        blockMap.put(36908, Color.decode("#66FFFF"));
        blockMap.put(12332, Color.decode("#32FFFF"));
        blockMap.put(45100, Color.decode("#32FFFF"));
        blockMap.put(16428, Color.decode("#00FFFF"));
        blockMap.put(49196, Color.decode("#00FFFF"));
        blockMap.put(20524, Color.decode("#00CCCC"));
        blockMap.put(53292, Color.decode("#00CCCC"));
        blockMap.put(24620, Color.decode("#009999"));
        blockMap.put(57388, Color.decode("#009999"));
        blockMap.put(28716, Color.decode("#006666"));
        blockMap.put(61484, Color.decode("#006666"));
        blockMap.put(45, Color.decode("#003333"));
        blockMap.put(47, Color.decode("#CCE9FF"));
        blockMap.put(48, Color.decode("#99D4FF"));
        blockMap.put(49, Color.decode("#66BFFF"));
        blockMap.put(53, Color.decode("#32AAFF"));
        blockMap.put(4149, Color.decode("#32AAFF"));
        blockMap.put(8245, Color.decode("#32AAFF"));
        blockMap.put(12341, Color.decode("#32AAFF"));
        blockMap.put(16437, Color.decode("#32AAFF"));
        blockMap.put(20533, Color.decode("#32AAFF"));
        blockMap.put(24629, Color.decode("#32AAFF"));
        blockMap.put(28725, Color.decode("#32AAFF"));
        blockMap.put(56, Color.decode("#0094FF"));
        blockMap.put(57, Color.decode("#0077CC"));
        blockMap.put(67, Color.decode("#005999"));
        blockMap.put(4163, Color.decode("#005999"));
        blockMap.put(8259, Color.decode("#005999"));
        blockMap.put(12355, Color.decode("#005999"));
        blockMap.put(16451, Color.decode("#005999"));
        blockMap.put(20547, Color.decode("#005999"));
        blockMap.put(24643, Color.decode("#005999"));
        blockMap.put(28739, Color.decode("#005999"));
        blockMap.put(74, Color.decode("#003B66"));
        blockMap.put(79, Color.decode("#001D33"));
        blockMap.put(80, Color.decode("#CCD3FF"));
        blockMap.put(82, Color.decode("#99A8FF"));
        blockMap.put(86, Color.decode("#667CFF"));
        blockMap.put(4182, Color.decode("#667CFF"));
        blockMap.put(8278, Color.decode("#667CFF"));
        blockMap.put(12374, Color.decode("#667CFF"));
        blockMap.put(87, Color.decode("#3251FF"));
        blockMap.put(88, Color.decode("#0026FF"));
        blockMap.put(89, Color.decode("#001ECC"));
        blockMap.put(91, Color.decode("#001699"));
        blockMap.put(4187, Color.decode("#001699"));
        blockMap.put(8283, Color.decode("#001699"));
        blockMap.put(12379, Color.decode("#001699"));
        blockMap.put(95, Color.decode("#000F66"));
        blockMap.put(4191, Color.decode("#000733"));
        blockMap.put(8287, Color.decode("#D9CCFF"));
        blockMap.put(12383, Color.decode("#B499FF"));
        blockMap.put(16479, Color.decode("#8E66FF"));
        blockMap.put(20575, Color.decode("#6932FF"));
        blockMap.put(24671, Color.decode("#4800FF"));
        blockMap.put(28767, Color.decode("#3600CC"));
        blockMap.put(32863, Color.decode("#280099"));
        blockMap.put(36959, Color.decode("#1B0066"));
        blockMap.put(41055, Color.decode("#0D0033"));
        blockMap.put(45151, Color.decode("#EECCFF"));
        blockMap.put(49247, Color.decode("#DE99FF"));
        blockMap.put(53343, Color.decode("#CE66FF"));
        blockMap.put(57439, Color.decode("#BE32FF"));
        blockMap.put(61535, Color.decode("#B200FF"));
        blockMap.put(98, Color.decode("#8B00CC"));
        blockMap.put(4194, Color.decode("#680099"));
        blockMap.put(8290, Color.decode("#450066"));
        blockMap.put(12386, Color.decode("#220033"));
        blockMap.put(103, Color.decode("#FFCCF8"));
        blockMap.put(108, Color.decode("#FF99F1"));
        blockMap.put(4204, Color.decode("#FF99F1"));
        blockMap.put(8300, Color.decode("#FF99F1"));
        blockMap.put(12396, Color.decode("#FF99F1"));
        blockMap.put(16492, Color.decode("#FF99F1"));
        blockMap.put(20588, Color.decode("#FF99F1"));
        blockMap.put(24684, Color.decode("#FF99F1"));
        blockMap.put(28780, Color.decode("#FF99F1"));
        blockMap.put(109, Color.decode("#FF66EA"));
        blockMap.put(4205, Color.decode("#FF66EA"));
        blockMap.put(8301, Color.decode("#FF66EA"));
        blockMap.put(12397, Color.decode("#FF66EA"));
        blockMap.put(16493, Color.decode("#FF66EA"));
        blockMap.put(20589, Color.decode("#FF66EA"));
        blockMap.put(24685, Color.decode("#FF66EA"));
        blockMap.put(28781, Color.decode("#FF66EA"));
        blockMap.put(110, Color.decode("#FF32E3"));
        blockMap.put(112, Color.decode("#FF00DC"));
        blockMap.put(114, Color.decode("#CC00B0"));
        blockMap.put(4210, Color.decode("#CC00B0"));
        blockMap.put(8306, Color.decode("#CC00B0"));
        blockMap.put(12402, Color.decode("#CC00B0"));
        blockMap.put(16498, Color.decode("#CC00B0"));
        blockMap.put(20594, Color.decode("#CC00B0"));
        blockMap.put(24690, Color.decode("#CC00B0"));
        blockMap.put(28786, Color.decode("#CC00B0"));
        blockMap.put(121, Color.decode("#990084"));
        blockMap.put(126, Color.decode("#660058"));
        blockMap.put(32894, Color.decode("#660058"));
        blockMap.put(4222, Color.decode("#33002C"));
        blockMap.put(36990, Color.decode("#33002C"));
    }

    public void createImage(String imageName, List<Integer> blockIDs){
        BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

        // Place pixels
        int k = 0;
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int key = blockIDs.get(k);
                Color color = blockMap.get(key);

                try{
                    img.setRGB(j, i, color.getRGB());
                }catch(NullPointerException e){
                    System.out.println(imageName + " is null, blockID: " + blockIDs.get(k));
                }

                k++;
            }
        }

        // Write image
        try{
            new File("images").mkdirs();
            File f = new File("images/" + imageName + ".png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
}
