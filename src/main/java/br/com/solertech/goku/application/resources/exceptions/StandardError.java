package br.com.solertech.goku.application.resources.exceptions;

public class StandardError {

	private Long timestamp;
	private Integer status;
	private String Error;

	public StandardError() {
	}

	public StandardError(Long timestamp, Integer status, String error) {
		this.timestamp = timestamp;
		this.status = status;
		Error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		Error = error;
	}

}
