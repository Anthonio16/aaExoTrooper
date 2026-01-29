package aaDataAccess.aaDAOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import aaInfrastructure.aaAppConfig;
import aaInfrastructure.aaAppException;

public class aaArchivoDAO {
    
    // Para el requisito 50: Buscar munición
    public String aaLeerMunicion(String aaTipoBuscado) throws aaAppException {
        try (BufferedReader aaBr = new BufferedReader(new FileReader("storage/DataFiles/ExoMunision.txt"))) {
            String aaLinea;
            while ((aaLinea = aaBr.readLine()) != null) {
                if (aaLinea.contains(aaTipoBuscado)) {
                    return aaLinea; // Retorna la línea con la munición/energía
                }
            }
        } catch (Exception e) {
            throw new aaAppException("Error al leer ExoMunision.txt", e, getClass(), "aaLeerMunicion");
        }
        return "Munición no encontrada";
    }

    // Para el requisito 38: Guardar log en TXT
    public void aaGuardarTracer(String aaLog) throws aaAppException {
        try (PrintWriter aaPw = new PrintWriter(new FileWriter("storage/DataFiles/ExoTracer.txt", true))) {
            aaPw.println(aaLog);
        } catch (Exception e) {
            throw new aaAppException("Error al escribir en ExoTracer.txt", e, getClass(), "aaGuardarTracer");
        }
    }
}
