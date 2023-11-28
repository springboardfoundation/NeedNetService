package org.springboardfoundation.common.dto.need;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class NeedDto {
    private String title;
    private NeedType type;
    private String description;
    private Date startDate;
    private Date endDate;
    private List<String> files;
    private String additionalInfo;
    private NeedStatus status;
}