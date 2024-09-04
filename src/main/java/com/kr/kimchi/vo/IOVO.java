package kr.co.kim.vo;

public class IOVO {

	private int io_id;  
	private String io_status;  
	private String io_quantity;
	private String io_date; 
	private String io_information; 
	private String io_return_date; 
	private String invoice_issuance_status; 
	private int ma_id; 
	private int obtain_no;
	
	
	public IOVO() {
		super();
	}


	public int getIo_id() {
		return io_id;
	}


	public void setIo_id(int io_id) {
		this.io_id = io_id;
	}


	public String getIo_status() {
		return io_status;
	}


	public void setIo_status(String io_status) {
		this.io_status = io_status;
	}


	public String getIo_quantity() {
		return io_quantity;
	}


	public void setIo_quantity(String io_quantity) {
		this.io_quantity = io_quantity;
	}


	public String getIo_date() {
		return io_date;
	}


	public void setIo_date(String io_date) {
		this.io_date = io_date;
	}


	public String getIo_information() {
		return io_information;
	}


	public void setIo_information(String io_information) {
		this.io_information = io_information;
	}


	public String getIo_return_date() {
		return io_return_date;
	}


	public void setIo_return_date(String io_return_date) {
		this.io_return_date = io_return_date;
	}


	public String getInvoice_issuance_status() {
		return invoice_issuance_status;
	}


	public void setInvoice_issuance_status(String invoice_issuance_status) {
		this.invoice_issuance_status = invoice_issuance_status;
	}


	public int getMa_id() {
		return ma_id;
	}


	public void setMa_id(int ma_id) {
		this.ma_id = ma_id;
	}


	public int getObtain_no() {
		return obtain_no;
	}


	public void setObtain_no(int obtain_no) {
		this.obtain_no = obtain_no;
	}


	@Override
	public String toString() {
		return "IOVO [io_id=" + io_id + ", io_status=" + io_status + ", io_quantity=" + io_quantity + ", io_date="
				+ io_date + ", io_information=" + io_information + ", io_return_date=" + io_return_date
				+ ", invoice_issuance_status=" + invoice_issuance_status + ", ma_id=" + ma_id + ", obtain_no="
				+ obtain_no + "]";
	}
	
	
	
	
}
