package trnpbulkvhclreqapp.model.views;

import java.sql.ResultSet;

import java.sql.Timestamp;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;
import oracle.jbo.server.ViewRowSetImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Oct 13 15:01:03 IST 2023
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TrnpBulkTrfViewVOImpl
  extends ViewObjectImpl
{
  /**
   * This is the default constructor (do not remove).
   */
  public TrnpBulkTrfViewVOImpl()
  {
  }

  /**
   * Returns the bind variable value for BindCldId.
   * @return bind variable value for BindCldId
   */
  public String getBindCldId()
  {
    return (String) getNamedWhereClauseParam("BindCldId");
  }

  /**
   * Sets <code>value</code> for bind variable BindCldId.
   * @param value value to bind as BindCldId
   */
  public void setBindCldId(String value)
  {
    setNamedWhereClauseParam("BindCldId", value);
  }

  /**
   * Returns the bind variable value for BindSlocId.
   * @return bind variable value for BindSlocId
   */
  public Integer getBindSlocId()
  {
    return (Integer) getNamedWhereClauseParam("BindSlocId");
  }

  /**
   * Sets <code>value</code> for bind variable BindSlocId.
   * @param value value to bind as BindSlocId
   */
  public void setBindSlocId(Integer value)
  {
    setNamedWhereClauseParam("BindSlocId", value);
  }

  /**
   * Returns the bind variable value for BindDocId.
   * @return bind variable value for BindDocId
   */
  public String getBindDocId()
  {
    return (String) getNamedWhereClauseParam("BindDocId");
  }

  /**
   * Sets <code>value</code> for bind variable BindDocId.
   * @param value value to bind as BindDocId
   */
  public void setBindDocId(String value)
  {
    setNamedWhereClauseParam("BindDocId", value);
  }

  /**
   * Returns the bind variable value for BindOrgId.
   * @return bind variable value for BindOrgId
   */
  public String getBindOrgId()
  {
    return (String) getNamedWhereClauseParam("BindOrgId");
  }

  /**
   * Sets <code>value</code> for bind variable BindOrgId.
   * @param value value to bind as BindOrgId
   */
  public void setBindOrgId(String value)
  {
    setNamedWhereClauseParam("BindOrgId", value);
  }

  /**
   * executeQueryForCollection - overridden for custom java data source support.
   */
  @Override
  protected void executeQueryForCollection(Object qc, Object[] params, int noUserParams)
  {
    super.executeQueryForCollection(qc, params, noUserParams);
  }

  /**
   * hasNextForCollection - overridden for custom java data source support.
   */
  @Override
  protected boolean hasNextForCollection(Object qc)
  {
    boolean bRet = super.hasNextForCollection(qc);
    return bRet;
  }

  /**
   * createRowFromResultSet - overridden for custom java data source support.
   */
  @Override
  protected ViewRowImpl createRowFromResultSet(Object qc, ResultSet resultSet)
  {
    ViewRowImpl value = super.createRowFromResultSet(qc, resultSet);
    return value;
  }

  /**
   * getQueryHitCount - overridden for custom java data source support.
   */
  @Override
  public long getQueryHitCount(ViewRowSetImpl viewRowSet)
  {
    long value = super.getQueryHitCount(viewRowSet);
    return value;
  }

  /**
   * getCappedQueryHitCount - overridden for custom java data source support.
   */
  @Override
  public long getCappedQueryHitCount(ViewRowSetImpl viewRowSet, Row[] masterRows, long oldCap, long cap)
  {
    long value = super.getCappedQueryHitCount(viewRowSet, masterRows, oldCap, cap);
    return value;
  }

  /**
   * Returns the bind variable value for BindStDt.
   * @return bind variable value for BindStDt
   */
  public Timestamp getBindStDt()
  {
    return (Timestamp) getNamedWhereClauseParam("BindStDt");
  }

  /**
   * Sets <code>value</code> for bind variable BindStDt.
   * @param value value to bind as BindStDt
   */
  public void setBindStDt(Timestamp value)
  {
    setNamedWhereClauseParam("BindStDt", value);
  }

  /**
   * Returns the bind variable value for BindEndDt.
   * @return bind variable value for BindEndDt
   */
  public Timestamp getBindEndDt()
  {
    return (Timestamp) getNamedWhereClauseParam("BindEndDt");
  }

  /**
   * Sets <code>value</code> for bind variable BindEndDt.
   * @param value value to bind as BindEndDt
   */
  public void setBindEndDt(Timestamp value)
  {
    setNamedWhereClauseParam("BindEndDt", value);
  }
}

