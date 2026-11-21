package assets.rivalrebels.common.round;

public enum RivalRebelsTeam {
   NONE(0),
   OMEGA(1),
   SIGMA(2);

   public int id = 0;

   RivalRebelsTeam(int i) {
      this.id = i;
   }

   public static RivalRebelsTeam getForID(int i) {
      switch (i) {
         case 1:
            return OMEGA;
         case 2:
            return SIGMA;
         default:
            return NONE;
      }
   }
}
