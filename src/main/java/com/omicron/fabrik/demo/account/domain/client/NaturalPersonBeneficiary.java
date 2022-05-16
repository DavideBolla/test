
package com.omicron.fabrik.demo.account.domain.client;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NaturalPersonBeneficiary implements Serializable
{
	@JsonProperty("fiscalCode1")
    private String fiscalCode1;
	
	@JsonProperty("fiscalCode2")
    private String fiscalCode2;
	
	@JsonProperty("fiscalCode3")
    private String fiscalCode3;
	
	@JsonProperty("fiscalCode4")
    private String fiscalCode4;
	
	@JsonProperty("fiscalCode5")
    private String fiscalCode5;
	
    private final static long serialVersionUID = -2551181083015172492L;

    public String getFiscalCode1() {
        return fiscalCode1;
    }

    public void setFiscalCode1(String fiscalCode1) {
        this.fiscalCode1 = fiscalCode1;
    }

    public NaturalPersonBeneficiary withFiscalCode1(String fiscalCode1) {
        this.fiscalCode1 = fiscalCode1;
        return this;
    }

    public String getFiscalCode2() {
        return fiscalCode2;
    }

    public void setFiscalCode2(String fiscalCode2) {
        this.fiscalCode2 = fiscalCode2;
    }

    public NaturalPersonBeneficiary withFiscalCode2(String fiscalCode2) {
        this.fiscalCode2 = fiscalCode2;
        return this;
    }

    public String getFiscalCode3() {
        return fiscalCode3;
    }

    public void setFiscalCode3(String fiscalCode3) {
        this.fiscalCode3 = fiscalCode3;
    }

    public NaturalPersonBeneficiary withFiscalCode3(String fiscalCode3) {
        this.fiscalCode3 = fiscalCode3;
        return this;
    }

    public String getFiscalCode4() {
        return fiscalCode4;
    }

    public void setFiscalCode4(String fiscalCode4) {
        this.fiscalCode4 = fiscalCode4;
    }

    public NaturalPersonBeneficiary withFiscalCode4(String fiscalCode4) {
        this.fiscalCode4 = fiscalCode4;
        return this;
    }

    public String getFiscalCode5() {
        return fiscalCode5;
    }

    public void setFiscalCode5(String fiscalCode5) {
        this.fiscalCode5 = fiscalCode5;
    }

    public NaturalPersonBeneficiary withFiscalCode5(String fiscalCode5) {
        this.fiscalCode5 = fiscalCode5;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NaturalPersonBeneficiary.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("fiscalCode1");
        sb.append('=');
        sb.append(((this.fiscalCode1 == null)?"<null>":this.fiscalCode1));
        sb.append(',');
        sb.append("fiscalCode2");
        sb.append('=');
        sb.append(((this.fiscalCode2 == null)?"<null>":this.fiscalCode2));
        sb.append(',');
        sb.append("fiscalCode3");
        sb.append('=');
        sb.append(((this.fiscalCode3 == null)?"<null>":this.fiscalCode3));
        sb.append(',');
        sb.append("fiscalCode4");
        sb.append('=');
        sb.append(((this.fiscalCode4 == null)?"<null>":this.fiscalCode4));
        sb.append(',');
        sb.append("fiscalCode5");
        sb.append('=');
        sb.append(((this.fiscalCode5 == null)?"<null>":this.fiscalCode5));
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
        result = ((result* 31)+((this.fiscalCode1 == null)? 0 :this.fiscalCode1 .hashCode()));
        result = ((result* 31)+((this.fiscalCode2 == null)? 0 :this.fiscalCode2 .hashCode()));
        result = ((result* 31)+((this.fiscalCode3 == null)? 0 :this.fiscalCode3 .hashCode()));
        result = ((result* 31)+((this.fiscalCode4 == null)? 0 :this.fiscalCode4 .hashCode()));
        result = ((result* 31)+((this.fiscalCode5 == null)? 0 :this.fiscalCode5 .hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NaturalPersonBeneficiary) == false) {
            return false;
        }
        NaturalPersonBeneficiary rhs = ((NaturalPersonBeneficiary) other);
        return ((((((this.fiscalCode1 == rhs.fiscalCode1)||((this.fiscalCode1 != null)&&this.fiscalCode1 .equals(rhs.fiscalCode1)))&&((this.fiscalCode2 == rhs.fiscalCode2)||((this.fiscalCode2 != null)&&this.fiscalCode2 .equals(rhs.fiscalCode2))))&&((this.fiscalCode3 == rhs.fiscalCode3)||((this.fiscalCode3 != null)&&this.fiscalCode3 .equals(rhs.fiscalCode3))))&&((this.fiscalCode4 == rhs.fiscalCode4)||((this.fiscalCode4 != null)&&this.fiscalCode4 .equals(rhs.fiscalCode4))))&&((this.fiscalCode5 == rhs.fiscalCode5)||((this.fiscalCode5 != null)&&this.fiscalCode5 .equals(rhs.fiscalCode5))));
    }

}
