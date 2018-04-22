package com.github.MrMks.Werewolf_V3.SpongeSupport.Commands;

import com.github.MrMks.Werewolf_V3.Command.CommandArgs;
import com.github.MrMks.Werewolf_V3.Command.CommandExecutor.CommandManager;
import com.github.MrMks.Werewolf_V3.Command.CommandSourceSponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;

import java.util.LinkedList;

public class WerewolfCommandExecutor implements CommandExecutor {

    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        CommandSourceSponge source = new CommandSourceSponge(src);
        LinkedList<String> allArg = new LinkedList<>(args.getAll("werewolf"));

        String subCommandLabel = allArg.pollFirst();
        CommandArgs subCommandArgs = new CommandArgs(allArg);

        (new CommandManager()).execute(source,subCommandLabel,subCommandArgs);

        return CommandResult.success();
    }
}
