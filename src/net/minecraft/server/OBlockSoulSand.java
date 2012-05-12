package net.minecraft.server;

import net.minecraft.server.OAxisAlignedBB;
import net.minecraft.server.OBlock;
import net.minecraft.server.OEntity;
import net.minecraft.server.OMaterial;
import net.minecraft.server.OWorld;

public class OBlockSoulSand extends OBlock {

   public OBlockSoulSand(int var1, int var2) {
      super(var1, var2, OMaterial.o);
   }

   public OAxisAlignedBB e(OWorld var1, int var2, int var3, int var4) {
      float var5 = 0.125F;
      return OAxisAlignedBB.b((double)var2, (double)var3, (double)var4, (double)(var2 + 1), (double)((float)(var3 + 1) - var5), (double)(var4 + 1));
   }

   public void a(OWorld var1, int var2, int var3, int var4, OEntity var5) {
      var5.bp *= 0.4D;
      var5.br *= 0.4D;
   }
}
