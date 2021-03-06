package com.ussshenzhou.rainbow6.entities;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

import javax.annotation.Nullable;

public class ImpactGrenadeEntityRenderer extends EntityRenderer<ImpactGrenadeEntity> {
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation("rainbow6:textures/entity/impactgrenade.png");
    private static final ImpactGrenadeModel IMPACT_GRENADE_MODEL = new ImpactGrenadeModel();
    private float Y = (float) Math.random()*360;
    private float Z = (float) Math.random()*360;
    public ImpactGrenadeEntityRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }
    @Override
    public void render(ImpactGrenadeEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) + Y));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + Z));
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(TEXTURE_LOCATION));
        IMPACT_GRENADE_MODEL.render(matrixStackIn,ivertexbuilder,packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    @Nullable
    @Override
    public ResourceLocation getEntityTexture(ImpactGrenadeEntity entity) {
        return TEXTURE_LOCATION;
    }

}
