package trnpbulkvhclreqapp.view.beans;

import adf.utils.bean.ADFBeanUtils;

import adf.utils.ebiz.EbizParams;
import adf.utils.ebiz.EbizParamsAPPUtils;

import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.domain.Number;

import adf.utils.model.ADFModelUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.faces.event.ValueChangeEvent;

import javax.faces.validator.ValidatorException;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;


import trnpbulkvhclreqapp.model.classes.BulkSoList;
import trnpbulkvhclreqapp.model.classes.BulkTrfList;

public class TrnpBulkVhclReqBean {
    private RichSelectOneChoice lrStatusBind;
    private RichSelectOneChoice docTypeBind;
    private RichSelectBooleanCheckbox checkBoxSalesOrder;

    public TrnpBulkVhclReqBean() {
    }
    private ArrayList<BulkSoList> SoBulkList = new ArrayList<BulkSoList>();
  private ArrayList<BulkTrfList> TrfBulkList = new ArrayList<BulkTrfList>();

  public void setTrfBulkList(ArrayList<BulkTrfList> TrfBulkList)
  {
    this.TrfBulkList = TrfBulkList;
  }

  public ArrayList<BulkTrfList> getTrfBulkList()
  {
    this.TrfBulkList = null;
    OperationBinding op = ADFBeanUtils.findOperation("getTrfList");
    op.execute();
    if (op.getResult() != null && TrfBulkList == null) {

        this.TrfBulkList = (ArrayList<BulkTrfList>) op.getResult();
    }
    return TrfBulkList;
  }

  private String mode = (String) ADFModelUtils.resolvEl("#{pageFlowScope.Mode}");
    private Boolean Freeze = null;
    public Boolean featureForShippingAddress = null;
    private String wfId;
    public Integer catgId=0;

    public void setCatgId(Integer catgId) {
        this.catgId = catgId;
    }

    public Integer getCatgId() {
        
        if(catgId==0){
        OperationBinding op = ADFBeanUtils.findOperation("catgIdFrmEoId");
        op.execute();
        Integer i = (Integer)op.getResult();
        setCatgId(i);
        }
//        System.out.println("bean catgId"+catgId);
        return catgId;
    }


    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getWfId() {
        return wfId;
    }

    public void setFeatureForShippingAddress(Boolean featureForShippingAddress) {
        this.featureForShippingAddress = featureForShippingAddress;
    }

    public Boolean getFeatureForShippingAddress() {
        if (featureForShippingAddress == null) {
            OperationBinding op = ADFBeanUtils.findOperation("showShipAddFeature");
            op.execute();
            String result = op.getResult() == null ? "N" : (String) op.getResult();
            if (result.equals("Y")) {
                setFeatureForShippingAddress(true);
            } else {
                setFeatureForShippingAddress(false);
            }
        }
        return featureForShippingAddress;
    }

    public void setFreeze(Boolean Freeze) {
        this.Freeze = Freeze;
    }

