
package com.omicron.fabrik.demo.account.domain.client.response;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionsPayload implements Serializable
{
	@JsonProperty("list")
    private java.util.List<Transaction> list = null;
	
	@JsonProperty("status")
    private String status = null;
    
    private final static long serialVersionUID = 2959801660161675154L;

    public TransactionsPayload withList(java.util.List<Transaction> transaction) {
        this.list = transaction;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TransactionsPayload.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("list");
        sb.append('=');
        sb.append(((this.list == null)?"<null>":this.list));
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
        result = ((result* 31)+((this.list == null)? 0 :this.list.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionsPayload) == false) {
            return false;
        }
        TransactionsPayload rhs = ((TransactionsPayload) other);
        return ((this.list == rhs.list)||((this.list!= null)&&this.list.equals(rhs.list)));
    }

}
