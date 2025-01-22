
package net.mcreator.mountainspoem.client.particle;

@OnlyIn(Dist.CLIENT)
public class WaterRideParticle extends TextureSheetParticle {
	public static WaterRideParticleProvider provider(SpriteSet spriteSet) {
		return new WaterRideParticleProvider(spriteSet);
	}

	public static class WaterRideParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public WaterRideParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new WaterRideParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected WaterRideParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.lifetime = 11;
		this.gravity = 0.3f;
		this.hasPhysics = true;
		this.xd = vx * 1.1;
		this.yd = vy * 1.1;
		this.zd = vz * 1.1;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
	}

	@Override
	public void tick() {
		super.tick();
	}
}
