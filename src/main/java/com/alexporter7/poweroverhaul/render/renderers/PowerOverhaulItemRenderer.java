package com.alexporter7.poweroverhaul.render.renderers;

import com.alexporter7.poweroverhaul.render.PowerOverhaulModelBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

import static com.alexporter7.poweroverhaul.util.ModelManager.Texture.NETWORK_TOOL;

public class PowerOverhaulItemRenderer implements IItemRenderer {

    private final PowerOverhaulModelBase MODEL;

    public PowerOverhaulItemRenderer(PowerOverhaulModelBase modelBase) {
        MODEL = modelBase;
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        switch(type) {
            case EQUIPPED:
            case EQUIPPED_FIRST_PERSON:
            case INVENTORY:
                return true;
            default:
                return false;
        }
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        switch(type) {
            case EQUIPPED:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(NETWORK_TOOL.getResourceLocation());
                GL11.glScalef(1.5f, 1.5f, 1.5f);
                GL11.glTranslatef(0.5f, 1.75f, 0.5f);
                GL11.glRotatef(180, 0, 0, 1);
                GL11.glRotatef(150, 0, 1, 0);
                MODEL.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            case EQUIPPED_FIRST_PERSON:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(NETWORK_TOOL.getResourceLocation());
                GL11.glScalef(1.5f, 1.5f, 1.5f);
                GL11.glTranslatef(0.5f, 2.0f, 0.25f);
                GL11.glRotatef(180, 0, 0, 1);
                GL11.glRotatef(240, 0, 1, 0);
                MODEL.render((Entity)data[1], 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
                GL11.glPopMatrix();
                break;
            case INVENTORY:
                GL11.glPushMatrix();
                Minecraft.getMinecraft().renderEngine.bindTexture(NETWORK_TOOL.getResourceLocation());
                GL11.glScalef(1.5f, 1.5f, 1.5f);
                GL11.glTranslatef(0.5f, 1.5f, 0.5f);
                GL11.glRotatef(180, 0, 0, 1);
                GL11.glRotatef(100, 0, 1, 0);
                MODEL.renderModel(0.0625f);
                GL11.glPopMatrix();
            default:
                break;
        }



    }
}
