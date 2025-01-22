
package net.mcreator.mountainspoem.world.features.treedecorators;

import com.mojang.serialization.Codec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class YanforestFruitDecorator extends CocoaDecorator {
	public static Codec<YanforestFruitDecorator> CODEC = Codec.unit(YanforestFruitDecorator::new);
	public static TreeDecoratorType<?> DECORATOR_TYPE = new TreeDecoratorType<>(CODEC);

	@SubscribeEvent
	public static void registerTreeDecorator(RegisterEvent event) {
		event.register(ForgeRegistries.Keys.TREE_DECORATOR_TYPES, registerHelper -> registerHelper.register("yanforest_tree_fruit_decorator", DECORATOR_TYPE));
	}

	public YanforestFruitDecorator() {
		super(0.2f);
	}

	@Override
	protected @NotNull TreeDecoratorType<?> type() {
		return DECORATOR_TYPE;
	}

	/* failed to load code for net.minecraft.world.level.levelgen.feature.treedecorators.CocoaDecorator */
	private static BlockState oriented(BlockState blockstate, Direction direction) {
		return switch (direction) {
			case SOUTH -> blockstate.getBlock().rotate(blockstate, Rotation.CLOCKWISE_180);
			case EAST -> blockstate.getBlock().rotate(blockstate, Rotation.CLOCKWISE_90);
			case WEST -> blockstate.getBlock().rotate(blockstate, Rotation.COUNTERCLOCKWISE_90);
			default -> blockstate;
		};
	}
}
