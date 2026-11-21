package assets.rivalrebels.client.model;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import net.minecraft.client.renderer.GLAllocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class ModelFast3D {
   private int textureID = 0;
   private int vboiId = 0;
   private int vboId = 0;
   private int indicesCount = 0;
   private int pId = 0;

   public ModelFast3D() {
      ByteBuffer byteBuffer = GLAllocation.func_74524_c(120);
      FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(1.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(1.0F);
      floatBuffer.put(0.0F);
      floatBuffer.put(0.0F);
      ((Buffer)floatBuffer).flip();
      byte[] indices = new byte[]{0, 1, 2};
      this.indicesCount = indices.length;
      ByteBuffer indicesBuffer = GLAllocation.func_74524_c(this.indicesCount);
      indicesBuffer.put(indices);
      ((Buffer)indicesBuffer).flip();
      GL15.glBindBuffer(34962, this.vboId);
      GL15.glBufferData(34962, floatBuffer, 35044);
      GL20.glVertexAttribPointer(0, 3, 5126, false, 8, 0L);
      GL20.glVertexAttribPointer(2, 2, 5126, false, 8, 6L);
      GL15.glBindBuffer(34962, 0);
      GL30.glBindVertexArray(0);
      this.vboiId = GL15.glGenBuffers();
      GL15.glBindBuffer(34963, this.vboiId);
      GL15.glBufferData(34963, indicesBuffer, 35044);
      GL15.glBindBuffer(34963, 0);
      int vsId = GL20.glCreateShader(35633);
      int fsId = GL20.glCreateShader(35632);
      GL20.glShaderSource(vsId, "void main() { gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex; }");
      GL20.glShaderSource(fsId, "void main() { gl_FragColor = vec4(0.4,0.4,0.8,1.0); }");
      GL20.glCompileShader(vsId);
      GL20.glCompileShader(fsId);
      this.pId = GL20.glCreateProgram();
      GL20.glAttachShader(this.pId, vsId);
      GL20.glAttachShader(this.pId, fsId);
      GL20.glBindAttribLocation(this.pId, 0, "in_Position");
      GL20.glBindAttribLocation(this.pId, 1, "in_Normal");
      GL20.glBindAttribLocation(this.pId, 2, "in_UV");
      GL20.glLinkProgram(this.pId);
      GL20.glValidateProgram(this.pId);
   }

   public void render() {
      GL20.glUseProgram(this.pId);
      GL15.glBindBuffer(34963, this.vboId);
      GL20.glEnableVertexAttribArray(0);
      GL20.glEnableVertexAttribArray(1);
      GL20.glEnableVertexAttribArray(2);
      GL15.glBindBuffer(34963, this.vboiId);
      GL11.glDrawElements(4, this.indicesCount, 5121, 0L);
      GL15.glBindBuffer(34963, 0);
      GL20.glDisableVertexAttribArray(0);
      GL20.glDisableVertexAttribArray(1);
      GL30.glBindVertexArray(0);
      GL20.glUseProgram(0);
   }
}
