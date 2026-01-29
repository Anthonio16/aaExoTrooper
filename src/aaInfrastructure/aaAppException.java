package aaInfrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import aaInfrastructure.Tools.CMDColor;


public class aaAppException extends Exception {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public aaAppException(String showMsg) {
        super((showMsg == null || showMsg.isBlank()) ? aaAppConfig.MSG_DEFAULT_ERROR : showMsg);
        saveLogFile(null, null, null);
    }

    public aaAppException(String showMsg, Exception e, Class<?> clase, String metodo) {
        // ✅ Guardamos causa real (aunque sea null)
        super((showMsg == null || showMsg.isBlank()) ? aaAppConfig.MSG_DEFAULT_ERROR : showMsg, e);

        // ✅ Si e es null, NO hacemos e.getMessage()
        String causeMsg = (e == null) ? null : e.getMessage();
        saveLogFile(causeMsg, clase, metodo);
    }

    private void saveLogFile(String logMsg, Class<?> clase, String metodo) {
        String timestamp  = LocalDateTime.now().format(FORMATTER);
        String className  = (clase  == null) ? aaAppConfig.MSG_DEFAULT_CLASS  : clase.getSimpleName();
        String methodName = (metodo == null) ? aaAppConfig.MSG_DEFAULT_METHOD : metodo;

        // ✅ Si no hay causa (e null), mostramos mensaje por defecto
        logMsg = (logMsg == null || logMsg.isBlank()) ? aaAppConfig.MSG_DEFAULT_ERROR : logMsg;

        logMsg = String.format(
            "╭─💀─ SHOW ❱❱ %s \n╰──── LOG  ❱❱ %s | %s.%s | %s",
            getMessage(), timestamp, className, methodName, logMsg
        );

        try (PrintWriter writer = new PrintWriter(new FileWriter(aaAppConfig.getLOGFILE(), true))) {
            System.err.println(CMDColor.BLUE + logMsg);
            writer.println(logMsg);
        } catch (Exception e) {
            System.err.println(CMDColor.RED + "[aaAppException.saveLogFile] ❱ " + e.getMessage());
        } finally {
            System.out.println(CMDColor.RESET);
        }
    }
}
