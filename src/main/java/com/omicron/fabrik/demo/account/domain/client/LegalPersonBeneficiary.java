
package com.omicron.fabrik.demo.account.domain.client;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LegalPersonBeneficiary implements Serializable
{
	@JsonProperty(value = "fiscalCode", required = true)
    private String fiscalCode;
	
	@JsonProperty("legalRepresentativeFiscalCode")
    private String legalRepresentativeFiscalCode;
	
    private final static long serialVersionUID = -7594510300569472455L;

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public LegalPersonBeneficiary withFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
        return this;
    }

    public String getLegalRepresentativeFiscalCode() {
        return legalRepresentativeFiscalCode;
    }

    public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
        this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
    }

    public LegalPersonBeneficiary withLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
        this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LegalPersonBeneficiary.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("fiscalCode");
        sb.append('=');
        sb.append(((this.fiscalCode == null)?"<null>":this.fiscalCode));
        sb.append(',');
        sb.append("legalRepresentativeFiscalCode");
        sb.append('=');
        sb.append(((this.legalRepresentativeFiscalCode == null)?"<null>":this.legalRepresentativeFiscalCode));
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
        result = ((result* 31)+((this.fiscalCode == null)? 0 :this.fiscalCode.hashCode()));
        result = ((result* 31)+((this.legalRepresentativeFiscalCode == null)? 0 :this.legalRepresentativeFiscalCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LegalPersonBeneficiary) == false) {
            return false;
        }
        LegalPersonBeneficiary rhs = ((LegalPersonBeneficiary) other);
        return (((this.fiscalCode == rhs.fiscalCode)||((this.fiscalCode!= null)&&this.fiscalCode.equals(rhs.fiscalCode)))&&((this.legalRepresentativeFiscalCode == rhs.legalRepresentativeFiscalCode)||((this.legalRepresentativeFiscalCode!= null)&&this.legalRepresentativeFiscalCode.equals(rhs.legalRepresentativeFiscalCode))));
    }

}
