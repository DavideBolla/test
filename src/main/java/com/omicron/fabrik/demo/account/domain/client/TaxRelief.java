
package com.omicron.fabrik.demo.account.domain.client;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaxRelief implements Serializable
{
	@JsonProperty("taxReliefId")
    private String taxReliefId;
	
	@JsonProperty("isCondoUpgrade")
    private Boolean isCondoUpgrade;
	
	@JsonProperty("creditorFiscalCode")
    private String creditorFiscalCode;
	
	@JsonProperty("beneficiaryType")
    private String beneficiaryType;
	
	@JsonProperty("naturalPersonBeneficiary")
    private NaturalPersonBeneficiary naturalPersonBeneficiary;
	
	@JsonProperty("legalPersonBeneficiary")
    private LegalPersonBeneficiary legalPersonBeneficiary;
	
    private final static long serialVersionUID = -7558769505353462270L;

    public String getTaxReliefId() {
        return taxReliefId;
    }

    public void setTaxReliefId(String taxReliefId) {
        this.taxReliefId = taxReliefId;
    }

    public TaxRelief withTaxReliefId(String taxReliefId) {
        this.taxReliefId = taxReliefId;
        return this;
    }

    public Boolean getIsCondoUpgrade() {
        return isCondoUpgrade;
    }

    public void setIsCondoUpgrade(Boolean isCondoUpgrade) {
        this.isCondoUpgrade = isCondoUpgrade;
    }

    public TaxRelief withIsCondoUpgrade(Boolean isCondoUpgrade) {
        this.isCondoUpgrade = isCondoUpgrade;
        return this;
    }

    public String getCreditorFiscalCode() {
        return creditorFiscalCode;
    }

    public void setCreditorFiscalCode(String creditorFiscalCode) {
        this.creditorFiscalCode = creditorFiscalCode;
    }

    public TaxRelief withCreditorFiscalCode(String creditorFiscalCode) {
        this.creditorFiscalCode = creditorFiscalCode;
        return this;
    }

    public String getBeneficiaryType() {
        return beneficiaryType;
    }

    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
    }

    public TaxRelief withBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType;
        return this;
    }

    public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
        return naturalPersonBeneficiary;
    }

    public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
        this.naturalPersonBeneficiary = naturalPersonBeneficiary;
    }

    public TaxRelief withNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
        this.naturalPersonBeneficiary = naturalPersonBeneficiary;
        return this;
    }

    public LegalPersonBeneficiary getLegalPersonBeneficiary() {
        return legalPersonBeneficiary;
    }

    public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
        this.legalPersonBeneficiary = legalPersonBeneficiary;
    }

    public TaxRelief withLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
        this.legalPersonBeneficiary = legalPersonBeneficiary;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TaxRelief.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("taxReliefId");
        sb.append('=');
        sb.append(((this.taxReliefId == null)?"<null>":this.taxReliefId));
        sb.append(',');
        sb.append("isCondoUpgrade");
        sb.append('=');
        sb.append(((this.isCondoUpgrade == null)?"<null>":this.isCondoUpgrade));
        sb.append(',');
        sb.append("creditorFiscalCode");
        sb.append('=');
        sb.append(((this.creditorFiscalCode == null)?"<null>":this.creditorFiscalCode));
        sb.append(',');
        sb.append("beneficiaryType");
        sb.append('=');
        sb.append(((this.beneficiaryType == null)?"<null>":this.beneficiaryType));
        sb.append(',');
        sb.append("naturalPersonBeneficiary");
        sb.append('=');
        sb.append(((this.naturalPersonBeneficiary == null)?"<null>":this.naturalPersonBeneficiary));
        sb.append(',');
        sb.append("legalPersonBeneficiary");
        sb.append('=');
        sb.append(((this.legalPersonBeneficiary == null)?"<null>":this.legalPersonBeneficiary));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.isCondoUpgrade == null)? 0 :this.isCondoUpgrade.hashCode()));
        result = ((result* 31)+((this.creditorFiscalCode == null)? 0 :this.creditorFiscalCode.hashCode()));
        result = ((result* 31)+((this.legalPersonBeneficiary == null)? 0 :this.legalPersonBeneficiary.hashCode()));
        result = ((result* 31)+((this.taxReliefId == null)? 0 :this.taxReliefId.hashCode()));
        result = ((result* 31)+((this.beneficiaryType == null)? 0 :this.beneficiaryType.hashCode()));
        result = ((result* 31)+((this.naturalPersonBeneficiary == null)? 0 :this.naturalPersonBeneficiary.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TaxRelief) == false) {
            return false;
        }
        TaxRelief rhs = ((TaxRelief) other);
        return (((((((this.isCondoUpgrade == rhs.isCondoUpgrade)||((this.isCondoUpgrade!= null)&&this.isCondoUpgrade.equals(rhs.isCondoUpgrade)))&&((this.creditorFiscalCode == rhs.creditorFiscalCode)||((this.creditorFiscalCode!= null)&&this.creditorFiscalCode.equals(rhs.creditorFiscalCode))))&&((this.legalPersonBeneficiary == rhs.legalPersonBeneficiary)||((this.legalPersonBeneficiary!= null)&&this.legalPersonBeneficiary.equals(rhs.legalPersonBeneficiary))))&&((this.taxReliefId == rhs.taxReliefId)||((this.taxReliefId!= null)&&this.taxReliefId.equals(rhs.taxReliefId))))&&((this.beneficiaryType == rhs.beneficiaryType)||((this.beneficiaryType!= null)&&this.beneficiaryType.equals(rhs.beneficiaryType))))&&((this.naturalPersonBeneficiary == rhs.naturalPersonBeneficiary)||((this.naturalPersonBeneficiary!= null)&&this.naturalPersonBeneficiary.equals(rhs.naturalPersonBeneficiary))));
    }

}
