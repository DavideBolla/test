
package com.omicron.fabrik.demo.account.domain.client.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ApiGenericResponse implements Serializable
{

    private String status;
    private List<Error> errors = new ArrayList<>();
    private final static long serialVersionUID = -5140159134544666359L;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ApiGenericResponse withStatus(String status) {
        this.status = status;
        return this;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public ApiGenericResponse withErrors(List<Error> errors) {
        this.errors = errors;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ApiGenericResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("errors");
        sb.append('=');
        sb.append(((this.errors == null)?"<null>":this.errors));
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
        result = ((result* 31)+((this.errors == null)? 0 :this.errors.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ApiGenericResponse) == false) {
            return false;
        }
        ApiGenericResponse rhs = ((ApiGenericResponse) other);
        return (((this.errors == rhs.errors)||((this.errors!= null)&&this.errors.equals(rhs.errors))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status)));
    }
}
