package aaDataAccess.aaDTOs;

public class aaExobotDTO {
   private Integer aaIdExobot  ;
   private String aaTipoExobot;
   private String aaTipoArma  ;
   private String aaEntreno   ;
   private String aaNoAccion  ;

   public aaExobotDTO() {
}
   public aaExobotDTO(Integer aaIdExobot, String aaTipoExobot, String aaTipoArma, String aaEntreno, String aaNoAccion) {
    this.aaIdExobot = aaIdExobot;
    this.aaTipoExobot = aaTipoExobot;
    this.aaTipoArma = aaTipoArma;
    this.aaEntreno = aaEntreno;
    this.aaNoAccion = aaNoAccion;
}
   public Integer getAaIdExobot() {
    return aaIdExobot;
   }
   public void setAaIdExobot(Integer aaIdExobot) {
    this.aaIdExobot = aaIdExobot;
   }
   public String getAaTipoExobot() {
    return aaTipoExobot;
   }
   public void setAaTipoExobot(String aaTipoExobot) {
    this.aaTipoExobot = aaTipoExobot;
   }
   public String getAaTipoArma() {
    return aaTipoArma;
   }
   public void setAaTipoArma(String aaTipoArma) {
    this.aaTipoArma = aaTipoArma;
   }
   public String getAaEntreno() {
    return aaEntreno;
   }
   public void setAaEntreno(String aaEntreno) {
    this.aaEntreno = aaEntreno;
   }
   public String getAaNoAccion() {
    return aaNoAccion;
   }
   public void setAaNoAccion(String aaNoAccion) {
    this.aaNoAccion = aaNoAccion;
   }


    @Override
    public String toString() {
        return getClass().getName()
            + "\n aaIdExobot        : " + aaIdExobot
            + "\n aaTipoExobot      : " + aaTipoExobot
            + "\n aaTipoArma        : " + aaTipoArma
            + "\n aaEntreno         : " + aaEntreno
            + "\n aaNoAccion        : " + aaNoAccion
            + "\n ----------------------------";
    }
}
