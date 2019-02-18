package me.rojo8399.placeholderapi.impl.integration;

import me.lucko.luckperms.LuckPerms;
import me.lucko.luckperms.api.Contexts;
import me.lucko.luckperms.api.User;
import me.lucko.luckperms.api.caching.MetaData;
import me.lucko.luckperms.api.caching.PermissionData;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;

public class LuckPermsUtil {

    public static boolean apiLoaded = false;

    public static void initialize(){
        apiLoaded = Sponge.getPluginManager().getPlugin("luckperms").isPresent();
    }

    public static String getPlayerPrefix(Player player){
        User user = LuckPerms.getApi().getUser(player.getUniqueId());
        Contexts contexts = LuckPerms.getApi().getContextManager().lookupApplicableContexts(user).get();
        PermissionData permissionData = user.getCachedData().getPermissionData(contexts);
        MetaData metaData = user.getCachedData().getMetaData(permissionData.getContexts());
        return metaData.getPrefix().replaceAll("(&([A-Fa-fK-Ok-oRr0-9]))", "§$2");
    }

}
