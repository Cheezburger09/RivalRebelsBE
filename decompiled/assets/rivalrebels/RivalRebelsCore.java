package assets.rivalrebels;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.Name;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.SortingIndex;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import java.util.Map;

@Name("Rival Rebels")
@MCVersion("1.7.10")
@TransformerExclusions("assets.rivalrebels.")
@SortingIndex(1001)
public class RivalRebelsCore implements IFMLLoadingPlugin {
   public String[] getASMTransformerClass() {
      return new String[]{ASMTransformer.class.getName()};
   }

   public String getModContainerClass() {
      return null;
   }

   public String getSetupClass() {
      return null;
   }

   public void injectData(Map<String, Object> data) {
   }

   public String getAccessTransformerClass() {
      return null;
   }
}
