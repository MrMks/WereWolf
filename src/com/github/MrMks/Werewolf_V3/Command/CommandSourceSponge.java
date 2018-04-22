package com.github.MrMks.Werewolf_V3.Command;

import com.github.MrMks.Werewolf_V3.LocaleLang.LocaleCode;
import org.spongepowered.api.command.source.CommandBlockSource;
import org.spongepowered.api.command.source.ConsoleSource;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class CommandSourceSponge extends CommandSource {

    public CommandSourceSponge(org.spongepowered.api.command.CommandSource spongeSource){
        this.spongeSource = spongeSource;
        if(spongeSource instanceof Player) type = SourceType.PLAYER;
        else if (spongeSource instanceof ConsoleSource) type = SourceType.CONSOLE;
        else if (spongeSource instanceof CommandBlockSource) type = SourceType.COMMAND_BLOCK;
    }

    private org.spongepowered.api.command.CommandSource spongeSource;
    @Override
    public String getName() {
        return spongeSource.getName();
    }

    private SourceType type;
    @Override
    public SourceType getType() {
        return type;
    }

    @Override
    public boolean hasPermission(String permission) {
        return spongeSource.hasPermission(permission);
    }

    @Override
    public void sendMessage(LocaleCode msg) {
        spongeSource.sendMessage(Text.of(msg.getTrabslatedMessage()));
    }
}
