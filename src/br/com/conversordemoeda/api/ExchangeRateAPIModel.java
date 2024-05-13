package br.com.conversordemoeda.api;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class ExchangeRateAPIModel{
	
	private String result;	
	private String documentation;
	private String terms_of_use;
	private String time_last_update_unix;
	private String time_last_update_utc;
	private String time_next_update_unix; 
	private String time_next_update_utc; 
	private String base_code;	
	private Object conversion_rates;	
	private String json;
	static final String[] ARR_BASE_CODE = { "", "USD", "ARS", "BRL", "COP" };
	

	public ExchangeRateAPIModel() {
		// TODO Auto-generated constructor stub
	}

	public ExchangeRateAPIModel(ExchangeRateAPIRegistro erar) {
		this.result = erar.result();
		this.documentation = erar.documentation();
		this.terms_of_use = erar.terms_of_use();
		this.time_last_update_unix = erar.time_last_update_unix();
		this.time_last_update_utc = erar.time_last_update_utc();
		this.time_next_update_unix = erar.time_next_update_unix();
		this.time_next_update_utc = erar.time_next_update_utc();
		this.base_code = erar.base_code();
		this.conversion_rates = erar.conversion_rates();			
	}
	
	
	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}	

	public String getDocumentation() {
		return documentation;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public String getTerms_of_use() {
		return terms_of_use;
	}

	public void setTerms_of_use(String terms_of_use) {
		this.terms_of_use = terms_of_use;
	}

	public String getTime_last_update_unix() {
		return time_last_update_unix;
	}

	public void setTime_last_update_unix(String time_last_update_unix) {
		this.time_last_update_unix = time_last_update_unix;
	}

	public String getTime_last_update_utc() {
		return time_last_update_utc;
	}

	public void setTime_last_update_utc(String time_last_update_utc) {
		this.time_last_update_utc = time_last_update_utc;
	}

	public String getTime_next_update_unix() {
		return time_next_update_unix;
	}

	public void setTime_next_update_unix(String time_next_update_unix) {
		this.time_next_update_unix = time_next_update_unix;
	}

	public String getTime_next_update_utc() {
		return time_next_update_utc;
	}

	public void setTime_next_update_utc(String time_next_update_utc) {
		this.time_next_update_utc = time_next_update_utc;
	}


	public String getBase_code() {
		return base_code;
	}

	public void setBase_code(String base_code) {
		this.base_code = base_code;
	}

	public Object getConversion_rates() {
		return conversion_rates;
	}

	public void setConversion_rates(Object conversion_rates) {
		this.conversion_rates = conversion_rates;
	}
	
	public String[] getARR_BASE_CODE() {
		return ARR_BASE_CODE;
	}

	public String getARR_BASE_CODE(int indexbase_code) {
		return ARR_BASE_CODE[indexbase_code];
	}
	
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
}
