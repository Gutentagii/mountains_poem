
package net.mcreator.mountainspoem.client.particle;

@OnlyIn(Dist.CLIENT)
public class SoulsPieceParticle extends TextureSheetParticle {
	public static SoulsPieceParticleProvider provider(SpriteSet spriteSet) {
		return new SoulsPieceParticleProvider(spriteSet);
	}

	public static class SoulsPieceParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public SoulsPieceParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new SoulsPieceParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;
	private float angularVelocity;
	private float angularAcceleration;

	protected SoulsPieceParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.quadSize *= 1.1f;
		this.lifetime = (int) Math.max(1, 8 + (this.random.nextInt(6) - 3));
		this.gravity = 0.3f;
		this.hasPhysics = true;
		this.xd = vx * 1.1;
		this.yd = vy * 1.1;
		this.zd = vz * 1.1;
		this.angularVelocity = 0.2f;
		this.angularAcceleration = 0f;
		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();
		this.oRoll = this.roll;
		this.roll += this.angularVelocity;
		this.angularVelocity += this.angularAcceleration;
	}
}
