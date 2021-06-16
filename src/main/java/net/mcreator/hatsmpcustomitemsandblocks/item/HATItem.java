
package net.mcreator.hatsmpcustomitemsandblocks.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.hatsmpcustomitemsandblocks.procedures.HATLeggingsTickEventProcedure;
import net.mcreator.hatsmpcustomitemsandblocks.procedures.HATHelmetTickEventProcedure;
import net.mcreator.hatsmpcustomitemsandblocks.procedures.HATBootsTickEventProcedure;
import net.mcreator.hatsmpcustomitemsandblocks.procedures.HATBodyTickEventProcedure;
import net.mcreator.hatsmpcustomitemsandblocks.HatSmpModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@HatSmpModElements.ModElement.Tag
public class HATItem extends HatSmpModElements.ModElement {
	@ObjectHolder("hat_smp:hat_helmet")
	public static final Item helmet = null;
	@ObjectHolder("hat_smp:hat_chestplate")
	public static final Item body = null;
	@ObjectHolder("hat_smp:hat_leggings")
	public static final Item legs = null;
	@ObjectHolder("hat_smp:hat_boots")
	public static final Item boots = null;
	public HATItem(HatSmpModElements instance) {
		super(instance, 33);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 1000;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{5, 8, 9, 5}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 100;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(DragonpasteItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "hat";
			}

			@Override
			public float getToughness() {
				return 3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.2f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new Modelsteve().bone;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "hat_smp:textures/hat.png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				super.onArmorTick(itemstack, world, entity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					HATHelmetTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("hat_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "hat_smp:textures/models/armor/dragon__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					HATBodyTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("hat_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "hat_smp:textures/models/armor/dragon__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					HATLeggingsTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("hat_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "hat_smp:textures/models/armor/dragon__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}

			@Override
			public void onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					HATBootsTickEventProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("hat_boots"));
	}
	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class Modelsteve extends EntityModel<Entity> {
		private final ModelRenderer Head;
		private final ModelRenderer bone;
		public Modelsteve() {
			textureWidth = 64;
			textureHeight = 64;
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, 24.0F, 0.0F);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-1.0F, 48.35F, 1.0F);
			setRotationAngle(bone, 0.0F, 0.0F, 0.0F);
			bone.setTextureOffset(3, 1).addBox(-3.0F, -35.0F, -5.0F, 8.0F, 3.0F, 8.0F, 0.0F, false);
			bone.setTextureOffset(9, 1).addBox(-2.0F, -42.0F, -4.0F, 6.0F, 9.0F, 6.0F, 0.0F, false);
			bone.setTextureOffset(11, 49).addBox(-3.0F, -42.0F, -2.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(11, 49).addBox(4.0F, -42.0F, -2.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(11, 49).addBox(0.0F, -42.0F, -5.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(11, 49).addBox(0.0F, -42.0F, 2.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 0).addBox(-4.0F, -35.0F, -3.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(0, 0).addBox(5.0F, -35.0F, -3.0F, 1.0F, 3.0F, 4.0F, 0.0F, false);
			bone.setTextureOffset(0, 0).addBox(-1.0F, -35.0F, -6.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 0).addBox(-1.0F, -35.0F, 3.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(11, 39).addBox(-2.0F, -43.0F, -4.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Head.render(matrixStack, buffer, packedLight, packedOverlay);
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
}