    public Boolean getFreeze() {
        //        Boolean freeze = false;
        //        OperationBinding op = ADFBeanUtils.findOperation("getFreezeVal");
        //        op.execute();
        //        if (op.getResult() != null) {
        //            String frzval = op.getResult().toString();
        //            freeze = "Y".equalsIgnoreCase(frzval) ? true : false;
        //            Freeze = freeze;
        //        }
        return Freeze;

    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
  /**
  * Added by : Manjeet Singh
  * Modified on : 06-05-2024
  * Remarks : This Variable is designed to verify the quantity loaded during loading for displaying the unscanned barcode report link on the BVR page when transferring to Mombasa. '.
  * TMS ID : 131416
  **/
public String RenderBcLink;

  public void setRenderBcLink(String RenderBcLink)
  {
    this.RenderBcLink = RenderBcLink;
  }

  public String getRenderBcLink()
  {
    OperationBinding op = ADFBeanUtils.findOperation("getLoadingStatus");
    op.execute();
    System.err.println("____getLoadingStatus_____"+op.getResult());
    if (op.getResult() != null && RenderBcLink == null) {

       setRenderBcLink((String) op.getResult());
    }
    return RenderBcLink;
  }

  public void setSoBulkList(ArrayList<BulkSoList> SoBulkList) {
        this.SoBulkList = SoBulkList;
    }

    public ArrayList<BulkSoList> getSoBulkList() {
        //        SoBulkList.clear();
        this.SoBulkList = null;
        OperationBinding op = ADFBeanUtils.findOperation("getSoList");
        op.execute();
        if (op.getResult() != null && SoBulkList == null) {

            this.SoBulkList = (ArrayList<BulkSoList>) op.getResult();
        }
        //   System.out.println("value of check list are:"+SoBulkList);
        return SoBulkList;
    }
    List<Object> DataList = new ArrayList();

    public void setDataList(List<Object> DataList) {
        this.DataList = DataList;
    }

    public List<Object> getDataList() {
        return DataList;
    }

    public void addBulkVhclReqHdrAL(ActionEvent actionEvent) {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("createInsertSoBulkHdr");
        binding.execute();
        mode = "A";
        SoBulkList.clear();
    }

    public String validateHeader() {
        String ret = "Y";
        OperationBinding binding = ADFBeanUtils.getOperationBinding("validateHdrBulkVr");
        binding.execute();
        Integer i = (Integer) binding.getResult();
        if (i.compareTo(1) == 0) {
            ADFModelUtils.showFacesMessage(ADFModelUtils.resolvRsrc("MSG.17733"),
                //"Currency Description cannot be left blank",
                ADFModelUtils.resolvRsrc("MSG.17734"), //"Please enter Currency Description before search",
                FacesMessage.SEVERITY_WARN, findClientId("transCurrDescId"));
            return "N";
        }
        return ret;
    }


    public void searchTrnpBulkSoAL(ActionEvent actionEvent) {
        if (validateHeader().equalsIgnoreCase("Y")) {
            OperationBinding binding = ADFBeanUtils.getOperationBinding("searchBulkSo");
            binding.execute();
        }

    }

    public void resetTrnpBulkSoAL(ActionEvent actionEvent) {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("resetBulkSo");
        binding.execute();
        SoBulkList.clear();
    }

    public void populateItmDetailAL(ActionEvent actionEvent) {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("populateItemDetail");
        //binding.getParamsMap().put("SoListGrp", BulkSoList);
        binding.execute();
        SoBulkList.clear();
        TrfBulkList.clear();
    }

    public void saveBulkVhclReqAL(ActionEvent actionEvent) {

        OperationBinding binding2 = ADFBeanUtils.getOperationBinding("validateItemDetails");
        binding2.execute();
        if (binding2.getResult().toString().equalsIgnoreCase("Y")) {
            //genBulkLrDispId
            OperationBinding opDisp = ADFBeanUtils.getOperationBinding("saveBulkLrAction");
            opDisp.execute();

            if (opDisp.getResult() != null && opDisp.getResult().toString().equals("Y")) {

                OperationBinding op = ADFBeanUtils.getOperationBinding("checkVehicle");
                op.execute();
                if (op.getResult() != null && op.getResult().toString().equals("Y")) {
                    OperationBinding binding3 = ADFBeanUtils.getOperationBinding("removeItemFromVr");
                    binding3.getParamsMap().put("type", "S");
                    binding3.execute();
                    if (binding3.getResult() != null && binding3.getResult().toString().equals("Y")) {
                        OperationBinding ob = ADFBeanUtils.getOperationBinding("checkStockDetails");
                        ob.execute();
                        //if started
                        if (ob.getResult() != null && ob.getResult().toString().equals("Y")) {

                            OperationBinding bind = ADFBeanUtils.getOperationBinding("checkSrcVo");
                            bind.execute();
                            if (bind.getResult().toString().equalsIgnoreCase("Y")) {
                                OperationBinding binding1 = ADFBeanUtils.getOperationBinding("validateBulkVr");
                                binding1.execute();
                                if (binding1.getResult().toString().equalsIgnoreCase("SUCCESS")){
                                OperationBinding binding = ADFBeanUtils.getOperationBinding("Commit");
                                binding.execute();
                                OperationBinding bindingOb = ADFBeanUtils.getOperationBinding("executeBulkLr");
                                bindingOb.execute();
                                mode = "V";
                                ADFModelUtils.showFormattedFacesMessage(ADFModelUtils.resolvRsrc("MSG.12669"),
                                                                            //"Saved",
                                ADFModelUtils.resolvRsrc("MSG.614"), //"Data Saved Successfully",
                                FacesMessage.SEVERITY_INFO);
                                }
                                else{
                                             ADFModelUtils.showFormattedFacesMessage(binding1.getResult().toString(),
                                                                                     "",
                                                                                     FacesMessage.SEVERITY_ERROR);
                                     
                                         }
                                

                            } else {
                                ADFModelUtils.showFormattedFacesMessage("Among all the selected Sales Order, the stock was 0 for all the items!!!",
                                                                        "Please Select another sales order!!! ",
                                                                        FacesMessage.SEVERITY_WARN);
                                return;
                            }
                        } else if (ob.getResult().toString().equals("D")) {
                            ADFModelUtils.showFormattedFacesMessage("Different Vehicle ",
                                                                    " Different Vehicles found for same route. ",
                                                                    FacesMessage.SEVERITY_WARN);
                        }else {
                            ADFModelUtils.showFormattedFacesMessage("Available Stock is less than required quantity for these items : ",
                                                                    ob.getResult().toString(),
                                                                    FacesMessage.SEVERITY_WARN);
                        }
                    } else {
                        ADFModelUtils.showFormattedFacesMessage("",
                                                                "Please select atleast one item for all Orders :: "+binding3.getResult().toString(),
                                                                FacesMessage.SEVERITY_WARN);
                    }

                    //else
                } else {
                    ADFModelUtils.showFormattedFacesMessage("Please select Vehicle.",
                                                            "Vehicles are not selected for all Order.",
                                                            FacesMessage.SEVERITY_WARN);
                }
                //here
            }
            //            else if(opDisp.getResult() != null && opDisp.getResult().toString().equals("X")){
            //                ADFModelUtils.showFormattedFacesMessage("Error",
            //                                                        "Display id row null. Please cancel and create again",
            //                                                        FacesMessage.SEVERITY_ERROR);
            //            }
            //            else{
            //                ADFModelUtils.showFormattedFacesMessage("Error",
            //                                                        "Display id not generated.",
            //                                                        FacesMessage.SEVERITY_WARN);
            //            }
        }


    }


    public String findClientId(String id) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent root = context.getViewRoot();
        UIComponent clint = findComponent(root, id);
        return clint.getClientId(context);
    }

