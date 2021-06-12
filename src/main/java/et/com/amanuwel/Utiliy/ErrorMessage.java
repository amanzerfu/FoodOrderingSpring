package et.com.amanuwel.Utiliy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "ErrorMessage")
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorMessage implements Serializable {
    public String code;
    public String title;
    public String message;

    public ErrorMessage() {
    }
    public ErrorMessage(String code, String title, String message) {
        this.code = code;
        this.title = title;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
