package com.ussshenzhou.rainbow6.tileentities;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModTileEntityRendererRegistry {
    @SubscribeEvent
    public static void registryTileEntityRenderer(FMLClientSetupEvent event){
        ClientRegistry.bindTileEntityRenderer(ModTileEntityTypes.BlackMirrorTileEntityType,BlackMirrorTileEntityRenderer::new);
    }
}
