package trnpbulkvhclreqapp.model.views.common;

import java.sql.Timestamp;

import oracle.jbo.Row;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Oct 13 15:01:03 IST 2023
// ---------------------------------------------------------------------
public interface TrnpBulkTrfViewVORow
  extends Row
{


  String getTransReqType();

  void setTransReqType(String param);

  String getTransReqTypeId();

  void setTransReqTypeId(String param);

  String getTransCageName();

  String getCageId();

  void setCageId(String param);

  String getTransVhclType();

  void setTransVhclType(String param);

  Integer getTransVhclTypeId();

  void setTransVhclTypeId(Integer param);

  String getTransChkSelect();

  void setTransChkSelect(String param);


  String getTransWhName();

  void setTransWhName(String value);
}

