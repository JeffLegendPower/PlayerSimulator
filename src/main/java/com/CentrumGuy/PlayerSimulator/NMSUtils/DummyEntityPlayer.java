package com.CentrumGuy.PlayerSimulator.NMSUtils;

import com.CentrumGuy.PlayerSimulator.Bot;
import com.mojang.authlib.GameProfile;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.WorldServer;

public class DummyEntityPlayer extends EntityPlayer {

	private final Bot bot;

	public DummyEntityPlayer(MinecraftServer minecraftserver, WorldServer worldserver, GameProfile gameprofile,
							 PlayerInteractManager playerinteractmanager, Bot bot) {
		super(minecraftserver, worldserver, gameprofile, playerinteractmanager);
		this.bot = bot;
	}
	
	public DummyCraftPlayer getBukkitEntity() {
		if (bukkitEntity == null) {
            bukkitEntity = new DummyCraftPlayer(server.server, this, bot);
        }
		
		return (DummyCraftPlayer) bukkitEntity;
	}
}
