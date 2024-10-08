package trnpbulkvhclreqapp.model.views;

import java.util.List;

import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaItem;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jul 12 17:27:55 IST 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LovGroupNmVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public LovGroupNmVOImpl() {
    }

    /**
     * Returns the bind variable value for BindEoSlocId.
     * @return bind variable value for BindEoSlocId
     */
    public Integer getBindEoSlocId() {
        return (Integer) getNamedWhereClauseParam("BindEoSlocId");
    }

    /**
     * Sets <code>value</code> for bind variable BindEoSlocId.
     * @param value value to bind as BindEoSlocId
     */
    public void setBindEoSlocId(Integer value) {
        setNamedWhereClauseParam("BindEoSlocId", value);
    }

    /**
     * Returns the bind variable value for BindEoHoOrgId.
     * @return bind variable value for BindEoHoOrgId
     */
    public String getBindEoHoOrgId() {
        return (String) getNamedWhereClauseParam("BindEoHoOrgId");
    }

    /**
     * Sets <code>value</code> for bind variable BindEoHoOrgId.
     * @param value value to bind as BindEoHoOrgId
     */
    public void setBindEoHoOrgId(String value) {
        setNamedWhereClauseParam("BindEoHoOrgId", value);
    }

    /**
     * Returns the bind variable value for BindEoCldId.
     * @return bind variable value for BindEoCldId
     */
    public String getBindEoCldId() {
        return (String) getNamedWhereClauseParam("BindEoCldId");
    }

    /**
     * Sets <code>value</code> for bind variable BindEoCldId.
     * @param value value to bind as BindEoCldId
     */
    public void setBindEoCldId(String value) {
        setNamedWhereClauseParam("BindEoCldId", value);
    }
    @Override
    public void applyViewCriteria(ViewCriteria viewCriteria, boolean b) {
        super.applyViewCriteria(supressStartsWithClauseForLov(viewCriteria), b);
    }


    public ViewCriteria supressStartsWithClauseForLov(ViewCriteria vc) {
        if (vc != null && vc.getName().contains("__lov__filterlist__vcr__")) {
            ViewCriteriaRow currentRow = (ViewCriteriaRow) vc.getCurrentRow();
            if (currentRow != null) {
                List criteriaItems = currentRow.getCriteriaItems();
                for (int i = 0; i < criteriaItems.size(); i++) {
                    ViewCriteriaItem object = (ViewCriteriaItem) criteriaItems.get(i);
                    if (object != null) {
                       
                        if ("STARTSWITH".equals(object.getOperator())) {
                            object.setOperator("CONTAINS");
                        }
                    }
                }
            }
        }
        return vc;
    }
    
}

