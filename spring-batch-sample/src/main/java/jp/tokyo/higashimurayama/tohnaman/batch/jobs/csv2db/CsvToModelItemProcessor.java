package jp.tokyo.higashimurayama.tohnaman.batch.jobs.csv2db;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;

import jp.tokyo.higashimurayama.tohnaman.batch.mybatis.model.MstAddress;

/**
 * AddressDtoをMstAddressに変換クラス<br>
 * <br>
 * 以下のルールで変換する
 * <ul>
 * <li>市区町村名が東村山市以外は無視する</li>
 * <li>郵便番号のハイフンを削除する</li>
 * </ul>
 */
public class CsvToModelItemProcessor implements ItemProcessor<AddressDto, MstAddress> {

	@Override
	public MstAddress process(AddressDto item) throws Exception {
		MstAddress output = null;
		String cityName = item.getCityName();
		if (cityName.equals("東村山市")) {
			output = new MstAddress();
			BeanUtils.copyProperties(item, output);
			output.setZip(item.getZip().replace("-", ""));
		}
		return output;
	}
}
