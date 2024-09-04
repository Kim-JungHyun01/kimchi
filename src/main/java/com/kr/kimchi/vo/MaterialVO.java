package kr.co.kim.vo;

public class MaterialVO {
	
	private int ma_id;
	private String ma_name;
	private String ma_category;
	private int ma_price;
	private String ma_unit;
	private String ma_specifications;
	private int ma_StockQuantity;
	private int ma_AvailableStock;
	private int ma_BasicStock;
	private String ma_stock_value;
	private String ma_storage;
	private String ma_updateDate;
	private int attachment_no;
	
	public MaterialVO() {	}


	public int getMa_id() {
		return ma_id;
	}

	public void setMa_id(int ma_id) {
		this.ma_id = ma_id;
	}

	public String getMa_name() {
		return ma_name;
	}

	public void setMa_name(String ma_name) {
		this.ma_name = ma_name;
	}

	public String getMa_category() {
		return ma_category;
	}

	public void setMa_category(String ma_category) {
		this.ma_category = ma_category;
	}

	public int getMa_price() {
		return ma_price;
	}

	public void setMa_price(int ma_price) {
		this.ma_price = ma_price;
	}

	public String getMa_unit() {
		return ma_unit;
	}

	public void setMa_unit(String ma_unit) {
		this.ma_unit = ma_unit;
	}

	public String getMa_specifications() {
		return ma_specifications;
	}

	public void setMa_specifications(String ma_specifications) {
		this.ma_specifications = ma_specifications;
	}

	public int getMa_StockQuantity() {
		return ma_StockQuantity;
	}

	public void setMa_StockQuantity(int ma_StockQuantity) {
		this.ma_StockQuantity = ma_StockQuantity;
	}

	public int getMa_AvailableStock() {
		return ma_AvailableStock;
	}

	public void setMa_AvailableStock(int ma_AvailableStock) {
		this.ma_AvailableStock = ma_AvailableStock;
	}

	public int getMa_BasicStock() {
		return ma_BasicStock;
	}

	public void setMa_BasicStock(int ma_BasicStock) {
		this.ma_BasicStock = ma_BasicStock;
	}

	public String getMa_stock_value() {
		return ma_stock_value;
	}

	public void setMa_stock_value(String ma_stock_value) {
		this.ma_stock_value = ma_stock_value;
	}

	public String getMa_storage() {
		return ma_storage;
	}

	public void setMa_storage(String ma_storage) {
		this.ma_storage = ma_storage;
	}

	public String getMa_updateDate() {
		return ma_updateDate;
	}

	public void setMa_updateDate(String ma_updateDate) {
		this.ma_updateDate = ma_updateDate;
	}

	public int getAttachment_no() {
		return attachment_no;
	}

	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}

	@Override
	public String toString() {
		return "MaterialVO [ma_id=" + ma_id + ", ma_name=" + ma_name + ", ma_category=" + ma_category + ", ma_price="
				+ ma_price + ", ma_unit=" + ma_unit + ", ma_specifications=" + ma_specifications + ", ma_StockQuantity="
				+ ma_StockQuantity + ", ma_AvailableStock=" + ma_AvailableStock + ", ma_BasicStock=" + ma_BasicStock
				+ ", ma_stock_value=" + ma_stock_value + ", ma_storage=" + ma_storage + ", ma_updateDate="
				+ ma_updateDate + ", attachment_no=" + attachment_no + "]";
	}

}
