package com.ermans.bottledanimals.init;

import com.ermans.bottledanimals.block.generator.basicgenerator.BlockBasicGenerator;
import com.ermans.bottledanimals.block.machine.animaldigitizer.BlockAnimalDigitizer;
import com.ermans.bottledanimals.block.machine.animalmaterializer.BlockAnimalMaterializer;
import com.ermans.bottledanimals.block.machine.breeder.BlockBreeder;
import com.ermans.bottledanimals.block.machine.dropextractor.BlockDropExtractor;
import com.ermans.bottledanimals.block.machine.foodcrusher.BlockFoodCrusher;
import com.ermans.bottledanimals.block.machine.growthaccelerator.BlockGrowthAccelerator;
import com.ermans.bottledanimals.block.machine.rancher.BlockRancher;
import com.ermans.bottledanimals.block.machine.wirelessfeeder.BlockWirelessFeeder;
import com.ermans.bottledanimals.block.simple.BlockMachineFrame;
import com.ermans.bottledanimals.fluid.FluidBlockBA;
import com.ermans.bottledanimals.reference.Names;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;
import java.util.Map;

public class ModBlocks {

    public static BlockAnimalDigitizer blockAnimalDigitizer;
    public static BlockBreeder blockBreeder;
    public static BlockGrowthAccelerator blockGrowthAccelerator;
    public static BlockDropExtractor blockDropExtractor;
    public static BlockWirelessFeeder blockWirelessFeeder;
    public static BlockRancher blockRancher;
    public static BlockFoodCrusher blockFoodCrusher;
    public static BlockAnimalMaterializer blockAnimalMaterializer;

    public static BlockMachineFrame blockMachineFrame;

    public static BlockBasicGenerator blockBasicGenerator;

    public static FluidBlockBA milkBlock;
    public static FluidBlockBA foodBlock;

    public static Map<String, Block> blocks = new HashMap<String, Block>();
    public static Map<String, FluidBlockBA> fluidBlocks = new HashMap<String, FluidBlockBA>();


    public static void registerBlocks() {

        ////MACHINES
        blockAnimalDigitizer = (BlockAnimalDigitizer) registerBlock(new BlockAnimalDigitizer(), Names.Machines.ANIMAL_DIGITIZER);




        ////FLUID BLOCKS
        milkBlock = registerFluidBlock(FluidBlockBA.create(ModFluids.milk));
        foodBlock = registerFluidBlock(FluidBlockBA.create(ModFluids.food));


//        blockBreeder = new BlockBreeder();
//        blockGrowthAccelerator = new BlockGrowthAccelerator();
//        blockDropExtractor = new BlockDropExtractor();
//        blockWirelessFeeder = new BlockWirelessFeeder();
//        blockRancher = new BlockRancher();
//        blockFoodCrusher = new BlockFoodCrusher();
//        blockAnimalMaterializer = new BlockAnimalMaterializer();
//
//        blockMachineFrame = new BlockMachineFrame();
//
//        blockBasicGenerator = new BlockBasicGenerator();

//        milkBlock = FluidBlockBA.create(ModFluids.milk, Material.water);
//        foodBlock = FluidBlockBA.create(ModFluids.food, Material.water);

//        GameRegistry.registerBlock(blockAnimalDigitizer, Names.Machines.ANIMAL_DIGITIZER);
//        GameRegistry.registerBlock(blockBreeder, Names.Machines.BREEDER);
//        GameRegistry.registerBlock(blockGrowthAccelerator, Names.Machines.GROWTH_ACCELERATOR);
//        GameRegistry.registerBlock(blockDropExtractor, Names.Machines.DROP_EXTRACTOR);
//        GameRegistry.registerBlock(blockWirelessFeeder, Names.Machines.WIRELESS_FEEDER);
//        GameRegistry.registerBlock(blockRancher, Names.Machines.RANCHER);
//        GameRegistry.registerBlock(blockFoodCrusher, Names.Machines.FOOD_CRUSHER);
//        GameRegistry.registerBlock(blockAnimalMaterializer, Names.Machines.ANIMAL_MATERIALIZER);
//
//        GameRegistry.registerBlock(blockMachineFrame, Names.Blocks.MACHINE_FRAME);
//
//        GameRegistry.registerBlock(blockBasicGenerator, Names.Machines.BASIC_GENERATOR);
//
//        GameRegistry.registerBlock(milkBlock, "block" + StringUtils.capitalize(ModFluids.milk.getName()));
//        GameRegistry.registerBlock(foodBlock, "block" + StringUtils.capitalize(ModFluids.food.getName()));
    }

    private static Block registerBlock(Block block, String blockName) {
        blocks.put(blockName, block);
        return GameRegistry.registerBlock(block, blockName);
    }

    private static FluidBlockBA registerFluidBlock(FluidBlockBA block) {
        fluidBlocks.put(block.getRegistryName(), block);
        return (FluidBlockBA) GameRegistry.registerBlock(block);
    }
}
