package com.xiris.mountainspoem.client.particle;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

@OnlyIn(Dist.CLIENT)
public class SacrificeAParticle extends TextureSheetParticle {
    public static SacrificeAParticleProvider provider(SpriteSet spriteSet) {
        return new SacrificeAParticleProvider(spriteSet);
    }

    public static class SacrificeAParticleProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public SacrificeAParticleProvider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new SacrificeAParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }
    }

    private final SpriteSet spriteSet;

    protected SacrificeAParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z);
        this.spriteSet = spriteSet;
        this.setSize(0.4f, 0.4f);
        this.quadSize *= 1.6f;
        this.lifetime = Math.max(1, 13 + (this.random.nextInt(2) - 1));
        this.gravity = -0.3f;
        this.hasPhysics = true;
        this.xd = vx * 1.1;
        this.yd = vy * 1.1;
        this.zd = vz * 1.1;
        this.pickSprite(spriteSet);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {
        super.tick();
    }
}
