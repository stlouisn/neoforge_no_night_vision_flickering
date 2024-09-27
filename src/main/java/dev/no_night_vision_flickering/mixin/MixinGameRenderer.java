package dev.no_night_vision_flickering.mixin;

import static net.minecraft.entity.effect.StatusEffects.NIGHT_VISION;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class MixinGameRenderer {

  @Inject(method = "getNightVisionStrength", at = @At("TAIL"), cancellable = true)
  private static void injectGetNightVisionStrength(LivingEntity entity, float tickDelta, CallbackInfoReturnable<Float> cir) {
    StatusEffectInstance se = entity.getStatusEffect(NIGHT_VISION);
    if (se == null) {
      return;
    }
    float duration = se.getDuration();
    cir.setReturnValue(duration > 100 ? 1 : duration * 0.01f);
  }
}
