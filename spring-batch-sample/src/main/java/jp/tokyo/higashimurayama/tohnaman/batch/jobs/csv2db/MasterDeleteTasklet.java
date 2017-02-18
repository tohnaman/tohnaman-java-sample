package jp.tokyo.higashimurayama.tohnaman.batch.jobs.csv2db;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import jp.tokyo.higashimurayama.tohnaman.batch.mybatis.mapper.MstAddressMapper;

/**
 * マスタ削除用Tasklet<br>
 */
public class MasterDeleteTasklet implements Tasklet {

	@Autowired
	private MstAddressMapper mstAddressMapper;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		this.mstAddressMapper.deleteByExample(null);
		return RepeatStatus.FINISHED;
	}
}
