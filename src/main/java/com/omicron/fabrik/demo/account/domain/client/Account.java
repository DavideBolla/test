
package com.omicron.fabrik.demo.account.domain.client;

import java.io.Serializable;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account implements Serializable
{
	@JsonProperty("accountCode")
    private String accountCode;
	
	@JsonProperty("bicCode")
    private String bicCode;
	
    private final static long serialVersionUID = -2382688108060759568L;

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Account withAccountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

    public Account withBicCode(String bicCode) {
        this.bicCode = bicCode;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Account.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accountCode");
        sb.append('=');
        sb.append(((this.accountCode == null)?"<null>":this.accountCode));
        sb.append(',');
        sb.append("bicCode");
        sb.append('=');
        sb.append(((this.bicCode == null)?"<null>":this.bicCode));
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
        result = ((result* 31)+((this.accountCode == null)? 0 :this.accountCode.hashCode()));
        result = ((result* 31)+((this.bicCode == null)? 0 :this.bicCode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Account) == false) {
            return false;
        }
        Account rhs = ((Account) other);
        return (((this.accountCode == rhs.accountCode)||((this.accountCode!= null)&&this.accountCode.equals(rhs.accountCode)))&&((this.bicCode == rhs.bicCode)||((this.bicCode!= null)&&this.bicCode.equals(rhs.bicCode))));
    }

}
