package svenhjol.charmony.decor.common.features.chairs;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

public class Chair extends Entity {
    public Chair(EntityType<Chair> entityType, Level level) {
        super(entityType, level);
    }

    public Chair(Level level, BlockPos pos) {
        super(Chairs.feature().registers.entity.get(), level);
        setPos(pos.getX() + 0.5d, pos.getY() + 0.5d, pos.getZ() + 0.5d);

        var facing = level.getBlockState(pos)
            .getValue(StairBlock.FACING)
            .getOpposite();

        setYRot(facing.toYRot());
    }

    @Override
    public void tick() {
        super.tick();

        var level = level();
        var pos = blockPosition();
        var state = level.getBlockState(pos);
        var block = state.getBlock();

        if (!level.isClientSide()) {
            var stateAbove = level.getBlockState(pos.above());

            if (!(block instanceof StairBlock)) {
                unRide();
                remove(RemovalReason.DISCARDED);
                Chairs.feature().log().debug("Removing because no longer a stairs block");
            } else if (stateAbove.isCollisionShapeFullBlock(level, pos.above())) {
                unRide();
                remove(RemovalReason.DISCARDED);
                Chairs.feature().log().debug("Removing because block above is invalid");
            } else if (!hasExactlyOnePlayerPassenger()) {
                remove(RemovalReason.DISCARDED);
                Chairs.feature().log().debug("Removing because no passengers");
            }
        }
    }

    @Override
    public boolean hurtServer(ServerLevel serverLevel, DamageSource damageSource, float f) {
        return false;
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float f) {
        return new Vec3(0.0f, getPassengersRidingOffsetY(entityDimensions), 0.0f);
    }

    protected float getPassengersRidingOffsetY(EntityDimensions entityDimensions) {
        return entityDimensions.height() - 0.25f;
    }

    @Override
    protected void positionRider(Entity entity, MoveFunction moveFunction) {
        super.positionRider(entity, moveFunction);
        clampRotation(entity);
    }

    @Override
    public void onPassengerTurned(Entity entity) {
        clampRotation(entity);
    }

    private void clampRotation(Entity entity) {
        entity.setYBodyRot(this.getYRot());
        var f = Mth.wrapDegrees(entity.getYRot() - this.getYRot());
        var g = Mth.clamp(f, -105.0f, 105.0f);
        entity.yRotO += g - f;
        entity.setYRot(entity.getYRot() + g - f);
        entity.setYHeadRot(entity.getYRot());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        // no op
    }

    @Override
    protected void readAdditionalSaveData(ValueInput valueInput) {
        // no op
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput valueOutput) {
        // no op
    }
}
