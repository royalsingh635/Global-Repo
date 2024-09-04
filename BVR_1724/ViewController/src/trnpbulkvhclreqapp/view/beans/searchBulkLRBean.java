package trnpbulkvhclreqapp.view.beans;
                   
import adf.utils.bean.ADFBeanUtils;

import javax.faces.event.ActionEvent;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.context.RequestContext;

public class searchBulkLRBean {
    public searchBulkLRBean() {
    }

    public void searchBulkLRAL(ActionEvent actionEvent) {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("searchBulkLR");
        binding.execute();
    }

    public void resetBulkLRAL(ActionEvent actionEvent) {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("resetBulkLR");
        binding.execute();
    }

    public String docViewAction() {
        String s = (String) RequestContext.getCurrentInstance().getCurrentComponent().getAttributes().get("LrDocId");
                System.out.println("curent doc" + s);
               if (s != null) {
                   RequestContext.getCurrentInstance().getPageFlowScope().put("DocId", s);
                   return "V";
               }
               return null;
    }
}
