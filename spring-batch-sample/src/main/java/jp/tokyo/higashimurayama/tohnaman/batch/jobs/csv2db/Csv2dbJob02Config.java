package jp.tokyo.higashimurayama.tohnaman.batch.jobs.csv2db;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.FileSystemResource;

import jp.tokyo.higashimurayama.tohnaman.batch.core.BatchContext;
import jp.tokyo.higashimurayama.tohnaman.batch.mybatis.model.MstAddress;

/**
 * CSVtoDBジョブの設定クラス
 */
@EnableBatchProcessing
@Import({ BatchContext.class })
public class Csv2dbJob02Config {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	@Autowired
	private FlatFileItemReader<AddressDto> addressReader;

	/**
	 * ジョブ
	 *
	 * @return
	 */
	@Bean
	public Job csv2dbJob() {
		// @formatter:off
		return jobBuilderFactory
				.get("csv2dbJob")
				.flow(csv2dbStep())
				.end()
				.build();
		// @formatter:on
	}

	/**
	 * ステップ
	 *
	 * @return
	 */
	@Bean
	public Step csv2dbStep() {
		// @formatter:off
		return stepBuilderFactory
				.get("csv2dbStep")
				.<AddressDto, MstAddress>chunk(1000)
				.reader(addressReader)
				.processor(csvToModelItemProcessor())
				.writer(addressWriter())
				.build();
		// @formatter:on
	}

	/**
	 * CSVファイルを読み込みAddressDtoを設定する
	 * 
	 * @return
	 */
	@Bean
	@StepScope
	public FlatFileItemReader<AddressDto> addressReader(@Value("#{jobParameters['csvFilePath']}") String csvFilePath) {
		FlatFileItemReader<AddressDto> reader = new FlatFileItemReader<>();
		reader.setResource(new FileSystemResource(csvFilePath));
		reader.setLinesToSkip(1);
		reader.setEncoding("Shift_JIS");

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "id", "prefCd", "cityCd", "townCd", "zip", "officeFlg", "deleteFlg",
				"prefName", "prefKana", "cityName", "cityKana", "townName", "townKana", "townMemo", "kyotoStreet",
				"azaName", "azaKana", "memo", "officeName", "officeKana", "officeAddress", "newId" });
		BeanWrapperFieldSetMapper<AddressDto> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(AddressDto.class);
		DefaultLineMapper<AddressDto> lineMapper = new DefaultLineMapper<>();
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		reader.setLineMapper(lineMapper);

		return reader;
	}

	/**
	 * AddressDtoをMstAddressに変換する
	 * 
	 * @return
	 */
	@Bean
	public CsvToModelItemProcessor csvToModelItemProcessor() {
		return new CsvToModelItemProcessor();
	}

	/**
	 * MstAddressをDBに登録する
	 * 
	 * @return
	 */
	@Bean
	public MyBatisBatchItemWriter<MstAddress> addressWriter() {
		MyBatisBatchItemWriter<MstAddress> writer = new MyBatisBatchItemWriter<>();
		writer.setStatementId("jp.tokyo.higashimurayama.tohnaman.batch.mybatis.mapper.MstAddressMapper.insert");
		writer.setSqlSessionFactory(sqlSessionFactory);
		return writer;
	}
}
