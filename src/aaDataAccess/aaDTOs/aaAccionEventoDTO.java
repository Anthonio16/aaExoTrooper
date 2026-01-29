package aaDataAccess.aaDTOs;

public class aaAccionEventoDTO {
    private Integer aaIdEvento   ;
    private String  aaFecha      ;
    private String  aaDescripcion;
    private String  aaEstado     ;
    
    public aaAccionEventoDTO() {
    }

    public aaAccionEventoDTO(String aaFecha, String aaDescripcion, String aaEstado) {
        this.aaFecha = aaFecha;
        this.aaDescripcion = aaDescripcion;
        this.aaEstado = aaEstado;
    }

    public aaAccionEventoDTO(Integer aaIdEvento, String aaFecha, String aaDescripcion, String aaEstado) {
        this.aaIdEvento = aaIdEvento;
        this.aaFecha = aaFecha;
        this.aaDescripcion = aaDescripcion;
        this.aaEstado = aaEstado;
    }
    
    public Integer getAaIdEvento() {
        return aaIdEvento;
    }
    public void setAaIdEvento(Integer aaIdEvento) {
        this.aaIdEvento = aaIdEvento;
    }
    public String getAaFecha() {
        return aaFecha;
    }
    public void setAaFecha(String aaFecha) {
        this.aaFecha = aaFecha;
    }
    public String getAaDescripcion() {
        return aaDescripcion;
    }
    public void setAaDescripcion(String aaDescripcion) {
        this.aaDescripcion = aaDescripcion;
    }
    public String getAaEstado() {
        return aaEstado;
    }
    public void setAaEstado(String aaEstado) {
        this.aaEstado = aaEstado;
    }    

    @Override
    public String toString() {
        return getClass().getName()
            + "\n aaIdEvento        : " + aaIdEvento
            + "\n aaFecha           : " + aaFecha
            + "\n aaDescripcion     : " + aaDescripcion
            + "\n aaEstado          : " + aaEstado
            + "\n ----------------------------";
    }
}
