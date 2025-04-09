package com.alexporter7.poweroverhaul.generators;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

import javax.imageio.ImageIO;

import com.alexporter7.poweroverhaul.api.material.PowerOverhaulMaterial;
import com.alexporter7.poweroverhaul.init.MaterialDef;

public class MaterialTextureGenerator {

    public static final String BASE_ORE_BLOCK_TEXTURE = "ore_block_base_1";
    public static final String BASE_ORE_OVERLAY_TEXTURE = "ore_block_material_dull";

    public static void main(String[] args) throws FileNotFoundException {
        generateOreTextures();
    }

    public static void generateOreTextures() throws FileNotFoundException {
        HashSet<PowerOverhaulMaterial> materials = MaterialDef.createMaterialList();

        for (PowerOverhaulMaterial material : materials) {
            BufferedImage result = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
            Graphics2D image = result.createGraphics();

            try {
                BufferedImage base = ImageIO.read(getBlockFileLocation(BASE_ORE_BLOCK_TEXTURE));
                BufferedImage overlayRaw = ImageIO.read(getBlockFileLocation(BASE_ORE_OVERLAY_TEXTURE));
                BufferedImage overlayTinted = tintTexture(overlayRaw, material);

                image.drawImage(base, null, 0, 0);
                image.drawImage(overlayTinted, null, 0, 0);

                File outputFile = new File(getFileOutput(material));
                ImageIO.write(result, "png", outputFile);
            } catch (IOException exception) {
                throw new FileNotFoundException();
            }

        }
    }

    public static BufferedImage tintTexture(BufferedImage overlay, PowerOverhaulMaterial material) {
        BufferedImage result = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics2D image = result.createGraphics();
        Color overlayColor = new Color(material.getColor());

        image.drawImage(overlay, null, 0, 0);
        image.setColor(overlayColor);
        image.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, 0.75f));
        image.fillRect(0, 0, 16, 16);

        return result;
    }

    public static File getBlockFileLocation(String textureName) {
        return new File("./src/main/resources/assets/poweroverhaul/textures/blocks/" + textureName + ".png");
    }

    public static String getFileOutput(PowerOverhaulMaterial material) {
        return "./src/main/resources/assets/poweroverhaul/textures/blocks/ores/" + material.getName()
            + "_ore_block.png";
    }
}
