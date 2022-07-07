package com.CentrumGuy.PlayerSimulator.NMSUtils;

import com.CentrumGuy.PlayerSimulator.Bot;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.scoreboard.Scoreboard;

import net.minecraft.server.v1_8_R3.EntityPlayer;

public class DummyCraftPlayer extends CraftPlayer {

	private final Bot bot;

	public DummyCraftPlayer(CraftServer server, EntityPlayer entity, Bot bot) {
		super(server, entity);
		this.bot = bot;
	}

	public void setScoreboard(Scoreboard scoreboard) {
		super.setScoreboard(scoreboard);
		/*Validate.notNull(scoreboard, "Scoreboard cannot be null");
        PlayerConnection playerConnection = getHandle().playerConnection;
        if (playerConnection == null) {
            throw new IllegalStateException("Cannot set scoreboard yet");
        }
        if (playerConnection.isDisconnected()) {
            throw new IllegalStateException("Cannot set scoreboard for invalid CraftPlayer");
        }

        this.server.getScoreboardManager().setPlayerBoard(this, scoreboard);*/
	}

	public Bot getBot() {
		return bot;
	}
}
