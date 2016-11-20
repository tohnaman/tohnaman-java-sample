package jp.tokyo.higashimurayama.tohnaman.batch.jobs.csv2db;

import java.io.Serializable;

/**
 * CSVファイルの内容を格納するクラス
 */
public class AddressDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer prefCd;
	private Integer cityCd;
	private Integer townCd;
	private String zip;
	private Integer officeFlg;
	private Integer deleteFlg;
	private String prefName;
	private String prefKana;
	private String cityName;
	private String cityKana;
	private String townName;
	private String townKana;
	private String townMemo;
	private String kyotoStreet;
	private String azaName;
	private String azaKana;
	private String memo;
	private String officeName;
	private String officeKana;
	private String officeAddress;
	private Integer newId;
	private String registDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrefCd() {
		return prefCd;
	}

	public void setPrefCd(Integer prefCd) {
		this.prefCd = prefCd;
	}

	public Integer getCityCd() {
		return cityCd;
	}

	public void setCityCd(Integer cityCd) {
		this.cityCd = cityCd;
	}

	public Integer getTownCd() {
		return townCd;
	}

	public void setTownCd(Integer townCd) {
		this.townCd = townCd;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Integer getOfficeFlg() {
		return officeFlg;
	}

	public void setOfficeFlg(Integer officeFlg) {
		this.officeFlg = officeFlg;
	}

	public Integer getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(Integer deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getPrefName() {
		return prefName;
	}

	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	public String getPrefKana() {
		return prefKana;
	}

	public void setPrefKana(String prefKana) {
		this.prefKana = prefKana;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityKana() {
		return cityKana;
	}

	public void setCityKana(String cityKana) {
		this.cityKana = cityKana;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getTownKana() {
		return townKana;
	}

	public void setTownKana(String townKana) {
		this.townKana = townKana;
	}

	public String getTownMemo() {
		return townMemo;
	}

	public void setTownMemo(String townMemo) {
		this.townMemo = townMemo;
	}

	public String getKyotoStreet() {
		return kyotoStreet;
	}

	public void setKyotoStreet(String kyotoStreet) {
		this.kyotoStreet = kyotoStreet;
	}

	public String getAzaName() {
		return azaName;
	}

	public void setAzaName(String azaName) {
		this.azaName = azaName;
	}

	public String getAzaKana() {
		return azaKana;
	}

	public void setAzaKana(String azaKana) {
		this.azaKana = azaKana;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeKana() {
		return officeKana;
	}

	public void setOfficeKana(String officeKana) {
		this.officeKana = officeKana;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Integer getNewId() {
		return newId;
	}

	public void setNewId(Integer newId) {
		this.newId = newId;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
}
