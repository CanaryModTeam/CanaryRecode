package net.minecraft.server;

import java.util.Arrays;

import net.canarymod.api.inventory.Container;
import net.minecraft.server.OBlock;
import net.minecraft.server.OEntityPlayer;
import net.minecraft.server.OIInventory;
import net.minecraft.server.OItemStack;
import net.minecraft.server.ONBTTagCompound;
import net.minecraft.server.ONBTTagList;
import net.minecraft.server.OTileEntity;

public class OTileEntityChest extends OTileEntity implements OIInventory, Container<OItemStack> {

    private OItemStack[] i = new OItemStack[36];
    public boolean a = false;
    public OTileEntityChest b;
    public OTileEntityChest c;
    public OTileEntityChest d;
    public OTileEntityChest e;
    public float f;
    public float g;
    public int h;
    private int j;
    private String name = "container.chest"; //CanaryMod

    public OTileEntityChest() {
        super();
    }

    @Override
    public int c() {
        return 27;
    }

    @Override
    public OItemStack g_(int var1) {
        return this.i[var1];
    }

    @Override
    public OItemStack a(int var1, int var2) {
        if (this.i[var1] != null) {
            OItemStack var3;
            if (this.i[var1].a <= var2) {
                var3 = this.i[var1];
                this.i[var1] = null;
                this.G_();
                return var3;
            } else {
                var3 = this.i[var1].a(var2);
                if (this.i[var1].a == 0) {
                    this.i[var1] = null;
                }

                this.G_();
                return var3;
            }
        } else {
            return null;
        }
    }

    @Override
    public OItemStack b(int var1) {
        if (this.i[var1] != null) {
            OItemStack var2 = this.i[var1];
            this.i[var1] = null;
            return var2;
        } else {
            return null;
        }
    }

    @Override
    public void a(int var1, OItemStack var2) {
        this.i[var1] = var2;
        if (var2 != null && var2.a > this.a()) {
            var2.a = this.a();
        }

        this.G_();
    }

    @Override
    public String e() {
        return name;
    }

    @Override
    public void a(ONBTTagCompound var1) {
        super.a(var1);
        ONBTTagList var2 = var1.n("Items");
        this.i = new OItemStack[this.c()];

        for (int var3 = 0; var3 < var2.d(); ++var3) {
            ONBTTagCompound var4 = (ONBTTagCompound) var2.a(var3);
            int var5 = var4.d("Slot") & 255;
            if (var5 >= 0 && var5 < this.i.length) {
                this.i[var5] = OItemStack.a(var4);
            }
        }

    }

    @Override
    public void b(ONBTTagCompound var1) {
        super.b(var1);
        ONBTTagList var2 = new ONBTTagList();

        for (int var3 = 0; var3 < this.i.length; ++var3) {
            if (this.i[var3] != null) {
                ONBTTagCompound var4 = new ONBTTagCompound();
                var4.a("Slot", (byte) var3);
                this.i[var3].b(var4);
                var2.a(var4);
            }
        }

        var1.a("Items", var2);
    }

    @Override
    public int a() {
        return 64;
    }

    @Override
    public boolean a(OEntityPlayer var1) {
        return this.k.b(this.l, this.m, this.n) != this ? false : var1.e(this.l + 0.5D, this.m + 0.5D, this.n + 0.5D) <= 64.0D;
    }

    @Override
    public void h() {
        super.h();
        this.a = false;
    }

    public void i() {
        if (!this.a) {
            this.a = true;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            if (this.k.a(this.l - 1, this.m, this.n) == OBlock.au.bO) {
                this.d = (OTileEntityChest) this.k.b(this.l - 1, this.m, this.n);
            }

            if (this.k.a(this.l + 1, this.m, this.n) == OBlock.au.bO) {
                this.c = (OTileEntityChest) this.k.b(this.l + 1, this.m, this.n);
            }

            if (this.k.a(this.l, this.m, this.n - 1) == OBlock.au.bO) {
                this.b = (OTileEntityChest) this.k.b(this.l, this.m, this.n - 1);
            }

            if (this.k.a(this.l, this.m, this.n + 1) == OBlock.au.bO) {
                this.e = (OTileEntityChest) this.k.b(this.l, this.m, this.n + 1);
            }

            if (this.b != null) {
                this.b.h();
            }

            if (this.e != null) {
                this.e.h();
            }

            if (this.c != null) {
                this.c.h();
            }

            if (this.d != null) {
                this.d.h();
            }

        }
    }

    @Override
    public void q_() {
        super.q_();
        this.i();
        if (++this.j % 20 * 4 == 0) {
            this.k.e(this.l, this.m, this.n, 1, this.h);
        }

        this.g = this.f;
        float var1 = 0.1F;
        double var4;
        if (this.h > 0 && this.f == 0.0F && this.b == null && this.d == null) {
            double var2 = this.l + 0.5D;
            var4 = this.n + 0.5D;
            if (this.e != null) {
                var4 += 0.5D;
            }

            if (this.c != null) {
                var2 += 0.5D;
            }

            this.k.a(var2, this.m + 0.5D, var4, "random.chestopen", 0.5F, this.k.r.nextFloat() * 0.1F + 0.9F);
        }

        if (this.h == 0 && this.f > 0.0F || this.h > 0 && this.f < 1.0F) {
            float var6 = this.f;
            if (this.h > 0) {
                this.f += var1;
            } else {
                this.f -= var1;
            }

            if (this.f > 1.0F) {
                this.f = 1.0F;
            }

            float var7 = 0.5F;
            if (this.f < var7 && var6 >= var7 && this.b == null && this.d == null) {
                var4 = this.l + 0.5D;
                double var8 = this.n + 0.5D;
                if (this.e != null) {
                    var8 += 0.5D;
                }

                if (this.c != null) {
                    var4 += 0.5D;
                }

                this.k.a(var4, this.m + 0.5D, var8, "random.chestclosed", 0.5F, this.k.r.nextFloat() * 0.1F + 0.9F);
            }

            if (this.f < 0.0F) {
                this.f = 0.0F;
            }
        }

    }

    @Override
    public void b(int var1, int var2) {
        if (var1 == 1) {
            this.h = var2;
        }

    }

    @Override
    public void f() {
        ++this.h;
        this.k.e(this.l, this.m, this.n, 1, this.h);
    }

    @Override
    public void g() {
        --this.h;
        this.k.e(this.l, this.m, this.n, 1, this.h);
    }

    @Override
    public void j() {
        this.h();
        this.i();
        super.j();
    }

    //CanaryMod Start
    @Override
    public OItemStack[] getContents() {
        return Arrays.copyOf(i, getSize());
    }

    @Override
    public void setContents(OItemStack[] values) {
        i = Arrays.copyOf(values, getSize());
    }

    @Override
    public OItemStack getSlot(int index) {
        return g_(index);
    }

    @Override
    public void setSlot(int index, OItemStack value) {
        a(index, value);
    }

    @Override
    public int getSize() {
        return c();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        name = value;
    }

    @Override
    public void update() {
        G_();
    }
    //CanaryMod end
}
