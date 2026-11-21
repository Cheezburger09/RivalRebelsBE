package assets.rivalrebels.client.renderhelper;

public class Triangle {
   public Vertice v1;
   public Vertice v2;
   public Vertice v3;
   public TextureVertice t1;
   public TextureVertice t2;
   public TextureVertice t3;

   public Triangle(Vertice V1, Vertice V2, Vertice V3, TextureVertice T1, TextureVertice T2, TextureVertice T3) {
      this.v1 = V1;
      this.v2 = V2;
      this.v3 = V3;
      this.t1 = T1;
      this.t2 = T2;
      this.t3 = T3;
   }
}
