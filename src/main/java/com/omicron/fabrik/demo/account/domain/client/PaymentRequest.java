
package com.omicron.fabrik.demo.account.domain.client;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequest implements Serializable {
	
    private final static long serialVersionUID = 6656459502880211632L;
    
	@JsonProperty("creditor")
    private Creditor creditor;
	
	@JsonProperty("executionDate")
    private String executionDate;
	
	@JsonProperty(value = "uri", required = true)
    private String uri;
	
	@JsonProperty("description")
    private String description;
	
	@JsonProperty("amount")
    private Double amount;
	
	@JsonProperty("currency")
    private String currency;
	
	@JsonProperty("isUrgent")
    private Boolean isUrgent;
	
	@JsonProperty("isInstant")
    private Boolean isInstant;
	
	@JsonProperty("feeType")
    private String feeType;
	
	@JsonProperty("feeAccountId")
    private String feeAccountId;
	
	@JsonProperty("taxRelief")
    private TaxRelief taxRelief;
	
	public PaymentRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public PaymentRequest(Creditor creditor, String executionDate, String uri, String description, Double amount,
			String currency, Boolean isUrgent, Boolean isInstant, String feeType, String feeAccountId,
			TaxRelief taxRelief) {
		super();
		this.creditor = creditor;
		this.executionDate = executionDate;
		this.uri = uri;
		this.description = description;
		this.amount = amount;
		this.currency = currency;
		this.isUrgent = isUrgent;
		this.isInstant = isInstant;
		this.feeType = feeType;
		this.feeAccountId = feeAccountId;
		this.taxRelief = taxRelief;
	}
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("creditor");
        sb.append('=');
        sb.append(((this.creditor == null)?"<null>":this.creditor));
        sb.append(',');
        sb.append("executionDate");
        sb.append('=');
        sb.append(((this.executionDate == null)?"<null>":this.executionDate));
        sb.append(',');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("amount");
        sb.append('=');
        sb.append(((this.amount == null)?"<null>":this.amount));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null)?"<null>":this.currency));
        sb.append(',');
        sb.append("isUrgent");
        sb.append('=');
        sb.append(((this.isUrgent == null)?"<null>":this.isUrgent));
        sb.append(',');
        sb.append("isInstant");
        sb.append('=');
        sb.append(((this.isInstant == null)?"<null>":this.isInstant));
        sb.append(',');
        sb.append("feeType");
        sb.append('=');
        sb.append(((this.feeType == null)?"<null>":this.feeType));
        sb.append(',');
        sb.append("feeAccountId");
        sb.append('=');
        sb.append(((this.feeAccountId == null)?"<null>":this.feeAccountId));
        sb.append(',');
        sb.append("taxRelief");
        sb.append('=');
        sb.append(((this.taxRelief == null)?"<null>":this.taxRelief));
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
        result = ((result* 31)+((this.isUrgent == null)? 0 :this.isUrgent.hashCode()));
        result = ((result* 31)+((this.amount == null)? 0 :this.amount.hashCode()));
        result = ((result* 31)+((this.taxRelief == null)? 0 :this.taxRelief.hashCode()));
        result = ((result* 31)+((this.feeAccountId == null)? 0 :this.feeAccountId.hashCode()));
        result = ((result* 31)+((this.executionDate == null)? 0 :this.executionDate.hashCode()));
        result = ((result* 31)+((this.isInstant == null)? 0 :this.isInstant.hashCode()));
        result = ((result* 31)+((this.description == null)? 0 :this.description.hashCode()));
        result = ((result* 31)+((this.creditor == null)? 0 :this.creditor.hashCode()));
        result = ((result* 31)+((this.currency == null)? 0 :this.currency.hashCode()));
        result = ((result* 31)+((this.feeType == null)? 0 :this.feeType.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PaymentRequest) == false) {
            return false;
        }
        PaymentRequest rhs = ((PaymentRequest) other);
        return ((((((((((((this.isUrgent == rhs.isUrgent)||((this.isUrgent!= null)&&this.isUrgent.equals(rhs.isUrgent)))&&((this.amount == rhs.amount)||((this.amount!= null)&&this.amount.equals(rhs.amount))))&&((this.taxRelief == rhs.taxRelief)||((this.taxRelief!= null)&&this.taxRelief.equals(rhs.taxRelief))))&&((this.feeAccountId == rhs.feeAccountId)||((this.feeAccountId!= null)&&this.feeAccountId.equals(rhs.feeAccountId))))&&((this.executionDate == rhs.executionDate)||((this.executionDate!= null)&&this.executionDate.equals(rhs.executionDate))))&&((this.isInstant == rhs.isInstant)||((this.isInstant!= null)&&this.isInstant.equals(rhs.isInstant))))&&((this.description == rhs.description)||((this.description!= null)&&this.description.equals(rhs.description))))&&((this.creditor == rhs.creditor)||((this.creditor!= null)&&this.creditor.equals(rhs.creditor))))&&((this.currency == rhs.currency)||((this.currency!= null)&&this.currency.equals(rhs.currency))))&&((this.feeType == rhs.feeType)||((this.feeType!= null)&&this.feeType.equals(rhs.feeType))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))));
    }

}
