package com.hepsiemlak.packageservice.model.error;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Data
public class ErrorDetailDto implements Serializable {

    private String errorCode;
    private String errorMessage;

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append("errorCode", errorCode)
                .append("errorMessage", errorMessage)
                .toString();
    }
}
