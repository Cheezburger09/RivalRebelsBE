package assets.rivalrebels.common.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import org.apache.commons.io.IOUtils;

public class FileRW {
   public static String read(File file) {
      StringBuilder text = new StringBuilder();
      BufferedReader reader = null;

      try {
         reader = new BufferedReader(new FileReader(file));
         String line = null;

         while ((line = reader.readLine()) != null) {
            text.append(line);
            text.append("\n");
         }
      } catch (Exception var12) {
      } finally {
         try {
            if (reader != null) {
               reader.close();
            }
         } catch (IOException var11) {
         }
      }

      return text.toString();
   }

   public static byte[] readbytes(File file) {
      FileInputStream fis = null;
      byte[] data = new byte[0];

      try {
         fis = new FileInputStream(file);
         data = IOUtils.toByteArray(fis);
      } catch (Exception var12) {
      } finally {
         try {
            if (fis != null) {
               fis.close();
            }
         } catch (IOException var11) {
         }
      }

      return data;
   }

   public static void write(File file, String text) {
      Writer output = null;

      try {
         output = new BufferedWriter(new FileWriter(file));
         output.write(text);
      } catch (IOException var12) {
      } finally {
         try {
            if (output != null) {
               output.close();
            }
         } catch (IOException var11) {
         }
      }
   }

   public static void writebytes(File file, byte[] data) {
      FileOutputStream fos = null;

      try {
         file.delete();
         file.createNewFile();
         fos = new FileOutputStream(file);
         fos.write(data);
      } catch (Exception var12) {
      } finally {
         try {
            if (fos != null) {
               fos.close();
            }
         } catch (IOException var11) {
         }
      }
   }

   public static boolean goToURL(String string) {
      try {
         Class oclass = Class.forName("java.awt.Desktop");
         Object object = oclass.getMethod("getDesktop").invoke(null);
         oclass.getMethod("browse", URI.class).invoke(object, new URI(string));
         return true;
      } catch (Exception e) {
         e.printStackTrace();
         return false;
      }
   }

   public static byte[] getBytesString(String str) {
      char[] buffer = str.toCharArray();
      byte[] bytes = new byte[buffer.length];

      for (int i = 0; i < bytes.length; i++) {
         bytes[i] = (byte)buffer[i];
      }

      return bytes;
   }

   public static String getStringBytes(byte[] bytes) {
      char[] buffer = new char[bytes.length];

      for (int i = 0; i < bytes.length; i++) {
         buffer[i] = (char)bytes[i];
         if (buffer[i] == 'ﾧ') {
            buffer[i] = 167;
         }
      }

      return new String(buffer);
   }
}
