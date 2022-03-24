package com.hepsiemlak.favoriteservice.model.error;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Data
public class ErrorDto implements Serializable {

    private String title;
    private int status;
    private String detail;
    private String message;
    private String requestUri;
    private String requestMethod;
    private String instant;
    private List<ErrorDetailDto> errorDetails = new ArrayList<>();

    @Override
    public String toString() {
        return new ToStringBuilder(this, SHORT_PREFIX_STYLE)
                .append("title", title)
                .append("status", status)
                .append("detail", detail)
                .append("message", message)
                .append("requestUri", requestUri)
                .append("requestMethod", requestMethod)
                .append("instant", instant)
                .append("errorDetails", errorDetails)
                .toString();
    }

}
