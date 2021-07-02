// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

public static class Modelsteve extends EntityModel<Entity> {
	private final ModelRenderer Head;

	public Modelsteve() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(39, 49).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 1.0F, 6.0F, 0.0F, false);
		Head.setTextureOffset(49, 60).addBox(-2.0F, -9.0F, -4.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(45, 57).addBox(-4.0F, -9.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(48, 54).addBox(-2.0F, -9.0F, 3.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(44, 48).addBox(3.0F, -9.0F, -2.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(14, 45).addBox(-1.0F, -16.0F, -3.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(45, 52).addBox(-2.0F, -15.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);
		Head.setTextureOffset(14, 45).addBox(-1.0F, -16.0F, 2.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);
		Head.setTextureOffset(14, 45).addBox(-3.0F, -16.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(14, 45).addBox(2.0F, -16.0F, -1.0F, 1.0F, 7.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(14, 45).addBox(-2.0F, -16.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}