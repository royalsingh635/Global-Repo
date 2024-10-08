package trnpbulkvhclreqapp.model.views;

import adf.utils.ebiz.EbizParams;

import adf.utils.ebiz.EbizParamsAPPUtils;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jul 10 13:23:33 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SearchParamDualVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Dummy,
        TransDrftDispId,
        TransDispDocId,
        TransSlocId,
        TransOrgId,
        TransHoOrgId,
        TransCldId,
        TransStDt,
        TransEndDt,
        TransDocType,
        TransDocTypeId,
        TransModeNm,
        TransModeId,
        TransLrNo,
        TransLrDocId,
        TransSchdlNo,
        TransSchdlDocId,
        TransSoNo,
        TransSoDocId,
        TransEoNm,
        TransEoId,
        TransStatus,
        TransStatusId,
        TransRmaId,
        TransRmaDocId,
        TransBVRDocType,
        SearchParamDualVO1,
        LOVBulkLRDrftDispIdVO1,
        LovDocumentTypeVO1,
        LovModeVO1,
        LovSODispIdVO1,
        LovLrDispId1,
        LovSchdlDispId1,
        LOVStatusVO1,
        LovEoId1,
        LovRmaDispIdVO1;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int DUMMY = AttributesEnum.Dummy.index();
    public static final int TRANSDRFTDISPID = AttributesEnum.TransDrftDispId.index();
    public static final int TRANSDISPDOCID = AttributesEnum.TransDispDocId.index();
    public static final int TRANSSLOCID = AttributesEnum.TransSlocId.index();
    public static final int TRANSORGID = AttributesEnum.TransOrgId.index();
    public static final int TRANSHOORGID = AttributesEnum.TransHoOrgId.index();
    public static final int TRANSCLDID = AttributesEnum.TransCldId.index();
    public static final int TRANSSTDT = AttributesEnum.TransStDt.index();
    public static final int TRANSENDDT = AttributesEnum.TransEndDt.index();
    public static final int TRANSDOCTYPE = AttributesEnum.TransDocType.index();
    public static final int TRANSDOCTYPEID = AttributesEnum.TransDocTypeId.index();
    public static final int TRANSMODENM = AttributesEnum.TransModeNm.index();
    public static final int TRANSMODEID = AttributesEnum.TransModeId.index();
    public static final int TRANSLRNO = AttributesEnum.TransLrNo.index();
    public static final int TRANSLRDOCID = AttributesEnum.TransLrDocId.index();
    public static final int TRANSSCHDLNO = AttributesEnum.TransSchdlNo.index();
    public static final int TRANSSCHDLDOCID = AttributesEnum.TransSchdlDocId.index();
    public static final int TRANSSONO = AttributesEnum.TransSoNo.index();
    public static final int TRANSSODOCID = AttributesEnum.TransSoDocId.index();
    public static final int TRANSEONM = AttributesEnum.TransEoNm.index();
    public static final int TRANSEOID = AttributesEnum.TransEoId.index();
    public static final int TRANSSTATUS = AttributesEnum.TransStatus.index();
    public static final int TRANSSTATUSID = AttributesEnum.TransStatusId.index();
    public static final int TRANSRMAID = AttributesEnum.TransRmaId.index();
    public static final int TRANSRMADOCID = AttributesEnum.TransRmaDocId.index();
    public static final int TRANSBVRDOCTYPE = AttributesEnum.TransBVRDocType.index();
    public static final int SEARCHPARAMDUALVO1 = AttributesEnum.SearchParamDualVO1.index();
    public static final int LOVBULKLRDRFTDISPIDVO1 = AttributesEnum.LOVBulkLRDrftDispIdVO1.index();
    public static final int LOVDOCUMENTTYPEVO1 = AttributesEnum.LovDocumentTypeVO1.index();
    public static final int LOVMODEVO1 = AttributesEnum.LovModeVO1.index();
    public static final int LOVSODISPIDVO1 = AttributesEnum.LovSODispIdVO1.index();
    public static final int LOVLRDISPID1 = AttributesEnum.LovLrDispId1.index();
    public static final int LOVSCHDLDISPID1 = AttributesEnum.LovSchdlDispId1.index();
    public static final int LOVSTATUSVO1 = AttributesEnum.LOVStatusVO1.index();
    public static final int LOVEOID1 = AttributesEnum.LovEoId1.index();
    public static final int LOVRMADISPIDVO1 = AttributesEnum.LovRmaDispIdVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public SearchParamDualVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute Dummy.
     * @return the Dummy
     */
    public String getDummy() {
        return (String) getAttributeInternal(DUMMY);
    }

    /**
     * Gets the attribute value for the calculated attribute TransDrftDispId.
     * @return the TransDrftDispId
     */
    public String getTransDrftDispId() {
        return (String) getAttributeInternal(TRANSDRFTDISPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransDrftDispId.
     * @param value value to set the  TransDrftDispId
     */
    public void setTransDrftDispId(String value) {
        setAttributeInternal(TRANSDRFTDISPID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransDispDocId.
     * @return the TransDispDocId
     */
    public String getTransDispDocId() {
        return (String) getAttributeInternal(TRANSDISPDOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransDispDocId.
     * @param value value to set the  TransDispDocId
     */
    public void setTransDispDocId(String value) {
        setAttributeInternal(TRANSDISPDOCID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransSlocId.
     * @return the TransSlocId
     */
    public Integer getTransSlocId() {
        if(getAttributeInternal(TRANSSLOCID) == null){
            return EbizParams.GLBL_APP_SERV_LOC();
        }
        return (Integer) getAttributeInternal(TRANSSLOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransSlocId.
     * @param value value to set the  TransSlocId
     */
    public void setTransSlocId(Integer value) {
        setAttributeInternal(TRANSSLOCID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransOrgId.
     * @return the TransOrgId
     */
    public String getTransOrgId() {
        if(getAttributeInternal(TRANSORGID) == null){
            return EbizParams.GLBL_APP_USR_ORG();
        }
        return (String) getAttributeInternal(TRANSORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransOrgId.
     * @param value value to set the  TransOrgId
     */
    public void setTransOrgId(String value) {
        setAttributeInternal(TRANSORGID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransHoOrgId.
     * @return the TransHoOrgId
     */
    public String getTransHoOrgId() {
        if(getAttributeInternal(TRANSHOORGID) == null){
            return EbizParams.GLBL_HO_ORG_ID();
        }
        return (String) getAttributeInternal(TRANSHOORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransHoOrgId.
     * @param value value to set the  TransHoOrgId
     */
    public void setTransHoOrgId(String value) {
        setAttributeInternal(TRANSHOORGID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransCldId.
     * @return the TransCldId
     */
    public String getTransCldId() {
        if(getAttributeInternal(TRANSCLDID) == null){
            return EbizParams.GLBL_APP_CLD_ID();
        }
        return (String) getAttributeInternal(TRANSCLDID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransCldId.
     * @param value value to set the  TransCldId
     */
    public void setTransCldId(String value) {
        setAttributeInternal(TRANSCLDID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransStDt.
     * @return the TransStDt
     */
    public Timestamp getTransStDt() {
        return (Timestamp) getAttributeInternal(TRANSSTDT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransStDt.
     * @param value value to set the  TransStDt
     */
    public void setTransStDt(Timestamp value) {
        setAttributeInternal(TRANSSTDT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransEndDt.
     * @return the TransEndDt
     */
    public Timestamp getTransEndDt() {
        return (Timestamp) getAttributeInternal(TRANSENDDT);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransEndDt.
     * @param value value to set the  TransEndDt
     */
    public void setTransEndDt(Timestamp value) {
        setAttributeInternal(TRANSENDDT, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransDocType.
     * @return the TransDocType
     */
    public String getTransDocType() {

        return (String) getAttributeInternal(TRANSDOCTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransDocType.
     * @param value value to set the  TransDocType
     */
    public void setTransDocType(String value) {
        setAttributeInternal(TRANSDOCTYPE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransDocTypeId.
     * @return the TransDocTypeId
     */
    public Integer getTransDocTypeId() {
        return (Integer) getAttributeInternal(TRANSDOCTYPEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransDocTypeId.
     * @param value value to set the  TransDocTypeId
     */
    public void setTransDocTypeId(Integer value) {
        setAttributeInternal(TRANSDOCTYPEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransModeNm.
     * @return the TransModeNm
     */
    public String getTransModeNm() {
        return (String) getAttributeInternal(TRANSMODENM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransModeNm.
     * @param value value to set the  TransModeNm
     */
    public void setTransModeNm(String value) {
        setAttributeInternal(TRANSMODENM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransModeId.
     * @return the TransModeId
     */
    public Integer getTransModeId() {
        return (Integer) getAttributeInternal(TRANSMODEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransModeId.
     * @param value value to set the  TransModeId
     */
    public void setTransModeId(Integer value) {
        setAttributeInternal(TRANSMODEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransLrNo.
     * @return the TransLrNo
     */
    public String getTransLrNo() {
        return (String) getAttributeInternal(TRANSLRNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransLrNo.
     * @param value value to set the  TransLrNo
     */
    public void setTransLrNo(String value) {
        setAttributeInternal(TRANSLRNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransLrDocId.
     * @return the TransLrDocId
     */
    public String getTransLrDocId() {
        return (String) getAttributeInternal(TRANSLRDOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransLrDocId.
     * @param value value to set the  TransLrDocId
     */
    public void setTransLrDocId(String value) {
        setAttributeInternal(TRANSLRDOCID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransSchdlNo.
     * @return the TransSchdlNo
     */
    public String getTransSchdlNo() {
        return (String) getAttributeInternal(TRANSSCHDLNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransSchdlNo.
     * @param value value to set the  TransSchdlNo
     */
    public void setTransSchdlNo(String value) {
        setAttributeInternal(TRANSSCHDLNO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransSchdlDocId.
     * @return the TransSchdlDocId
     */
    public String getTransSchdlDocId() {
        return (String) getAttributeInternal(TRANSSCHDLDOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransSchdlDocId.
     * @param value value to set the  TransSchdlDocId
     */
    public void setTransSchdlDocId(String value) {
        setAttributeInternal(TRANSSCHDLDOCID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransSoNo.
     * @return the TransSoNo
     */
    public String getTransSoNo() {
        return (String) getAttributeInternal(TRANSSONO);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransSoNo.
     * @param value value to set the  TransSoNo
     */
    public void setTransSoNo(String value) {
        setAttributeInternal(TRANSSONO, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransSoDocId.
     * @return the TransSoDocId
     */
    public String getTransSoDocId() {
        return (String) getAttributeInternal(TRANSSODOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransSoDocId.
     * @param value value to set the  TransSoDocId
     */
    public void setTransSoDocId(String value) {
        setAttributeInternal(TRANSSODOCID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransEoNm.
     * @return the TransEoNm
     */
    public String getTransEoNm() {
        return (String) getAttributeInternal(TRANSEONM);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransEoNm.
     * @param value value to set the  TransEoNm
     */
    public void setTransEoNm(String value) {
        setAttributeInternal(TRANSEONM, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransEoId.
     * @return the TransEoId
     */
    public Integer getTransEoId() {
        return (Integer) getAttributeInternal(TRANSEOID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransEoId.
     * @param value value to set the  TransEoId
     */
    public void setTransEoId(Integer value) {
        setAttributeInternal(TRANSEOID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransStatus.
     * @return the TransStatus
     */
    public String getTransStatus() {
        return (String) getAttributeInternal(TRANSSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransStatus.
     * @param value value to set the  TransStatus
     */
    public void setTransStatus(String value) {
        setAttributeInternal(TRANSSTATUS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransStatusId.
     * @return the TransStatusId
     */
    public Integer getTransStatusId() {
        return (Integer) getAttributeInternal(TRANSSTATUSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransStatusId.
     * @param value value to set the  TransStatusId
     */
    public void setTransStatusId(Integer value) {
        setAttributeInternal(TRANSSTATUSID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransRmaId.
     * @return the TransRmaId
     */
    public String getTransRmaId() {
        return (String) getAttributeInternal(TRANSRMAID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransRmaId.
     * @param value value to set the  TransRmaId
     */
    public void setTransRmaId(String value) {
        setAttributeInternal(TRANSRMAID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransRmaDocId.
     * @return the TransRmaDocId
     */
    public String getTransRmaDocId() {
        return (String) getAttributeInternal(TRANSRMADOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransRmaDocId.
     * @param value value to set the  TransRmaDocId
     */
    public void setTransRmaDocId(String value) {
        setAttributeInternal(TRANSRMADOCID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute TransBVRDocType.
     * @return the TransBVRDocType
     */
    public Integer getTransBVRDocType() {
        return (Integer) getAttributeInternal(TRANSBVRDOCTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute TransBVRDocType.
     * @param value value to set the  TransBVRDocType
     */
    public void setTransBVRDocType(Integer value) {
        setAttributeInternal(TRANSBVRDOCTYPE, value);
    }

    /**
     * Gets the view accessor <code>RowSet</code> SearchParamDualVO1.
     */
    public RowSet getSearchParamDualVO1() {
        return (RowSet) getAttributeInternal(SEARCHPARAMDUALVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LOVBulkLRDrftDispIdVO1.
     */
    public RowSet getLOVBulkLRDrftDispIdVO1() {
        return (RowSet) getAttributeInternal(LOVBULKLRDRFTDISPIDVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovDocumentTypeVO1.
     */
    public RowSet getLovDocumentTypeVO1() {
        return (RowSet) getAttributeInternal(LOVDOCUMENTTYPEVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovModeVO1.
     */
    public RowSet getLovModeVO1() {
        return (RowSet) getAttributeInternal(LOVMODEVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovSODispIdVO1.
     */
    public RowSet getLovSODispIdVO1() {
        return (RowSet) getAttributeInternal(LOVSODISPIDVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovLrDispId1.
     */
    public RowSet getLovLrDispId1() {
        return (RowSet) getAttributeInternal(LOVLRDISPID1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovSchdlDispId1.
     */
    public RowSet getLovSchdlDispId1() {
        return (RowSet) getAttributeInternal(LOVSCHDLDISPID1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LOVStatusVO1.
     */
    public RowSet getLOVStatusVO1() {
        return (RowSet) getAttributeInternal(LOVSTATUSVO1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovEoId1.
     */
    public RowSet getLovEoId1() {
        return (RowSet) getAttributeInternal(LOVEOID1);
    }

    /**
     * Gets the view accessor <code>RowSet</code> LovRmaDispIdVO1.
     */
    public RowSet getLovRmaDispIdVO1() {
        return (RowSet) getAttributeInternal(LOVRMADISPIDVO1);
    }
}

