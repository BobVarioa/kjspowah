package com.bobvaraioa.kubejspowah;

import com.mojang.logging.LogUtils;
import dev.latvian.mods.kubejs.script.ScriptType;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TagsUpdatedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KubeJSPowah.MODID)
public class KubeJSPowah {
    public static final String MODID = "kubejspowah";

    public KubeJSPowah() {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGHEST, KubeJSPowah::serverReload);
    }

    public static void serverReload(TagsUpdatedEvent event) {
        KubeJSPowahPlugin.COOLANTS.post(ScriptType.SERVER, KubeJSPowahPlugin.CoolantsEvent.INSTANCE);
        KubeJSPowahPlugin.HEAT_SOURCE.post(ScriptType.SERVER, KubeJSPowahPlugin.HeatSourceEvent.INSTANCE);
        KubeJSPowahPlugin.MAGMATIC_FLUID.post(ScriptType.SERVER, KubeJSPowahPlugin.MagmaticFluidEvent.INSTANCE);
    }
}