    public UIComponent findComponent(UIComponent base, String id) {
        UIComponent children = null;
        UIComponent result = null;
        if (id.equals(base.getId()))
            return base;
        Iterator childrens = base.getFacetsAndChildren();
        while (childrens.hasNext() && (result == null)) {
            children = (UIComponent) childrens.next();
            if (id.equals(children.getId())) {
                result = children;
                break;
            }
            result = findComponent(children, id);
            if (result != null) {
                break;
            }
        }
        return result;
    }


    public String validateReqValue() {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("validateReqValue");
        binding.execute();
        Integer val = (Integer) binding.getResult();
        if (val.compareTo(1) == 0) {
            ADFModelUtils.showFacesMessage(ADFModelUtils.resolvRsrc("LBL.4952"), //"Warning",
                ADFModelUtils.resolvRsrc("MSG.17735") + ADFModelUtils.resolvRsrc("MSG.17736"), // " 'Please add required value! ",
                FacesMessage.SEVERITY_WARN, findClientId("soc3"));
            return "N";
        } else if (val.compareTo(2) == 0) {
            ADFModelUtils.showFacesMessage(ADFModelUtils.resolvRsrc("LBL.4952"), //"Warning",
                "Please select cage no.", // " 'Please add required value! ",
                FacesMessage.SEVERITY_WARN, findClientId("transCageNameId"));
            return "N";
        }
        //        if(val.compareTo(2)== 0){
        //            ADFModelUtils.showFacesMessage("Warning", "Route Name is mandatory" + " 'Please add required value! ",
        //                                           FacesMessage.SEVERITY_WARN, findClientId("transRouteNameId"));
        //            return  "N";
        //        }
        //        else if(val.compareTo(3)== 0){
        //            ADFModelUtils.showFacesMessage("Warning", "Location is mandatory" + " 'Please add required value! ",
        //                                           FacesMessage.SEVERITY_WARN, findClientId("transLocNmId"));
        //            return  "N";
        //        }


        /**
         * TMS ID : 80455
         * Modified By : Bhanu PS
         * Changes Done : Below Code has been commented,
         *                  So that Vehicle type should be non-mandatory
         * */
        //        if (val.compareTo(4) == 0) {
        //            ADFModelUtils.showFacesMessage(ADFModelUtils.resolvRsrc("LBL.4952"), //"Warning",
        //                ADFModelUtils.resolvRsrc("MSG.17737") + ADFModelUtils.resolvRsrc("MSG.17736"), //" 'Please add required value! ",
        //                FacesMessage.SEVERITY_WARN, findClientId("transVhclTypeId"));
        //            return "N";
        //        }
        return "Y";
    }


