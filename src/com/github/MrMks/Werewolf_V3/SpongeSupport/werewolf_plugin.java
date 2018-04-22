package com.github.MrMks.Werewolf_V3.SpongeSupport;

import com.github.MrMks.Werewolf_V3.SpongeSupport.Commands.WerewolfCommandExecutor;
import com.github.MrMks.Werewolf_V3.SpongeSupport.TabCompleter.WerewolfCommandElement;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartingServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;

@Plugin(id = "werewolf",name = "WereWolf")
public class werewolf_plugin {

    @Listener
    public void OnIntialization(GameStartingServerEvent event){
        CommandSpec commandSpec = CommandSpec.builder()
                .arguments(new WerewolfCommandElement(Text.of("werewolf")))
                .executor(new WerewolfCommandExecutor())
                .build();

        Sponge.getCommandManager().register(this,commandSpec,"ww");
    }

}
