package me.rojo8399.placeholderapi.impl.integration;

import io.github.nucleuspowered.nucleus.api.NucleusAPI;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

import java.util.Optional;

public class NucleusUtil {

    public static boolean apiLoaded = false;

    public static void initialize(){
        apiLoaded = Sponge.getPluginManager().getPlugin("nucleus").isPresent();
    }

    public static String getNick(Player p) {
        Optional<Text> optionalText = NucleusAPI.getNicknameService().get().getNickname(p);
        if (optionalText.isPresent()){
            return TextSerializers.FORMATTING_CODE.serialize(optionalText.get()).replaceAll("(&([A-Fa-fK-Ok-oRr0-9]))", "§$2");
        }else {
            return p.getName();
        }
    }
}
