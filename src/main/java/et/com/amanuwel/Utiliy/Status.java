package et.com.amanuwel.Utiliy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "Status")
@XmlAccessorType(XmlAccessType.FIELD)
public class Status implements Serializable {
    public boolean status;
    public String message;
    private List<ErrorMessage> errorMessages;

    public Status() {
    }

    public Status(boolean status) {
        this.status = status;
    }

    public Status(boolean status, String message, List<ErrorMessage> errorMessages) {
        this.status = status;
        this.message = message;
        this.errorMessages = errorMessages;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", errorMessages=" + errorMessages +
                '}';
    }
}
