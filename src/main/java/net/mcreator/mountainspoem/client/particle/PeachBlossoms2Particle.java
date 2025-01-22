
package net.mcreator.mountainspoem.client.particle;

@OnlyIn(Dist.CLIENT)
public class PeachBlossoms2Particle extends TextureSheetParticle {
	public static PeachBlossoms2ParticleProvider provider(SpriteSet spriteSet) {
		return new PeachBlossoms2ParticleProvider(spriteSet);
	}

	public static class PeachBlossoms2ParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public PeachBlossoms2ParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new PeachBlossoms2Particle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected PeachBlossoms2Particle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.quadSize *= 0.9f;
		this.lifetime = 13;
		this.gravity = 0.2f;
		this.hasPhysics = false;
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
