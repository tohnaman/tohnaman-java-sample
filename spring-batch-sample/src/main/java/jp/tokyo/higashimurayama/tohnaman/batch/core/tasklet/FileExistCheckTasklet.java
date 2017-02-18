package jp.tokyo.higashimurayama.tohnaman.batch.core.tasklet;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

/**
 * ファイル存在チェック用Tasklet<br>
 * <br>
 * ファイルが存在しない場合は、ExitStatusにNOT_EXISTを設定
 */
public class FileExistCheckTasklet implements Tasklet, InitializingBean {

	/** ファイルが存在しない場合のExitStatus */
	public static final String NOT_EXIST = "NOT_EXIST";

	/** ファイルパス */
	private String filePath;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		if (!Files.exists(Paths.get(filePath))) {
			contribution.setExitStatus(new ExitStatus(NOT_EXIST));
		}
		return RepeatStatus.FINISHED;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(filePath, "ファイルパスは必須です。");
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
