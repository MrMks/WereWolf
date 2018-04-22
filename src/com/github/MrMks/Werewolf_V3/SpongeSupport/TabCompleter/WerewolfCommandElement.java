package com.github.MrMks.Werewolf_V3.SpongeSupport.TabCompleter;

import com.github.MrMks.Werewolf_V3.Command.CommandSourceSponge;
import com.github.MrMks.Werewolf_V3.Command.TabCompleter.TabCompleterManager;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;

public class WerewolfCommandElement extends CommandElement {
    public WerewolfCommandElement(@Nullable Text key) {
        super(key);
    }

    @Nullable
    @Override
    protected Object parseValue(CommandSource source, CommandArgs args) throws ArgumentParseException {
        return args.getAll() ;
    }

    @Override
    public List<String> complete(CommandSource src, CommandArgs args, CommandContext context) {
        CommandSourceSponge source = new CommandSourceSponge(src);
        LinkedList<String> allArgs = new LinkedList<>(context.getAll("werewolf"));

        String subCommandLabel = allArgs.pollFirst();
        com.github.MrMks.Werewolf_V3.Command.CommandArgs subCommandArgs = new com.github.MrMks.Werewolf_V3.Command.CommandArgs(allArgs);

        return TabCompleterManager.complete(source,subCommandLabel,subCommandArgs);
    }

    @Override
    public Text getUsage(CommandSource src){
        return null;
    }
}
