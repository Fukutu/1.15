package cofh.cofh_archery.entity.projectile;

import cofh.lib.util.Utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import static cofh.cofh_archery.init.ModReferences.BLAZE_ARROW_ENTITY;
import static cofh.cofh_archery.init.ModReferences.BLAZE_ARROW_ITEM;
import static cofh.lib.util.constants.Tags.TAG_ARROW_DATA;

public class BlazeArrowEntity extends AbstractArrowEntity {

    private static float DAMAGE = 1.5F;
    private static final int EFFECT_DURATION = 10;

    public static int radius = 2;

    public boolean discharged;

    public BlazeArrowEntity(EntityType<? extends BlazeArrowEntity> entityIn, World worldIn) {

        super(entityIn, worldIn);
        this.damage = DAMAGE;
    }

    public BlazeArrowEntity(World worldIn, LivingEntity shooter) {

        super(BLAZE_ARROW_ENTITY, shooter, worldIn);
        this.damage = DAMAGE;
    }

    public BlazeArrowEntity(World worldIn, double x, double y, double z) {

        super(BLAZE_ARROW_ENTITY, x, y, z, worldIn);
        this.damage = DAMAGE;
    }

    @Override
    protected ItemStack getArrowStack() {

        return discharged ? new ItemStack(Items.ARROW) : new ItemStack(BLAZE_ARROW_ITEM);
    }

    @Override
    protected void onHit(RayTraceResult raytraceResultIn) {

        super.onHit(raytraceResultIn);

        if (!discharged && raytraceResultIn.getType() != RayTraceResult.Type.MISS) {
            if (radius > 0 && !isInWater()) {
                Utils.igniteNearbyEntities(this, world, this.getPosition(), radius, EFFECT_DURATION);
                Utils.igniteNearbyGround(this, world, this.getPosition(), radius);
                discharged = true;
            }
        }
    }

    @Override
    protected void func_213868_a(EntityRayTraceResult raytraceResultIn) {

        super.func_213868_a(raytraceResultIn);

        Entity entity = raytraceResultIn.getEntity();
        if (!entity.isInvulnerable() && !entity.isImmuneToFire() && !isInWater() && !(entity instanceof EndermanEntity)) {
            entity.setFire(EFFECT_DURATION);
        }
    }

    @Override
    public void setFire(int seconds) {

    }

    @Override
    public void setIsCritical(boolean critical) {

    }

    @Override
    public void setKnockbackStrength(int knockbackStrengthIn) {

    }

    @Override
    public void setPierceLevel(byte level) {

    }

    @Override
    public void tick() {

        super.tick();

        if (!this.inGround || this.func_203047_q()) {
            if (Utils.isClientWorld(world) && !isInWater()) {
                Vec3d vec3d = this.getMotion();
                double d1 = vec3d.x;
                double d2 = vec3d.y;
                double d0 = vec3d.z;
                this.world.addParticle(ParticleTypes.LAVA, this.posX + d1 * 0.25D, this.posY + d2 * 0.25D, this.posZ + d0 * 0.25D, -d1, -d2 + 0.2D, -d0);
            }
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {

        super.writeAdditional(compound);
        compound.putBoolean(TAG_ARROW_DATA, discharged);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {

        super.readAdditional(compound);
        discharged = compound.getBoolean(TAG_ARROW_DATA);
    }

    @Override
    public boolean isBurning() {

        return !this.world.isRemote;
    }

    @Override
    public IPacket<?> createSpawnPacket() {

        return NetworkHooks.getEntitySpawningPacket(this);
    }

}