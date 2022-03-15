package com.example.bai2_thtuan2_3;

public class Product extends  Goods{
    private Catalog Dmuc;

    public Catalog getDmuc() {
        return Dmuc;
    }

    public void setDmuc(Catalog dmuc) {
        Dmuc = dmuc;
    }

    public Product(String id, String name, Catalog dmuc) {
        super(id, name);
        Dmuc = dmuc;
    }
    public Product(String id, String name) {
        super(id, name);
    }

    public Product() {
      super();
    }
}
