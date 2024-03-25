package fun.pullock.incentive.core.dao.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompleteRecordDO {

    private Long id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long userId;

    private Long taskId;

    private Integer status;

    private String source;

    private String uniqueSourceId;

    private Integer afterCompleteType;

    private String afterCompleteRule;
}