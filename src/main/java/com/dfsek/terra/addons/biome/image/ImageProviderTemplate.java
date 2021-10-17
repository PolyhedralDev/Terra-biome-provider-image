package com.dfsek.terra.addons.biome.image;

import com.dfsek.tectonic.annotations.Default;
import com.dfsek.tectonic.annotations.Value;
import com.dfsek.tectonic.loading.object.ObjectTemplate;

import java.awt.image.BufferedImage;
import java.util.HashSet;

import com.dfsek.terra.api.registry.Registry;
import com.dfsek.terra.api.world.biome.TerraBiome;
import com.dfsek.terra.api.world.biome.generation.BiomeProvider;


public class ImageProviderTemplate implements ObjectTemplate<BiomeProvider> {
    private final Registry<TerraBiome> biomes;
    @Value("resolution")
    @Default
    private int resolution = 1;
    @Value("image.name")
    private BufferedImage image;
    @Value("image.align")
    private ImageBiomeProvider.Align align;
    
    public ImageProviderTemplate(Registry<TerraBiome> set) {
        this.biomes = set;
    }
    
    @Override
    public BiomeProvider get() {
        return new ImageBiomeProvider(new HashSet<>(biomes.entries()), image, resolution, align);
    }
}
