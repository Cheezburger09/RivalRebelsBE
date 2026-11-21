package assets.rivalrebels.client.renderhelper;

public class TextureFace {
   TextureVertice v1;
   TextureVertice v2;
   TextureVertice v3;
   TextureVertice v4;

   public TextureFace(TextureVertice V1, TextureVertice V2, TextureVertice V3, TextureVertice V4) {
      this.v1 = V1;
      this.v2 = V2;
      this.v3 = V3;
      this.v4 = V4;
   }
}
