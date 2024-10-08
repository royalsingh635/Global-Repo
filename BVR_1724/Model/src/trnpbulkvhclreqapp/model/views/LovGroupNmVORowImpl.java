package trnpbulkvhclreqapp.model.views;

import java.math.BigInteger;

import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Jun 15 17:38:59 IST 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class LovGroupNmVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        EoCldId,
        EoMstId,
        EoHoOrgId,
        EoMstSlocId,
        EoMstNm;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return LovGroupNmVORowImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return LovGroupNmVORowImpl.AttributesEnum.firstIndex() +
                   LovGroupNmVORowImpl.AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = LovGroupNmVORowImpl.AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int EOCLDID = AttributesEnum.EoCldId.index();
    public static final int EOMSTID = AttributesEnum.EoMstId.index();
    public static final int EOHOORGID = AttributesEnum.EoHoOrgId.index();
    public static final int EOMSTSLOCID = AttributesEnum.EoMstSlocId.index();
    public static final int EOMSTNM = AttributesEnum.EoMstNm.index();

    /**
     * This is the default constructor (do not remove).
     */
    public LovGroupNmVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute EoCldId.
     * @return the EoCldId
     */
    public String getEoCldId() {
        return (String) getAttributeInternal(EOCLDID);
    }

    /**
     * Gets the attribute value for the calculated attribute EoMstId.
     * @return the EoMstId
     */
    public Integer getEoMstId() {
        return (Integer) getAttributeInternal(EOMSTID);
    }

    /**
     * Gets the attribute value for the calculated attribute EoHoOrgId.
     * @return the EoHoOrgId
     */
    public String getEoHoOrgId() {
        return (String) getAttributeInternal(EOHOORGID);
    }

    /**
     * Gets the attribute value for the calculated attribute EoMstSlocId.
     * @return the EoMstSlocId
     */
    public Integer getEoMstSlocId() {
        return (Integer) getAttributeInternal(EOMSTSLOCID);
    }

    /**
     * Gets the attribute value for the calculated attribute EoMstNm.
     * @return the EoMstNm
     */
    public String getEoMstNm() {
        return (String) getAttributeInternal(EOMSTNM);
    }
}

