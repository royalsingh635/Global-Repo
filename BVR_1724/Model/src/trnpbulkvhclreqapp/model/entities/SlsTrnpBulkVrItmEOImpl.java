package trnpbulkvhclreqapp.model.entities;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.NClobDomain;
import oracle.jbo.domain.Number;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jul 06 12:55:57 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class SlsTrnpBulkVrItmEOImpl extends EntityImpl
{
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
    CldId,
    SlocId,
    OrgId,
    HoOrgId,
    DocId,
    SrcDocId,
    ItmSrNo,
    ItmId,
    DlvSchdlNo,
    DlvDt,
    TotQty,
    WhId,
    ItmUomBs,
    ItmUomSp,
    UsrIdCreate,
    UsrIdCreateDt,
    UsrIdMod,
    UsrIdModDt,
    DlvQty,
    SchdlDt,
    ColorAttGrpId,
    ItmFlag,
    AvlStk,
    UnpstdStk,
    WipStk,
    ItmCbm,
    BtoDocId;
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


  public static final int CLDID = AttributesEnum.CldId.index();
  public static final int SLOCID = AttributesEnum.SlocId.index();
  public static final int ORGID = AttributesEnum.OrgId.index();
  public static final int HOORGID = AttributesEnum.HoOrgId.index();
  public static final int DOCID = AttributesEnum.DocId.index();
  public static final int SRCDOCID = AttributesEnum.SrcDocId.index();
  public static final int ITMSRNO = AttributesEnum.ItmSrNo.index();
  public static final int ITMID = AttributesEnum.ItmId.index();
  public static final int DLVSCHDLNO = AttributesEnum.DlvSchdlNo.index();
  public static final int DLVDT = AttributesEnum.DlvDt.index();
  public static final int TOTQTY = AttributesEnum.TotQty.index();
  public static final int WHID = AttributesEnum.WhId.index();
  public static final int ITMUOMBS = AttributesEnum.ItmUomBs.index();
  public static final int ITMUOMSP = AttributesEnum.ItmUomSp.index();
  public static final int USRIDCREATE = AttributesEnum.UsrIdCreate.index();
  public static final int USRIDCREATEDT = AttributesEnum.UsrIdCreateDt.index();
  public static final int USRIDMOD = AttributesEnum.UsrIdMod.index();
  public static final int USRIDMODDT = AttributesEnum.UsrIdModDt.index();
  public static final int DLVQTY = AttributesEnum.DlvQty.index();
  public static final int SCHDLDT = AttributesEnum.SchdlDt.index();
  public static final int COLORATTGRPID = AttributesEnum.ColorAttGrpId.index();
  public static final int ITMFLAG = AttributesEnum.ItmFlag.index();
  public static final int AVLSTK = AttributesEnum.AvlStk.index();
  public static final int UNPSTDSTK = AttributesEnum.UnpstdStk.index();
  public static final int WIPSTK = AttributesEnum.WipStk.index();
  public static final int ITMCBM = AttributesEnum.ItmCbm.index();
  public static final int BTODOCID = AttributesEnum.BtoDocId.index();

  /**
   * This is the default constructor (do not remove).
   */
    public SlsTrnpBulkVrItmEOImpl() {
    }

  /**
   * @return the definition object for this instance class.
   */
  public static synchronized EntityDefImpl getDefinitionObject()
  {
    return EntityDefImpl.findDefObject("trnpbulkvhclreqapp.model.entities.SlsTrnpBulkVrItmEO");
  }


  /**
   * Gets the attribute value for CldId, using the alias name CldId.
   * @return the value of CldId
   */
    public String getCldId() {
        return (String) getAttributeInternal(CLDID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CldId.
     * @param value value to set the CldId
     */
    public void setCldId(String value) {
        setAttributeInternal(CLDID, value);
    }

    /**
     * Gets the attribute value for SlocId, using the alias name SlocId.
     * @return the value of SlocId
     */
    public Integer getSlocId() {
        return (Integer) getAttributeInternal(SLOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SlocId.
     * @param value value to set the SlocId
     */
    public void setSlocId(Integer value) {
        setAttributeInternal(SLOCID, value);
    }

    /**
     * Gets the attribute value for OrgId, using the alias name OrgId.
     * @return the value of OrgId
     */
    public String getOrgId() {
        return (String) getAttributeInternal(ORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrgId.
     * @param value value to set the OrgId
     */
    public void setOrgId(String value) {
        setAttributeInternal(ORGID, value);
    }

    /**
     * Gets the attribute value for HoOrgId, using the alias name HoOrgId.
     * @return the value of HoOrgId
     */
    public String getHoOrgId() {
        return (String) getAttributeInternal(HOORGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for HoOrgId.
     * @param value value to set the HoOrgId
     */
    public void setHoOrgId(String value) {
        setAttributeInternal(HOORGID, value);
    }

    /**
     * Gets the attribute value for DocId, using the alias name DocId.
     * @return the value of DocId
     */
    public String getDocId() {
        return (String) getAttributeInternal(DOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DocId.
     * @param value value to set the DocId
     */
    public void setDocId(String value) {
        setAttributeInternal(DOCID, value);
    }

    /**
     * Gets the attribute value for SrcDocId, using the alias name SrcDocId.
     * @return the value of SrcDocId
     */
    public String getSrcDocId() {
        return (String) getAttributeInternal(SRCDOCID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SrcDocId.
     * @param value value to set the SrcDocId
     */
    public void setSrcDocId(String value) {
        setAttributeInternal(SRCDOCID, value);
    }

    /**
     * Gets the attribute value for ItmSrNo, using the alias name ItmSrNo.
     * @return the value of ItmSrNo
     */
    public Integer getItmSrNo() {
        return (Integer) getAttributeInternal(ITMSRNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItmSrNo.
     * @param value value to set the ItmSrNo
     */
    public void setItmSrNo(Integer value) {
        setAttributeInternal(ITMSRNO, value);
    }

    /**
     * Gets the attribute value for ItmId, using the alias name ItmId.
     * @return the value of ItmId
     */
    public String getItmId() {
        return (String) getAttributeInternal(ITMID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItmId.
     * @param value value to set the ItmId
     */
    public void setItmId(String value) {
        setAttributeInternal(ITMID, value);
    }

    /**
     * Gets the attribute value for DlvSchdlNo, using the alias name DlvSchdlNo.
     * @return the value of DlvSchdlNo
     */
    public Integer getDlvSchdlNo() {
        return (Integer) getAttributeInternal(DLVSCHDLNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for DlvSchdlNo.
     * @param value value to set the DlvSchdlNo
     */
    public void setDlvSchdlNo(Integer value) {
        setAttributeInternal(DLVSCHDLNO, value);
    }

    /**
     * Gets the attribute value for DlvDt, using the alias name DlvDt.
     * @return the value of DlvDt
     */
    public Timestamp getDlvDt() {
        return (Timestamp) getAttributeInternal(DLVDT);
    }

    /**
     * Sets <code>value</code> as the attribute value for DlvDt.
     * @param value value to set the DlvDt
     */
    public void setDlvDt(Timestamp value) {
        setAttributeInternal(DLVDT, value);
    }

    /**
     * Gets the attribute value for TotQty, using the alias name TotQty.
     * @return the value of TotQty
     */
    public oracle.jbo.domain.Number getTotQty() {
        return (oracle.jbo.domain.Number) getAttributeInternal(TOTQTY);
    }

    /**
     * Sets <code>value</code> as the attribute value for TotQty.
     * @param value value to set the TotQty
     */
    public void setTotQty(oracle.jbo.domain.Number value) {
        setAttributeInternal(TOTQTY, value);
    }

    /**
     * Gets the attribute value for WhId, using the alias name WhId.
     * @return the value of WhId
     */
    public String getWhId() {
        return (String) getAttributeInternal(WHID);
    }

    /**
     * Sets <code>value</code> as the attribute value for WhId.
     * @param value value to set the WhId
     */
    public void setWhId(String value) {
        setAttributeInternal(WHID, value);
    }

    /**
     * Gets the attribute value for ItmUomBs, using the alias name ItmUomBs.
     * @return the value of ItmUomBs
     */
    public String getItmUomBs() {
        return (String) getAttributeInternal(ITMUOMBS);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItmUomBs.
     * @param value value to set the ItmUomBs
     */
    public void setItmUomBs(String value) {
        setAttributeInternal(ITMUOMBS, value);
    }

    /**
     * Gets the attribute value for ItmUomSp, using the alias name ItmUomSp.
     * @return the value of ItmUomSp
     */
    public String getItmUomSp() {
        return (String) getAttributeInternal(ITMUOMSP);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItmUomSp.
     * @param value value to set the ItmUomSp
     */
    public void setItmUomSp(String value) {
        setAttributeInternal(ITMUOMSP, value);
    }

    /**
     * Gets the attribute value for UsrIdCreate, using the alias name UsrIdCreate.
     * @return the value of UsrIdCreate
     */
    public Integer getUsrIdCreate() {
        return (Integer) getAttributeInternal(USRIDCREATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for UsrIdCreate.
     * @param value value to set the UsrIdCreate
     */
    public void setUsrIdCreate(Integer value) {
        setAttributeInternal(USRIDCREATE, value);
    }

    /**
     * Gets the attribute value for UsrIdCreateDt, using the alias name UsrIdCreateDt.
     * @return the value of UsrIdCreateDt
     */
    public Timestamp getUsrIdCreateDt() {
        return (Timestamp) getAttributeInternal(USRIDCREATEDT);
    }

    /**
     * Sets <code>value</code> as the attribute value for UsrIdCreateDt.
     * @param value value to set the UsrIdCreateDt
     */
    public void setUsrIdCreateDt(Timestamp value) {
        setAttributeInternal(USRIDCREATEDT, value);
    }

    /**
     * Gets the attribute value for UsrIdMod, using the alias name UsrIdMod.
     * @return the value of UsrIdMod
     */
    public Integer getUsrIdMod() {
        return (Integer) getAttributeInternal(USRIDMOD);
    }

    /**
     * Sets <code>value</code> as the attribute value for UsrIdMod.
     * @param value value to set the UsrIdMod
     */
    public void setUsrIdMod(Integer value) {
        setAttributeInternal(USRIDMOD, value);
    }

    /**
     * Gets the attribute value for UsrIdModDt, using the alias name UsrIdModDt.
     * @return the value of UsrIdModDt
     */
    public Timestamp getUsrIdModDt() {
        return (Timestamp) getAttributeInternal(USRIDMODDT);
    }

    /**
     * Sets <code>value</code> as the attribute value for UsrIdModDt.
     * @param value value to set the UsrIdModDt
     */
    public void setUsrIdModDt(Timestamp value) {
        setAttributeInternal(USRIDMODDT, value);
    }


    /**
     * Gets the attribute value for DlvQty, using the alias name DlvQty.
     * @return the value of DlvQty
     */
    public Number getDlvQty() {
        return (Number) getAttributeInternal(DLVQTY);
    }

    /**
     * Sets <code>value</code> as the attribute value for DlvQty.
     * @param value value to set the DlvQty
     */
    public void setDlvQty(Number value) {
        setAttributeInternal(DLVQTY, value);
    }


    /**
     * Gets the attribute value for SchdlDt, using the alias name SchdlDt.
     * @return the value of SchdlDt
     */
    public Timestamp getSchdlDt() {
        return (Timestamp) getAttributeInternal(SCHDLDT);
    }

    /**
     * Sets <code>value</code> as the attribute value for SchdlDt.
     * @param value value to set the SchdlDt
     */
    public void setSchdlDt(Timestamp value) {
        setAttributeInternal(SCHDLDT, value);
    }

    /**
     * Gets the attribute value for ColorAttGrpId, using the alias name ColorAttGrpId.
     * @return the value of ColorAttGrpId
     */
    public String getColorAttGrpId() {
        return (String) getAttributeInternal(COLORATTGRPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ColorAttGrpId.
     * @param value value to set the ColorAttGrpId
     */
    public void setColorAttGrpId(String value) {
        setAttributeInternal(COLORATTGRPID, value);
    }

    /**
     * Gets the attribute value for ItmFlag, using the alias name ItmFlag.
     * @return the value of ItmFlag
     */
    public String getItmFlag() {
        return (String) getAttributeInternal(ITMFLAG);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItmFlag.
     * @param value value to set the ItmFlag
     */
    public void setItmFlag(String value) {
        setAttributeInternal(ITMFLAG, value);
    }


    /**
     * Gets the attribute value for AvlStk, using the alias name AvlStk.
     * @return the value of AvlStk
     */
    public Number getAvlStk() {
        return (Number) getAttributeInternal(AVLSTK);
    }

    /**
     * Sets <code>value</code> as the attribute value for AvlStk.
     * @param value value to set the AvlStk
     */
    public void setAvlStk(Number value) {
        setAttributeInternal(AVLSTK, value);
    }

    /**
     * Gets the attribute value for UnpstdStk, using the alias name UnpstdStk.
     * @return the value of UnpstdStk
     */
    public Number getUnpstdStk() {
        return (Number) getAttributeInternal(UNPSTDSTK);
    }

    /**
     * Sets <code>value</code> as the attribute value for UnpstdStk.
     * @param value value to set the UnpstdStk
     */
    public void setUnpstdStk(Number value) {
        setAttributeInternal(UNPSTDSTK, value);
    }

    /**
     * Gets the attribute value for WipStk, using the alias name WipStk.
     * @return the value of WipStk
     */
    public Number getWipStk() {
        return (Number) getAttributeInternal(WIPSTK);
    }

    /**
     * Sets <code>value</code> as the attribute value for WipStk.
     * @param value value to set the WipStk
     */
    public void setWipStk(Number value) {
        setAttributeInternal(WIPSTK, value);
    }


    /**
     * Gets the attribute value for ItmCbm, using the alias name ItmCbm.
     * @return the value of ItmCbm
     */
    public Number getItmCbm() {
        return (Number) getAttributeInternal(ITMCBM);
    }

    /**
     * Sets <code>value</code> as the attribute value for ItmCbm.
     * @param value value to set the ItmCbm
     */
    public void setItmCbm(Number value) {
        setAttributeInternal(ITMCBM, value);
    }


  /**
   * Gets the attribute value for BtoDocId, using the alias name BtoDocId.
   * @return the value of BtoDocId
   */
  public String getBtoDocId()
  {
    return (String) getAttributeInternal(BTODOCID);
  }

  /**
   * Sets <code>value</code> as the attribute value for BtoDocId.
   * @param value value to set the BtoDocId
   */
  public void setBtoDocId(String value)
  {
    setAttributeInternal(BTODOCID, value);
  }


  /**
   * @param cldId key constituent
   * @param slocId key constituent
   * @param orgId key constituent
   * @param hoOrgId key constituent
   * @param docId key constituent
   * @param srcDocId key constituent
   * @param itmSrNo key constituent
   * @param itmId key constituent
   * @param whId key constituent

   * @return a Key object based on given key constituents.
   */
  public static Key createPrimaryKey(String cldId, Integer slocId, String orgId, String hoOrgId, String docId,
                                     String srcDocId, Integer itmSrNo, String itmId, String whId)
  {
    return new Key(new Object[]
    {
      cldId, slocId, orgId, hoOrgId, docId, srcDocId, itmSrNo, itmId, whId
    });
  }

  /**
   * Add attribute defaulting logic in this method.
   * @param attributeList list of attribute names/values to initialize the row
   */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
      //  super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        super.doDML(operation, e);
    }
}

