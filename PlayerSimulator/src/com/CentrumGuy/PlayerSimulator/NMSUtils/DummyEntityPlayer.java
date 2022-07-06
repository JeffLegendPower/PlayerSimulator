package com.CentrumGuy.PlayerSimulator.NMSUtils;

import com.mojang.authlib.GameProfile;

import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.WorldServer;

public class DummyEntityPlayer extends EntityPlayer {
	public DummyEntityPlayer(MinecraftServer minecraftserver, WorldServer worldserver, GameProfile gameprofile,
			PlayerInteractManager playerinteractmanager) {
		super(minecraftserver, worldserver, gameprofile, playerinteractmanager);
	}
	
	public DummyCraftPlayer getBukkitEntity() {
		if (bukkitEntity == null) {
            bukkitEntity = new DummyCraftPlayer(server.server, (EntityPlayer) this);
        }
		
		return (DummyCraftPlayer) bukkitEntity;
	}
}