    public void addListOfOrdersAL(ActionEvent actionEvent) {
        if (validateReqValue().equalsIgnoreCase("Y")) {
            System.out.println("in validateReqVal Y case");
            OperationBinding binding = ADFBeanUtils.getOperationBinding("addListOfOrders");
            binding.execute();
        }
        // DataList.add(binding.getResult());
    }


    public void editBulkVhclReqAL(ActionEvent actionEvent) {
        OperationBinding pendingAtOp = ADFBeanUtils.getOperationBinding("chkPendingUsr");
        pendingAtOp.execute();
        Integer pendingAt = (Integer) pendingAtOp.getResult();
        if (pendingAt.equals(-1) || pendingAt.equals(EbizParams.GLBL_APP_USR())) {
            //                setMode("A");
            mode = "A";
        } else {
            OperationBinding usrNmOp = ADFBeanUtils.getOperationBinding("getUsrNm");
            usrNmOp.getParamsMap().put("usrId", pendingAt);
            usrNmOp.execute();
            String usrNm = ADFModelUtils.resolvRsrc("MSG.2402"); // "Anonymous.";
            if (usrNmOp.getResult() != null)
                usrNm = (String) usrNmOp.getResult();
            ADFModelUtils.showFormattedFacesMessage(ADFModelUtils.resolvRsrc("MSG.1163"),
                                                    ADFModelUtils.resolvRsrc("MSG.1294") + " [ " + usrNm + "] " +
                                                    ADFModelUtils.resolvRsrc("MSG.879"), FacesMessage.SEVERITY_INFO);
        }
    }

    public String canclBulkVhclReqAction() {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("Rollback");
        binding.execute();
        SoBulkList.clear();
        return "Back";
    }


    public void generateRequestAL(ActionEvent actionEvent) {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("generateBulkRequest");
        binding.execute();
        AdfFacesContext.getCurrentInstance().addPartialTarget(lrStatusBind);
    }

    public void deleteBulkItemsAL(ActionEvent actionEvent) {
        System.out.println("inside delete");
        OperationBinding binding = ADFBeanUtils.getOperationBinding("Delete");
        binding.execute();
    }

    public void deleteSalesOrderSrc(ActionEvent actionEvent) {
        String docId = actionEvent.getComponent().getAttributes().get("SoDocId").toString();
        OperationBinding binding = ADFBeanUtils.getOperationBinding("deleteSalesOrderSrc");
        binding.getParamsMap().put("SrcDocId", docId);
        binding.execute();
        if (binding.getResult().toString().equalsIgnoreCase("Y")) {
            ADFBeanUtils.getOperationBinding("Delete1").execute();
        }


    }


    public void chkSelectSOVCL(ValueChangeEvent vce) {
        vce.getComponent().processUpdates(FacesContext.getCurrentInstance());

        // System.out.println("inside vcl");
        OperationBinding binding = ADFBeanUtils.getOperationBinding("getTotalGrossWtVal");
        binding.execute();
        // System.out.println("inside gross wt");
        OperationBinding binding1 = ADFBeanUtils.getOperationBinding("getTotalBalanceWtVal");
        binding1.execute();
        //System.out.println("inside balance wt");
        OperationBinding binding2 = ADFBeanUtils.getOperationBinding("getTotalBundleVal");
        binding2.execute();
        OperationBinding binding3 = ADFBeanUtils.getOperationBinding("getTotalAmount");
        binding3.execute(); //getTotalAmount
    }

