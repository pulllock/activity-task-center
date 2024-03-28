package fun.pullock.incentive.core.strategy.task.complete.limit;

import fun.pullock.incentive.core.enums.CompleteLimitType;
import fun.pullock.incentive.core.model.dto.CompleteRecordDTO;
import fun.pullock.incentive.core.service.CompleteRecordService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import static fun.pullock.incentive.core.enums.CompleteLimitType.WEEK;

@Component
public class CompleteLimitWeekHandler implements CompleteLimitHandler {

    @Resource
    private CompleteRecordService completeRecordService;

    @Override
    public CompleteLimitType type() {
        return WEEK;
    }

    @Override
    public Boolean reachLimit(CompleteLimitContext context) {
        LocalDate today = context.getNow().toLocalDate();
        LocalDate startDay = today.with(TemporalAdjusters.previous(DayOfWeek.MONDAY))
                .minusWeeks(context.getTask().getCompleteLimitRule().getPeriod() - 1);

        List<CompleteRecordDTO> records = completeRecordService.queryByUserTaskDateRange(
                context.getUserId(),
                context.getTask().getId(),
                startDay,
                today
        );

        return records.size() >= context.getTask().getCompleteLimitRule().getTimes();
    }
}
