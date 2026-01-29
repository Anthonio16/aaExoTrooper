package aaDataAccess.aaDTOs;

public class aaMunicionDTO {
    private  Integer   aaIdMunicion;
    private  String    aaNombre;
    private  String    aaTipo;

    public aaMunicionDTO() {
    }

    public aaMunicionDTO(Integer aaIdMunicion, String aaNombre, String aaTipo) {
        this.aaIdMunicion = aaIdMunicion;
        this.aaNombre = aaNombre;
        this.aaTipo = aaTipo;
    }

    public Integer getAaIdMunicion() {
        return aaIdMunicion;
    }
    public void setAaIdMunicion(Integer aaIdMunicion) {
        this.aaIdMunicion = aaIdMunicion;
    }
    public String getAaNombre() {
        return aaNombre;
    }
    public void setAaNombre(String aaNombre) {
        this.aaNombre = aaNombre;
    }
    public String getAaTipo() {
        return aaTipo;
    }
    public void setAaTipo(String aaTipo) {
        this.aaTipo = aaTipo;
    }       

    @Override
    public String toString() {
        return getClass().getName()
            + "\n aaIdMunicion  : " + aaIdMunicion
            + "\n aaNombre      : " + aaNombre
            + "\n aaTipo        : " + aaTipo
            + "\n ----------------------------";
    }

}
