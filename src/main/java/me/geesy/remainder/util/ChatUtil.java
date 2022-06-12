package me.geesy.remainder.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ChatUtil {


    public static void sendChatMessage(String msg){
            IChatComponent chatComponent = new ChatComponentText(msg);
            if(Minecraft.getMinecraft().thePlayer != null){
            (Minecraft.getMinecraft().thePlayer).addChatMessage(chatComponent);}
    }
}
