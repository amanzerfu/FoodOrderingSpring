 package et.com.amanuwel.Utiliy;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusInit {
    public Status singleErrorInit(String message, String code, String title, String messageDesc){
        Status status = new Status(false, message, null);
        List<ErrorMessage> errorMessageList = new ArrayList<ErrorMessage>();
        ErrorMessage errorMessage = new ErrorMessage(code,title,message);
        errorMessageList.add(errorMessage);
        status.setErrorMessages(errorMessageList);
        return status;
    }
    public Status singleErrorInit(String title, String messageDesc){
        Status status = new Status(false, title, null);
        List<ErrorMessage> errorMessageList = new ArrayList<ErrorMessage>();
        ErrorMessage errorMessage = new ErrorMessage("",title,messageDesc);
        errorMessageList.add(errorMessage);
        status.setErrorMessages(errorMessageList);
        return status;
    }
    public Status unknownErrorInit(){
        Status status = new Status(false, "Error Occured", null);
        List<ErrorMessage> errorMessageList = new ArrayList<ErrorMessage>();
        ErrorMessage errorMessage = new ErrorMessage("","Error Occured","Unknown error has occured");
        errorMessageList.add(errorMessage);
        status.setErrorMessages(errorMessageList);
        return status;
    }
    public Status webServiceErrorInit(){
        Status status = new Status(false, "Unable to Connect to Webservice", null);
        List<ErrorMessage> errorMessageList = new ArrayList<ErrorMessage>();
        ErrorMessage errorMessage = new ErrorMessage("","Unable to Connect to Webservice","Unable to Connect to Webservice");
        errorMessageList.add(errorMessage);
        status.setErrorMessages(errorMessageList);
        return status;
    }
    public Status emptyErrorInit(){
        Status status = new Status(false, "Search result not found", null);
        List<ErrorMessage> errorMessageList = new ArrayList<ErrorMessage>();
        ErrorMessage errorMessage = new ErrorMessage("","Search result not found","Search result not found");
        errorMessageList.add(errorMessage);
        status.setErrorMessages(errorMessageList);
        return status;
    }
    public Status successful(){
        return new Status(true, "Successful", null);
    }
    public Status successfullyAdded(){
        return new Status(true, "Successfully Added", null);
    }
    public Status successfullyDeleted(){
        return new Status(true, "Successfully Deleted", null);
    }
    public Status successfullyRemoved(){
        return new Status(true, "Successfully Removed", null);
    }
    public Status successfullyUnsubscribed(){
        return new Status(true, "Successfully Unsubscribed", null);
    }
    public Status alreadyRemoved(){
        return new Status(false, "Already Removed", null);
    }
    public Status successfullyUpdated(){
        return new Status(true, "Successfully Updated", null);
    }
    public Status denied(){
        return new Status(true, "Request Denied", null);
    }
    public Status notFound(Long id){
        return singleErrorInit("Not Found","not item found the record by this id:" + id);
    }

}
