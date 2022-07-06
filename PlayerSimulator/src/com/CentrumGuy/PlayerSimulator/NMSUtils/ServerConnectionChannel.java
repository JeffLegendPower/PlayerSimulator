package com.CentrumGuy.PlayerSimulator.NMSUtils;

import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import net.minecraft.server.v1_8_R3.EnumProtocolDirection;
import net.minecraft.server.v1_8_R3.HandshakeListener;
import net.minecraft.server.v1_8_R3.LegacyPingHandler;
import net.minecraft.server.v1_8_R3.NetworkManager;
import net.minecraft.server.v1_8_R3.PacketDecoder;
import net.minecraft.server.v1_8_R3.PacketEncoder;
import net.minecraft.server.v1_8_R3.PacketListener;
import net.minecraft.server.v1_8_R3.PacketPrepender;
import net.minecraft.server.v1_8_R3.PacketSplitter;
import net.minecraft.server.v1_8_R3.ServerConnection;

@SuppressWarnings({ "rawtypes"})
public class ServerConnectionChannel extends ChannelInitializer {
    final ServerConnection a;

    public ServerConnectionChannel(ServerConnection serverconnection) {
        this.a = serverconnection;
    }

    protected void initChannel(Channel channel) {
        try {
            channel.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
        } catch (ChannelException channelexception) {
            ;
        }

        try {
            channel.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
        } catch (ChannelException channelexception1) {
            ;
        }

        channel.pipeline().addLast("timeout", new ReadTimeoutHandler(30)).addLast("legacy_query", (ChannelHandler) (new LegacyPingHandler(this.a))).addLast("splitter", (ChannelHandler) (new PacketSplitter())).addLast("decoder", (ChannelHandler) (new PacketDecoder(EnumProtocolDirection.SERVERBOUND))).addLast("prepender", (ChannelHandler) (new PacketPrepender())).addLast("encoder", (ChannelHandler) (new PacketEncoder(EnumProtocolDirection.CLIENTBOUND)));
        NetworkManager networkmanager = new NetworkManager(EnumProtocolDirection.SERVERBOUND);
        
        channel.pipeline().addLast("packet_handler", networkmanager);
        networkmanager.a(new HandshakeListener(a.d(), networkmanager));
    }
}