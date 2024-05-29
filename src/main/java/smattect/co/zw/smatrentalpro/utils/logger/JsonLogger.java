package smattect.co.zw.smatrentalpro.utils.logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;

@Slf4j
public class JsonLogger {
    private JsonLogger() {
    }
    public static void logAsPrettyJson(Object object) {
        if (object == null) {
            return;
        }
        try {
            String data = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
            log.info(data);
        } catch (JsonProcessingException ex) {
        }
    }
    public static void logAsPrettyJsonDebug(Object object) {
        if (object == null) {
            return;
        }

        try {
            String data = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
            log.debug(data);
        } catch (JsonProcessingException ex) {
        }
    }

    public static String printAsPrettyJson(Object object) {
        if (object == null) {
            return null;
        }

        try {
            String data = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
            return data;
        } catch (JsonProcessingException ex) {
        }
        return null;
    }

    public static void logAsPrettyJson(Object object,@NotNull LogLevel logLevel) {
        if (object == null) {
            return;
        }
        try {
            String data = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
            switch (logLevel) {
                case TRACE:
                    log.trace(data);
                    break;
                case DEBUG:
                    log.debug(data);
                    break;
                case WARN:
                    log.warn(data);
                    break;
                case ERROR:
                    log.error(data);
                    break;
                case INFO:
                    log.info(data);
                    break;
                default:
                    break;

            }

        } catch (JsonProcessingException ex) {
        }

    }
}
