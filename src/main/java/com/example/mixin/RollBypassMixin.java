package com.example.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.combatroll.client.RollManager")
public class RollBypassMixin {
    @Inject(method = "canRoll", at = @At("HEAD"), cancellable = true)
    private static void bypassMouseHoldRestriction(ClientPlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (player.isUsingItem() && !player.isSwimming() && !player.isClimbing()) {
            cir.setReturnValue(true);
        }
    }
}
