
package net.mcreator.mountainspoem.client.particle;

@OnlyIn(Dist.CLIENT)
public class SacrificeJParticle extends TextureSheetParticle {
	public static SacrificeJParticleProvider provider(SpriteSet spriteSet) {
		return new SacrificeJParticleProvider(spriteSet);
	}

	public static class SacrificeJParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public SacrificeJParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new SacrificeJParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected SacrificeJParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.4f, 0.4f);
		this.quadSize *= 1.6f;
		this.lifetime = (int) Math.max(1, 13 + (this.random.nextInt(2) - 1));
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
