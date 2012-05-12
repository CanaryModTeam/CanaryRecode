package net.minecraft.server;

import net.canarymod.api.DamageSource;
import net.minecraft.server.OEntity;
import net.minecraft.server.OEntityArrow;
import net.minecraft.server.OEntityDamageSource;
import net.minecraft.server.OEntityDamageSourceIndirect;
import net.minecraft.server.OEntityFireball;
import net.minecraft.server.OEntityLiving;
import net.minecraft.server.OEntityPlayer;
import net.minecraft.server.OStatCollector;
/**
 * CanaryMod Modified!
 * @author Chris
 *
 */
public class ODamageSource {

   public static ODamageSource b = (new ODamageSource("inFire")).j();
   public static ODamageSource c = (new ODamageSource("onFire")).h().j();
   public static ODamageSource d = (new ODamageSource("lava")).j();
   public static ODamageSource e = (new ODamageSource("inWall")).h();
   public static ODamageSource f = (new ODamageSource("drown")).h();
   public static ODamageSource g = (new ODamageSource("starve")).h();
   public static ODamageSource h = new ODamageSource("cactus");
   public static ODamageSource i = (new ODamageSource("fall")).h();
   public static ODamageSource j = (new ODamageSource("outOfWorld")).h().i();
   public static ODamageSource k = (new ODamageSource("generic")).h();
   public static ODamageSource l = new ODamageSource("explosion");
   public static ODamageSource m = (new ODamageSource("magic")).h();
   private boolean a = false;
   private boolean o = false;
   private float p = 0.3F;
   private boolean q;
   private boolean r;
   public String n;
   //CanaryMod start
   DamageSource _handler;
   //CanaryMod end


   public static ODamageSource a(OEntityLiving var0) {
      return new OEntityDamageSource("mob", var0);
   }

   public static ODamageSource b(OEntityPlayer var0) {
      return new OEntityDamageSource("player", var0);
   }

   public static ODamageSource a(OEntityArrow var0, OEntity var1) {
      return (new OEntityDamageSourceIndirect("arrow", var0, var1)).d();
   }

   public static ODamageSource a(OEntityFireball var0, OEntity var1) {
      return (new OEntityDamageSourceIndirect("fireball", var0, var1)).j().d();
   }

   public static ODamageSource a(OEntity var0, OEntity var1) {
      return (new OEntityDamageSourceIndirect("thrown", var0, var1)).d();
   }

   public static ODamageSource b(OEntity var0, OEntity var1) {
      return (new OEntityDamageSourceIndirect("indirectMagic", var0, var1)).h();
   }

   public boolean c() {
      return this.r;
   }

   public ODamageSource d() {
      this.r = true;
      return this;
   }

   public boolean e() {
      return this.a;
   }

   public float f() {
      return this.p;
   }

   public boolean g() {
      return this.o;
   }

   protected ODamageSource(String var1) {
      super();
      this.n = var1;
      //CanaryMod start
      _handler = new DamageSource(this);
      //CanaryMod end
   }
   
   //CanaryMod start
   /**
    * Get Canary handler
    * @return
    */
   public DamageSource getCanaryHandler() {
       return _handler;
   }
   //CanaryMod end

   public OEntity b() {
      return this.a();
   }

   public OEntity a() {
      return null;
   }

   protected ODamageSource h() {
      this.a = true;
      this.p = 0.0F;
      return this;
   }

   protected ODamageSource i() {
      this.o = true;
      return this;
   }

   protected ODamageSource j() {
      this.q = true;
      return this;
   }

   public String a(OEntityPlayer var1) {
      return OStatCollector.a("death." + this.n, new Object[]{var1.v});
   }

   public boolean k() {
      return this.q;
   }

   public String l() {
      return this.n;
   }

}
