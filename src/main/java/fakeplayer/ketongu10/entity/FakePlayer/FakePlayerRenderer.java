package fakeplayer.ketongu10.entity.FakePlayer;

import fakeplayer.ketongu10.entity.test.EntityTest;
import fakeplayer.ketongu10.entity.test.ModelTest;
import fakeplayer.ketongu10.util.Reference;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class FakePlayerRenderer extends RenderLivingBase<EntityFakePlayer>
{
    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID + ":textures/entity/fakeplayer.png");

    public FakePlayerRenderer(RenderManager manager)
    {
        super(manager, new ModelVillager(0), 0.2f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFakePlayer entity)
    {
        return TEXTURE;
    }
}
