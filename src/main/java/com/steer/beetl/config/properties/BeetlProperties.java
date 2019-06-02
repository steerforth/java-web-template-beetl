package com.steer.beetl.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = BeetlProperties.BEETLCONF_PREFIX)
public class BeetlProperties {
    public static final String BEETLCONF_PREFIX = "beetl";

    private String delimiterStatementStart;

    private String delimiterStatementEnd;

    private String resourceTagroot;

    private String resourceTagsuffix;

    private String resourceAutoCheck;

    private String webappExt;

    private String errorHandler;

    @Value("${spring.mvc.view.prefix}")
    private String prefix;

    public Properties getProperties() {
        Properties properties = new Properties();
//        if (ToolUtil.isNotEmpty(delimiterStatementStart)) {
//            if (delimiterStatementStart.startsWith("\\")) {
//                delimiterStatementStart = delimiterStatementStart.substring(1);
//            }else {
//                properties.setProperty("DELIMITER_STATEMENT_START", delimiterStatementStart);
//            }
//        }
//        if (ToolUtil.isNotEmpty(delimiterStatementEnd)) {
//            properties.setProperty("DELIMITER_STATEMENT_END", delimiterStatementEnd);
//        } else {
//            properties.setProperty("DELIMITER_STATEMENT_END", "null");
//        }
//        if (ToolUtil.isNotEmpty(resourceTagroot)) {
            properties.setProperty("RESOURCE.tagRoot", resourceTagroot);
//        }
//        if (ToolUtil.isNotEmpty(resourceTagsuffix)) {
            properties.setProperty("RESOURCE.tagSuffix", resourceTagsuffix);
//        }
//        if (ToolUtil.isNotEmpty(resourceAutoCheck)) {
//            properties.setProperty("RESOURCE.autoCheck", resourceAutoCheck);
//        }
        properties.setProperty("WEBAPP_EXT",webappExt);

        properties.setProperty("ERROR_HANDLER",errorHandler);
        return properties;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDelimiterStatementStart() {
        return delimiterStatementStart;
    }

    public void setDelimiterStatementStart(String delimiterStatementStart) {
        this.delimiterStatementStart = delimiterStatementStart;
    }

    public String getDelimiterStatementEnd() {
        return delimiterStatementEnd;
    }

    public void setDelimiterStatementEnd(String delimiterStatementEnd) {
        this.delimiterStatementEnd = delimiterStatementEnd;
    }

    public String getResourceTagroot() {
        return resourceTagroot;
    }

    public void setResourceTagroot(String resourceTagroot) {
        this.resourceTagroot = resourceTagroot;
    }

    public String getResourceTagsuffix() {
        return resourceTagsuffix;
    }

    public void setResourceTagsuffix(String resourceTagsuffix) {
        this.resourceTagsuffix = resourceTagsuffix;
    }

    public String getResourceAutoCheck() {
        return resourceAutoCheck;
    }

    public String getWebappExt() {
        return webappExt;
    }

    public void setWebappExt(String webappExt) {
        this.webappExt = webappExt;
    }

    public void setResourceAutoCheck(String resourceAutoCheck) {
        this.resourceAutoCheck = resourceAutoCheck;
    }

    public String getErrorHandler() {
        return errorHandler;
    }

    public void setErrorHandler(String errorHandler) {
        this.errorHandler = errorHandler;
    }
}

