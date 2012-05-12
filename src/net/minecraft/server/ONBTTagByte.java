package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import net.minecraft.server.ONBTBase;

public class ONBTTagByte extends ONBTBase {

   public byte a;


   public ONBTTagByte(String var1) {
      super(var1);
   }

   public ONBTTagByte(String var1, byte var2) {
      super(var1);
      this.a = var2;
   }

   void a(DataOutput var1) throws IOException {
       var1.writeByte(this.a);
   }

   void a(DataInput var1) throws IOException {
      this.a = var1.readByte();
   }

   public byte a() {
      return (byte)1;
   }

   public String toString() {
      return "" + this.a;
   }

   public ONBTBase b() {
      return new ONBTTagByte(this.c(), this.a);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         ONBTTagByte var2 = (ONBTTagByte)var1;
         return this.a == var2.a;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.a;
   }
}
