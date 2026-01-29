package aaDataAccess.aaDTOs;

public class aaUsuarioDTO {
    private Integer aaIdUsuario;
    private String  aaCedula;
    private String  aaUsuario;
    private String  aaClave;

    public aaUsuarioDTO() {}

    public aaUsuarioDTO(String aaCedula, String aaUsuario, String aaClave) {
        this.aaCedula = aaCedula;
        this.aaUsuario = aaUsuario;
        this.aaClave = aaClave;
    }

    public Integer getAaIdUsuario() {
        return aaIdUsuario;
    }
    
    public void setAaIdUsuario(Integer aaIdUsuario) {
        this.aaIdUsuario = aaIdUsuario;
    }
    
    public String getAaCedula() {
        return aaCedula;
    }

    public void setAaCedula(String aaCedula) {
        this.aaCedula = aaCedula;
    }
    
    public String getAaUsuario() {
        return aaUsuario;
    }
    
    public void setAaUsuario(String aaUsuario) {
        this.aaUsuario = aaUsuario;
    }
    
    public String getAaClave() {
        return aaClave;
    }
    
    public void setAaClave(String aaClave) {
        this.aaClave = aaClave;
    }
    
    @Override
    public String toString() {
        return getClass().getName()
            + "\n aaIdUsuario   : " + aaIdUsuario
            + "\n aaCedula      : " + aaCedula
            + "\n aaUsuario     : " + aaUsuario
            + "\n aaClave       : " + aaClave
            + "\n ----------------------------";
    }
}