    public void totStkVldtr(FacesContext facesContext, UIComponent uIComponent, Object object) {
     Number n = (Number) object;
        System.out.println("docTypeBind get =" + docTypeBind);
        n = n == null ? new Number(0) : n;
        if (n.compareTo(0) == 0) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          ADFModelUtils.resolvRsrc("LBL.14611"), //"Quantity Must be Greater than 0.",
                                                          null));
        }


       Number avlqty = (Number) uIComponent.getAttributes().get("dlvQty");
        if (n.compareTo(avlqty) == 1) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          ADFModelUtils.resolvRsrc("MSG.17738") + "[" +
                                                          //"Quantity Must be less than or equal to Document created Quantity.[" +
                                                          avlqty + "]", null));
        }
        //        } else if (n.compareTo(avlqty) == 1 && docTypeBind.equals(2342)) {
        //            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
        //                                                          "Quantity Must be less than or equal to RMA Quantity.[" +
        //                                                          avlqty + "]", null));
        //        }

        //        Number avlblQty = (Number)uIComponent.getAttributes().get("avlblQty");
        //        if(n.compareTo(avlblQty) == 1){
        //            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Quantity Must be less than Available Stock.",null));
        //        }


    }


    public void amendVhclSchdl(ActionEvent actionEvent) {
        OperationBinding binding = ADFBeanUtils.getOperationBinding("amendVhclSchdl");
        binding.execute();
        Integer res = (Integer) binding.getResult();
        if (res != null) {
            if (res.compareTo(1) == 0) {
                mode = "A";

            } else if (res.compareTo(-1) == 0) {
                ADFModelUtils.showFormattedFacesMessage(null, ADFModelUtils.resolvRsrc("MSG.17745"), // "VEHICLE REQUEST NUMBER NOT GENERATED",
                                                        FacesMessage.SEVERITY_INFO);
            } else if (res.compareTo(-2) == 0) {
                ADFModelUtils.showFormattedFacesMessage(ADFModelUtils.resolvRsrc("MSG.17755"),
                    //"Can'nt Ammend this Vehicle Request",
                    ADFModelUtils.resolvRsrc("MSG.17747"),
                    //"This Document is already used in another Application.",
                    FacesMessage.SEVERITY_INFO);
            } else if (res.compareTo(-3) == 0) {
                ADFModelUtils.showFormattedFacesMessage("Error",
                                                        "There is some error in calling function FN_TRNP_AMND_BLK_LR",
                                                        FacesMessage.SEVERITY_INFO);
            }
        }
        //        System.out.println("mode is " + mode);
    }

    public void cancelOldVhclReq(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding bindingcancel = ADFBeanUtils.getOperationBinding("cancelOldBulkRequest");
        bindingcancel.execute();
        mode = "V";
    }

    public void setLrStatusBind(RichSelectOneChoice lrStatusBind) {
        this.lrStatusBind = lrStatusBind;
    }

    public RichSelectOneChoice getLrStatusBind() {
        return lrStatusBind;
    }

    public void docTypeValidator(FacesContext facesContext, UIComponent uIComponent, Object object) {
        // Add event code here...
        if (object == null) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          ADFModelUtils.resolvRsrc("MSG.2260"), // "Please Select Document Type",
                                                          ""));
        }

    }

    public void setDocTypeBind(RichSelectOneChoice docTypeBind) {
        this.docTypeBind = docTypeBind;
    }

    public RichSelectOneChoice getDocTypeBind() {
        return docTypeBind;
    }

    public void selectAllItemVCL(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        //        System.out.println(" ==  == == == "+valueChangeEvent.getNewValue());
        //        OperationBinding binding = ADFBeanUtils.getOperationBinding("selectAllItem");
        //        binding.execute();
    }

    public String saveAndForwardAction() {
        // Add event code here...
        String retFlow = null;
        OperationBinding binding2 = ADFBeanUtils.getOperationBinding("validateItemDetails");
        binding2.execute();
        if (binding2.getResult().toString().equalsIgnoreCase("Y")) {
            //
            OperationBinding opDisp = ADFBeanUtils.getOperationBinding("saveBulkLrAction");
            opDisp.execute();

            if (opDisp.getResult() != null && opDisp.getResult().toString().equals("Y")) {
                // validate if the vehicle sre not selected in SRC table
                OperationBinding op = ADFBeanUtils.getOperationBinding("checkVehicle");
                op.execute();
                if (op.getResult() != null && op.getResult().toString().equals("Y")) {
                    OperationBinding binding3 = ADFBeanUtils.getOperationBinding("removeItemFromVr");
                    binding3.getParamsMap().put("type", "A");// To Remove unchecked items from item details tab.
                    binding3.execute();
                    if (binding3.getResult() != null && binding3.getResult().toString().equals("Y")) {
                        //                OperationBinding binding = ADFBeanUtils.getOperationBinding("Commit");
                        //                binding.execute();
                        OperationBinding ob = ADFBeanUtils.getOperationBinding("checkStockDetails"); 
                        ob.execute();
                        //if started
                        
                        if (ob.getResult() != null && ob.getResult().toString().equals("Y")) {

                            OperationBinding bind = ADFBeanUtils.getOperationBinding("checkSrcVo");
                            bind.execute();
                            if (bind.getResult().toString().equalsIgnoreCase("Y")) {
                                OperationBinding chkCage = ADFBeanUtils.findOperation("chkCageStatus");
                                chkCage.execute();
                                    String chkCag =  chkCage.getResult() == null ? "N" : (String)chkCage.getResult() ;
                                    if(chkCag.equalsIgnoreCase("Y")){
                                OperationBinding bindingOb = ADFBeanUtils.getOperationBinding("executeBulkLr");
                                bindingOb.execute();
                                /** ************ CODE STARTED **************
                     * Added By  : Bhanu PS
                     * Added On  : 24.05.2019
                     * Below Code is added to insert data in Workflow.
                     */

                                OperationBinding WfnoOp = ADFBeanUtils.findOperation("getWfNo");
                                WfnoOp.execute();
                                String WfNum = null;
                                Integer level = 0;
                                Integer res = -1;
                                String action = "I";
                                String remark = "A";
                                if (WfnoOp.getResult() != null) {
                                    WfNum = WfnoOp.getResult().toString();
                                }
                                if (WfNum != null) {
                                    OperationBinding usrLevelOp = ADFBeanUtils.findOperation("currUsrLvl");
                                    usrLevelOp.getParamsMap().put("WfNum", WfNum);
                                    usrLevelOp.execute();
                                    level = -1;
                                    if (usrLevelOp.getResult() != null) {
                                        if (usrLevelOp.getResult() != null)
                                            level = Integer.parseInt(usrLevelOp.getResult().toString());
                                    }
                                    if (level == -1) {
                                        ADFModelUtils.showFormattedFacesMessage(ADFModelUtils.resolvRsrc("MSG.1506"),
                                                                                " ", FacesMessage.SEVERITY_ERROR);
                                    } else {
                                        OperationBinding insTxnOp = ADFBeanUtils.findOperation("insertIntoWF");
                                        insTxnOp.getParamsMap().put("wfId", WfNum);
                                        insTxnOp.getParamsMap().put("lvlFrm", level);
                                        insTxnOp.getParamsMap().put("lvlTo", level);
                                        insTxnOp.getParamsMap().put("action", action);
                                        insTxnOp.getParamsMap().put("remark", remark);
                                        insTxnOp.getParamsMap().put("amount", 0);
                                        insTxnOp.execute();

                                        if (insTxnOp.getResult() != null) {
                                            res = Integer.parseInt(insTxnOp.getResult().toString());
                                        }
                                        
                                        if (res != null && res == 1) {
                                            OperationBinding binding1 = ADFBeanUtils.getOperationBinding("validateBulkVr");
                                            binding1.execute();
                                            if (binding1.getResult().toString().equalsIgnoreCase("SUCCESS")){
                                            OperationBinding binding = ADFBeanUtils.getOperationBinding("Commit");
                                                OperationBinding operationBinding = ADFBeanUtils.findOperation("Commit");
                                                operationBinding.execute();
                                                setMode("V");
                                                return "wayToWorkflow";
                                            }
                                            else{
                                                         ADFModelUtils.showFormattedFacesMessage(binding1.getResult().toString(),
                                                                                                 "",
                                                                                                 FacesMessage.SEVERITY_ERROR);
                                                 
                                                     }
                                            
                                        }
                                    }
                                } else {

                                    ADFModelUtils.showFormattedFacesMessage(ADFModelUtils.resolvRsrc("MSG.1486"), " ",
                                                                            FacesMessage.SEVERITY_ERROR); // Workflow not Defined for this Document.

                                }
                                /************** CODE END ***************/


                                //                mode = "V";
                                ADFModelUtils.showFormattedFacesMessage(ADFModelUtils.resolvRsrc("MSG.12669"),
                                                                        //"Saved",
                                    ADFModelUtils.resolvRsrc("MSG.614"), //"Data Saved Successfully",
                                    FacesMessage.SEVERITY_INFO);

                                }else{
                                        ADFModelUtils.showFormattedFacesMessage("",
                                                                                chkCag,
                                                                                FacesMessage.SEVERITY_WARN);
                                    }
                            } else {
                                ADFModelUtils.showFormattedFacesMessage("Among all the selected Sales Order, the stock was 0 for all the items!!!",
                                                                        "Please Select another sales order!!! ",
                                                                        FacesMessage.SEVERITY_WARN);
                            }
                            ////////else
                        } else if (ob.getResult().toString().equals("D")) {
                            ADFModelUtils.showFormattedFacesMessage("Different Vehicle",
                                                                    "Different Vehicles found for same route.",
                                                                    FacesMessage.SEVERITY_WARN);
                        } else {
                            ADFModelUtils.showFormattedFacesMessage("Available Stock is less than required quantity for these items : ",
                                                                    ob.getResult().toString(),
                                                                    FacesMessage.SEVERITY_WARN);
                        }

                        //ELSE
                    } else {
                        ADFModelUtils.showFormattedFacesMessage("",
                                                                "Please select atleast one item for all Sales Orders :: "+binding3.getResult().toString(),
                                                                FacesMessage.SEVERITY_WARN);
                    }
                } else {
                    ADFModelUtils.showFormattedFacesMessage("Please select Vehicle.",
                                                            "Vehicles are not selected for all Order.",
                                                            FacesMessage.SEVERITY_WARN);
                }
                //here
            }
            //            else if(opDisp.getResult() != null && opDisp.getResult().toString().equals("X")){
            //                ADFModelUtils.showFormattedFacesMessage("Error",
            //                                                        "Display id row null. Please cancel and create again",
            //                                                        FacesMessage.SEVERITY_ERROR);
            //            }
            //
            //            else{
            //                ADFModelUtils.showFormattedFacesMessage("Error",
            //                                                        "Display id not generated.",
            //                                                        FacesMessage.SEVERITY_WARN);
            //            }
        }
        return null;
    }

    public void selectAllDocumentsAL(ActionEvent actionEvent) {

        OperationBinding ob = ADFBeanUtils.findOperation("selectAllDoc");
        ob.getParamsMap().put("action", "SA");
        ob.execute();
        //AdfFacesContext.getCurrentInstance().addPartialTarget(checkBoxSalesOrder);

    }

    public void deSelectAllDocAL(ActionEvent actionEvent) {

        OperationBinding ob = ADFBeanUtils.findOperation("selectAllDoc");
        ob.getParamsMap().put("action", "DA");
        ob.execute();
    }

    public void selectAllItemAL(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding ob = ADFBeanUtils.findOperation("selectAllItem");
        ob.getParamsMap().put("action", "SA");
        ob.execute();

    }

    public void deSelectAllItemAL(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding ob = ADFBeanUtils.findOperation("selectAllItem");
        ob.getParamsMap().put("action", "DA");
        ob.execute();

    }

    public void setCheckBoxSalesOrder(RichSelectBooleanCheckbox checkBoxSalesOrder) {
        this.checkBoxSalesOrder = checkBoxSalesOrder;
    }

    public RichSelectBooleanCheckbox getCheckBoxSalesOrder() {
        return checkBoxSalesOrder;
    }

    public void updateSchlDtAL(ActionEvent actionEvent) {
        // Add event code here...
        OperationBinding ob = ADFBeanUtils.findOperation("updateSchlDt");

        ob.execute();
    }

    public void refrshStkACL(ActionEvent actionEvent) {
        OperationBinding op = ADFBeanUtils.findOperation("refrshStk");
        op.execute();
    }

    public void vhclNoVldtr(FacesContext facesContext, UIComponent uIComponent, Object object) {
        if(object!=null){
            String vhclNo = object.toString();
        OperationBinding op = ADFBeanUtils.findOperation("chkVhclNoSchdlStat");
        op.getParamsMap().put("vhclNo", vhclNo);
        op.execute();
        Integer n = op.getResult() == null ? 0 : (Integer)op.getResult();
        if (n.equals(-1)) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                          "Vehicle Number is already scheduled!!! Please select some other vehicle!!!"
                                                          //"Quantity Must be less than or equal to Document created Quantity.[" +
                                                            , null));
            }
        }

    }

    public void popVehicle(ActionEvent actionEvent) {
       OperationBinding op = ADFBeanUtils.findOperation("popVehicle");
       op.execute();
       Integer res = (Integer)op.getResult();
       if(res.equals(0)){
               ADFModelUtils.showFormattedFacesMessage("Please select Vehicle.",
                                                       "Vehicles is not selected.",
                                                       FacesMessage.SEVERITY_WARN);
           }
    }

    public void rptPrintButtonAL(ActionEvent actionEvent) {
//        OperationBinding op = ADFBeanUtils.findOperation("populateRptData");
//        op.getParamsMap().put("linkId", "l20");
//        op.execute();
//        
//        
        System.out.println("1 Data inserted in Teble");
    }

    public String populateRptDataACTION() {
//        OperationBinding op = ADFBeanUtils.findOperation("populateRptData");
//        op.getParamsMap().put("linkId", "l20");
//        op.execute();
//        
//        
//        System.out.println("2 Data inserted in Teble");
        return null;
    }

  public void chkSelectTrfVCL(ValueChangeEvent valueChangeEvent)
  {
    // Add event code here...
    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
    OperationBinding binding2 = ADFBeanUtils.getOperationBinding("getTotalBundleVal");
    binding2.execute();
  }

  public void selectAllDocumentsTrfAL(ActionEvent actionEvent)
  {
    // Add event code here...
    OperationBinding ob = ADFBeanUtils.findOperation("selectAllDocTrf");
    ob.getParamsMap().put("action", "SA");
    ob.execute();
  }

  public void deSelectAllDocTrfAL(ActionEvent actionEvent)
  {
    // Add event code here...
    OperationBinding ob = ADFBeanUtils.findOperation("selectAllDocTrf");
    ob.getParamsMap().put("action", "DA");
    ob.execute();
  }

  public void ChkSelectBulkTrf(ValueChangeEvent valueChangeEvent)
  {
    // Add event code here...
    valueChangeEvent.getComponent().processUpdates(FacesContext.getCurrentInstance());
  }

  public void SelectAllVrItm(ActionEvent actionEvent)
  {
    // Add event code here...
    OperationBinding ob = ADFBeanUtils.findOperation("selectAllVRItem");
    ob.getParamsMap().put("action", "SA");
    ob.execute();

  }

  public void deSelectAllVrItm(ActionEvent actionEvent)
  {
    // Add event code here...
    OperationBinding ob = ADFBeanUtils.findOperation("selectAllVRItem");
    ob.getParamsMap().put("action", "DA");
    ob.execute();

  }
  /**
          * Added by : Manjeet Singh
          * Modified on : 04-12-23
          * Remarks : This Below Code is used for validation. '.
          * TMS ID : 128922
          **/
  public void TotalQtyVldt(FacesContext facesContext, UIComponent uIComponent, Object object)
  {
    Number n = (Number) object;
       System.out.println("docTypeBind get =" + docTypeBind);
       n = n == null ? new Number(0) : n;
       System.err.println("_____TotalQtyVldt_____n___________"+n);
       if (n.compareTo(0) == 0) {
           throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                         ADFModelUtils.resolvRsrc("LBL.14611"), //"Quantity Must be Greater than 0.",
                                                         null));
       }


      Number avlqty = (Number) uIComponent.getAttributes().get("DlvQty");
    System.err.println("_____TotalQtyVldt_____avlqty________"+avlqty);
       if (n.compareTo(avlqty) == 1) {
           throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                                         ADFModelUtils.resolvRsrc("MSG.17738") + "[" +
                                                         //"Quantity Must be less than or equal to Document created Quantity.[" +
                                                         avlqty + "]", null));
       }
  }
}
